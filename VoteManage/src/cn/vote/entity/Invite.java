package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Invite implements java.io.Serializable {

	private Integer id;
	private Users usersByInviteId;
	private Users usersByAcceptId;
	private Integer pollingNumber;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsersByInviteId() {
		return this.usersByInviteId;
	}

	public void setUsersByInviteId(Users usersByInviteId) {
		this.usersByInviteId = usersByInviteId;
	}

	public Users getUsersByAcceptId() {
		return this.usersByAcceptId;
	}

	public void setUsersByAcceptId(Users usersByAcceptId) {
		this.usersByAcceptId = usersByAcceptId;
	}

	public Integer getPollingNumber() {
		return this.pollingNumber;
	}

	public void setPollingNumber(Integer pollingNumber) {
		this.pollingNumber = pollingNumber;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public Admin getAdminByUpdate() {
		return adminByUpdate;
	}

	public void setAdminByUpdate(Admin adminByUpdate) {
		this.adminByUpdate = adminByUpdate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}