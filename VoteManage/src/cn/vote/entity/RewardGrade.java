package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class RewardGrade implements java.io.Serializable {

	private Integer id;
	private Integer setNumber;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSetNumber() {
		return this.setNumber;
	}

	public void setSetNumber(Integer setNumber) {
		this.setNumber = setNumber;
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