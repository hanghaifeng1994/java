package com.learnyeai.interact.service;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.mapper.ItaInteractionTimesMapper;
import com.learnyeai.interact.model.ItaInteractionTimesExt;
import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class ItaInteractionTimesWyService extends WeyeBaseService<ItaInteractionTimes> {

    @Resource
    private ItaInteractionTimesMapper itaInteractionTimesMapper;
    @Autowired
    private ItaCollectionWyService itaCollectionWyService;

    @Autowired
    private ItaLikedWyService itaLikedWyService;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public BaseMapper<ItaInteractionTimes> getMapper() {
        return itaInteractionTimesMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ItaInteractionTimes t, Map params) {
        Weekend w=  super.genSqlExample(t,null);
        Weekend week=new Weekend(this.getEntityClass());
        WeekendCriteria<ItaInteractionTimes,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getObjId())){
            String[] obj=(t.getObjId()).split(",");
            c.andIn(ItaInteractionTimes::getObjId,Arrays.asList(obj));
        }
        if(StringUtils.isNotBlank(t.getType())){
            c.andEqualTo(ItaInteractionTimes::getType,t.getType());
        }
        if(t.getList()!=null){
            List<ItaInteractionTimes> list=t.getList();
            for (ItaInteractionTimes i:list){
                WeekendCriteria<ItaInteractionTimes,Object> criteria=week.weekendCriteria();
                criteria.andEqualTo(ItaInteractionTimes::getObjId,i.getObjId());
                criteria.andEqualTo(ItaInteractionTimes::getType,i.getType());
                w.or(criteria);
            }
        }
        w.and(c);
        return w;
    }
    public ItaInteractionTimesExt queryByObjIdExt(ItaInteractionTimes itaInteractionTimes){
        ItaInteractionTimesExt ita=new ItaInteractionTimesExt();
        String objId=itaInteractionTimes.getObjId();
        String userId=currentUserInfoIml.getId();
        ItaLiked liked=new ItaLiked();
        liked.setObjId(objId);
        liked.setCreateBy(userId);
        ItaCollection collection=new ItaCollection();
        collection.setCreateBy(userId);
        collection.setObjId(objId);
        List<ItaLiked> likeds=itaLikedWyService.queryList(liked,new HashMap());
        List<ItaCollection> collections=itaCollectionWyService.queryList(collection,new HashMap());
        if(collections.size()>0){
            ita.setIsCollStatus("1");
        }else{
            ita.setIsCollStatus("0");
        }
        if(likeds.size()>0){
            ita.setIsLikeStatus("1");
            ita.setIsLikeStatus("0");
        }
        return ita;
    }

    /**
     * 对象互动数据
     * @param ctx
     * @return
     */
    public List<ItaInteractionTimes> queryPageData(IBusinessContext ctx){
        ItaInteractionTimes ita= super.convert2Bean(ctx.getParamMap());
        List<ItaInteractionTimes> list=ita.getList();
        List<ItaInteractionTimes> result=new ArrayList<>();
        for (ItaInteractionTimes times:list){
            String objid=times.getObjId();
            String type=times.getType();
            String cachTimes=cachName+"timesPer"+type;
           boolean flag =redisTemplate.opsForHash().hasKey(cachTimes,objid);
           if(flag){
               times= (ItaInteractionTimes) redisTemplate.opsForHash().get(cachTimes,objid);
               result.add(times);
           }else{
               List<ItaInteractionTimes> timess=  super.queryList(times,new HashMap());
               if(timess.size()>0){
                   result.add(timess.get(0));
               }else{
                   result.add(times);
               }
           }
        }
        return result;
    }

    public void addReadTimes(IBusinessContext ctx){
        ItaInteractionTimes times= super.convert2Bean(ctx.getParamMap());
        String type =times.getType();
        String objId=times.getObjId();
        //将数据存入缓存中
        String cachTimesKey=cachName+"timesPer"+type;
        String cachTimesTmpKey=cachName+"timesTmp"+type;
        RedisUtil redisUtil= RedisUtilFactory.getUtil(cachTimesKey,ItaInteractionTimes.class);
        RedisTemplate<String,Object> template=redisUtil.getRedisTemplate();
        RedisUtil redisUtilTmp= RedisUtilFactory.getUtil(cachTimesTmpKey,ItaInteractionTimes.class);
        RedisTemplate<String,Object> templateTmp=redisUtilTmp.getRedisTemplate();
        //        template.opsForHash().put(cachTimesKey,objId,times);
        //统计对象数据信息
        boolean flag=template.opsForHash().hasKey(cachTimesKey,objId);
        if(flag){
            //获取到访问量次数
            times= (ItaInteractionTimes) template.opsForHash().get(cachTimesKey,objId);
            Integer i=times.getBrowseNum();
            if(i==null){
                i=1;
            }else{
               i++;
            }
            times.setBrowseNum(i);
        }else{
            times.setBrowseNum(1);
        }
        String id=KeyFactory.getKeyGenerator("interact" + "ita_interaction_times").genNextKey();
        times.setTmId(id);
        template.opsForHash().put(cachTimesKey,objId,times);
        templateTmp.opsForHash().put(cachTimesTmpKey,objId,times);
    }

}
