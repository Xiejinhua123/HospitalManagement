package com.accp.demo;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer newId;
	private String newType;
	private String newTitle;
	private String newSubtitle;
	private String newCon;
	private String newDate;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Integer newId, String newType, String newTitle,
			String newSubtitle, String newCon, String newDate) {
		this.newId = newId;
		this.newType = newType;
		this.newTitle = newTitle;
		this.newSubtitle = newSubtitle;
		this.newCon = newCon;
		this.newDate = newDate;
	}

	// Property accessors

	public Integer getNewId() {
		return this.newId;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
	}

	public String getNewType() {
		return this.newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public String getNewTitle() {
		return this.newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewSubtitle() {
		return this.newSubtitle;
	}

	public void setNewSubtitle(String newSubtitle) {
		this.newSubtitle = newSubtitle;
	}

	public String getNewCon() {
		return this.newCon;
	}

	public void setNewCon(String newCon) {
		this.newCon = newCon;
	}

	public String getNewDate() {
		return this.newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}

}