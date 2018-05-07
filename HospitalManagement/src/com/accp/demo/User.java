package com.accp.demo;

/**
 * 用户类
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.3.8
 */
public class User {
	
	private String userId; // 用户编号
	private String userPassword; // 用户密码 
	private int	roleId; // 用户编号
	private String onlineState; // 用在线状态
	private String createTime; // 创建时间
	private String modifyTime; // 修改时间
	private String lastLogin; // 最后一次登陆时间
	
	public User(String userId, String userPassword, int roleId, String onlineState, String createTime,
			String modifyTime, String lastLogin) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.roleId = roleId;
		this.onlineState = onlineState;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.lastLogin = lastLogin;
	}
	public String getOnlineState() {
		return onlineState;
	}
	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
}
