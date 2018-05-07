package com.accp.biz;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.SpecialistDao;
import com.accp.demo.Specialist;

/**
 * ר�ұ��ҵ������
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.23
 *
 */
public class SpecialistBiz {

	private Logger logger = Logger.getLogger(SpecialistBiz.class);
	private SpecialistDao sd = new com.accp.dao.impl.SpecialistImpl(); 
	
	/**
	 * ���ר��
	 * 
	 * @return
	 * 		�������ݿ�Ӱ������
	 */
	public int add(Specialist s) throws IllegalAccessException{
		
		if(s.getDepId() < 0 || s.getDocId().length() != 12 || s.getDocId() == null){
			logger.debug("ר�ҹҺ���Ϣ������Ӳ���ȷ");
			throw new IllegalAccessException("��ǰר�Һ���Ӳ���ȷ��������������");
		}
		return sd.add(s);
	}
	
	/**
	 * ������������ר�ҵ���Ϣ
	 * 
	 * @param map
	 * 		�������ݣ�����ֵ
	 * 
	 * @return
	 * 		���е���Ϣ
	 */
	public List<Specialist> getByA(Map<String, String> map){
		return sd.getByTime(map); 
	}
}
