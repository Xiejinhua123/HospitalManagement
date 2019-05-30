package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.LoveDao;
import cn.vote.entity.Love;
import cn.vote.util.UtilHibernate;

public class LoveDaoImpl extends HibernateDaoSupport implements LoveDao{

	@Override
	public void updateLove(Love ld) {
		try{
		Love l=super.getHibernateTemplate().get(Love.class,ld.getId());
		l=UtilHibernate.Compare(l, ld);
		super.getHibernateTemplate().update(l);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Love getLove() {
		try{
			List<Love> list=super.getHibernateTemplate().find("from Love");
			if(list!=null && list.size()==1)
			{
				return list.get(0);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

}
