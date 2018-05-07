package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

import com.accp.util.Page;

/**
 * 就诊
 */
public class DoctorOffer implements java.io.Serializable {

	// Fields
	private Integer doid;
	private Users users;
	private Registered registered;
	private String symptom;
	private String comment;
	private Set prescriptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public DoctorOffer() {
	}

	/** minimal constructor */
	public DoctorOffer(Integer doid) {
		this.doid = doid;
	}

	/** full constructor */
	public DoctorOffer(Integer doid, Users users, Registered registered,
			String symptom, Set prescriptions) {
		this.doid = doid;
		this.users = users;
		this.registered = registered;
		this.symptom = symptom;
		this.prescriptions = prescriptions;
	}

	// Property accessors

	public Integer getDoid() {
		return this.doid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDoid(Integer doid) {
		this.doid = doid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Registered getRegistered() {
		return this.registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

}