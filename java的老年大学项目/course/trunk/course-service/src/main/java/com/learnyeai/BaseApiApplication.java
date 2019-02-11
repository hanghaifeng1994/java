package com.learnyeai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.learnyeai.common.redis.MyEnableCaching;
import com.learnyeai.learnai.support.MyBatisDao;

import tk.mybatis.spring.annotation.MapperScan;

//@EnableWebMvc
@ServletComponentScan
@MapperScan(basePackages = "com.learnyeai", annotationClass = MyBatisDao.class)
@EnableEurekaClient
@EnableFeignClients
@MyEnableCaching
@SpringBootApplication
public class BaseApiApplication  implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BaseApiApplication.class, args);
//		SpringContextUtils.setApplicationContext(ctx);
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info("服务启动完成!");
	}
}
