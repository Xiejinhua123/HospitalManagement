package cn.vote.service;

public interface VoteService {
	
	/**
	 * 
	 * 投票人宝箱+1
	 * 被投票人票数+1
	 */
	/**
	 * 进行投票
	 * @param 投票数
	 * @param 被投人Id
	 */
	public void vote(int number,String UserId);
	
	/**
	 * 用户打开宝箱
	 * 宝箱数-1
	 * 随机获得龙珠或者爱心数
	 * @param name 获得商品名称
	 * @param 数量
	 */
	public void OpenBox(String name,int number);
	
	/**
	 * 转盘游戏
	 * 消耗爱心
	 * 随机获得龙珠或者爱心数
	 */
	public void turntable();
	
}
