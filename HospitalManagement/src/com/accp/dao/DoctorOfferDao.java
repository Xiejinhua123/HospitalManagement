package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;

/**
 * ��������ɾ�Ĳ�ӿ�
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.13
 *
 */
public interface DoctorOfferDao extends CommonInterface{
	
	/**
	 *	��ȡ���еľ�����Ϣ
	 *	��ҳ��ѯ
	 *
	 * @param pagesize
	 * 		��ǰҳ��
	 * 
	 * @param map
	 * 		���ݲ�ѯ����,�Լ���ѯ������
	 * 
	 * @return
	 * 		��ǰҳ��������Ϣ
	 */
	public Page<DoctorOffer> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * ���ݱ�Ż�ȡ������Ϣ<br/>
	 * 
	 * @param id
	 * 		��ѯ�ľ�����Ϣ�ı��
	 * 
	 * @return
	 * 		��ȡ�Ķ��󼯺�,��ҵ���߼�����д���
	 */
	public List<DoctorOffer> getById(int id);

	/**
	 * ͨ���û��Һ���Ϣ������ҽ�����еľ�����Ϣ
	 * 
	 * @param regId
	 * 		�Һű��
	 * 
	 * @return
	 * 		����ʵ��
	 */
	public List<DoctorOffer> getByReg(int regId);
}
