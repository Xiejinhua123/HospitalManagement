package com.accp.demo;

public class Specialist {

	private int sepId;
	private int depId;
	private String docId;
	private String dateTime;
	
	public Specialist() {
		// TODO 自动生成的构造函数存根
	}

	public Specialist(int sepId, int depId, String docId, String dateTime) {
		super();
		this.sepId = sepId;
		this.depId = depId;
		this.docId = docId;
		this.dateTime = dateTime;
	}

	public int getSepId() {
		return sepId;
	}

	public void setSepId(int sepId) {
		this.sepId = sepId;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	

}
