package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.DoctorOfferDao;
import com.accp.demo.DoctorOffer;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class DoctorOfferImpl extends HibernateUtil implements DoctorOfferDao{	
	CommonDao<DoctorOffer> c=new CommonDaoImpl<DoctorOffer>();
	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		DoctorOffer u=(DoctorOffer)t;
		Serializable result=s.save(t);
		String 	RoleId=result.toString();
		Integer doId=Integer.parseInt(RoleId);
		u=(DoctorOffer) s.get(DoctorOffer.class, doId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			DoctorOffer u=(DoctorOffer) s.get(DoctorOffer.class, id);
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
		DoctorOffer u=(DoctorOffer)t;
		boolean b=false;
		try{
			DoctorOffer a=(DoctorOffer) s.get(DoctorOffer.class, u.getDoid());
			if(u.getUsers()!=null) a.setUsers(u.getUsers());
			if(u.getRegistered()!=null) a.setRegistered(u.getRegistered());
			if(u.getSymptom()!=null) a.setSymptom(u.getSymptom());
			if(u.getPrescriptions()!=null) a.setPrescriptions(u.getPrescriptions());
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
			DoctorOffer u=(DoctorOffer) s.get(DoctorOffer.class, id);
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
	public List<DoctorOffer> getByColumn(DoctorOffer d) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(d);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(d);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<DoctorOffer> list=q.list();
		return list;
	}

	@Override
	public void getPage(Page<DoctorOffer> page,DoctorOffer d) {
		Session session = HibernateUtil.currentSession();
		String sql=Generate.getSql(d);
		Query query = session.createQuery(sql);
		//参数一     一页多少条
		//参数二     从哪开始(页数-1)*每页条数
		//map 动态查询 where 后条件
		// select top ? * from user where userId not in (select top ? userId from user)
		Map<String ,Object > map=Generate.getParams(d);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); //总条目数		
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );  //从第几行开始
		query.setMaxResults( page.getItems() );	//一页多少行
		List<DoctorOffer> list = query.list();
		page.setList(list);
		
	}

}
