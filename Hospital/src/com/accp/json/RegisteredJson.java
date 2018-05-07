package com.accp.json;

/**
 * 科室
 * @author xueshe01
 *
 */
public class RegisteredJson {
	
	private String doctorName;
	private String depName;
	private String depAddress;
	private String regId;
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepAddress() {
		return depAddress;
	}
	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public RegisteredJson(String doctorName, String depName, String depAddress, String regId) {
		super();
		this.doctorName = doctorName;
		this.depName = depName;
		this.depAddress = depAddress;
		this.regId = regId;
	}
	public RegisteredJson() {
		super();
	}

	
}
