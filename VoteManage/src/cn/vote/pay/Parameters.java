package cn.vote.pay;

/**
 * 支付需要的必备参数
 * 
 * @author 解金化
 *
 */
public class Parameters {

	/**
	 * APP ID
	 */
	private String app_id;
	
	/**
	 * 签名<br/>
	 * 
	 * MD5加密
	 */
	private String sign;
	
	/**
	 * 页面跳转<br/>
	 * 
	 *  false
	 */
	private String return_url;
	
	/**
	 * 交易异步通知地址<br/>
	 * 
	 * 支付方服务器主动通知商户网站里制定的页面http地址
	 */
	private String notify_url;
	
	/**
	 * 使用的支付渠道<br/>
	 * 
	 * 支付宝：ALIPAY_WAP <br/>
	 * 
	 * 微信：SML_WEIXIN_WAP
	 */
	private String channel;
	
	/**
	 * 商户网站唯一订单号<br/>
	 * 
	 * 由后台自主生成的唯一订单号
	 */
	private String out_trade_no;
	
	/**
	 * 订单名称<br/>
	 * 交易标题
	 */
	private String subject;
	
	/**
	 * 订单描述<br/>
	 * false
	 */
	private String description;
	
	/**
	 * 订单金额 单位是：分
	 */
	private long total_fee;
	
	/**
	 * 额外参数，用于数据透传，支付返回结果带有该参数<br/>
	 * 
	 * 平台提供<br/>
	 * 
	 * false
	 */
	private String extra;
	
	/**
	 * 客户端ip地址<br/>
	 * 
	 * 发起支付的客户端ip<br/>
	 * 
	 * 使用微信支付渠道该 ip 必须是真实的ip
	 */
	private String ip;

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(long total_fee) {
		this.total_fee = total_fee;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
