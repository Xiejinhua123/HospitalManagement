package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Dictionary;
import com.accp.util.Page;

public interface DictionaryDao extends CommonInterface{

	/**
	 * 分页查询数据字典信息
	 * 
	 * @param page
	 * 		分页对象
	 * @param dic
	 * 		含有动态条件的对象
	 */
	void getPage(Page<Dictionary> page,Dictionary d);

	/**
	 * 动态条件查询
	 * 
	 * @param d
	 * 		含有动态条件的封装对象
	 * 
	 * @return
	 * 		数据字典集合
	 */
	List<Dictionary> getByColumn(Dictionary d);

	boolean delByTypeName(String typeName);

}
