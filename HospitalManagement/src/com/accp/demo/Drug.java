package com.accp.demo;

/**
 * ҩƷ��
 * 
 * @author ���
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Drug {

	private int drugId;//ҩƷ���
	private String drugName;//ҩƷ����
	private String drugAlias;//������
	private String drugShape;//����
	private String drugType;//ҩƷ���
	private int drugNumber;//���
	private Double drugPrice;//ҩƷ�۸�
	private String drugConsumption;//�÷�����
	private String attention;//ע������
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugAlias() {
		return drugAlias;
	}
	public void setDrugAlias(String drugAlias) {
		this.drugAlias = drugAlias;
	}
	public String getDrugShape() {
		return drugShape;
	}
	public void setDrugShape(String drugShape) {
		this.drugShape = drugShape;
	}
	public String getDrugType() {
		return drugType;
	}
	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
	public int getDrugNumber() {
		return drugNumber;
	}
	public void setDrugNumber(int drugNumber) {
		this.drugNumber = drugNumber;
	}
	public Double getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}
	public String getDrugConsumption() {
		return drugConsumption;
	}
	public void setDrugConsumption(String drugConsumption) {
		this.drugConsumption = drugConsumption;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public Drug(int drugId, String drugName, String drugAlias,
			String drugShape, String drugType, int drugNumber,
			Double drugPrice, String drugConsumption, String attention) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugAlias = drugAlias;
		this.drugShape = drugShape;
		this.drugType = drugType;
		this.drugNumber = drugNumber;
		this.drugPrice = drugPrice;
		this.drugConsumption = drugConsumption;
		this.attention = attention;
	}
	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
