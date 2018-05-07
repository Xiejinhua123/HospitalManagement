package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Department;
import com.accp.util.Page;

public interface DepartmenBiz {
	/**
	 * 添加科室信息<br/>
	 * 
	 * 解析科室对象<br/>
	 * 
	 * 进行非null验证，抛出异常<br/>
	 * 
	 * 添加方法返回值为当前添加的信息的自增编号<br/>
	 * 
	 * 通过自增编号重新查询当前信息<br/>
	 * 
	 * 将查询对象返回<br/>
	 * 
	 * @param department
	 *            封装的科室信息
	 * 
	 * @return 添加后的科室信息
	 */
	public Department add(Department department) throws Exception;

	/**
	 * 删除科室的信息，根据科室编号<br/>
	 * 
	 * 在前台提供多个勾选，在本业务层进行循环删除操作<br/>
	 * 
	 * 启动线程保护正在删除操作的科室对象（能做就做，不能就不用）<br/>
	 * 
	 * 创建事务，进行循环操作，保证数据安全，保证全部操作成功或者失败<br/>
	 * 
	 * @param list
	 *            前台数据，需要删除的对象的编号集合
	 * 
	 * @return 事务正常提交返回true，事务回滚返回false
	 */
	public Boolean del(List<Integer> list) throws Exception;

	/**
	 * 修改科室信息 非null验证，并且验证数据库中的非null列，验证信息抛出异常<br/>
	 * 
	 * 修改数据库<br/>
	 * 
	 * 根据当前对象的编号重新查询，不能直接返回当前对象，有可能出现数据冗余 出现夯重代码<br/>
	 * 
	 * 接收返回的对象并返回<br/>
	 * 
	 * @param department
	 *            需要修改的科室信息的封装对象
	 * 
	 * @return 修改后的科室信息对象
	 */
	public Department update(Department department) throws Exception;

	/**
	 * 分页形式查询科室信息<br/>
	 * 
	 * 参数是一个在servlet中封装好的page对象<br/>
	 * 
	 * 但是page对象中的属性并不完整<br/>
	 * 
	 * 剩余页面内容的集合需要在当前类进行完善 即page.setList();<br/>
	 * 
	 * 最后将完整属性的当前对象返回给servlet中<br/>
	 * 
	 * 在此期间不要new对象，加速内存的开销<br/>
	 * 
	 * @param page
	 *            属性不完整的page对象
	 * 
	 * @return 完整属性的page对象
	 * @throws Exception 
	 */
	public void getPage(Page<Department> page,Department department) throws Exception;

	/**
	 * 根据提供的对象中的条件信息查询<br/>
	 * 
	 * 需要根据什么查询就把值放入对象即可<br/>
	 * 
	 * 后台进行处理
	 * 
	 * @param d
	 * 		附带有条件的对象
	 * 
	 * @return
	 * 		有则集合，没有则null
	 */
	public List<Department> getByColomn(Department d) throws Exception;
	
	/**
	 * 根据给定的科室编号查询科室
	 * 
	 * @param depId
	 * 		科室编号
	 * 
	 * @return
	 * 		有返回对象，没有返回null
	 * 
	 * @throws Exception
	 * 		有可能发生的异常
	 */
	Department getById(Integer depId) throws Exception;
	
	/**
	 * 获取所有的科室信息
	 * 
	 * @param d
	 * 		含有动态条件的对象
	 * 
	 * @return
	 * 		集合
	 * 	
	 * @throws Exception
	 * 		有可能的异常信息
	 * 	
	 */
	public List<Department> getAll(Department d) throws Exception;

}
