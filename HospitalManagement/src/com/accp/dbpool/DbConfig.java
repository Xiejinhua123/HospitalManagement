package com.accp.dbpool;

/**
 * 数据库连接池的基本属性类
 * @author xueshe01
 *
 */
public class DbConfig {
	/*数据库连接基本属性*/
	private String DRIVERNAME;
	private String URL;
	private String USERNAME;
	private String PASSWORD;
	
	/*连接池需要具备的属性*/
	private String poolName; // 连接池的名字
	private int minConns = 20; // 空闲的连接，最小连接数
	private int maxConns = 100; // 空闲的连接，最大保持多少个
	private int initConns = 20; // 初始化连接池连接数量
	private long waitTime = 500; // 当连接池五可用连接是，等待的时间
	private int maxActiveConns = 200; // 整个连接池最大允许多少个连接
	private boolean isCheck = false; // 是否启动连接池检测
	private long checkPeriod = 1000*60; // 间隔60秒检测一次和数据库连接的状态
	public String getDRIVERNAME() {
		return DRIVERNAME;
	}
	public void setDRIVERNAME(String dRIVERNAME) {
		DRIVERNAME = dRIVERNAME;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public int getMinConns() {
		return minConns;
	}
	public void setMinConns(int minConns) {
		this.minConns = minConns;
	}
	public int getMaxConns() {
		return maxConns;
	}
	public void setMaxConns(int maxConns) {
		this.maxConns = maxConns;
	}
	public int getInitConns() {
		return initConns;
	}
	public void setInitConns(int initConns) {
		this.initConns = initConns;
	}
	public long getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}
	public int getMaxActiveConns() {
		return maxActiveConns;
	}
	public void setMaxActiveConns(int maxActiveConns) {
		this.maxActiveConns = maxActiveConns;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public long getCheckPeriod() {
		return checkPeriod;
	}
	public void setCheckPeriod(long cheacPeriod) {
		this.checkPeriod = cheacPeriod;
	}
	
}
