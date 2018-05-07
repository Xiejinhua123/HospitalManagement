package com.accp.dao;

import java.util.List;

import com.accp.demo.Dictionary;

/**
 * 数据字典表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface DictionaryDao extends CommonInterface{
	
	/**
	 * 	在程序开始前执行该方法
	 * 	
	 * 	将字典中的所有字段放入公共类数据集合（common.dictionaryMap）中
	 * 	分组查询 （按照类型名称列进行查询 ）
	 * 
	 * @return
	 *		返回当前的书籍字典集合
	 */
	public List<Dictionary> getAll();
	
	/**
	 * 通过字段的唯一值查找字段的信息
	 * 
	 * @param code
	 * 	参数，需要查找的字段的唯一值
	 *  
	 * @return
	 * 	将查询到的相关信息，封装为对象返回
	 * 	在业务层处理
	 */
	public List<Dictionary> getByCode(String code);
}
