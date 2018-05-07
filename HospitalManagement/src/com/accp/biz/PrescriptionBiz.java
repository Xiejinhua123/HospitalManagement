package com.accp.biz;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.dao.PrescriptionDao;
import com.accp.dao.impl.PrescriptionImpl;
import com.accp.demo.Prescription;

/**
 * 处方表业务处理类
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.31
 *
 */
public class PrescriptionBiz {

	private Logger logger = Logger.getLogger(PrescriptionBiz.class);
	private PrescriptionDao pd = new PrescriptionImpl();
	
	/**
	 * 执行添加药方信息
	 * 
	 * @param p
	 * 		实体类
	 * 
	 * @return
	 * 		添加行数
	 * 
	 * @throws NullPointerException
	 * 		传值为空
	 */
	public int add(Prescription p) throws NullPointerException{
		
		if(p == null){
			logger.debug("添加处方信息失败，参数为空");
			throw new NullPointerException("noParameter");
		}
		
		int a = pd.add(p);
		return a;
	}
	
	/**
	 * 通过处方编号查询所有的药品
	 * 
	 * @param doid
	 * 		处方编号
	 * 
	 * @return
	 * 		返回药品的集合
	 */
	public List<Prescription> getList(int doid){
		
		List<Prescription> list = pd.getById(doid);
		return list;
		
	}
	
}
