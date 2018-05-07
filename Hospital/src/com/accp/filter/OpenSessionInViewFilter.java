package com.accp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accp.demo.Common;
import com.accp.util.HibernateUtil;

@WebFilter(urlPatterns="/*")
public class OpenSessionInViewFilter implements Filter {
	String url;
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException 
	{		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
//		 url=request.getRequestURI();
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.currentSession();
			tx = session.beginTransaction();
			// 鎵ц璇锋眰澶勭悊閾�
			arg2.doFilter(arg0, arg1);
			// 杩斿洖鍝嶅簲鏃讹紝鎻愪氦浜嬪姟
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 鍏抽棴session
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		Common c = new Common();
	}

}
