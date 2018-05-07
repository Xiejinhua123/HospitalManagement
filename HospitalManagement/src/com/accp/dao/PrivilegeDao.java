package com.accp.dao;

import java.util.List;

import com.accp.demo.Page;
import com.accp.demo.Privilege;

/**
 * Ȩ�ޱ���ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface PrivilegeDao extends CommonInterface {
	
	/**
	 * ��ѯ���е�Ȩ��
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Privilege> getPage(int pagesize);
	
	/**
	 * ����Ȩ�ޱ�Ų�ѯ���Ȩ��
	 * 
	 * @param id
	 * 		Ȩ�ޱ��
	 * 
	 * @return
	 * 		���ص�ǰ���󼯺ϣ���ҵ�����д���
	 */
	public List<Privilege> getById(int id);
}
