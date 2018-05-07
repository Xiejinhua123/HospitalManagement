package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.DrugDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Drug;
import com.accp.demo.Page;

/**
 * 药品表的增删改查
 * 
 * @author 解金化  解智翔
 * @version 1.0
 * @date 2017.03.14
 *
 */
public class DrugImpl extends BaseDao implements DrugDao {

	public <T> int add(T t) {
		Drug d=(Drug)t;
		String sql="if not exists(select * from Drug where DrugId=?) insert into Drug values(?,?,?,?,?,?,?,?)";
		Object[] parm={d.getDrugId(),d.getDrugName(),d.getDrugAlias(),d.getDrugShape(),d.getDrugType(),d.getDrugNumber(),d.getDrugPrice(),d.getDrugConsumption(),d.getAttention()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		String sql="delete from Drug where DrugId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		Drug d=(Drug)t;
		String sql="Update Drug set DrugName=?,DrugAlias=?,DrugShape=?,DrugType=?,DrugNumber=?,DrugPrice=?,DrugConsumption=?,Attention=? where DrugId=?";
		Object[] parm={d.getDrugName(),d.getDrugAlias(),d.getDrugShape(),d.getDrugType(),d.getDrugNumber(),d.getDrugPrice(),d.getDrugConsumption(),d.getAttention(),d.getDrugId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Drug> getPage(int pagesize, Map<String, String> map) {
		String sql="";
		if(map==null){
			sql="select top(?) * from Drug where DrugId not in(select top((?-1)*?) DrugId from Drug)";
		}
		for(String s:map.keySet()){
			if(s.equals("DrugShape")){
				sql="select top(?) * from Drug where DrugShape ='"
					+map.get(s)
					+"' and DrugId not in(select top((?-1)*?) DrugId from Drug";
			}
			else if(s.equals("DrugType")){
				sql="select op(?) * from Drug where DrugType = '"
					+map.get(s)
					+"' and DrugId not in(select top((?-1)*?) DrugId from Drug";
			}
			else if(s.equals("DrugExpiration")){
				//根据过期时间查询，查询出过期时间大于指定时间的药品
				sql="select top(?) * from Drug d,DrugTime t where d.DrugId=t.DrugId and t.DrugExpiration>'"
					+map.get(s)
					+"' and d.DrugId not in(select top((?-1)*?) DrugId from Drug)";
			}
		}
			
			Page<Drug> page=new Page<Drug>();
			page.setList(query(sql,Drug.class,new Object[]{page.getItems(),pagesize,page.getItems()}));
			System.out.println(sql);
		return page;
	}

	public List<Drug> getById(int id) {
		return query("select * from Drug where DrugId=?", Drug.class, new Object[]{id});
	}

	public List<Drug> getDrugId(String name) {
		String sql = "select * from Drug d where d.DrugName = ?";
		return query(sql, Drug.class, new Object[]{name});
	}

}
