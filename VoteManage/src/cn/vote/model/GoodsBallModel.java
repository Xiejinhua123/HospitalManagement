package cn.vote.model;

import java.util.List;

/**
 * 向前台输送的龙珠兑换商品详情数据
 * @author 解金化
 */
public class GoodsBallModel {
	
	private Integer id;
	private List<GoodsBall_Goods_Model> gbg; // 商品
	private List<GoodsBall_Ball_Model> gbb; // 龙珠
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setGbg(List<GoodsBall_Goods_Model> gbg) {
		this.gbg = gbg;
	}
	public void setGbb(List<GoodsBall_Ball_Model> gbb) {
		this.gbb = gbb;
	}
	public List<GoodsBall_Goods_Model> getGbg() {
		return gbg;
	}
	public List<GoodsBall_Ball_Model> getGbb() {
		return gbb;
	}
}
