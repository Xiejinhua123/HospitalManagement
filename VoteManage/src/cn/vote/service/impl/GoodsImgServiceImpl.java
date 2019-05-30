package cn.vote.service.impl;

import cn.vote.dao.GoodsImgDao;
import cn.vote.service.GoodsImgService;

public class GoodsImgServiceImpl implements GoodsImgService {
	private GoodsImgDao goodsImgDao;

	@Override
	public String getUrl(Integer id) throws Exception {
		if (null == id)
			throw new Exception("getUrl(Integer id) id 为空");
		return goodsImgDao.getImg(id);
	}

	public GoodsImgDao getGoodsImgDao() {
		return goodsImgDao;
	}

	public void setGoodsImgDao(GoodsImgDao goodsImgDao) {
		this.goodsImgDao = goodsImgDao;
	}

}
