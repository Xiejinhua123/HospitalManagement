package com.accp.demo;

import java.util.List;

/**
 * 	�����ֵ��
 * 	�ڳ�������ǰ��ִ�в����������������ݿ�Ӧ���ֶ�
 * 
 * @author ���
 * 	@version 1.0
 * 	
 * 2017.3.8
 * 
 */
public class Dictionary {
	
	private String typeName; // �ֶ�����
	private String typeCode; // �ֶα���
	private List<String> typeValus; // �ֶ�ֵ
	private Integer isVisible; // �Ƿ�ɼ�
	private String momo; // ��ע
	public Dictionary() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Dictionary(String typeName, String typeCode, List<String> typeValus,
			Integer isVisible, String momo) {
		super();
		this.typeName = typeName;
		this.typeCode = typeCode;
		this.typeValus = typeValus;
		this.isVisible = isVisible;
		this.momo = momo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public List<String> getTypeValus() {
		return typeValus;
	}
	public void setTypeValus(List<String> typeValus) {
		this.typeValus = typeValus;
	}
	public Integer getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	public String getMomo() {
		return momo;
	}
	public void setMomo(String momo) {
		this.momo = momo;
	}
	
}
