package cn.vote.dao;

import java.util.List;

import cn.vote.entity.GoodsBall;
import cn.vote.model.GoodsBallModel;
import cn.vote.util.Page;

/**
 * 龙珠兑换商品增删改查
 * 
 * @author 解金化
 *
 */
public interface GoodsBallDao {

	/**
	 * 分页获取实体
	 * @param page
	 * 		分页对象
	 * @return
	 * 		查询到的集合
	 */
	List<GoodsBall> getPage(Page<GoodsBallModel> page);
	
	List<GoodsBall> getAll();
	
	void addGoodsBall(GoodsBall g);
	
	void delGoodsBall(GoodsBall g);
	
	void update(GoodsBall g);

}
