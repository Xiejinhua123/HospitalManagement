package com.accp.biz;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.dao.PrescriptionDao;
import com.accp.dao.impl.PrescriptionImpl;
import com.accp.demo.Prescription;

/**
 * ������ҵ������
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.31
 *
 */
public class PrescriptionBiz {

	private Logger logger = Logger.getLogger(PrescriptionBiz.class);
	private PrescriptionDao pd = new PrescriptionImpl();
	
	/**
	 * ִ�����ҩ����Ϣ
	 * 
	 * @param p
	 * 		ʵ����
	 * 
	 * @return
	 * 		�������
	 * 
	 * @throws NullPointerException
	 * 		��ֵΪ��
	 */
	public int add(Prescription p) throws NullPointerException{
		
		if(p == null){
			logger.debug("��Ӵ�����Ϣʧ�ܣ�����Ϊ��");
			throw new NullPointerException("noParameter");
		}
		
		int a = pd.add(p);
		return a;
	}
	
	/**
	 * ͨ��������Ų�ѯ���е�ҩƷ
	 * 
	 * @param doid
	 * 		�������
	 * 
	 * @return
	 * 		����ҩƷ�ļ���
	 */
	public List<Prescription> getList(int doid){
		
		List<Prescription> list = pd.getById(doid);
		return list;
		
	}
	
}
