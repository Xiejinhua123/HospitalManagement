package com.accp.impl;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.DepartmentDao;
import com.accp.demo.Department;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class DepartmentImpl extends HibernateUtil implements DepartmentDao{

	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		Department u=(Department)t;
		Serializable result=s.save(t);
		String 	userId=result.toString();
		u=(Department) s.get(Department.class, userId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Department u=(Department) s.get(Department.class, id);
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
		Department u=(Department)t;
		boolean b=false;
		try{
			Department a=(Department) s.get(Department.class, u.getDepId());
			if(u.getDepName()!= null) a.setDepName(u.getDepName());
			if(u.getDepAddress()!=null)a.setDepAddress(u.getDepAddress());
			if(u.getUserses() !=null) a.setUserses(u.getUserses());
			if(u.getFixedSysmptomses()!=null)a.setFixedSysmptomses(u.getFixedSysmptomses());
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
			Department u=(Department) s.get(Department.class, id);
			s.delete(u);
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
	CommonDaoImpl<Department> c=new CommonDaoImpl<>();
	@Override
	public void getPage(Page<Department> page,Department d) {
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
		List<Department> list = query.list();
		page.setList(list);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getByColumn(Department u) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(u);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(u);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		return q.list();
	}
	public static void main(String[] args) {
		Department u=new Department();
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(u);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(u);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Department> list=q.list();
		for (Department department : list) {
			
			System.out.println(department.getDepName());
		}
	}

}
