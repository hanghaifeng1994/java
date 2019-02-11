package com.learnyeai.learnai.config;

import com.learnyeai.learnai.support.CurrentUserInfoDao;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/8/4.
 */
@EnableConfigurationProperties(LearnAiProperties.class)
@Configuration
public class LearnaiBeanConfig {

    @Bean
    @ConditionalOnMissingBean(value = CurrentUserInfoDao.class)
    CurrentUserInfoIml getCurrentUserInfoIml(){
        return new CurrentUserInfoIml();
    }

    /*@Bean(name = "batchSqlSessionTemplate")
    SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
        return sqlSessionTemplate;
    }*/
}
