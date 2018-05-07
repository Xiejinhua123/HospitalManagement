package com.accp.dao;

import java.util.List;

import com.accp.demo.Privilege;
import com.accp.demo.RolePrivilege;
import com.accp.demo.Roles;

public interface RolePrivilegeDao extends CommonInterface{

	/**
	 * 通过角色信息获取当前的绑定集合
	 * 
	 * @param r
	 * 		角色对象
	 * @return
	 * 		绑定的集合，有则返回集合  没有返回对象
	 */
	List<RolePrivilege> getByRole(Roles r);

	/**
	 * 通过权限信息获取绑定信息
	 * 
	 * @param p
	 * 		权限对象
	 * @return
	 * 		绑定集合，有则返回集合，没有返回null
	 */
	List<RolePrivilege> getByPriilege(Privilege p);

	/**
	 * 通过角色和权限获取唯一的绑定信息
	 * 
	 * @param r
	 * 		角色对象
	 * @param p
	 * 		权限对象
	 * @return
	 * 		唯一对象
	 */
	RolePrivilege getByRolePrivilege(Roles r, Privilege p);

	/**
	 * 通过编号查询唯一绑定信息
	 * 
	 * @param id
	 * 		用户编号
	 * @return
	 * 		有则返回对象，没有返回null
	 */
	RolePrivilege getById(Integer id);

}
