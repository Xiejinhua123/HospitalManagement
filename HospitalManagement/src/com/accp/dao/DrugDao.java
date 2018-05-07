package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Drug;
import com.accp.demo.Page;

/**
 * 药品表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface DrugDao extends CommonInterface {

	/**
	 * 查询当前药品信息
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询依据，以及查询条件
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Drug> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号查询药品信息
	 * 	
	 * @param id
	 * 		参数，需要查询的编号
	 * 
	 * @return
	 * 		返回当前的查询的对象，在业务层处理
	 */
	public List<Drug> getById(int id);
	
	/**
	 * 通过药品名称获取药品的编号
	 * 
	 * @param name
	 * 		药品名称
	 * @return
	 * 		药品编号
	 */
	public List<Drug> getDrugId(String name);
}
