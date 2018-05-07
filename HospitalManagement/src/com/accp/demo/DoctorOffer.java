package com.accp.demo;

/**
 * 就诊表
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.13
 *
 */
public class DoctorOffer {

	private int dOId;//就诊编号
	private String docId;//医生编号
	private int regId;//挂号编号
	private String sympton;//症状信息
	
	public int getdOId() {
		return dOId;
	}
	public void setdOId(int dOId) {
		this.dOId = dOId;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getSympton() {
		return sympton;
	}
	public void setSympton(String sympton) {
		this.sympton = sympton;
	}
	public DoctorOffer(int dOId, String docId, int regId, String sympton) {
		super();
		this.dOId = dOId;
		this.docId = docId;
		this.regId = regId;
		this.sympton = sympton;
	}
	public DoctorOffer(String docId, int regId, String sympton) {
		super();
		this.docId = docId;
		this.regId = regId;
		this.sympton = sympton;
	}
	public DoctorOffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
