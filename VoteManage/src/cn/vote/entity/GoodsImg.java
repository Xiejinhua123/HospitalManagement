package cn.vote.entity;

@SuppressWarnings("serial")
public class GoodsImg implements java.io.Serializable {

	private String id;
	private Goods goods;
	private String imgUrl;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}