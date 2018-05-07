package com.accp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.RegisteredDao;
import com.accp.dao.impl.RegisteredImpl;
import com.accp.demo.Page;
import com.accp.demo.Registered;
import com.accp.tools.GenerateId;

/**
 * �Һ���Ϣ���ҵ������
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.13
 */
public class RegisteredBiz {
	
	private Logger logger = Logger.getLogger(RegisteredBiz.class); // ��־��¼����
	private RegisteredDao rb = new RegisteredImpl(); // �Һ���Ϣ����ɾ�Ĳ����
	
	/**
	 * �Һ� 
	 * 
	 * @param r
	 * 		�Һ���Ϣ��ķ�װ����
	 * 
	 * @return
	 * 		������Ӷ����ݿ��Ӱ��
	 * 
	 * @throws NullPointerException
	 * 		�����쳣����ֵ
	 */
	public int add(Registered r) throws NullPointerException{
		
		if(r == null){
			logger.debug("�Һ�ʱ����ϢΪ��");
			throw new NullPointerException("��ǰ��Ϣ�ύ����ȷ����ȷ����Ϣ");
		}
		
		r.setRegTime(GenerateId.getDateTime());
		r.setPayState(0);
		r.setIsPay(0);
		r.setRegState("501");
		
		if(r.getRegType().equals("ר�Һ�"))
			r.setRegPrice(5.0); // �ùҺż۸�ͨ�������ֵ���в������������в�ͬ����ɾ�Ĳ����
		else
			r.setRegPrice(2.5); // ͬ��
		
		int a = rb.add(r);
		return a;
	}
	
	/**
	 * �޸ĹҺ�״̬
	 * 
	 * @param r
	 * 		��Ҫ�޸ĵĹҺ���Ϣ�ķ�װ����
	 * 
	 *  @return
	 * 		���ص�ǰ���������ݿ��Ӱ��
	 * 
	 * @throws NullPointerException
	 * 		�����쳣���׳��쳣��ǰ̨����
	 */
	public int update(Registered r) throws NullPointerException{
		
		if(r == null){
			logger.debug("�޸ĹҺ�״̬ʱ����ϢΪ��");
			throw new NullPointerException("��ǰ��Ϣ�ύ����ȷ����ȷ��");
		}
		
		int a = rb.update(r);
		return a;
		
	}
	
	/**
	 * ��ѯ��ǰҳ�����йҺ���Ϣ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ݣ���ѯ����
	 * 
	 * @return
	 * 		���ص�ǰҳ�����ж���
	 */		
	public Page<Registered> getPage(int pagesize,Map<String,String> map) throws IllegalAccessException{
		
		if(pagesize < 0){			
			logger.debug("��ҳ��ѯ�Һ���Ϣ�������쳣");
			throw new IllegalAccessException("�ύ��ַ����ȷ������������ύ");
		}
		
		Page<Registered> page = rb.getPage(pagesize,map);
		return page;
	}
	
	/**
	 * ���õ�ǰ���û���ţ���ѯ�û���Ϣ
	 * 
	 * @param regId
	 * 		�û����
	 * 
	 * @return
	 * 		���ص�ǰ���û�
	 */
	public Registered getById(int regId){
		
		if(regId < 0){
			logger.debug("��ѯ��ǰ�Һ���Ϣ���û���Ų���ȷ");
		}
		
		List<Registered> list = rb.getById(regId);
		Registered reg = null;
		for (Registered r : list) {
			reg = r;
		}
		return reg;
	}
	
	/**
	 * ��ȡ��ǰҽ��û�д���ĹҺ���Ϣ
	 * 
	 * @param doctorId
	 * 		ҽ�����
	 * 
	 * @return
	 * 		û�д���ĹҺż���
	 * 	
	 */
	public List<Registered> getNoDispose(String doctorId) throws IllegalAccessException{
		if(doctorId == null || doctorId.length() != 12){
			logger.info("��ȡû�д���ĹҺ���Ϣ����������ҽ����Ų���ȷ");
			throw new IllegalAccessError("idError");
		}
		List<Registered> list = new ArrayList<Registered>();
		list = rb.getNoDispose(doctorId);
		return list;
	}
}
