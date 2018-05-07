package com.accp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.RegisteredDao;
import com.accp.dao.impl.RegisteredImpl;
import com.accp.demo.Page;
import com.accp.demo.Registered;
import com.accp.tools.GenerateId;

/**
 * 挂号信息表的业务处理类
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.13
 */
public class RegisteredBiz {
	
	private Logger logger = Logger.getLogger(RegisteredBiz.class); // 日志记录对象
	private RegisteredDao rb = new RegisteredImpl(); // 挂号信息表增删改查对象
	
	/**
	 * 挂号 
	 * 
	 * @param r
	 * 		挂号信息表的封装对象
	 * 
	 * @return
	 * 		返回添加对数据库的影响
	 * 
	 * @throws NullPointerException
	 * 		参数异常，空值
	 */
	public int add(Registered r) throws NullPointerException{
		
		if(r == null){
			logger.debug("挂号时，信息为空");
			throw new NullPointerException("当前信息提交不正确，请确认信息");
		}
		
		r.setRegTime(GenerateId.getDateTime());
		r.setPayState(0);
		r.setIsPay(0);
		r.setRegState("501");
		
		if(r.getRegType().equals("专家号"))
			r.setRegPrice(5.0); // 该挂号价格通过数据字典进行操作，包括进行不同的增删改查操作
		else
			r.setRegPrice(2.5); // 同上
		
		int a = rb.add(r);
		return a;
	}
	
	/**
	 * 修改挂号状态
	 * 
	 * @param r
	 * 		需要修改的挂号信息的封装对象
	 * 
	 *  @return
	 * 		返回当前操作对数据库的影响
	 * 
	 * @throws NullPointerException
	 * 		参数异常，抛出异常，前台捕获
	 */
	public int update(Registered r) throws NullPointerException{
		
		if(r == null){
			logger.debug("修改挂号状态时，信息为空");
			throw new NullPointerException("当前信息提交不正确，请确认");
		}
		
		int a = rb.update(r);
		return a;
		
	}
	
	/**
	 * 查询当前页的所有挂号信息
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @param map
	 * 		查询依据，查询条件
	 * 
	 * @return
	 * 		返回当前页的所有对象
	 */		
	public Page<Registered> getPage(int pagesize,Map<String,String> map) throws IllegalAccessException{
		
		if(pagesize < 0){			
			logger.debug("分页查询挂号信息，参数异常");
			throw new IllegalAccessException("提交地址不正确，请检查后重新提交");
		}
		
		Page<Registered> page = rb.getPage(pagesize,map);
		return page;
	}
	
	/**
	 * 利用当前的用户编号，查询用户信息
	 * 
	 * @param regId
	 * 		用户编号
	 * 
	 * @return
	 * 		返回当前的用户
	 */
	public Registered getById(int regId){
		
		if(regId < 0){
			logger.debug("查询当前挂号信息的用户编号不正确");
		}
		
		List<Registered> list = rb.getById(regId);
		Registered reg = null;
		for (Registered r : list) {
			reg = r;
		}
		return reg;
	}
	
	/**
	 * 获取当前医生没有处理的挂号信息
	 * 
	 * @param doctorId
	 * 		医生编号
	 * 
	 * @return
	 * 		没有处理的挂号集合
	 * 	
	 */
	public List<Registered> getNoDispose(String doctorId) throws IllegalAccessException{
		if(doctorId == null || doctorId.length() != 12){
			logger.info("获取没有处理的挂号信息，参数错误，医生编号不正确");
			throw new IllegalAccessError("idError");
		}
		List<Registered> list = new ArrayList<Registered>();
		list = rb.getNoDispose(doctorId);
		return list;
	}
}
