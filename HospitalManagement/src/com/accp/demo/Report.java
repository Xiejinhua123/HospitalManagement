package com.accp.demo;

/**
 * �����
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public class Report {
	
	private String repId; // ������
	private String repAuthor; // �ύ��
	private String repReview; // �����Ա
	private String repCon; // ��������
	private String repReply; // �ظ�����
	private String repType; // ��������
	public Report() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
