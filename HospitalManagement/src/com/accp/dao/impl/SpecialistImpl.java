package com.accp.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accp.dao.SpecialistDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Specialist;
import com.accp.tools.GenerateId;

/**
 * 专家科室值班信息实现类
 * 
 * @author 解金化
 * @date 2017.03.23
 * @version 1.0
 *
 */
public class SpecialistImpl extends BaseDao implements SpecialistDao {
	
	/**
	 * 科室主任添加今日值班信息
	 * 
	 */
	public <T> int add(T t) {
		// TODO 自动生成的方法存根
		Specialist s = (Specialist)t;
		s.setDateTime(GenerateId.getDate());
		String sql = "insert into Specialist values(?,?,?)";
		Object[] obj = new Object[]{s.getDepId(),s.getDocId(),s.getDateTime()};
		
		return executeSQL(sql, obj);
	}
	
	/**
	 * 该方法不实现
	 */
	public int del(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	/**
	 * 该方法不实现
	 */
	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	/**
	 * 根据时间获取当日的专家信息
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
