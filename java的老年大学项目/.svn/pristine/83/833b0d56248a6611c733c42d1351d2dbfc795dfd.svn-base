package com.learnyeai.servicebase.conf;

import com.learnyeai.servicebase.SpringDispatcherServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by zpz on 2018/4/10.
 */
@Order(1)
@Configuration
public class DispatcherServletConfig {
    @Autowired
    private SpringDispatcherServlet springDispatcherServlet;

    @Bean("dispatcherServlet")
    public DispatcherServlet myDS(ApplicationContext parentContext) {
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        applicationContext.setParent(parentContext);
        //base package
        applicationContext.scan("cn.com.weyeyun");
//        applicationContext.register(WebMvcConfig.class);
        //通过构造函数指定dispatcherServlet的上下文
        /*DispatcherServlet rest_dispatcherServlet
                = new SpringDispatcherServlet(applicationContext);*/
//        return rest_dispatcherServlet;

        springDispatcherServlet.setApplicationContext(applicationContext);
        return springDispatcherServlet;
    }
    @Bean
    public ServletRegistrationBean restServlet(DispatcherServlet dispatcherServlet){

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
//        registrationBean.addUrlMappings("/rest/*");
        //指定name，如果不指定默认为dispatcherServlet
//        registrationBean.setName("rest");
        return registrationBean;
    }


    /*@Bean
    public ServletRegistrationBean restServlet(ApplicationContext parentContext){
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        applicationContext.setParent(parentContext);
        //base package
        applicationContext.scan("cn.com.weyeyun");
        applicationContext.register(WebMvcConfig.class);
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet rest_dispatcherServlet
                = new SpringDispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
//        registrationBean.addUrlMappings("/rest*//*");
        //指定name，如果不指定默认为dispatcherServlet
//        registrationBean.setName("rest");
        return registrationBean;
    }*/
}
