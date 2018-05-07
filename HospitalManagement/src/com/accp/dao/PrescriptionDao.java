package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Prescription;

/**
 * ��������ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface PrescriptionDao extends CommonInterface {

	/**
	 * ��ѯ��ǰҳ��ļ���
	 * ��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ���ѯ����
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Prescription> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param id
	 * 		��������ǰ��ѯ�ı��
	 * 
	 * @return
	 * 		���ز�ѯ������ļ��ϣ���ҵ��㴦��
	 */
	public List<Prescription> getById(int id);
}
