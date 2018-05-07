package com.accp.dao;

import java.util.List;

import com.accp.demo.Patient;
import com.accp.util.Page;

public interface PatientDao extends CommonInterface {

	/**
	 * 动态分页查询患者信息
	 * 
	 * @param page
	 * 		分页对象
	 * 
	 * @param p
	 * 		
	 */
	void getPage(Page<Patient> page, Patient p);

	/**
	 * 动态查询患者信息
	 * 
	 * @param p
	 * 		动态条件组成的对象
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<Patient> getByColumn(Patient p);
	
}
