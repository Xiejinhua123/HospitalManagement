package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.GoodsImgDao;
import cn.vote.entity.GoodsConversion;
import cn.vote.entity.GoodsImg;
import cn.vote.util.UtilHibernate;

public class GoodsImgDaoImpl extends HibernateDaoSupport implements GoodsImgDao{

	@SuppressWarnings("unchecked")
	@Override
	public String getImg(Integer goodsId) {
		List<GoodsImg> list= super.getHibernateTemplate().find("from GoodsImg where goods.id=?",goodsId);
		if(list==null || list.size()<1) return null; 
		else return list.get(0).getImgUrl();
	}

	@Override
	public void add(GoodsImg gi) {
		try{
		super.getHibernateTemplate().save(gi);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteGoodImg(Integer gi)
	{
		GoodsImg g=super.getHibernateTemplate().get(GoodsImg.class, gi);
		super.getHibernateTemplate().delete(g);
		return true;
	}

	@Override
	public void update(GoodsImg gi) {
		try{
			GoodsImg r=super.getHibernateTemplate().get(GoodsImg.class,gi.getId());
			GoodsImg r1=UtilHibernate.Compare(r, gi);
			super.getHibernateTemplate().update(r1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
