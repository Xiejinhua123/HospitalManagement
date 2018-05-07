package com.accp.dao;

import java.util.List;

public interface CommonDao <T>{
	/**
	 * 添加
	 * @param t 要添加的脏对象
	 * @return  Object(主键)
	 */
	@SuppressWarnings("hiding")
	public <T> Object save(T t);
	
	/**
	 * 根据id删除 id为String
	 * @param c 要操作的实体类
	 * @param id 根绝id删除
	 * @return boolean
	 */
	@SuppressWarnings("hiding")
	public <T> boolean del(Class<?> c,String id);
	
	/**
	 * 根据id删除 id为 int
	 * @param c 要操作的实体类
	 * @param id 根绝id删除 
	 * @return boolean.3
	 */
	@SuppressWarnings("hiding")
	public <T> boolean del(Class<?> c,int id);
	
	/**
	 * 修改
	 * @param t 脏对象
	 * @return boolean
	 */
	@SuppressWarnings("hiding")
	public <T> boolean update(T t);

	/**
	 * 分页
	 * @param page javaBean 
	 * @param sql  sql语句
	 * @param map  条件参数 键对应列  value 对应值
	 */
	//public <T> void getPage(Page<T> page, T t) ;
	
	/**
	 * 动态查询
	 * @param t
	 * @return
	 */
	public <T> List<T> getByColumn(T t);
}
