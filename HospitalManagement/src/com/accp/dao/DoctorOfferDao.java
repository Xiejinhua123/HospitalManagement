package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;

/**
 * 就诊表的增删改查接口
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.13
 *
 */
public interface DoctorOfferDao extends CommonInterface{
	
	/**
	 *	获取所有的就诊信息
	 *	分页查询
	 *
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		根据查询类型,以及查询的条件
	 * 
	 * @return
	 * 		当前页的所有信息
	 */
	public Page<DoctorOffer> getPage(int pagesize,Map<String,String> map);
	
	/**
	 * 根据编号获取就诊信息<br/>
	 * 
	 * @param id
	 * 		查询的就诊信息的编号
	 * 
	 * @return
	 * 		获取的对象集合,在业务逻辑层进行处理
	 */
	public List<DoctorOffer> getById(int id);

	/**
	 * 通过用户挂号信息，查找医生表中的就诊信息
	 * 
	 * @param regId
	 * 		挂号编号
	 * 
	 * @return
	 * 		就诊实体
	 */
	public List<DoctorOffer> getByReg(int regId);
}
