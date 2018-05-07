package com.accp.impl;

import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.ReportDao;
import com.accp.demo.Registered;
import com.accp.demo.Report;
import com.accp.util.HibernateUtil;

public class ReportImpl extends HibernateUtil implements ReportDao
{
	CommonDao<Report> c=new CommonDaoImpl<Report>();
	@Override
	public <T> Object add(T t) {
		return c.save(t);
	}

	@Override
	public boolean del(String id) {
		return c.del(Report.class, id);
	}

	@Override
	public boolean del(int id) {
		return c.del(Report.class, id);
	}

	@Override
	public <T> boolean update(T t) {
		Session s=HibernateUtil.currentSession();
		Report u=(Report)t;
		boolean b=false;
		try{
			Report a=(Report) s.get(Registered.class,u.getRepId());
			if(u.getUsersByRepReview()!=null)a.setReportTime(u.getReportTime());
			if(u.getUsersByRepAuthor()!=null)a.setUsersByRepAuthor(u.getUsersByRepAuthor());
			if(u.getReportTime()!=null)a.setReportTime(u.getReportTime());
			if(u.getRepCon()!=null)a.setRepCon(u.getRepCon());
			if(u.getRepReply()!=null)a.setRepReply(u.getRepReply());
			if(u.getReplyTime()!=null)a.setReplyTime(u.getReplyTime());
			if(u.getRepType()!=null)a.setRepType(u.getRepType());
			
		}
		catch(Exception e)
		{
			b=false;
			e.getMessage();
		}	
		return b;
	}

}
