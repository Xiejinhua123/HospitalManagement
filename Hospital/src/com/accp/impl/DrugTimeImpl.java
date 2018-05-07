package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.CommonDao;
import com.accp.dao.DrugTimeDao;
import com.accp.demo.Drug;
import com.accp.demo.DrugTime;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class DrugTimeImpl extends HibernateUtil implements DrugTimeDao{

	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		DrugTime u=(DrugTime)t;
		Serializable result=s.save(t);
		String 	userId=result.toString();
		u=(DrugTime) s.get(DrugTime.class, userId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			DrugTime u=(DrugTime) s.get(DrugTime.class, id);
			s.delete(u);
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		DrugTime u=(DrugTime)t;
		boolean b=false;
		try{
			DrugTime a=(DrugTime) s.get(DrugTime.class, u.getDrugTimeId());
			if(u.getDrug()!=null) a.setDrug(u.getDrug());
			if(u.getDates()!=null)a.setDates(u.getDates());
			if(u.getDrugNumber()!=null)a.setDrugNumber(u.getDrugNumber());
			if(u.getDrugProduction()!=null) a.setDrugProduction(u.getDrugProduction());
			if(u.getDrugExpiration()!=null) a.setDrugExpiration(u.getDrugExpiration());
			if(u.getDrugCount()!=null) a.setDrugCount(u.getDrugCount());
			}
			catch(Exception e)
			{
				b=false;
				e.getMessage();
			}
		
		return b;
	}

	@Override
	public boolean del(int id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			DrugTime u=(DrugTime) s.get(DrugTime.class, id);
			s.delete(u);
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
	
	
	CommonDao<DrugTime> c=new CommonDaoImpl<DrugTime>();
	@Override
	public List<DrugTime> getByDrug(Drug drug) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(DrugTime.class);
		c.add(Restrictions.eq("drug", drug));
		return c.list();
	}
	
	@Override
	public List<DrugTime> getByColumn(DrugTime d) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(d);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(d);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<DrugTime> list=q.list();
		return list;
	}

	@Override
	public void getPage(Page<DrugTime> page, DrugTime d, Boolean bool) {
		Session session = HibernateUtil.currentSession();
		String sql=Generate.getSql(d);
		Query query = session.createQuery(sql);
		Map<String ,Object > map=Generate.getParams(d);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); //总条目数		
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );  //从第几行开始
		query.setMaxResults( page.getItems() );	//一页多少行
		List<DrugTime> list = query.list();
		page.setList(list);
		
	}

	@Override
	public int getDrugNum(Drug drug) {
		
		Session session = HibernateUtil.currentSession();
		String sql = "select SUM(dt.drugCount) from DrugTime dt where dt.drug = :drug";
		Query query = session.createQuery(sql);
		query.setParameter("drug", drug);
		int a = 0;
		try {
			Object o = query.uniqueResult();
			a = Integer.parseInt(o.toString());
		} catch (Exception e) {
		}
		return a;
	}

public static void main(String[] args) {
	Drug d = new Drug();
	d.setDrugId(1);
	new DrugTimeImpl().getDrugNum(d);
}

	

}
