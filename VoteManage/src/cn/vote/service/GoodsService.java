package cn.vote.service;

import java.util.List;

import cn.vote.entity.Goods;
import cn.vote.model.GoodsModel;
import cn.vote.util.ImageCutModel;
import cn.vote.util.Page;

public interface GoodsService {
	/**
	 * 后台查看所有的用户
	 * @param page
	 * 		分页对象
	 */
	void getPageGoods(Page page,String goodsName) throws Exception;
	/**
	 * 修改商品
	 * @param g 前排传回对象
	 * @throws Exception
	 */
	boolean updateGoods(Goods g)throws Exception;
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品对象
	 */
	GoodsModel findGoodsById(Integer id)throws Exception;
	
	public boolean  delById(Integer id)throws Exception;
	
	/**
	 * 添加商品
	 * 
	 * @author 解金化
	 * 
	 * @param goods
	 * 		商品实体
	 * @param paths
	 * 		上传的商品的图片
	 * @param icm
	 * 		执行图片切割必要参数
	 * 
	 * @throws Exception
	 */
	void addGoods(Goods goods, String[] paths, ImageCutModel icm) throws Exception;
	/**
	 * 获取所有商品名称
	 * @return
	 */
	public List<String> getAllGoodsName();
}
