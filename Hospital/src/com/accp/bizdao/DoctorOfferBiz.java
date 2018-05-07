package com.accp.bizdao;

import java.util.ArrayList;
import java.util.List;

import com.accp.demo.DoctorOffer;
import com.accp.demo.Prescription;
import com.accp.demo.Registered;
import com.accp.demo.Users;
import com.accp.util.Page;

/**
 * 接诊业务处理
 * 
 * 在处理处方表的时候同时处理就诊表
 * 
 * @author 解金化
 * @version 1.0 
 * @date 2017.04.21
 *
 */
public interface DoctorOfferBiz {
	
	/**
	 * 添加就诊信息<br/>
	 * 
	 * 非null验证，非null列验证<br/>
	 * 
	 * 将该对象中的处方信息提取出来<br/>
	 * 即提炼出   Prescription（处方） 对象<br/>
	 * 
	 * 附带的药品编号，需要在执行添加之前获取数据库中相关药品的数量<br/>
	 * 
	 * 判断数量是否达标，不达标就抛出一个自定义的异常，有servlet中进行处理<br/>
	 * 
	 * 创建事务<br/>
	 * 
	 * 向数据库中添加就诊信息返回就诊编号<br/>
	 * 
	 * 根据该编号添加处方信息<br/>
	 * 
	 * 判断事务的提交情况<br/>
	 * 
	 * 返回相应的信息<br/>
	 * 
	 * @param regId
	 * 		挂号编号
	 * @param u
	 * 		医生对象
	 * @param sysem
	 * 		症状信息
	 * 
	 * @return
	 * 		事务提交返回对象，事务回滚返回null
	 */
	public ArrayList<Prescription> add(String regId,Users u,String sysem,String[] drugs) throws Exception;
	
	/**
	 * 删除就诊信息 不常用<br/>
	 * 
	 * 非null验正<br/>
	 * 
	 * 提取其中信息，删除就诊信息，<br/>
	 * 就必须事先删除处方表中的相对应信息<br/>
	 * 
	 * 创建事务进行处理<br/>
	 * 
	 * 必须同时全部删除，或者失败
	 * 
	 * @param list
	 * 		前台勾选多项信息
	 * 
	 * @return
	 * 		事务提交返回true,事务回滚返回false
	 */
	public Boolean del(List<Integer> list)throws Exception;
	
	/**
	 * 分页查询信息就诊信息<br/>
	 * 
	 * 查询过程中需要进行逻辑处理<br/>
	 * 
	 * 查询当前页的集合信息<br/>
	 * 
	 * 然后查询集合中每个对象所对应的处方信息（循环查询赋值）<br/>
	 * 
	 * 还要根据处方表中的药品编号，查询药品的对象，放入当前对象的map属性中<br/>
	 * 
	 * @param page
	 * 		未完全封装的分页对象
	 * 
	 * @param docoff
	 * 		附带有查询条件的对象
	 * 
	 * @return
	 * 		完整的分页对象
	 */
	public void getPage(Page<DoctorOffer> page,DoctorOffer docoff) throws Exception;
	
	/**
	 * 根据编号查询就诊信息
	 * 
	 * 非null验证
	 * 
	 * 查询过程逻辑与查询全部一样
	 * 
	 * @param id
	 * 		需要的编号
	 * 
	 * @return
	 * 		有则返回对象，没有就返回null
	 */
	public DoctorOffer getById(Integer id)throws Exception;
	
	/**
	 * 条件查询
	 * 
	 * @param docoff
	 * 		查询条件构成的对象
	 * 
	 * @return
	 * 		有返回集合，没有返回null
	 * 
	 * @throws Exception
	 * 		有可能抛出的异常
	 */
	public List<DoctorOffer> getByColumn(DoctorOffer docoff) throws Exception;

	/**
	 * 通过挂号查询对应的就诊信息
	 * 
	 * @param byId
	 * 		挂号对象
	 * @return
	 * 		就诊集合
	 * @throws Exception 
	 */
	public List<DoctorOffer> getByRegistered(Registered byId) throws Exception;
	
	
	
}
