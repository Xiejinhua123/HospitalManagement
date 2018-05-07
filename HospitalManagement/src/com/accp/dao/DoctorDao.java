package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Doctor;
import com.accp.demo.Page;

/**
 * 医生表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.08
 */
public interface DoctorDao extends CommonInterface{
	
	/**
	 * 	查询所有医生信息
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页码 
	 * @param map
	 * 		查询的类型，以及查询的条件
	 * 
	 * @return
	 * 	当前页对象
	 * 	
	 */
	public Page<Doctor> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据医生编号，获取当前医生今天的挂号人数
	 * 
	 * @param id
	 * 		医生编号
	 * 
	 * @return
	 */
	public int getNumById(String id);
	
	/**
	 * 通过医生编号查询医生信息
	 * 
	 * @param map
	 * 		查询类别，查询条件
	 * 
	 * @return
	 * 		返回查询集合，在业务逻辑层处理
	 */
	public List<Doctor> getById(String doctorid);
	
	/**
	 * 医生登录账号
	 * @param id
	 * 		医生工号
	 * 
	 * @param pwd
	 * 		医生密码
	 * 
	 * @return
	 * 		返回登录后的医生对象
	 */
	public List<Doctor> login(String id,String pwd);
}
