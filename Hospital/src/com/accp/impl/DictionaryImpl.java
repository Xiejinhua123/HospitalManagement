package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.DictionaryDao;
import com.accp.demo.Department;
import com.accp.demo.Dictionary;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

import sun.util.logging.resources.logging;

public class DictionaryImpl extends HibernateUtil implements DictionaryDao{
	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		Dictionary u=(Dictionary)t;
		Serializable result=s.save(t);
		Integer RoleId=Integer.parseInt(result.toString());
		u=(Dictionary) s.get(Dictionary.class, RoleId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Dictionary u=(Dictionary) s.get(Dictionary.class, id);
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
		Dictionary u=(Dictionary)t;
		boolean b=true;
		try{
			Dictionary a=(Dictionary) s.get(Dictionary.class, u.getDicId());
			if(u.getTypeCode()!=null) a.setTypeCode(u.getTypeCode());
			if(u.getTypeName()!=null) a.setTypeName(u.getTypeName());
			if(u.getTypeValus()!=null) a.setTypeValus(u.getTypeValus());
			if(u.getIsVisible()!=null) a.setIsVisible(u.getIsVisible());
			if(u.getMemo()!=null) a.setMemo(u.getMemo());
			s.update(a);
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
			Dictionary u=(Dictionary) s.get(Dictionary.class, id);
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
	public void getPage(Page<Dictionary> page, Dictionary d) {
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
		List<Dictionary> list = query.list();
		page.setList(list);
		
	}
	CommonDaoImpl<Department> c=new CommonDaoImpl<Department>();
	@Override
	public List<Dictionary> getByColumn(Dictionary d) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(d);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(d);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Dictionary> list=q.list();
		return list;
	}

	@Override
	public boolean delByTypeName(String typeName) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(Dictionary.class);
		Criterion c1=Restrictions.eq("typeName", typeName);
		c.add(c1);
		List<Dictionary> list=null;
		try{
		list= c.list();
		}
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
		if(list!=null)
		{
			try{
			for (Dictionary dictionary : list) {
				s.delete(dictionary);
				}
				}
			catch(Exception e)
			{
				e.getMessage();
			}
			return true;
		}
		else return false;
	}

}
