package com.learnyeai.servicebase.conf;

import com.learnyeai.learnai.web.filter.SessionFilter;
import com.learnyeai.learnai.web.filter.ThreadContextFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/4/18.
 */
@Configuration
public class FilterConfig {
    @Value("${filter.session.exclude}")
    private String session_exclude;
    @Value("${filter.thread.context.loginUrl}")
    private String thread_context_loginUrl;
    @Bean
    public FilterRegistrationBean sessionFilterRegistration() {
        SessionFilter sessionFilter = new SessionFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(sessionFilter);
        registration.setOrder(2);
        registration.addUrlPatterns("*.do");
        registration.addInitParameter("exclude", session_exclude);
        return registration;
    }
    @Bean
    public FilterRegistrationBean threadContextFilterRegistration() {
        ThreadContextFilter threadContextFilter = new ThreadContextFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(threadContextFilter);
        registration.setOrder(1);
        registration.addUrlPatterns("*.do");
        registration.addInitParameter("loginUrls", thread_context_loginUrl);
        return registration;
    }

    /*@Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new IndexServlet());
        registration.addUrlMappings("/hello");
        return registration;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new IndexListener());
        return servletListenerRegistrationBean;
    }*/
}
