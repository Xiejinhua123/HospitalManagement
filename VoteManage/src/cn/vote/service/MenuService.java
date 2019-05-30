package cn.vote.service;

import java.util.List;

import cn.vote.model.MenuModel;

/**
 * 菜单栏的管理
 * 
 * @author 解金化
 * 
 * @date 2017.08.13
 *
 */
public interface MenuService {

	/**
	 * 该方法用来在用户登录之后进行权限的验证处理<br/><br/>
	 * 
	 * 所有被拦截的路径，都会被和该方法返回的模型类进行匹配<br/><br/>
	 * 
	 * 该方法返回一个int类型的集合，集合中存放的是当前登录用户拥有的权限信息编号<br/><br/>
	 * @return 
	 * 		菜单项模型集合
	 */
	List<MenuModel> getMenu() throws Exception;
	
	/**
	 * 通过给定的菜单模型的集合，返回一段html代码
	 * 
	 * @param list
	 * 		需要的模型集合
	 * @return
	 * 		HTML代码
	 * @throws Exception
	 * 		自定异常
	 */
	String toHtml( List<MenuModel> list ) throws Exception;
	
	/**
	 * 将当前的权限信息放入session中，以便在拦截的时候进行比对
	 * 
	 * @param list
	 * 		需要的模型集合
	 * @throws Exception
	 * 		自定义异常
	 */
	void toSessionList( List<MenuModel> list ) throws Exception;
}
