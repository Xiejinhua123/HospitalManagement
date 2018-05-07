package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.FixedSysmptoms;
import com.accp.util.Page;

/**
 * 固定症状表信息
 * @author xueshe01
 *
 */
public interface FixedSysmptomsDao extends CommonInterface{

	/**
	 *	动态分页查询固定症状
	 *
	 * @param page
	 * 		分页对象
	 * 
	 * @param f
	 * 		动态条件构成的对象
	 * 
	 */
	void getPage(Page<FixedSysmptoms> page,FixedSysmptoms f);

	/**
	 * 动态查询
	 * 
	 * @param f
	 * 		动态条件构成的对象
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<FixedSysmptoms> getByColumn(FixedSysmptoms f);

}
