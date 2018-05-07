package com.accp.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.FixedPrescriptionDao;
import com.accp.demo.Drug;
import com.accp.demo.FixedPrescription;
import com.accp.demo.FixedSysmptoms;
import com.accp.util.HibernateUtil;

public class FixedPrescriptionimpl extends HibernateUtil implements FixedPrescriptionDao {

	@Override
	public <T> Object add(T t) {
		Session s=HibernateUtil.currentSession();
		FixedPrescription u=(FixedPrescription)t;
		Serializable result=s.save(t);
		Integer RoleId=Integer.parseInt((String) result);
		u=(FixedPrescription) s.get(FixedPrescription.class, RoleId);
		return u;
	}

	@Override
	public boolean del(String id) {
		Session s=HibernateUtil.currentSession();
		boolean b=true;
		try{
			FixedPrescription u=(FixedPrescription) s.get(FixedPrescription.class, id);
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
		FixedPrescription u=(FixedPrescription)t;
		boolean b=false;
		try{
			FixedPrescription a=(FixedPrescription) s.get(FixedPrescription.class, u.getFpid());
			if(u.getFixedSysmptoms()!=null)a.setFixedSysmptoms(u.getFixedSysmptoms());
			if(u.getDrug()!=null)a.setDrug(u.getDrug());
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
			FixedPrescription u=(FixedPrescription) s.get(FixedPrescription.class, id);
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
	public List<FixedPrescription> getByFixedSysmptoms(FixedSysmptoms f) {
		
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(FixedPrescription.class);
		c.add(Restrictions.eq("FixedPrescription", f));
		return c.list();
	}

	@Override
	public FixedPrescription getById(Integer id) {
		Session s=HibernateUtil.currentSession();
		FixedPrescription f=(FixedPrescription) s.get(FixedPrescription.class, id);
		return f;
	}

	@Override
	public List<FixedPrescription> getByDrug(Drug drug) {
		return null;
	}

}
