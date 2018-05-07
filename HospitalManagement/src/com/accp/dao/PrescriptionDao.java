package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Prescription;

/**
 * 处方表增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface PrescriptionDao extends CommonInterface {

	/**
	 * 查询当前页面的集合
	 * 分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询依据，查询条件
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Prescription> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号查询处方信息
	 * 
	 * @param id
	 * 		参数，当前查询的编号
	 * 
	 * @return
	 * 		返回查询到对象的集合，在业务层处理
	 */
	public List<Prescription> getById(int id);
}
