package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.DoctorOffer;
import com.accp.util.Page;

public interface DoctorOfferDao extends CommonInterface {

	/**
	 * 动态查询
	 * 
	 * @param docoff
	 * 		含有动态查询条件的就诊对象
	 * 
	 * @return
	 * 		就诊集合
	 */
	List<DoctorOffer> getByColumn(DoctorOffer docoff);

	/**
	 * 分页查询就诊信息
	 * 
	 * @param page
	 * 		分页对象
	 * 
	 * @param docoff
	 * 		动态查询条件
	 */
	void getPage(Page<DoctorOffer> page,DoctorOffer d);

}
