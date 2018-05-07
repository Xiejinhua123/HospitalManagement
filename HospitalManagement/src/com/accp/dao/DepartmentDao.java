package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Department;
import com.accp.demo.Page;

/**
 * 科室表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface DepartmentDao extends CommonInterface {
	
	/**
	 * 查询所有科室信息
	 * 分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Department> getPage(int pagesize);
	
	/**
	 * 通过科室编号查询科室信息
	 *
	 *@param id
	 *		科室编号
	 *
	 * @return
	 * 		放回当前的科室信息，在业务逻辑层处理
	 */
	public List<Department> getById(int id);
	
	/**
	 * 获取所有的科室信息
	 * 
	 * @return
	 * 		所有科室的集合
	 */
	public List<Department> getAll(Map<String, String> map);
	
}
