package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer rolesId;
	private String roleName;
	private String createTime;
	private String modifyTime;
	private Integer enableds;
	private Set userRoles = new HashSet(0);
	private Set rolePrivileges = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(Integer rolesId, String roleName, String createTime) {
		this.rolesId = rolesId;
		this.roleName = roleName;
		this.createTime = createTime;
	}

	/** full constructor */
	public Roles(Integer rolesId, String roleName, String createTime,
			String modifyTime, Integer enableds, Set userRoles,
			Set rolePrivileges) {
		this.rolesId = rolesId;
		this.roleName = roleName;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.enableds = enableds;
		this.userRoles = userRoles;
		this.rolePrivileges = rolePrivileges;
	}

	// Property accessors

	public Integer getRolesId() {
		return this.rolesId;
	}

	public void setRolesId(Integer rolesId) {
		this.rolesId = rolesId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getEnableds() {
		return this.enableds;
	}

	public void setEnableds(Integer enableds) {
		this.enableds = enableds;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public Set getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(Set rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

}