package cn.vote.model;

import java.util.Map;

/**
 * 开宝箱奖品反馈
 * 
 * @author 解金化
 *
 */
public class BoxAwardsModel {
	
	private Integer id;
	private Integer lovaNumber; // 爱心数量
	private Integer boxNumber; // 宝箱数量
	private Map<String , Integer> balls; // 龙珠名,可能会开出好多种龙珠,不同的龙珠对应不同的数量
	private Map<String , Integer> goods; // 商品名：商品数量

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLovaNumber() {
		return lovaNumber;
	}
	public void setLovaNumber(Integer lovaNumber) {
		this.lovaNumber = lovaNumber;
	}
	public Map<String, Integer> getBalls() {
		return this.balls;
	}
	public void setBalls(Map<String, Integer> balls) {
		this.balls = balls;
	}
	public Map<String, Integer> getGoods() {
		return this.goods;
	}
	public void setGoods(Map<String, Integer> goods) {
		this.goods = goods;
	}
	public Integer getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}
}
