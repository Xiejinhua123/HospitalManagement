package com.accp.dao;

/**
 * ���ýӿڣ�����ִ����ɾ��
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.08
 *
 */
public interface CommonInterface {
	
	/**
	 * ͨ����ӷ���<br/>
	 * 
	 * ��ִ����ӵ�ʱ��ע����Ҫ���Ȳ�ѯ���ݿ�����Ϣ���Ƿ��ظ����<br/>
	 * 
	 * ĳЩ�����ҵ��㴦��<br/>
	 * 
	 * ĳЩ�������sql����������<br/>
	 * 
	 * @param t
	 * 		�����������ͣ�ִ�����
	 * 
	 * @return
	 * 		����Ӱ������
	 * 
	 */
	public <T> int add(T t);
	
	/**
	 * ͨ��ɾ������
	 * 
	 * @param id
	 * 		��Ҫɾ����id
	 * 
	 * @return
	 * 		���ص�ǰɾ��Ӱ�������
	 */
	public int del(String id);
	
	
	/**
	 * ִ���޸�
	 *  
	 * @param t
	 * 		�޸Ķ���
	 * 
	 * @return
	 * 		ִ���޸�
	 * 
	 */
	public <T> int update(T t);
}
