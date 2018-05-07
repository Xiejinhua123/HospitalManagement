package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Drug;
import com.accp.demo.FixedPrescription;
import com.accp.demo.FixedSysmptoms;

/**
 * 固定处方表的业务处理
 * 
 * @author 解金化
 *
 */
public interface FixedPrescriptionBiz {

	/**
	 * 根据药品查询所有的固定处方
	 * 
	 * @param drug
	 * 		药品对象
	 * @return
	 * 		符合条件的固定处方集合
	 */
	List<FixedPrescription> getByDrug(Drug drug) throws Exception;
	
	/**
	 * 根据固定症状查询规定处方
	 * 
	 * @param f
	 * 		固定症状
	 * @return
	 * 		有则返回集合，没有返回null
	 * @throws Exception
	 */
	List<FixedPrescription> getByFixedSysmptoms(FixedSysmptoms f) throws Exception;
	
	/**
	 * 根据编号查找
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		一个对象
	 * @throws Exception
	 * 		有可能出现的异常
	 */
	FixedPrescription getById(Integer id) throws Exception;
	
	/**
	 * 添加固定处方
	 * 
	 * @param f
	 * 		需要添加的对象
	 * 
	 * @return
	 * 		添加成功的对象
	 * @throws Exception
	 * 有可能发生的异常情况
	 */
	FixedPrescription add(FixedPrescription f) throws Exception;
	
	/**
	 * 删除固定处方
	 * 
	 * @param fixids
	 * 		多项编号
	 * 
	 * @return
	 * 		成功返回true,失败返回false
	 */
	boolean del(List<Integer> fixids) throws Exception;
	
	/**
	 * 修改固定处方
	 * 
	 * @param f
	 * 		脏对象
	 * 
	 * @return
	 * 		持久对象
	 * @throws Exception
	 * 		异常
	 */
	FixedPrescription update(FixedPrescription f)throws Exception;

}
