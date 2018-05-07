package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.accp.util.HibernateUtil;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Department implements java.io.Serializable {

	// Fields

	private Integer depId;
	private String depName;
	private String depAddress;
	private Set fixedSysmptomses = new HashSet(0);
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer depId, String depName, String depAddress) {
		this.depId = depId;
		this.depName = depName;
		this.depAddress = depAddress;
	}

	/** full constructor */
	public Department(Integer depId, String depName, String depAddress,
			Set fixedSysmptomses, Set userses) {
		this.depId = depId;
		this.depName = depName;
		this.depAddress = depAddress;
		this.fixedSysmptomses = fixedSysmptomses;
		this.userses = userses;
	}

	// Property accessors

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {

		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepAddress() {
		return this.depAddress;
	}

	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}

	public Set getFixedSysmptomses() {
		return this.fixedSysmptomses;
	}

	public void setFixedSysmptomses(Set fixedSysmptomses) {
		this.fixedSysmptomses = fixedSysmptomses;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}