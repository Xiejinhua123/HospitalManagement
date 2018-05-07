package com.accp.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DepartmentDao;
import com.accp.dao.impl.DepartmentImpl;
import com.accp.demo.Department;
import com.accp.demo.Page;

/**
 * 科室表的业务处理层
 * 
 * @author 解金化
 * 
 * @version 1.1
 * 
 * @time 2017.03.11
 *
 */
public class DepartmentBiz {
	
	private Logger logger = Logger.getLogger(DepartmentBiz.class);
	private DepartmentDao dd = new DepartmentImpl();
	
	/**
	 * 该方法用来执行科室添加
	 *  
	 * @param d
	 * 		需要添加的科室信息对象
	 * 
	 * @return
	 * 		返回数据影响行数
	 */
	public int add(Department d) throws NullPointerException,SQLException{
		
		if(d == null){
			logger.debug("添加科室，参数为空");
			throw new NullPointerException("执行失败，没有科室需要添加");
		}
		int a = dd.add(d);
		return a;
	}
	
	/**
	 * 用来执行删除科室
	 * 
	 * @param id
	 * 		需要删除的科室的编号
	 * 
	 * @return
	 * 		返回删除对数据库的影响
	 * 
	 * @throws IllegalAccessException
	 * 		传递非法参数异常
	 */
	public int del(int id) throws IllegalAccessException{
		
		if(id < 10000){
			logger.debug("删除，参数不正确");
			throw new IllegalAccessError("删除编号不正确");
		}
		int a = dd.del(id+"");
		return a;
	}
	
	/**
	 * 用来修改科室信息
	 * 
	 * @param d
	 * 		需要修改的科室的信息封装对象
	 * 
	 * @return
	 * 		返回数据库影响行数
	 * 
	 * @throws NullPointerException
	 * 		空值异常
	 * @throws SQLException
	 * 		数据库异常
	 */
	public int update(Department d) throws NullPointerException,SQLException{
		
		if(d == null){
			logger.debug("修改，对象为空");
			throw new NullPointerException("当前修改的信息为空");
		}
		int a = dd.update(d);
		return a;
	}
	
	/**
	 * 获取当前页码的内容
	 * 
	 * @param pagesize
	 * 		参数，当前页码
	 * 
	 * @return
	 * 		返回当前页码下的所有信息
	 * 
	 * @throws IllegalAccessException
	 * 		非法参数异常
	 */
	public Page<Department> getPage(int pagesize) throws IllegalAccessException{
		
		if(pagesize <= 0){
			logger.debug("显示科室，页码为空");
			throw new IllegalAccessException("当前的页数不正确");
		}
		Page<Department> pages = dd.getPage(pagesize);
		return pages;
	}
	
	/**
	 * 根据科室编号查询科室信息
	 * 
	 * @param id
	 * 		科室编号
	 * 
	 * @return
	 * 		返回当前的科室的封装对象
	 * 
	 * @throws IllegalAccessException
	 * 		传递的参数异常
	 */
	public Department getById(int id) throws IllegalAccessException{
		
		if(id < 1000){
			logger.debug("获取当前科室信息，参数异常");
			throw new IllegalAccessError("当前的科室编号不正确，无法进行查询");
		}
		
		/**
		 * 从数据库读出信息并返回
		 * 
		 * 数据库id列唯一
		 * 只返回一条信息
		 */
		List<Department> list = dd.getById(id);
		Department dd = null;
		for (Department d : list) {
			dd = d;
		}
		return dd;
	}
	
	/**
	 * 获取所有的科室信息
	 * 
	 * @return
	 * 		返回科室的集合
	 */
	public List<Department> getAll(Map<String,String> map){
		List<Department> list = dd.getAll(map);
		return list;
	}
}
