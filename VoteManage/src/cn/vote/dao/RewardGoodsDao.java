package cn.vote.dao;

import cn.vote.entity.RewardGoods;

public interface RewardGoodsDao {

	void deleteByGoods(RewardGoods r);
	
	void addRewardGoods(RewardGoods r);
	
	void updateRewardGoods(RewardGoods r);
	
	RewardGoods getRewardGoodsById(Integer id);

}
