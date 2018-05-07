package com.accp.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

import com.accp.bizimpl.UserBizImpl;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable,HttpSessionBindingListener {

	// Fields
	@JSONField(serialize=false)
	
	private String usersId;
	private Department department;
	private String userPassword;
	private String onlineState;
	private Date createTime;
	private Date modifyTime;
	private Date lastLogin;
	private String trueName;
	private String idCard;
	private String docSex;
	private Date docBirthday;
	private String schoolRecord;
	private String telePhone;
	private String officePhone;
	private String onjobState;
	private String email;
	private String isSpecialist;
	private String duty;
	private Set userRoles = new HashSet(0);
	private Set reportsForRepAuthor = new HashSet(0);
	private Set reportsForRepReview = new HashSet(0);
	private Set doctorOffers = new HashSet(0);
	private Set registereds = new HashSet(0);
	

public Users(){}
	public Users(String usersId, Department department, String userPassword, String onlineState, Date createTime,
			Date modifyTime, Date lastLogin, String trueName, String idCard, String docSex, Date docBirthday,
			String schoolRecord, String telePhone, String officePhone, String onjobState, String email,
			String isSpecialist, String duty, Set userRoles, Set reportsForRepAuthor, Set reportsForRepReview,
			Set doctorOffers, Set registereds) {
		super();
		this.usersId = usersId;
		this.department = department;
		this.userPassword = userPassword;
		this.onlineState = onlineState;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.lastLogin = lastLogin;
		this.trueName = trueName;
		this.idCard = idCard;
		this.docSex = docSex;
		this.docBirthday = docBirthday;
		this.schoolRecord = schoolRecord;
		this.telePhone = telePhone;
		this.officePhone = officePhone;
		this.onjobState = onjobState;
		this.email = email;
		this.isSpecialist = isSpecialist;
		this.duty = duty;
		this.userRoles = userRoles;
		this.reportsForRepAuthor = reportsForRepAuthor;
		this.reportsForRepReview = reportsForRepReview;
		this.doctorOffers = doctorOffers;
		this.registereds = registereds;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getDocSex() {
		return docSex;
	}

	public void setDocSex(String docSex) {
		this.docSex = docSex;
	}

	public Date getDocBirthday() {
		return docBirthday;
	}

	public void setDocBirthday(Date docBirthday) {
		this.docBirthday = docBirthday;
	}

	public String getSchoolRecord() {
		return schoolRecord;
	}

	public void setSchoolRecord(String schoolRecord) {
		this.schoolRecord = schoolRecord;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOnjobState() {
		return onjobState;
	}

	public void setOnjobState(String onjobState) {
		this.onjobState = onjobState;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsSpecialist() {
		return isSpecialist;
	}

	public void setIsSpecialist(String isSpecialist) {
		this.isSpecialist = isSpecialist;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public Set getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public Set getReportsForRepAuthor() {
		return reportsForRepAuthor;
	}

	public void setReportsForRepAuthor(Set reportsForRepAuthor) {
		this.reportsForRepAuthor = reportsForRepAuthor;
	}

	public Set getReportsForRepReview() {
		return reportsForRepReview;
	}

	public void setReportsForRepReview(Set reportsForRepReview) {
		this.reportsForRepReview = reportsForRepReview;
	}

	public Set getDoctorOffers() {
		return doctorOffers;
	}

	public void setDoctorOffers(Set doctorOffers) {
		this.doctorOffers = doctorOffers;
	}

	public Set getRegistereds() {
		return registereds;
	}

	public void setRegistereds(Set registereds) {
		this.registereds = registereds;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		Logger.getLogger(Users.class).error("监听开始");
		try {
			this.setOnlineState("1001");
			Date d=new Date();
			this.setLastLogin(d);
			new UserBizImpl().update(this);
		} catch (Exception e) {
			Logger.getLogger(Users.class).error("User修改在线状态报错！");;
		}
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		Logger.getLogger(Users.class).error("结束监听");
		try {
			this.setOnlineState("1002");
			Logger.getLogger(Users.class).error(this.trueName);
			new UserBizImpl().update(this);
		} catch (Exception e) {
			Logger.getLogger(Users.class).error("User修改离线状态报错！");
		}
	}

}