package com.accp.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.dao.CommonDao;
import com.accp.dao.PrescriptionDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;
import com.accp.util.HibernateUtil;

public class PrescriptionImpl extends HibernateUtil implements PrescriptionDao{
	CommonDao<Prescription> c=new CommonDaoImpl<Prescription>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		return c.del(Prescription.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(Prescription.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		Prescription u=(Prescription)t;
		boolean b=false;
		try{
			Prescription a=(Prescription) s.get(Prescription.class,u.getPreId());
			if(u.getDoctorOffer()!=null) a.setDoctorOffer(u.getDoctorOffer());
			if(u.getDrug()!=null)a.setDrug(u.getDrug());
			if(u.getDrugNum()!=null) a.setDrugNum(u.getDrugNum());
			if(u.getDrugUnit()!=null) a.setDrugUnit(u.getDrugUnit());
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}	
		return b;
	}

	@Override
	public Prescription getById(Integer preId) {
		Session s=HibernateUtil.currentSession();
		Prescription p=(Prescription) s.get(Prescription.class, preId);
		return  p;
	}

	@Override
	public List<Prescription> getByDrug(Drug drug) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(Prescription.class);
		Criterion c1=Restrictions.eq("drug", drug);
		c.add(c1);
		List<Prescription> list=c.list();
		return list;
	}

	@Override
	public List<Prescription> getByDocoff(DoctorOffer docoff) {
		Session s=HibernateUtil.currentSession();
		Criteria c=s.createCriteria(Prescription.class);
		Criterion  c1=Restrictions.eq("DoctorOffer", docoff);
		c.add(c1);
		List<Prescription> list=c.list();
		return list;
	}

	@Override
	public List<Prescription> getUsersId(String id) {
		// TODO 自动生成的方法存根
		Session session=HibernateUtil.currentSession();
		String hql="From Prescription p where p.doctorOffer.users.usersId=?";
		Query query=session.createQuery(hql);
		List<Prescription> list=query.list();
		return list;
	}

}
