package com.accp.demo;

/**
 * �̶�֢״��
 * @author ���
 *	@version 1.0
 *	
 *2017.03.08
 *
 */
public class FixedSysmptoms {

	private int fSId;//�̶�֢״���
	private String sysmptoms;//�̶�֢״
	public int getfSId() {
		return fSId;
	}
	public void setfSId(int fSId) {
		this.fSId = fSId;
	}
	public String getSysmptoms() {
		return sysmptoms;
	}
	public void setSysmptoms(String sysmptoms) {
		this.sysmptoms = sysmptoms;
	}
	public FixedSysmptoms(int fSId, String sysmptoms) {
		super();
		this.fSId = fSId;
		this.sysmptoms = sysmptoms;
	}
	public FixedSysmptoms() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
