package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Drug;
import com.accp.demo.DrugTime;
import com.accp.util.Page;

public interface DrugTimeDao extends CommonInterface {

	/**
	 * 根据药品查询药品过期时间
	 * 
	 * @param drug
	 * 		药品对象
	 * 
	 * @return
	 * 		过期时间的集合
	 * 		有就返回集合，没有返回null
	 */
	List<DrugTime> getByDrug(Drug drug);

	/**
	 * 动态条件查询
	 * 
	 * @param d
	 * 		查询条件组成的对象
	 * 
	 * @return
	 * 		符合条件的集合
	 */
	List<DrugTime> getByColumn(DrugTime d);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * 		分页对象
	 * @param drugtime
	 * 		动态条件构成的对象
	 * @param b
	 * 		这是针对数量的一列
	 * 		true 为  查询全部
	 * 		false 为 查询数量大于0的对象集合
	 */
	void getPage(Page<DrugTime> page, DrugTime d,Boolean bool) throws Exception;

	/**
	 * 获取给定参数的药品的总数量
	 * 
	 * @param drugId
	 * 		需要查询的药品的编号
	 * 
	 * @return
	 * 		返回该药品的总数量
	 */
	int getDrugNum(Drug drug);

}
