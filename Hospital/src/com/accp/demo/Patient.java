package com.accp.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

import com.accp.bizimpl.PatientBizImpl;
import com.accp.util.Generate;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */

public class Patient implements java.io.Serializable,HttpSessionBindingListener {

	// Fields

	private Integer patId;
	private String patPassword;
	private String patName;
	private String patCard;
	private String patSex;
	private Date patBirthday;
	private Integer age;
	private String patPhone;
	private String patAddress;
	private String patSymotoms;
	private String geneticDisorders;
	private String onlineState;
	private Date createTime;
	private Date modifyTime;
	private Date lastLogin;
	private Set registereds = new HashSet(0);

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(Integer patId, String patPassword, String onlineState,
			Date createTime) {
		this.patId = patId;
		this.patPassword = patPassword;
		this.onlineState = onlineState;
		this.createTime = createTime;
	}

	/** full constructor */
	public Patient(Integer patId, String patPassword,
			String patName, String patCard, String patSex, Date patBirthday,
			String patPhone, String patAddress, String patSymotoms,
			String geneticDisorders, String onlineState, Date createTime,
			Date modifyTime, Date lastLogin, Set registereds) {
		this.patId = patId;
		this.patPassword = patPassword;
		this.patName = patName;
		this.patCard = patCard;
		this.patSex = patSex;
		this.patBirthday = patBirthday;
		this.patPhone = patPhone;
		this.patAddress = patAddress;
		this.patSymotoms = patSymotoms;
		this.geneticDisorders = geneticDisorders;
		this.onlineState = onlineState;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.lastLogin = lastLogin;
		this.registereds = registereds;
	}

	// Property accessors

	public Integer getPatId() {
		return this.patId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setPatId(Integer patId) {
		this.patId = patId;
	}

	public String getPatPassword() {
		return this.patPassword;
	}

	public void setPatPassword(String patPassword) {
		this.patPassword = patPassword;
	}

	public String getPatName() {
		return this.patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatCard() {
		return this.patCard;
	}

	public void setPatCard(String patCard) {
		this.patCard = patCard;
	}

	public String getPatSex() {
		return this.patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public Date getPatBirthday() {
		return this.patBirthday;
	}

	public void setPatBirthday(Date patBirthday) {
		try {
			this.age = Generate.getAge(patBirthday);
		} catch (IllegalAccessException e) {
			this.age = 0;
		}
		this.patBirthday = patBirthday;
	}

	public String getPatPhone() {
		return this.patPhone;
	}

	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}

	public String getPatAddress() {
		return this.patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	public String getPatSymotoms() {
		return this.patSymotoms;
	}

	public void setPatSymotoms(String patSymotoms) {
		this.patSymotoms = patSymotoms;
	}

	public String getGeneticDisorders() {
		return this.geneticDisorders;
	}

	public void setGeneticDisorders(String geneticDisorders) {
		this.geneticDisorders = geneticDisorders;
	}

	public String getOnlineState() {
		return this.onlineState;
	}

	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Set getRegistereds() {
		return this.registereds;
	}

	public void setRegistereds(Set registereds) {
		this.registereds = registereds;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		/**
		 * 录后将当前的累的实体对象放入session<br/>
		 * 该实现方法将监听session中该对象的状态<br/>
		 * 放入session修改在线状态
		 */
		try {
			this.setOnlineState("1001");
			new PatientBizImpl().update(this);
		} catch (Exception e) {
			Logger.getLogger(Patient.class).error("Patient修改在线状态报错！");;
		}
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		try {
			this.setOnlineState("1002");
			Date d=new Date();
			SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-DD");
			this.setLastLogin(d);
			new PatientBizImpl().update(this);
		} catch (Exception e) {
			Logger.getLogger(Patient.class).error("Patient修改离线状态报错！");;
		}
	}
}