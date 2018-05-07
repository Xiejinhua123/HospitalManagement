package com.accp.dbpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		PoolManager pool = PoolManager.getInstance();
	 	Connection conn = pool.getConn("dataA");
		Statement stmt;
		try {
			stmt = conn.createStatement();		
			ResultSet rs = stmt.executeQuery("select * from admin");
			while(rs.next()){
				System.out.print(rs.getString("loginid"));
				System.out.print(rs.getString("loginpwd"));
			}
			rs.close();
			stmt.close();
			pool.close(conn, "dataA");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接异常");
		}
	}

}
