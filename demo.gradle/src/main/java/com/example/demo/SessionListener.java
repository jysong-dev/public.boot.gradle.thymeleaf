package com.example.demo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.demo.domain.LogVO;
import com.example.demo.service.LogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener, HttpSessionAttributeListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		session.setAttribute("remoteAddr", req.getRemoteAddr());
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
		LOGGER.debug("Session Created! : " + session.getId());
		LogService logService = (LogService)context.getBean("logService");

		try {
			String agent = req.getHeader("user-agent");
			String referer = req.getHeader("referer");
			LogVO logVO = new LogVO();

			logVO.setSessionId(session.getId());
			logVO.setLogSeCode("CONNECT");
			logVO.setUserAgent(agent);
			logVO.setReferer(referer);
			logVO.setRequesterIp(req.getRemoteAddr());
			
			logService.insertLog(logVO);
			
		} catch (Exception e) {
			LOGGER.error("Exception : " + e);
		}
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		
		HttpSession session = se.getSession();
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		session.setAttribute("remoteAddr", req.getRemoteAddr());
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
		LOGGER.debug("Session Created! : " + session.getId());
		LogService logService = (LogService)context.getBean("logService");

		try {
			String agent = req.getHeader("user-agent");
			String referer = req.getHeader("referer");
			LogVO logVO = new LogVO();

			logVO.setSessionId(session.getId());
			logVO.setLogSeCode("CONNECT");
			logVO.setUserAgent(agent);
			logVO.setReferer(referer);
			logVO.setRequesterIp(req.getRemoteAddr());
			
			logService.insertLog(logVO);
			
		} catch (Exception e) {
			LOGGER.error("Exception : " + e);
		}

	}

}
