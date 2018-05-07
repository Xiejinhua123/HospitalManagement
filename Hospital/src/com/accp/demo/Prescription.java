package com.accp.demo;

/**
 * Prescription entity. @author MyEclipse Persistence Tools
 */

/**
 * 处方表
 * @author xueshe01
 *
 */
@SuppressWarnings("serial")
public class Prescription implements java.io.Serializable {
	// Fields
	private Integer preId; // 编号
	private DoctorOffer doctorOffer; // 就诊信息
	private Drug drug; // 药品信息
	private Integer drugNum; // 药品数量
	private String drugUnit; // 单位

	// Constructors

	/** default constructor */
	public Prescription() {
	}

	/** full constructor */
	public Prescription(Integer preId, DoctorOffer doctorOffer, Drug drug,
			Integer drugNum, String drugUnit) {
		this.preId = preId;
		this.doctorOffer = doctorOffer;
		this.drug = drug;
		this.drugNum = drugNum;
		this.drugUnit = drugUnit;
	}

	// Property accessors

	public Integer getPreId() {
		return this.preId;
	}

	public void setPreId(Integer preId) {
		this.preId = preId;
	}

	public DoctorOffer getDoctorOffer() {
		return this.doctorOffer;
	}

	public void setDoctorOffer(DoctorOffer doctorOffer) {
		this.doctorOffer = doctorOffer;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Integer getDrugNum() {
		return this.drugNum;
	}

	public void setDrugNum(Integer drugNum) {
		this.drugNum = drugNum;
	}

	public String getDrugUnit() {
		return this.drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}

}