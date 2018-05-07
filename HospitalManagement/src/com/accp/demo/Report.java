package com.accp.demo;

/**
 * 报表表
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public class Report {
	
	private String repId; // 报表编号
	private String repAuthor; // 提交人
	private String repReview; // 审查人员
	private String repCon; // 报表内容
	private String repReply; // 回复内容
	private String repType; // 报表类型
	public Report() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Report(String repId, String repAuthor, String repReview,
			String repCon, String repReply, String repType) {
		super();
		this.repId = repId;
		this.repAuthor = repAuthor;
		this.repReview = repReview;
		this.repCon = repCon;
		this.repReply = repReply;
		this.repType = repType;
	}
	public String getRepId() {
		return repId;
	}
	public void setRepId(String repId) {
		this.repId = repId;
	}
	public String getRepAuthor() {
		return repAuthor;
	}
	public void setRepAuthor(String repAuthor) {
		this.repAuthor = repAuthor;
	}
	public String getRepReview() {
		return repReview;
	}
	public void setRepReview(String repReview) {
		this.repReview = repReview;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public String getRepReply() {
		return repReply;
	}
	public void setRepReply(String repReply) {
		this.repReply = repReply;
	}
	public String getRepType() {
		return repType;
	}
	public void setRepType(String repType) {
		this.repType = repType;
	}
	
}
