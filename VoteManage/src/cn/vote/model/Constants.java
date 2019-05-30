package cn.vote.model;

/**
 * 储存在session中的参数名称
 * @author 李宜昌
 *
 */
public class Constants {
	/**
	 * 后台管理员登录之后放入session中的用户
	 */
	 public static final String SESSION_LONG_ADMIN_KEY="loginAdmin";
	 
	 /**
	  * 用户登录之后放入session中的用户
	  */
	 public static final String SESSION_USER_KEY = "users";
	 
	 /**
	  * 投票支付后，在系统中存储的支付状态
	  */
	 public static final String SESSION_PAY_STATIC_KEY = "paystatic";
	 
	 /**
	  * 登陆成功之后将查询到的该用户的权限信息储存在session中，这是session中的键
	  */
	// public static final String SESSION_LOGIN_RESOURCE = "resource";
	 
	 /**
	  * 登录之后将菜单信息放入到session中，通过jsp直接获取
	  */
	 public static final String SESSION_LOGIN_MENUHTML = "menuHtml";
	 
	 /**
	  * 登陆成功之后的权限比对情况，将该用户所拥有的权限编号放入到session中<br/>
	  * 在每一次的提交请求的时候进行比对信息
	  */
	 public static final String SESSION_LOGIN_MENUID = "menuId";
}
