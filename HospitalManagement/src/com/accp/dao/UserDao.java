package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Page;
import com.accp.demo.User;

/**
 * �û������ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * 
 *	2017.03.08
 *
 */
public interface UserDao extends CommonInterface {
		
	/**
	 * ���ݿ����Ա�鿴�����û���Ϣ
	 * 	��ҳ��ѯ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		��ǰҳ����
	 */
	public Page<User> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ͨ���û���id�����û�
	 * 
	 * @param userid
	 * 		�������û���id
	 * 
	 * @return
	 * 		���ؼ��ϣ����߼�����д���
	 */
	public List<User> getById(String userid);
	
	/**
	 * ��ȡ���е��û��ı��
	 * 
	 * ����ӵ�ʱ����������Ƿ�ǰ�û�����Ѿ�ʹ��
	 * 
	 * @return
	 * 		���������û��ı�ż���
	 */
	public List<String> getAllId();
}

