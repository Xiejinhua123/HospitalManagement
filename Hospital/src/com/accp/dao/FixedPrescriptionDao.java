package com.accp.dao;

import java.util.List;

import com.accp.demo.Drug;
import com.accp.demo.FixedPrescription;
import com.accp.demo.FixedSysmptoms;

/**
 * 固定处方表
 * @author xueshe01
 *
 */
public interface FixedPrescriptionDao extends CommonInterface{

	/**
	 * 根据固定出症状查询固定处方
	 * 
	 * @param f	
	 * 		固定处方对象
	 * 
	 * @return
	 * 		有则返回集合，没有则返回null
	 */
	List<FixedPrescription> getByFixedSysmptoms(FixedSysmptoms f);

	/**
	 * 根据编号查询
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		获取到了返回对象，没有获取到返回null
	 */
	FixedPrescription getById(Integer id);

	/**
	 * 根据药品获取固定症状
	 * 
	 * @param drug
	 * 		药品对象
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<FixedPrescription> getByDrug(Drug drug);

}
