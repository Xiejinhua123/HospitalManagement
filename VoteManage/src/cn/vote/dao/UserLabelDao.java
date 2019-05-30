package cn.vote.dao;

import java.util.List;

import cn.vote.entity.UserLabel;
import cn.vote.model.UserModel;
import cn.vote.util.Page;

public interface UserLabelDao {
	
	
	void doVote(UserLabel userLabel);
	/**
	 * 给用户添加标签
	 * @param users 用户
	 * @param labelId	标签
	 */
	void addLabel(UserLabel userLabel);
	
	/**
	 * 删除用户标签
	 */
	public void delLabel(UserLabel userLabel);
	
	/**
	 * 获取用户标签集合
	 * @return
	 */
	List<UserLabel> getUserLabeAll(String id);
	
	/**
	 * 获取标签用户集合
	 * @return
	 */
	List<UserLabel> getUserByLabelId(Page<UserModel> p, Integer LabelId);

	/**
	 * 根据用户id和标签id获取标签
	 * @param usersId
	 * @param labelId
	 * @return
	 */
	UserLabel getById(String usersId,Integer labelId);
	
	public void deleteByLabel(Integer labelId);
	
	/**
	 * 获取标签使用量
	 * @param labelId 标签id
	 * @return	标签使用量
	 */
	Integer getNumberByLableId(Integer labelId);

	List<UserLabel> getUserByLabelIdTop10(Integer labelId);
	
	/**
	 * 获取标签达人
	 * @return
	 */
	List<UserLabel> getExpert();
	/**
	 * 获取标签达人票数
	 * @return
	 */
	List<Long> getExpertNumber() ;
	
}
