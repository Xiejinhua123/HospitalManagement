package cn.vote.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.AwardsDao;
import cn.vote.entity.Awards;
import cn.vote.model.AwardsModel;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

public class AwardsDaoImpl extends HibernateDaoSupport implements AwardsDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Awards> getByGameId(Page<AwardsModel> page, Integer id) {
		
		String sql = "from Awards  where game.id = ? order by probability";
		Session s= this.getSession();
		Query query =s.createQuery(sql);
		query.setInteger(0, id);
		int number=(page.getPageSize()-1)*page.getItems();
		query.setFirstResult(number);
		query.setMaxResults(page.getItems());
		try{
			List<Awards> list=query.list();
			if(list!=null && list.size()>0)return list;
		}catch (Exception e) {
			e.getStackTrace();
		}finally{
			releaseSession(s);
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getAllNumber() {
		try{
			List list=super.getHibernateTemplate().find("select count(*) from Awards");
			if(list!=null)return (Long) list.get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (long) 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getAllNumberByGameId(Integer id) {
		try{
			List list=super.getHibernateTemplate().find("select count(*) from Awards where game.id=?",id);
			if(list!=null)return (Long) list.get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (long) 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Awards> getByGameId(Integer id) {
//		String sql = "from Awards  where game.id = ? order by probability";
		String sql = "from Awards  where game.id = ?"; // 暂时不按照概率排序
		Session session=this.getSession();
		Query query =session .createQuery(sql);
		query.setInteger(0, id);
		try{
			List<Awards> list=query.list();
			if(list!=null && list.size()>0)return list;
		}catch (Exception e) {
			e.getStackTrace();
		}finally{
			releaseSession(session);
		}
		return null;
	}

	@Override
	public void deleteAward(Awards a) {
		this.updateAward(a);
	}

	@Override
	public void updateAward(Awards a) {
		try{
			Awards aw=getById(a.getId());
			a.setParticipation("无");
			Awards a1=UtilHibernate.Compare(aw, a);
			
			super.getHibernateTemplate().update(a1);
		}catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public Awards getById(Integer awardsID) {
		try{
			Awards a=	super.getHibernateTemplate().get(Awards.class, awardsID);
			if(a!=null)return a;
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public void addAward(Awards a) {
		try{
			super.getHibernateTemplate().save(a);
		}catch (Exception e) {
			e.getStackTrace();
		}
	}

}
