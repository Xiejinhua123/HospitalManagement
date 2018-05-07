package com.accp.bizimpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.accp.bizdao.RoleBiz;
import com.accp.bizdao.RolePrivilegeBiz;
import com.accp.bizdao.UserRoleBiz;
import com.accp.dao.RoleDao;
import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.impl.RoleImpl;
import com.accp.util.Page;

public class RoleBizImpl implements RoleBiz {
	
	private Logger logger = Logger.getLogger(RoleBizImpl.class);
	private RoleDao roledao = new RoleImpl();
	Set<Users> set = new HashSet<>();
	@Override
	public Roles add(Roles r) throws Exception {
	
		if( null == r || r.getRolesId() != null ){
			logger.debug("添加角色信息失败，参数异常");
			throw new Exception(" roles add() parameter error ");
		}
		
		Object id = roledao.add(r);
		if( null == id )return null;
		else return getById((Integer) id);
	}
	@Override
	public Boolean del(List<Integer> ids) throws Exception {
		/**
		 * 删除角色信息，必须实现删除跟角色相关的信息
		 * 
		 * 解除绑定的权限信息
		 * 
		 * 解除用户绑定的角色信息
		 */
		
		if( null == ids || ids.size() == 0 ){
			logger.debug("删除角色信息失败，当前的参数为null");
			throw new Exception( "roles del parameter is null" );
		}
		RolePrivilegeBiz rpb = new RolePrivilegeBizImpl(); // 角色权限的操作对象
		UserRoleBiz urb = new UserRoleBizImpl(); // 用户角色的操作对象
		
		for (Integer id: ids) {
			
			Roles r = getById(id); // 获取当前编号对应的用户对象
			
			if( !rpb.roleDelPri(id) ){
				logger.debug("删除角色信息，解除绑定的权限失败");
				throw new Exception("role del() RolePrivilegeBiz del() be defeated");
			}		
			
			List<UserRole> ur = urb.getUsersByRoles(r); // 通过角色信息获取用户角色实体集合
			if( null != ur && ur.size() != 0 ){
				
				List<Integer> urids = new LinkedList<>(); // 参数集合
				for (UserRole urid : ur) {
					urids.add(urid.getUrid());
				}
				/*
				 * 解除绑定的用户角色，参数也是相对应的实体类的编号
				 */
				for (Integer ids1 : urids) {
					urb.usersDelRole(ids1.toString());
				}
				
			}
			
			if( !roledao.del(id) ){
				logger.debug("删除角色信息失败，执行过程中出现错误");
				throw new Exception("role del() exceute error");
			}
			
		}
		
		return true;
	}
	@Override
	public Roles update(Roles r) throws Exception {

		if( null == r || r.getRolesId() <= 0 ){
			logger.debug("修改角色信息失败，参数为null");
			throw new Exception("role update() parameter is null");
		}
		if( roledao.update(r) )return getById(r.getRolesId());
		else return null;
	}
	@Override
	public void getPage(Page<Roles> page, Roles r) throws Exception {

		if( null == page || null == page.getItems() || null == page.getPagesize()
				|| page.getItems() <= 0 || page.getPagesize() <= 0){
			logger.debug("分页获取角色信息失败，分页对象出错");
			throw new Exception("role getPage() parameter is error");
		}
		
		roledao.getPage(page,r);

	}
	@Override
	public Roles getById(Integer rid) throws Exception {

		if( null == rid || rid <= 0 ){
			logger.debug("根据编号查询角色信息失败，参数为null");
			throw new Exception("role getById() parameter is null");
		}
		Roles r = new Roles();
		r.setRolesId(rid);
		List<Roles> list = getByColumn(r);
		if( null == list || list.size() == 0 )return null;
		else return list.get(0);
	}
	@Override
	public List<Roles> getByColumn(Roles r) {
		return roledao.getByColumn(r);
	}

	@Override
	public List<Roles> getByUserId(Users u) throws Exception {
		if( null == u ){
			logger.debug("根据用户获取当前用户的角色失败");
			throw new Exception("role getByUser() parameter is null");
		}
		UserRoleBiz urb = new UserRoleBizImpl();
		List<UserRole> list = urb.getRoleByUsers(u); // 用户角色集合
		List<Roles> rolelist = new LinkedList<Roles>(); // 角色集合
		for (UserRole r : list) {			
			rolelist.add(r.getRoles());			
		}
		return rolelist;
	}
	@Override
	public List<Roles> getAll() throws Exception {
		List<Roles>list=null;
		list=roledao.getByColumn(null);
		return list;
	}


}
