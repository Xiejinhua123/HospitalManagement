package cn.vote.service;

public interface GoodsImgService {
	/**
	 * 根据商品id获取商品第一张图片
	 * @param id
	 * @return
	 */
	public String getUrl(Integer id) throws Exception;
}
