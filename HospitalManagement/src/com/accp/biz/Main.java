package com.accp.biz;

import java.util.List;

import com.accp.dbpool.BaseDao;
import com.accp.demo.Department;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String sql = "if not exists(select * from Department where DepName='脑外科') insert into Department values('脑外科','二楼201')";
//		int a = new BaseDao().executeSQL(sql,new Object[]{});
//		System.out.println(a);
//		
		sql = "select * from Department";
		List<Department> list = new BaseDao().query(sql, Department.class, new Object[]{});
		for (Department d : list) {
			System.out.println(d.getDepId()+"" + d.getDepName() + d.getDepAddress());
		}
		
		
		
		
		
		
		
		
		
//		List<String> list = new ArrayList<String>();
//		
//		StringBuffer a = null;
//		for(int i = 5000; i < 10000; i++){
//			a = new StringBuffer( "20170311" );
//			if(i < 10)a.append("000");
//			else if(i < 100)a.append("00");
//			else if(i < 1000)a.append("0");
//			a.append(i + "");
//			list.add(a.toString());
//			
//		}
////		for (String string : list) {
////			System.out.println(string);
////		}
//		
//		String id = GenerateId.getId(); // 系统生成用户编号
//		
//		boolean b = false;
//		
//		do{
//			b = false; // 假设没有相同的id生成
//			for (String str : list) {
//				
//				if(str.equals(id)){
//					b = true;
//					id = GenerateId.getId();
//				}									
//			}
//		}while(b);
//		System.out.println(id);
	}

}
