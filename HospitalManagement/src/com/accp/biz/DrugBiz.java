package com.accp.biz;

import java.util.List;

import com.accp.dao.DrugDao;
import com.accp.dao.impl.DrugImpl;
import com.accp.demo.Drug;

/**
 * 药品表的业务处理
 * 
 * @author 解金化
 *	@version 1.0
 *	@date 2017.04.05
 */
public class DrugBiz {

	private DrugDao dd = new DrugImpl();
	
	/**
	 * 通过药品名称获取药品编号
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
