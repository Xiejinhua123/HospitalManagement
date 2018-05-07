package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Drug;
import com.accp.util.Page;

public interface DrugDao extends CommonInterface{

	/**
	 * 动态条件查询
	 * 
	 * @param d
	 * 		动态条件封装的类
	 * @return
	 * 		返回集合
	 */
	List<Drug> getByColumn(Drug d);

	/**
	 * 动态分页查询
	 * 
	 * @param page
	 * 		分页对象
	 * 
	 * @param drug
	 * 		动态查询条件封装的类
	 */
	void getPage(Page<Drug> page,Drug d);

}
