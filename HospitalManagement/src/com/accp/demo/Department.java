package com.accp.demo;

/**
 * ������
 * 
 * @author ���
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Department {
	
	private int depId; // ���ұ��
	private String depName; // ��������
	private String depAddress; // ���ҵ�ַ
	public Department() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Department(int depId, String depName, String depAddress) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depAddress = depAddress;
	}
	public Department(String depName, String depAddress) {
		super();
		this.depName = depName;
		this.depAddress = depAddress;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepAddress() {
		return depAddress;
	}
	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}
	

}
