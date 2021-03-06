package com.learnyeai.auth;

import org.jsets.jdbc.config.EnableJsetsJdbc;
import org.jsets.shiro.config.EnableJsetsShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableJsetsJdbc
@EnableJsetsShiro
@EnableCaching
@EnableEurekaClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
