package com.learnyeai.interact.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.interact.mapper.ItaCustExtMapper;
import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.mapper.ItaCollectionMapper;
import com.learnyeai.interact.model.ItaCustExt;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class ItaCollectionWyService extends WeyeBaseService<ItaCollection> {

    @Resource
    private ItaCollectionMapper itaCollectionMapper;
    @Resource
    CurrentUserInfoIml currentUserInfoIml;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${redisPrefix}")
    private String cachName;

    @Override
    public BaseMapper<ItaCollection> getMapper() {
        return itaCollectionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ItaCollection t, Map params) {
//        String userId=(String)params.get("userId");
        Weekend w= super.genSqlExample(t,params);
        WeekendCriteria<ItaCollection,Object> c= w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCreateBy())){
            c.andEqualTo(ItaCollection::getCreateBy,t.getCreateBy());
        }
        w.and(c);
        return w;
    }

    public List<ItaCollection> listPage(IBusinessContext ctx){
       ItaCollection itaCollection=   super.convert2Bean(ctx.getParamMap());
        if (itaCollection != null) {
            itaCollection.initPage();
            PageHelper.startPage(itaCollection.getPage(), itaCollection.getRows());
        }
       itaCollection.setCreateBy(currentUserInfoIml.getId());
        MyPage<ItaCollection> page= super.queryPage(null,ctx.getParamMap());
        return  rtnPageList4Report(page);
    }
    public static List rtnPageList4Report(MyPage page) {
        if (page.getTotal() > -1L) {
            ThreadContext.put("totalCount", page);
        }

        return page.getList();
    }

    /**
     * 新增时在缓存中加入数据，在临时缓存中加入数据，
     * 删除向临时删除缓存加入数据
     * 保存数据
     */
    public Map<String,Object> saveCach(ItaCollection ic){
        String userId=currentUserInfoIml.getId();
        String mchtId = WeyeThreadContextUtils.getMerchantId();
        String mchtSchmId = WeyeThreadContextUtils.getMerchantSchemeId();
        ic.setMchtId(mchtId);
        ic.setMchtSchmId(mchtSchmId);
        String type=ic.getType();
        String objId=ic.getObjId();
        String  cach=cachName+"collect"+type;
        String key=objId;
        boolean flag=  redisTemplate.opsForHash().hasKey(cach,objId);
        String colId=KeyFactory.getKeyGenerator("interact" + "ita_collect").genNextKey();
        ic.setCltId(colId);
        //查询缓存中是否存在数据
            //向数据缓存中查询数据
            String cachCust=cachName+"cust";
            String cachTmp=cachName+"custtmp";
            String cachCustDel=cachName+"custdel";
            String cachTimes=cachName+"times";
            String cachTimesTmp=cachName+"timestmp";
            String cachTimesDel=cachName+"timesdel";
            RedisUtil redisCust=RedisUtilFactory.getUtil(cachCust,ItaCustExt.class);
            RedisUtil redisCustTmp=RedisUtilFactory.getUtil(cachTmp,ItaCustExt.class);
            RedisUtil redisCustDel=RedisUtilFactory.getUtil(cachCustDel,ItaCustExt.class);
            RedisUtil redisTimes=RedisUtilFactory.getUtil(cachTimes,ItaInteractionTimes.class);
            RedisTemplate<String,Object> template=redisTimes.getRedisTemplate();
            RedisUtil redisTimesDel=RedisUtilFactory.getUtil(cachTimesDel,ItaInteractionTimes.class);
            RedisTemplate<String,Object> templateDel=redisTimesDel.getRedisTemplate();
            if("1".equals(ic.getCltStatus())){
                ic.setCreateBy(currentUserInfoIml.getId());
                ic.setCreateDate(new Date());
                //将收藏信息放入缓存
                redisTemplate.opsForHash().put(cach,objId,ic);
                //新增的情况下
                boolean flag1=redisCust.exists(userId);
                Integer CollectionNum;
                ItaCustExt  itCach=new ItaCustExt();
                if(flag1){
                    itCach= redisCust.get(userId);
                    CollectionNum= itCach.getCollectionNum();
                    if(CollectionNum==null){
                        CollectionNum=1;
                    }
                    CollectionNum = CollectionNum+1;
                    redisCust.remove(userId);
                    redisCustTmp.remove(userId);
                }else{
                    CollectionNum=1;
                }
                itCach.setCustId(userId);
                itCach.setCollectionNum(CollectionNum);
                itCach.setMchtId(WeyeThreadContextUtils.getMerchantId());
                itCach.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
                redisCust.set(userId,itCach);
                redisCustTmp.set(userId,itCach);

                String cachTimesKey=cachName+"timesPer"+type;
                String cachTimesTmpKey=cachName+"timesTmp"+type;
                //统计对象数据信息
                boolean flag2=template.opsForHash().hasKey(type,objId);
                Integer favNum;
                ItaInteractionTimes times=new ItaInteractionTimes();
                if(flag2){
                    times=(ItaInteractionTimes) redisTemplate.opsForHash().get(cachTimesKey,objId);
                    favNum= times.getFavNum();
                    if(favNum==null){
                        favNum=1;
                    }
                    favNum = favNum+1;
                }else{
                    favNum=1;
                }
                String id=KeyFactory.getKeyGenerator("interact" + "ita_interaction_times").genNextKey();
                times.setObjId(objId);
                times.setTmId(id);
                times.setFavNum(favNum);
                times.setType(type);
                times.setMchtId(WeyeThreadContextUtils.getMerchantId());
                times.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
                template.opsForHash().put(cachTimesKey,objId,times);
                templateDel.opsForHash().put(cachTimesTmpKey,objId,times);
            }else{
                ic.setCreateBy(currentUserInfoIml.getId());
                ic.setCreateDate(new Date());
                //将收藏信息放入缓存
                redisTemplate.opsForHash().put(cach,objId,ic);
                boolean flagdel=redisCust.exists(userId);
                Integer collectionNum;
                ItaCustExt  itCach=new ItaCustExt();
                if(flagdel){
                    itCach= redisCust.get(userId);
                    collectionNum= itCach.getCollectionNum();
                    if(collectionNum==null){
                        collectionNum=1;
                    }
                    collectionNum = collectionNum-1;
                    redisCust.remove(userId);
                }else{
                    collectionNum=0;
                }
                itCach.setCustId(userId);
                itCach.setCollectionNum(collectionNum);
                itCach.setMchtId(WeyeThreadContextUtils.getMerchantId());
                itCach.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
                redisCust.set(userId,itCach);
                redisCustDel.set(userId,itCach);

                String cachTimesKey=cachName+"timesPer"+type;
                String cachTimesTmpKey=cachName+"timesTmp"+type;
                //统计对象数据信息
                boolean flag2=redisTemplate.opsForHash().hasKey(cachTimesKey,objId);
                Integer favNum;
                ItaInteractionTimes times=new ItaInteractionTimes();
                if(flag2){
                    times=(ItaInteractionTimes) redisTemplate.opsForHash().get(type,objId);
                    favNum= times.getFavNum();
                    if(favNum==null){
                        favNum=1;
                    }
                    favNum = favNum-1;
                    redisTemplate.opsForHash().delete(cachTimesKey,objId);
                }else{
                    favNum=0;
                }
                String id=KeyFactory.getKeyGenerator("interact" + "ita_interaction_times").genNextKey();
                times.setObjId(objId);
                times.setTmId(id);
                times.setCmtNum(favNum);
                times.setType(type);
                times.setMchtId(WeyeThreadContextUtils.getMerchantId());
                times.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
                redisTemplate.opsForHash().delete(cachTimesKey,objId);
                redisTemplate.opsForHash().put(cachTimesTmpKey,objId,times);
            }
        return MapUtil.newMap("msg","操作成功！");
    }

}
