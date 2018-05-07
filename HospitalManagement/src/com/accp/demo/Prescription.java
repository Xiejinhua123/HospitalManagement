package com.accp.demo;

/**
 * 处方表
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Prescription {
	
	private int doId; // 就诊编号
	private int drugId; // 药品编号
	private String drugName; // 药品名称
	private int drugNum; // 药品数量
	private Double drugPrice; // 单价
	
	public Double getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDoId() {
		return doId;
	}
	public void setDoId(int doId) {
		this.doId = doId;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public int getDrugNum() {
		return drugNum;
	}
	public void setDrugNum(int drugNum) {
		this.drugNum = drugNum;
	}
	public Prescription(int doId, int drugId, int drugNum) {
		super();
		this.doId = doId;
		this.drugId = drugId;
		this.drugNum = drugNum;
	}
	public Prescription() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
