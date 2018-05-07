package com.accp.bizdao;

import java.sql.SQLException;
import java.util.List;

import com.accp.demo.Department;
import com.accp.demo.Users;
import com.accp.json.UserJson;
import com.accp.util.Page;
/**
 * 用户表的业务处理
 * 
 * @author 解金化
 * 
 * @version 1.0
 *
 *	@datetiem 2017.04.20
 */
public interface UserBiz {
	
	/**
	 * 执行用户登录
	 * 
	 * @param name
	 * 		用户名
	 * 
	 * @param pwd
	 * 		密码
	 * 
	 * @return
	 * 		返回一个登录后的对象
	 * @throws Exception 
	 */
	public Users usersLogin(String name,String pwd) throws Exception;
	
	/**
	 * 添加用户信息<br/>
	 * 
	 * 其中用户编号程序工具类生成<br/>
	 * 
	 * 生成后进行数据库验证，当前生成的编号是否已经存在<br/>
	 * 
	 * 如果存在继续生成，直到不存在为止<br/>
	 * 
	 * 添加<br/>
	 * 
	 * 通过编号查询到当前实例，用来返回<br/>
	 * 
	 * 在添加的同时对doctor表同时添加信息<br/>
	 * 
	 * @param Users
	 * 		用户实例
	 * @param list
	 * 		这是角色编号， 
	 * 		判断是否为null
	 * 		如果不是，为当前用户绑定角色
	 * 
	 * @return
	 * 		添加成功返回对象，失败返回null
	 * 
	 * @throws NullPointerException
	 * 		空指针异常
	 * 
	 * @throws SQLException
	 * 		sql异常
	 */
	public Users usersAdd(Users Users,List<Integer> list) throws Exception;
		
	/**
	 * 删除（一般不会执行删除操作）<br/>
	 * 
	 * 启用事务<br/>
	 * 删除前应该通过用户的编号查询到当前用户的角色，<br/>
	 * 如果是医生，同样将医生表中的相关信息删除<br/>
	 * 
	 * 事先应该删除用户角色表中的所有信息<br/>
	 * 
	 * @param list
	 * 		前台提供多个勾选
	 * 
	 * @return
	 * 		事务提交返回true，事务提交失败返回false
	 * @throws Exception 
	 */
	public Boolean del(List<String> id) throws Exception;
	
	/**
	 * 修改信息<br/>
	 * 
	 * 事务<br/>
	 * 
	 * 在修改信息之前应该通过对象编号在数据库中查询数据库中的数据，<br/>
	 * 
	 * 判断修改的是什么<br/>
	 * 
	 * 修改信息后，应该修改当前用户的最后修改时间<br/>
	 * 
	 * @param u
	 * 		脏对象
	 * @return
	 * 		事务提交，返回true,事务回滚，提交false
	 * @throws Exception 
	 */
	public Boolean update(Users u) throws Exception;
	
	/**
	 * 根据用户的编号查询用户<br/>
	 * 
	 * @param id
	 * 		用户编号
	 * @return
	 * 		有则返回对象，没有则返回null
	 * @throws Exception 
	 */
	public Users getById(String id) throws Exception;
	
	/**
	 * 分页查询<br/>
	 * 
	 * @param page
	 * 		属性不完整的page对象
	 * @param map
	 * 		不确定的查询条件，比如：根据角色，根据时间。。。。
	 * @return
	 * 		属性值完整的page对象
	 */
	@SuppressWarnings("rawtypes")
	Page<Users> getPage(Page page,Users u) throws Exception;
	
	/**
	 * 通过列查询对象
	 * 
	 * @param u
	 * 		带有参数的对象——带有值得列组成的对象<br/>
	 * 		该对象含有查询条件信息
	 * @return
	 * 		查询到的对象集合
	 * @throws Exception 
	 */
	public List<Users> getByColumn(Users u) throws Exception;
	
	/**
	 * 通过用户所在的部门查询在线用户
	 * 
	 * @param dep
	 * 		部门对象
	 * @returns u
	 * 		用户集合
	 * @throws Exception
	 */
	public List<Users> getByDep(Department dep,Users u) throws Exception;
	
	/**
	 * 通过用户所在的部门查询在线用户
	 * 
	 * @param dep
	 * 		部门对象
	 * @returns u
	 * 		用户集合
	 * @throws Exception
	 */
	public List<UserJson> getByDep(Department dep) throws Exception;

}
