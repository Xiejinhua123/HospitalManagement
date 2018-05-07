package com.accp.demo;

/**
 * DrugTime entity. @author MyEclipse Persistence Tools
 */

public class DrugTime implements java.io.Serializable {

	// Fields

	private Integer drugTimeId;
	private Drug drug;
	private String dates;
	private Integer drugNumber;
	private String drugProduction;
	private Integer drugExpiration;
	private Integer drugCount;

	// Constructors

	/** default constructor */
	public DrugTime() {
	}

	/** minimal constructor */
	public DrugTime(Integer drugTimeId, String dates, Integer drugNumber,
			String drugProduction, Integer drugExpiration, Integer drugCount) {
		this.drugTimeId = drugTimeId;
		this.dates = dates;
		this.drugNumber = drugNumber;
		this.drugProduction = drugProduction;
		this.drugExpiration = drugExpiration;
		this.drugCount = drugCount;
	}

	/** full constructor */
	public DrugTime(Integer drugTimeId, Drug drug, String dates,
			Integer drugNumber, String drugProduction, Integer drugExpiration,
			Integer drugCount) {
		this.drugTimeId = drugTimeId;
		this.drug = drug;
		this.dates = dates;
		this.drugNumber = drugNumber;
		this.drugProduction = drugProduction;
		this.drugExpiration = drugExpiration;
		this.drugCount = drugCount;
	}

	// Property accessors

	public Integer getDrugTimeId() {
		return this.drugTimeId;
	}

	public void setDrugTimeId(Integer drugTimeId) {
		this.drugTimeId = drugTimeId;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public Integer getDrugNumber() {
		return this.drugNumber;
	}

	public void setDrugNumber(Integer drugNumber) {
		this.drugNumber = drugNumber;
	}

	public String getDrugProduction() {
		return this.drugProduction;
	}

	public void setDrugProduction(String drugProduction) {
		this.drugProduction = drugProduction;
	}

	public Integer getDrugExpiration() {
		return this.drugExpiration;
	}

	public void setDrugExpiration(Integer drugExpiration) {
		this.drugExpiration = drugExpiration;
	}

	public Integer getDrugCount() {
		return this.drugCount;
	}

	public void setDrugCount(Integer drugCount) {
		this.drugCount = drugCount;
	}

}