package com.accp.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * ���Ӷ���
 * @author xueshe01
 */
public class PoolConnection {
	private DbConfig config;
	//�̰߳�ȫ�ļ��϶��������洢���е�����
	private List<Connection> freeConn = new Vector<Connection>();
	//����ʹ�õ��߳�
	private List<Connection> activeConn = new Vector<Connection>();
	//�����Ӷ���͵�ǰ�̹߳�������
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	//��¼��ǰ�̵߳�����
	private int connActive = 0;
	
	public PoolConnection(DbConfig config){
		this.config=config;
		init();
	}
	/**
	 * 1.��ʼ��������������Ϣ��ʼ�����ӳصĳ�ʼ������
	 * 2.����һ�����ݿ����� ����������Ϣ����һ�����ݿ�����Ӷ���Connection
	 * 3.�������ͷŵķ��� ��������ƶ���������
	 * 4.�ж����ӵ�װ���Ƿ�����
	 * 5.���ӳص�״̬���
	 */
	public void init() {
		try {
		 	Class.forName(config.getDRIVERNAME());
			for(int i = 0; i < config.getInitConns(); i++){
				freeConn.add(newConnection());				
			}
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}
	/**
	 * �ṩ�ⲿ���ã���ȡ���ݿ����Ӷ���
	 * @return
	 */
	public synchronized Connection getConnection(){
		Connection conn = null;
		//�ȴӵ�ǰ�߳�ȡ
		if(isEnable(local.get())){
			return local.get();
		}
		//С���������������ܹ��ṩ�µ����Ӷ���
		if(connActive < this.config.getMaxActiveConns()){
			if(freeConn.size() > 0){
				conn = freeConn.get(0);
				if(isEnable(conn)){
					local.set(conn);
				}
				freeConn.remove(0);//�õ�һ�����ӣ����Ƴ�һ����������
			}else{
				conn = newConnection(); // ��ȡһ���µ�����
			}
			activeConn.add(conn);
		}else{//�ȴ��ͷ�����
			try {
				wait(this.config.getWaitTime());
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			conn = getConnection(); // �ݹ����
		}
		return conn;
	}
	/**
	 * �������ݿ����Ӷ���
	 * @return
	 * synchronized �����̻߳���������ǰ�߳�ʹ�ã������̲߳��������
	 */
	private synchronized Connection newConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(config.getURL(), config.getUSERNAME(), config.getPASSWORD());
			this.connActive++; // ����������1
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;		
	}
	/**
	 * �ͷ����ӣ����Ӷ���ķŻ����ӳ�
	 */
	public synchronized void releaseConnection(Connection conn){
		//���ӿ��� ���� ���е����ӳ��� û�г�����������������
		if(isEnable(conn) && (freeConn.size() < config.getMaxConns())){
			freeConn.add(conn);
			this.notifyAll();//�������ڵȴ����ӵĶ���
		}else{
			//�����ӹر�
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		local.remove();
		activeConn.remove(conn);
		connActive--;
	}
	/**
	 * �ж����ݿ�����Ӷ����Ƿ����
	 * @param conn ���ݿ����Ӷ���
	 * @return ��������
	 */
	private boolean isEnable(Connection conn){
		try {
			if(conn == null || conn.isClosed())
				return false;			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return true;
	}
}
