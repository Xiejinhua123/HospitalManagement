package com.accp.demo;

/**
 * FixedPrescription entity. @author MyEclipse Persistence Tools
 */

public class FixedPrescription implements java.io.Serializable {

	// Fields

	private Integer fpid;
	private FixedSysmptoms fixedSysmptoms;
	private Drug drug;

	// Constructors

	/** default constructor */
	public FixedPrescription() {
	}

	/** full constructor */
	public FixedPrescription(Integer fpid, FixedSysmptoms fixedSysmptoms,
			Drug drug) {
		this.fpid = fpid;
		this.fixedSysmptoms = fixedSysmptoms;
		this.drug = drug;
	}

	// Property accessors

	public Integer getFpid() {
		return this.fpid;
	}

	public void setFpid(Integer fpid) {
		this.fpid = fpid;
	}

	public FixedSysmptoms getFixedSysmptoms() {
		return this.fixedSysmptoms;
	}

	public void setFixedSysmptoms(FixedSysmptoms fixedSysmptoms) {
		this.fixedSysmptoms = fixedSysmptoms;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

}