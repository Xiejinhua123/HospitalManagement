package cn.vote.entity;

import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("serial")
public class GoodsConversion implements java.io.Serializable {

	private String id;
	private Users users;
	private Goods goods;
	private GoodsBall goodsBall;
	private Integer loveNumber;
	private Timestamp recordTime;
	private String orderNumber;
	private String deliveringWay;
	private String trackingNumber;
	private String conversionAddress;
	private Integer status;
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

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public GoodsBall getGoodsBall() {
		return this.goodsBall;
	}

	public void setGoodsBall(GoodsBall goodsBall) {
		this.goodsBall = goodsBall;
	}

	public Integer getLoveNumber() {
		return this.loveNumber;
	}

	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}

	public Timestamp getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDeliveringWay() {
		return this.deliveringWay;
	}

	public void setDeliveringWay(String deliveringWay) {
		this.deliveringWay = deliveringWay;
	}

	public String getTrackingNumber() {
		return this.trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getConversionAddress() {
		return this.conversionAddress;
	}

	public void setConversionAddress(String conversionAddress) {
		this.conversionAddress = conversionAddress;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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