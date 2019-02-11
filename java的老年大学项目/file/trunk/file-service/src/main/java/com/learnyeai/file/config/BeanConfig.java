package com.learnyeai.file.config;

import com.learnyeai.file.filter.ServiceFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

/**
 * Created by zpz on 2018/8/30.
 */
@Configuration
public class BeanConfig {

    /*@Bean
    public MultipartConfigElement multipartConfigElement(){

        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置上传的文件大小上限，如果超出限制，就会抛出异常信息
        Long size = 1l*1024*1024*1024;
        factory.setMaxFileSize(size.toString());
        //设置一次总上传数据的大小，用于多文件上传设置
        factory.setMaxRequestSize(size.toString());
        return factory.createMultipartConfig();
    }*/

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常

        Long size = 1l*1024*1024*1024;

        resolver.setMaxInMemorySize(10*1024*1024);
        resolver.setMaxUploadSize(size);
//        resolver.setUploadTempDir(fileTemDir);
        return resolver;
    }

    @Bean
    public FilterRegistrationBean threadContextFilterRegistration() {
        ServiceFilter threadContextFilter = new ServiceFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(threadContextFilter);
        registration.setOrder(1);
        registration.addUrlPatterns("*");
        return registration;
    }

}
