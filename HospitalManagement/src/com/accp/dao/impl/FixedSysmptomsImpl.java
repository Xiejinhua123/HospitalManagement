package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.FixedSysmptomsDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.FixedSysmptoms;
import com.accp.demo.Page;

public class FixedSysmptomsImpl extends BaseDao implements FixedSysmptomsDao {

	public <T> int add(T t) {
		// TODO �Զ����ɵķ������
		FixedSysmptoms f=(FixedSysmptoms)t;
		String sql="if not exists(select * from FixedSysmptoms where FSId=?) insert into FixedSysmptoms values(?)";
		Object[] parm={f.getfSId(),f.getSysmptoms()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO �Զ����ɵķ������
		String sql="delete from FixedSysmptoms where FSId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO �Զ����ɵķ������
		FixedSysmptoms f=(FixedSysmptoms)t;
		String sql="Update FixedSysmptoms set Sysmptoms=? where FSId=?";
		Object[] parm={f.getSysmptoms(),f.getfSId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<FixedSysmptoms> getPage(int pagesize, Map<String, String> map) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public List<FixedSysmptoms> getById(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
