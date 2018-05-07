package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Doctor;
import com.accp.demo.Page;

/**
 * ҽ������ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface DoctorDao extends CommonInterface{
	
	/**
	 * 	��ѯ����ҽ����Ϣ
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ�� 
	 * @param map
	 * 		��ѯ�����ͣ��Լ���ѯ������
	 * 
	 * @return
	 * 	��ǰҳ����
	 * 	
	 */
	public Page<Doctor> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ����ҽ����ţ���ȡ��ǰҽ������ĹҺ�����
	 * 
	 * @param id
	 * 		ҽ�����
	 * 
	 * @return
	 */
	public int getNumById(String id);
	
	/**
	 * ͨ��ҽ����Ų�ѯҽ����Ϣ
	 * 
	 * @param map
	 * 		��ѯ��𣬲�ѯ����
	 * 
	 * @return
	 * 		���ز�ѯ���ϣ���ҵ���߼��㴦��
	 */
	public List<Doctor> getById(String doctorid);
	
	/**
	 * ҽ����¼�˺�
	 * @param id
	 * 		ҽ������
	 * 
	 * @param pwd
	 * 		ҽ������
	 * 
	 * @return
	 * 		���ص�¼���ҽ������
	 */
	public List<Doctor> login(String id,String pwd);
}
