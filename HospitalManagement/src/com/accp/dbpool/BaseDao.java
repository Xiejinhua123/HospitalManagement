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
 * @author �������� ���ݿ��������
 */
public class BaseDao {
	
//	public final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ�����
//	public final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databasename =HospitalManagement"; // url
//	public final static String DBNAME = "sa"; // ���ݿ��û���
//	public final static String DBPASS = "123"; // ���ݿ�����
//
//	/**
//	 * �õ����ݿ�����
//	 * 
//	 * @throws ClassNotFoundException
//	 * @throws SQLException
//	 * @return ���ݿ�����
//	 */
//	public Connection getConn() throws ClassNotFoundException, SQLException {
//		Connection conn = null;
//		try {
//			Class.forName(DRIVER); // ע������
//			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // ������ݿ�����
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn; // ��������
//	}
	
	PoolManager pool = PoolManager.getInstance();
	
	public Connection getConn() throws ClassNotFoundException,SQLException{
		
	 	Connection conn = pool.getConn("dataA");
	 	return conn;
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				pool.close(conn, "dataA");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt) {

		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				pool.close(conn, "dataA");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(ResultSet rs) {

		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate(); // ִ��SQL���
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
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
		Class<?> cl = t.getClass();   // T�����Ͷ���
		Field[] fields = new Field[paramNames.length];
		String tablename = cl.getSimpleName();
		try {
			conn = getConn(); // �õ����ݿ�����
			StringBuffer sql = new StringBuffer("select * from " + tablename + " where 1=1 ");
			Object[] params = new Object[paramNames.length];
			boolean hasParam = false;
			for(int i=0;i<params.length;i++){
				hasParam = true;
				fields[i] = cl.getDeclaredField(paramNames[i]);
				fields[i].setAccessible(true); // ��������ֱ�ӿ��Է���
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
			pstmt = conn.prepareStatement(sql.toString()); // �õ�PreparedStatement����
			if (params != null && hasParam) {
				for (int i = 0; i < paramNames.length; i++) {
					pstmt.setObject(i + 1, params[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL���
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
	 * ִ�в�ѯ���
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql.toString()); // �õ�PreparedStatement����
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL���
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
	 * ִ�в�ѯ���
	 * 
	 * @param sql SQL���
	 * 
	 * @param obj �����б�
	 * 
	 * @return
	 * 		����ĳһ�е�ֵ�����ַ�����ʽ����
	 */
	public ResultSet getList(String sql,Object[] obj){
		try {
			conn = getConn();
			p = conn.prepareStatement(sql.toString()); // �õ�PreparedStatement����
			if (p != null) {
				for (int i = 0; i < obj.length; i++) {
					p.setObject(i + 1, obj[i]); // ΪԤ����sql���ò���
				}
			}
			rs = p.executeQuery(); // ִ��SQL��
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * ִ���޲δ洢����
	 * 
	 * @param sql
	 * 		SQL���
	 * 
	 * @param obj
	 * 		null
	 * 
	 * @return
	 * 		��������Դ
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			closeAll(conn, p, rs);
		}
		return a;
	}
}
