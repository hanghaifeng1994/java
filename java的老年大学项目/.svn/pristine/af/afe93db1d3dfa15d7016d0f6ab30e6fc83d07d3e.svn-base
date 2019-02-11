package com.learnyeai.lifelongedu.gateway.config;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.lifelongedu.gateway.util.LearnAiGateWayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zpz on 2018/8/16.
 */
@EnableConfigurationProperties(LearnAiGateWayProperties.class)
@Configuration
public class BeanConfig {
    @Bean
    public SpringContextUtils springContextUtils(ApplicationContext parentContext){
        SpringContextUtils utils = new SpringContextUtils();
        utils.setApplicationContext(parentContext);
        return utils;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
