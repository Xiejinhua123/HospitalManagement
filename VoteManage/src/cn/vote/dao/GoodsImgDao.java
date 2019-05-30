package cn.vote.dao;

import cn.vote.entity.GoodsImg;

public interface GoodsImgDao {
	public String getImg(Integer goodsId);

	/**
	 * 添加商品图片
	 * @param gi
	 */
	public void add(GoodsImg gi);
	
	public boolean deleteGoodImg(Integer gi);
	
	public void update(GoodsImg gi);
}
