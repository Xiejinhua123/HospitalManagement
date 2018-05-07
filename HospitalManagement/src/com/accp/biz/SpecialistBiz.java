package com.accp.biz;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.dao.SpecialistDao;
import com.accp.demo.Specialist;

/**
 * 专家表的业务处理类
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.03.23
 *
 */
public class SpecialistBiz {

	private Logger logger = Logger.getLogger(SpecialistBiz.class);
	private SpecialistDao sd = new com.accp.dao.impl.SpecialistImpl(); 
	
	/**
	 * 添加专家
	 * 
	 * @return
	 * 		返回数据库影响行数
	 */
	public int add(Specialist s) throws IllegalAccessException{
		
		if(s.getDepId() < 0 || s.getDocId().length() != 12 || s.getDocId() == null){
			logger.debug("专家挂号信息参数添加不正确");
			throw new IllegalAccessException("当前专家号添加不正确，请检查后重新添加");
		}
		return sd.add(s);
	}
	
	/**
	 * 根据条件返回专家的信息
	 * 
	 * @param map
	 * 		条件根据，条件值
	 * 
	 * @return
	 * 		所有的信息
	 */
	public List<Specialist> getByA(Map<String, String> map){
		return sd.getByTime(map); 
	}
}
