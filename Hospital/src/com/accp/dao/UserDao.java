package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Department;
import com.accp.demo.Roles;
import com.accp.demo.Users;
import com.accp.util.Page;

public interface UserDao extends CommonInterface {
	
	/**
	 * 通过某列查寻对象
	 * 
	 * @param u
	 * 		
	 * 
	 * @return
	 * 		有就返回对象，没有返回null
	 */
	List<Users> getByColumn(Users u);
	
	/**
	 * 执行分页
	 * 
	 * @param page
	 * 		分页的对象
	 * 
	 * @param sql
	 * 		分页生成的sql语句
	 * 
	 * @param map
	 * 		这是需要匹配的参数名和参数的值
	 */
	void getPage(Page page,String sql,Map<String, Object> map);

	/**
	 * 根据用户查询用户的角色
	 * 
	 * @param u
	 * 		用户
	 * 
	 * @return
	 * 		有为集合，没有为null
	 */
	List<Roles> getRoleByUser(Users u);

	/**
	 * 根据用户的科室查询用户
	 * 
	 * @param dep
	 *		科室对象 
	 * @return
	 * 		用户集合
	 */
	List<Users> getByDep(Department dep);

}
