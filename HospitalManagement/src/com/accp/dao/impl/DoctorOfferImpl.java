package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.DoctorOfferDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;
/***
 * 就诊表的增删改查
 * @author 解金化 解智翔
 * @version 1.0
 * @date 2017.3.15
 *
 */
public class DoctorOfferImpl extends BaseDao implements DoctorOfferDao {

	public <T> int add(T t) {
		// TODO 自动生成的方法存根
		DoctorOffer d=(DoctorOffer)t;
		String sql="if not exists(select * from DoctorOffer where DOId=?) insert into DoctorOffer values(?,?,?)";
		Object[] parm={d.getdOId(),d.getDocId(),d.getRegId(),d.getSympton()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		String sql="delete from DoctorOffer where DOId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		DoctorOffer d=(DoctorOffer)t;
		String sql="Update DoctoeOffer set DocId=?,RegId=?,Symptom=? where DOId=?";
		Object[] parm={d.getDocId(),d.getRegId(),d.getSympton(),d.getdOId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<DoctorOffer> getPage(int pagesize, Map<String, String> map) {
		Page<DoctorOffer> page = new Page<DoctorOffer>();
		page.setPagesize(pagesize);
		StringBuffer sql = new StringBuffer("select top(?) * from DoctorOffer where DOId not in(select top((?-1)*?) DOId from DoctorOffer)");
		Object[] obj = new Object[]{page.getItems(),pagesize,page.getItems()};
		
		if(map != null){
			for (String s : map.keySet()) {
				if(s.equals("DocId")){
					sql.append(" and DocId = " + map.get("DocId"));
				}
				if(s.equals("RegId")){
					sql.append(" and RegId = " + map.get("RegId"));					
				}
			}
		}
		page.setList(query(sql.toString(), DoctorOffer.class, obj));
		return page;
	}

	public List<DoctorOffer> getById(int id) {
		
		String sql = "select * from DoctorOffer where DOId = ?";
		return query(sql, DoctorOffer.class, new Object[]{id});
	}

	public List<DoctorOffer> getByReg(int regId) {
		
		String sql = "select * from DoctorOffer d where d.RegId = ?";
		return query(sql, DoctorOffer.class, new Object[]{regId});
		
	}

}
