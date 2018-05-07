package com.accp.dao;

import java.util.List;

import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;

public interface UserRoleDao extends CommonInterface{

	/**
	 * 根据提供的角色信息，查询用户角色绑定信息
	 * 
	 * @param r
	 * 		角色信息
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<UserRole> getByRoles(Roles r);

	/**
	 * 根据用户和角色信息，查询当前的绑定信息
	 * 
	 * @param u
	 * 		用户对象
	 * 
	 * @param r
	 * 		角色对象
	 * ·
	 * @return
	 * 		绑定的唯一值信息
	 */
	UserRole getId(Users u, Roles r);

	/**
	 * 根据提供的用户信息查询当前用户绑定的角色信息
	 * 
	 * @param u
	 * 		用户信息
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<UserRole> getRoleByUsers(Users u);


}
