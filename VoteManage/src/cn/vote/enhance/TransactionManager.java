package cn.vote.enhance;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import cn.vote.entity.Admin;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.util.WebUtil;

public class TransactionManager implements ThrowsAdvice {
	private final Logger logger =Logger.getLogger(TransactionManager.class);
    public void afterThrowing(Method method,Object [] args,Object target,Exception ex)throws Throwable{
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
	       logger.error("异常: [ "+time+name+" ] 使用 ' "+target.toString()+" ' 类的 ' "+method.getName()+" ' 方法,抛出异常"+ex.getMessage());
     }
 }