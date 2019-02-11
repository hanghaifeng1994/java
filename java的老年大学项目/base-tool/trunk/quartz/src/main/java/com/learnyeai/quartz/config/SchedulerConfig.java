package com.learnyeai.quartz.config;

import com.learnyeai.core.utils.SpringContextUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@Configuration
public class SchedulerConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean(name="SchedulerFactory")
    @Lazy
    public SchedulerFactoryBean schedulerFactoryBean(SpringContextUtils springContextUtils) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        factory.setSchedulerName(applicationName);
        factory.setOverwriteExistingJobs(true);

        factory.setAutoStartup(true);
        factory.setStartupDelay(2);
        factory.setApplicationContextSchedulerContextKey("applicationContext");

        Map<String, CronTrigger> l1 = SpringContextUtils.getApplicationContext().getBeansOfType(CronTrigger.class);
        Map<String, SimpleTrigger> l2 = SpringContextUtils.getApplicationContext().getBeansOfType(SimpleTrigger.class);

        if(l1.size() > 0 || l2.size() > 0) {
            Trigger trigger[] = new Trigger[l1.size() + l2.size()];
            int idx = 0;
            for(Iterator<CronTrigger> it = l1.values().iterator(); it.hasNext();){
                trigger[idx++] = it.next();
            }
            for(Iterator<SimpleTrigger> it = l2.values().iterator(); it.hasNext();){
                trigger[idx++] = it.next();
            }
            factory.setTriggers(trigger);
        }
        return factory;
    }

    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
  
    /*
     * quartz初始化监听器
     *  注SchedulerFactoryBean实现了SmartLifecycle
     *  会对quartz作相应的初始化和stop // zhangpeizhong 20180622
     */
    /*@Bean
    public QuartzInitializerListener executorListener() {
       return new QuartzInitializerListener();
    }*/

    /*@Bean
    public ServletListenerRegistrationBean serssionListenerBean(){
        ServletListenerRegistrationBean
                sessionListener = new ServletListenerRegistrationBean(new QuartzInitializerListener());
        return sessionListener;
    }*/
    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws IOException {
        return schedulerFactoryBean.getScheduler();
//        return schedulerFactoryBean().getScheduler();
    }

}
