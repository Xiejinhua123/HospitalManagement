package com.accp.dao;

import java.util.List;

import com.accp.demo.Registered;
import com.accp.util.Page;

public interface RegisteredDao extends CommonInterface{

	/**
	 * 分页动态查询挂号信息
	 * 
	 * @param page
	 * 		分页对象
	 * 
	 * @param r
	 * 		动态条件构成的对象
	 */
	void getPage(Page<Registered> page, Registered r);

	/**
	 * 动态查询挂号信息
	 * 
	 * @param r
	 * 		动态条件构成的对象
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<Registered> getByColumn(Registered r);

}
