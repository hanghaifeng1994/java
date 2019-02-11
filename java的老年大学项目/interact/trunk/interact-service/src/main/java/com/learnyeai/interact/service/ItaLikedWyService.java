package com.learnyeai.interact.service;

import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.mapper.ItaCustExtMapper;
import com.learnyeai.interact.model.*;
import com.learnyeai.interact.mapper.ItaLikedMapper;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.omg.CORBA.Current;
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
public class ItaLikedWyService extends WeyeBaseService<ItaLiked> {

    @Resource
    private ItaLikedMapper itaLikedMapper;
    @Value("${redisPrefix}")
    private String cachName;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;

    @Override
    public BaseMapper<ItaLiked> getMapper() {
        return itaLikedMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ItaLiked t, Map params) {
        Weekend w=super.genSqlExample(t);
        Weekend week=new Weekend(this.getEntityClass());
        WeekendCriteria<ItaLiked,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getObjId())){
            c.andEqualTo(ItaLiked::getObjId,t.getObjId());
        }
        if(StringUtils.isNotBlank(t.getType())){
            c.andEqualTo(ItaLiked::getType,t.getType());
        }
        if(StringUtils.isNotBlank(t.getCreateBy())){
            c.andEqualTo(ItaLiked::getCreateBy,t.getCreateBy());
        }
        w.and(c);
        return w;
    }

    /**
     * 是否点赞列表
     * @param ctx
     * @return
     */
    public List<ItaLiked> isItaLike(IBusinessContext ctx){
        ItaLiked t= super.convert2Bean(ctx.getParamMap());
        List<ItaLiked> list= t.getList();
        String userId=currentUserInfoIml.getId();
        List<ItaLiked> result =new ArrayList<>();
        for (ItaLiked liked:list){
            String type =liked.getType();
            String objId=liked.getObjId();
           liked.setCreateBy(userId);
           //先判断缓存是否存在
            List<ItaLiked> likeds =new ArrayList<>();
            String cachLikePer=cachName+"IslikePer"+type;
            boolean flag=redisTemplate.opsForHash().hasKey(cachLikePer,objId);
            if(flag){
                liked= (ItaLiked) redisTemplate.opsForHash().get(cachLikePer,objId);
                result.add(liked);
            }else{
                likeds=   super.queryList(liked,new HashMap());
                if(likeds.size()>0){
                    result.add(likeds.get(0));
                }else{
                    liked.setLkStatus("2");
                    result.add(liked);
                }
            }

       }
        return result;
    }

    /**
     * 新增点赞
     * @param ctx
     * @return
     */
    public  Map<String,Object> saveCach(IBusinessContext ctx){
        ItaLiked it =    super.convert2Bean(ctx.getParamMap());
        it.setLkStatus("1");
        String tdUserId=it.getTheUserId();
        String objId=it.getObjId();
        String type=it.getType();
        String userId=currentUserInfoIml.getId();
        String userName=currentUserInfoIml.getLoginName();
        it.setCreateDate(new Date());
        it.setCreateBy(currentUserInfoIml.getId());
        String mchtId = WeyeThreadContextUtils.getMerchantId();
        String mchtSchmId = WeyeThreadContextUtils.getMerchantSchemeId();
        String lkId=KeyFactory.getKeyGenerator("interact" + "ita_isliked").genNextKey();
        it.setMchtId(mchtId);
        it.setLkId(lkId);
        it.setMchtSchmId(mchtSchmId);
        it.setLkUserName(userName);
        String cach=cachName+"IslikePer"+type;
        String cachLikeTmp=cachName+"IslikeTmp"+type;
        String cachCust=cachName+"cust";
        String cachTmp=cachName+"custtmp";
        RedisUtil redisCust=RedisUtilFactory.getUtil(cachCust,ItaCustExt.class);
        RedisUtil redisCustTmp=RedisUtilFactory.getUtil(cachTmp,ItaCustExt.class);
        //将点赞数据存入缓存
        redisTemplate.opsForHash().put(cach,objId,it);
        redisTemplate.opsForHash().put(cachLikeTmp,objId,it);
        //统计用户数据
        //查询缓存中是否存在该用户数据
        boolean flag=redisCust.exists(tdUserId);
        Integer lkNum;
        ItaCustExt  itCach=new ItaCustExt();
        if(flag){
            itCach= redisCust.get(tdUserId);
            lkNum= itCach.getLikedNum();
            if(lkNum==null){
                lkNum=0;
            }
            lkNum = lkNum+1;
            redisCust.remove(tdUserId);
            redisCustTmp.remove(tdUserId);
        }else{
            lkNum=1;
        }
        itCach.setCustId(tdUserId);
        itCach.setLikedNum(lkNum);
        itCach.setMchtId(WeyeThreadContextUtils.getMerchantId());
        itCach.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        redisCust.set(tdUserId,itCach);
        redisCustTmp.set(tdUserId,itCach);

        //定义对象统计缓存
        //持久存在缓存
        String cachTimesKey=cachName+"timesPer"+type;
//        临时缓存
        String cachTimesTmpKey=cachName+"timesTmp"+type;
        //统计对象数据信息
        boolean flag2=redisTemplate.opsForHash().hasKey(cachTimesKey,objId);
        Integer likedNum;
        ItaInteractionTimes times=new ItaInteractionTimes();
        if(flag2){
            times=(ItaInteractionTimes) redisTemplate.opsForHash().get(cachTimesKey,objId);
                likedNum= times.getLkNum();
                if(likedNum==null){
                    likedNum=0;
                }
                likedNum = likedNum+1;
        }else{
            likedNum=1;
        }
        String id=KeyFactory.getKeyGenerator("interact" + "ita_interaction_times").genNextKey();
        times.setObjId(objId);
        times.setTmId(id);
        times.setLkNum(likedNum);
        times.setType(type);
        times.setMchtId(WeyeThreadContextUtils.getMerchantId());
        times.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
//        将数据存入临时缓存中
        redisTemplate.opsForHash().put(cachTimesTmpKey,objId,times);
//        将数据存入持久缓存中
        redisTemplate.opsForHash().put(cachTimesKey,objId,times);
        return MapUtil.newMap("msg","操作成功");
    }
}
