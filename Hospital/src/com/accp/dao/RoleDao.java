package com.accp.dao;

import java.util.List;

import com.accp.demo.Roles;
import com.accp.util.Page;

/**
 * 角色信息的业务处理
 * @author 解金化
 *
 */
public interface RoleDao extends CommonInterface{

	/**
	 * 分页查询角色信息
	 * 
	 * @param page
	 * 		分页对象
	 * @param r
	 * 		动态查询条件构成的对象
	 */
	void getPage(Page<Roles> page, Roles r);

	/**
	 * 动态查询
	 * 
	 * @param r
	 * 		动态条件构成的对象
	 * @return
	 * 		有则返回集合  没有返回null
	 */
	List<Roles> getByColumn(Roles r);

}
