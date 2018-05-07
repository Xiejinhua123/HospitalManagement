package com.accp.bizimpl;

import java.util.List;


import org.apache.log4j.Logger;

import com.accp.bizdao.PrivilegeBiz;
import com.accp.bizdao.RoleBiz;

import com.accp.bizdao.RolePrivilegeBiz;
import com.accp.dao.RolePrivilegeDao;
import com.accp.demo.Privilege;
import com.accp.demo.RolePrivilege;
import com.accp.demo.Roles;
import com.accp.impl.RolePrivilegeImpl;

/**
 * 角色权限的处理
 * @author Administrator
 */
public class RolePrivilegeBizImpl implements RolePrivilegeBiz {

	
	private Logger logger = Logger.getLogger(RolePrivilegeBizImpl.class);
	private RolePrivilegeDao rpd = new RolePrivilegeImpl();

	@Override
	public boolean roleAddPri(Integer rolid, List<Integer> list) throws Exception {

		if( null == rolid || null == list || list.size() <= 0 ){
			logger.debug("为角色绑定权限失败，参数为null");
			throw new Exception("rolesprivilege add() parameter is null");
		} 
		RoleBiz roleBiz = new RoleBizImpl();
		PrivilegeBiz privilegeBiz = new PrivilegeBizImpl();
		
		Roles roles = roleBiz.getById(rolid);
		Privilege p = null;
		RolePrivilege rolePrivilege = new RolePrivilege();
		for (Integer priId : list) {
			
			//权限对象
			p = null;
			p = privilegeBiz.getById(priId); // 获取权限对象
			
			//设置当前对象为null对象
			rolePrivilege.setRoles(null);
			rolePrivilege.setPrivilege(null);
			
			//为添加对象设置添加的值
			rolePrivilege.setRoles(roles);
			rolePrivilege.setPrivilege(p);
			
			RolePrivilege rp = getByRolePrivilege(roles, p);
			if( null == rp ){
				Object id = rpd.add(rolePrivilege); // 执行数据库添加
				if( null == id || (Integer)id <= 0 ){
					logger.debug("绑定权限信息出错，执行失败");
					throw new Exception("roleprivilege add() exceute error");
				}
			}else{
				logger.debug("为角色绑定权限失败，当前角色已经有该项权限");
				throw new Exception("rolesprivilege add() execure be defeated");
			}
		}
		

		return true;
	}
	@Override
	public Boolean roleDelPri(Integer rolid, List<Integer> priId) throws Exception {
		if(  null == rolid || rolid <= 0 || null == priId || priId.size() <= 0 ){
			logger.debug("删除用户全部权限信息失败，参数为null");
			throw new Exception("roleprivilege delAll() parameter is null");
		}
		/**
		 * 一、获取角色对象
		 * 
		 * 二、循环权限对象
		 * 
		 * 三、通过角色和权限获取绑定信息
		 * 
		 * 四、通过获取到的绑定信息，获取编号
		 * 
		 * 五、删除
		 */
		
		RoleBiz roleBiz = new RoleBizImpl();
		PrivilegeBiz privilegeBiz = new PrivilegeBizImpl();
		
		Roles roles = roleBiz.getById(rolid); // 获取角色对象
		Privilege p = null;
		RolePrivilege rp = null;
		for (Integer priid : priId) { // 循环权限集合
			
			p = null;
			p = privilegeBiz.getById(priid); // 获取权限对象
 			
			rp = null;
			rp = getByRolePrivilege(roles, p); // 获取绑定对象
			
			if( !rpd.del(rp.getRpid()) ){
				logger.debug("在解除部分绑定的时候，执行出现错误");
				throw new Exception("roleprivilege del() exceute error");
			}
		}
		
		return true;
	}
	@Override
	public Boolean roleDelPri(Integer rolid) throws Exception {
		if(  null == rolid || rolid <= 0 ){
			logger.debug("删除用户全部权限信息失败，参数为null");
			throw new Exception("roleprivilege delAll() parameter is null");
		}
		RoleBiz roleBiz = new RoleBizImpl();
		
		Roles roles = roleBiz.getById(rolid); // 获取角色对象
		//通过当前的角色对象，获取所有的绑定信息
		List<RolePrivilege> roleprivileges = getByRole(roles); 
		for (RolePrivilege rp : roleprivileges) {
			if( !rpd.del(rp.getRpid()) ){
				logger.debug("解除绑定的角色权限信息的时候失败");
				throw new Exception("roleprivilege delAll() exceute error");
			}
		}
		return true;
	}
	@Override
	public Boolean updatePri(Integer rolid, List<Integer> priId) throws Exception {

		/**
		 * 修改的时候实事先删除数据库中所有的信息
		 * 
		 * 然后重新添加当前的权限信息
		 */
		
		if( null == rolid || null == priId || priId.size() <= 0 ){
			logger.debug("修改角色权限信息失败，参数为null");
			throw new Exception("roleprivilege update() parameter is null");
		}
		
		roleDelPri(rolid);
		roleAddPri(rolid, priId);
		
		return true;
	}
	@Override
	public List<RolePrivilege> getByRole(Roles r) throws Exception {
		if( null == r || null == r.getRolesId() || r.getRolesId() <= 0){
			logger.debug("通过角色获取绑定信息失败，参数为null");
			throw new Exception("roleprivilege getByRole() parameter is null");
		}
		
		List<RolePrivilege> list = rpd.getByRole(r);
		if( null == list || list.size() <= 0 )return null;
		else return list;
	}
	@Override
	public List<RolePrivilege> getByPriilege(Privilege p) throws Exception {
		if( null == p || null == p.getPriId() || p.getPriId() <= 0){
			logger.debug("通过权限获取绑定信息失败，参数为null");
			throw new Exception("roleprivilege getByPriilege() parameter is null");
		}
		
		List<RolePrivilege> list = rpd.getByPriilege(p);
		
		if( null == list || list.size() <= 0 )return null;
		else return list;
	}
	@Override
	public RolePrivilege getByRolePrivilege(Roles r, Privilege p) throws Exception {

		if( null == r || null == p ){
			logger.debug("通过给定的角色和权限查询失败，参数为null");
			throw new Exception("roleprivilege get");
		}
		
		RolePrivilege list = rpd.getByRolePrivilege(r,p);
		
		if( null == list)return null;
		else return list;
	}
	@Override
	public RolePrivilege getById(Integer id) throws Exception {
		
		if( null == id || id <= 0 ){
			logger.debug("通过编号查询绑定信息失败，参数为null");
			throw new Exception("roleprivilege getById() parameter is null");
		}
		
		RolePrivilege r = rpd.getById(id);
		return r;
	}
	
}
