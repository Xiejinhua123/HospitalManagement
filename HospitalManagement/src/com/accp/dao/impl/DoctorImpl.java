package com.accp.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accp.dao.DoctorDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Doctor;
import com.accp.demo.Page;

/**
 * 医生表的增删改查
 * 
 * @author 解金化  解智翔
 * @version 1.0
 * @date 2017.03.14
 *
 */
public class DoctorImpl extends BaseDao implements DoctorDao {

	public <T> int add(T t) {
	
		Doctor d=(Doctor)t;		
		String sql="if not exists(select * from Doctor where DocId=?) insert into Doctor values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] parm={d.getDocId(),d.getDocId(),d.getTrueName(),d.getIdCard(),d.getDocSex(),d.getDocBirthday(),d.getSchoolRecord(),d.getTelePhone(),d.getOfficePhone(),d.getOnjobState(),d.getEmail(),d.getDepartmentId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		
		String sql="delete from Doctor where DocId=?";
		Object[] parm={id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		
		Doctor d=(Doctor)t;
		String sql="Update Doctor set TrueName=?,IdCard=?,DocSex=?,DocBirthday=?,SchoolRecord=?,TelePhone=?,OfficePhone=?,OnjobState=?,Email=?,DepartmentId=? where DocId=?";
		Object[] parm={d.getTrueName(),d.getIdCard(),d.getDocSex(),d.getDocBirthday(),d.getSchoolRecord(),d.getTelePhone(),d.getOfficePhone(),d.getOnjobState(),d.getEmail(),d.getDepartmentId(),d.getDocId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Doctor> getPage(int pagesize, Map<String, String> map) {
		String sql = "";
		Page<Doctor> page = new Page<Doctor>();
		Object[] obj =  new Object[]{page.getItems(),pagesize,page.getItems()};
		
		if(map == null){
			sql = "select top(?) * from Doctor where DocId not in(select top((?-1)*?) DocId from Doctor)";
		}else{
			for (String s : map.keySet()) {
				
				if(s.equals("depId"))
					sql = "select top(?) * from Doctor doc,[User] u where doc.DepartmentId = "
							+ map.get(s) +
							" and doc.DocId not in (select top((?-1)*?) DocId" +
							" from Doctor) and u.UserId = doc.DocId" +
							" and u.OnlineState = '1001'";
					
				else if(s.equals("sex"))
					sql = "select top(?) * from Doctor doc,[User] u where doc.docSex = "
							+ map.get(s) +
							" and doc.DocId not in (select top((?-1)*?) DocId" +
							" from Doctor) and u.UserId = doc.DocId" +
							" and u.OnlineState = '1001'";
			}
		}
		page.setList(query(sql, Doctor.class,obj));
		//System.out.println(sql);
		return page;
	}

	public List<Doctor> getById(String doctorid) {
		// TODO Auto-generated method stub
		String sql = "select d.DocId,d.TrueName,d.IdCard,d.DocBirthday,d.TelePhone,d.OfficePhone,d.Email,d.DepartmentId," +
				"DocSex = (select dic.TypeValus from Dictionary dic where dic.TypeCode = d.DocSex)," +
				"SchoolRecord = (select dic.TypeValus from Dictionary dic where dic.TypeCode = d.SchoolRecord)," +
				"OnjobState = (select dic.TypeValus from Dictionary dic where dic.TypeCode = d.OnjobState)," +
				"duty = (select dic.TypeValus from Dictionary dic where dic.TypeCode = d.Duty) from Doctor d" +
				" where d.DocId = ?";
		
		return query(sql, Doctor.class, new Object[]{doctorid});
	}
	
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("depId", "1005");
		System.out.println(new DoctorImpl().getPage(1,map).getList());
		
		//System.out.println(new DoctorImpl().getById("aaaaa"));
	}

	public int getNumById(String id) {
		
		String sql = "select COUNT(*) wateNum from Registered reg" +
				" where reg.DocId = ? and " +
				"convert(date,reg.RegTime) = CONVERT(date,GETDATE())" +
				" and reg.RegState = '501'";
	
		Object[] obj = new Object[]{id};
		rs = getList(sql, obj);
		int num = 0;
		try {
			while(rs.next()){
				num = rs.getInt("wateNum"); // 获取当前的医生今天的挂号数量
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, p, rs);
		}			 
		return num;
	}

	public List<Doctor> login(String id, String pwd) {

		String sql = "select doc.DocId,doc.TrueName,doc.IdCard,doc.DocBirthday,doc.TelePhone,doc.OfficePhone,doc.Email,doc.DepartmentId," +
				"DocSex = (select TypeValus from Dictionary where TypeCode = doc.DocSex)," +
				"SchoolRecord = (select TypeValus from Dictionary where TypeCode = doc.SchoolRecord)," +
				"OnjobState = (select TypeValus from Dictionary where TypeCode = doc.OnjobState)," +
				"Duty = (select TypeValus from Dictionary where TypeCode = doc.Duty)" +
				"from Doctor doc,[User] u where doc.DocId = u.UserId and doc.DocId = ? and u.UserPassword = ?";
		Object[] obj = new Object[]{id,pwd};
		
		return query(sql, Doctor.class, obj);
	}

}
