package com.learnyeai.common.redis;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 因为使用纯json格式，不包含类型信息，所以重写缓存
 * 主要是重写拦截器 MyProxyCachingConfiguration
 * 升级springcloud版本时注意，版本变化，作相应调整
 * Created by zpz on 2018/8/9.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MyCachingConfigurationSelector.class})
public @interface MyEnableCaching {
    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

    int order() default 2147483647;
}