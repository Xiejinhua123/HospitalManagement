package com.accp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DoctorDao;
import com.accp.dao.impl.DoctorImpl;
import com.accp.demo.Doctor;
import com.accp.demo.Page;

/**
 * 该类是医生类的业务处理
 * 
 * @author 解金化
 * @version 1.0
 * 
 * @time 2017.03.11
 *
 */
public class DoctorBiz {

	private Logger logger = Logger.getLogger(DoctorBiz.class);
	private DoctorDao dd = new DoctorImpl();
	
	/**
	 * 添加医生
	 * 
	 * @param d
	 * 		参数，添加的医生的封装对象
	 * 
	 * @return
	 * 		返回该次操作对数据库的影响程度
	 */
	public int add(Doctor d){
		
		if(d == null){
			logger.debug("添加医生信息，传入值为空");
			throw new NullPointerException("当前医生信息不正确，无法为您添加医生");
		}
		
		int a = dd.add(d);
		return a;
		
	}
	
	/**
	 * 该方法执行医生的修改
	 * 
	 * @param d
	 * 		需要修改的医生的信息封装对象
	 * 
	 * @return
	 * 		返回数据库影响行数
	 */
	public int update(Doctor d){
		
		if(d == null || d.getDocId() == null){
			logger.debug("修改医生信息，医生编号，或者医生对象为空");
			throw new NullPointerException("当前医生提交不正确，请正确提交信息后，重新修改");
		}
		
		int a = dd.update(d);
		return a;
	}
	
	/**
	 * 执行删除
	 * 
	 * @param id
	 * 		当前医生的编号
	 * 
	 * @return
	 * 		返回当前的删除行数
	 */
	public int del(String id){
		
		if(id == null || id.length() != 12){
			logger.debug("删除医生，医生编号为空");
			throw new IllegalAccessError("当前医生编号信息不正确，请正确填写信息");
		}
		
		int a = dd.del(id);
		return a;
		
	}
	
	/**
	 * 分页查询当前页码的医生信息
	 * 
	 * @param pagesize
	 * @param map
	 * @return
	 */
	public Page<Doctor> getPage(int pagesize,Map<String, String> map){
		
		if(pagesize < 0){
			logger.debug("分页查询医生，页码错误");
			throw new IllegalAccessError("当前服务器请求出错，请修改后重新请求");
		}
		
		Page<Doctor> page = dd.getPage(pagesize, map);
		return page;
	}
	
	/**
	 * 根据医生编号查询医生信息
	 * 
	 * @param id
	 * 		当前医生的编号
	 * 
	 * @return
	 * 		返回当前查询到的医生对象，如果没有，返回null
	 */
	public Doctor getById(String id){
		
		if(id == null || id.length() != 12){
			logger.debug("查询医生，医生编号为空");
			throw new IllegalAccessError("当前医生编号信息不正确，请正确填写信息");
		}
		
		List<Doctor> list = dd.getById(id);
		Doctor doc = null;
		for (Doctor d : list) {
			doc = d;
		}
		return doc;
	}
	
	/**
	 * 获取当前医生当天的未处理挂号数量
	 * 
	 * @param docId
	 * 		医生工号
	 * 
	 * @return
	 * 		挂号数量
	 */
	public int getNum(String docId){
		return dd.getNumById(docId);
	}
	
	/**
	 * 医生登录
	 * 
	 * @param id
	 * 		医生工号
	 * 
	 * @param pwd
	 * 		密码
	 * 
	 * @return
	 * 		返回登录的医生对象
	 */
	public Doctor login(String id,String pwd) throws IllegalAccessException{
		Doctor doctor = null;
		if(id == null || id.length() != 12){
			logger.info("医生登录，工号信息不正确");
			throw new IllegalAccessError("idError");
		}
		if(pwd.length() < 6 || pwd == null){
			logger.info("医生登录，密码不正确");
			throw new IllegalAccessError("pwdError");
		}
		List<Doctor> list = new ArrayList<Doctor>(); 
		list = dd.login(id, pwd);
		for (Doctor d : list) {
			doctor = d;
		}
		return doctor;
	}
	
	public static void main(String[] args) {
		int a = new DoctorBiz().getNum("201701135677");
		System.out.println(a);
	}
}
