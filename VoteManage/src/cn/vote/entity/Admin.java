package cn.vote.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Admin implements Serializable {

	private Integer id;
	private Admin adminByCreateId;
	private Admin adminByUpdateId;
	private Integer deleted;
	private String manageAccount;
	private String managePassword;
	private Integer rank;
	private String name;
	private Date createTime;
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getAdminByCreateId() {
		return adminByCreateId;
	}

	public void setAdminByCreateId(Admin adminByCreateId) {
		this.adminByCreateId = adminByCreateId;
	}

	public Admin getAdminByUpdateId() {
		return adminByUpdateId;
	}

	public void setAdminByUpdateId(Admin adminByUpdateId) {
		this.adminByUpdateId = adminByUpdateId;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getManageAccount() {
		return manageAccount;
	}

	public void setManageAccount(String manageAccount) {
		this.manageAccount = manageAccount;
	}

	public String getManagePassword() {
		return managePassword;
	}

	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}