package cn.com.weyeyun.rabbitmq.task;

import cn.com.weyeyun.quartz.DetailQuartzJobBean;
//import cn.com.weyeyun.rabbitmq.service.SaveMsgQueService;
import cn.com.weyeyun.rabbitmq.model.RabMsgTempTable;
import cn.com.weyeyun.rabbitmq.service.RabMsgTempTableWyService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yl on 2018/6/29.
 */
@Component("saveMsgQueTask")
public class SaveMsgQueTask {
    @Autowired
    private Scheduler scheduler;
    @Value("${cacheKey}")
    private String cacheKey;
    @Autowired
    private RabMsgTempTableWyService rabMsgTempTableWyService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void init(){
        JobDetailFactoryBean jd = new JobDetailFactoryBean();
        jd.setGroup("jobDataAsMap");
        jd.setName("view");
        jd.setDurability(true);
        jd.setRequestsRecovery(true);
        jd.setJobClass(DetailQuartzJobBean.class);
        Map<String, Object> pp = new HashMap();
        pp.put("targetObject", "saveMsgQueTask");
        pp.put("targetMethod", "saveMsgQue");
        pp.put("concurrent", false);

        jd.setJobDataAsMap(pp);
        jd.afterPropertiesSet();

        // 10s执行一次
//        String cronExpression = "0 0/10 * * * ?";
        String cronExpression = "0/10 * * * * ?";
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("saveMsgQueTrigger", "view")
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(jd.getObject(), trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("创建定时任务失败-重新处理消息",e);
        }
    }
    public void saveMsgQue(JobExecutionContext context){
        Set<String> serverkeys = redisTemplate.keys(cacheKey);
//        int i=serverkeys.size();
        ArrayList<Object> listKey = new ArrayList();
        //将消息插入到本地数据库中
        rabMsgTempTableWyService.saveMessage(serverkeys);
        logger.info("共插入"+serverkeys.size()+"条数据");
    }
}
