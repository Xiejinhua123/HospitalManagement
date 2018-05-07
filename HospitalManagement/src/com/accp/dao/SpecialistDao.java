package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Specialist;

/**
 * ��ǰ�ӿ� ʵ��ר��ֵ������ɾ�Ĳ�<br/>
 * 
 * ��ѡ��Һ���Ϣʱ����в�ѯ<br/>
 * 
 * @author ���
 *		
 *@date 2017.03.23
 *
 */
public interface SpecialistDao extends CommonInterface {
	
	/**
	 * ����ʱ���ѯ�� ��ѯ���й�ר�ҺŵĿ�����Ϣ
	 * 
	 * @return
	 * 		���������ר����Ϣ
	 */
	public List<Specialist> getByTime(Map<String,String> map);
	
}
