package cn.com.weyeyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

//@EnableWebMvc
//@ServletComponentScan
//@MapperScan(basePackages = "cn.com.weyeyun", annotationClass = cn.com.weyeyun.servicebase.support.MyBatisDao.class)
//@EnableFeignClients
//@EnableEurekaClient
//@EnableCaching

@SpringBootApplication
@EnableCaching
/*@EntityScan(basePackages = "cn.com.weyeyun.commoncert.model")
*/
//@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class BaseServerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}


	public void run(String... args) throws Exception {
		logger.info("服务启动完成!");
	}
}
