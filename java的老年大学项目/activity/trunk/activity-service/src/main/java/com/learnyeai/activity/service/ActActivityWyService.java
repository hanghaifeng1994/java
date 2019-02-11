package com.learnyeai.activity.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.activity.mapper.ActCategoryActivityMapper;
import com.learnyeai.activity.mapper.ActSiteActivityRelMapper;
import com.learnyeai.activity.model.*;
import com.learnyeai.activity.mapper.ActActivityMapper;
import com.learnyeai.activity.util.ActivityUtil;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.*;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.mq.ParseRabbitMsg;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.JsonUtils;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class ActActivityWyService extends WeyeBaseService<ActActivity> {

    @Resource
    private ActActivityMapper actActivityMapper;
    @Resource
    private ActActivityWorksWyService actActivityWorksWyService;
    @Resource
    private ActCategoryActivityWyService actCategoryActivityWyService;
    @Resource
    private ActResultsWyService actResultsWyService;
    @Resource
    private  ActActivityMemerWyService actActivityMemerWyService;
    @Resource
    private ActCategoryActivityMapper actCategoryActivityMapper;
    @Resource
    private ActCategoryWyService actCategoryWyService;
    @Resource
    private ActSiteActivityRelMapper actSiteActivityRelMapper;
    @Autowired
    private RabbitSender rabbitSender;
    @Resource
    BaseInfoDao baseInfoDao;
    @Resource
    private ActSiteActivityRelWyService actSiteActivityRelWyService;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;

    @Override
    public BaseMapper<ActActivity> getMapper() {
        return actActivityMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected Weekend genSqlExample(ActActivity t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<ActActivity,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getSiteId())){
            String[] str=(t.getSiteId()).split(",");
            c.andIn(ActActivity::getActId,Arrays.asList(str));
        }
        w.and(c);
        return w;
    }

    /**
     * 可管理的活动列表
     * @param ctx
     * @return
     */
    public List<ActActivity> queryPageManger(IBusinessContext ctx){
        ActActivity a=super.convert2Bean(ctx.getParamMap());
        Weekend<ActActivity> w=super.genSqlExample(a,ctx.getParamMap());
        WeekendCriteria<ActActivity,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(a.getCatId())){
            String query="";
             query+="EXISTS (SELECT 1 FROM act_category_activity ca" +
                    " WHERE ca.`ACT_ID` =act_activity.`ACT_ID` and ca.cat_id='"+a.getCatId()+"')";
            c.andCondition(query);
        }
        if(StringUtils.isNotBlank(a.getActStatus())){
            c.andEqualTo(ActActivity::getActStatus,a.getActStatus());
        }
        if(a.getStartDate() !=null){
            c.andEqualTo(ActActivity::getActPubStatus,"1");
            c.andGreaterThanOrEqualTo(ActActivity::getUpdateBy,a.getStartDate());
        }
        if(a.getEndDate() !=null){
            c.andEqualTo(ActActivity::getActPubStatus,"1");
            c.andLessThan(ActActivity::getUpdateBy,a.getEndDate());
        }
        if(StringUtils.isNotBlank(a.getActTitle())){
            c.andLike(ActActivity::getActTitle,a.getActTitle());
        }
        String catSiteId=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(catSiteId)){
            String[] siteIds=catSiteId.split(",");
            c.andIn(ActActivity::getSiteId,Arrays.asList(siteIds));
        }
        w.and(c);
        List<ActActivity> list=actActivityMapper.selectByExample(w);
        return  getCatName(list,ctx);
    }
    /**
     * 0表示删除成功 1表示存在活动作品不能删除 2存在活动分类3存在活动成员 4存在活动成果
     * @param ac
     * @return
     */
    public Map<String,Object> saveData(ActActivity ac){
        Map<String,Object> map=new HashMap<>();
        boolean flag=true;
        //有id为修改，没有id 为新增
        if(StringUtils.isNotBlank(ac.getActId())){
//          map=operate(map,ac.getActId());
//           if(map.containsKey("status")){
//               return map;
//           }
           flag=false;
        }
        ac.setActStatus("0");
        ac.setActPubStatus("0");
        super.save(ac);
        map.put("id",ac.getActId());
        ActCategoryActivity aca=new ActCategoryActivity();
        aca.setActId(ac.getActId());
        aca.setCatId(ac.getCatId());
        if(flag){
            actCategoryActivityMapper.insert(aca);
        }
        return map;
    }

    /**
     * 批量删除
     * @param ac
     * @return
     */
    @Transactional
    public Map<String,Object> deleteData(ActActivity ac){
        String[] arr=(ac.getActId()).split(",");
        Map<String,Object> result=new HashMap<>();
        int count= 0;
        for (String id:arr){
            Map<String,Object> map=new HashMap<>();
//            map=  operate(map,id);
            //活动不关联其他数据可以删除
//            if(!(map.containsKey("status"))){
                ActActivity actActivity=super.queryById(id) ;
                //删除活动
                count+= super.deleteById(id);
                //删除活动站点关联表
                actSiteActivityRelMapper.deleteBySiteIdAndActId(actActivity);
//            }

        }
        result.put("num",count);
        return  result;
    }

    /**
     * 如果存在关联数据返回状态
     * @param map
     * @param actId
     * @return
     */
    public Map<String,Object>  operate(Map<String,Object> map,String actId){
        //修改时判断该活动下有没有活动作品有活动作品不给出
        ActActivityWorks aw=new ActActivityWorks();
        aw.setActId(actId);
        //存在活动作品不给删除
        List<ActActivityWorks> list=  actActivityWorksWyService.queryList(aw,new HashMap());
        if(list.size()>0){
            map.put("status","1");
            return map;
        }
        //存在活动分类关联数据
        ActCategoryActivity aca=new ActCategoryActivity();
        aca.setActId(actId);
        List<ActCategoryActivity> acalist=  actCategoryActivityWyService.queryList(aca,new HashMap());
        if(list.size()>0){
            map.put("status","2");
            return map;
        }
        //存在活动成员
        ActActivityMemer aam=new ActActivityMemer();
        aam.setActId(actId);
        List<ActActivityMemer> aamlist=  actActivityMemerWyService.queryList(aam,new HashMap());
        if(aamlist.size()>0){
            map.put("status","3");
            return map;
        }
        //存在活动成果
        ActResults ar=new ActResults();
        ar.setActId(actId);
        List<ActResults> arlist=  actResultsWyService.queryList(ar,new HashMap());
        if(arlist.size()>0){
            map.put("status","4");
            return map;
        }
        return map;
    }

    public  List<ActActivity>  queryPageByCriteria(IBusinessContext ctx){
        ActActivity t= super.convert2Bean(ctx.getParamMap());
        if (t != null) {
            t.initPage();
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        //存放商户id以及商户方案id
//        t.setMchtId(currentUserInfoIml.get);
        List<ActActivity> list=   actActivityMapper.queryPageByCriteria(t);
        return   getCatName(list,ctx);
    }

    /**
     * 批量提交
     * @param t
     * @return
     */
    public Map<String,Object> sumbitAudit(ActActivity t){
        String[] actIds=(t.getActId()).split(",");
        ActActivity actActivity=new ActActivity();
        int num =0;
        for (String actId:actIds){
            actActivity.setActId(actId);
            actActivity.setActStatus(t.getActStatus());
           num += super.save(actActivity);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     *  审核 /批量审核
     * @param ctx
     * @return
     */
    public Map<String,Object> audit(IBusinessContext ctx) throws WeyeRabbitException {
        ActActivity act=new ActActivity();
        //新建实体对象
        AuditlogMq auditlogMq= toParseAuditLog(ctx);
        String[] actIds=(auditlogMq.getObjId()).split(",");
        int num =0;
        act.setActStatus(auditlogMq.getStatus());
        auditlogMq.setMchtId(WeyeThreadContextUtils.getMerchantId());
        auditlogMq.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        for(String actId:actIds){
            act.setActId(actId);
            //活动表中保存
            num+=  super.save(act);
            auditlogMq.setObjId(actId);
            RabbitMetaMessage msg=ParseRabbitMsg.toParseRabbitMetaMessage(auditlogMq);
            rabbitSender.send(msg);

        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 发布/取消发布
     * status 0 取消发布1 发布
     * @param ac
     * @return
     */
    @Transactional
    public  int publish(ActActivity ac){
        String[] actIds=(ac.getActId()).split(",");
        int count=0;
        String status =ac.getActPubStatus();
        for (String actId:actIds){
            //修改活动发布状态
            ac=  super.queryById(actId);
            String siId=ac.getSiteId();
            ac.setActPubStatus(status);
            count+=super.save(ac);
            if("0".equals(status)){
                ActSiteActivityRel asar =new ActSiteActivityRel();
                asar.setActPubStatus(status);
                //根据活动id 查询出关联表中所有数据
                List<ActSiteActivityRel> list= actSiteActivityRelWyService.queryList(asar,new HashMap());
                for (ActSiteActivityRel as:list){
                    as.setActPubStatus(status);
                    actSiteActivityRelWyService.updateBySelective(as);
                }
            }else if("1".equals(status)){
                //发布时先查询该站点是不是主站点，是主站点关联表中加上他所有子站点数据
                List<PtsetSiteVo> sitelist=SiteUtils.getPubSites(siId);
                ActSiteActivityRel rel =new ActSiteActivityRel();
                rel.setActId(ac.getActId());
                rel.setActPubStatus(ac.getActPubStatus());
                rel.setActPubDate(new Date());
                //先将所有的状态都为0
                rel.setActPubStatus(status);
                for (PtsetSiteVo pt:sitelist){
                    String siteId=pt.getSiteId();
                    logger.info("===================siteId={}",siteId);
                    rel.setSiteId(siteId);
                    rel.setActCrtSiteId(siId);
                    if("1".equals(pt.getSiteType())){
                        rel.setActManageStatus("1");
                    }else{
                        rel.setActManageStatus("0");
                    }
                    actSiteActivityRelMapper.insertSelective(rel);
                }
            }
        }
        return  count;
    }

    /**
     * 主站下发到子站的列表
     * @param ctx
     * @return
     */
    public List<ActActivity> lowerSendPage(IBusinessContext ctx){
        ActActivity a=super.convert2Bean(ctx.getParamMap());
        Weekend w=super.genSqlExample(a,ctx.getParamMap());
        WeekendCriteria<ActActivity,Object> c=w.weekendCriteria();
        String query=" EXISTS (SELECT 1 FROM act_site_activity_rel r WHERE r.`ACT_ID` =act_activity.`ACT_ID` and r.SITE_ID != r.ACT_CRT_SITE_ID";
        String catSiteId=MapUtil.singleNodeText(ctx.getParamMap(),"catSiteId");
        if(StringUtils.isNotBlank(catSiteId)){
            query+=" and r.site_id in(";
            String[] siteIds=catSiteId.split(",");
            String str="";
               for (int i=0 ; i<siteIds.length;i++){
                  if(i==siteIds.length-1){
                      str+="'"+siteIds[i]+"'";
                  } else{
                      str+="'"+siteIds[i]+"',";
                  }
               }
            query+=str+")";
        }
        //分类id不为空
        if(StringUtils.isNotBlank(a.getCatId())){
             query+=" AND (EXISTS (SELECT 1 FROM act_category_activity cr WHERE cr.`ACT_ID`=r.`ACT_ID` and cr.cat_id='"+a.getCatId()+"'))";
        }
        query+=")";
        c.andCondition(query);
        if(a.getActEndDate() !=null){
            c.andGreaterThanOrEqualTo(ActActivity::getActEndDate,a.getActEndDate());
        }
        if(a.getActStartDate() !=null){
            c.andGreaterThanOrEqualTo(ActActivity::getActStartDate,a.getActStartDate());
        }
        if(StringUtils.isNotBlank(a.getActTitle())){
            c.andLike(ActActivity::getActTitle,a.getActTitle());
        }
        w.and(c);
        List<ActActivity> list=actActivityMapper.selectByExample(w);
        return  getCatName(list,ctx);
    }

    /**
     * 站点可用活动列表
     * @param ctx
     * @return
     */
    public List<ActActivity> queryPageUse(IBusinessContext ctx){
        ActActivity a=super.convert2Bean(ctx.getParamMap());
        if (a != null) {
            a.initPage();
            PageHelper.startPage(a.getPage(), a.getRows());
        }
        String siteId =a.getSiteId();
        a.setSiteId(null);
        Weekend w=super.genSqlExample(a,ctx.getParamMap());
        WeekendCriteria<ActActivity,Object> c=w.weekendCriteria();
        String query=" EXISTS (SELECT 1 FROM act_site_activity_rel r WHERE r.`ACT_ID`" +
                " =act_activity.`ACT_ID`  and r.ACT_PUB_STATUS='1'";
        if(StringUtils.isNotBlank(siteId)){
            query+=" and r.site_id ='"+siteId+"'";
        }
        //分类id不为空
        String  str="";
        if(StringUtils.isNotBlank(a.getCatId())){
            query+=" AND (EXISTS (SELECT 1 FROM act_category_activity cr WHERE cr.`ACT_ID`=r.`ACT_ID`";
            String[] catIds=(a.getCatId()).split(",");
              str=" and cr.cat_id in (";
            for(int i=0;i<catIds.length;i++){
                if(i==catIds.length-1){
                    str+="'"+catIds[i]+"'";
                }else{
                    str+="'"+catIds[i]+"',";
                }
            }
            str+=")))";
        }
        query+=str+")";
        c.andCondition(query);
        if(a.getStartDate() !=null){
            c.andEqualTo(ActActivity::getActPubStatus,"1");
            c.andGreaterThanOrEqualTo(ActActivity::getUpdateBy,a.getStartDate());
        }
        String idEnd=MapUtil.singleNodeText(ctx.getParamMap(),"isEnd");
        if(StringUtils.isNotBlank(idEnd)){
            if("1".equals(idEnd)){
                c.andEqualTo(ActActivity::getActPubStatus,"1");
                c.andLessThanOrEqualTo(ActActivity::getActEndDate,new Date());
            }else if("0".equals(idEnd)){
                c.andEqualTo(ActActivity::getActPubStatus,"1");
                c.andGreaterThanOrEqualTo(ActActivity::getActEndDate,new Date());
            }
        }
        if(StringUtils.isNotBlank(a.getActAreaId())){
            c.andEqualTo(ActActivity::getActAreaId,a.getActAreaId());
        }
        if(a.getEndDate() !=null){
            c.andEqualTo(ActActivity::getActPubStatus,"1");
            c.andLessThan(ActActivity::getUpdateBy,a.getEndDate());
        }
        if(StringUtils.isNotBlank(a.getActTitle())){
            c.andLike(ActActivity::getActTitle,a.getActTitle());
        }
        w.and(c);
        List<ActActivity> list=actActivityMapper.selectByExample(w);
        return  getCatName(list,ctx);
    }

    public List<ActActivity> myQueryPage(IBusinessContext ctx){
        ActActivity t= super.convert2Bean(ctx.getParamMap());
        if (t != null) {
            t.initPage();
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        Weekend w=super.genSqlExample(t,ctx.getParamMap());
        WeekendCriteria<ActActivity,Object> c=w.weekendCriteria();
        String custId=currentUserInfoIml.getId();
        c.andCondition(" EXISTS (SELECT 1 FROM act_activity_memer m WHERE m.`ACT_ID`=act_activity.`ACT_ID` AND m.act_id='"+custId+"') ");
        w.and(c);
        List<ActActivity> list=actActivityMapper.selectByExample(w);
        list=getCatName(list,ctx);
        return list;
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
     * 查询出的列表数据拼上分类名称
     * @param list
     * @param ctx
     * @return
     */
    public List<ActActivity> getCatName(List<ActActivity> list,IBusinessContext ctx){
        ActCategoryActivity aca=new ActCategoryActivity();
        ActCategory ac=new ActCategory();
        for (ActActivity aa:list){
            aca.setActId(aa.getActId());
            //ACT_CATEGORY_ACTIVITY
            List<ActCategoryActivity> acas=  actCategoryActivityWyService.queryList(aca,ctx.getParamMap());
            String catName="";
            String catId="";
            for (ActCategoryActivity a:acas){
                int i=1;
                ActCategory actCategory=  actCategoryWyService.queryById((acas.get(0)).getCatId());
                if(actCategory!=null){
                    if(i==acas.size()){
                        catName+=actCategory.getCatName();
                        catId+=actCategory.getCatId();
                    }else{
                        catName+=actCategory.getCatName()+",";
                        catId+=actCategory.getCatId()+",";
                    }
                }
                aa.setCatName(catName);
                aa.setCatId(catId);
            }
        }
        MyPage page=new MyPage(list);
        return  rtnPageList4Report(page);
    }
}
