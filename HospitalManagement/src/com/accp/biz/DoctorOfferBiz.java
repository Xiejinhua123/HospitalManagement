package com.accp.biz;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.DoctorOfferDao;
import com.accp.dao.impl.DoctorOfferImpl;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;

/**
 * 当前类处理所有的就诊信息
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.17
 *
 */
public class DoctorOfferBiz {
	
	private Logger logger = Logger.getLogger(DoctorOffer.class); // 日志对象
	private DoctorOfferDao dod = new DoctorOfferImpl();
	
	/**
	 * 执行病例添加，添加就诊信息
	 * 
	 * @param docoff
	 * 		当前添加的封装对象
	 * 
	 * @return
	 * 		返回数据库影响行数
	 * 
	 * @throws NullPointerException
	 * 		参数为空，异常处理
	 */
	public int add(DoctorOffer docoff) throws NullPointerException{
		int a = 0;
		
		if(docoff == null){
			logger.debug("添加就诊信息不正确，参数为空");
			throw new NullPointerException("添加有误，请检查后重新提交");
		}
		
		a = dod.add(docoff);
		
		return a;
	}
	
	/**
	 * 执行删除
	 * 
	 * @param id
	 * 		需要删除的对象的编号
	 * 
	 * @return
	 * 		数据库影响行数
	 * 
	 * @throws IllegalAccessError
	 * 		参数异常
	 */
	public int del(int id) throws IllegalAccessError{
		
		int a = 0;
		
		if(id < 0){
			logger.debug("删除就诊信息不正确，非法参数");
			throw new NullPointerException("删除有误，请检查后重新提交");
		}
		
		a = dod.del(id+""); // 执行删除
		
		return a;
	}
	
	/**
	 * 修改当前的就诊信息
	 * 
	 * @param docoff
	 * 		就诊对象
	 * 
	 * @return
	 * 		返回数据库执行数
	 * 
	 * @throws NullPointerException
	 * 		参数为空，异常捕获
	 */
	public int update(DoctorOffer docoff) throws NullPointerException{
		int a = 0;
		
		if(docoff == null){
			logger.debug("修改参数为空");
			throw new NullPointerException("修改操作有误，请重新提交");
		}
		
		dod.update(docoff);
		
		return a;
	}
	
	/**
	 * 分页获取就诊信息
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询类型，查询条件
	 * 
	 * @return
	 * 		返回当前页的对象
	 * 
	 * @throws IllegalAccessException
	 * 		参数异常
	 */
	public Page<DoctorOffer> getPage(int pagesize,Map<String, String> map) throws IllegalAccessException{
		if(pagesize < 0){
			logger.debug("查询就诊信息时，请求出错，页码不正确");
			throw new IllegalAccessError("信息提交不正确，请检查后重新提交");
		}
		
		Page<DoctorOffer> page = dod.getPage(pagesize, map);
		return page;
	}
	
	/**
	 * 通过就诊编号查询就诊信息
	 * 
	 * @param id
	 * 		就诊编号
	 * 
	 * @return
	 * 		查询到的用户的信息对象
	 * 
	 * @throws IllegalAccessException
	 * 		参数异常
	 */
	public DoctorOffer getById(int id) throws IllegalAccessException{
		
		if(id < 0){
			logger.debug("查询就诊信息有误，编号小于0");
			throw new IllegalAccessException("当前查询不正确，请检测后重新提交信息");
		}
		
		DoctorOffer docoff = null;
		
		List<DoctorOffer> list = dod.getById(id);
		
		for (DoctorOffer doc : list) {
			docoff = doc;
		}
		
		return docoff;
		
	}
	
	/**
	 * 通过挂号表编号查询就诊表实体类
	 * 
	 * @param RegId
	 * 		挂号编号
	 * 
	 * @return
	 * 		就诊实体信息
	 * 
	 * @throws NullPointerException
	 * 		空指针异常
	 */
	public DoctorOffer getByRegId(int RegId) throws NullPointerException {
		
		if(RegId < 0){
			logger.debug("通过挂号表编号查询就诊表实体类，");
			throw new NullPointerException("noRegId");
		}
		DoctorOffer d = null;
		List<DoctorOffer> list = dod.getByReg(RegId);
		for (DoctorOffer doctorOffer : list) {
			d = doctorOffer;
		}
		return d;
	}
}
