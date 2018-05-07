package com.accp.demo;

/**
 * 科室类
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Department {
	
	private int depId; // 科室编号
	private String depName; // 科室名称
	private String depAddress; // 科室地址
	public Department() {
		super();
		// TODO 自动生成的构造函数存根
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
