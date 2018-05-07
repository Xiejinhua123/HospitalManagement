package com.accp.json;

/**
 * 挂号成功
 * @author xueshe01
 *
 */
public class RegJson {
	
	private String regId;
	private Integer patId;
	private String patName;
	
	public RegJson() {
		super();
	}
	public RegJson(String regId, Integer patId, String patName) {
		super();
		this.regId = regId;
		this.patId = patId;
		this.patName = patName;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Integer getPatId() {
		return patId;
	}
	public void setPatId(Integer patId) {
		this.patId = patId;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}

}
