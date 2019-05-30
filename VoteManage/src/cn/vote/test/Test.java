package cn.vote.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.vote.dao.AwardsDao;
import cn.vote.entity.Awards;
import cn.vote.model.BoxAwardsModel;
import cn.vote.service.GameService;

public class Test {
	
	public static void main(String[] args) {
		new Test().openTheBox();
	}
	
	/**
	 * 开宝箱测试
	 */
	public void openTheBox(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		
		GameService gs = (GameService) ac.getBean("gameService");
		AwardsDao awardsDao = (AwardsDao) ac.getBean("awardsDao");
		List<Awards> awards = awardsDao.getByGameId( 2 ); // 这个奖项应该是按照概率从小到大自动排列
		
		BoxAwardsModel b = gs.getBam(100, awards);
		
		System.out.println("中奖商品：");
		System.out.println("名称" + "\t" + "数量");
		Map<String , Integer> goods = new HashMap<String, Integer>();
		goods = b.getGoods();
		if( null != goods )
		for (String s : goods.keySet()) {
			System.out.println(s + "\t" + goods.get(s));
		}
		
		System.out.println("中奖龙珠：");
		System.out.println("名称" + "\t" + "数量");
		Map<String , Integer> balls = b.getBalls();
		if( null != balls )
		for (String s : balls.keySet()) {
			System.out.println(s + "\t" + balls.get(s));
		}
		
		System.out.println("中奖的宝箱：" + b.getBoxNumber());
		System.out.println("中奖的爱心：" + b.getLovaNumber());
	}

}
