package com.accp.dao.impl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.accp.dao.RegisteredDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Page;
import com.accp.demo.Registered;

/***
 * 挂号信息的增删改查
 * @author 解金化 解智翔
 * @version 1.0
 * @date 2017.3.15
 *
 */
public class RegisteredImpl extends BaseDao implements RegisteredDao {
	
	/**
	 * 该添加方法编号自动生成<br/>
	 * 
	 * 在业务逻辑层处理<br/>
	 * 
	 * 这里无需处理
	 */
	public <T> int add(T t) {
		Registered r=(Registered)t;
		String sql="insert into Registered values(?,?,?,?,?,?,?,?,?)";
		Object[] parm={r.getPatId(),r.getRegTime(),r.getDepId(),r.getDocId(),r.getRegType(),r.getRegPrice()};
		int a = 1;
		if(a > 0){
			a = getStored(parm);
			System.out.println("impl" + a);
		}
		return a;
	}
	
	public int del(String id) {
		String sql="delete from Registered where RegId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		Registered r=(Registered)t;
		String sql="Update Registered set PatId=?,RegTime=?,DepId=?,DocId=?,RegType=?,RegPrice=?,PayState=?,RegState=?,IsPay=? where RegId=?";
		Object[] parm={r.getPatId(),r.getRegTime(),r.getDepId(),r.getDocId(),r.getRegType(),r.getRegPrice(),r.getPayState(),r.getRegState(),r.getIsPay(),r.getRegId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Registered> getPage(int pagesize, Map<String, String> map) {
		
		Page<Registered> page = new Page<Registered>();
		
		//初始SQL语句
		StringBuffer sql = new StringBuffer( "select top(?) * from Registered where RegId not in (select top((?-1)*?) RegId from Registered)");
		//初始参数列表
		Object[] obj = new Object[]{page.getItems(),pagesize,page.getItems()};
		
		if(map != null){
			for (String s : map.keySet()) {
				
				if(s.equals("DepId")){ // 按照科室信息查询
					sql.append(" and DepId = " + map.get("DepId"));
				}
				if(s.equals("RegType")){ // 按照挂号类型查询
					sql.append(" and RegType = " + map.get("RegType"));
				}
				
			}
		}
		//System.out.println(sql); // 测试SQL语句
		page.setList(query(sql.toString(), Registered.class, obj));
		return page;
	}

	public List<Registered> getById(int id) {
		// TODO 自动生成的方法存根
		return query("select * from Registered where RegId = ?", Registered.class, new Object[]{id});
	}
	
	public static void main(String[] args) {
		System.out.println(new RegisteredImpl().getNoDispose("201701135677"));
	}

	public List<Registered> getNoDispose(String doctorId) {
		String sql = "select * from Registered where convert(date,RegTime) = CONVERT(date,GETDATE()) and DocId = ? and RegState = '501'";
		Object[] obj = new Object[]{doctorId};
		return query(sql, Registered.class, obj);
	}

}
