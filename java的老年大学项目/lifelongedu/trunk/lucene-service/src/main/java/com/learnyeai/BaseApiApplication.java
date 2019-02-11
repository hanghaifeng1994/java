package com.learnyeai;

import com.learnyeai.common.redis.MyEnableCaching;
import com.learnyeai.learnai.support.MyBatisDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableWebMvc
@ServletComponentScan
@MapperScan(basePackages = "com.learnyeai", annotationClass = MyBatisDao.class)
@EnableEurekaClient
@EnableFeignClients
@MyEnableCaching
//@EnableCaching
@SpringBootApplication
public class BaseApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BaseApiApplication.class, args);
//		SpringContextUtils.setApplicationContext(ctx);
	}
}
