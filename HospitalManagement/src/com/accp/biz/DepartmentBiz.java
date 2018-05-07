package com.accp.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DepartmentDao;
import com.accp.dao.impl.DepartmentImpl;
import com.accp.demo.Department;
import com.accp.demo.Page;

/**
 * ���ұ��ҵ�����
 * 
 * @author ���
 * 
 * @version 1.1
 * 
 * @time 2017.03.11
 *
 */
public class DepartmentBiz {
	
	private Logger logger = Logger.getLogger(DepartmentBiz.class);
	private DepartmentDao dd = new DepartmentImpl();
	
	/**
	 * �÷�������ִ�п������
	 *  
	 * @param d
	 * 		��Ҫ��ӵĿ�����Ϣ����
	 * 
	 * @return
	 * 		��������Ӱ������
	 */
	public int add(Department d) throws NullPointerException,SQLException{
		
		if(d == null){
			logger.debug("��ӿ��ң�����Ϊ��");
			throw new NullPointerException("ִ��ʧ�ܣ�û�п�����Ҫ���");
		}
		int a = dd.add(d);
		return a;
	}
	
	/**
	 * ����ִ��ɾ������
	 * 
	 * @param id
	 * 		��Ҫɾ���Ŀ��ҵı��
	 * 
	 * @return
	 * 		����ɾ�������ݿ��Ӱ��
	 * 
	 * @throws IllegalAccessException
	 * 		���ݷǷ������쳣
	 */
	public int del(int id) throws IllegalAccessException{
		
		if(id < 10000){
			logger.debug("ɾ������������ȷ");
			throw new IllegalAccessError("ɾ����Ų���ȷ");
		}
		int a = dd.del(id+"");
		return a;
	}
	
	/**
	 * �����޸Ŀ�����Ϣ
	 * 
	 * @param d
	 * 		��Ҫ�޸ĵĿ��ҵ���Ϣ��װ����
	 * 
	 * @return
	 * 		�������ݿ�Ӱ������
	 * 
	 * @throws NullPointerException
	 * 		��ֵ�쳣
	 * @throws SQLException
	 * 		���ݿ��쳣
	 */
	public int update(Department d) throws NullPointerException,SQLException{
		
		if(d == null){
			logger.debug("�޸ģ�����Ϊ��");
			throw new NullPointerException("��ǰ�޸ĵ���ϢΪ��");
		}
		int a = dd.update(d);
		return a;
	}
	
	/**
	 * ��ȡ��ǰҳ�������
	 * 
	 * @param pagesize
	 * 		��������ǰҳ��
	 * 
	 * @return
	 * 		���ص�ǰҳ���µ�������Ϣ
	 * 
	 * @throws IllegalAccessException
	 * 		�Ƿ������쳣
	 */
	public Page<Department> getPage(int pagesize) throws IllegalAccessException{
		
		if(pagesize <= 0){
			logger.debug("��ʾ���ң�ҳ��Ϊ��");
			throw new IllegalAccessException("��ǰ��ҳ������ȷ");
		}
		Page<Department> pages = dd.getPage(pagesize);
		return pages;
	}
	
	/**
	 * ���ݿ��ұ�Ų�ѯ������Ϣ
	 * 
	 * @param id
	 * 		���ұ��
	 * 
	 * @return
	 * 		���ص�ǰ�Ŀ��ҵķ�װ����
	 * 
	 * @throws IllegalAccessException
	 * 		���ݵĲ����쳣
	 */
	public Department getById(int id) throws IllegalAccessException{
		
		if(id < 1000){
			logger.debug("��ȡ��ǰ������Ϣ�������쳣");
			throw new IllegalAccessError("��ǰ�Ŀ��ұ�Ų���ȷ���޷����в�ѯ");
		}
		
		/**
		 * �����ݿ������Ϣ������
		 * 
		 * ���ݿ�id��Ψһ
		 * ֻ����һ����Ϣ
		 */
		List<Department> list = dd.getById(id);
		Department dd = null;
		for (Department d : list) {
			dd = d;
		}
		return dd;
	}
	
	/**
	 * ��ȡ���еĿ�����Ϣ
	 * 
	 * @return
	 * 		���ؿ��ҵļ���
	 */
	public List<Department> getAll(Map<String,String> map){
		List<Department> list = dd.getAll(map);
		return list;
	}
}
