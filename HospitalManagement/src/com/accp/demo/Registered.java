package com.accp.demo;

/**
 * �Һ���Ϣ��
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Registered {

	private int regId; // �Һű��
	private int patId; // ���߱��
	private String regTime; // �Һ�ʱ��
	private int depId; // ���ұ��
	private String docId; // ҽ�����
	private String regType; // �Һ����
	private double regPrice; // �ҺŽ�� 
	private int payState; // �Һ�֧��״̬
	private String regState; // ״̬
	private int isPay; // �ùҺŴ����Ƿ񸶿�
	public Registered() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
