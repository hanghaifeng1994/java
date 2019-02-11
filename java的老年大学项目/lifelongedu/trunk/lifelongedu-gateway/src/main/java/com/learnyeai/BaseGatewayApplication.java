package com.learnyeai;

import com.learnyeai.lifelongedu.gateway.util.LearnAiGateWayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.WebUtils;


@ComponentScan
@RestController
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class BaseGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseGatewayApplication.class, args);
	}

	@GetMapping("/test.do")
	public String test(ServerWebExchange exchange){
		ServerHttpRequest request = exchange.getRequest();
		String url = request.getURI().toString();
		return "ok";
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		// 前端必须事先获取token，再请求数据
		// 获取token方式，登录返回token，
		// 如果用户已经登录，把用户id放到请求head中，未登录，生成一个id。
		return builder.routes()
				.route(r -> r.path("/tt")
						/*.filters((aa)->{
							aa.addRequestParameter("", "");
							aa.addRequestHeader("_SESSION_ID_KEY", null);
							aa.addResponseHeader("", "");
							return aa;
						})*/
						.uri("http://localhost:8010/test")
				)
				.build();
	}
}
