package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.User;

/**
 * 用户表的增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.03.08
 *
 */
public interface UserDao extends CommonInterface {
		
	/**
	 * 数据库管理员查看所有用户信息
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<User> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 通过用户的id查找用户
	 * 
	 * @param userid
	 * 		参数，用户的id
	 * 
	 * @return
	 * 		返回集合，在逻辑层进行处理
	 */
	public List<User> getById(String userid);
	
	/**
	 * 获取所有的用户的编号
	 * 
	 * 在添加的时候用来检测是否当前用户编号已经使用
	 * 
	 * @return
	 * 		返回所有用户的编号集合
	 */
	public List<String> getAllId();
}

