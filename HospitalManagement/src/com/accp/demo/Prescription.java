package com.accp.demo;

/**
 * ������
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Prescription {
	
	private int doId; // ������
	private int drugId; // ҩƷ���
	private String drugName; // ҩƷ����
	private int drugNum; // ҩƷ����
	private Double drugPrice; // ����
	
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
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
