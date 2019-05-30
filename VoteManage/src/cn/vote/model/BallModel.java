package cn.vote.model;

/**
 * 龙珠信息说明
 * @author Administrator
 *
 */
public class BallModel {
	private Integer id;			  //龙珠id
	private String ballName;	  //龙珠名称
	private Float probability;	  //概率
	private String text;		  //概率说明
	private Integer putIntoNumber;//龙珠投入数量
	private Integer exchangeNumber;//被兑换的数量	
	private Integer userballNumber;//用户手中的数量
	private String BallInstructions;//龙珠说明
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBallName() {
		return ballName;
	}
	public void setBallName(String ballName) {
		this.ballName = ballName;
	}
	public Float getProbability() {
		return probability;
	}
	public void setProbability(Float probability) {
		this.probability = probability;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPutIntoNumber() {
		return putIntoNumber;
	}
	public void setPutIntoNumber(Integer putIntoNumber) {
		this.putIntoNumber = putIntoNumber;
	}
	public Integer getExchangeNumber() {
		return exchangeNumber;
	}
	public void setExchangeNumber(Integer exchangeNumber) {
		this.exchangeNumber = exchangeNumber;
	}
	public Integer getUserballNumber() {
		return userballNumber;
	}
	public void setUserballNumber(Integer userballNumber) {
		this.userballNumber = userballNumber;
	}
	public String getBallInstructions() {
		return BallInstructions;
	}
	public void setBallInstructions(String ballInstructions) {
		BallInstructions = ballInstructions;
	}
	
	
	
}
