package cn.vote.dao;

public interface RechargeRecordDao {

	/**
	 * 获取当前的用户的充值量
	 * @param id
	 * 		用户编号
	 * @return
	 * 		该用户的充值量
	 */
	Integer getAllPay(String id);

}
