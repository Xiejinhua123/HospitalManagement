package cn.vote.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.GoodsBallDao;
import cn.vote.entity.GoodsBall;
import cn.vote.entity.RewardGoods;
import cn.vote.entity.RewardGrade;
import cn.vote.model.GoodsBallModel;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

/**
 * 龙珠兑换商品实现类
 * @author 解金化
 *
 */
public class GoodsBallDaoImpl extends HibernateDaoSupport implements GoodsBallDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<GoodsBall> getPage(final Page<GoodsBallModel> page) {
		
		return super.getHibernateTemplate().executeFind(
			new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					String hql = "select count(id) from GoodsBall";
					Query query = session.createQuery(hql);
					page.setTotal( Integer.parseInt( query.uniqueResult().toString() ) );
					
					hql = "from GoodsBall";
					query = session.createQuery(hql);
					query.setFirstResult( page.getItems() * ( page.getPageCount() - 1 ) );
					query.setMaxResults( page.getItems() );
					
					return query.list();
				}
			
			}
		);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsBall> getAll() {
		try{
			List<GoodsBall> list=super.getHibernateTemplate().find("from GoodsBall");
			if(list!=null && list.size()>0) return list;
		}catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public void addGoodsBall(GoodsBall g) {
		try{
			super.getHibernateTemplate().save(g);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delGoodsBall(GoodsBall g) {
		this.update(g);
	}

	@Override
	public void update(GoodsBall g) {
		try{
			GoodsBall r=super.getHibernateTemplate().get(GoodsBall.class,g.getId());
			GoodsBall r1=UtilHibernate.Compare(r, g);
			super.getHibernateTemplate().update(r1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
