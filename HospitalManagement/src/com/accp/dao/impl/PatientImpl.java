package com.accp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.accp.dao.PatientDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * ���߱����ɾ�Ĳ�ʵ����
 * 
 * @author ���  ������
 * @version 1.0
 * @date 2017.03.14
 *
 */
public class PatientImpl extends BaseDao implements PatientDao {

	/**
	 * ���߱����ӷ���<br/>
	 * 
	 * �÷��������������û����<br/>
	 * 
	 * ����������û���ʱ����м�⵱ǰ���û�ע����Ϣ�����ݿ����Ƿ��ظ�
	 */
	public <T> int add(T t) {
		Patient p=(Patient)t;
		String sql="insert into Patient values(?,?,?,?,?,?,?,?,?,?)";
		Object[] parm={p.getPatNickname(),p.getPatPassword(),p.getPatName(),p.getPatCard(),p.getPatSex(),p.getPatBirthday(),p.getPatPhone(),p.getPatAddress(),p.getPatSymotoms(),p.getGeneticDisorders()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public int del(String id) {
		// TODO �Զ����ɵķ������
		String sql="if exists(select * from Patient where PatId=?) delete from Patient where PatId=?";
		Object[] parm={id,id};
		int a=executeSQL(sql, parm);
		return a;
	}

	public <T> int update(T t) {
		// TODO �Զ����ɵķ������
		Patient p=(Patient)t;
		String sql="Update Patient set PatNickname=?,PatPassword=?,PatName=?,PatCard=?,PatSex=?,PatBirthday=?,PatPhone=?,PatAddress=?,PatSymotoms=?,GeneticDisorders=? where PatId=?";
		Object[] parm={p.getPatNickname(),p.getPatPassword(),p.getPatName(),p.getPatCard(),p.getPatSex(),p.getPatBirthday(),p.getPatPhone(),p.getPatSymotoms(),p.getGeneticDisorders(),p.getPatId()};
		int a=executeSQL(sql, parm);
		return a;
	}

	public Page<Patient> getPage(int pagesize) {
		Page<Patient> page = new Page<Patient>();
		String sql = "select top(?) * from Patient where PatId not in(select top((?-1)*?) PatId from Patient)";
		page.setList(query(sql, Patient.class, new Object[]{page.getItems(),pagesize,page.getItems()}));
		return page;
	}

	public List<String> getAllColumn(String columnname) {
		// TODO �Զ����ɵķ������
		String sql = "select "+columnname+" from Patient"; // ���õ�¼���ͻ�ȡSQL���
		//System.out.println(sql); //����SQL����Ƿ���ȷ
		rs = getList(sql, new Object[]{}); // ��ȡ�����
		List<String> list = new ArrayList<String>(); // new ��  list ����
		
		try {
			while(rs.next()){ // ѭ�������
				
				String str = rs.getString(columnname);
				list.add(str); // ��������е��ַ�������ֵ��list����
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			closeAll(conn, p, rs); // �ͷ�������Դ
		}	
		
		return list;
	
	}
	public List<Patient> getById(int id) {
		// TODO �Զ����ɵķ������
		return query("select p.PatId,p.PatNickname,p.PatAddress,p.PatName,p.PatCard,p.PatBirthday,p.PatPhone,p.PatAddress,p.PatSymotoms,p.GeneticDisorders," +
				"PatSex = (select dic.TypeValus from Dictionary dic where dic.TypeCode = p.PatSex)" +
				" from patient p where PatId = ?", Patient.class, new Object[]{id});
	}

	public List<Patient> login(String name, String pwd) {
		String sql = "select * from Patient where (PatNickname = ? or PatCard = ? or PatPhone = ?) and PatPassword = ? ";
	
		return query(sql, Patient.class, new Object[]{name,name,name,pwd});
	}
	
	public static void main(String[] args) {
		List<String> list = new PatientImpl().getAllColumn("PatNickname");
		System.out.println("a");
		for (String string : list) {
			System.out.println(string);
		}		
	}

}
