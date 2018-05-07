package com.accp.demo;

/**
 * 药品表
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Drug {

	private int drugId;//药品编号
	private String drugName;//药品名称
	private String drugAlias;//曾用名
	private String drugShape;//剂型
	private String drugType;//药品类别
	private int drugNumber;//库存
	private Double drugPrice;//药品价格
	private String drugConsumption;//用法用量
	private String attention;//注意事项
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
