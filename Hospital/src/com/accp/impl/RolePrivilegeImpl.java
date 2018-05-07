package com.accp.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.CommonDao;
import com.accp.dao.RolePrivilegeDao;
import com.accp.demo.Privilege;
import com.accp.demo.RolePrivilege;
import com.accp.demo.Roles;
import com.accp.util.HibernateUtil;

public class RolePrivilegeImpl extends HibernateUtil implements RolePrivilegeDao{
	CommonDao<RolePrivilege> c=new CommonDaoImpl<RolePrivilege>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		return c.del(RolePrivilege.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(RolePrivilege.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		RolePrivilege u=(RolePrivilege)t;
		boolean b=true;
		try{
			RolePrivilege a=(RolePrivilege) s.get(RolePrivilege.class, u.getRpid());
			if(u.getPrivilege()!=null)a.setPrivilege(u.getPrivilege());
			if(u.getRoles()!=null)a.setRoles(u.getRoles());
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}	
		return b;
	}

	@Override
	public List<RolePrivilege> getByRole(Roles r) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(RolePrivilege.class);
		Criterion c1=Restrictions.eq("roles", r);
		c.add(c1);
		List<RolePrivilege> list=c.list();
		return list;
	}

	@Override
	public List<RolePrivilege> getByPriilege(Privilege p) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(RolePrivilege.class);
		Criterion c1=Restrictions.eq("privilege", p);
		c.add(c1);
		List<RolePrivilege> list=c.list();
		return list;
	}

	@Override
	public RolePrivilege getByRolePrivilege(Roles r, Privilege p) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(RolePrivilege.class);
		Criterion c1=Restrictions.eq("privilege", p);
		Criterion c2=Restrictions.eq("roles", r);
		c.add(c1).add(c2);
		RolePrivilege rp=(RolePrivilege) c.uniqueResult();
		return rp;
		
	}

	@Override
	public RolePrivilege getById(Integer id) {
		return null;
	}

}
