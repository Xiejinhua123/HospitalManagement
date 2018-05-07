package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.FixedSysmptomsDao;
import com.accp.demo.Drug;
import com.accp.demo.FixedSysmptoms;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class FixedSysmptomsImpl extends HibernateUtil implements FixedSysmptomsDao{

	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		FixedSysmptoms u=(FixedSysmptoms)t;
		Serializable result=s.save(t);
		Integer RoleId=Integer.parseInt((String) result);
		u=(FixedSysmptoms) s.get(FixedSysmptoms.class, RoleId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			FixedSysmptoms u=(FixedSysmptoms) s.get(FixedSysmptoms.class, id);
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
		FixedSysmptoms u=(FixedSysmptoms)t;
		boolean b=false;
		try{
			FixedSysmptoms a=(FixedSysmptoms) s.get(FixedSysmptoms.class, u.getFsid());
			if(u.getDepartment()!=null) a.setDepartment(u.getDepartment());
			if(u.getSysmptoms()!=null)a.setSysmptoms(u.getSysmptoms());
			if(u.getFixedPrescriptions()!=null)a.setFixedPrescriptions(u.getFixedPrescriptions());
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
			FixedSysmptoms u=(FixedSysmptoms) s.get(FixedSysmptoms.class, id);
			s.delete(u);
 		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
	CommonDaoImpl<FixedSysmptoms> c=new CommonDaoImpl<>();
	@Override
	public void getPage(Page<FixedSysmptoms> page,FixedSysmptoms f) {
		Session session = HibernateUtil.currentSession();
		String sql=Generate.getSql(f);
		Query query = session.createQuery(sql);
		//参数一     一页多少条
		//参数二     从哪开始(页数-1)*每页条数
		//map 动态查询 where 后条件
		// select top ? * from user where userId not in (select top ? userId from user)
		Map<String ,Object > map=Generate.getParams(f);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); //总条目数		
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );  //从第几行开始
		query.setMaxResults( page.getItems() );	//一页多少行
		List<FixedSysmptoms> list = query.list();
		page.setList(list);
		
	}

	@Override
	public List<FixedSysmptoms> getByColumn(FixedSysmptoms f) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(f);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(f);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<FixedSysmptoms> list=q.list();
		return list;
	}

}
