package com.accp.json;

public class UserJson {
	
	private String userId;
	private String userName;
	private String createTime;
	private String lastLogin;
	private String depName;
	private String duty; // 职位
	private String isSpecialist;
	
	public UserJson(String userId, String userName, String createTime, String lastLogin, String depName, String duty) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.createTime = createTime;
		this.lastLogin = lastLogin;
		this.depName = depName;
		this.duty = duty;
	}
	public UserJson(String userId, String userName, String createTime, String lastLogin, String depName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.createTime = createTime;
		this.lastLogin = lastLogin;
		this.depName = depName;
	}
	public UserJson() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getIsSpecialist() {
		return isSpecialist;
	}
	public void setIsSpecialist(String isSpecialist) {
		this.isSpecialist = isSpecialist;
	}
	
}
