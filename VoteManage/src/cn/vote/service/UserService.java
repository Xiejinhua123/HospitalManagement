package cn.vote.service;

import java.util.List;

import cn.vote.entity.UserBall;
import cn.vote.entity.Users;
import cn.vote.model.UserModel;
import cn.vote.util.Page;

/**
 * 用户的业务处理
 * 
 * @author 解金化
 * 
 * @date 2017.07.16
 *
 */
public interface UserService {
	
	/**
	 * 用户登录
	 * @param name
	 * 		用户名
	 * @param pwd
	 * 		密码
	 * @return
	 * 		是否登陆成功
	 * @throws Exception 
	 */
	public boolean doLoginUser(String name,String pwd) throws Exception;
	
	/**
	 * 后台查看所有的用户
	 * @param page
	 * 		分页对象
	 */
	void getPageUser(Page<UserModel> page, String name, String tj)
			throws Exception;
	
	/**
	 * 获取投票排行榜
	 * @param page
	 * @throws Exception
	 */
	void getVotesRanking(Page<UserModel> page, String name) throws Exception;
	
	/**
	 * 用户修改自己的信息<br/>
	 * 
	 * 首先需要修改的是自己的地址信息，当前的所有地址  ， 删除  ， 重新添加<br/>
	 * 
	 * @param users
	 * 		用户
	 */
	void update(Users users) throws Exception;
	
	/**
	 * 执行投票<br/>
	 * 
	 * 验证在数据库中存储的数量是否够量不够需要充值，否买投票
	 * 
	 * 用户如果需要进行投票  必须验证 是否付款成功
	 * 
	 * @param voteNumber
	 * 		需要投的票数
	 * 
	 * @param uuid
	 * 		被投票的用户编号
	 * 
	 * @param id
	 * 		标签编号
	 * 
	 * @throws Exception
	 * 		自定义异常
	 */
	void doVote(int voteNumber , String uuid , Integer id) throws Exception;

	/**
	 * 验证用户的用户名在数据库中是否已经存在过
	 * 
	 * 如果存在就返回true
	 * 
	 * 不存在就返回false
	 * 
	 * @param userName
	 * 		用户的用户名
	 * 
	 * @author 解金化
	 * 
	 * @return 
	 * @throws Exception 
	 */
	public Boolean selectByName(String userName) throws Exception;


	/**
	 * 获取自己的信息
	 * @return
	 * @throws Exception 
	 */
	UserModel getMyUsers() throws Exception;
	
	/**
	 * 获取他人信息
	 * 
	 * @return
	 */
	UserModel getHimUsers(String usersId);
	
	/**
	 * 根据用户的编号获取用户的龙珠信息
	 * 
	 * @param usersId
	 * 		用户编号
	 * 
	 * @return
	 * 		用户龙珠信息
	 */
	List<UserBall> getUserBall(String usersId);
	
	/**
	 * 获取投票前十名
	 * @return
	 */
	public List<UserModel> getVoteTen();

	/**
	 * 添加用户
	 * 
	 * @param users
	 * 		用户实体
	 * 
	 * @param userNumber
	 * 		需要添加的用户数量
	 * 
	 * @param urls
	 * 		添加的用户上传的头像路径
	 */
	void add(Users users, Integer userNumber, String[] urls) throws Exception;

	/**
	 * 随机获得三明用户
	 * 
	 * @return
	 */
	List<UserModel> getrandom();

	public List<UserModel> getUserByUserName(String name)throws Exception;
	/**
	 * 获取达人
	 * @return
	 */
	public List<UserModel> getExpert(Page<UserModel> page);
}
