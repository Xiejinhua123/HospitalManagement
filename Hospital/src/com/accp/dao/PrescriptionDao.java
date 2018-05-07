package com.accp.dao;

import java.util.List;

import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;

/**
 * 处方表增删改查
 * @author xueshe01
 *
 */
public interface PrescriptionDao extends CommonInterface{

	/**
	 * 根据编号查询
	 * @param preId
	 * 		处方表编号
	 * @return
	 * 		有则返回对象，没有返回null
	 */
	Prescription getById(Integer preId);

	/**
	 * 根据药品信息查询
	 * 
	 * @param drug
	 * 		药品实体对象
	 * @return
	 * 		有则返回集合 没有返回null
	 */
	List<Prescription> getByDrug(Drug drug);

	/**
	 * 根据就诊信息查询
	 * 
	 * @param docoff
	 * 		就诊实体对象
	 * 
	 * @return
	 * 		有则返回集合，没有返回null
	 */
	List<Prescription> getByDocoff(DoctorOffer docoff);
	/***
	 * 根据医生编号查询
	 * @param id
	 * @return
	 */
	List<Prescription> getUsersId(String id);

}
