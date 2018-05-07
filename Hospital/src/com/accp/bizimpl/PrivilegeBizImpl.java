package com.accp.bizimpl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.PrivilegeBiz;
import com.accp.bizdao.RolePrivilegeBiz;
import com.accp.dao.PrivilegeDao;
import com.accp.demo.Privilege;
import com.accp.demo.RolePrivilege;
import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.impl.PrivilegeImpl;

/**
 * 权限表业务处理
 * @author xueshe01
 *
 */
public class PrivilegeBizImpl implements PrivilegeBiz {

	private Logger logger = Logger.getLogger(PrivilegeBizImpl.class);	
	private PrivilegeDao pd = new PrivilegeImpl();
	
	@Override
	public Privilege add(Privilege p) throws Exception {
		
		if( null == p ){
			logger.debug("添加权限出错，参数为null");
			throw new Exception("Privilege add() paramter is null");
		}
		
		Object pid = pd.add(p);
		if( null == pid )return null;
		else{
			return getById((Integer) pid);
		}
	}

	@Override
	public Boolean del(List<Integer> pid) throws Exception {
		
		if( null == pid || pid.size() == 0 ){
			logger.debug("删除权限信息失败，参数为null");
			throw new Exception("Privilege del() parameter is null");
		}
		
		/*
		 * 再删除的时候，首先应该删除所有的角色权限表中的相关信息
		 */
		RolePrivilegeBiz rolePrivilegeBiz = new RolePrivilegeBizImpl(); // 角色权限
		int i = 0;
		int pcount = pid.size();
		for (Integer id : pid) { // 循环需要删除的权限编号
			
			Privilege p = getById(id); // 获取权限对象
			
			if( null == p ){
				logger.debug("删除失败，其中有权限信息不再数据库中");
				throw new Exception("Privilege del() error: Privilege Could not find");
			}
			
			/**
			 * 解除角色权限绑定
			 */
			List<RolePrivilege> list = rolePrivilegeBiz.getByPriilege(p); // 通过权限获取角色权限集合
			for (RolePrivilege rp : list) {
				rolePrivilegeBiz.roleDelPri(rp.getRpid()); // 解除绑定
			}
		
			try{
				
			}catch(Exception e){}
			if( pd.del(id) )i++;
			else{
				logger.debug("删除权限失败，某个权限删除失败");
				throw new Exception("Privilege del() Some delete failure");
			}
		}
		if( i == pcount )return true;
		else{
			logger.debug("删除权限失败，并没有全部删除给定的权限信息");
			throw new Exception("Privilege del() not delete all of them");
		}
	}

	@Override
	public Privilege update(Privilege p) throws Exception {
		
		if( null == p || null == p.getPriId() || p.getPriId() == 0 ){
			logger.debug("修改权限失败，当前参数异常");
			throw new Exception("privilegeBizImpl update() parameter is error");
		}
		
		if( pd.update(p) ) return getById(p.getPriId());
		else return null;
	}

	@Override
	public List<Privilege> getAll(Integer parentId, Integer displayOrder) throws Exception {
		
		Privilege p = new Privilege();
		
		/**
		 * 如果父级编号不为null<br/>
		 * 
		 * 查询的是当前父级的自子权限<br/>
		 * 
		 * 是二级权限
		 */
		if( null != parentId ){
			p.setDisplayOrder(2);
			p.setParentId(parentId);
		}		
		/*
		 * 如果权限等级不为null<br/>
		 * 
		 * 查询当前等级权限<br/>
		 * 
		 * 否则查询的是一级权限没有父级
		 */
		else if( null != displayOrder )p.setDisplayOrder(displayOrder); 
		/**
		 * 全都为null<br/>
		 * 
		 * 查询的是全部一级权限
		 */
		else p.setDisplayOrder(1);
		
		List<Privilege> list = pd.getByColumn(p);
		
		if( null == list || list.size() == 0 ) return null;
		else return list;
	}

	@Override
	public Privilege getById(Integer priId) throws Exception {
		if( null == priId || priId == 0 ){
			logger.debug("通过编号查询权限信息失败");
			throw new Exception("Privilege getById() parameter is null");
		}
		
		Privilege p = new Privilege();
		p.setPriId(priId);
		List<Privilege> list = pd.getByColumn(p);
		if( null == list || list.size() == 0 ) return null;
		else return list.get(0);
	}

	@Override
	public List<Privilege> getAll(Roles r) throws Exception {
		
		if( null == r ){
			logger.debug("通过角色查询权限失败，参数为null");
			throw new Exception("getPriByRol() parameter is null");
		}
		List<RolePrivilege> list = new RolePrivilegeBizImpl().getByRole(r);
		List<Privilege> priList = new LinkedList<Privilege>(); // 接收当前角色的权限信息
		for (RolePrivilege rp : list) {
			priList.add(rp.getPrivilege());
		}
		return priList;
	}

	@Override
	public List<Privilege> getPriByUsers(Users user) throws Exception {
		
		if( null == user ){
			logger.debug("通过用户获取用户的权限失败");
			throw new Exception("getPriByUsers() parameter is null");
		}
		
		List<UserRole> roleLst = new UserRoleBizImpl().getRoleByUsers(user);
		List<Roles> list = new LinkedList<>();
		for (UserRole userRole : roleLst) {
			list.add(userRole.getRoles());
		}
		List<Privilege> priList = new LinkedList<Privilege>();
		for (Roles roles : list) { // 获取当前用户的角色信息，并且循环角色获取权限
			
			priList.addAll( getAll(roles) );
			
		}
		List<Privilege> renList = new LinkedList<>();
		for (Privilege pri : priList) {
			Privilege p = new Privilege();
			p.setDisplayOrder(pri.getDisplayOrder());
			if( pri.getEnableds() == 0 )continue;
			p.setEnableds( pri.getEnableds() );
			p.setMenuPic(pri.getMenuPic());
			p.setMenuUrl(pri.getMenuUrl());
			p.setParentId(pri.getParentId());
			p.setPriId(pri.getPriId());
			p.setPriName(pri.getPriName());
			renList.add(p);
		}
		return renList;
	}

}
