package com.accp.demo;

/**
 * 新闻表
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public class News {

	private String newId;//新闻编号
	private String newType;//新闻类型
	private String newTitle;//新闻标题
	private String newSubtitle;//副标题
	private String newCon;//新闻正文
	private String newDate;//新闻时间
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewSubtitle() {
		return newSubtitle;
	}
	public void setNewSubtitle(String newSubtitle) {
		this.newSubtitle = newSubtitle;
	}
	public String getNewCon() {
		return newCon;
	}
	public void setNewCon(String newCon) {
		this.newCon = newCon;
	}
	public String getNewDate() {
		return newDate;
	}
	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}
	public News(String newId, String newType, String newTitle,
			String newSubtitle, String newCon, String newDate) {
		super();
		this.newId = newId;
		this.newType = newType;
		this.newTitle = newTitle;
		this.newSubtitle = newSubtitle;
		this.newCon = newCon;
		this.newDate = newDate;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
