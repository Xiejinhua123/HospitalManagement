package cn.vote.action;

import cn.vote.model.Constants;
import cn.vote.util.WebUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invoc) throws Exception {

		Object obj = WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		if( obj == null ){
			return "noLogin";
		}
		return invoc.invoke();
	}
	
}
