package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Registered entity. @author MyEclipse Persistence Tools
 */

public class Registered implements java.io.Serializable {

	// Fields

	private String regId;
	private Users users;
	private Patient patient;
	private String appointmentTime;
	private String regTime;
	private Integer depId;
	private String regType;
	private Double regPrice;
	private Integer payState;
	private String regState;
	private Integer isPay;
	private Set doctorOffers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Registered() {
	}

	/** minimal constructor */
	public Registered(String regId, Patient patient, String regTime,
			Integer depId, String regType, Double regPrice, Integer payState,
			String regState) {
		this.regId = regId;
		this.patient = patient;
		this.regTime = regTime;
		this.depId = depId;
		this.regType = regType;
		this.regPrice = regPrice;
		this.payState = payState;
		this.regState = regState;
	}

	/** full constructor */
	public Registered(String regId, Users users, Patient patient,
			String appointmentTime, String regTime, Integer depId,
			String regType, Double regPrice, Integer payState, String regState,
			Integer isPay, Set doctorOffers) {
		this.regId = regId;
		this.users = users;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
		this.regTime = regTime;
		this.depId = depId;
		this.regType = regType;
		this.regPrice = regPrice;
		this.payState = payState;
		this.regState = regState;
		this.isPay = isPay;
		this.doctorOffers = doctorOffers;
	}

	// Property accessors

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getAppointmentTime() {
		return this.appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getRegTime() {
		return this.regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getRegType() {
		return this.regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public Double getRegPrice() {
		return this.regPrice;
	}

	public void setRegPrice(Double regPrice) {
		this.regPrice = regPrice;
	}

	public Integer getPayState() {
		return this.payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public String getRegState() {
		return this.regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public Integer getIsPay() {
		return this.isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Set getDoctorOffers() {
		return this.doctorOffers;
	}

	public void setDoctorOffers(Set doctorOffers) {
		this.doctorOffers = doctorOffers;
	}

}