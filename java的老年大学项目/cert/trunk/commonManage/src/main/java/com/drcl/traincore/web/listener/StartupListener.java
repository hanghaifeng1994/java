package com.drcl.traincore.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent event) {
	}

	/**
	 * 没有web应用启动后将就的用户服务中记录的容器对应的session清除，修正在线用户数量
	 */
	public void contextInitialized(ServletContextEvent event) {
	}

}