package com.learnyeai.servicebase.conf;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zpz on 2018/6/22.
 */
@Configuration
public class ShutdownConfig {
/*

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

application.properties 添加下面配置
#访问路径，配置后就和1.x版本路径一样 http://127.0.0.1:8080/shutdown
management.endpoints.web.base-path=/
# 暴露所有，也可以暴露单个或多个
management.endpoints.web.exposure.include=*
# 开启shutdown
management.endpoint.shutdown.enabled=true
     */
    /**
     * 用于接受shutdown事件
     * @return
     */
//    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdown());
        return tomcat;
    }
    private static class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
        private static final Logger log = LoggerFactory.getLogger(GracefulShutdown.class);
        private volatile Connector connector;
        private final int waitTime = 120;
        @Override
        public void customize(Connector connector) {
            this.connector = connector;
        }
        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            this.connector.pause();
            Executor executor = this.connector.getProtocolHandler().getExecutor();
            if (executor instanceof ThreadPoolExecutor) {
                try {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                    log.info("shutdown start");
                    threadPoolExecutor.shutdown();
                    log.info("shutdown end");
                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                        log.info("Tomcat 进程在" + waitTime + "秒内无法结束，尝试强制结束");
                    }
                    log.info("shutdown success");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}