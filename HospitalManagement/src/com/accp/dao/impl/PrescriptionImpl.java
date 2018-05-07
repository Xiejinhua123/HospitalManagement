package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.PrescriptionDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Page;
import com.accp.demo.Prescription;

public class PrescriptionImpl extends BaseDao implements PrescriptionDao {

	public <T> int add(T t) {
		Prescription p = (Prescription) t;
		String sql = "insert into Prescription (DOId,DrugId,DrugNum) values(?,?,?)";
		Object[] obj = new Object[]{p.getDoId(),p.getDrugId(),p.getDrugNum()};
		return executeSQL(sql, obj);
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public Page<Prescription> getPage(int pagesize, Map<String, String> map) {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<Prescription> getById(int id) {

		String sql = "select p.*,d.DrugName DrugName,d.DrugPrice DrugPrice from Prescription p,Drug d where p.DrugId = d.DrugId and p.DOId = ?";
		return query(sql, Prescription.class, new Object[]{id});
		
	}
	
	public static void main(String[] args) {
		List<Prescription> list = new PrescriptionImpl().getById(17);
		for (int i = 0; i < list.size(); i++) {
			
			Prescription p = list.get(i);
			System.out.println("名称："+p.getDrugName()+"数量："+p.getDrugNum()+"单价："+p.getDrugPrice());
			
		}
		
		
	}

}
