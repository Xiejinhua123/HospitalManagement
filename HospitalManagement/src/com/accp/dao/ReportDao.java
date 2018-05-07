package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Report;

/**
 * 报表表的增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface ReportDao extends CommonInterface {
	
	/**
	 * 查询所有报表
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询依据，查询条件
	 * 
	 * @return
	 * 		返回当前页码对象
	 */
	public Page<Report> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号查询报表信息
	 * 
	 * @param id
	 * 		参数，报表的编号
	 * 
	 * @return
	 * 		返回当前编号的对象集合，在业务层处理
	 */
	public List<Report> getById(String id);
}
