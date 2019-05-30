package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class RewardExchangeRecord implements java.io.Serializable {

	private String id;
	private Users users;
	private RewardGrade rewardGrade;
	private Integer goodsId;
	private Date recordTime;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public RewardGrade getRewardGrade() {
		return this.rewardGrade;
	}

	public void setRewardGrade(RewardGrade rewardGrade) {
		this.rewardGrade = rewardGrade;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
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