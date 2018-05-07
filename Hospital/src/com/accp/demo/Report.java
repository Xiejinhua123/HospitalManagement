package com.accp.demo;

/**
 * Report entity. @author MyEclipse Persistence Tools
 */

public class Report implements java.io.Serializable {

	// Fields

	private String repId;
	private Users usersByRepReview;
	private Users usersByRepAuthor;
	private String reportTime;
	private String repCon;
	private String repReply;
	private String replyTime;
	private String repType;

	// Constructors

	/** default constructor */
	public Report() {
	}

	/** minimal constructor */
	public Report(String repId, Users usersByRepReview, Users usersByRepAuthor,
			String reportTime, String repCon, String repType) {
		this.repId = repId;
		this.usersByRepReview = usersByRepReview;
		this.usersByRepAuthor = usersByRepAuthor;
		this.reportTime = reportTime;
		this.repCon = repCon;
		this.repType = repType;
	}

	/** full constructor */
	public Report(String repId, Users usersByRepReview, Users usersByRepAuthor,
			String reportTime, String repCon, String repReply,
			String replyTime, String repType) {
		this.repId = repId;
		this.usersByRepReview = usersByRepReview;
		this.usersByRepAuthor = usersByRepAuthor;
		this.reportTime = reportTime;
		this.repCon = repCon;
		this.repReply = repReply;
		this.replyTime = replyTime;
		this.repType = repType;
	}

	// Property accessors

	public String getRepId() {
		return this.repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}

	public Users getUsersByRepReview() {
		return this.usersByRepReview;
	}

	public void setUsersByRepReview(Users usersByRepReview) {
		this.usersByRepReview = usersByRepReview;
	}

	public Users getUsersByRepAuthor() {
		return this.usersByRepAuthor;
	}

	public void setUsersByRepAuthor(Users usersByRepAuthor) {
		this.usersByRepAuthor = usersByRepAuthor;
	}

	public String getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getRepCon() {
		return this.repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	public String getRepReply() {
		return this.repReply;
	}

	public void setRepReply(String repReply) {
		this.repReply = repReply;
	}

	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getRepType() {
		return this.repType;
	}

	public void setRepType(String repType) {
		this.repType = repType;
	}

}