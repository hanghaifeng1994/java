package com.learnyeai.resultbill.consumer;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.rabbitmq.util.DeadQueueDefine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/6/13.
 */
@Configuration
public class ResultBillConfig {
    @Bean
    public SpringContextUtils springContextUtils(ApplicationContext parentContext){
        SpringContextUtils utils = new SpringContextUtils();
        utils.setApplicationContext(parentContext);
        return utils;
    }
    @Bean
    public DeadQueueDefine getDeadQueueDefine(){
        return new DeadQueueDefine() {
            @Override
            public String getExchange() {
                return "resultbill.dxexchange";
            }

            @Override
            public String getqQueue() {
                return "resultbill.dxqueue";
            }

            @Override
            public String getKey() {
                return "resultbill.dx";
            }
        };
    }
}
