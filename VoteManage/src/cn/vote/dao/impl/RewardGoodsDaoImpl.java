package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.RewardGoodsDao;
import cn.vote.entity.RewardGoods;

public class RewardGoodsDaoImpl extends HibernateDaoSupport implements RewardGoodsDao {

	@SuppressWarnings("unchecked")
	@Override
	public void deleteByGoods(RewardGoods r) {
		
		this.updateRewardGoods(r);
	}

	@Override
	public void addRewardGoods(RewardGoods r) {
		try{
			super.getHibernateTemplate().save(r);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRewardGoods(RewardGoods r) {
		try{
			super.getHibernateTemplate().update(r);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RewardGoods getRewardGoodsById(Integer id) {
		try{
			List<RewardGoods> list=super.getHibernateTemplate().find("from RewardGoods where id=?",id);
			if(list!=null)	return list.get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
