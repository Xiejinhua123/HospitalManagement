package com.accp.dbpool;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 北大青鸟 数据库操作基类
 */
public class BaseDao {
	
//	public final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 数据库驱动
//	public final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databasename =HospitalManagement"; // url
//	public final static String DBNAME = "sa"; // 数据库用户名
//	public final static String DBPASS = "123"; // 数据库密码
//
//	/**
//	 * 得到数据库连接
//	 * 
//	 * @throws ClassNotFoundException
//	 * @throws SQLException
//	 * @return 数据库连接
//	 */
//	public Connection getConn() throws ClassNotFoundException, SQLException {
//		Connection conn = null;
//		try {
//			Class.forName(DRIVER); // 注册驱动
//			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // 获得数据库连接
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn; // 返回连接
//	}
	
	PoolManager pool = PoolManager.getInstance();
	
	public Connection getConn() throws ClassNotFoundException,SQLException{
		
	 	Connection conn = pool.getConn("dataA");
	 	return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            数据库连接
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* 如果rs不空，关闭rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果pstmt不空，关闭pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果conn不空，关闭conn */
		if (conn != null) {
			try {
				pool.close(conn, "dataA");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            数据库连接
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt) {

		/* 如果pstmt不空，关闭pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果conn不空，关闭conn */
		if (conn != null) {
			try {
				pool.close(conn, "dataA");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            数据库连接
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(ResultSet rs) {

		/* 如果rs不空，关闭rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
	 * 
	 * @param sql
	 *            预编译的 SQL 语句
	 * @param param
	 *            预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的条数
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate(); // 执行SQL语句
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
	
	@SuppressWarnings({"unchecked"})
	public <T> List<T> find(T t,String[] paramNames){
		List<T> result = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Class<?> cl = t.getClass();   // T的类型对象
		Field[] fields = new Field[paramNames.length];
		String tablename = cl.getSimpleName();
		try {
			conn = getConn(); // 得到数据库连接
			StringBuffer sql = new StringBuffer("select * from " + tablename + " where 1=1 ");
			Object[] params = new Object[paramNames.length];
			boolean hasParam = false;
			for(int i=0;i<params.length;i++){
				hasParam = true;
				fields[i] = cl.getDeclaredField(paramNames[i]);
				fields[i].setAccessible(true); // 设置属性直接可以访问
				Class<?> fieldType = fields[i].getType();
				Object value = fields[i].get(t);
				if(String.class.equals(fieldType)){
					sql.append(" and " + paramNames[i] + " like ? ");
					value = "%" + value + "%";
				}
				else{
					sql.append(" and " + paramNames[i] + " = ? ");
				}
				params[i] = value;
			}
			pstmt = conn.prepareStatement(sql.toString()); // 得到PreparedStatement对象
			if (params != null && hasParam) {
				for (int i = 0; i < paramNames.length; i++) {
					pstmt.setObject(i + 1, params[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				T temp = (T)t.getClass().newInstance();
				for(Field ff : cl.getDeclaredFields()){
					ff.setAccessible(true);
					String ffName = ff.getName();
					Object vv = null;
					try{
						vv = rs.getObject(ffName);
						ff.set(temp, vv);
					}catch(Exception e){
					}
				}
				result.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return result;		
	}

	/**
	 * 执行查询语句
	 * @param <T>
	 * @param sql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public <T> List<T> query(String sql,Class<T> entityClass,Object[] params){
		
		List<T> result = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql.toString()); // 得到PreparedStatement对象
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				T temp = (T)entityClass.newInstance();
				for(Field ff : entityClass.getDeclaredFields()){
					ff.setAccessible(true);
					String ffName = ff.getName();
					Object vv = null;
					try{
						vv = rs.getObject(ffName);
						ff.set(temp, vv);
					}catch(Exception e){
					}
				}
				result.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;		
	}
	
	
	protected Connection conn = null;
	protected PreparedStatement p = null;
	protected ResultSet rs = null;
	/**
	 * 执行查询语句
	 * 
	 * @param sql SQL语句
	 * 
	 * @param obj 参数列表
	 * 
	 * @return
	 * 		返回某一列的值，用字符串形式接收
	 */
	public ResultSet getList(String sql,Object[] obj){
		try {
			conn = getConn();
			p = conn.prepareStatement(sql.toString()); // 得到PreparedStatement对象
			if (p != null) {
				for (int i = 0; i < obj.length; i++) {
					p.setObject(i + 1, obj[i]); // 为预编译sql设置参数
				}
			}
			rs = p.executeQuery(); // 执行SQL语
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 执行无参存储过程
	 * 
	 * @param sql
	 * 		SQL语句
	 * 
	 * @param obj
	 * 		null
	 * 
	 * @return
	 * 		返回数据源
	 */
	public int getStored(Object[] obj){
		
		int a = -1;
		try {
			conn = getConn();
			CallableStatement cstmt = conn.prepareCall("{call Get_Id(?,?,?,?,?,?,?)}");
			cstmt.setInt(1, (Integer)obj[0]);
			cstmt.setString(2, (String)obj[1]);
			cstmt.setInt(3, (Integer)obj[2]);
			cstmt.setString(4, (String)obj[3]);
			cstmt.setString(5,(String)obj[4]);
			cstmt.setDouble(6, (Double)obj[5]);
			cstmt.registerOutParameter(7, java.sql.Types.INTEGER);
			cstmt.execute();
 			a = cstmt.getInt(7);
			System.out.println("basedao:" + a);
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			closeAll(conn, p, rs);
		}
		return a;
	}
}
