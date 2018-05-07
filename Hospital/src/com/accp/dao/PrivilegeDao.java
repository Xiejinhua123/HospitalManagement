package com.accp.dao;

import java.util.List;

import com.accp.demo.Privilege;

public interface PrivilegeDao extends CommonInterface{

	/**
	 * 动态查询权限
	 * 
	 * @param p
	 * @return
	 */
	List<Privilege> getByColumn(Privilege p);

}
