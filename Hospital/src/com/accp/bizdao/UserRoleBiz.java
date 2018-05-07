package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;

/**
 * 用户角色业务处理
 * 
 * @author xueshe01
 *
 */
public interface UserRoleBiz {
	
	/**
	 * 为当前用户添加角色<br/>
	 * 
	 * 在前台应该做出判断，已经有的角色不允许当前用户进行添加，不能添加重复的角色信息<br/>
	 * 
	 * @param list
	 * 		一个用户可以有多个角色，角色编号集合，循环添加
	 * @param UsersId
	 * 		用户的编号
	 * @return
	 */
	public Boolean usersAddRoles(String usersId,  List<Integer> list)throws Exception;
	
	/**
	 * 修改用户的角色信息<br/>
	 *
	 * 在修改角色信息的时候,不能肯定在数据库中当前用户的角色列表是否已经存在需要修改的角色信息<br/>
	 * 所以就在修改之前将当前的用户的角色信息全部删除，重新将当前的角色添加<br/>
	 * 
	 * @param list
	 * @return
	 * @throws Exception 
	 */
	public Boolean usersUpateRoles(String usersId,List<Integer> list) throws Exception;
	
	/**
	 * 删除角色绑定的角色信息<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * 要求同上<br/>
	 * 
	 * @param UsersId
	 * 		当前的用户编号
	 * @param RolesId
	 * 		勾选的多项角色编号
	 * 
	 * @return
	 * 		事务提交返回true ， 事务回滚返回false
	 * @throws Exception 
	 */
	public Boolean usersDelRole(String usersId,List<Integer> list) throws Exception;
	
	/**
	 * 解除所有方法
	 * 
	 * @param usersId
	 * 	用户编号
	 * @return
	 * 		成功失败
	 * @throws Exception
	 */
	public Boolean usersDelRole(String usersId) throws Exception;
	
	/**
	 * 通过用户获取角色信息
	 * 
	 * @param u
	 * 		用户对象
	 * @return
	 * 		角色集合
	 * @throws Exception
	 */
	public List<UserRole> getRoleByUsers( Users u ) throws Exception;

	/**
	 * 通过角色获取用户
	 * 
	 * @param r
	 * 		角色对象
	 * 
	 * @return
	 * 		用户集合
	 * @throws Exception
	 */
	public List<UserRole> getUsersByRoles(Roles r) throws Exception;
	
	/**
	 * 通过用户和角色信息，获取用户角色编号信息
	 * @param u
	 * 		用户对象
	 * @param r
	 * 		角色对象
	 * @return
	 * 		用户角色信息
	 * @throws Exception
	 */
	public UserRole getId(Users u , Roles r) throws Exception;
}
