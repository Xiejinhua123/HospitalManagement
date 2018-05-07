package com.accp.test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class SessionListenter
 *
 */
@WebListener
public class SessionListenter implements HttpSessionListener{

	Logger logger = Logger.getLogger(SessionListenter.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.error("session被创建");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.error("session销毁");
	}
}
