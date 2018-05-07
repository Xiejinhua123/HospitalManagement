package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.News;
import com.accp.util.Page;

public interface NewsDao extends CommonInterface{

	/**
	 * 动态查询
	 * 
	 * @param n
	 * 		动态查询的条件构成的对象
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<News> getByCoulumn(News n);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * 		分页对象
	 * @param n
	 * 		动态条件构成的对象
	 */
	void getPage(Page<News> page,News n);

}
