package com.accp.bizdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.accp.demo.Drug;
import com.accp.util.Page;

/**
 * 药品表的业务处理
 * 
 * 其中涉及到三张表的增删改查
 *  
 * @author 李伊昌
 * @version 1.0 
 * 
 *  @date 2017.04.22
 */
public interface DrugBiz {
	/**
	 * 添加药品<br/>
	 * 
	 * 进行非null验证，非null列验证<br/>
	 * 
	 * 添加药品,返回药品编号<br/>
	 * 
	 * 过期时间的表属于入库的操作
	 *  
	 * @param 药品 d
	 * @throws Exception 
	 */
	public Drug addDrug (Drug d) throws Exception;
	
	/**
	 * 修改药品
	 * 
	 * 非null验证，非null列验证
	 * 
	 * 如果修改的是库存，就必须进行事务处理，同时修改过期时间表库存
	 * 
	 * 也修改总库存
	 * 
	 * @param d
	 * 		脏对象
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 * @throws Exception 
	 */
	public Drug updateDrug (Drug d)throws Exception;
	
	/**
	 * 删除药品<br/>
	 * 
	 * 非null验证，非null列验证<br/>
	 * 
	 * 开启事务处理<br/>
	 * 
	 * 在删除过期表信息<br/>
	 * 
	 * 最后删除药品表信息<br/>
	 * 
	 * @param id
	 * 		多项药品编号
	 * 
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 * 
	 * @throws NullPointerException
	 * 		空指针异常
	 * 
	 * @throws SQLException
	 * 		sql访问异常
	 */
	public Boolean delDrug(List<Integer> drugId)throws Exception;
	
	/**
	 * 通过药品编号获取药品信息
	 * 
	 * 非null验证，非null列验证
	 * 
	 * 获取药品
	 * 
	 * @param id
	 * 		药品编号
	 * 	
	 * @return
	 * 		有则返回对象，没有返回null
	 */
	public Drug getDrugById(Integer id) throws Exception;
	
	/**
	 * 进行分页查询药品信息
	 * 
	 * @param page
	 * 		不完整的分页对象
	 * @param map
	 * 		有可能用到的条件查询
	 * @return
	 * 		完整的page对象
	 */
	public void getPage(Page<Drug> page,Drug drug) throws Exception;
	
	/**
	 * 查询所有，
	 * 
	 * @param d
	 * 		含有动态条件的对象
	 * 
	 * @return
	 * 		所有的药品对象
	 * 
	 * @throws Exception
	 * 		有可能的异常
	 */
	public List<Drug> getAll(Drug d) throws Exception;
	
	/**
	 * 根据给定的就诊编号查询针对性的药品
	 * @param sys
	 * 		症状数组
	 * @return
	 * 		返回对症药品<br/>
	 * 		key是症状信息<br/>
	 * 		value是针对症状的药品<br/>
	 * 
	 * @throws Exception
	 * 		自定义异常
	 */
	public Map<String,List<Drug>> getBySys(Integer doid) throws Exception;

}
