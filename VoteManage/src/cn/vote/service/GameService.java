package cn.vote.service;

import java.util.List;

import cn.vote.entity.Awards;
import cn.vote.model.BoxAwardsModel;

/**
 * 游戏部分的业务处理
 * @author 解金化
 *
 */
public interface GameService {

	/**
	 * 开宝箱
	 * 
	 * @param 开启的宝箱数量
	 * 
	 * @return
	 * 		开启所有的宝箱之后获得的奖品
	 * @throws Exception
	 * 		自定义异常 
	 */
	public BoxAwardsModel openTheBox(Integer boxNumber) throws Exception;

	BoxAwardsModel getBam(Integer number, List<Awards> awards);

}
