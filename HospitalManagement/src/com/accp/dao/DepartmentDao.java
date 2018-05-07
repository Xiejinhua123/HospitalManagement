package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Department;
import com.accp.demo.Page;

/**
 * ���ұ���ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface DepartmentDao extends CommonInterface {
	
	/**
	 * ��ѯ���п�����Ϣ
	 * ��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<Department> getPage(int pagesize);
	
	/**
	 * ͨ�����ұ�Ų�ѯ������Ϣ
	 *
	 *@param id
	 *		���ұ��
	 *
	 * @return
	 * 		�Żص�ǰ�Ŀ�����Ϣ����ҵ���߼��㴦��
	 */
	public List<Department> getById(int id);
	
	/**
	 * ��ȡ���еĿ�����Ϣ
	 * 
	 * @return
	 * 		���п��ҵļ���
	 */
	public List<Department> getAll(Map<String, String> map);
	
}
