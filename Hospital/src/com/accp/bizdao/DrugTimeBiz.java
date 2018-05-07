package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Drug;
import com.accp.demo.DrugTime;
import com.accp.util.Page;

/**
 * 药品过期时间的操作<br/>
 * 
 * 进销存
 * 
 * @author 解金化
 * @date 2017.04.23
 * @version 1.0
 *
 */
public interface DrugTimeBiz {
	/**
	 * 进货<br/>
	 * 
	 * 非null验证，非null列验证<br/>
	 * 
	 * 同时需要修改宗品的总结库存量<br/>
	 * 
	 * @param d
	 * @return
	 */
	public DrugTime add(DrugTime d)throws Exception;
	
	/**
	 * 根据进货批次删除进货信息<br/>
	 * 
	 * 删除信息之后，应该同时进行总库存量的修改<br/>
	 * 
	 * @param id
	 * 		需要删除的批次编号
	 * 
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public Boolean del(List<Integer> idlist) throws Exception;
	
	/**
	 * 修改<br/>
	 * 
	 * 修改基本信息<br/>
	 * 
	 * @param d
	 * 		脏对象
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public Boolean update(DrugTime d)throws Exception;
	
	/**
	 * 修改方法重载<br/>
	 * 
	 * 修改数量信息<br/>
	 * 
	 * 其中在这里的修改必须考虑到，如果当前批次的药品数量不够给定的参数number<br/>
	 * 
	 * 必须要先把本批次的记录的数量修改为0，同时更改number的值<br/>
	 * 
	 * 然后进行下一批次的操作，下一批次还不够继续进行上述的问题<br/>
	 * 
	 * @param drugId
	 * 		药品编号
	 * @param number
	 * 		修改的数量
	 * @param bool
	 * 		true为增加，false为减少		
	 *
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public Boolean update(Integer drugId, int number,Boolean bool)throws Exception;
	
	/**
	 * 重载<br/>
	 * 
	 * 根据药品编号查看所有的批次信息（所有）<br/>
	 * 
	 * 查询所有的药品信息的进货情况<br/>
	 * 
	 * 由当前的批次共同组成药品库存<br/>
	 * 
	 * @param page
	 * 		属性值不完整的的page对象
	 * @param drugId
	 * 		药品编号
	 * @param bool
	 * 		表示是否查询所有
	 * 		true查询所有，包括数量为0的
	 * 		false查询部分，不包括数量为0的
	 * @return
	 */
	public void getPage(Page<DrugTime> page,DrugTime drugtime,Boolean bool) throws Exception;

	/**
	 * 根据过期时间编号进行查询
	 * 
	 * @param drugTimeId
	 * 		过期时间编号
	 * 
	 * @return
	 * 		有则返回对象，没有返回null
	 * @throws Exception
	 * 		有可能出现的异常
	 */
	public DrugTime getById(Integer drugTimeId) throws Exception;

	/**
	 * 根据药品获取全部的药品过期时间
	 * 
	 * @param drug
	 * 		药品对象
	 * 
	 * @return
	 * 		过期时间集合
	 * @throws Exception 
	 */
	public List<DrugTime> getByDrug(Drug drug) throws Exception;

	/**
	 * 动态查询
	 * @param d
	 * 		动态条件封装的对象
	 * @return
	 * 		有则返回集合  没有返回null
	 * @throws Exception
	 */
	public List<DrugTime> getByColumn(DrugTime d) throws Exception;
	
}
