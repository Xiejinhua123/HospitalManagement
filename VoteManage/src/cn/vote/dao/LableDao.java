package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Lable;
import cn.vote.util.Page;

public interface LableDao {

	/**
	 * 分页
	 * 
	 * @param page
	 * @param l
	 * @return
	 */
	List<Lable> getPage(Page<cn.vote.model.LabelModel> page, Lable l);

	/**
	 * 查看所有标签
	 * 
	 * @return 标签集合
	 */
	public List<Lable> getAll();

	/**
	 * 根据标签id查询标签
	 * 
	 * @return 标签对象
	 */
	public Lable getById(Integer id);

	/**
	 * 修改标签信息
	 * 
	 * @return 成功返回true;
	 */
	public boolean update(Lable lable);

	/**
	 * 根据id删除标签
	 * 
	 * @param id
	 *            标签id
	 * @return 成功返回true
	 */
	public boolean delete(Lable lable);

	public boolean addLable(Lable lable);

}
