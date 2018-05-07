package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Registered;
import com.accp.json.RegJson;
import com.accp.json.RegisteredJson;
import com.accp.util.Page;

/**
 * 挂号业务处理
 * @author 李伊昌
 */
public interface RegisteredBiz {
	/**	
	 * 挂号<br/>
	 * 
	 * 该方法为普通挂号<br/>
	 * 
	 * 挂号返回编号<br/>
	 * 
	 * 通过编号查询并返回全部信息<br/>
	 * 
	 * @param uid
	 * 		医生编号
	 * @param patid
	 * 		患者编号
	 * 
	 * @return
	 * 		挂号成功返回对象的json形式字符串，失败返回null
	 */
	public RegisteredJson add(String uid, Integer patid) throws Exception;
	
	/**
	 * 预约挂号<br/>
	 * 
	 * 需要在该方法中修改对象的挂号时间<br/>
	 * 
	 * 挂号时间由前台传递<br/>
	 * 
	 * 预约时间在当前方法中生成（工具类生成）<br/>
	 * 
	 * 前台需要进行判断<br/>
	 * 
	 * @param r
	 * 		不完整信息的挂号对象
	 * @return
	 * 		完整信息的挂号对象
	 */
	public Registered appointment(Registered r);
	
	/**
	 * 删除挂号信息（不常用）<br/>
	 * 
	 * 通过编号删除<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * 删除挂号信息，必须实现删除处方表、就诊表中关于该挂号的相关信息<br/>
	 * 
	 * @param id
	 * 		需要删除的挂号编号
	 * 	
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 * @throws Exception 
	 */
	public Boolean del(List<String> id) throws Exception;
	
	/**
	 * 修改方法（最常用）<br/>
	 * 
	 * 在付款等都需要修改当前表中的相关信息<br/>
	 * 
	 * @param r
	 * 		脏对象
	 * @return
	 * 		修改成功返回true，失败返回false
	 * @throws Exception 
	 */
	public Registered update(Registered r) throws Exception;
	
	/**
	 * 获取所有的信息<br/>
	 * 
	 * 该方法有可能提供动态查询<br/>
	 * 
	 * @param page
	 * 		不完整的分页信息
	 * 
	 * @param r
	 * 		含有动态条件的查询对象
	 */
	public void getPage(Page<Registered> page,Registered r) throws Exception;
	
	/**
	 * 通过编号查询所有的信息<br/>
	 * 
	 * @param id
	 * 		挂号编号
	 * @return
	 * 		有则返回对象，没有则返回null
	 * @throws Exception 
	 */
	public Registered getById(String id) throws Exception;
	
	/**
	 * 通过条件查询所有的信息
	 * 
	 * @param r
	 * 		动态条件构成的对象
	 * @return
	 * 		返回查询到的集合
	 * @throws Exception
	 * 		有可能产生的异常
	 */
	public List<Registered> getByColumn(Registered r) throws Exception;

	/**
	 * 根据医生编号查询当前医生的挂号信息，并且是没有处理过得
	 * 
	 * @param usersId
	 * 		医生编号
	 * 
	 * @return
	 * 		前台需要的json数组
	 * 
	 * @throws Exception
	 * 		异常
	 */
	List<RegJson> getByDoctorNoDispose(String usersId) throws Exception;
}
