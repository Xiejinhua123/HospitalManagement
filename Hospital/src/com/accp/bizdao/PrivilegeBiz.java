package com.accp.bizdao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Privilege;
import com.accp.demo.Roles;
import com.accp.demo.Users;

/**
 * 权限的业务处理层
 * @author 李伊昌
 */
public interface PrivilegeBiz {

	/**
	 * 添加权限信息<br/>
	 * 
	 * 非null验证，非null列验证<br/>
	 * 
	 * 添加返回添加的编号<br/>
	 * 
	 * 根据编号查询添加的对象<br/>
	 * 
	 * @param p
	 * 		封装的权限对象
	 * 
	 * @return
	 * 		添加成功返回对象，失败返回null
	 */
	public Privilege add(Privilege p) throws Exception;
	
	/**
	 * 删除权限信息<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * 在删除权限之前应该删除角色权限表中的相关当前对象的信息<br/>
	 * 
	 * 然后删除权限信息<br/>
	 * 
	 * @param pid
	 * 		前台勾选的多项权限信息
	 * 
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 */
	public Boolean del(List<Integer> pid) throws Exception;
	
	/**
	 * 普通的修改方法<br/>
	 * 
	 * 进行非null验证<br/>
	 * 
	 * @param p
	 * 		脏对象
	 * @return
	 * 		修改成功返回true，修改失败返回false
	 */
	public Privilege update(Privilege p)throws Exception;
	
	/**
	 * 该方法用来查询所有的权限信息<br/>
	 * 
	 * 其中该权限牵涉到回旋加载<br/>
	 * 
	 * 需要进行权限等级判断<br/>
	 * 
	 * 是几级的就单单查询几级的权限信息<br/>
	 * 
	 * 只要不是一级权限，就需要查询所有的一级权限信息<br/>
	 * 
	 * 用来生成树状图，表示出权限的整体结构<br/>
	 * 
	 * @param parentId
	 * 		父级权限编号
	 * 	
	 * @param displayOrder
	 * 		权限等级
	 * 
	 * @return
	 * 		权限的集合
	 */
	public List<Privilege> getAll(Integer parentId,Integer displayOrder) throws Exception;
	
	/**
	 * 根据权限的编号查询权限
	 * 
	 * @param priId
	 * 		权限编号
	 * 
	 * @return
	 * 		有则返回对象，没有则返回null
	 * @throws Exception
	 * 		有可能产生的异常
	 */
	public Privilege getById(Integer priId) throws Exception;

	/**
	 * 根据角色信息获取角色下的权限集合
	 * 
	 * @param r
	 * 		角色对象
	 * 
	 * @return
	 * 		权限集合
	 * @throws Exception 
	 */
	public List<Privilege> getAll(Roles r) throws Exception;
	
	/**
	 *根据给定的用户获取当前用户的所有的权限信息
	 *
	 * @param user
	 * 		给定的用户对象
	 * @return
	 * 		该用户对应的所以权限信息
	 * @throws Exception
	 * 		自定义异常
	 */
	public List<Privilege> getPriByUsers(Users user)throws Exception;
}
