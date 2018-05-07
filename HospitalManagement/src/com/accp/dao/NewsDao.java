package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.News;
import com.accp.demo.Page;

/**
 * 新闻表的增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface NewsDao extends CommonInterface {
	
	/**
	 * 查询所有的新闻
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
	 * 
	 */
	public Page<News> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号查询新闻
	 * 
	 * @param id
	 * 		参数，新闻编号
	 * 
	 * @return
	 * 		返回集合，在业务层处理
	 */
	public List<News> getById(String id);
}
