package com.learnyeai.servicebase.conf;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.servicebase.convert.JsonHttpMessageConverter;
import com.learnyeai.learnai.session.dao.CacheSessionDao;
import com.learnyeai.learnai.session.dao.SessionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.util.List;

/**
 * Created by zpz on 2018/4/16.
 */
@Configuration
public class WebMvcConfigAdapter extends WebMvcConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/content/**").addResourceLocations("classpath:/web/");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new JsonHttpMessageConverter());
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){

        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置上传的文件大小上限，如果超出限制，就会抛出异常信息
        factory.setMaxFileSize("128KB");
        //设置一次总上传数据的大小，用于多文件上传设置
        factory.setMaxRequestSize("256KB");
        return factory.createMultipartConfig();
    }

    @Bean
    public MessageSource messageSource() {
        logger.info("MessageSource");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("classpath:META-INF/messages/base-messages","classpath:META-INF/messages/messages");
//        messageSource.setBasename("config.messages.messages");

        return messageSource;
    }

    @Bean
    public SpringContextUtils springContextUtils(ApplicationContext parentContext){
        SpringContextUtils utils = new SpringContextUtils();
        utils.setApplicationContext(parentContext);
        return utils;
    }

    @Bean
    public SessionDao sessionDao(){
        return new CacheSessionDao();
    }


}
