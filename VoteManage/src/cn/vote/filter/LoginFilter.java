package cn.vote.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vote.model.Constants;

@WebFilter(urlPatterns = "/pagefile/pages/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		String pageName = url.substring(url.lastIndexOf("/") + 1, url.length());
		if(pageName.equals("controller.jsp"))
		{
			chain.doFilter(req, res);
			return;
		}	
		
		if (pageName.equals("login.htm")) {
			chain.doFilter(req, res);
			return;
		}
		String suffix = pageName.substring(pageName.lastIndexOf(".") + 1,
				pageName.length());
		if (suffix.equals("jsp") || suffix.equals("html")) {
			Object obj = request.getSession().getAttribute(
					Constants.SESSION_LONG_ADMIN_KEY);
			if (null == obj) {
				response.sendRedirect("/VoteManage/pagefile/pages/login.htm");
			} else {
				if(pageName.equals("shouye.jsp"))
				{
					chain.doFilter(req, res);
					return;
				}	
				// 如果已经登录进行权限过滤
				try {
					Object o = request.getSession().getAttribute(
							Constants.SESSION_LOGIN_MENUID);
					String[] s = request.getParameterValues("resId");
					Integer rId = null;
					if (s != null)
						rId = Integer.parseInt(s[0]);
					else
						response.sendRedirect("/VoteManage/pagefile/pages/login.htm");
					if (o == null)
						response.sendRedirect("/VoteManage/pagefile/pages/login.htm");
					else {
						Integer[] i = (Integer[]) o;
						for (Integer integer : i) {
							if( rId == null ){
								response.sendRedirect("/VoteManage/pagefile/pages/login.htm");
							}
							if (rId.equals(integer)) {
								chain.doFilter(req, res);
								return;
							}
						}
					}
					response.sendRedirect("/VoteManage/pagefile/pages/login.htm");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
