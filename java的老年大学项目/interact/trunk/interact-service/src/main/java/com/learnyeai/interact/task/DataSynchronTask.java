package com.learnyeai.interact.task;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.mapper.ItaCustExtBatchMapper;
import com.learnyeai.interact.mapper.ItaInteractionTimesBatchMapper;
import com.learnyeai.interact.mapper.ItaLikedBatchMapper;
import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.model.ItaCustExt;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component("dataSynchronTask")
public class DataSynchronTask {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 定时同步用户数据统计
     * @param context
     */
    @Transactional
    public void saveCustData(JobExecutionContext context) {
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ItaCustExtBatchMapper mapper = session.getMapper(ItaCustExtBatchMapper.class);
        //通过缓存获取数据
        String tmpCach=cachName+"custtmp";
        RedisUtil redisTmp=RedisUtilFactory.getUtil(tmpCach,ItaCustExt.class);
        RedisTemplate<String,Object> redisTemplate=redisTmp.getRedisTemplate();
//        redisTemplate.opsForHash().keys()
        List<ItaCustExt>  list = redisTmp.getAll();
        for(ItaCustExt ice:list){
            mapper.deleteCustByPrimaryKey(ice.getCustId());
            mapper.insertCustSelective(ice);
            //新增之后删除临时数据
            redisTmp.remove(tmpCach,ice.getCustId());
            //修改互动信息统计缓存内容
            session.commit();
        }
        session.close();
    }

    /**
     * 定时同步对象统计表
     * @param context
     */
    @Transactional
    public void saveTimesData(JobExecutionContext context) {
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ItaInteractionTimesBatchMapper mapper = session.getMapper(ItaInteractionTimesBatchMapper.class);
        //通过缓存获取数据
        //持久存在缓存
        String cachTimesKey=cachName+"timesPer*";
//        临时缓存
        String cachTimesTmpKey=cachName+"timesTmp*";
        //操作临时缓存
        //通过缓存获取数据
        Set<String> l=redisTemplate.keys(cachTimesTmpKey);
        Iterator it=l.iterator();
        while (it.hasNext()){
            String redisKey= (String) it.next();
            Set<Object> keys= redisTemplate.opsForHash().keys(redisKey);
            Iterator keyIter=keys.iterator();
            List<Object> list=redisTemplate.opsForHash().multiGet(redisKey,keys);
            for (Object obj:list){
                ItaInteractionTimes ita=(ItaInteractionTimes)obj;
                mapper.deleteByObjIdAndType(ita);
                mapper.saveData(ita);
                session.commit();
                redisTemplate.opsForHash().delete(redisKey,ita.getObjId());
            }
        }
        session.close();
    }
}
