package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.DrugDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class DrugImpl extends HibernateUtil implements DrugDao{
	CommonDao<Drug> c=new CommonDaoImpl<Drug>();
	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		Drug u=(Drug)t;
		Serializable result=s.save(t);
		String userId=result.toString();
		u=(Drug) s.get(Drug.class, userId);
		return u;
	}
	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Drug u=(Drug) s.get(Drug.class, id);
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
		Drug u=(Drug)t;
		boolean b=false;
		try{
			Drug a=(Drug) s.get(Drug.class, u.getDrugId());
			if(u.getDrugName()!=null) a.setDrugName(u.getDrugName());
			if(u.getDrugAlias()!=null)a.setDrugAlias(u.getDrugAlias());
			if(u.getDrugShape()!=null)a.setDrugShape(u.getDrugShape());
			if(u.getDrugType()!=null)a.setDrugType(u.getDrugType());
			if(u.getDrugSymptom()!=null)a.setDrugSymptom(u.getDrugSymptom());
			if(u.getDrugBigUnit()!=null)a.setDrugBigUnit(u.getDrugBigUnit());
			if(u.getDrugSmallUnit()!=null)a.setDrugSmallUnit(u.getDrugSmallUnit());
			if(u.getSpecification()!=null)a.setSpecification(u.getSpecification());
			if(u.getDrugPrice()!=null)a.setDrugPrice(u.getDrugPrice());
			if(u.getDrugConsumption()!=null)a.setDrugConsumption(u.getDrugConsumption());
			if(u.getAttention()!=null)a.setAttention(u.getAttention());
			if(u.getPrescriptions()!=null)a.setPrescriptions(u.getPrescriptions());
			if(u.getFixedPrescriptions()!=null)a.setFixedPrescriptions(u.getFixedPrescriptions());
			if(u.getDrugTimes()!=null)a.setDrugTimes(u.getDrugTimes());
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
			Drug u=(Drug) s.get(Drug.class, id);
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
	public List<Drug> getByColumn(Drug d) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(d);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(d);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Drug> list=q.list();
		return list;
	}
	@Override
	public void getPage(Page<Drug> page,Drug d) {
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
		List<Drug> list = query.list();
		page.setList(list);
		
	}

}
