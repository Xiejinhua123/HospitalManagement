package com.accp.biz;

import java.util.List;

import com.accp.dao.DrugDao;
import com.accp.dao.impl.DrugImpl;
import com.accp.demo.Drug;

/**
 * ҩƷ���ҵ����
 * 
 * @author ���
 *	@version 1.0
 *	@date 2017.04.05
 */
public class DrugBiz {

	private DrugDao dd = new DrugImpl();
	
	/**
	 * ͨ��ҩƷ���ƻ�ȡҩƷ���
	 * 
	 * @param name
	 * @return
	 */
	public int getDrugId(String name){
		List<Drug> list = dd.getDrugId(name);
		Drug d = list.get(0);
		return d.getDrugId();
	}
	
}
