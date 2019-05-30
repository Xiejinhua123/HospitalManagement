package cn.vote.dao;

import java.text.ParseException;
import java.util.List;

import cn.vote.entity.UsersImg;
import cn.vote.entity.VotingRecords;

public interface VotingRecordsDao {
	
	
	
	/**
	 * 根据标签id查询投票记录集合
	 * @param id 标签id
	 * @return 投票记录集合
	 */
	public List<VotingRecords> getByLableId(Integer id);
	
	/**
	 * 根据用用户id查询用户投票记录集合
	 * @param id 用户id
	 * @return 用户投票记录集合
	 */
	public List<VotingRecords> getByUserId(Integer id);
	
	
	public void addVotingRecords(VotingRecords vr);

	/**
	 * 通过标签删除投票记录
	 * 
	 * @param id
	 * 		标签编号
	 * @throws ParseException 
	 */
	public void deteleByLabel(Integer id) throws ParseException;
	
}
