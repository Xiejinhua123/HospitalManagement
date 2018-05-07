package com.accp.bizdao;

import java.util.List;
import com.accp.demo.Roles;
import com.accp.demo.Users;
import com.accp.util.Page;

/**
 * 角色信息业务处理
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.04.22
 *
 */
public interface RoleBiz {
	/**
	 * 添加角色信息<br/>
	 * 
	 * 事务管理<br/>
	 * 
	 * 在添加之前应该确定当前角色名称在数据库中是会否已经存在，如果存在，不允许添加<br/>
	 * 
	 * @param r
	 * 		分装的角色信息 
	 * @param list
	 * 		这是权限编号，需要判断，是否为null
	 * 		如果不为null，需要一并连权限信息添加
	 * 
	 * @return
	 * 		事务提交返回对象，事务回滚返回null
	 * @throws Exception 
	 */
	public Roles add(Roles r) throws Exception;
	
	/**
	 * 删除角色（不常用）<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * 再删除角色之前需要先删除角色权限表中<br/>
	 * 
	 * 关于当前角色的所有信息<br/>
	 * 
	 * @param id
	 * 		角色编号
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 * @throws Exception 
	 */
	public Boolean del(List<Integer> id) throws Exception;
	
	
	
	/**
	 * 修改角色信息<br/>
	 *
	 * 每次修改需要修改“最后一次修改时间” 一列<br/>
	 * 
	 * @param r
	 * @return
	 * @throws Exception 
	 */
	public Roles update(Roles r) throws Exception;
	
	/**
	 * 分页查询所有的角色信息
	 * 
	 * @param page
	 * 		属性不完整的page信息
	 * @param r
	 * 		动态条件查询构成的对象
	 * @return
	 * 		属性值完整的page对象
	 * @throws Exception 
	 */
	public void getPage(Page<Roles> page,Roles r) throws Exception;
	
	/**
	 * 根据角色编号查询角色具体信息<br/>
	 * 
	 * @param rid
	 * 		角色编号
	 * @return
	 * 		如果存在返回对象，如果不存在返null
	 * @throws Exception 
	 */
	public Roles getById(Integer rid) throws Exception;
	
	/**
	 * 获取所有的角色信息
	 * @return
	 */
	public List<Roles> getByColumn(Roles r) throws Exception;

	/**
	 * 根据用户对象获取当前用户的角色信息
	 * @param u
	 * 		用户对象
	 * @return
	 * 		角色集合
	 */
	public List<Roles> getByUserId(Users u) throws Exception;
	/***
	 * 
	 * @return
	 */
	public List<Roles>getAll()throws Exception;
}
