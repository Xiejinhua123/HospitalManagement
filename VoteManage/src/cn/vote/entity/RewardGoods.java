package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class RewardGoods implements java.io.Serializable {

	private Integer id;
	private Goods goods;
	private RewardGrade rewardGrade;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public RewardGrade getRewardGrade() {
		return this.rewardGrade;
	}

	public void setRewardGrade(RewardGrade rewardGrade) {
		this.rewardGrade = rewardGrade;
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