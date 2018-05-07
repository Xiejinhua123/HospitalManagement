package com.accp.demo;

import java.util.List;

/**
 * 	数据字典表
 * 	在程序运行前，执行操作，查找所有数据库应用字段
 * 
 * @author 解金化
 * 	@version 1.0
 * 	
 * 2017.3.8
 * 
 */
public class Dictionary {
	
	private String typeName; // 字段名称
	private String typeCode; // 字段编码
	private List<String> typeValus; // 字段值
	private Integer isVisible; // 是否可见
	private String momo; // 备注
	public Dictionary() {
		super();
		// TODO 自动生成的构造函数存根
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
