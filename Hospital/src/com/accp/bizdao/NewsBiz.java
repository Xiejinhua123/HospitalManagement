package com.accp.bizdao;

import java.util.List;

import com.accp.demo.News;
import com.accp.util.Page;

/**
 * 新闻表
 * 
 * @author 李伊昌
 *
 */
public interface NewsBiz {
	/**
	 * 添加新闻信息
	 * 
	 * 正常添加
	 * 
	 * 其中编号程序生成
	 * 
	 * @param news
	 * 		新闻对象
	 * @return
	 * 		新闻对象
	 */
	public News add(News news)throws Exception;
	
	/**
	 * 根据新闻的编号删除新闻信息
	 * 
	 * @param id
	 * 		前台勾选的新闻编号集合
	 * @return
	 * 		全部删除成功返回true，任何一条失败返回false
	 */
	public Boolean del(List<Integer> id) throws Exception;
	
	/**
	 * 执行修改操作
	 * 
	 * 普通修改
	 * 
	 * @param n
	 * 		脏对象
	 * @return
	 * 		成功返回true，失败返回false
	 */
	public News update (News news)throws Exception;
	
	/**
	 * 分页查询
	 * 
	 * @param page
	 * 		属性不完整的对象
	 * 
	 * @param map
	 * 		属性完整的对象
	 * 
	 * @return
	 * 		属性完整的对象
	 */
	public void getPage(Page<News> page,News n) throws Exception;
	
	/**
	 * 根据编号查询
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		对象
	 * @throws Exception 
	 */
	public News getById(Integer id) throws Exception;
	
	/**
	 * 根据条件查询
	 * 
	 * @param n
	 * 		由条件信息构成的对象
	 * 
	 * @return
	 * 		有则返回对象，没有返回null
	 * @throws Exception
	 */
	public List<News> getByColumn(News n) throws Exception;
}
