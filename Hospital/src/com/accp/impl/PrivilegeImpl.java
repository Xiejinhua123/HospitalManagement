package com.accp.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.PrivilegeDao;
import com.accp.demo.Privilege;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;

public class PrivilegeImpl extends HibernateUtil implements PrivilegeDao{
	CommonDao<Privilege> c=new CommonDaoImpl<Privilege>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		
		return c.del(Privilege.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(Privilege.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		Privilege u=(Privilege)t;
		boolean b=false;
		try{
			Privilege a=(Privilege) s.get(Privilege.class,u.getPriId());
			if(u.getPriName()!=null) a.setPriName(u.getPriName());
			if(u.getParentId()!=null) a.setParentId(u.getParentId());
			if(u.getMemo()!=null)a.setMemo(u.getMemo());
			if(u.getMenuPic()!=null)a.setMenuPic(u.getMenuPic());
			if(u.getMenuUrl()!=null)a.setMenuUrl(u.getMenuUrl());
			if(u.getDisplayOrder()!=null) a.setDisplayOrder(u.getDisplayOrder());
			if(u.getCreateTime()!=null) a.setCreateTime(u.getCreateTime());
			if(u.getModifyTime()!=null) a.setModifyTime(u.getModifyTime());
			if(u.getEnableds()!=null) a.setEnableds(u.getEnableds());
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
	public List<Privilege> getByColumn(Privilege p) {
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(p);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(p);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Privilege> list=q.list();
		return list;
	}

}
