package com.accp.bizdao;

import java.util.List;

import com.accp.demo.FixedSysmptoms;
import com.accp.util.Page;

/**
 * 固定症状的业务逻辑<br/>
 * 
 * 其中涉及到的是两张表的共同增删改查
 * 
 * 	@author 解金化
 *	@version 1.0
 *	@date 2017.04.22
 *
 */
public interface FixedSysmptomsBiz {

	/**
	 * 添加固定症状<br/>
	 * 
	 * 非null验证，非null列验证<br/>
	 * 
	 * 开启事务<br/>
	 * 
	 * 添加固定症状，返回症状的编号<br/>
	 * 
	 * 解析其中的map集合，将集合中的key拿出来，和返回的编号一起<br/>
	 * 
	 * 组成一个个的固定处方对象，将这些对象添加到数据库中<br/>
	 * 
	 * @param f
	 * 		封装对象
	 * 
	 * @return
	 * 		
	 */
	public FixedSysmptoms add(FixedSysmptoms f,List<Integer> drugId)throws Exception;
	
	/**
	 * 删除固定症状<br/>
	 * 
	 * 开启事务<br/>
	 * 
	 * 在删除固定症状的的时候必须事先删除针对的固定处方表信息<br/>
	 * 
	 * 然后删除固定症状信息<br/>
	 * 
	 * @param id
	 * 		前台提供多个勾选进行循环删除，固定编号
	 * 
	 * @return
	 * 		所有事务提交返回true，事务回滚返回false
	 */
	public Boolean del(List<Integer> id)throws Exception;
	
	/**
	 * 提供修改方法<br/>
	 * 
	 * 事务处理，有可能修改该的是药品信息，也有可能是症状信息<br/>
	 * 
	 * @param f
	 * 		脏对象
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 */
	public Boolean update(FixedSysmptoms f,List<Integer> drugIds)throws Exception;
	
	/**
	 * 分页查询所有<br/>
	 * 
	 * 经历两次查询<br/>
	 * 
	 * 先查询固定症状<br/>
	 * 
	 * 在查询针对症状的处方<br/>
	 * 
	 * @param page
	 * 		属性不完整的对象
	 * @param map
	 * 		有可能出现的查询条件，比如科室编号。。。
	 * @return
	 * 		返回属性完整的对象
	 * @throws Exception 
	 */
	public void getPage(Page<FixedSysmptoms> page,FixedSysmptoms f) throws Exception;
	
	/**
	 * 同上
	 * @param id
	 * 		编号
	 * @return
	 * 		有则返回对象，没有则返回null
	 */
	public FixedSysmptoms getById(Integer id)throws Exception;

	/**
	 * 根据列查询
	 * 
	 * @param strings
	 * 		列名集合
	 * @param objects
	 * 		值得集合
	 * @return
	 * 		对象集合
	 */
	public List<FixedSysmptoms> getByColumn(FixedSysmptoms f) throws Exception;
}
