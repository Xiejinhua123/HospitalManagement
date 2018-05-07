package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.Report;

/**
 * ��������ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface ReportDao extends CommonInterface {
	
	/**
	 * ��ѯ���б���
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ���ѯ����
	 * 
	 * @return
	 * 		���ص�ǰҳ�����
	 */
	public Page<Report> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param id
	 * 		����������ı��
	 * 
	 * @return
	 * 		���ص�ǰ��ŵĶ��󼯺ϣ���ҵ��㴦��
	 */
	public List<Report> getById(String id);
}
