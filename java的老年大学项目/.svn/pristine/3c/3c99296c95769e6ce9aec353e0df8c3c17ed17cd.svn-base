package com.learnyeai.servicebase.conf;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 会覆盖掉原来的resource配置
 * @author liuzh
 * @since 2015-12-19 16:16
 */
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/content/**").addResourceLocations("classpath:/web/");
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0);
        super.configureMessageConverters(converters);
    }
}
