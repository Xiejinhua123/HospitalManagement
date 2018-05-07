package com.accp.bizdao;

import java.util.List;
import com.accp.demo.Report;
import com.accp.util.Page;

/**
 * 报表业务处理
 * 
 * @author 李伊昌
 * @time 2017/4/25
 * 
 */
public interface ReportBiz {
	/**
	 * 提交报表
	 * 
	 * 审阅报表
	 * 
	 * 修改自己的报表
	 * 
	 * 删除自己的报表
	 * 
	 * 查看自己的报表
	 * 
	 * 查看全部报表
	 */
	
	/**
	 * 提交报表
	 * 
	 * 其中编号程序生成
	 * 
	 * @param r
	 * 		封装的报表
	 * @return
	 * 		数据完整报表
	 */
	public Report add(Report r)throws Exception;
	
	/**
	 * 删除
	 * 
	 * @param list
	 * 		前台勾选多项报表
	 * 
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public Boolean del(List<Integer> list) throws Exception;
	
	/**
	 * 修改或者审阅报表
	 * 
	 * @param r
	 * 		脏对象
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public Boolean update(Report r) throws Exception;
	
	/**
	 * 分页查询
	 * @param page
	 * 		属性不完整的分页对象
	 * @param r
	 * 		动态查询构成的对象
	 * @return
	 * 		属性完整的分页对象
	 * @exception Exception
	 * 	有可能产生的异常
	 */
	public void getPage(Page<Report> page,Report r) throws Exception;
	
	/**
	 * 查询单一的报表
	 * 
	 * @param RepId
	 * 		报表编号
	 * 
	 * @return
	 * 		报表的对象
	 * 
	 * @throws Exception
	 * 		有可能的异常
	 */
	public Report getById(String RepId) throws Exception;
}
