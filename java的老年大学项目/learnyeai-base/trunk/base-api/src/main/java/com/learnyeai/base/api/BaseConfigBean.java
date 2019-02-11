package com.learnyeai.base.api;

import com.learnyeai.base.api.bean.ClientBaseInfoDaoImpl;
import com.learnyeai.base.api.bean.ClientBaseInfoGet;
import com.learnyeai.base.api.bean.ClientThreadStart;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.common.engine.ILearnAiThreadStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/8/4.
 */
@Configuration
public class BaseConfigBean {
    @Autowired
    private ClientBaseInfoGet clientBaseInfo;

    @Bean
    @ConditionalOnMissingBean(value = ILearnAiThreadStart.class)
    public ClientThreadStart getCommonThreadStart(){
        return new ClientThreadStart(clientBaseInfo);
    }
    @Bean
    @ConditionalOnMissingBean(value = BaseInfoDao.class)
    public BaseInfoDao getBaseInfoDao(){
        return new ClientBaseInfoDaoImpl(clientBaseInfo);
    }
}
