package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Drug;
import com.accp.demo.Page;

/**
 * ҩƷ����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface DrugDao extends CommonInterface {

	/**
	 * ��ѯ��ǰҩƷ��Ϣ
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ��Լ���ѯ����
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Drug> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ų�ѯҩƷ��Ϣ
	 * 	
	 * @param id
	 * 		��������Ҫ��ѯ�ı��
	 * 
	 * @return
	 * 		���ص�ǰ�Ĳ�ѯ�Ķ�����ҵ��㴦��
	 */
	public List<Drug> getById(int id);
	
	/**
	 * ͨ��ҩƷ���ƻ�ȡҩƷ�ı��
	 * 
	 * @param name
	 * 		ҩƷ����
	 * @return
	 * 		ҩƷ���
	 */
	public List<Drug> getDrugId(String name);
}
