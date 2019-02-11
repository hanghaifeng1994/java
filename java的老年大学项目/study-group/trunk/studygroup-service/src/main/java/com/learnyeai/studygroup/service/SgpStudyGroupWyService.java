package com.learnyeai.studygroup.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.mq.ParseRabbitMsg;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.studygroup.mapper.SgpCategoryGroupRelMapper;
import com.learnyeai.studygroup.mapper.SgpSiteStudygroupRelMapper;
import com.learnyeai.studygroup.model.*;
import com.learnyeai.studygroup.mapper.SgpStudyGroupMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import com.learnyeai.tools.common.MapUtil;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import com.learnyeai.studygroup.mapper.SgpMemberMapper;

import org.springframework.transaction.annotation.Transactional;



import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class SgpStudyGroupWyService extends WeyeBaseService<SgpStudyGroup> {

    @Resource
    private SgpStudyGroupMapper sgpStudyGroupMapper;
    @Resource
    private SgpSiteStudygroupRelMapper sgpSiteStudygroupRelMapper;
    @Resource
    private SgpSiteStudygroupRelWyService sgpSiteStudygroupRelWyService;
    @Resource
    private SgpMemberMapper sgpMemberMapper;
    @Resource
    private SgpStudyGroupTalentWyService sgpStudyGroupTalentWyService;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;
    @Resource
    private SgpCategoryGroupRelMapper sgpCategoryGroupRelMapper;
    @Resource
    private SgpStudyGroupExperienceWyService sgpStudyGroupExperienceWyService;
    @Autowired
    private SgpCategoryGroupRelWyService sgpCategoryGroupRelWyService;
    @Autowired
    private SgpCategoryWyService sgpCategoryWyService;
    @Resource
    private BaseInfoDao baseInfoDao;



    @Autowired
    private RabbitSender rabbitSender;
    @Override
    public BaseMapper<SgpStudyGroup> getMapper() {
        return sgpStudyGroupMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend genSqlExample(SgpStudyGroup s,Map params){
        Weekend<SgpStudyGroup> weekend = super.genSqlExample(s,params);
        WeekendCriteria<SgpStudyGroup,Object> c = weekend.weekendCriteria();
        if(StringUtils.isNotBlank(s.getSgpId())){
            c.andEqualTo(SgpStudyGroup::getSgpId,s.getSgpId());
        }
        if(StringUtils.isNotBlank(s.getSgpStatus())){
            c.andEqualTo(SgpStudyGroup::getSgpStatus,s.getSgpStatus());
        }
        String sId=MapUtil.singleNodeText(params,"siteIds");
        if(StringUtils.isNotBlank(sId)){
            String[] siteIds=(sId).split(",");
            c.andIn(SgpStudyGroup::getSiteId,Arrays.asList(siteIds));
        }
        if(StringUtils.isNotBlank(s.getSgpName())){
            c.andLike(SgpStudyGroup::getSiteId,"%"+s.getSgpName()+"%");
        }
        weekend.and(c);
        return weekend;
    }
    public List<SgpStudyGroup> queryPageExt(IBusinessContext ctx){
        SgpStudyGroup ssg=super.convert2Bean(ctx.getParamMap());
        if (ssg != null) {
            ssg.initPage();
            PageHelper.startPage(ssg.getPage(), ssg.getRows());
        }
        Weekend<SgpStudyGroup> w=super.genSqlExample(ssg,ctx.getParamMap());
        WeekendCriteria<SgpStudyGroup,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(ssg.getCatId())){
            c.andCondition("EXISTS (SELECT 1  FROM sgp_category_group_rel r WHERE r.`SGP_ID` = sgp_study_group.`SGP_ID` and r.`CAT_ID`='"+ssg.getCatId()+"')");
        }
        if(StringUtils.isNotBlank(ssg.getSgpStatus())){
            c.andEqualTo(SgpStudyGroup::getSgpStatus,ssg.getSgpStatus());
        }
        if(StringUtils.isNotBlank(ssg.getSgpName())){
            c.andLike(SgpStudyGroup::getSgpName,"%"+ssg.getSgpName()+"%");
        }
       String siteIds= MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
            String[] siteIdArr=siteIds.split(",");
            c.andIn(SgpStudyGroup::getSiteId,Arrays.asList(siteIdArr));
        }
        w.and(c);
        List<SgpStudyGroup> list= sgpStudyGroupMapper.selectByExample(w);
        list=setTanExp(list,ctx);
        list=setCatName(list,ctx);
        MyPage page=new MyPage(list);
        return rtnPageList4Report(page);
    }
    @Transactional
    public Map<String,Object> delBatch(IBusinessContext ctx){
       SgpStudyGroup g= super.convert2Bean(ctx.getParamMap());
       String[] ids=(g.getSgpId()).split(",");
       for (String id:ids){
           super.deleteById(id);
       }

        return  null;
    }

    /**
     * 根据才艺id查询
     * @param ctx
     * @return
     */
    public MyPage<SgpStudyGroup> queryPageByCyId(IBusinessContext ctx){
        String cyId=MapUtil.singleNodeText(ctx.getParamMap(),"cyId");
        SgpStudyGroup ssg=super.convert2Bean(ctx.getParamMap());
        if (ssg != null) {
            ssg.initPage();
            PageHelper.startPage(ssg.getPage(), ssg.getRows());
        }
        Weekend<SgpStudyGroup> w=super.genSqlExample(ssg,ctx.getParamMap());
        WeekendCriteria<SgpStudyGroup,Object> c=w.weekendCriteria();
        String query="EXISTS (SELECT 1 FROM sgp_study_group_talent t WHERE t.`SGP_ID` =sgp_study_group.`SGP_ID` ";
        if(StringUtils.isNotBlank(cyId)){
            String[] cyIds=cyId.split(",");
            query+=" and t.TLT_ID in (";
            for(int i=0;i<cyIds.length;i++){
                if(i==cyIds.length-1){
                   query+="'"+cyIds[i]+"'" ;
                }else{
                    query+="'"+cyIds[i]+"'," ;
                }
            }
            query+=")";
        }
         query+=")";
        List<SgpStudyGroup> list=sgpStudyGroupMapper.selectByExample(w);
        setTanExp(list,ctx);
        setCatName(list,ctx);
        MyPage page=new MyPage(list);
        return page;
    }
    /**
     * 根据经验id查询
     * @param ctx
     * @return
     */
    public MyPage<SgpStudyGroup> queryPageByExpId(IBusinessContext ctx){
        String expId=MapUtil.singleNodeText(ctx.getParamMap(),"expId");
        SgpStudyGroup ssg=super.convert2Bean(ctx.getParamMap());
        if (ssg != null) {
            ssg.initPage();
            PageHelper.startPage(ssg.getPage(), ssg.getRows());
        }
        Weekend<SgpStudyGroup> w=super.genSqlExample(ssg,ctx.getParamMap());
        WeekendCriteria<SgpStudyGroup,Object> c=w.weekendCriteria();
        String query="EXISTS (SELECT 1 FROM sgp_study_group_experience t WHERE t.`SGP_ID` =sgp_study_group_experience.`SGP_ID` ";
        if(StringUtils.isNotBlank(expId)){
            String[] expIds=expId.split(",");
            query+=" and t.EPC_ID in (";
            for(int i=0;i<expIds.length;i++){
                if(i==expIds.length-1){
                    query+="'"+expIds[i]+"'" ;
                }else{
                    query+="'"+expIds[i]+"'," ;
                }
            }
            query+=")";
        }
        query+=")";
        List<SgpStudyGroup> list=sgpStudyGroupMapper.selectByExample(w);
        setTanExp(list,ctx);
        setCatName(list,ctx);
        MyPage page=new MyPage(list);
        return page;
    }

    /**
     * 学习小组保存
     * @param ctx
     * @return
     */
    public Map<String,Object> saveData(IBusinessContext ctx){
        SgpStudyGroup g= super.convert2Bean(ctx.getParamMap());
        String catId=g.getCatId();
        boolean flag=false;
        if(StringUtils.isBlank(g.getSgpId())){
            flag=true;
            //新增将状态设为0
            g.setSgpStatus("0");
            g.setSgpUserNum(0);
            g.setTalentNum(0);
            g.setSgpUserNum(0);
        }
        super.save(g);
        if(flag){
            SgpCategoryGroupRel sc=new SgpCategoryGroupRel();
            String[] catIds=catId.split(",");
            for(String cId:catIds){
                sc.setCatId(cId);
                sc.setSgpId(g.getSgpId());
                //在活动关联表中存入数据
                sgpCategoryGroupRelMapper.insertSelective(sc);
            }
        }
        return MapUtil.newMap("id",g.getSgpId());
    }

    /**
     * 审核
     * @param ctx
     * @return
     * @throws WeyeRabbitException
     */
    @Transactional
    public Map<String,Object> audit(IBusinessContext ctx) throws WeyeRabbitException {
        SgpStudyGroup g=new SgpStudyGroup();
        AuditlogMq mq= toParseAuditLog(ctx);
        String[] sgpIds=(mq.getObjId()).split(",");
        int num =0;
        String status =mq.getStatus();
        mq.setAdUserId(currentUserInfoIml.getId());
        mq.setMchtId(WeyeThreadContextUtils.getMerchantId());
        mq.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        g.setSgpStatus(status);
        for(String sgpId:sgpIds){
            g.setSgpId(sgpId);
            //活动表中保存
            num+=  super.save(g);
            mq.setObjId(sgpId);
            RabbitMetaMessage msg=ParseRabbitMsg.toParseRabbitMetaMessage(mq);
            rabbitSender.send(msg);
            //审核通过后在站点小组关联表中新建记录
            SgpSiteStudygroupRel sssr=new SgpSiteStudygroupRel();
            SgpStudyGroup ssg= super.queryById(sgpId);
            sssr.setCrtSiteId( ssg.getSiteId());
            sssr.setManageStatus("1");
            sssr.setSgpId(ssg.getSgpId());
            sssr.setPubStatus("1");
            sssr.setPubDate(new Date());
            //2为审核通过
            if("2".equals(status)){
               List<PtsetSiteVo> l= SiteUtils.getPubSites(ssg.getSiteId());
               //判断关联表是否有数据，有数据修改，无数据新增
                List<SgpSiteStudygroupRel> srs=sgpSiteStudygroupRelWyService.queryList(sssr,new HashMap());
               for(PtsetSiteVo pt:l){
                   String siteId=pt.getSiteId();
                   sssr.setSiteId(siteId);
                   if(srs.size()==0){
                       sgpSiteStudygroupRelMapper.insertSelective(sssr);
                   }
               }
            }
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 下发列表
     * @param ctx
     * @return
     */
    public  List<SgpStudyGroup> sendLowerPage(IBusinessContext ctx){
        SgpStudyGroup ssg= super.convert2Bean(ctx.getParamMap());
        if (ssg != null) {
            ssg.initPage();
            PageHelper.startPage(ssg.getPage(), ssg.getRows());
        }
        Weekend<SgpStudyGroup> w=super.genSqlExample(ssg,ctx.getParamMap());
        WeekendCriteria<SgpStudyGroup,Object> c=w.weekendCriteria();
        String query="";
        query=" exists (select 1 from sgp_site_studygroup_rel r where r.`SGP_ID`=sgp_study_group.`SGP_ID` and r.`SITE_ID` !=r.`CRT_SITE_ID`";

        if(StringUtils.isNotBlank(ssg.getCatId())){
            query+=   " AND EXISTS (SELECT 1 FROM sgp_category_group_rel gr WHERE gr.`SGP_ID`=r.`SGP_ID`and gr.`CAT_ID`='"+ssg.getCatId()+"'";
        }
        String sId=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(sId)){
            String[] siteIds=sId.split(",");
//            c.andIn(SgpStudyGroup::getSiteId,Arrays.asList(siteIds));
            int length=siteIds.length;
            query+="and r.`SITE_ID` in(";
            for(int i=0;i<length;i++){
                if(i==(length-1)){
                    query+="'"+siteIds[i]+"'";
                }else{
                    query+="'"+siteIds[i]+"',";
                }
            }
            query+="))";
        }
        if(ssg.getStartDate()!=null){
            c.andEqualTo(SgpStudyGroup::getSgpStatus,"2");
           c.andGreaterThanOrEqualTo(SgpStudyGroup::getUpdateDate,ssg.getStartDate());
        }
        if(ssg.getEndDate()!=null){
            c.andEqualTo(SgpStudyGroup::getSgpStatus,"2");
            c.andLessThanOrEqualTo(SgpStudyGroup::getUpdateDate,ssg.getEndDate());
        }
        query+=")";
        if(StringUtils.isNotBlank(ssg.getSgpName())){
            c.andLike(SgpStudyGroup::getSgpName,"%"+ssg.getSgpName()+"%");
        }
        c.andCondition(query);
        w.and(c);
        List<SgpStudyGroup>  list=  sgpStudyGroupMapper.selectByExample(w);
        list=setTanExp(list,ctx);
        list=setCatName(list,ctx);
        MyPage page =new MyPage(list);
        return rtnPageList4Report(page);
    }
    public List<SgpStudyGroup> pullGroupPage(IBusinessContext ctx){
     MyPage<SgpStudyGroup> page=   super.queryPage(null,ctx.getParamMap());
        List<SgpStudyGroup> list= page.getList();
        list=setCatName(list,ctx);
        list=setTanExp(list,ctx);
        page.setList(list);
        return  rtnPageList4Report(page);
    }

    /**
     * 可用列表
     * @param ctx
     * @return
     */
    public List<SgpStudyGroup> queryPageUse(IBusinessContext ctx){
        SgpStudyGroup ssg=super.convert2Bean(ctx.getParamMap());
        String siteId = (CurrentBaseInfoUtil.getSite()).getSiteId();
        ssg.setSiteId(null);
        if (ssg != null) {
            ssg.initPage();
            PageHelper.startPage(ssg.getPage(), ssg.getRows());
        }
        Weekend<SgpStudyGroup>  w=super.genSqlExample(ssg,ctx.getParamMap());
        WeekendCriteria<SgpStudyGroup,Object> c=w.weekendCriteria();
        String query=" EXISTS (SELECT 1 FROM sgp_site_studygroup_rel r WHERE r.`SGP_ID`=sgp_study_group.`SGP_ID`  ";
        if(siteId !=null){
            query+="and r.`site_id` ='"+siteId+"'";
        }
        if(StringUtils.isNotBlank(ssg.getCatId())){
            query+="AND (EXISTS(SELECT 1 FROM sgp_category_group_rel gr WHERE gr.`SGP_ID`= r.`SGP_ID` AND gr.`CAT_ID` in (";
            String[] getCatIds=(ssg.getCatId()).split(",");
            int length=getCatIds.length;
            for(int i=0;i<length;i++){
                if(i==(length-1)){
                    query+="'"+getCatIds[i]+"'";
                }else{
                    query+="'"+getCatIds[i]+"',";
                }
            }
            query+=")))";
        }
        query+=")";
        c.andCondition(query);
        w.and(c);
        List<SgpStudyGroup> list=sgpStudyGroupMapper.selectByExample(w);
        list=setCatName(list,ctx);
        list=setTanExp(list,ctx);
        MyPage page=new MyPage( setTanExp(list,ctx));
        return rtnPageList4Report(page);
    }
    public static List rtnPageList4Report(MyPage page) {
        if (page.getTotal() > -1L) {
            Map extData = CtxReportUtil.getListExtResultMap();
            extData.put("totalCount", page.getTotal());
            extData.put("pageNo", page.getPageNo());
            extData.put("pageSize", page.getPageSize());
        }

        return page.getList();
    }



    @Transactional
    public Map<String,Object> deleteall(SgpStudyGroup ssg){
        String[] sgpIds = (ssg.getSgpId()).split(",");
        int num = 0;
        for (String id:sgpIds){
            num += super.deleteById(id);
            sgpMemberMapper.deleteMemberbySgpIds(id);
        }
        logger.info("批量删除了"+num+"条数");
        return MapUtil.newMap("num",num);
    }




    @Transactional
    public Map<String,Object> sumbitAudit(SgpStudyGroup ssg){
        String[] sgpIds = (ssg.getSgpId()).split(",");
        SgpStudyGroup sgpStudyGroup = new SgpStudyGroup();
        int num = 0;
        SgpStudyGroup group=new SgpStudyGroup();
        for (String sgpId:sgpIds){
            sgpStudyGroup.setSgpId(sgpId);
            String status=ssg.getSgpStatus();
            group=super.queryById(sgpId);
            String siteId= group.getSiteId();
            sgpStudyGroup.setSgpStatus(ssg.getSgpStatus());
            num = super.save(sgpStudyGroup);
            SgpSiteStudygroupRel sssr=new SgpSiteStudygroupRel();
            sssr.setCrtSiteId( group.getSiteId());
            sssr.setManageStatus("1");
            sssr.setSgpId(group.getSgpId());
            sssr.setPubStatus("1");
            sssr.setPubDate(new Date());
            //2为审核通过
            if("2".equals(status)){
                List<PtsetSiteVo> l= SiteUtils.getPubSites(group.getSiteId());
                //判断关联表是否有数据，有数据修改，无数据新增
                List<SgpSiteStudygroupRel> srs=sgpSiteStudygroupRelWyService.queryList(sssr,new HashMap());
                for(PtsetSiteVo pt:l){
                    String ptSiteId=pt.getSiteId();
                    sssr.setSiteId(ptSiteId);
                    if(srs.size()==0){
                        sgpSiteStudygroupRelMapper.insertSelective(sssr);
                    }
                }
            }
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 将入参转为审核日志对象
     */
    public AuditlogMq toParseAuditLog(IBusinessContext ctx){
        try {
            AuditlogMq a= (AuditlogMq)BeanMapUtils.convertMap(AuditlogMq.class, ctx.getParamMap());
            return a;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 获取经验数才艺数
     * @param list
     * @param ctx
     * @return
     */
    public List<SgpStudyGroup> setTanExp(List<SgpStudyGroup> list,IBusinessContext ctx){
        SgpStudyGroupTalent talent=new SgpStudyGroupTalent();
        SgpStudyGroupExperience Experience=new SgpStudyGroupExperience();
        for (SgpStudyGroup s:list){
            String sgpId=s.getSgpId();
            talent.setSgpId(sgpId);
            Experience.setSgpId(sgpId);
            //查询才艺数量
            List<SgpStudyGroupTalent> talents =sgpStudyGroupTalentWyService.queryList(talent ,ctx.getParamMap());
            //查询经验数量
            List<SgpStudyGroupExperience> experiences =sgpStudyGroupExperienceWyService.queryList(Experience,ctx.getParamMap());
            s.setTalentNum(talents.size());
            s.setExperienceNum(experiences.size());
        }
        return list;
    }

    /**
     * 存放分类名称和分类id
     * @param list
     * @param ctx
     * @return
     */
    public  List<SgpStudyGroup> setCatName(List<SgpStudyGroup> list,IBusinessContext ctx){
        for (SgpStudyGroup sg:list){
            SgpCategoryGroupRel rel=new SgpCategoryGroupRel();
            String catName="";
            String catId="";
            if(sg!=null){
                rel.setSgpId(sg.getSgpId());
                List<SgpCategoryGroupRel> sgp= sgpCategoryGroupRelWyService.queryList(rel,new HashMap());
                int i=0;
                for(SgpCategoryGroupRel s:sgp){
                    SgpCategory sc=   sgpCategoryWyService.queryById(s.getCatId());
                    if(sc !=null){
                        if(i==sgp.size()-1){
                            catName+=sc.getCatName();
                            catId+=sc.getCatId();
                        }else{
                            catName+=sc.getCatName()+",";
                            catId+=sc.getCatId()+",";
                        }
                    }
                    i++;
                }
            }
            sg.setCatName(catName);
            sg.setCatId(catId);
        }
        return list;
    }
}
