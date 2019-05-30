package cn.vote.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.LableDao;
import cn.vote.entity.Lable;
import cn.vote.model.LabelModel;
import cn.vote.util.Page;

public class LableDaoImpl extends HibernateDaoSupport implements LableDao{
	
	private final Logger logger =Logger.getLogger(LableDaoImpl.class);
	@SuppressWarnings("unchecked")
	@Override
	public List<Lable> getAll() {
		List<Lable> list=super.getHibernateTemplate().find("from Lable");
		if(list!=null && list.size()>=1) return list;
		else return null;
	}
	/**
	 * 根据条件分页查询
	 * @param page 
	 * @param l 查询条件
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lable> getPage(Page<LabelModel> page,Lable l)
	{
		Session session = this.getSession();    
		Query q = session.createQuery("from Lable");
		int number=(page.getPageSize()-1)*page.getItems();
		q.setFirstResult(number);
		q.setMaxResults(page.getItems());
		List<Lable> list=q.list();
		releaseSession(session);
		return list;
	}
	
	@Override
	public boolean update(Lable lable) {
		try{
		Lable la=super.getHibernateTemplate().get(Lable.class, lable.getId());
		la.setLableName(lable.getLableName());
		la.setExplains(lable.getExplains());
		super.getHibernateTemplate().update(la);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("标签修改失败");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Lable lable) {
		this.update(lable);
		return true;
	}

	@Override
	public Lable getById(Integer id) {
		return super.getHibernateTemplate().get(Lable.class, id);
	}

	@Override
	public boolean addLable(Lable lable) {
		try{
		super.getHibernateTemplate().save(lable);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.info("添加标签失败");
			return false;
		}
		return true;
	}
	
}
