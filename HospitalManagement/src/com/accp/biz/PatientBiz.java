package com.accp.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.dao.PatientDao;
import com.accp.dao.impl.PatientImpl;
import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * 当前类是患者表的业务处理类
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.09
 *
 */
public class PatientBiz {
	
	private Logger logger = Logger.getLogger(PatientBiz.class); // 日志对象
	private PatientDao pd = new PatientImpl(); // 增删改查对象
	
	/**
	 * 执行登录
	 * 
	 * @param name
	 * 		患者名称
	 * 
	 * @param pwd
	 *		患者登录密码 
	 *
	 * @return
	 * 		返回null 或者  登陆后的患者对象
	 * 
	 * @throws Exception
	 * 		传入参数异常
	 * 
	 */
	public Patient login(String name, String pwd) throws Exception{
		
		if(name == null || pwd == null || name.length() == 0 || pwd.length() ==0){
			logger.debug("传入参数异常，没有正确的参数");
			throw new Exception("登录失败，登录名称或者密码为空");
		}	
		
		List<Patient> list = pd.login(name, pwd);
		Patient p = null;
		for (Patient patient : list) {
			p = patient;
		}
		return p;
	}
	
	/**
	 * 执行修改
	 * 
	 * @param p
	 * 		修改的对象
	 * 
	 * @return
	 * 		返回当前修改影响的行数
	 * 
	 * @throws Exception
	 * 		数据库异常情况，前台提交数据信息有误
	 */
	public int update(Patient p) throws Exception{
		
		if(p == null){
			
			logger.debug("修改客户信息，传入参数为空");
			throw new Exception("患者信息没有正确提交");
			
		}
		
		try {
			
			int a = pd.update(p); // 执行修改操作，返回影响行数
			
			return a;
			
		} catch (Exception e) {
			
			logger.debug("患者信息有误，数据库修改失败");
			throw new Exception("患者信息提交有误");
			
		}
		
	}
	
	/**
	 * 执行注册
	 * 
	 * 在前台提交表单的时候，需要验证当前用户填写的信息
	 * 如果是电话号码：p.setPhone();
	 * 如果是身份证号：p.setIdcard();
	 * 如果输用户名	 ：p.setNickname();
	 * 
	 * @param p
	 * 		需要添加的对象
	 * 
	 * @return
	 * 		返回数据库影响的行数
	 * 
	 * @throws Exception
	 * 		数据库异常，抛出异常，提交有误
	 */
	public int add(Patient p) throws Exception{
		
		if(p == null){
			
			logger.debug("添加客户信息，传入参数为空");
			throw new Exception("患者信息没有正确提交");
			
		}
		
		/*
		 * 通过前台的数据监测，用户是使用什么进行注册
		 * 
		 * 并且对于注册种类进行数据库验证，监测是否有重复
		 * 
		 * 如果重复，将信息以异常的形式抛出，在前台进行处理
		 */
		List<String> list = new ArrayList<String>();
		if(p.getPatPhone() != null){
			
			list = pd.getAllColumn("PatPhone");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatPhone().equals(string)){
					logger.debug("hasPhone");
					throw new Exception("hasPhone");
				}
			}
		}
		if(p.getPatNickname() != null) {

			list = pd.getAllColumn("PatNickname");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatNickname().equals(string)){
					logger.debug("hasName");
					throw new Exception("hasName");
				}					
			}
			
		}
		if(p.getPatCard() != null){
			
			list = pd.getAllColumn("PatCard");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatCard().equals(string)){
					logger.debug("hasCard");
					throw new Exception("hasCard");
				}
			}
			
		}			
		
		/**
		 * 没有重复
		 * 
		 * 正常情况下进行添加患者
		 */
		try {
			
			int a = pd.add(p); // 执行修改操作，返回影响行数
			
			return a;
			
		} catch (Exception e) {
			
			logger.debug("患者信息有误，数据库修改失败");
			throw new Exception("nothing");
			
		}
	}
	
	/**
	 * 分页查询页面信息
	 * 
	 * @param pagesize
	 * 		当前页面页码
	 * 
	 * @return
	 * 		返回当前页的患者信息
	 */
	public Page<Patient> getAll(int pagesize){
		return pd.getPage(pagesize);
	}
	
	/**
	 * 该方法用来判断当前登录用户的信息是否存在
	 * @param name
	 * @return
	 */
	public Boolean exists(String name){
		List<String> list = new ArrayList<String>();
		list = pd.getAllColumn("PatNickname"); // 检测昵称
		for (String s : list) {
			if(name.equals(s))
				return true;
		}
		list = pd.getAllColumn("PatCard"); // 检测身份证号
		for(String s : list){
			if(name.equals(s))
				return true;
		}
		list = pd.getAllColumn("PatPhone"); // 检测手机号码
		for(String s : list){
			if(name.equals(s))
				return true;
		}
		return false;
	}
	
	public Patient getById(String patId) throws IllegalAccessException{
		if(patId == null){
			logger.debug("查询患者信息学不正确");
			throw new IllegalAccessException("idError");
		}
		Patient p = null;
		
		List<Patient> list = pd.getById(Integer.parseInt(patId));
		for (Patient patient : list) {
			
			p = patient;
			
		}
		return p;
	} 
	
	public static void main(String[] args) {
//		String name = "张三";
//		String pwd = "123456789";
//		try {
//			Patient p = new PatientBiz().login(name, pwd);
//			System.out.println(p);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//System.out.println(new PatientBiz().exists("北大青鸟1"));
		
		Patient p = new Patient();
		p.setPatPassword("123456");
		p.getPatNickname();
		
	}
	
}
