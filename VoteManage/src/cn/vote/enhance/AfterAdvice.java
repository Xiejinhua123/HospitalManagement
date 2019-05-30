package cn.vote.enhance;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import cn.vote.entity.Admin;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.util.WebUtil;

public class AfterAdvice implements AfterReturningAdvice {
	private final Logger logger =Logger.getLogger(AfterAdvice.class); 
	/**
	  * method 为目标类的方法
	  *
	  * args 为目标类的入参
	  *
	  * obj 为目标类的实例
	  */
	@Override
	public void afterReturning(Object arg0, Method method, Object[] arg2,Object arg3) throws Throwable
	{
		   String name="";
		   Object o1= (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		   Admin a=(Admin)o1;
		   Object o=WebUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		   Users user=(Users)o;
		   if(a==null && user==null)name="";
		   else if(a==null) name=user.getUserName();
		   else name=a.getName();
		   SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String time=sd.format(new Date());
	       logger.info("后置增强:"+time+"用户 [ "+name+" ] 调用 '["+arg3.toString()+"]'类的'"+method.getName()+"'()方法");
	}
}