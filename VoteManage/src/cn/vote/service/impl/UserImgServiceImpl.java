package cn.vote.service.impl;

import java.util.List;

import cn.vote.dao.UsersImgDao;
import cn.vote.entity.Users;
import cn.vote.entity.UsersImg;
import cn.vote.model.Constants;
import cn.vote.service.UserImgService;
import cn.vote.util.DateUtils;
import cn.vote.util.WebUtil;

public class UserImgServiceImpl implements UserImgService {

	private UsersImgDao usersImgDao;

	@Override
	public void addUserImg(UsersImg ui) throws Exception {
		if (ui.getImgUrl() == null)
			throw new Exception("用户图片参数为空");
		try {
			Users users = (Users) WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			ui.setUsers(users);
			ui.setId(DateUtils.getUUID());
			usersImgDao.addUserImg(ui);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delUserImg(String uiId) throws Exception {
		if (uiId == null)
			throw new Exception("用户图片参数为空");
		try {
			usersImgDao.delUserImg(uiId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UsersImg> getAllUserImg() {
		try {
			List<UsersImg> list = usersImgDao.getAll();
			if (list != null)
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UsersImgDao getUsersImgDao() {
		return usersImgDao;
	}

	public void setUsersImgDao(UsersImgDao usersImgDao) {
		this.usersImgDao = usersImgDao;
	}

}
