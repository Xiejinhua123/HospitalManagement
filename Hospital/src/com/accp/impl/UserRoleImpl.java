package com.accp.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.CommonDao;
import com.accp.dao.UserRoleDao;
import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.util.HibernateUtil;

public class UserRoleImpl extends HibernateUtil implements UserRoleDao{
	CommonDao<UserRole> c=new CommonDaoImpl<UserRole>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		return c.del(UserRole.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(UserRole.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		UserRole u=(UserRole)t;
		boolean b=true;
		try{
			UserRole a=(UserRole) s.get(UserRole.class, u.getUrid());
			if(u.getRoles()!=null)a.setRoles(u.getRoles());
			if(u.getUsers()!=null)a.setUsers(u.getUsers());
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}	
		return b;
	}

	@Override
	public List<UserRole> getByRoles(Roles r) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(UserRole.class);
		Criterion c1=Restrictions.eq("roles", r);
		c.add(c1);
		List<UserRole> list=c.list();
		return list;
	}

	@Override
	public UserRole getId(Users u, Roles r) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(UserRole.class);
		Criterion c1=Restrictions.eq("roles", r);
		Criterion c2=Restrictions.eq("users", u);
		c.add(c1).add(c2);
		UserRole ur=(UserRole) c.uniqueResult();
		return ur;
		
	}

	@Override
	public List<UserRole> getRoleByUsers(Users u) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(UserRole.class);
		Criterion c1=Restrictions.eq("users", u);
		c.add(c1);
		List<UserRole> list=c.list();
		return list;
	}

}
