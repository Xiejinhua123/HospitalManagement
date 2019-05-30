package cn.vote.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.GoodsConversionDao;
import cn.vote.entity.GoodsBall;
import cn.vote.entity.GoodsConversion;
import cn.vote.util.UtilHibernate;

public class GoodsConversionDaoImpl extends HibernateDaoSupport implements GoodsConversionDao{

	@Override
	public Integer getBallNum(Integer ballId) {
		try{
			super.getHibernateTemplate().find("select sum() from GoodsConversion where goodsBall.id=?",ballId);
		}catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public void getBallNumber()
	{							
		super.getHibernateTemplate().find("select sum() from GoodsConversion where goodsBall is not null");
	}
	
	@Override
	public void deleteByGoods(GoodsConversion g) {
		this.update(g);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsConversion> getByUserId(Integer userId) {
		try{
			List<GoodsConversion> list=super.getHibernateTemplate().find("GoodsConversion where users.id=?",userId);
			if(list!=null) return list;
		}catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public void add(GoodsConversion g) {
		super.getHibernateTemplate().save(g);
	}

	@Override
	public void update(GoodsConversion g) {
		try{
			GoodsConversion r=super.getHibernateTemplate().get(GoodsConversion.class,g.getId());
			GoodsConversion r1=UtilHibernate.Compare(r, g);
			super.getHibernateTemplate().update(r1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
