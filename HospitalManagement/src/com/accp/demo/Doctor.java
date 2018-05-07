package com.accp.demo;

/**
 * 医生类
 * 
 * @author 解金化
 *@version 1.0
 *
 *	2017.03.08
 */
public class Doctor {

	private String docId;//医生编号
	private String trueName;//真实姓名
	private String idCard;//身份证号
	private String docSex;//医生性别
	private String docBirthday;//生日
	private String schoolRecord;//学历
	private String telePhone;//电话号码
	private String officePhone;//办公室电话
	private String onjobState;//在职状态
	private String email;//邮箱
	private int departmentId;//部门ID
	private String duty; // 职务
		
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String docId, String trueName, String idCard, String docSex,
			String docBirthday, String schoolRecord, String telePhone,
			String officePhone, String onjobState, String email,
			int departmentId,String duty) {
		super();
		this.docId = docId;
		this.trueName = trueName;
		this.idCard = idCard;
		this.docSex = docSex;
		this.docBirthday = docBirthday;
		this.schoolRecord = schoolRecord;
		this.telePhone = telePhone;
		this.officePhone = officePhone;
		this.onjobState = onjobState;
		this.email = email;
		this.departmentId = departmentId;
		this.duty = duty;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
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
	public String getDocBirthday() {
		return docBirthday;
	}
	public void setDocBirthday(String docBirthday) {
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
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
}
