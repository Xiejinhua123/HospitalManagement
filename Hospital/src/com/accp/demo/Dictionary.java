package com.accp.demo;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */

public class Dictionary implements java.io.Serializable {

	// Fields

	private Integer dicId;
	private String typeCode;
	private String typeName;
	private String typeValus;
	private Integer isVisible;
	private String memo;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** minimal constructor */
	public Dictionary(Integer dicId, String typeCode) {
		this.dicId = dicId;
		this.typeCode = typeCode;
	}

	/** full constructor */
	public Dictionary(Integer dicId, String typeCode, String typeName,
			String typeValus, Integer isVisible, String memo) {
		this.dicId = dicId;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.typeValus = typeValus;
		this.isVisible = isVisible;
		this.memo = memo;
	}

	// Property accessors

	public Integer getDicId() {
		return this.dicId;
	}

	public void setDicId(Integer dicId) {
		this.dicId = dicId;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeValus() {
		return this.typeValus;
	}

	public void setTypeValus(String typeValus) {
		this.typeValus = typeValus;
	}

	public Integer getIsVisible() {
		return this.isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}