package com.accp.dao;

import java.util.List;

import com.accp.demo.Page;

/**
 * ��ɫ����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface Role extends CommonInterface {
	
	/**
	 * ��ѯ��ɫ��Ϣ
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Role> getPage(int pagesize);
	
	/**
	 * ����id��ѯ��ɫ��Ϣ
	 * 
	 * @param id
	 * 	��������ǰ��ѯ��ɫ�ı��
	 *  
	 * @return
	 * 		���ؽ�ɫ��Ϣ����ҵ���߼��㴦��
	 */
	public List<Role> getById(int id);
}
