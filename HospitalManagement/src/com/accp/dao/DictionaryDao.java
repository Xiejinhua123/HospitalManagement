package com.accp.dao;

import java.util.List;

import com.accp.demo.Dictionary;

/**
 * �����ֵ����ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.08
 */
public interface DictionaryDao extends CommonInterface{
	
	/**
	 * 	�ڳ���ʼǰִ�и÷���
	 * 	
	 * 	���ֵ��е������ֶη��빫�������ݼ��ϣ�common.dictionaryMap����
	 * 	�����ѯ ���������������н��в�ѯ ��
	 * 
	 * @return
	 *		���ص�ǰ���鼮�ֵ伯��
	 */
	public List<Dictionary> getAll();
	
	/**
	 * ͨ���ֶε�Ψһֵ�����ֶε���Ϣ
	 * 
	 * @param code
	 * 	��������Ҫ���ҵ��ֶε�Ψһֵ
	 *  
	 * @return
	 * 	����ѯ���������Ϣ����װΪ���󷵻�
	 * 	��ҵ��㴦��
	 */
	public List<Dictionary> getByCode(String code);
}
