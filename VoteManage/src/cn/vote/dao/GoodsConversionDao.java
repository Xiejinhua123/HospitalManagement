package cn.vote.dao;

import java.util.List;

import cn.vote.entity.GoodsConversion;

public interface GoodsConversionDao {

	/**
	 * 查询
	 * @param ballId
	 * @return
	 */
	public Integer getBallNum(Integer ballId);

	/**
	 * 根据商品删除商品兑换记录
	 * @param id
	 * 		商品编号
	 */
	public void deleteByGoods(GoodsConversion g);
	
	public void update(GoodsConversion g);
	
	public List<GoodsConversion> getByUserId(Integer userId);
	
	public void add(GoodsConversion g);
	
}
