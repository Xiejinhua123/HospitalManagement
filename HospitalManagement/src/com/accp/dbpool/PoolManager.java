package com.accp.dbpool;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * ���ݿ����ӳصĹ������ ����
 * @author xueshe01
 *
 */
public class PoolManager {
	//�������ӳصĶ�����
	private Hashtable<String, PoolConnection> pools = new Hashtable<String,PoolConnection>();
	private static List<DbConfig> config = new ArrayList<DbConfig>();
	static{
		Properties prop = new Properties();
		try {
			prop.load(PoolManager.class.getClassLoader().getResourceAsStream("db.properties"));
			
			DbConfig configA = new DbConfig();
			configA.setDRIVERNAME(prop.getProperty("dataA.driverName"));
			configA.setURL(prop.getProperty("dataA.url"));
			configA.setUSERNAME(prop.getProperty("dataA.userName"));
			configA.setPASSWORD(prop.getProperty("dataA.password"));
			configA.setPoolName("dataA");
			config.add(configA);
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public PoolManager() {
		init();
	}
	
	/**
	 * ��ȡPoolManager��ʵ�������ڵ���ģʽ
	 * @return
	 */
	public static PoolManager getInstance(){
		return Single.instance;
	}
	
	/*˽�еľ�̬�ڲ���*/
	private static class Single{
		private static PoolManager instance = new PoolManager();
	}
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		for (int i = 0; i < config.size(); i++) {
			DbConfig cfg = config.get(i);
			PoolConnection pool = new PoolConnection(cfg);
			pools.put(cfg.getPoolName(), pool);
		}
	}
	/**
	 * 1.���Ӷ���Ļ�ȡ  ��  ����
	 */
	/**
	 * ��ȡһ�����ݿ����Ӷ���
	 * @param poolName
	 * @return
	 */
	public Connection getConn(String poolName){
		PoolConnection poolConn = pools.get(poolName);
		return poolConn.getConnection();
	}
	/**
	 * �������õ����ݿ����Ӷ���
	 * @param conn
	 * @param poolName
	 */
	public void close(Connection conn, String poolName){
		PoolConnection poolConn = pools.get(poolName);
		poolConn.releaseConnection(conn);
	}
}
