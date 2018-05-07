package com.accp.bizdao;

import java.util.List;

import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;

public interface PrescriptionBiz {

	/**
	 * 根据就诊信息查询处方
	 * 
	 * @param docoff
	 * 		就诊对象
	 * @return
	 * 		集合
	 */
	List<Prescription> getByDocoff(DoctorOffer docoff) throws Exception;

	/**
	 * 根据药品查询处方
	 * 
	 * @param drug
	 * 		药品对象
	 * @return
	 * 		符合条件集合
	 */
	List<Prescription> getByDrug(Drug drug) throws Exception;
	
	/**
	 * 通过编号查询处方信息
	 * 
	 * @param preId
	 * @return
	 * @throws Exception
	 */
	Prescription getById(Integer preId) throws Exception;
	
	/**
	 * 添加处方
	 * 
	 * @param p
	 * 		处方
	 * @return
	 * 		成功返回对象，失败返回null
	 * @throws Exception
	 */
	Prescription add(Prescription p) throws Exception;
	
	/**
	 * 删除处方
	 * 
	 * @param pres
	 * 		处方编号
	 * @return
	 * 		成功返回true,失败返回false
	 * @throws Exception 
	 */
	Boolean del(List<Integer> pres) throws Exception;

	/**
	 * 修改处方
	 * 
	 * @param p
	 * 		脏对象
	 * @return
	 * 		成功返回持久化对象，失败返回null
	 * @throws Exception
	 */
	Prescription update(Prescription p) throws Exception;

	/**
	 * 根据挂号编号查循处方信息
	 * 
	 * @param regid
	 * 		挂号编号
	 * 
	 * @return
	 * 		处方信息的json字符串
	 */
	String getPreByReg(String regid) throws Exception;
	
	/***
	 * 根据医生编号查询所有的处方
	 * @param docoff
	 * @return
	 * @throws Exception
	 */
	List<Prescription> getUsersId(String id) throws Exception;


}
