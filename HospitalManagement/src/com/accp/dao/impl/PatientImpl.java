package com.accp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.accp.dao.PatientDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * 患者表的增删改查实现类
 * 
 * @author 解金化  解智翔
 * @version 1.0
 * @date 2017.03.14
 *
 */
public class PatientImpl extends BaseDao implements PatientDao {

	/**
	 * 患者表的添加方法<br/>
	 * 
	 * 该方法，后条生成用户编号<br/>
	 * 
	 * 并且在添加用户的时候进行检测当前的用户注册信息在数据库中是否重复
	 */
	public <T> int add(T t) {
		Patient p=(Patient)t;
		String sql="insert into Patient values(?,?,?,?,?,?,?,?,?,?)";
		Object[] parm={p.getPatNickname(),p.getPatPassword(),p.getPatName(),p.getPatCard(),p.getPatSex(),p.getPatBirthday(),p.getPatPhone(),p.getPatAddress(),p.getPatSymotoms(),p.getGeneticDisorders()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		String sql="if exists(select * from Patient where PatId=?) delete from Patient where PatId=?";
		Object[] parm={id,id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		Patient p=(Patient)t;
		String sql="Update Patient set PatNickname=?,PatPassword=?,PatName=?,PatCard=?,PatSex=?,PatBirthday=?,PatPhone=?,PatAddress=?,PatSymotoms=?,GeneticDisorders=? where PatId=?";
		Object[] parm={p.getPatNickname(),p.getPatPassword(),p.getPatName(),p.getPatCard(),p.getPatSex(),p.getPatBirthday(),p.getPatPhone(),p.getPatSymotoms(),p.getGeneticDisorders(),p.getPatId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Patient> getPage(int pagesize) {
		Page<Patient> page = new Page<Patient>();
		String sql = "select top(?) * from Patient where PatId not in(select top((?-1)*?) PatId from Patient)";
		page.setList(query(sql, Patient.class, new Object[]{page.getItems(),pagesize,page.getItems()}));
		return page;
	}

	public List<String> getAllColumn(String columnname) {
		// TODO 自动生成的方法存根
		String sql = "select "+columnname+" from Patient"; // 利用登录类型获取SQL语句
		//System.out.println(sql); //测试SQL语句是否正确
		rs = getList(sql, new Object[]{}); // 获取结果集
		List<String> list = new ArrayList<String>(); // new 出  list 对象，
		
		try {
			while(rs.next()){ // 循环结果集
				
				String str = rs.getString(columnname);
				list.add(str); // 将结果集中的字符串，赋值给list对象
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(conn, p, rs); // 释放所有资源
		}	
		
		return list;
	
	}
	public List<Patient> getById(int id) {
		// TODO 自动生成的方法存根
		return query("select p.PatId,p.PatNickname,p.PatAddress,p.PatName,p.PatCard,p.PatBirthday,p.PatPhone,p.PatAddress,p.PatSymotoms,p.GeneticDisorders," +
				"PatSex = (select dic.TypeValus from Dictionary dic where dic.TypeCode = p.PatSex)" +
				" from patient p where PatId = ?", Patient.class, new Object[]{id});
	}

	public List<Patient> login(String name, String pwd) {
		String sql = "select * from Patient where (PatNickname = ? or PatCard = ? or PatPhone = ?) and PatPassword = ? ";
	
		return query(sql, Patient.class, new Object[]{name,name,name,pwd});
	}
	
	public static void main(String[] args) {
		List<String> list = new PatientImpl().getAllColumn("PatNickname");
		System.out.println("a");
		for (String string : list) {
			System.out.println(string);
		}		
	}

}
