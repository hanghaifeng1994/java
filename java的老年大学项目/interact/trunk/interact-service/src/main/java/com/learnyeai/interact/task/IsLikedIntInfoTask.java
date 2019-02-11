package com.learnyeai.interact.task;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.mapper.ItaLikedBatchMapper;
import com.learnyeai.interact.model.IsItaLiked;
import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.interact.service.ItaLikedWyService;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.MyPage;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component("IsLikedIntInfoTask")
public class IsLikedIntInfoTask {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Resource
    private ItaLikedWyService itaLikedWyService;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 定时处理点赞
     * @param context
     */
    @Transactional
    public void saveLikeData(JobExecutionContext context) {
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ItaLikedBatchMapper mapper = session.getMapper(ItaLikedBatchMapper.class);
        //通过缓存获取数据
        String key=cachName+"IslikeTmp*";
        //通过缓存获取数据
        Set<String> l=redisTemplate.keys(key);
        Iterator it=l.iterator();
        while(it.hasNext()){
            String redisKey= (String) it.next();
            Set<Object> keys= redisTemplate.opsForHash().keys(redisKey);
            Iterator keyIter=keys.iterator();
            List<Object> list=redisTemplate.opsForHash().multiGet(redisKey,keys);
            ItaLiked lk=new ItaLiked();
            for (Object obj:list){
                ItaLiked liked=(ItaLiked)obj;
                lk.setObjId(liked.getObjId());
                lk.setType(liked.getType());
               MyPage<ItaLiked> page= itaLikedWyService.queryPage(lk,new HashMap());
               if((page.getList()).size()==0){
                   mapper.saveBatch(liked);
               }else{
                   mapper.updateBatch(liked);
               }

                session.commit();
                redisTemplate.opsForHash().delete(redisKey,liked.getObjId());
            }
        }
        session.close();
    }
}
