package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * 患者信息表增删改查
 * 
 * @author 解金化
 * @version 1.0
 *
 *	2017.03.08
 */
public interface PatientDao extends CommonInterface {
	
	/**
	 * 	查询患者信息
	 * 	分页查询
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @return
	 * 		当前页对象
	 * 
	 */
	public Page<Patient> getPage(int pagesize);
	
	/**
	 * 根据列名查询
	 * 
	 * 该方法用于将所有的患者电话、用户名、身份证号信息，读出到集合中
	 * 
	 * 用于检测用户提交信息是否已经被注册
	 * 
	 * 仅供后台检测时调用
	 * 
	 * @return
	 * 		返回患者表中的该列的所有信息
	 */
	public List<String> getAllColumn(String columnname);
	
	/**
	 * 	根据编号查询患者
	 * 
	 * @param id
	 * 		参数，患者编号
	 * 	
	 * @return
	 * 		返回患者信息，在业务层处理
	 */
	public List<Patient> getById(int id);
	
	/**
	 * 登录功能
	 * 
	 * @param name
	 * 		用户名
	 * 
	 * @param pwd
	 * 		密码
	 * 
	 * @return
	 * 		登陆成功，返回当前的登录对象，返回集合，在业务层处理
	 * 		登录失败，返回null
	 */
	public List<Patient> login(String name, String pwd);
	
}
