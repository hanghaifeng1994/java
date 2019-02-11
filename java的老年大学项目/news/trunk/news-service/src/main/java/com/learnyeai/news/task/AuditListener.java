package com.learnyeai.news.task;

import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.news.model.NewsArticle;
import com.learnyeai.news.service.NewsArticleWyService;
import com.learnyeai.tools.common.JsonUtils;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Set;

@Component("auditListener")
public class AuditListener {
    @Value("${serviceType}")
    private String serviceType;
    @Autowired
    @Qualifier(value="redisTemplateMq")
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    NewsArticleWyService newsArticleWyService;
    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(AuditListener.class);
    @Transactional
    public void updateAuditStatus(JobExecutionContext context){
            //获取所有的redis中处理后的所有id
        Set<Object> cachkeys=redisTemplate.opsForHash().keys(serviceType);
        Iterator<Object> iterator = cachkeys.iterator();
        NewsArticle news=new NewsArticle();
        int count=0;
        while (iterator.hasNext()){
            String auditId=(String) iterator.next();
            String jstr=  (String) redisTemplate.opsForHash().get(serviceType,auditId);
            AuditlogMq obj=JsonUtils.jsonToObject(jstr,AuditlogMq.class);
            news.setArticleId(obj.getObjId());
            news.setAuditId(auditId);
            count+= newsArticleWyService.save(news);
            //操作成功后删除缓存数据
            redisTemplate.opsForHash().delete(serviceType,auditId);
        }
        Logger.info("共更新新闻{}条数据",count);

    }

}
