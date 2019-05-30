package cn.vote.model;


public class GoodsModel {
	private Integer id;
	private String goodsName;
	private Integer loveNumber;
	private Integer shelvesStatus;
	private String description;
	private String url;
	private String deleteds;
	
	public String getDeleteds() {
		return deleteds;
	}
	public void setDeleteds(String deleteds) {
		this.deleteds = deleteds;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getLoveNumber() {
		return loveNumber;
	}
	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}
	public Integer getShelvesStatus() {
		return shelvesStatus;
	}
	public void setShelvesStatus(Integer shelvesStatus) {
		this.shelvesStatus = shelvesStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
