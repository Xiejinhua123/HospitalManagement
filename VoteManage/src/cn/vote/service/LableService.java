package cn.vote.service;


import java.util.List;

import cn.vote.entity.Lable;
import cn.vote.model.LabelModel;
import cn.vote.util.Page;

public interface LableService {
	/**
	 * 分页的形式
	 * 查看标签 并计算标签使用数
	 * @return 标签集合
	 */
	public void getAll ( Page<LabelModel> page,Lable l)throws Exception ;
	
	/**
	 * 获取所有标签
	 * @return
	 */
	 public List<LabelModel> getAllLabel();
	
	public Lable getById(Integer id)throws Exception ;
	/**
	 * 修改标签信息
	 * @return 成功返回true;
	 */
	public boolean updateLable(Lable lable)throws Exception ;
	
	/**
	 * 根据id删除标签
	 * @param id 标签id
	 * @return 成功返回true
 	 */
	public boolean delete(Integer id)throws Exception ;
	
	public boolean addLable(Lable lable)throws Exception;
}
