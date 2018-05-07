package com.accp.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	// Fields

	private Integer priId;
	private String priName;
	private Integer parentId;
	private String memo;
	private String menuPic;
	private String menuUrl;
	private Integer displayOrder;
	private String createTime;
	private String modifyTime;
	private Integer enableds;
	private Set rolePrivileges = new HashSet(0);

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** minimal constructor */
	public Privilege(Integer priId, String priName, String createTime) {
		this.priId = priId;
		this.priName = priName;
		this.createTime = createTime;
	}

	/** full constructor */
	public Privilege(Integer priId, String priName, Integer parentId,
			String memo, String menuPic, String menuUrl, Integer displayOrder,
			String createTime, String modifyTime, Integer enableds,
			Set rolePrivileges) {
		this.priId = priId;
		this.priName = priName;
		this.parentId = parentId;
		this.memo = memo;
		this.menuPic = menuPic;
		this.menuUrl = menuUrl;
		this.displayOrder = displayOrder;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.enableds = enableds;
		this.rolePrivileges = rolePrivileges;
	}

	// Property accessors

	public Integer getPriId() {
		return this.priId;
	}

	public void setPriId(Integer priId) {
		this.priId = priId;
	}

	public String getPriName() {
		return this.priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMenuPic() {
		return this.menuPic;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
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

	public Set getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(Set rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

}