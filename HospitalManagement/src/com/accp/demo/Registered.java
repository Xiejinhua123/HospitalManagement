package com.accp.demo;

/**
 * 挂号信息表
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Registered {

	private int regId; // 挂号编号
	private int patId; // 患者编号
	private String regTime; // 挂号时间
	private int depId; // 科室编号
	private String docId; // 医生编号
	private String regType; // 挂号类别
	private double regPrice; // 挂号金额 
	private int payState; // 挂号支付状态
	private String regState; // 状态
	private int isPay; // 该挂号处方是否付款
	public Registered() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Registered(int regId, int patId, String regTime, int depId,
			String docId, String regType, double regPrice, int payState, String regState,
			int isPay) {
		super();
		this.regId = regId;
		this.patId = patId;
		this.regTime = regTime;
		this.depId = depId;
		this.docId = docId;
		this.regType = regType;
		this.regPrice = regPrice;
		this.payState = payState;
		this.regState = regState;
		this.isPay = isPay;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public double getRegPrice() {
		return regPrice;
	}
	public void setRegPrice(double regPrice) {
		this.regPrice = regPrice;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	
	
	
}
