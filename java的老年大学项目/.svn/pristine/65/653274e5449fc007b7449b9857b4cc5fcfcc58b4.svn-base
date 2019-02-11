package com.learnyeai.schoolclass.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.learnyeai.learnai.context.CtxReportUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.mapper.ClzClazzMapper;
import com.learnyeai.schoolclass.mapper.ClzSiteClazzMapper;
import com.learnyeai.schoolclass.model.ClzCategory;
import com.learnyeai.schoolclass.model.ClzCategoryClzzRell;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.model.ClzClazzBatch;
import com.learnyeai.schoolclass.model.ClzClazzCourse;
import com.learnyeai.schoolclass.model.ClzSiteClazz;
import com.learnyeai.schoolclass.model.ClzStudentClazz;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzWyService extends WeyeBaseService<ClzClazz> {

    @Resource
    private ClzClazzMapper clzClazzMapper;
    @Resource
    private ClzCategoryClzzRellWyService clzCategoryClzzRellWyService;
    @Resource
    private ClzCategoryWyService clzCategoryWyService;
    @Resource
    private  ClzStudentClazzWyService clzStudentClazzWyService;
    @Resource
    private  ClzClazzCourseWyService clzClazzCourseWyService;
    @Resource
    private  ClzClazzBatchWyService clzClazzBatchWyService;
    @Resource
    private ClzSiteClazzMapper clzSiteClazzMapper;


    @Override
    public BaseMapper<ClzClazz> getMapper() {
        return clzClazzMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Transactional
    public Map<String,Object>  saveData(IBusinessContext ctx){
        ClzClazz c= super.convert2Bean(ctx.getParamMap());
        boolean flag=false;
        if(StringUtils.isBlank(c.getCzId())){
            c.setCzPubStatus("0");
            c.setCzJoinupNum(0l);
            flag=true;
        }
        super.save(c);
        //新增需要在班级分类关联表中加入数据
        if(flag){
            String catId=MapUtil.singleNodeText(ctx.getParamMap(),"catId");
            ClzCategoryClzzRell  rel=new ClzCategoryClzzRell();
            rel.setCatId(catId);
            rel.setCzId(c.getCzId());
            clzCategoryClzzRellWyService.save(rel);
        }
        return MapUtil.newMap("id",c.getCzId());
    }

    /**
     * 批量发布操作
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> publish(IBusinessContext ctx){
     String ids=MapUtil.singleNodeText(ctx.getParamMap(),"ids");
      ClzClazz c =super.convert2Bean(ctx.getParamMap());
      String pubStatus=MapUtil.singleNodeText(ctx.getParamMap(),"czPubStatus");
        c.setCzPubStatus(pubStatus);
        c.setCzPubDate(new Date());
     Map<String,Object> result=new HashMap<>();
     String[] idarr=ids.split(",");
     ClzSiteClazz csc=new ClzSiteClazz();
     int count=0;
     for(String id:idarr){
         c.setCzId(id);
         ClzClazz clazz= super.queryById(id);
         String siteId=clazz.getSiteId();
         //1发布时想站点关联表中插入记录 0取消发布删除记录
         if("1".equals(pubStatus)){
             count+= super.save(c);
             csc.setCzPubDate(new Date());
             csc.setCzPubStatus(pubStatus);
             csc.setCzCrtSiteId(siteId);
             csc.setCzId(c.getCzId());
             List<PtsetSiteVo> list= SiteUtils.getPubSites(siteId);
             for (PtsetSiteVo pt:list){
                 csc.setSiteId(pt.getSiteId());
                 String type=pt.getSiteType();
                 if("1".equals(type)){
                     csc.setCzManageStatus("1");
                 }else {
                     csc.setCzManageStatus("0");
                 }
                 clzSiteClazzMapper.insertSelective(csc);
             }
         }else{
             ClzClazzCourse ccc=new ClzClazzCourse();
             ccc.setCzId(c.getCzId());
             //取消发布时先查看班级是否有课程 存在情况下不给取消
             List<ClzClazzCourse> cccs= clzClazzCourseWyService.queryList(ccc,new HashMap());
             if(cccs.size()>0){
                 result.put("errmsg","班级下存在课程不能取消发布");
                 return result;
             }
             ClzStudentClazz csclazz=new ClzStudentClazz();
             csclazz.setCzId(c.getCzId());
             //是否存在学员 存在情况下不给取消
             List<ClzStudentClazz> csclazzs= clzStudentClazzWyService.queryList(csclazz,new HashMap());
             if(csclazzs.size()>0){
                 result.put("errmsg","班级下存在学员不能取消发布");
                 return result;
             }
               ClzClazzBatch ccb=new ClzClazzBatch();
             ccb.setCzId(c.getCzId());
             List<ClzClazzBatch> ccbs= clzClazzBatchWyService.queryList(ccb,new HashMap());
             if(ccbs.size()>0){
                 result.put("errmsg","班级下存在报名批次不能取消发布");
                 return result;
             }
            //修改班级表发布状态
             count+=super.save(c);
             //删除班级站点关联表中的数据
             clzSiteClazzMapper.deleteByCzId(c.getCzId());
         }
     }
     return  MapUtil.newMap("num",count);
    }
    @Transactional
    public Map<String,Object> deleteBatch(IBusinessContext ctx){
        String ids=MapUtil.singleNodeText(ctx.getParamMap(),"ids");
        String[] idarr=ids.split(",");
        int count=0;
       Map<String,Object> result=new HashMap<>();
        for (String id:idarr){
            ClzClazzCourse ccc=new ClzClazzCourse();
            ccc.setCzId(id);
            //取消发布时先查看班级是否有课程 存在情况下不给删除
            List<ClzClazzCourse> cccs= clzClazzCourseWyService.queryList(ccc,new HashMap());
            if(cccs.size()>0){
                result.put("errmsg","班级下存在课程不能删除");
                result.put("num",count);
                return result;
            }
            ClzStudentClazz csclazz=new ClzStudentClazz();
            csclazz.setCzId(id);
            //是否存在学员 存在情况下不给取消
            List<ClzStudentClazz> csclazzs= clzStudentClazzWyService.queryList(csclazz,new HashMap());
            if(csclazzs.size()>0){
                result.put("errmsg","班级下存在学员不能");
                result.put("num",count);
                return result;
            }
            ClzClazzBatch ccb=new ClzClazzBatch();
            ccb.setCzId(id);
            List<ClzClazzBatch> ccbs= clzClazzBatchWyService.queryList(ccb,new HashMap());
            if(ccbs.size()>0){
                result.put("errmsg","班级下存在报名批次不能删除");
                result.put("num",count);
                return result;
            }
            //修改班级表发布状态
            count+=super.deleteById(id);

        }
        result.put("num",count);
        return result;
    }

    /**
     * 查询站点可管理的列表
     * @param ctx
     * @return
     */
    public List<ClzClazz> queryPageManger(IBusinessContext ctx){
        ClzClazz cc=  super.convert2Bean(ctx.getParamMap());
        if (cc != null) {
            cc.initPage();
            PageHelper.startPage(cc.getPage(), cc.getRows());
        }
        Weekend<ClzClazz> w =super.genSqlExample(cc,ctx.getParamMap());
        WeekendCriteria<ClzClazz,Object> c=w.weekendCriteria();
        String catId=MapUtil.singleNodeText(ctx.getParamMap(),"catId");
        String siteIds=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(catId)){
            c.andCondition("EXISTS (SELECT 1 FROM clz_category_clzz_rell r WHERE r.`CZ_ID`=clz_clazz.`CZ_ID` and r.cat_id='"+catId+"')");
        }
        if(cc.getUpdateDate() !=null){
            cc.getCzPubStatus();
            //发布状态为已发布 修改时间则为发布时间
            c.andEqualTo(ClzClazz::getCzPubStatus,"1");
           c.andEqualTo(ClzClazz::getUpdateDate,cc.getUpdateDate());
        }
        if(StringUtils.isNotBlank(cc.getPosid())){
            c.andEqualTo(ClzClazz::getPosid,cc.getPosid());
        }
        if(StringUtils.isNotBlank(siteIds)){
            String[] catSiteIds=siteIds.split(",");
            c.andIn(ClzClazz::getSiteId, Arrays.asList(catSiteIds));
        }
        if(StringUtils.isNotBlank(cc.getAreaId())){
            c.andEqualTo(ClzClazz::getAreaId,cc.getAreaId());
        }
        if(StringUtils.isNotBlank(cc.getCzName())){
            c.andLike(ClzClazz::getCzName,"%"+cc.getCzName()+"%");
        }
        if(StringUtils.isNotBlank(cc.getCzCerted())){
            c.andEqualTo(ClzClazz::getCzCerted,cc.getCzCerted());
        }
        w.and(c);
        List<ClzClazz> list=clzClazzMapper.selectByExample(w);
        //是否是可用班级
        Date now =new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        for(ClzClazz cz:list){
            Date endDate= cz.getCzEndDate();
            if(endDate==null){
                cz.setIsEnd("1");
            }else{
                if(now.getTime()>endDate.getTime()){
                    cz.setIsEnd("1");
                }else{
                    cz.setIsEnd("2");
                }
            }
        }
        return  setCatName(list,ctx);
    }

    /**
     * 可用列表
     * @param ctx
     * @return
     */
    public List<ClzClazz> queryPageUse(IBusinessContext ctx){
        ClzClazz cc=  super.convert2Bean(ctx.getParamMap());
        if (cc != null) {
            cc.initPage();
            PageHelper.startPage(cc.getPage(), cc.getRows());
        }
        Weekend<ClzClazz> w =super.genSqlExample(cc,ctx.getParamMap());
        WeekendCriteria<ClzClazz,Object> c=w.weekendCriteria();
        String query="EXISTS (SELECT 1 FROM clz_site_clazz s WHERE s.`CZ_ID` =clz_clazz.`CZ_ID` and s.CZ_PUB_STATUS='1'";
        String siteIds=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
            String[] catSiteIds=siteIds.split(",");
           query+="and s.site_id in(";
           for (int i=0;i<catSiteIds.length;i++){
               if(i==catSiteIds.length-1){
                   query+="'"+catSiteIds[i]+"'";
               }else{
                   query+="'"+catSiteIds[i]+"',";
               }
           }
           query+=")";
        }
        if(StringUtils.isNotBlank(cc.getCzId())){
            query+="and (exists (select 1 from clz_category_clzz_rell r where r.cz_id=s.cz_id and r.cat_id='"+cc.getCzId()+"'))";
        }
        query+=")";
        c.andCondition(query);
        if(cc.getCzStartDate() !=null){
            cc.getCzPubStatus();
            //发布状态为已发布 修改时间则为发布时间
            c.andEqualTo(ClzClazz::getCzPubStatus,"1");
            c.andGreaterThanOrEqualTo(ClzClazz::getUpdateDate,cc.getUpdateDate());
        }
        if(StringUtils.isNotBlank(cc.getAreaId())){
            c.andEqualTo(ClzClazz::getAreaId,cc.getAreaId());
        }
        String isEnd=MapUtil.singleNodeText(ctx.getParamMap(),"isEnd");
        if(StringUtils.isNotBlank(isEnd)){
            if("0".equals(isEnd)){
                c.andLessThan(ClzClazz::getCzStartDate,new Date());
            }else if("1".equals(isEnd)){
                c.andGreaterThanOrEqualTo(ClzClazz::getCzEndDate,new Date());
                c.andLessThan(ClzClazz::getCzEndDate,new Date());
            }else if("2".equals(isEnd)){
                c.andGreaterThan(ClzClazz::getCzEndDate,new Date());
            }
        }
        if(cc.getEndDate() !=null){
            cc.getCzPubStatus();
            //发布状态为已发布 修改时间则为发布时间
            c.andEqualTo(ClzClazz::getCzPubStatus,"1");
            c.andLessThan(ClzClazz::getUpdateDate,cc.getEndDate());
        }
        if(StringUtils.isNotBlank(cc.getCzName())){
            c.andLike(ClzClazz::getCzName,"%"+cc.getCzName()+"%");
        }
        if(StringUtils.isNotBlank(cc.getCzCerted())){
            c.andEqualTo(ClzClazz::getCzCerted,cc.getCzCerted());
        }
        w.and(c);
        List<ClzClazz> list=clzClazzMapper.selectByExample(w);
        //是否是可用班级
        return  setCatName(list,ctx);
    }

    /**
     * 下发列表
     * @param ctx
     * @return
     */
    public MyPage sendLowerPage(IBusinessContext ctx){
        ClzClazz cc =super.convert2Bean(ctx.getParamMap());
        Weekend<ClzClazz> w =super.genSqlExample(cc,ctx.getParamMap());
        WeekendCriteria<ClzClazz,Object> c=w.weekendCriteria();
        String query="";
        query+=" EXISTS (SELECT  1 FROM clz_site_clazz r  WHERE r.`CZ_ID` = clz_clazz.`CZ_ID` AND r.`SITE_ID` != r.`CZ_CRT_SITE_ID`";
        String siteIds=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
            String[] siteIdArr=siteIds.split(",");
            int length=siteIdArr.length;
            query+=" and r.site_id in (";
            for (int i=0;i<length;i++){
                if(i==length-1){
                    query+="'"+siteIdArr[i]+"'";
                }else{
                    query+="'"+siteIdArr[i]+"',";
                }
            }
            query+=")";
        }
        String catId=MapUtil.singleNodeText(ctx.getParamMap(),"catId");
        if(StringUtils.isNotBlank(catId)){
            query+="  AND (exists (SELECT 1 FROM clz_category_clzz_rell rel where rel.`CZ_ID` =r.`CZ_ID` and rel.`CAT_ID`='"+catId+"')) ";
        }
        query+=")";
        if(cc.getCzStartDate() !=null){
            cc.getCzPubStatus();
            //发布状态为已发布 修改时间则为发布时间
            c.andEqualTo(ClzClazz::getCzPubStatus,"1");
            c.andGreaterThanOrEqualTo(ClzClazz::getUpdateDate,cc.getUpdateDate());
        }
        c.andCondition(query);
        if(cc.getEndDate() !=null){
            cc.getCzPubStatus();
            //发布状态为已发布 修改时间则为发布时间
            c.andEqualTo(ClzClazz::getCzPubStatus,"1");
            c.andLessThan(ClzClazz::getUpdateDate,cc.getEndDate());
        }
        if(StringUtils.isNotBlank(cc.getCzName())){
            c.andLike(ClzClazz::getCzName,"%"+cc.getCzName()+"%");
        }
        if(StringUtils.isNotBlank(cc.getCzCerted())){
            c.andEqualTo(ClzClazz::getCzCerted,cc.getCzCerted());
        }
        w.and(c);
        List<ClzClazz> list=clzClazzMapper.selectByExample(w);
        //是否是可用班级
        list= setCatName(list,ctx);
        MyPage page=new MyPage(list);
        return  page;
    }
    /**
     * 将分类名称放入到列表中
     * @param list
     * @param ctx
     * @return
     */
    public List<ClzClazz> setCatName(List<ClzClazz> list,IBusinessContext ctx){
        for (ClzClazz clz:list){
            //先通过分类班级关联表查询所所属分类
            ClzCategoryClzzRell rel=new ClzCategoryClzzRell();
            rel.setCzId(clz.getCzId());
            List<ClzCategoryClzzRell> l=clzCategoryClzzRellWyService.queryList(rel,new HashMap<>());
            String name="";
            String catId="";
            int i=0;
            for (ClzCategoryClzzRell clzrel:l){
                i++;
             ClzCategory cate=   clzCategoryWyService.queryById(clzrel.getCatId());
                 if(cate !=null){
                     if(l.size()==i){
                         name+= cate.getCatName();
                         catId+=cate.getCatId();
                     }else{
                         catId+=cate.getCatId()+",";
                         name+= cate.getCatName()+",";
                     }
                 }
            }
            clz.setCatName(name);
            clz.setCatId(catId);
        }
     MyPage page=new MyPage(list);
     return rtnPageList4Report(page);
    }

    /**
     * 批量推荐
     * @param ctx
     * @return
     */
    @Transactional
    public  Map<String,Object> recommend(IBusinessContext ctx){
        ClzClazz c= super.convert2Bean(ctx.getParamMap());
        String[] czIds=(c.getCzId()).split(",");
        String flag=MapUtil.singleNodeText(ctx.getParamMap(),"flag");
        //1为批量推荐 2 为批量取消推荐
      int i=0;
       for(String czId:czIds){
           if("1".equals(flag)){
                c.setCzId(czId);
                c.setPosidDate(new Date());
           }else{
               c.setPosid("");
           }
         i+=  super.save(c);
       }
        return  MapUtil.newMap("num",i);
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
     * 增加报名人数
     * @param num
     * @return
     */
    public void updateJoinupNum(String czId, int num) {
    	clzClazzMapper.updateJoinupNum(czId, num);
    }
}
