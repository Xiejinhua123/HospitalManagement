package com.accp.demo;

/**
 * �û���
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.3.8
 */
public class User {
	
	private String userId; // �û����
	private String userPassword; // �û����� 
	private int	roleId; // �û����
	private String onlineState; // ������״̬
	private String createTime; // ����ʱ��
	private String modifyTime; // �޸�ʱ��
	private String lastLogin; // ���һ�ε�½ʱ��
	
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
