package com.accp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DoctorDao;
import com.accp.dao.impl.DoctorImpl;
import com.accp.demo.Doctor;
import com.accp.demo.Page;

/**
 * ������ҽ�����ҵ����
 * 
 * @author ���
 * @version 1.0
 * 
 * @time 2017.03.11
 *
 */
public class DoctorBiz {

	private Logger logger = Logger.getLogger(DoctorBiz.class);
	private DoctorDao dd = new DoctorImpl();
	
	/**
	 * ���ҽ��
	 * 
	 * @param d
	 * 		��������ӵ�ҽ���ķ�װ����
	 * 
	 * @return
	 * 		���ظôβ��������ݿ��Ӱ��̶�
	 */
	public int add(Doctor d){
		
		if(d == null){
			logger.debug("���ҽ����Ϣ������ֵΪ��");
			throw new NullPointerException("��ǰҽ����Ϣ����ȷ���޷�Ϊ�����ҽ��");
		}
		
		int a = dd.add(d);
		return a;
		
	}
	
	/**
	 * �÷���ִ��ҽ�����޸�
	 * 
	 * @param d
	 * 		��Ҫ�޸ĵ�ҽ������Ϣ��װ����
	 * 
	 * @return
	 * 		�������ݿ�Ӱ������
	 */
	public int update(Doctor d){
		
		if(d == null || d.getDocId() == null){
			logger.debug("�޸�ҽ����Ϣ��ҽ����ţ�����ҽ������Ϊ��");
			throw new NullPointerException("��ǰҽ���ύ����ȷ������ȷ�ύ��Ϣ�������޸�");
		}
		
		int a = dd.update(d);
		return a;
	}
	
	/**
	 * ִ��ɾ��
	 * 
	 * @param id
	 * 		��ǰҽ���ı��
	 * 
	 * @return
	 * 		���ص�ǰ��ɾ������
	 */
	public int del(String id){
		
		if(id == null || id.length() != 12){
			logger.debug("ɾ��ҽ����ҽ�����Ϊ��");
			throw new IllegalAccessError("��ǰҽ�������Ϣ����ȷ������ȷ��д��Ϣ");
		}
		
		int a = dd.del(id);
		return a;
		
	}
	
	/**
	 * ��ҳ��ѯ��ǰҳ���ҽ����Ϣ
	 * 
	 * @param pagesize
	 * @param map
	 * @return
	 */
	public Page<Doctor> getPage(int pagesize,Map<String, String> map){
		
		if(pagesize < 0){
			logger.debug("��ҳ��ѯҽ����ҳ�����");
			throw new IllegalAccessError("��ǰ����������������޸ĺ���������");
		}
		
		Page<Doctor> page = dd.getPage(pagesize, map);
		return page;
	}
	
	/**
	 * ����ҽ����Ų�ѯҽ����Ϣ
	 * 
	 * @param id
	 * 		��ǰҽ���ı��
	 * 
	 * @return
	 * 		���ص�ǰ��ѯ����ҽ���������û�У�����null
	 */
	public Doctor getById(String id){
		
		if(id == null || id.length() != 12){
			logger.debug("��ѯҽ����ҽ�����Ϊ��");
			throw new IllegalAccessError("��ǰҽ�������Ϣ����ȷ������ȷ��д��Ϣ");
		}
		
		List<Doctor> list = dd.getById(id);
		Doctor doc = null;
		for (Doctor d : list) {
			doc = d;
		}
		return doc;
	}
	
	/**
	 * ��ȡ��ǰҽ�������δ����Һ�����
	 * 
	 * @param docId
	 * 		ҽ������
	 * 
	 * @return
	 * 		�Һ�����
	 */
	public int getNum(String docId){
		return dd.getNumById(docId);
	}
	
	/**
	 * ҽ����¼
	 * 
	 * @param id
	 * 		ҽ������
	 * 
	 * @param pwd
	 * 		����
	 * 
	 * @return
	 * 		���ص�¼��ҽ������
	 */
	public Doctor login(String id,String pwd) throws IllegalAccessException{
		Doctor doctor = null;
		if(id == null || id.length() != 12){
			logger.info("ҽ����¼��������Ϣ����ȷ");
			throw new IllegalAccessError("idError");
		}
		if(pwd.length() < 6 || pwd == null){
			logger.info("ҽ����¼�����벻��ȷ");
			throw new IllegalAccessError("pwdError");
		}
		List<Doctor> list = new ArrayList<Doctor>(); 
		list = dd.login(id, pwd);
		for (Doctor d : list) {
			doctor = d;
		}
		return doctor;
	}
	
	public static void main(String[] args) {
		int a = new DoctorBiz().getNum("201701135677");
		System.out.println(a);
	}
}
