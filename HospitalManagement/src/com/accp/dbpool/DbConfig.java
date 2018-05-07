package com.accp.dbpool;

/**
 * ���ݿ����ӳصĻ���������
 * @author xueshe01
 *
 */
public class DbConfig {
	/*���ݿ����ӻ�������*/
	private String DRIVERNAME;
	private String URL;
	private String USERNAME;
	private String PASSWORD;
	
	/*���ӳ���Ҫ�߱�������*/
	private String poolName; // ���ӳص�����
	private int minConns = 20; // ���е����ӣ���С������
	private int maxConns = 100; // ���е����ӣ���󱣳ֶ��ٸ�
	private int initConns = 20; // ��ʼ�����ӳ���������
	private long waitTime = 500; // �����ӳ�����������ǣ��ȴ���ʱ��
	private int maxActiveConns = 200; // �������ӳ����������ٸ�����
	private boolean isCheck = false; // �Ƿ��������ӳؼ��
	private long checkPeriod = 1000*60; // ���60����һ�κ����ݿ����ӵ�״̬
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
