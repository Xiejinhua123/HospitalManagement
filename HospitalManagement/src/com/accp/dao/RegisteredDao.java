package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Registered;

/**
 * 挂号信息表增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface RegisteredDao extends CommonInterface {
	
	/**
	 * 查询挂号信息
	 * 分页查询
	 * 
	 * @param pagesize
	 * 		当前页面页码
	 * 
	 * @param map
	 * 		查询依据，查询条件
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Registered> getPage(int pagesize,Map<String,String> map); 
	
	/**
	 * 根据编号查询挂号信息
	 * 
	 * @param id
	 * 		挂号编号
	 * 
	 * @return
	 * 		返回当前对象集合，在业务逻辑层处理
	 * 
	 */
	public List<Registered> getById(int id);
	
	/**
	 * 通过医生查询今天的没有处理的挂号信息
	 * 
	 * @param doctorId
	 * 		医生工号
	 * 
	 * @return
	 * 		返回挂号信息
	 */
	public List<Registered> getNoDispose(String doctorId);
		
}
