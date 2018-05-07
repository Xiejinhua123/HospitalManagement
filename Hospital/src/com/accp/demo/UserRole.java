package com.accp.demo;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole implements java.io.Serializable {

	// Fields

	private Integer urid;
	private Roles roles;
	private Users users;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** full constructor */
	public UserRole(Integer urid, Roles roles, Users users) {
		this.urid = urid;
		this.roles = roles;
		this.users = users;
	}

	// Property accessors

	public Integer getUrid() {
		return this.urid;
	}

	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}