package cn.vote.service;

import cn.vote.model.GoodsBallModel;
import cn.vote.util.Page;

/**
 * 龙珠兑换商品
 * 
 * @author 解金化
 *
 * @date 2017.07.23
 */
public interface GoodsBallService {

	/**
	 * 以分页的形式获取所有的龙珠兑换商品信息
	 * 
	 * @param page
	 * 		分页对象
	 * @throws Exception 
	 */
	void getAllGoodsBall(Page<GoodsBallModel> page) throws Exception;

}
