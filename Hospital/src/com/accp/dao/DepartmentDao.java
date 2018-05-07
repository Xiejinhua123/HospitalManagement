package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Department;
import com.accp.util.Page;

public interface DepartmentDao extends CommonInterface {

	/**
	 * 执行分页
	 * 
	 * @param page
	 * 		分页对象
	 * 
	 * @param department
	 * 		有可能出现的动态条件
	 */
	void getPage(Page<Department> page, Department d) throws Exception;

	/**
	 * 动态查询
	 * 
	 * @param d
	 * 		含有动态查询条件封装的对象
	 * @return
	 * 		查询到的集合
	 */
	List<Department> getByColumn(Department d) throws Exception;
}
