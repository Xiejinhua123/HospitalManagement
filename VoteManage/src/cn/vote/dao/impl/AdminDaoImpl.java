package cn.vote.dao.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.AdminDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Users;
import cn.vote.util.UtilHibernate;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> login(String name, String pwd) {
		return super.getHibernateTemplate().find("from Admin where manageAccount=? and managePassword=?",name,pwd);
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkName(String name) {
		List<Users> list= super.getHibernateTemplate().find("from Admin where manageAccount=?",name);
		if(list==null || list.size()<1)
		{
			return false;
		}
		 return true;
	}
	
	@Override
	public void insert(Admin a) {
		
		super.getHibernateTemplate().save(a);
		
	}

	@Override
	public Admin getById(Integer adminId) {
		return super.getHibernateTemplate().get(Admin.class, adminId);
	}

	@Override
	public List<Admin> getAll() {
		return super.getHibernateTemplate().find("from Admin order by rank");
	}

	@Override
	public void updateAdmin(Admin a) {
		Admin a1=super.getHibernateTemplate().get(Admin.class, a.getId());
		try {
			Admin a2=UtilHibernate.Compare(a1, a);
			super.getHibernateTemplate().update(a2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void addAdmin(Admin a) {
		super.getHibernateTemplate().save(a);
	}
}
