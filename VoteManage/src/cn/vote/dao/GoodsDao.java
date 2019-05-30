package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Goods;
import cn.vote.util.Page;

public interface GoodsDao {
	/**
	 * 获取所有商品,条件查询
	 * @return 商品集合
	 */
	public void getPageAll(Page page,String name);
	
	/**
	 * 修改商品
	 * @param g
	 * @return
	 */
	public boolean updaupdateGoods(Goods g);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Goods getById(Integer id);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public boolean delete(Goods g);

	/**
	 * 添加商品信息
	 * @param goods
	 */
	public void add(Goods goods);
	
	/**
	 * 获取所有商品名称
	 * @return
	 */
	public List<String> getAllGoodsName();
	
	Goods getByName(String name);
}
