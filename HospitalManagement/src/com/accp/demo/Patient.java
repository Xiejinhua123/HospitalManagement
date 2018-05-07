package com.accp.demo;

import com.accp.tools.GenerateId;

/**
 * ������Ϣ��
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.03.08
 *
 *	@version 1.0 
 */
public class Patient {

	private int patId;//���߱��
	private String patNickname;//�û���
	private String patPassword;//����
	private String patName;//��������
	private String patCard;//���֤��
	private String patSex;//�Ա�
	private String patBirthday;//����
	private String patPhone;//�绰
	private String patAddress;//��ַ
	private String patSymotoms;//����֢״
	private String geneticDisorders;//�Ŵ���ʷ
	private int age; // ����
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getPatNickname() {
		if(this.patNickname == null || this.patNickname.equals("")){
			return "�����ǳ�";
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
			return "��������";
		else
			return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPatCard() {
		if(patCard == null || patCard.equals(""))
			return "����ʡ��֤��Ϣ";
		else
			return patCard;
	}
	public void setPatCard(String patCard) {
		this.patCard = patCard;
	}
	public String getPatSex() {
		if(patSex == null)
			return "�����Ա���Ϣ";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		this.patBirthday = patBirthday;
	}
	public String getPatPhone() {
		if(patPhone == null || patPhone.equals(""))
			return "�����ֻ���Ϣ";
		else
			return patPhone;
	}
	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}
	public String getPatAddress() {
		if(patAddress == null || patAddress.equals(""))
			return "���޵�ַ��Ϣ";
		else
			return patAddress;
	}
	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}
	public String getPatSymotoms() {
		if(patSymotoms == null || patSymotoms.equals(""))
			return "���޹�����Ϣ";
		else
			return patSymotoms;
	}
	public void setPatSymotoms(String patSymotoms) {
		this.patSymotoms = patSymotoms;
	}
	public String getGeneticDisorders() {
		if(geneticDisorders == null || geneticDisorders.equals(""))
			return "�����Ŵ���ʷ";
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
