package cn.vote.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import cn.vote.dao.BallDao;
import cn.vote.dao.LableDao;
import cn.vote.dao.UserAddressDao;
import cn.vote.dao.UserBallDao;
import cn.vote.dao.UserDao;
import cn.vote.dao.UserLabelDao;
import cn.vote.dao.UsersImgDao;
import cn.vote.dao.VotingRecordsDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Lable;
import cn.vote.entity.UserBall;
import cn.vote.entity.UserLabel;
import cn.vote.entity.Users;
import cn.vote.entity.UsersImg;
import cn.vote.entity.VotingRecords;
import cn.vote.model.Constants;
import cn.vote.model.UserModel;
import cn.vote.service.UserService;

import cn.vote.util.DateUtils;
import cn.vote.util.Generate;
import cn.vote.util.MD5;
import cn.vote.util.Page;
import cn.vote.util.ParamCheck;
import cn.vote.util.WebUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private UserAddressDao userAddressDao;

	private VotingRecordsDao votingRecordsDao;

	private LableDao lableDao;

	private UserBallDao userBallDao;

	private UsersImgDao userImgDao;

	private BallDao ballDao;

	private UserLabelDao userLabelDao;

	@Override
	public UserModel getMyUsers() throws Exception {
		Users u = (Users) WebUtil
				.getSessionAttribute(Constants.SESSION_USER_KEY);
//		List<UsersImg> list2 = null;
//		list2 = userImgDao.getByUsersId(u.getId());
		UserModel user = new UserModel();
		user.setBoxNumber(u.getBoxNumber());
		user.setBallNumber(u.getBallNumber());
		user.setId(u.getId());
		user.setVoteNumber(u.getVoteNumber());
		user.setLoveNumber(u.getLoveNumber());
		user.setName(u.getUserName());
		user.setTotalVotes(u.getTotalVotes());
		user.setLabelList(getUserLabel(u.getId()));
		user.setImgUrl(u.getUserAvatar());
		user.setTelephone(u.getTelephone());
		user.setDeleteds(u.getDeleteds()+"");
		// 1-7星龙珠个数
		
		List<UserBall> ballList=userBallDao.getByUserId(u.getId());
		for (UserBall userBall : ballList) {
			if(userBall.getId().equals(1))
			{
				user.setOneball(userBall.getNumber());
			}else if(userBall.getId().equals(2))
			{
				user.setTwoball(userBall.getNumber());
			}else if(userBall.getId().equals(3))
			{
				user.setThreeball(userBall.getNumber());
			}else if(userBall.getId().equals(4))
			{
				user.setFourball(userBall.getNumber());
			}else if(userBall.getId().equals(5))
			{
				user.setFiveball(userBall.getNumber());
			}else if(userBall.getId().equals(6))
			{
				user.setSixball(userBall.getNumber());
			}else if(userBall.getId().equals(7))
			{
				user.setSevenball(userBall.getNumber());
			}
		}
		return user;
	}

	@Override
	public UserModel getHimUsers(String usersId) {
		Users u = userDao.getById(usersId);
		List<UsersImg> list2 = null;
		list2 = userImgDao.getByUsersId(u.getId());
//		获取用户其他图片
//		List<UsersImg> list2=null;
//		list2=userImgDao.getByUsersId(u.getId());
		UserModel user = new UserModel();
		user.setBoxNumber(u.getBoxNumber());
		user.setBallNumber(u.getBallNumber());
		user.setId(u.getId());
		user.setTelephone(u.getTelephone());
		user.setVoteNumber(u.getVoteNumber());
		user.setLoveNumber(u.getLoveNumber());
		user.setName(u.getUserName());
		user.setTotalVotes(u.getTotalVotes());
		user.setImgUrl(u.getUserAvatar());
		user.setTelephone(u.getTelephone());
		user.setDeleteds(u.getDeleteds()+"");
		// 1-7星龙珠个数
		List<UserBall> ballList=userBallDao.getByUserId(u.getId());
		for (UserBall userBall : ballList) {
			if(userBall.getBall().getId().equals(1))
			{
				user.setOneball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(2))
			{
				user.setTwoball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(3))
			{
				user.setThreeball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(4))
			{
				user.setFourball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(5))
			{
				user.setFiveball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(6))
			{
				user.setSixball(userBall.getNumber());
			}else if(userBall.getBall().getId().equals(7))
			{
				user.setSevenball(userBall.getNumber());
			}
		}
		return user;
	}

	@Override
	public void getPageUser(Page<UserModel> page, String name, String tj)
			throws Exception {
		if (!ParamCheck.checked(page, new String[] { "total", "pageCount",
				"rows" }))
			throw new Exception("分页获取用户信息失败，当前参数为null");
		try {
			List<Users> list = null;
			if (name == null || "".equals(name))
				list = userDao.getPage(page, null, null);// 分页查询全部
			else
				list = userDao.getPage(page, name, tj);// 分页查询全部
			List<UserModel> lik = new ArrayList<UserModel>();// 放入model中
			UserModel user = null;
			String operations = "";

			for (Users u : list) {
				List<UsersImg> list2 = null;
				list2 = userImgDao.getByUsersId(u.getId());
//				获取用户其他图片
//				List<UsersImg> list2=null;
//				list2=userImgDao.getByUsersId(u.getId());
				user = new UserModel();
				user.setBoxNumber(u.getBoxNumber());
				user.setBallNumber(u.getBallNumber());
				user.setId(u.getId());
				user.setVoteNumber(u.getVoteNumber());
				user.setLoveNumber(u.getLoveNumber());
				user.setName(u.getUserName());
				user.setTotalVotes(u.getTotalVotes());
				user.setLabelList(getUserLabel(u.getId()));
				user.setImgUrl(u.getUserAvatar());
				user.setDeleteds(u.getDeleteds()+"");
				if (u.getUserType() == 1) {
					user.setUserType("机器人用户");
				} else if (u.getUserType() == 0) {
					user.setUserType("正常用户");
				}
				if (u.getDeleteds().equals("1")) {
					operations = "<button class='btn btn-info' onclick=\"updateUser()\">修改"
							+ "</button>  <button class='btn btn-success' onclick=\"deleteUser()\">删除</button>";
				} else {
					operations = "<button class='btn btn-info' onclick=\"updateUser( \'"
							+ u.getId()
							+ "\' )\">修改"
							+ "</button>  <button class='btn btn-success' onclick=\"deleteUser(\'"
							+ u.getId() + "\')\">删除</button>";
				}
				user.setOperations(operations);
				lik.add(user);
			}
			page.setRows(lik);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserModel> getExpert(Page<UserModel> page) {
		List<UserLabel> list = userLabelDao.getExpert();
		List<Users> list1=new ArrayList<Users>();
		for (UserLabel userLabel : list) {
			list1.add(userLabel.getUsers());
		}
		List<UserModel> list2=new ArrayList<UserModel>();
		for (Users u : list1) {
			UserModel user= new UserModel();
			user.setName(u.getUserName());
			user.setVoteNumber(u.getVoteNumber());
			user.setId(u.getId());
			user.setImgUrl(u.getUserAvatar());
			list2.add(user);
		}
		List<Long> list3=userLabelDao.getExpertNumber();
		for (int i = 0; i < list3.size(); i++) {
			list2.get(i).setVoteNumber(list3.get(i).intValue());
		}
		
		return list2;
	}

	@Override
	public void getVotesRanking(Page<UserModel> page, String name)
			throws Exception {
		if (!ParamCheck.checked(page, new String[] { "total", "pageCount",
				"rows" }))
			throw new Exception("分页获取用户信息失败，当前参数为null");
		List<Users> list = userDao.gettotal(page, name);
		List<UserModel> lik = new LinkedList<UserModel>();
		UserModel user = null;
		for (Users u : list) {
			user = new UserModel();
			user.setBoxNumber(u.getBoxNumber());
			user.setId(u.getId());
			user.setImgUrl(u.getUserAvatar());
			user.setVoteNumber(u.getVoteNumber());
			user.setLoveNumber(u.getLoveNumber());
			user.setName(u.getUserName());
			user.setBirthday(u.getBirthday());
			user.setBallNumber(u.getBallNumber());
			user.setTotalVotes(u.getTotalVotes());
			user.setDeleteds(u.getDeleteds()+"");
			lik.add(user);
		}
		page.setRows(lik);
	}

	@Override
	public void doVote(int voteNumber, String uuid, Integer id)
			throws Exception {

		if (voteNumber <= 0) {
			throw new Exception("执行投票数量少于1票");
		}

		Users user = (Users) WebUtil
				.getSessionAttribute(Constants.SESSION_USER_KEY);
		// Users user=userDao.getById("1500967969865");
		if (user.getVoteNumber() < voteNumber) {

			throw new Exception("pay"); // 账户中的投票总量没有投的多，返回充值
		}

		if (uuid.equals(user.getId())) {

			throw new Exception("forOneself"); // 自己给自己投票
		}

		Users uuser = this.userDao.getById(uuid);

		if (uuser == null) {

			throw new Exception("voteObj not exist"); // 投票对象不存在
		}
		// 如果用户被删除不能投票
		if (uuser.getDeleteds().equals("1") || user.getDeleteds().equals("1"))
			return;

		// 增加投票记录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(new Date());
		Timestamp ts = Timestamp.valueOf(s);// 获取当前时间
		Admin a=(Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		Lable lable = null;
		if (id != null)
			lable = lableDao.getById(id);// 获取标签
		VotingRecords vr = new VotingRecords();
		vr.setId(DateUtils.getUUID().substring(1, 15));
		vr.setUsersByUserId(user);
		vr.setUsersByVoteUserId(uuser);
		vr.setLable(lable);
		vr.setVoteNumber(voteNumber);
		vr.setRecordTime(ts);
		vr.setDelete("0");
		vr.setUpdateTime(new Date());
		vr.setAdminByUpdate(a);
		votingRecordsDao.addVotingRecords(vr);

		// 修改本用户账户信息
		user.setVoteNumber(user.getVoteNumber() - voteNumber);

		// 修改用户的宝箱数
		user.setBoxNumber(user.getBoxNumber() + voteNumber);
		user.setDeleteds(0);
		user.setUpdateTime(new Date());
		user.setAdminByUpdate(a);
		try {
			this.userDao.updateUser(user);
		} catch (Exception e) {
			throw new Exception("error");
		}
		uuser.setTotalVotes(uuser.getTotalVotes() + voteNumber);
		try {
			this.userDao.updateUser(user);
		} catch (Exception e) {
			throw new Exception("error");
		}
	}

	@Override
	public void update(Users users) throws Exception {
		Users u = userDao.getById(users.getId());
		if (u.getDeleteds().equals("1"))
			return;
		users.setUserPassword(new MD5(users.getUserPassword()).compute());
		userDao.updateUser(users);
	}

	@Override
	public boolean doLoginUser(String name, String pwd) throws Exception {
		MD5 m=new MD5(pwd);
		Users u = userDao.doLogin(name, m.compute());
		if (u != null) {
			if (u.getDeleteds() == 1) {
				throw new Exception("state"); // 表示状态异常
			}
			if (u.getUserType() == 1) {
				throw new Exception("type"); // 表示用户是机器人 ， 不允许登录
			}
			WebUtil.setSessionAttribute(Constants.SESSION_USER_KEY, u);
			return true;
		}
		return false;
	}

	@Override
	public Boolean selectByName(String userName) throws Exception {
		if (null == userName || userName.length() <= 0)
			throw new Exception("parmar");
		Long num = this.userDao.getNumByName(userName);
		
		if (num > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<UserBall> getUserBall(String usersId) {
		try {
			List<UserBall> list = userBallDao.getByUserId(usersId);
			if (list != null)
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取用户id获取标签集合
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Lable> getUserLabel(String userId) throws Exception {
		if (userId == null)
			throw new Exception("getUserLabel  参数为空");
		List<UserLabel> list = userLabelDao.getUserLabeAll(userId);
		List<Lable> list1 = new ArrayList<Lable>();
		if (list == null)
			return null;
		for (UserLabel userLabel : list) {
			Lable l = lableDao.getById(userLabel.getLable().getId());
			list1.add(l);
		}
		return list1;
	}

	@Override
	public List<UserModel> getVoteTen() {
		List<Users> list = userDao.getVoteTen(1, 10);
		List<UserModel> list1 = new ArrayList<UserModel>();
		for (Users users : list) {
			UserModel u = new UserModel();
			u.setDeleteds(users.getDeleteds()+"");
			u.setId(users.getId());
			u.setImgUrl(users.getUserAvatar());
			u.setName(users.getUserName());
			list1.add(u);
		}
		return list1;
	}

	@Override
	public void add(Users users, Integer userNumber, String[] urls)
			throws Exception {

		if (users == null || users.getUserName() == null
				|| users.getUserPassword() == null
				|| users.getUserType() == null) {
			throw new Exception("添加用户失败，必要参数为null");
		}

		Admin admin = null;
		try{
			admin = (Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			admin = null;
		}
		
		if (userNumber != 0) {
			for (int i = 0; i < userNumber; i++) {
				Users user = new Users();
				String id = Generate.getId();
				while (this.userDao.getById(id) != null) {
					id = Generate.getId();
				}
				user.setId(id);
				user.setBallNumber(0);
				user.setBirthday(users.getBirthday());
				user.setBoxNumber(0);
				user.setDeleteds(0);
				user.setLoveNumber(0);
				user.setTelephone("13838838438");
				user.setTotalVotes(0);
				if (urls.length > 0)
					user.setUserAvatar(urls[0]);
				user.setUserName( users.getUserName() + (i + "" ));
				user.setUserPassword(users.getUserPassword());
				user.setUserType(users.getUserType());
				user.setVoteNumber(0);
				user.setWechatName("");
				user.setDeleteds(0);
				user.setAdminByUpdate(admin);
				user.setUpdateTime(new Date());

				try {
					this.userDao.addUser(user);
				} catch (Exception e) {
					throw new Exception("添加用户执行数据库失败");
				}
			}
		}
	}

	@Override
	public List<UserModel> getrandom() {
		int size = userDao.getAll().intValue();
		int sizeNum = size / 3;
		List<Users> list = userDao.getVoteTen(sizeNum, 3);
		List<UserModel> list1 = new ArrayList<UserModel>();
		for (Users users : list) {
			UserModel u = new UserModel();
			u.setId(users.getId());
			u.setImgUrl(users.getUserAvatar());
			u.setTotalVotes(users.getTotalVotes());
			u.setName(users.getUserName());
			u.setDeleteds(users.getDeleteds()+"");
			list1.add(u);
		}
		return list1;
	}

	@Override
	public List<UserModel> getUserByUserName(String name)throws Exception {
		if(name==null || "".equals(name))throw new Exception("getUserByUserName()参数错误");
		List<Users> list=userDao.getUserByUserName(name);
		List<UserModel> list1=new ArrayList<UserModel>();
		for (Users users : list) {
			UserModel u = new UserModel();
			u.setId(users.getId());
			u.setImgUrl(users.getUserAvatar());
			u.setTotalVotes(users.getTotalVotes());
			u.setName(users.getUserName());
			u.setDeleteds(users.getDeleteds()+"");
			list1.add(u);
		}
		return list1;
	}

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao)  {
		this.userDao = userDao;
	}

	public UserAddressDao getUserAddressDao() {
		return userAddressDao;
	}

	public void setUserAddressDao(UserAddressDao userAddressDao) {
		this.userAddressDao = userAddressDao;
	}

	public VotingRecordsDao getVotingRecordsDao() {
		return votingRecordsDao;
	}

	public void setVotingRecordsDao(VotingRecordsDao votingRecordsDao) {
		this.votingRecordsDao = votingRecordsDao;
	}

	public LableDao getLableDao() {
		return lableDao;
	}

	public void setLableDao(LableDao lableDao) {
		this.lableDao = lableDao;
	}

	public UserBallDao getUserBallDao() {
		return userBallDao;
	}

	public void setUserBallDao(UserBallDao userBallDao) {
		this.userBallDao = userBallDao;
	}

	public UserLabelDao getUserLabelDao() {
		return userLabelDao;
	}

	public void setUserLabelDao(UserLabelDao userLabelDao) {
		this.userLabelDao = userLabelDao;
	}

	public BallDao getBallDao() {
		return ballDao;
	}

	public void setBallDao(BallDao ballDao) {
		this.ballDao = ballDao;
	}

	public UsersImgDao getUserImgDao() {
		return userImgDao;
	}

	public void setUserImgDao(UsersImgDao userImgDao) {
		this.userImgDao = userImgDao;
	}

	
	
}
