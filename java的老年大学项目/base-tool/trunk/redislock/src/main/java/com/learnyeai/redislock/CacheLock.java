package com.learnyeai.redislock;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {
	String lockedPrefix() default "";//redis 锁key的前缀
	long timeOut() default 2000;//锁时间,单位:微秒，在timeout的时间范围内不断轮询锁，时间不能设置太大
	int expireTime() default 10000;//key在redis里存在的时间，单位秒
}
