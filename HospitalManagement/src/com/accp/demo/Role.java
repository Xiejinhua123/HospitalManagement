package com.accp.demo;

/**
 * ��ɫ��
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Role {
	
	private int roleId; // ��ɫ���
	private String roleName; //  ��ɫ����
	private String CreateTime; // ����ʱ��
	private String modifyTime; // �޸�ʱ��
	private int enabled; // �Ƿ���øý�ɫ
	public Role() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Role(int roleId, String roleName, String createTime,
			String modifyTime, int enabled) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		CreateTime = createTime;
		this.modifyTime = modifyTime;
		this.enabled = enabled;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
}
