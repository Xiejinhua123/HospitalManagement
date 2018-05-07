package com.accp.impl;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.UserDao;
import com.accp.demo.Common;
import com.accp.demo.Department;
import com.accp.demo.Roles;
import com.accp.demo.Users;
import com.accp.json.UserJson;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class UserImpl extends HibernateUtil implements UserDao{
	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		Users u=(Users)t;
		Serializable result=s.save(t);
		String 	UsersId=result.toString();
		u=(Users) s.get(Users.class, UsersId);
		return u;
	}
	

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Users u=(Users) s.get(Users.class, id);
			s.delete(u);
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
	public static void main(String[] args) {
//		UserImpl u=new UserImpl();
//		boolean b=u.del("123456789012");
	}
	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		Users u=(Users)t;
		boolean b=true;
		try{
			Users a=(Users)s.get(Users.class, u.getUsersId());
			if(u.getUserPassword() != null)
			{
			a.setUserPassword(u.getUserPassword());
			}
			if(u.getCreateTime() != null)
			{
			a.setCreateTime(u.getCreateTime());
			}
			if(u.getOnlineState() != null)
			{
				a.setOnlineState(u.getOnlineState());
			}
			if(u.getModifyTime() != null)
			{
				a.setModifyTime(u.getModifyTime());
			}
			if(u.getLastLogin() != null)
			{
				a.setLastLogin(u.getLastLogin());
			}
			if(u.getTrueName() != null)
			{
				a.setTrueName(u.getTrueName());
			}
			if(u.getIdCard() != null)
			{
				a.setIdCard(u.getIdCard());
			}
			if(u.getIsSpecialist() != null)
			{
				a.setIsSpecialist(u.getIsSpecialist());
			}
			if(u.getDocBirthday() != null)
			{
				a.setDocBirthday(u.getDocBirthday());
			}
			if(u.getSchoolRecord() != null)
			{
				a.setSchoolRecord(u.getSchoolRecord());
			}
			if(u.getTelePhone() != null)
			{
				a.setTelePhone(u.getTelePhone());
			}
			if(u.getOfficePhone() != null)
			{
				a.setOfficePhone(u.getOfficePhone());
			}
			if(u.getOnjobState() != null)
			{
				a.setOnjobState(u.getOnjobState());
			}
			if(u.getEmail() != null)
			{
				a.setEmail(u.getEmail());
			}
			if(u.getIsSpecialist() != null)
			{
				a.setIsSpecialist(u.getIsSpecialist());
			}
			if(u.getDuty() != null)
			{
				a.setDuty(u.getDuty());
			}
			if(u.getRegistereds() != null)
			{
				a.setRegistereds(u.getRegistereds());
			}
			if(u.getUserRoles() != null)
			{
				a.setUserRoles(u.getUserRoles());
			}
			if(u.getReportsForRepAuthor() != null)
			{
				a.setReportsForRepAuthor(u.getReportsForRepAuthor());
			}
		    if(u.getReportsForRepReview() != null)
			{
				a.setReportsForRepReview(u.getReportsForRepReview());
			}
			if(u.getDoctorOffers() != null)
			{
				a.setDoctorOffers(u.getDoctorOffers());
			}
			if(u.getDocSex()!=null)
			{
				a.setDocSex(u.getDocSex());
			}
			
			s.update(a);
			s.flush();
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
	@Override
	public List<Users> getByColumn(Users u) {
		Session s = HibernateUtil.currentSession();
		String hql = Generate.getSql(u);
		Map<String, Object> map = Generate.getParams(u);
		Criteria c=s.createCriteria(Users.class);
		Criterion c1;
		for (String	str	 : map.keySet()) {
			c1=Restrictions.like(str, map.get(str));
			c.add(c1);
		}
		List<Users> list=c.list();
		if( null == list ){
			return null;
		}else		
			return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getPage(Page page, String sql, Map<String, Object> map) {
		
		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery(sql);
		
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size());
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );
		query.setMaxResults( page.getItems() );
		List<Users> list = query.list();
		List<UserJson> jsonlist = new LinkedList<>();
		for (Users users : list) {
			UserJson us = new UserJson(users.getUsersId(), users.getTrueName(), users.getCreateTime().toString(), users.getLastLogin().toString(), Common.DICTIONA_MAP.get( users.getDepartment().getDepName()).getTypeValus());
			jsonlist.add(us);
		}
		page.setList(jsonlist);

	}
	
	@Override
	public List<Roles> getRoleByUser(Users u) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(Roles.class);
		Criterion c1=Restrictions.eq("Users",u);
		List<Roles> list=c.list();
		return list;
	}

	@Override
	public List<Users> getByDep(Department dep) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(Users.class);
		if(dep!=null)
		{
		Criterion c1=Restrictions.eq("department", dep);
		c.add(c1);
		}
		return c.list();
	}

	@Override
	public boolean del(int id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Users u=(Users) s.get(Users.class, id);
			s.delete(u);
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}
		return b;
	}
}
