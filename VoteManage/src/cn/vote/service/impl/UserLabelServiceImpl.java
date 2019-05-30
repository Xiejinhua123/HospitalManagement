package cn.vote.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.vote.dao.LableDao;
import cn.vote.dao.UserLabelDao;
import cn.vote.entity.Lable;
import cn.vote.entity.UserLabel;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.model.UserLableModel;
import cn.vote.model.UserModel;
import cn.vote.service.UserLabelService;
import cn.vote.util.Page;
import cn.vote.util.WebUtil;

public class UserLabelServiceImpl implements UserLabelService {

	private UserLabelDao userLabelDao;
	private LableDao lableDao;

	@Override
	public void addUserLabel(Integer labelId) {
		try {
			Users user = (Users) WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			if (labelId == null || user == null)
				throw new Exception("addUserLabel() null");
			UserLabel ul1=userLabelDao.getById(user.getId(), labelId);
			if(ul1==null)//如果没有记录，添加一条心记录
			{
				Lable l = lableDao.getById(labelId);// 获取标签
				UserLabel ul = new UserLabel();
				ul.setUsers(user);
				ul.setLable(l);
				userLabelDao.addLabel(ul);// 添加用户标签
			}else//如果有记录修改票数
			{
				ul1.setVoteNumber(ul1.getVoteNumber()+1);
				userLabelDao.doVote(ul1);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Override
	public void delUserLabel(Integer labelId) {
		try {
			Users user = (Users) WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			if (labelId == null || user == null)
				throw new Exception("addUserLabel() null");
			Lable l = lableDao.getById(labelId);// 获取标签
			UserLabel ul = new UserLabel();
			ul.setUsers(user);
			ul.setLable(l);
			userLabelDao.delLabel(ul);// 删除用户标签
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public List<UserLabel> getUserLabel() {

		Users user = (Users) WebUtil
				.getSessionAttribute(Constants.SESSION_USER_KEY);
		return userLabelDao.getUserLabeAll(user.getId());
	}
	@Override
	public List<UserLableModel> getUserByLabelIdTop10(Integer labelId) throws Exception  {
		if (labelId == null)
			throw new Exception("getUserByLabelIdTop10参数为空");
		List<UserLabel> list=userLabelDao.getUserByLabelIdTop10(labelId);
		List<UserLableModel> list1=new ArrayList<UserLableModel>();
		if(list!=null)
		{
			for (UserLabel userLabel : list) {
				UserLableModel um=new UserLableModel();
				um.setVoteNumber(userLabel.getUsers().getVoteNumber());
				um.setName(userLabel.getUsers().getUserName());
				um.setUsersID(userLabel.getUsers().getId());
				um.setUrl(userLabel.getUsers().getUserAvatar());
				um.setLableVoteNumber(userLabel.getVoteNumber());
				list1.add(um);
			}
			return list1;
		}
		return null;
	}

	@Override
	public void getUserByLabelId(Page<UserModel> p, Integer id) throws Exception {
		if (id == null)
			throw new Exception("getUserByLabelId(id)参数为空");
		List<UserLabel> list = userLabelDao.getUserByLabelId(p, id);
		List<Users> list1 = new ArrayList<Users>();
		List<UserModel> list2 = new ArrayList<UserModel>();
		if (list == null)
			return;
		for (UserLabel userLabel : list) {
			Users user = userLabel.getUsers();
			list1.add(user);
		}
		UserModel user = null;
		for (Users u : list1) {
			user = new UserModel();
			user.setBoxNumber(u.getBoxNumber());
			user.setId(u.getId());
			user.setImgUrl(u.getUserAvatar());
			user.setLoveNumber(u.getLoveNumber());
			user.setName(u.getUserName());
			user.setTotalVotes(u.getTotalVotes());
			user.setDeleteds(u.getDeleteds()+"");
			if( u.getUserType() == 1 ){
				user.setUserType("机器人用户");
			}else if( u.getUserType() == 0 ){
				user.setUserType("正常用户");
			}
			String operations="";
			if(u.getDeleteds().equals("1"))
			{
				operations = "<button class='btn btn-info' onclick=\"updateUser()\">修改" +
						"</button>  <button class='btn btn-success' onclick=\"deleteUser()\">删除</button>";
			}else{
				operations = "<button class='btn btn-info' onclick=\"updateUser( \'" + u.getId() + "\' )\">修改" +
						"</button>  <button class='btn btn-success' onclick=\"deleteUser(\'" + u.getId() + "\')\">删除</button>";
			}
			user.setOperations(operations);
			list2.add(user);
		}
		p.setRows(list2);
		Integer num = userLabelDao.getNumberByLableId(id);
		if (num == null)
			p.setTotal(0);
		else
			p.setTotal(num);
	}

	public LableDao getLableDao() {
		return lableDao;
	}

	public void setLableDao(LableDao lableDao) {
		this.lableDao = lableDao;
	}

	public UserLabelDao getUserLabelDao() {
		return userLabelDao;
	}

	public void setUserLabelDao(UserLabelDao userLabelDao) {
		this.userLabelDao = userLabelDao;
	}

	
}
