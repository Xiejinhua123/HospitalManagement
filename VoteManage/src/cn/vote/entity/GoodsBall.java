package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class GoodsBall implements java.io.Serializable {

	private Integer id;
	private String goodsIds;
	private String product;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsIds() {
		return this.goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
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