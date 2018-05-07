package com.accp.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.dao.PatientDao;
import com.accp.demo.Patient;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class PatientImpl implements PatientDao {

	CommonDao<Patient> c = new CommonDaoImpl<Patient>();

	@Override
	public <T> Object add(T t) {
		Patient p = (Patient)t;
	
		Object s = c.save(t);
		return s;
	}

	@Override
	public boolean del(String id) {

		return c.del(Patient.class, id);

	}

	@Override
	public <T> boolean update(T t) {
		Session s = HibernateUtil.currentSession();
		Patient u = (Patient) t;
		boolean b = false;
		try {
			Patient a = (Patient) s.get(Patient.class, u.getPatId());
			
			if (u.getPatPassword() != null)
				a.setPatPassword(u.getPatPassword());
			if (u.getPatName() != null)
				a.setPatName(u.getPatName());
			if (u.getPatCard() != null)
				a.setPatCard(u.getPatCard());
			if (u.getPatSex() != null)
				a.setPatSex(u.getPatSex());	
			if (u.getPatBirthday() != null)
				a.setPatBirthday(u.getPatBirthday());
			if (u.getPatPhone() != null)
				a.setPatPhone(u.getPatPhone());
			if (u.getPatAddress() != null)
				a.setPatAddress(u.getPatAddress());
			if (u.getPatSymotoms() != null)
				a.setPatSymotoms(u.getPatSymotoms());
			if (u.getGeneticDisorders() != null)
				a.setGeneticDisorders(u.getGeneticDisorders());
			if (u.getOnlineState() != null)
				a.setOnlineState(u.getOnlineState());
			if (u.getCreateTime() != null)
				a.setCreateTime(u.getCreateTime());
			if (u.getModifyTime() != null)
				a.setModifyTime(u.getModifyTime());
			if (u.getLastLogin() != null)
				a.setLastLogin(u.getLastLogin());
			if (u.getRegistereds() != null)
				a.setRegistereds(u.getRegistereds());
		} catch (Exception e) {
			b = false;
			System.out.println(e.getMessage());
		}
		return b;
	}

	@Override
	public boolean del(int id) {
		return c.del(Patient.class, id);
	}

	@Override
	public void getPage(Page<Patient> page, Patient p) {
		Session session = HibernateUtil.currentSession();
		String sql = Generate.getSql(p);
		Query query = session.createQuery(sql);
		// 参数一 一页多少条
		// 参数二 从哪开始(页数-1)*每页条数
		// map 动态查询 where 后条件
		// select top ? * from user where userId not in (select top ? userId
		// from user)
		Map<String, Object> map = Generate.getParams(p);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); // 总条目数
		query.setFirstResult((page.getPagesize() - 1) * page.getItems()); // 从第几行开始
		query.setMaxResults(page.getItems()); // 一页多少行
		List<Patient> list = query.list();
		page.setList(list);

	}

	@Override
	public List<Patient> getByColumn(Patient p) {
		Session s = HibernateUtil.currentSession();
		String hql = Generate.getSql(p);
		Query q = s.createQuery(hql);
		Map<String, Object> map = Generate.getParams(p);
		for (String str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<Patient> list = q.list();
		return list;
	}

}
