package com.learnyeai.servicebase.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zpz on 2018/4/18.
 */
@Configuration
@ImportResource(locations = {"classpath*:META-INF/spring/*-context.xml"})
public class SpringBeanConfig {

}
