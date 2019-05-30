package cn.vote.enhance;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import cn.vote.entity.Admin;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.util.WebUtil;

public class BeforeAdvice implements MethodBeforeAdvice{
	private final Logger logger =Logger.getLogger(BeforeAdvice.class); 
	/**
	  * method 为目标类的方法
	  *
	  * args 为目标类的入参
	  *
	  * obj 为目标类的实例
	  */
	@Override
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		   String name="";
		   Object o1=  WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		   Admin a=null;
		   Users user=null;
		   if(o1!=null && !"".equals(o1))a=(Admin)o1;
		   Object o=WebUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		   if(o!=null && !"".equals(o))user=(Users)o;
		   if(a==null && user==null)name="";
		   else if(a==null) name=user.getUserName();
		   else name=a.getName();
		   SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String time=sd.format(new Date());
		   logger.info("前置增强:"+time+"用户 [ "+name+" ] 使用 '"+obj.getClass().getName()+"' 类的 '"+method.getName()+"'()方法");
	}
}
