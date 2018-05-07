package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.DepartmentDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Department;
import com.accp.demo.Page;

/**
 * 科室表增删改查
 * 
 * @author 解金化  解智翔
 * 
 * @version 1.0
 * 
 * @date 2017.03.14
 *
 */
public class DepartmentImpl extends BaseDao implements DepartmentDao {
	
	public <T> int add(T t) {
		
		Department d=(Department)t;
		String sql="insert into Department values(?,?)";
		Object[] parm={d.getDepName(),d.getDepAddress()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		String sql="delete from Department where DepId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		Department d=(Department)t;
		String sql="Update Department set DepName=?,DepAddress=? where DepId=?";
		Object[] parm={d.getDepName(),d.getDepAddress(),d.getDepId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Department> getPage(int pagesize) {
		// TODO 自动生成的方法存根
		Page<Department> page = new Page<Department>(); // 创建分页对象
		String sql = "select top(?) * from department where depId not in(select top((?-1)*?) depId from department)"; // 创建分页查询SQL语句
		page.setList(query(sql, Department.class, new Object[]{page.getItems(),pagesize,page.getItems()})); // 将查询结果赋值给分页对象
		return page;
	}

	public List<Department> getById(int id) {
		String sql = "select d.DepId,d.DepAddress,dic.TypeValus DepName from Department d,Dictionary dic where d.DepName = dic.TypeCode and d.DepId = ?";
		return query(sql, Department.class, new Object[]{id});
	}
	
	public static void main(String[] args) {
		List<Department> list = new DepartmentImpl().getById(1000);
		System.out.println("名称:" + list.get(0).getDepName());
		
	}

	public List<Department> getAll(Map<String,String> map) {
		String sql = "select d.DepId DepId,dic.TypeValus DepName," +
				"d.DepAddress DepAddress from Department d,Dictionary dic" +
				" where dic.TypeCode = d.DepName";
		Object[] obj = new Object[]{};
		
		if(map != null){
			for (String s : map.keySet()) {
				if(s.equals("Specialist")){
					sql = "select d.DepId DepId,dic.TypeValus DepName,d.DepAddress DepAddress" +
							" from Department d,Dictionary dic,Specialist s" +
							" where dic.TypeCode = d.DepName and d.DepId = s.DepId" +
							" and CONVERT(DATE,s.DateTime) = CONVERT(DATE,GETDATE())";
				}
			}
		}
		
		return query(sql, Department.class,obj);
	}

}
