package cn.com.weyeyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableWebMvc
@ServletComponentScan
@MapperScan(basePackages = "cn.com.weyeyun", annotationClass = cn.com.weyeyun.servicebase.support.MyBatisDao.class)
//@EnableFeignClients
@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class BaseServerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("服务启动完成!");
	}
}
