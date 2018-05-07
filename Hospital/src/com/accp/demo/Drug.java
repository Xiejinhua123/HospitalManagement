package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Drug entity. @author MyEclipse Persistence Tools
 */

public class Drug implements java.io.Serializable {

	// Fields

	private Integer drugId;
	private String drugName; // 名称  全名
	private String drugAlias; // 别名  简单名称
	private String drugShape; // 剂型
	private Integer number; // 剩余总量，数据库中不含有该项信息
	private String drugType;
	private String drugSymptom;
	private String drugBigUnit;
	private String drugSmallUnit;
	private String specification;
	private Double drugPrice;
	private String drugConsumption;
	private String attention;
	private Set prescriptions = new HashSet(0);
	private Set fixedPrescriptions = new HashSet(0);
	private Set drugTimes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Drug() {
	}

	/** minimal constructor */
	public Drug(Integer drugId) {
		this.drugId = drugId;
	}

	/** full constructor */
	public Drug(Integer drugId, String drugName, String drugAlias,
			String drugShape, String drugType, String drugSymptom,
			String drugBigUnit, String drugSmallUnit, String specification,
			Double drugPrice, String drugConsumption, String attention,
			Set prescriptions, Set fixedPrescriptions, Set drugTimes) {
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugAlias = drugAlias;
		this.drugShape = drugShape;
		this.drugType = drugType;
		this.drugSymptom = drugSymptom;
		this.drugBigUnit = drugBigUnit;
		this.drugSmallUnit = drugSmallUnit;
		this.specification = specification;
		this.drugPrice = drugPrice;
		this.drugConsumption = drugConsumption;
		this.attention = attention;
		this.prescriptions = prescriptions;
		this.fixedPrescriptions = fixedPrescriptions;
		this.drugTimes = drugTimes;
	}

	// Property accessors

	public Integer getDrugId() {
		return this.drugId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugAlias() {
		return this.drugAlias;
	}

	public void setDrugAlias(String drugAlias) {
		this.drugAlias = drugAlias;
	}

	public String getDrugShape() {
		return this.drugShape;
	}

	public void setDrugShape(String drugShape) {
		this.drugShape = drugShape;
	}

	public String getDrugType() {
		return this.drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getDrugSymptom() {
		return this.drugSymptom;
	}

	public void setDrugSymptom(String drugSymptom) {
		this.drugSymptom = drugSymptom;
	}

	public String getDrugBigUnit() {
		return this.drugBigUnit;
	}

	public void setDrugBigUnit(String drugBigUnit) {
		this.drugBigUnit = drugBigUnit;
	}

	public String getDrugSmallUnit() {
		return this.drugSmallUnit;
	}

	public void setDrugSmallUnit(String drugSmallUnit) {
		this.drugSmallUnit = drugSmallUnit;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Double getDrugPrice() {
		return this.drugPrice;
	}

	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}

	public String getDrugConsumption() {
		return this.drugConsumption;
	}

	public void setDrugConsumption(String drugConsumption) {
		this.drugConsumption = drugConsumption;
	}

	public String getAttention() {
		return this.attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Set getFixedPrescriptions() {
		return this.fixedPrescriptions;
	}

	public void setFixedPrescriptions(Set fixedPrescriptions) {
		this.fixedPrescriptions = fixedPrescriptions;
	}

	public Set getDrugTimes() {
		return this.drugTimes;
	}

	public void setDrugTimes(Set drugTimes) {
		this.drugTimes = drugTimes;
	}

}