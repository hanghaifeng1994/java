package com.learnyeai.testing.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetPlatformVo;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingItemTypes;
import com.learnyeai.testing.model.TestingQuestionPool;
import com.learnyeai.testing.mapper.TestingQuestionPoolMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.testing.model.TestingSitePool;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author twang
 */
@Service
public class TestingQuestionPoolWyService extends WeyeBaseService<TestingQuestionPool> {

    @Resource
    private TestingQuestionPoolMapper testingQuestionPoolMapper;
    @Resource
    private TestingItemTypesWyService testingItemTypesWyService;
    @Resource
    private TestingSitePoolWyService testingSitePoolWyService;
    @Resource
    private  BaseInfoDao baseInfoDao;

    @Override
    public BaseMapper<TestingQuestionPool> getMapper() {
        return testingQuestionPoolMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<TestingQuestionPool> genSqlExample(TestingQuestionPool t, Map params) {
        Weekend<TestingQuestionPool> w=super.genSqlExample(t,params);
        WeekendCriteria<TestingQuestionPool,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getSiteId())){
            String[] siteId=(t.getSiteId()).split(",");
            c.andIn(TestingQuestionPool::getSiteId, Arrays.asList(siteId));
        }
        if(StringUtils.isNotBlank(t.getPlatformId())){
            String[] ptIds=(t.getPlatformId()).split(",");
            c.andIn(TestingQuestionPool::getSiteId, Arrays.asList(ptIds));
        }
        if(StringUtils.isNotBlank(t.getName())){
            c.andLike(TestingQuestionPool::getName,"%"+t.getName()+"%");
        }
        w.and(c);
        return w;
    }

    /**
     * 保存数据
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> saveData(IBusinessContext ctx){
        TestingQuestionPool t= super.convert2Bean(ctx.getParamMap());
        String siteId=t.getSiteId();
        String ptId=t.getPlatformId();
        t.setPlatformId(ptId);
        PtsetPlatformVo ptVo= baseInfoDao.queryPlatform( ptId);
        //如果站点id为空的情况下创建站点为平台的主站点
        if(StringUtils.isBlank(siteId)){
            t.setSiteId(ptVo.getSiteId());
        }
        String mchtId=WeyeThreadContextUtils.getMerchantId();
        //判断该商户是否有商户提醒没有的情况下新增
        TestingItemTypes tit=new TestingItemTypes();
        tit.setMchtId(mchtId);
        super.save(t);
        List<TestingItemTypes> list=testingItemTypesWyService.queryList(tit,new HashMap());
        if(list.size()==0){
           List<String> l=new ArrayList<>();
//            dx:单选;ms:多选;pd:判断;tk:填空
           l.add("dx");
           l.add("ms");
           l.add("pd");
           l.add("tk");
           for (String type:l){
               tit.setItemTypeId("");
               if(type.equals("dx")){
                   tit.setName("单选题");
               }else if(type.equals("ms")){
                   tit.setName("多选题");
               }else if(type.equals("pd")){
                   tit.setName("判断题");
               }else if(type.equals("tk")){
                   tit.setName("填空题");
               }
               tit.setItemType(type);
               testingItemTypesWyService.save(tit);
           }

        }
        //如果站点不存在的情况下，查询出这个商户下面所有的站点进行下发操作
        TestingSitePool sitePool=new TestingSitePool();
        if(StringUtils.isNotBlank(siteId)){
            //自动下发操作
            List<PtsetSiteVo> pts=SiteUtils.getPubSites(siteId);
            for (PtsetSiteVo ptsetSiteVo:pts){
                sitePool.setDisable("1");
                sitePool.setTsCrtPlatformId(ptId);
                sitePool.setTsCrtSiteId(siteId);
                sitePool.setSiteId(ptsetSiteVo.getSiteId());
                sitePool.setQpId(t.getQpId());
                testingSitePoolWyService.save(sitePool);
            }
        }else{
            //获取平台列表
            List<PtsetSiteVo> pts= baseInfoDao.querySitesByPt(ptId);
            for (PtsetSiteVo pt:pts){
                //获取每个平台列表的站点
                List<PtsetSiteVo>  sites=  SiteUtils.getPubSites(pt.getSiteId());
                for(PtsetSiteVo ptsetSiteVo:sites){
                    sitePool.setDisable("1");
                    sitePool.setTsCrtPlatformId(ptId);
                    sitePool.setTsCrtSiteId(ptVo.getSiteId());
                    sitePool.setSiteId(ptsetSiteVo.getSiteId());
                    sitePool.setQpId(t.getQpId());
                    testingSitePoolWyService.save(sitePool);
                }
            }
        }

        return MapUtil.newMap("id",t.getQpId());
    }

    /**
     * 自动下发列表
     * @param ctx
     * @return
     */
    public List<TestingQuestionPool> sendLowerPage(IBusinessContext ctx){
        TestingQuestionPool t=super.convert2Bean(ctx.getParamMap());
        if (t != null) {
            t.initPage();
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        Weekend<TestingQuestionPool> w=super.genSqlExample(t, ctx.getParamMap());
        WeekendCriteria<TestingQuestionPool,Object> c=w.weekendCriteria();
        String query=" EXISTS (SELECT 1 FROM testing_site_pool p WHERE p.`QP_ID`=TESTING_QUESTION_POOL.`QP_ID` and p.`SITE_ID`!=p.`TS_CRT_SITE_ID` and p.DISABLE='1'   ";
        if(StringUtils.isNotBlank(t.getSiteId())){
              String[] siteIds=(t.getSiteId()).split(",");
              int length =siteIds.length;
              query+="and AND p.`SITE_ID` IN (";
              for( int i=0;i<length;i++){
                  if(i==length-1){
                      query+="'"+siteIds[i]+"'";
                  }else{
                      query+="'"+siteIds[i]+"',";
                  }
              }
              query+=")";
        }
        query+=")";
        c.andCondition(query);
        w.and(c);
        return testingQuestionPoolMapper.selectByExample(w);
    }
    
    public TestingQuestionPool get(String id) {
    	return testingQuestionPoolMapper.selectByPrimaryKey(id);
    }
}
