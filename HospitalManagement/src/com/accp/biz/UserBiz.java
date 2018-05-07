package com.accp.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.accp.dao.UserDao;
import com.accp.dao.impl.UserImpl;
import com.accp.demo.Page;
import com.accp.demo.User;
import com.accp.tools.GenerateId;

/**
 * �������������û���ҵ����
 * 
 * @author ���
 * @version 1.0
 *
 *2017.03.09
 */
public class UserBiz {
	
	private Logger logger = Logger.getLogger(UserBiz.class); 
	private UserDao userdao = new UserImpl();
	
	/**
	 * ִ������û�����
	 * 
	 * @param u
	 * 		��Ҫ��ӵ��û��ķ�װ����
	 * 
	 * @return
	 * 		����ִ�в������ݿ�Ӱ�������
	 * 
	 * @throws Exception
	 * 		�����ֵ���׳��쳣
	 */
	public int add(User u) throws Exception{
		
		if(u == null){
			
			logger.error("����û�����ֵ�쳣");
			throw new Exception("����û�ʱ�򣬴���������󣬿�ֵ");
			
		}else{
			List<String> list = userdao.getAllId(); // �����ݿ��ж������е��û����
			
			String id = GenerateId.getId(); // ϵͳ�����û����
			
			boolean b = false;
			
			do{
				b = false; // ����û����ͬ��id����
				for (String str : list) {
					
					if(str.equals(id)){
						b = true;
						id = GenerateId.getId();
						break;
					}									
				}
			}while(b);
			
			u.setUserId(id); // Ϊ��ӵ��û�����һ���û�id
			int a = userdao.add(u);
			return a;
			
		}
	}
	
	/**
	 * ����ɾ���û�
	 * 
	 * @param id
	 * 		��Ҫɾ�����û��ı��
	 * 
	 * @return
	 * 		�������ݿ��ִ�н��
	 * 
	 * @throws Exception
	 * 		�����쳣���д���
	 */
	public int del(String id) throws Exception{
		
		if(id == null || id.length() != 12){
			
			logger.debug("ɾ���û����������ݲ���ȷ");
			throw new Exception("�û������д����ȷ");
			
		}else{
			
			int a = userdao.del(id);
			return a;
			
		}		
		
	}
	
	/**
	 * ִ���û��޸�
	 * 
	 * @author ���
	 * 
	 * @param u
	 * 		��Ҫ�޸ĵ��û��Ķ���
	 * 
	 * @return
	 * 		�������ݿ��Ӱ������
	 * 
	 * @throws Exception
	 * 		����������Ϊ�գ��׳��쳣
	 */
	public int update(User u) throws Exception{
		
		if(u == null){
			logger.debug("�޸��û���Ϣʱ�򣬴������Ϊ��");
			throw new Exception("û����ȷ���û����޸�");
		}
		int a = userdao.update(u);
		return a;
	}
	
	/**
	 * ����Ա��ѯ�����û�
	 * ��ҳ��ѯ
	 * 
	 * @author ���
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @return
	 * 		���ص�ǰҳ�Ķ���
	 * 
	 * @throws NullPointerException
	 * 		ҳ���ֵ�쳣
	 * 
	 * @throws SQLException
	 * 		���ݿ��쳣
	 */
	public Page<User> getPage(int pagesize,Map<String, String> map) throws NullPointerException,SQLException{
		
		if(pagesize <= 0){
			logger.debug("ҳ�봫��ʧ��");
			throw new NullPointerException("ҳ��Ϊ��");
		}
		Page<User> pages = userdao.getPage(pagesize,map); // ִ�в�ѯ
		return pages;
		
	}
	
	/**
	 * ͨ���û���Ų�ѯ�����û���Ϣ
	 * 
	 * @param id
	 * 		�û����
	 * 
	 * @return
	 * 		���ص����û�����
	 * 
	 * @throws Exception
	 * 		���������д�
	 */
	public User getById(String id) throws Exception{
		
		if(id == null || id.length() != 12){
			logger.debug("��ѯ�����û���Ϣ��id�������");
			throw new Exception("��ǰ�û���Ų���ȷ");
		}
		List<User> list = userdao.getById(id);
		User u = null;
		for (User user : list) {
			u = user;
		}
		return u;
		
	}
	
		
}
