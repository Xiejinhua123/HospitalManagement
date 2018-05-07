package com.accp.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accp.dao.SpecialistDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Specialist;
import com.accp.tools.GenerateId;

/**
 * ר�ҿ���ֵ����Ϣʵ����
 * 
 * @author ���
 * @date 2017.03.23
 * @version 1.0
 *
 */
public class SpecialistImpl extends BaseDao implements SpecialistDao {
	
	/**
	 * ����������ӽ���ֵ����Ϣ
	 * 
	 */
	public <T> int add(T t) {
		// TODO �Զ����ɵķ������
		Specialist s = (Specialist)t;
		s.setDateTime(GenerateId.getDate());
		String sql = "insert into Specialist values(?,?,?)";
		Object[] obj = new Object[]{s.getDepId(),s.getDocId(),s.getDateTime()};
		
		return executeSQL(sql, obj);
	}
	
	/**
	 * �÷�����ʵ��
	 */
	public int del(String id) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	
	/**
	 * �÷�����ʵ��
	 */
	public <T> int update(T t) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	
	/**
	 * ����ʱ���ȡ���յ�ר����Ϣ
	 */
	public List<Specialist> getByTime(Map<String,String> map) {

		String time = GenerateId.getDate();
		
		StringBuffer sql = new StringBuffer("select * from specialist where CONVERT(date,[datetime]) = ?");
		Object[] obj = new Object[]{time};
		
		if(map != null){
			for (String s : map.keySet()) {
				if(s.equals("depId")){
					sql.append(" and depId = ?");
					obj[obj.length] = map.get(s);
				}
			}
		}
		
		return query(sql.toString(), Specialist.class, obj);
	}

}
