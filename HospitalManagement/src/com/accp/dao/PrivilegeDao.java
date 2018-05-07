package com.accp.dao;

import java.util.List;

import com.accp.demo.Page;
import com.accp.demo.Privilege;

/**
 * 权限表增删改查
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface PrivilegeDao extends CommonInterface {
	
	/**
	 * 查询所有的权限
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @return
	 * 		当前页对象
	 */
	public Page<Privilege> getPage(int pagesize);
	
	/**
	 * 根据权限编号查询相关权限
	 * 
	 * @param id
	 * 		权限编号
	 * 
	 * @return
	 * 		返回当前对象集合，在业务层进行处理
	 */
	public List<Privilege> getById(int id);
}
