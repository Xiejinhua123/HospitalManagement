package com.accp.biz;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DoctorOfferDao;
import com.accp.dao.impl.DoctorOfferImpl;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;

/**
 * ��ǰ�ദ�����еľ�����Ϣ
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.17
 *
 */
public class DoctorOfferBiz {
	
	private Logger logger = Logger.getLogger(DoctorOffer.class); // ��־����
	private DoctorOfferDao dod = new DoctorOfferImpl();
	
	/**
	 * ִ�в�����ӣ���Ӿ�����Ϣ
	 * 
	 * @param docoff
	 * 		��ǰ��ӵķ�װ����
	 * 
	 * @return
	 * 		�������ݿ�Ӱ������
	 * 
	 * @throws NullPointerException
	 * 		����Ϊ�գ��쳣����
	 */
	public int add(DoctorOffer docoff) throws NullPointerException{
		int a = 0;
		
		if(docoff == null){
			logger.debug("��Ӿ�����Ϣ����ȷ������Ϊ��");
			throw new NullPointerException("�����������������ύ");
		}
		
		a = dod.add(docoff);
		
		return a;
	}
	
	/**
	 * ִ��ɾ��
	 * 
	 * @param id
	 * 		��Ҫɾ���Ķ���ı��
	 * 
	 * @return
	 * 		���ݿ�Ӱ������
	 * 
	 * @throws IllegalAccessError
	 * 		�����쳣
	 */
	public int del(int id) throws IllegalAccessError{
		
		int a = 0;
		
		if(id < 0){
			logger.debug("ɾ��������Ϣ����ȷ���Ƿ�����");
			throw new NullPointerException("ɾ����������������ύ");
		}
		
		a = dod.del(id+""); // ִ��ɾ��
		
		return a;
	}
	
	/**
	 * �޸ĵ�ǰ�ľ�����Ϣ
	 * 
	 * @param docoff
	 * 		�������
	 * 
	 * @return
	 * 		�������ݿ�ִ����
	 * 
	 * @throws NullPointerException
	 * 		����Ϊ�գ��쳣����
	 */
	public int update(DoctorOffer docoff) throws NullPointerException{
		int a = 0;
		
		if(docoff == null){
			logger.debug("�޸Ĳ���Ϊ��");
			throw new NullPointerException("�޸Ĳ��������������ύ");
		}
		
		dod.update(docoff);
		
		return a;
	}
	
	/**
	 * ��ҳ��ȡ������Ϣ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		��ѯ���ͣ���ѯ����
	 * 
	 * @return
	 * 		���ص�ǰҳ�Ķ���
	 * 
	 * @throws IllegalAccessException
	 * 		�����쳣
	 */
	public Page<DoctorOffer> getPage(int pagesize,Map<String, String> map) throws IllegalAccessException{
		if(pagesize < 0){
			logger.debug("��ѯ������Ϣʱ���������ҳ�벻��ȷ");
			throw new IllegalAccessError("��Ϣ�ύ����ȷ������������ύ");
		}
		
		Page<DoctorOffer> page = dod.getPage(pagesize, map);
		return page;
	}
	
	/**
	 * ͨ�������Ų�ѯ������Ϣ
	 * 
	 * @param id
	 * 		������
	 * 
	 * @return
	 * 		��ѯ�����û�����Ϣ����
	 * 
	 * @throws IllegalAccessException
	 * 		�����쳣
	 */
	public DoctorOffer getById(int id) throws IllegalAccessException{
		
		if(id < 0){
			logger.debug("��ѯ������Ϣ���󣬱��С��0");
			throw new IllegalAccessException("��ǰ��ѯ����ȷ������������ύ��Ϣ");
		}
		
		DoctorOffer docoff = null;
		
		List<DoctorOffer> list = dod.getById(id);
		
		for (DoctorOffer doc : list) {
			docoff = doc;
		}
		
		return docoff;
		
	}
	
	/**
	 * ͨ���Һű��Ų�ѯ�����ʵ����
	 * 
	 * @param RegId
	 * 		�Һű��
	 * 
	 * @return
	 * 		����ʵ����Ϣ
	 * 
	 * @throws NullPointerException
	 * 		��ָ���쳣
	 */
	public DoctorOffer getByRegId(int RegId) throws NullPointerException {
		
		if(RegId < 0){
			logger.debug("ͨ���Һű��Ų�ѯ�����ʵ���࣬");
			throw new NullPointerException("noRegId");
		}
		DoctorOffer d = null;
		List<DoctorOffer> list = dod.getByReg(RegId);
		for (DoctorOffer doctorOffer : list) {
			d = doctorOffer;
		}
		return d;
	}
}
