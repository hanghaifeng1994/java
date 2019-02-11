package com.learnyeai.album.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.album.mapper.AbmCategoryPhotoRelMapper;
import com.learnyeai.album.mapper.AbmSitePhotoRelMapper;
import com.learnyeai.album.model.*;
import com.learnyeai.album.mapper.AbmAlbumMapper;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.BaseEntity;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.mq.ParseRabbitMsg;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import freemarker.template.utility.DateUtil;
import org.apache.http.impl.cookie.DateUtils;
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
public class AbmAlbumWyService extends WeyeBaseService<AbmAlbum> {

    @Resource
    private AbmAlbumMapper abmAlbumMapper;
    @Resource
    private  AbmSitePhotoRelWyService abmSitePhotoRelWyService;
    @Resource
    private RabbitSender rabbitSender;
    @Resource
    private AbmSitePhotoRelMapper abmSitePhotoRelMapper;
    @Resource
    private AbmPhotoWyService abmPhotoWyService;
    @Resource
    private AbmCategoryPhotoRelMapper abmCategoryPhotoRelMapper;
    @Resource
    private AbmCategoryPhotoRelWyService abmCategoryPhotoRelWyService;
    @Resource
    private AbmCategoryWyService abmCategoryWyService;
    @Resource
    BaseInfoDao baseInfoDao;
    @Resource
    CurrentUserInfoIml currentUserInfoIml;
    @Override
    public BaseMapper<AbmAlbum> getMapper() {
        return abmAlbumMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected Weekend<AbmAlbum> genSqlExample(AbmAlbum t, Map params) {
        Weekend<AbmAlbum> weekend = super.genSqlExample(t, params);
        WeekendCriteria<AbmAlbum, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCreateBy())){
            c.andEqualTo(AbmAlbum::getCreateBy,t.getCreateBy());
        }
        if(StringUtils.isNotBlank(t.getAbmStatus())){
            c.andEqualTo(AbmAlbum::getAbmStatus,t.getAbmStatus());
        }
        weekend.and(c);
        weekend.setOrderByClause("CREATE_DATE desc");
        return null;
    }

    /**
     * 主站下发子站的相册列表
     * @return
     */
    public List<AbmAlbum> sendLowerPage(IBusinessContext ctx){
        AbmAlbum a=  super.convert2Bean(ctx.getParamMap());
        if (a != null) {
            a.initPage();
            PageHelper.startPage(a.getPage(), a.getRows());
        }
        Weekend<AbmAlbum> w=super.genSqlExample(a,ctx.getParamMap());
        WeekendCriteria<AbmAlbum,Object> c=w.weekendCriteria();
        String query="";
        query=" exists (select 1 from abm_site_photo_rel r where r.`ABM_ID`=ABM_ALBUM.`ABM_ID` and r.`SITE_ID` !=r.`ABM_CRT_SITE_ID`";

        if(StringUtils.isNotBlank(a.getCatId())){
            query+=   " AND EXISTS (SELECT 1 FROM ABM_CATEGORY_PHOTO_REL gr WHERE gr.`ABM_ID`=r.`ABM_ID`and gr.`CAT_ID`='"+a.getCatId()+"')";
        }
       String siteId= MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteId)){
            String[] siteIds=(siteId).split(",");
            int length=siteIds.length;
            query+="and r.`SITE_ID` in(";
            for(int i=0;i<length;i++){
                if(i==(length-1)){
                    query+="'"+siteIds[i]+"'";
                }else{
                    query+="'"+siteIds[i]+"',";
                }
            }
            query+=")";
        }
        if(a.getStartDate()!=null){
            c.andEqualTo(AbmAlbum::getAbmStatus,"2");
            c.andGreaterThanOrEqualTo(AbmAlbum::getUpdateDate,a.getStartDate());
        }
        if(a.getEndDate() !=null){
            c.andEqualTo(AbmAlbum::getAbmStatus,"2");
            c.andLessThan(AbmAlbum::getUpdateDate,a.getEndDate());
        }
        if(StringUtils.isNotBlank(a.getAbmName())){
            c.andLike(AbmAlbum::getAbmName,a.getAbmName());
        }
        query+=")";
        c.andCondition(query);
        w.and(c);
       List<AbmAlbum> list= abmAlbumMapper.selectByExample(w);
        list= getCatName(list,ctx);
       MyPage page=new MyPage(list);
       return rtnPageList4Report(page);
    }
    public List<AbmAlbum> queryPageExt(IBusinessContext ctx){
        AbmAlbum vo=super.convert2Bean(ctx.getParamMap());
        if (vo != null) {
            vo.initPage();
            PageHelper.startPage(vo.getPage(), vo.getRows());
        }
        Weekend<AbmAlbum> w=super.genSqlExample(vo,ctx.getParamMap());
        WeekendCriteria<AbmAlbum,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(vo.getCatId())){
            c.andCondition(" EXISTS (SELECT 1 FROM ABM_CATEGORY_PHOTO_REL r WHERE " +
                    " r.`ABM_ID`= abm_album.`ABM_ID` AND r.`CAT_ID`='"+vo.getCatId()+"')");
        }
        if(StringUtils.isNotBlank(vo.getAbmStatus())){
            c.andEqualTo(AbmAlbum::getAbmStatus,vo.getAbmStatus());
        }
       String siteIds= MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
            String[] arr=siteIds.split(",");
            c.andIn(AbmAlbum::getSiteId,Arrays.asList(arr));
        }
        if(StringUtils.isNotBlank(vo.getAbmName())){
            c.andLike(AbmAlbum::getAbmName,vo.getAbmName());
        }
        if(vo.getAbmWeight()!=null){
            c.andEqualTo(AbmAlbum::getAbmWeight,vo.getAbmWeight());
        }
        if(vo.getStartDate() !=null){
            c.andGreaterThanOrEqualTo(AbmAlbum::getUpdateDate,vo.getStartDate());
        }
        if(vo.getEndDate() !=null){
            c.andLessThan(AbmAlbum::getUpdateDate,vo.getEndDate());
        }
        w.and(c);
        List<AbmAlbum> list= abmAlbumMapper.selectByExample(w);
        list= getCatName(list,ctx);
        MyPage page=new MyPage(list);
       return rtnPageList4Report(page);
    }

    /**
     * 可用分类列表
     * @param ctx
     * @return
     */
    public List<AbmAlbum> queryPageUse(IBusinessContext ctx){
        AbmAlbum a=super.convert2Bean(ctx.getParamMap());
        Weekend<AbmAlbum> w=super.genSqlExample(a,new HashMap());
        if (a != null) {
            a.initPage();
            PageHelper.startPage(a.getPage(), a.getRows());
        }
        WeekendCriteria<AbmAlbum,Object> c=w.weekendCriteria();
        String query=" EXISTS (SELECT 1 FROM abm_site_photo_rel r WHERE r.`ABM_ID` =abm_album.`ABM_ID` and r.ABM_PUB_STATUS='1'";
        if(StringUtils.isNotBlank(a.getCatId())){
           query+="AND EXISTS (SELECT * FROM abm_category_photo_rel pr WHERE pr.`ABM_ID`=r.`ABM_ID`";
             String[] catIds=(a.getCatId()).split(",");
            int length=catIds.length;
            query+="and pr.`CAT_ID` in(";
            for(int i=0;i<length;i++){
                if(i==(length-1)){
                    query+="'"+catIds[i]+"'";
                }else{
                    query+="'"+catIds[i]+"',";
                }
            }
            query+="))";
        }
        String siteId= MapUtil.singleNodeText(ctx.getParamMap(),"abmCrtSiteId");
        if(StringUtils.isNotBlank(siteId)){
            query+="and r.`SITE_ID`='"+siteId+"'";
        }
        query+=")";
        c.andCondition(query);
        if(StringUtils.isNotBlank(a.getPosid())){
            c.andEqualTo(AbmAlbum::getPosid,a.getPosid());
        }
        w.and(c);
        List<AbmAlbum> list= abmAlbumMapper.selectByExample(w);
        list= getCatName(list,ctx);
        MyPage page=new MyPage(list);
        return rtnPageList4Report(page);
    }
    @Transactional
    public Map<String,Object>  saveData(IBusinessContext ctx){
        AbmAlbum a=   super.convert2Bean(ctx.getParamMap());
        String catId=a.getCatId();
        //有id为修改
        if(StringUtils.isNotBlank(a.getAbmId())){
            a=super.queryById(a.getAbmId());
            if(a!=null){
                //先判断是否需要修改才艺分类
                if(StringUtils.isNotBlank(catId)){
                    AbmCategoryPhotoRel rel=new AbmCategoryPhotoRel();
                    rel.setAbmId(a.getAbmId());
                    //先删除才艺分类关联表中数据
                    abmCategoryPhotoRelMapper.deleteByCatAndAbmId(rel);
                    String[] catIds=(catId).split(",");
                    for (String cId:catIds){
                        rel.setCatId(cId);
                        abmCategoryPhotoRelMapper.insertSelective(rel);
                    }
                }
            }else{
                return MapUtil.newMap("msg","相册不存在！");
            }
            super.save(a);
        }else{
            //先新增相册表
            a.setAbmStatus("0");
            super.save(a);
            AbmCategoryPhotoRel ar=new AbmCategoryPhotoRel();
            String[] catIds=(catId).split(",");
            for (String cId:catIds){
                ar.setAbmId(a.getAbmId());
                ar.setCatId(cId);
                //新增相册分类关联表
                abmCategoryPhotoRelMapper.insertSelective(ar);
            }
            //新增站点相册管理表数据
           /* AbmSitePhotoRel pr=new AbmSitePhotoRel();
            pr.setAbmCrtSiteId(a.getSiteId());
            pr.setAbmId(a.getAbmId());
//            pr.setAbmCrtSiteId();
            //如果是主站点需要查询所有的子站点
            List<PtsetSiteVo> pts= GetPriSite(a.getSiteId());
            for (PtsetSiteVo pt:pts){
                pr.setSiteId(pt.getSiteId());
                if("1".equals(pt.getSiteType())){
                    pr.setAbmManageStatus("1");
                }else{
                    pr.setAbmManageStatus("0");
                }
            }
            abmSitePhotoRelMapper.insertSelective(pr);
            */
        }
        return  MapUtil.newMap("id",a.getAbmId());
    }
    @Transactional
    public Map<String,Object> delBatch(IBusinessContext ctx){
        AbmAlbum a= super.convert2Bean(ctx.getParamMap());
        String[] abmIds=(a.getAbmId()).split(",");
        AbmPhoto p=new AbmPhoto();
       int num=0;
        for (String abmId:abmIds){
            AbmAlbum al= super.queryById(abmId);
            if(al==null){
                return MapUtil.newMap("msg","请输入正确的相册！");
            }else {
                //删除相册数据
                num+=  super.deleteById(abmId);
                //删除相册站点关联表中数据
                abmSitePhotoRelMapper.deleteByAbmId(abmId);
            }

        }
        return MapUtil.newMap("num",num);
    }

    public AbmAlbum queryByIdMsg(IBusinessContext ctx){
        AbmAlbum a= super.convert2Bean(ctx.getParamMap());
        AbmAlbum result=  super.queryById(a.getAbmId());
        List<AbmPhoto> list=  abmPhotoWyService.queryList(null,ctx.getParamMap());
        AbmCategoryPhotoRel rel=new AbmCategoryPhotoRel();
        String abmId=a.getAbmId();
        //通过abmId查询出所有的分类id
        List<AbmCategoryPhotoRel> photoRels=  abmCategoryPhotoRelWyService.queryList(rel,ctx.getParamMap());
        int i=1;
        String catName="";
        String catId="";
        for(AbmCategoryPhotoRel prel:photoRels){
            //通过分类id查询分类名称
            AbmCategory cate=  abmCategoryWyService.queryById(prel.getAbmId());
            if(cate!=null){
                if(i==photoRels.size()){
                    catName+=cate.getCatName();
                    catId+=cate.getCatId();
                }else{
                    catId+=cate.getCatId()+",";
                }
            }
        }
        a.setCatId(catId);
        a.setCatName(catName);
        result.setPhotoList(list);
        return  result;
    }

    /**
     * 提交审核
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> sumbitAudit(IBusinessContext ctx){
        int num=0;
        AbmAlbum a= super.convert2Bean(ctx.getParamMap());
        String pubstatus=a.getAbmStatus();
        String[] arr=(a.getAbmId()).split(",");
        AbmAlbum ab=new AbmAlbum();
        for(String id :arr){
            ab.setAbmId(id);
            ab.setAbmStatus(a.getAbmStatus());
            num+=super.save(ab);
          AbmAlbum bum=  super.queryById(id);
            //如果是直接审核通过
            if("2".equals(a.getAbmStatus())){
               AbmSitePhotoRel pr=new AbmSitePhotoRel();
               pr.setAbmCrtSiteId(bum.getSiteId());
               pr.setAbmId(bum.getAbmId());
               pr.setAbmPubStatus(pubstatus);
               pr.setAbmPubDate(new Date());
//            pr.setAbmCrtSiteId();
            //如果是主站点需要查询所有的子站点
                List<PtsetSiteVo> pts= SiteUtils.getPubSites(bum.getSiteId());
                for (PtsetSiteVo pt:pts){
                    pr.setSiteId(pt.getSiteId());
                    if("1".equals(pt.getSiteType())){
                        pr.setAbmManageStatus("1");
                    }else{
                        pr.setAbmManageStatus("0");
                    }
                    abmSitePhotoRelMapper.insertSelective(pr);
                }
            }
        }
        return  MapUtil.newMap("num",num);
    }

    /**
     * 批量审核
     * @param ctx
     * @return
     */
    public Map<String,Object> audit(IBusinessContext ctx) throws WeyeRabbitException {
        AuditlogMq mq=toParseAuditlogMq(ctx);
        String[] objIds=(mq.getObjId()).split(",");
        String status=mq.getStatus();
        mq.setAdUserId(currentUserInfoIml.getId());
        mq.setMchtId(WeyeThreadContextUtils.getMerchantId());
        mq.setMchtSchmId(WeyeThreadContextUtils.getMerchantSchemeId());
        AbmAlbum a=new AbmAlbum();
        int num=0;
        for (String objId:objIds){
            mq.setObjId(objId);
            a.setAbmId(objId);
            a.setAbmStatus(status);
            num+=  super.save(a);
            a =super.queryById(objId);
            //获取消息发送对象
            RabbitMetaMessage message=ParseRabbitMsg.toParseRabbitMetaMessage(mq);
            rabbitSender.send(message);
            //审核成功后在相册站点关联表中新建记录
            if("2".equals(status)){
                AbmSitePhotoRel pr=new AbmSitePhotoRel();
                pr.setAbmCrtSiteId(a.getSiteId());
                pr.setAbmPubStatus("1");
                pr.setAbmPubDate(new Date());
                pr.setAbmId(a.getAbmId());
    //            pr.setAbmCrtSiteId();
                //如果是主站点需要查询所有的子站点
                List<PtsetSiteVo> pts=SiteUtils.getPubSites(a.getSiteId());
                for (PtsetSiteVo pt:pts){
                    pr.setSiteId(pt.getSiteId());
                    if("1".equals(pt.getSiteType())){
                        pr.setAbmManageStatus("1");
                    }else{
                        pr.setAbmManageStatus("0");
                    }
                    abmSitePhotoRelMapper.insertSelective(pr);
                }
            }
        }
        return MapUtil.newMap("num",num);
    }

    public List<AbmAlbum> myQueryPage(IBusinessContext ctx){
        String userId=currentUserInfoIml.getId();
        AbmAlbum a=new AbmAlbum();
        a.setCreateBy(userId);
        MyPage<AbmAlbum> page= super.queryPage(a,new HashMap());
        return rtnPageList4Report(page);
    }

    /**
     * 批量推荐
     * @param ctx
     * @return
     */
    public Map<String,Object> recommend(IBusinessContext ctx){
        AbmAlbum a=super.convert2Bean(ctx.getParamMap());
        String[] abmIds=(a.getAbmId()).split(",");
        int num=0;
        for (String id:abmIds){
            a.setAbmId(id);
            if("1".equals(a.getFlag())){
                a.setPosid("");
            }
            num +=super.save(a);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 将入参转为审核日志对象
     */
    public AuditlogMq toParseAuditlogMq(IBusinessContext ctx){
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
     * 将入参转为站点相片关联对象
     */
    public AbmSitePhotoRel toParseRel(IBusinessContext ctx){
        try {
            AbmSitePhotoRel a= (AbmSitePhotoRel)BeanMapUtils.convertMap(AbmSitePhotoRel.class, ctx.getParamMap());
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

    public QueryAbmVo toParseAbmVo(IBusinessContext ctx){
        try {
            QueryAbmVo a= (QueryAbmVo)BeanMapUtils.convertMap(QueryAbmVo.class, ctx.getParamMap());
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
    public List<AbmAlbum> getCatName(List<AbmAlbum> list,IBusinessContext ctx){
        AbmCategoryPhotoRel rel=new AbmCategoryPhotoRel();
        for (AbmAlbum a:list){
            String abmId=a.getAbmId();
            //通过abmId查询出所有的分类id
            rel.setAbmId(abmId);
          List<AbmCategoryPhotoRel> photoRels=  abmCategoryPhotoRelWyService.queryList(rel,ctx.getParamMap());
          int i=1;
          String catName="";
          String catId="";
          for(AbmCategoryPhotoRel prel:photoRels){
              //通过分类id查询分类名称
             AbmCategory cate=  abmCategoryWyService.queryById(prel.getAbmId());
             if(cate !=null){
                 if(i==photoRels.size()){
                     catName+=cate.getCatName();
                     catId+=cate.getCatId();
                 }else{
                     catId+=cate.getCatId()+",";
                 }
             }

          }
            a.setCatId(catId);
          a.setCatName(catName);
        }
        return list;
    }
}
