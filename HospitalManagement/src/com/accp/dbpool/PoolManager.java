package com.accp.dbpool;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * 数据库连接池的管理对象 单例
 * @author xueshe01
 *
 */
public class PoolManager {
	//所有连接池的对象存放
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public PoolManager() {
		init();
	}
	
	/**
	 * 获取PoolManager的实例，属于单例模式
	 * @return
	 */
	public static PoolManager getInstance(){
		return Single.instance;
	}
	
	/*私有的静态内部类*/
	private static class Single{
		private static PoolManager instance = new PoolManager();
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		for (int i = 0; i < config.size(); i++) {
			DbConfig cfg = config.get(i);
			PoolConnection pool = new PoolConnection(cfg);
			pools.put(cfg.getPoolName(), pool);
		}
	}
	/**
	 * 1.连接对象的获取  和  返回
	 */
	/**
	 * 获取一个数据库连接对象
	 * @param poolName
	 * @return
	 */
	public Connection getConn(String poolName){
		PoolConnection poolConn = pools.get(poolName);
		return poolConn.getConnection();
	}
	/**
	 * 销毁无用的数据库连接对象
	 * @param conn
	 * @param poolName
	 */
	public void close(Connection conn, String poolName){
		PoolConnection poolConn = pools.get(poolName);
		poolConn.releaseConnection(conn);
	}
}
