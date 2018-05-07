package com.accp.dao;

import java.util.List;
import java.util.Map;

import com.accp.demo.Specialist;

/**
 * 当前接口 实现专家值班表的增删改查<br/>
 * 
 * 在选择挂号信息时候进行查询<br/>
 * 
 * @author 解金化
 *		
 *@date 2017.03.23
 *
 */
public interface SpecialistDao extends CommonInterface {
	
	/**
	 * 根据时间查询， 查询所有挂专家号的科室信息
	 * 
	 * @return
	 * 		今天的所有专家信息
	 */
	public List<Specialist> getByTime(Map<String,String> map);
	
}
