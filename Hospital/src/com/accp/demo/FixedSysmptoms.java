package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * FixedSysmptoms entity. @author MyEclipse Persistence Tools
 */

public class FixedSysmptoms implements java.io.Serializable {

	// Fields

	private Integer fsid;
	private Department department;
	private String sysmptoms;
	private Set fixedPrescriptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public FixedSysmptoms() {
	}

	/** minimal constructor */
	public FixedSysmptoms(Integer fsid, Department department, String sysmptoms) {
		this.fsid = fsid;
		this.department = department;
		this.sysmptoms = sysmptoms;
	}

	/** full constructor */
	public FixedSysmptoms(Integer fsid, Department department,
			String sysmptoms, Set fixedPrescriptions) {
		this.fsid = fsid;
		this.department = department;
		this.sysmptoms = sysmptoms;
		this.fixedPrescriptions = fixedPrescriptions;
	}

	// Property accessors

	public Integer getFsid() {
		return this.fsid;
	}

	public void setFsid(Integer fsid) {
		this.fsid = fsid;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSysmptoms() {
		return this.sysmptoms;
	}

	public void setSysmptoms(String sysmptoms) {
		this.sysmptoms = sysmptoms;
	}

	public Set getFixedPrescriptions() {
		return this.fixedPrescriptions;
	}

	public void setFixedPrescriptions(Set fixedPrescriptions) {
		this.fixedPrescriptions = fixedPrescriptions;
	}

}