package com.accp.demo;

/**
 * RolePrivilege entity. @author MyEclipse Persistence Tools
 */

public class RolePrivilege implements java.io.Serializable {

	// Fields

	private Integer rpid;
	private Privilege privilege;
	private Roles roles;

	// Constructors

	/** default constructor */
	public RolePrivilege() {
	}

	/** full constructor */
	public RolePrivilege(Integer rpid, Privilege privilege, Roles roles) {
		this.rpid = rpid;
		this.privilege = privilege;
		this.roles = roles;
	}

	// Property accessors

	public Integer getRpid() {
		return this.rpid;
	}

	public void setRpid(Integer rpid) {
		this.rpid = rpid;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}