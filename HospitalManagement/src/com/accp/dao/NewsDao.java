package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.News;
import com.accp.demo.Page;

/**
 * ���ű����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface NewsDao extends CommonInterface {
	
	/**
	 * ��ѯ���е�����
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
	 * 
	 */
	public Page<News> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ų�ѯ����
	 * 
	 * @param id
	 * 		���������ű��
	 * 
	 * @return
	 * 		���ؼ��ϣ���ҵ��㴦��
	 */
	public List<News> getById(String id);
}
