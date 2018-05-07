package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.RoleDao;
import com.accp.demo.Registered;
import com.accp.demo.Roles;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class RoleImpl extends HibernateUtil implements RoleDao{

	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		Roles u=(Roles)t;
		Serializable result=s.save(t);
		int 	RoleId=Integer.parseInt(result.toString());
		u=(Roles) s.get(Roles.class, RoleId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			Roles u=(Roles) s.get(Roles.class, id);
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
		Roles u=(Roles)t;
		boolean b=false;
		try{
			Roles a=(Roles) s.get(Roles.class, u.getRolesId());
			if(u.getRoleName()!= null) a.setRoleName(u.getRoleName());
			if(u.getCreateTime()!=null)a.setCreateTime(u.getCreateTime());
			if(u.getModifyTime()!=null) a.setModifyTime(u.getModifyTime());
			if(u.getEnableds()!=null)a.setEnableds(u.getEnableds());
			if(u.getUserRoles()!=null) a.setUserRoles(u.getUserRoles());
			if(u.getRolePrivileges()!=null)a.setRolePrivileges(u.getRolePrivileges());
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
			Roles u=(Roles) s.get(Roles.class, id);
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
	public void getPage(Page<Roles> page, Roles r) {
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
		List<Roles> list = query.list();
		page.setList(list);
		
	}

	@Override
	public List<Roles> getByColumn(Roles r) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(r);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(r);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Roles> list=q.list();
		return list;
	}

}
