package com.accp.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * 连接对象
 * @author xueshe01
 */
public class PoolConnection {
	private DbConfig config;
	//线程安全的集合对象，用来存储空闲的连接
	private List<Connection> freeConn = new Vector<Connection>();
	//正在使用的线程
	private List<Connection> activeConn = new Vector<Connection>();
	//将连接对象和当前线程关联起来
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	//记录当前线程的总数
	private int connActive = 0;
	
	public PoolConnection(DbConfig config){
		this.config=config;
		init();
	}
	/**
	 * 1.初始化，根据配置信息初始化连接池的初始连接数
	 * 2.产生一个数据库连接 根据配置信息缠身一个数据库的连接对象Connection
	 * 3.将连接释放的方法 活动集合中移动到空闲中
	 * 4.判断连接的装填是否正常
	 * 5.连接池的状态检查
	 */
	public void init() {
		try {
		 	Class.forName(config.getDRIVERNAME());
			for(int i = 0; i < config.getInitConns(); i++){
				freeConn.add(newConnection());				
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	/**
	 * 提供外部调用，获取数据库连接对象
	 * @return
	 */
	public synchronized Connection getConnection(){
		Connection conn = null;
		//先从当前线程取
		if(isEnable(local.get())){
			return local.get();
		}
		//小于最大的连接数才能够提供新的连接对象
		if(connActive < this.config.getMaxActiveConns()){
			if(freeConn.size() > 0){
				conn = freeConn.get(0);
				if(isEnable(conn)){
					local.set(conn);
				}
				freeConn.remove(0);//用掉一个连接，就移除一个空闲连接
			}else{
				conn = newConnection(); // 获取一个新的连接
			}
			activeConn.add(conn);
		}else{//等待释放连接
			try {
				wait(this.config.getWaitTime());
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			conn = getConnection(); // 递归调用
		}
		return conn;
	}
	/**
	 * 产生数据库连接对象
	 * @return
	 * synchronized 作用线程互斥锁，当前线程使用，其他线程不允许访问
	 */
	private synchronized Connection newConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(config.getURL(), config.getUSERNAME(), config.getPASSWORD());
			this.connActive++; // 总连接数加1
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;		
	}
	/**
	 * 释放连接，连接对象的放回连接池
	 */
	public synchronized void releaseConnection(Connection conn){
		//连接可用 并且 空闲的连接池中 没有超过允许的最大连接数
		if(isEnable(conn) && (freeConn.size() < config.getMaxConns())){
			freeConn.add(conn);
			this.notifyAll();//唤醒正在等待连接的对象
		}else{
			//把链接关闭
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		local.remove();
		activeConn.remove(conn);
		connActive--;
	}
	/**
	 * 判断数据库的连接对象是否可用
	 * @param conn 数据库连接对象
	 * @return 布尔类型
	 */
	private boolean isEnable(Connection conn){
		try {
			if(conn == null || conn.isClosed())
				return false;			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;
	}
}
