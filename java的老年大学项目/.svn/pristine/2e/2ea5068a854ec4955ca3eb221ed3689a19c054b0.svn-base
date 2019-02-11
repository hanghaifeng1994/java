package com.learnyeai.core.utils;

import com.learnyeai.tools.common.FileUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.InputStream;

/**
 * SpringContext工具类
 */
public class SpringContextUtils{

    private static ApplicationContext applicationContext;
    private static final byte[] lock = new byte[0];

    private static Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        if(null != applicationContext) {
            return applicationContext;
        }
        return applicationContext;
    }

    /**
     * 通过Bean的名称得到bean
     * @param name bean名称
     * @param requiredType bean类型
     * @param <T> bean类型
     * @return bean
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        try{
            return getApplicationContext().getBean(name, requiredType);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     *
     * @param requiredType bean类型
     * @param <T> bean类型
     * @return bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        try{
            return getApplicationContext().getBean(requiredType);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
    public static <T> T getBean(String beanId){
        try{
            return (T)getApplicationContext().getBean(beanId);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
    /**
     * 获取系统文件
     *
     * @param location
     * @return
     */
    public static InputStream loadResource(String location) {
        try {
            Resource res = null;
            res = SpringContextUtils.getApplicationContext().getResource(location);
            return res.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取系统文件
     *
     * @param location
     * @return
     */
    public static String loadUtf8Resouce(String location) {
        InputStream ioStream = loadResource(location);
        try {
            String temp = FileUtil.readFileAsString(ioStream);
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(ioStream);
        }

        return "";
    }
}
