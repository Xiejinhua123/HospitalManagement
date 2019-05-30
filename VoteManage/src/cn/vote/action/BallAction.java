package cn.vote.action;

import java.util.List;

import cn.vote.entity.Ball;
import cn.vote.model.BallModel;
import cn.vote.service.BallService;

public class BallAction extends ActionBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737738418068956301L;
	private BallService ballService;
	private Ball ball;
	private Integer id;
	//获取全部龙珠信息
	@SuppressWarnings("unused")
	public void getAll()
	{
		try {
			List<Ball> list=ballService.getAll();
			if(list!=null)super.setJson(list);
			else super.setJson("false");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	//修改龙珠信息
	public void updateBall()
	{
		try {
		boolean b =	ballService.updateBall(ball);
		if(b)super.setJson("true");
		else super.setJson("false");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void getById()
	{
		try {
		 ball =	ballService.getById(id);
		 if(ball!=null)super.setJson(ball);
		 else super.setJson("false");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	//获取龙珠详细
	public void getBallxx()
	{
		try {
		BallModel bm=ballService.getBallModelById(id);
		if(bm!=null) super.setJson(bm);
		 else super.setJson("false");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public BallService getBallService() {
		return ballService;
	}
	public void setBallService(BallService ballService) {
		this.ballService = ballService;
	}
	public Ball getBall() {
		return ball;
	}
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
