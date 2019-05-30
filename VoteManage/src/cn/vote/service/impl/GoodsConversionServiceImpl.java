package cn.vote.service.impl;

import cn.vote.dao.GoodsConversionDao;
import cn.vote.service.GoodsConversionService;

public class GoodsConversionServiceImpl implements GoodsConversionService {

	private GoodsConversionDao goodsConversionDao;

	@Override
	public void numberOfBall() {

	}

	public GoodsConversionDao getGoodsConversionDao() {
		return goodsConversionDao;
	}

	public void setGoodsConversionDao(GoodsConversionDao goodsConversionDao) {
		this.goodsConversionDao = goodsConversionDao;
	}

}
