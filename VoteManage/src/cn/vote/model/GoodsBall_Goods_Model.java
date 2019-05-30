package cn.vote.model;

/**
 * 兑换商品时候需要用到的商品信息表
 * 
 * @author 解金化
 *
 */
public class GoodsBall_Goods_Model {

	private Integer id;
	private String name;
	private String url;
	private Integer number;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
