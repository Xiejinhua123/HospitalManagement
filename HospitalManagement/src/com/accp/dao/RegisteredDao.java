package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Registered;

/**
 * �Һ���Ϣ����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface RegisteredDao extends CommonInterface {
	
	/**
	 * ��ѯ�Һ���Ϣ
	 * ��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��ҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ���ѯ����
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Registered> getPage(int pagesize,Map<String,String> map); 
	
	/**
	 * ���ݱ�Ų�ѯ�Һ���Ϣ
	 * 
	 * @param id
	 * 		�Һű��
	 * 
	 * @return
	 * 		���ص�ǰ���󼯺ϣ���ҵ���߼��㴦��
	 * 
	 */
	public List<Registered> getById(int id);
	
	/**
	 * ͨ��ҽ����ѯ�����û�д���ĹҺ���Ϣ
	 * 
	 * @param doctorId
	 * 		ҽ������
	 * 
	 * @return
	 * 		���عҺ���Ϣ
	 */
	public List<Registered> getNoDispose(String doctorId);
		
}
