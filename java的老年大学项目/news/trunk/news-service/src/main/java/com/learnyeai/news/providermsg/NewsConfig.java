package com.learnyeai.news.providermsg;

import com.learnyeai.core.utils.SpringContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/6/13.
 */
@Configuration
public class NewsConfig {
    @Bean
    public SpringContextUtils springContextUtils(ApplicationContext parentContext){
        SpringContextUtils utils = new SpringContextUtils();
        utils.setApplicationContext(parentContext);
        return utils;
    }
}
