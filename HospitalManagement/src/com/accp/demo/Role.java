package com.accp.demo;

/**
 * 角色表
 * 
 * @author 解金化
 * @version 1.0
 * 
 *	2017.03.08
 */
public class Role {
	
	private int roleId; // 角色编号
	private String roleName; //  角色名称
	private String CreateTime; // 创建时间
	private String modifyTime; // 修改时间
	private int enabled; // 是否禁用该角色
	public Role() {
		super();
		// TODO 自动生成的构造函数存根
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
