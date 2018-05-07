package com.accp.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.RegisteredDao;
import com.accp.demo.DrugTime;
import com.accp.demo.Privilege;
import com.accp.demo.Registered;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class RegisteredImpl extends HibernateUtil implements RegisteredDao
{
	CommonDao<Registered> c=new CommonDaoImpl<Registered>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		return c.del(Registered.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(Registered.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		Registered u=(Registered)t;
		boolean b=false;
		try{
			Registered a=(Registered) s.get(Registered.class,u.getRegId());
			if(u.getUsers()!=null)a.setUsers(u.getUsers());
			if(u.getPatient()!=null)a.setPatient(u.getPatient());
			if(u.getAppointmentTime()!=null)a.setAppointmentTime(u.getAppointmentTime());
			if(u.getRegTime()!=null) a.setRegTime(u.getRegTime());
			if(u.getDepId()!=null)a.setDepId(u.getDepId());
			if(u.getRegType()!=null) a.setRegType(u.getRegType());
			if(u.getRegPrice()!=null) a.setRegPrice(u.getRegPrice());
			if(u.getPayState()!=null) a.setPayState(u.getPayState());
			if(u.getRegState()!=null)a.setRegState(u.getRegState());
			if(u.getIsPay()!=null)a.setIsPay(u.getIsPay());
			if(u.getDoctorOffers()!=null)a.setDoctorOffers(u.getDoctorOffers());
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}	
		return b;
	}

	@Override
	public void getPage(Page<Registered> page, Registered r) {
		Session session = HibernateUtil.currentSession();
		String sql=Generate.getSql(r);
		Query query = session.createQuery(sql);
		
		Map<String ,Object > map=Generate.getParams(r);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); //总条目数		
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );  //从第几行开始
		query.setMaxResults( page.getItems() );	//一页多少行
		List<Registered> list = query.list();
		page.setList(list);
	}

	@Override
	public List<Registered> getByColumn(Registered r) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(r);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(r);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Registered> list=q.list();
		return list;
	}
	

}
