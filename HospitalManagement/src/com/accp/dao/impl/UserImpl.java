package com.accp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.accp.dao.UserDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Page;
import com.accp.demo.User;
import com.accp.tools.GenerateId;

/***
 * 用户表增删改查
 * @author 解金化 解智翔
 * @version 1.0
 * @date 2017.3.15
 *
 */
public class UserImpl extends BaseDao implements UserDao {
	
	/**
	 * 添加角色信息<br/>
	 * 
	 * 
	 */
	public <T> int add(T t) {
		User u=(User)t;
		u.setUserId(GenerateId.getId());
		String sql="if not exists(select * from [User] where UserId=?) insert into User values(?,?,?,?,?,?)";
		Object[] parm={u.getUserId(),u.getUserId(),u.getUserPassword(),u.getCreateTime(),u.getModifyTime(),u.getLastLogin(),u.getOnlineState()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		String sql="delete [User] where UserId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		User u=(User)t;
		String sql="Update [User] set UserPassword=?,CreateTime=?,ModifyTime=?,LastLogin=?,OnlineState=? where UserId=?";
		Object[] parm={u.getUserPassword(),u.getCreateTime(),u.getModifyTime(),u.getLastLogin(),u.getOnlineState(),u.getUserId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<User> getPage(int pagesize,Map<String,String> map) {
		Page<User> page = new Page<User>();
		String sql = "select top(?) * from [User] where UserId not in(select top((?-1)*?) UserId from [User])";
		Object[] obj = new Object[]{page.getItems(),pagesize,page.getItems()};
		if(map != null){
			for (String s : map.keySet()) {
				if(s.equals("RoleId")){
					sql += " and RoleId = " + map.get("RoleId");
				}
			}
		}
		page.setList(query(sql, User.class, obj));
		return page;
	}

	public List<User> getById(String userid) {
		String sql = "select * from [User] where UserId = ?";
		return query(sql, User.class, new Object[]{userid});
	}

	public List<String> getAllId() {
		String sql = "select UserId as a from [User]";
		List<String> list = new ArrayList<String>();
		rs = getList(sql, new Object[]{});
		try {
			while(rs.next()){
				String s = rs.getString("UserId");
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, p, rs);
		}
		return list;
	}

}
