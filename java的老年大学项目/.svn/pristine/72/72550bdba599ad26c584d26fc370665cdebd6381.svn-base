package com.learnyeai.interact.service;

import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.model.ItaCustExt;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.model.ItaShare;
import com.learnyeai.interact.mapper.ItaShareMapper;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class ItaShareWyService extends WeyeBaseService<ItaShare> {

    @Resource
    private ItaShareMapper itaShareMapper;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public BaseMapper<ItaShare> getMapper() {
        return itaShareMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    public void saveData(ItaShare is){
        String userId=is.getCustId();
        String objId=is.getObjId();
        String type=is.getServiceType();
        super.save(is);
        //查询用户统计表中是否存在数据
        String cachCust=cachName+"cust";
        String cachTmp=cachName+"custtmp";
        String cachTimes=cachName+"times";
        String cachTimesTmp=cachName+"timestmp";
        RedisUtil redisCust=RedisUtilFactory.getUtil(cachCust,ItaCustExt.class);
        RedisUtil redisCustTmp=RedisUtilFactory.getUtil(cachTmp,ItaCustExt.class);
        RedisUtil redisTimes=RedisUtilFactory.getUtil(cachTimes,ItaInteractionTimes.class);
        RedisUtil redisTimesTmp=RedisUtilFactory.getUtil(cachTimesTmp,ItaInteractionTimes.class);
        boolean flag1=redisCust.exists(userId);
        ItaCustExt  itCach=new ItaCustExt();
        if(flag1){
            itCach= redisCust.get(userId);
            redisCust.remove(userId);
            redisCustTmp.remove(userId);
        }
        itCach.setCustId(userId);
        itCach.setMchtId(WeyeThreadContextUtils.getMerchantId());
        itCach.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        redisCust.set(userId,itCach);
        redisCustTmp.set(userId,itCach);

        //定义对象统计缓存
        //持久存在缓存
        String cachTimesKey=cachName+"timesPer"+type;
//        临时缓存
        String cachTimesTmpKey=cachName+"timesTmp"+type;
        //统计对象数据信息
        boolean flag2=redisTemplate.opsForHash().hasKey(cachTimesKey,objId);
        Integer shareNum;
        ItaInteractionTimes times=new ItaInteractionTimes();
        if(flag2){
            times=(ItaInteractionTimes) redisTemplate.opsForHash().get(type,objId);
            shareNum= times.getShareNum();
            if(shareNum==null){
                shareNum=1;
            }
            shareNum = shareNum+1;
        }else{
            shareNum=1;
        }
        String id=KeyFactory.getKeyGenerator("interact" + "ita_interaction_times").genNextKey();
        times.setObjId(objId);
        times.setTmId(id);
        times.setFavNum(shareNum);
        times.setType(type);
        times.setMchtId(WeyeThreadContextUtils.getMerchantId());
        times.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        //        将数据存入临时缓存中
        redisTemplate.opsForHash().put(cachTimesTmpKey,objId,times);
//        将数据存入持久缓存中
        redisTemplate.opsForHash().put(cachTimesKey,objId,times);
    }
}
