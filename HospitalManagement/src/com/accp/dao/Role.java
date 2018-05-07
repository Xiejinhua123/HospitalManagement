package com.accp.dao;

import java.util.List;

import com.accp.demo.Page;

/**
 * 角色表增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface Role extends CommonInterface {
	
	/**
	 * 查询角色信息
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页数
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Role> getPage(int pagesize);
	
	/**
	 * 根据id查询角色信息
	 * 
	 * @param id
	 * 	参数，当前查询角色的编号
	 *  
	 * @return
	 * 		返回角色信息，在业务逻辑层处理
	 */
	public List<Role> getById(int id);
}
