package com.learnyeai.interact.task;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.mapper.ItaCollectionBatchMapper;
import com.learnyeai.interact.mapper.ItaLikedBatchMapper;
import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.key.KeyGenerator;
import com.learnyeai.learnai.key.uuid.UUIDKeyGenerator;
import com.learnyeai.tools.common.JsonUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component("CollectIntInfoTask")
public class CollectIntInfoTask {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 定时新增
     * @param context
     */
    @Transactional
    public void saveInteractData(JobExecutionContext context) {
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ItaCollectionBatchMapper mapper = session.getMapper(ItaCollectionBatchMapper.class);
        String key=cachName+"collect*";
        //通过缓存获取数据
        Set<String> l=redisTemplate.keys(key);
        Iterator it=l.iterator();
        while (it.hasNext()){
            String redisKey= (String) it.next();
            Set<Object> keys= redisTemplate.opsForHash().keys(redisKey);
            Iterator keyIter=keys.iterator();
                List<Object> list=redisTemplate.opsForHash().multiGet(redisKey,keys);
                for (Object obj:list){
                    ItaCollection collection=(ItaCollection)obj;
                    if("2".equals(collection.getCltStatus())){
                        mapper.delbatch(collection);
                    }else{
                        mapper.delbatch(collection);
                        mapper.saveBatch(collection);
                    }
                    session.commit();
                    redisTemplate.opsForHash().delete(redisKey,((ItaCollection) obj).getObjId());
                }
        }
        session.close();
    }

}
