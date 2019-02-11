package com.learnyeai.servicebase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public abstract class SpringDispatcherServlet extends DispatcherServlet {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public SpringDispatcherServlet() {
	}

	public SpringDispatcherServlet(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		myIni();
		super.init(config);
	}
	
	protected void doService(HttpServletRequest request,
			HttpServletResponse response) {
		long begin = new Date().getTime();
		String url = request.getRequestURL().toString();
		logger.debug("{} start", url);
		try {
			myDoBefore(request, response);
			super.doService(request, response);
			myDoAfter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = new Date().getTime();
		logger.debug("times: {} ms，end {} ", (end - begin), url);
	}
	protected abstract void myIni();
	protected void myDoBefore(HttpServletRequest request, HttpServletResponse response){

	}
	protected void myDoAfter(HttpServletRequest request, HttpServletResponse response){

	}
}
