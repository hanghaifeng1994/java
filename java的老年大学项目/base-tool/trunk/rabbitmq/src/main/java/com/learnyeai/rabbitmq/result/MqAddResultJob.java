package com.learnyeai.rabbitmq.result;

import com.learnyeai.quartz.DetailQuartzJobBean;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/6/25.
 */
@Component
public class MqAddResultJob {

    @Autowired
    private Scheduler scheduler;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void init(){
        JobDetailFactoryBean jd = new JobDetailFactoryBean();
        jd.setGroup("mq");
        jd.setName("MqResultDealJob");
        jd.setDurability(true);
        jd.setRequestsRecovery(true);
        jd.setJobClass(DetailQuartzJobBean.class);
        Map<String, Object> pp = new HashMap();
        pp.put("targetObject", "mqResultTask");
        pp.put("targetMethod", "reDoAll");
        pp.put("concurrent", false);

        jd.setJobDataAsMap(pp);
        jd.afterPropertiesSet();

        // 10分钟执行一次
        String cronExpression = "0 1/10 * * * ?";
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("MqResultDealJobTrigger", "mq")
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(jd.getObject(), trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("创建定时任务失败-重新处理消息",e);
        }
    }
}
