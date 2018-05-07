package com.accp.demo;

import com.accp.tools.GenerateId;

/**
 * 患者信息表
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.03.08
 *
 *	@version 1.0 
 */
public class Patient {

	private int patId;//患者编号
	private String patNickname;//用户名
	private String patPassword;//密码
	private String patName;//患者姓名
	private String patCard;//身份证号
	private String patSex;//性别
	private String patBirthday;//生日
	private String patPhone;//电话
	private String patAddress;//地址
	private String patSymotoms;//过敏症状
	private String geneticDisorders;//遗传病史
	private int age; // 年龄
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getPatNickname() {
		if(this.patNickname == null || this.patNickname.equals("")){
			return "暂无昵称";
		}else
			return patNickname;
	}
	public void setPatNickname(String patNickname) {
		this.patNickname = patNickname;
	}
	public String getPatPassword() {
		return patPassword;
	}
	public void setPatPassword(String patPassword) {
		this.patPassword = patPassword;
	}
	public String getPatName() {
		if(patName == null || patName.equals(""))
			return "暂无姓名";
		else
			return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPatCard() {
		if(patCard == null || patCard.equals(""))
			return "暂无省份证信息";
		else
			return patCard;
	}
	public void setPatCard(String patCard) {
		this.patCard = patCard;
	}
	public String getPatSex() {
		if(patSex == null)
			return "暂无性别信息";
		else
			return patSex;
	}
	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}
	public String getPatBirthday() {
		return patBirthday;
	}
	public void setPatBirthday(String patBirthday) {
		try {
			this.age=GenerateId.getAge(patBirthday);
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.patBirthday = patBirthday;
	}
	public String getPatPhone() {
		if(patPhone == null || patPhone.equals(""))
			return "暂无手机信息";
		else
			return patPhone;
	}
	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}
	public String getPatAddress() {
		if(patAddress == null || patAddress.equals(""))
			return "暂无地址信息";
		else
			return patAddress;
	}
	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}
	public String getPatSymotoms() {
		if(patSymotoms == null || patSymotoms.equals(""))
			return "暂无过敏信息";
		else
			return patSymotoms;
	}
	public void setPatSymotoms(String patSymotoms) {
		this.patSymotoms = patSymotoms;
	}
	public String getGeneticDisorders() {
		if(geneticDisorders == null || geneticDisorders.equals(""))
			return "暂无遗传病史";
		else
			return geneticDisorders;
	}
	public void setGeneticDisorders(String geneticDisorders) {
		this.geneticDisorders = geneticDisorders;
	}
	public int getAge(){
		return age;
	}
	public Patient(int patId, String patNickname, String patPassword,
			String patName, String patCard, String patSex, String patBirthday,
			String patPhone, String patAddress, String patSymotoms,
			String geneticDisorders) {
		super();
		this.patId = patId;
		this.patNickname = patNickname;
		this.patPassword = patPassword;
		this.patName = patName;
		this.patCard = patCard;
		this.patSex = patSex;
		this.patBirthday = patBirthday;
		this.patPhone = patPhone;
		this.patAddress = patAddress;
		this.patSymotoms = patSymotoms;
		this.geneticDisorders = geneticDisorders;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
