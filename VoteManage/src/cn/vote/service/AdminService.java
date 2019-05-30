package cn.vote.service;

import java.util.List;

import cn.vote.entity.Admin;
import cn.vote.model.AdminModel;
import cn.vote.model.AdminUpdateModel;



/**
 * 管理员信息，接口
 * 
 * @author 解金化
 * 
 * @date 2017.07.18
 *
 */
public interface AdminService {

	/**
	 * 管理员登录<br/>
	 * 
	 * 当前的方法必须有完备的参数异常处理，将不正确的参数用异常的形式传递<br/>
	 * 
	 * 在action中进行相对应的处理
	 * 
	 * @param name
	 * 		管理员昵称
	 * @param pwd
	 * 		管理员密码
	 * @return
	 * 		登录成功返回“success”<br/>
	 * 		登录失败，将会返回失败原因：1、noName:没有账号<br/>
	 * 							2、errorPwd:密码错误<br/>
	 * 							3、error:服务器错误<br/>
	 * @throws Exception
	 * 		自定义异常处理
	 * 
	 */
	public void doLogin(String name,String pwd) throws Exception;
	
	/**
	 * 该方法用于根据当前的用户姓名查询当前的用户列表
	 * 
	 * @param name
	 * 		用户姓名
	 * @return
	 * 		有返回true,没有返回false
	 * @throws Exception
	 * 		自定义异常
	 */
	public Boolean findByName( String name ) throws Exception;
	
	/**
	 * 上级创建下级用户<br/>
	 * 
	 * 	只需要提供用户名，其余部分全部自动生成，默认密码123456
	 * 
	 * @param name
	 * 		用户名
	 * @return 
	 * 		添加的用户信息
	 * @throws Exception
	 * 		添加失败，抛出异常
	 */
	public Admin addAdmin( String name ) throws Exception;
	
	/**
	 * 获取所有比自己权限低的管理员的信息
	 * 
	 * @return
	 * 		查询到的管理员的信息
	 * @throws Exception 
	 */
	public List<AdminModel> getAll() throws Exception;
	
	/**
	 * 修改管理员的信息，等级必须比自己要低
	 * 
	 * @param a
	 * 		修改的管理员的信息
	 * @return 
	 * @throws Exception
	 * 		执行失败的异常捕获
	 */
	Admin updateAdmin(Admin a) throws Exception;
	
	/**
	 * 删除管理员信息
	 * 
	 * @param adminId
	 * 		管理员编号
	 * @throws Exception 
	 */
	public void delAdmin(Integer adminId) throws Exception;

	/**
	 * 根据用户的编号查询用户
	 * 
	 * @param id
	 * 		用户编号
	 * @return
	 * 		用于修改的用户的模型类
	 * @throws Exception 
	 */
	public AdminUpdateModel getById(Integer id) throws Exception;

}
