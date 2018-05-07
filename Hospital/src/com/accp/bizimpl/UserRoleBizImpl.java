package com.accp.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.RoleBiz;
import com.accp.bizdao.UserBiz;
import com.accp.bizdao.UserRoleBiz;
import com.accp.dao.UserRoleDao;
import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.impl.UserRoleImpl;

public class UserRoleBizImpl implements UserRoleBiz {
	
	private Logger logger = Logger.getLogger(UserRoleBizImpl.class);
	private UserRoleDao urd = new UserRoleImpl();
	private UserBiz ub = new UserBizImpl();
	
	@Override
	public Boolean usersAddRoles(String usersId, List<Integer> list) throws Exception {
		
		if( null == usersId || null == list || list.size() != 0 || usersId.length() != 12){
			logger.debug("为用户绑定角色的时候，参数出现异常情况");
			throw new Exception("UsersAddRole() parameter is error");
		}
		
		Users users = ub.getById(usersId); // 获取用户
		if( null == users ){
			logger.debug("绑定角色，用户没有找到");
			throw new Exception("UsersAddRole() They didn't find the Users");
		}
		//添加方法
		/**
		 * 为用户绑定角色信息
		 * 
		 * 需要利用用户编号查询用户
		 * 
		 * 利用角色编号获得角色实体
		 * 
		 * 创建对象，数据库添加
		 */
		UserRole ur = null; // 用户角色对象
		RoleBiz rb = new RoleBizImpl();
		for (Integer rid : list) {
			ur = new UserRole();
			ur.setUsers(users);
			ur.setRoles(rb.getById(rid));
			Object id = urd.add(ur);
			if( null == id || (int)id <= 0 ){
				logger.debug("用户绑定角色失败，数据路执行失败");
				throw new Exception("userrole add() error exceute error");
			}
		}
		return true;
	}

	@Override
	public Boolean usersUpateRoles(String usersId, List<Integer> list) throws Exception {
		
		if( null == usersId || usersId.length() != 0 || null == list || list.size() == 0 ){
			logger.debug("修改绑定角色失败，参数为null");
			throw new Exception("userrole update() parameter is null");
		}
		if( usersDelRole(usersId) ){
			if( usersAddRoles(usersId,list) )return true;
			else return false;
		}else return false;
	}
	
	@Override
	public Boolean usersDelRole(String usersId,List<Integer> roleIds) throws Exception {

		if( null == usersId || null == roleIds || roleIds.size() != 0 || usersId.length() != 12){
			logger.debug("删除用户角色的时候，参数出现异常情况");
			throw new Exception("UsersDelRole() parameter is error");
		}
		
		Users users = ub.getById(usersId); // 获取当前的用户
		if( null == users ){
			logger.debug("删除用户角色，用户没有找到");
			throw new Exception("UsersAddRole() They didn't find the Users");
		}
		
		RoleBiz rb = new RoleBizImpl();
		for (Integer rid : roleIds) { // 删除当前的角色信息
			Roles r = rb.getById(rid); // 获取角色信息
			UserRole ur = getId(users,r); // 获取用户角色
			if( !urd.del(ur.getUrid()) ){
				logger.debug("删除用户角色信息失败，执行失败");
				throw new Exception("userrole del() exceute error");
			}
		}
		
		return true;
	}

	@Override
	public List<UserRole> getRoleByUsers(Users u) throws Exception {
		if( null == u || null == u.getUsersId()){
			logger.debug("通过角色获取用户角色信息失败");
			throw new Exception("userrole getUsersByRole() parameter is null");
		}
		List<UserRole> list = urd.getRoleByUsers(u);
		return list;
	}

	@Override
	public List<UserRole> getUsersByRoles(Roles r) throws Exception {
		if( null == r || null == r.getRolesId() ){
			logger.debug("通过角色获取用户角色信息失败");
			throw new Exception("userrole getUsersByRole() parameter is null");
		}
		List<UserRole> list = urd.getByRoles(r);
		return list;
	}

	@Override
	public Boolean usersDelRole(String usersId) throws Exception {
		
		if( null == usersId || usersId.length() != 12 ){
			logger.debug("解除当前用户的所有绑定角色失败，参数为null");
			throw new Exception("userrole delAll() parameter is null");
		}
		
		List<UserRole> list = getRoleByUsers(new UserBizImpl().getById(usersId)); // 通过用户编号获取用户角色集合
		for (UserRole ur : list) {
			if( !urd.del(ur.getUrid()) ){
				logger.debug("删除用户角色信息失败");
				throw new Exception("userrole delAll() exceute error");
			}
		}
		
		return true;
	}

	@Override
	public UserRole getId(Users u, Roles r) throws Exception {
		if( null == u || null == r ){
			logger.debug("通过用户和角色获取对象失败，某个参数为null");
			throw new Exception("userRole getId() parameter is null");
		}
		UserRole ur = urd.getId(u,r);
		return ur;
	}


}
