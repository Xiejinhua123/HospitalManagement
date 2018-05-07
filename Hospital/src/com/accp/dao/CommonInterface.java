package com.accp.dao;

/**
 * 公用接口，用来执行增删改
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface CommonInterface {
	
	/**
	 * 通用添加方法<br/>
	 * 
	 * 在执行添加的时候注意需要事先查询数据库中信息，是否重复添加<br/>
	 * 
	 * 某些添加在业务层处理<br/>
	 * 
	 * 某些添加利用sql语句进行限制<br/>
	 * 
	 * @param t
	 * 		传入任意类型，执行添加
	 * 
	 * @return
	 * 		返回影响行数
	 * 
	 */
	public <T> Object add(T t);
	
	/**
	 * 通用删除方法
	 * 
	 * @param id
	 * 		需要删除的id
	 * 
	 * @return
	 * 		返回当前删除影响的行数
	 */
	public boolean del(String id);
	
	
	/**
	 * 执行修改
	 *  
	 * @param t
	 * 		修改对象
	 * 
	 * @return
	 * 		执行修改返回的影响行数
	 * 
	 */
	public boolean del(int id);
	
	/**
	 * 执行修改
	 *  
	 * @param t
	 * 		修改对象
	 * 
	 * @return
	 * 		执行修改返回的影响行数
	 * 
	 */
	public <T> boolean update(T t);
}
