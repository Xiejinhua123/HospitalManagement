package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * ������Ϣ����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *	2017.03.08
 */
public interface PatientDao extends CommonInterface {
	
	/**
	 * 	��ѯ������Ϣ
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		��ǰҳ����
	 * 
	 */
	public Page<Patient> getPage(int pagesize);
	
	/**
	 * ����������ѯ
	 * 
	 * �÷������ڽ����еĻ��ߵ绰���û��������֤����Ϣ��������������
	 * 
	 * ���ڼ���û��ύ��Ϣ�Ƿ��Ѿ���ע��
	 * 
	 * ������̨���ʱ����
	 * 
	 * @return
	 * 		���ػ��߱��еĸ��е�������Ϣ
	 */
	public List<String> getAllColumn(String columnname);
	
	/**
	 * 	���ݱ�Ų�ѯ����
	 * 
	 * @param id
	 * 		���������߱��
	 * 	
	 * @return
	 * 		���ػ�����Ϣ����ҵ��㴦��
	 */
	public List<Patient> getById(int id);
	
	/**
	 * ��¼����
	 * 
	 * @param name
	 * 		�û���
	 * 
	 * @param pwd
	 * 		����
	 * 
	 * @return
	 * 		��½�ɹ������ص�ǰ�ĵ�¼���󣬷��ؼ��ϣ���ҵ��㴦��
	 * 		��¼ʧ�ܣ�����null
	 */
	public List<Patient> login(String name, String pwd);
	
}
