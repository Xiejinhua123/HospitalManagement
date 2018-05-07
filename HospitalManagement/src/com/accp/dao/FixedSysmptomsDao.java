package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.FixedSysmptoms;
import com.accp.demo.Page;

/**
 * 固定症状表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface FixedSysmptomsDao extends CommonInterface {
	
	/**
	 * 查询所有信息
	 * 分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询依据，和查询条件
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<FixedSysmptoms> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号查询对象
	 * 
	 * @param id
	 * 		参数，需要查询的对象编号
	 * 
	 * @return
	 * 		返回查询对象集合，在业务逻辑层处理
	 */
	public List<FixedSysmptoms> getById(int id);
}
