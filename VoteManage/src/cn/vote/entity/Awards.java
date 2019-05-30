package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Awards implements java.io.Serializable {

	private Integer id;
	private Game game;
	private Integer loveNumber;
	private Integer boxNumber;
	private Integer goodsId;
	private Integer goodsNumber;
	private Integer ballId;
	private Integer ballnumber;
	private Float probability;
	private String participation;
	private String deletes;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getLoveNumber() {
		return this.loveNumber;
	}

	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}

	public Integer getBoxNumber() {
		return this.boxNumber;
	}

	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Integer getBallId() {
		return this.ballId;
	}

	public void setBallId(Integer ballId) {
		this.ballId = ballId;
	}

	public Integer getBallnumber() {
		return this.ballnumber;
	}

	public void setBallnumber(Integer ballnumber) {
		this.ballnumber = ballnumber;
	}

	public Float getProbability() {
		return this.probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public String getParticipation() {
		return this.participation;
	}

	public void setParticipation(String participation) {
		this.participation = participation;
	}

	public String getDelete() {
		return deletes;
	}

	public void setDelete(String deletes) {
		this.deletes = deletes;
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