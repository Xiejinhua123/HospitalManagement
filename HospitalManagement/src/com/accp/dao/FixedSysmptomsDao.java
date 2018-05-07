package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.FixedSysmptoms;
import com.accp.demo.Page;

/**
 * �̶�֢״����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface FixedSysmptomsDao extends CommonInterface {
	
	/**
	 * ��ѯ������Ϣ
	 * ��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ��Ͳ�ѯ����
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<FixedSysmptoms> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ų�ѯ����
	 * 
	 * @param id
	 * 		��������Ҫ��ѯ�Ķ�����
	 * 
	 * @return
	 * 		���ز�ѯ���󼯺ϣ���ҵ���߼��㴦��
	 */
	public List<FixedSysmptoms> getById(int id);
}
