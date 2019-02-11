package com.learnyeai.activity.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.activity.mapper.ActSiteActivityRelMapper;
import com.learnyeai.activity.model.ActCategory;
import com.learnyeai.activity.mapper.*;
import com.learnyeai.activity.model.ActSiteActivityRel;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.activity.model.ActSiteCategoryRel;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.base.api.util.SiteUtils;


import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class ActCategoryWyService extends WeyeBaseService<ActCategory>{

    @Resource
    private ActSiteCategoryRelMapper actSiteCategoryRelMapper;
    @Resource
    private ActSiteCategoryRelWyService actSiteCategoryRelWyService;
    @Resource
    private ActSiteActivityRelMapper actSiteActivityRelMapper;

    @Resource
    private ActCategoryMapper actCategoryMapper;

    @Override
    public BaseMapper<ActCategory> getMapper() {
        return actCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }


    @Override
    protected Weekend genSqlExample(ActCategory t,Map params){
        Weekend<ActCategory> w = super.genSqlExample(t,params);
        WeekendCriteria<ActCategory,Object> c = w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCatId())){
            c.andEqualTo(ActCategory::getCatId,t.getCatId());
        }
        if(StringUtils.isNotBlank(t.getCatName())){
            c.andEqualTo(ActCategory::getCatName,"%"+t.getCatName()+"%");
        }
        if(StringUtils.isNotBlank(t.getParentId())){
            c.andEqualTo(ActCategory::getParentId,t.getParentId());
        }
        w.and(c);
        return w;
    }

    /**
     * 分类可用接口
     * @param ctx
     * @return
     */
    public List<ActCategory> queryPageByUse(IBusinessContext ctx){
        ActCategory ac= super.convert2Bean(ctx.getParamMap());
        String siteId=ac.getSiteId();
        ac.setSiteId(null);
        if (ac != null) {
            ac.initPage();
            PageHelper.startPage(ac.getPage(), ac.getRows());
        }
        Weekend w=super.genSqlExample(ac ,ctx.getParamMap());
        WeekendCriteria<ActCategory,Object> c=w.weekendCriteria();
        String query="EXISTS (SELECT 1 FROM act_site_category_rel r WHERE r.`CAT_ID`=act_category.`CAT_ID`";
        if(StringUtils.isNotBlank(siteId)){
            query+=" and r.site_id='"+siteId+"'";
        }
        String showStatus=MapUtil.singleNodeText(ctx.getParamMap(),"showStatus");
        if(StringUtils.isNotBlank(showStatus)){
            query+=" and r.SHOW_STATUS='"+showStatus+"'";
        }
        query+=")";
        c.andCondition(query);
        if(StringUtils.isNotBlank(ac.getCatName())){
            c.andLike(ActCategory::getCatName,"%"+ac.getCatName()+"%");
        }
        if(StringUtils.isNotBlank(ac.getCatId())){
            c.andEqualTo(ActCategory::getCatId,"%"+ac.getCatId()+"%");
        }
        w.and(c);
       List<ActCategory> list= actCategoryMapper.selectByExample(w);
       return list;
    }

    @Transactional
    public Map<String,Object> deleteall(ActCategory ctg){
        String[] catIds = (ctg.getCatId()).split(",");
        String siteId;
        ActSiteCategoryRel ascr = new ActSiteCategoryRel();
        int num = 0;
        for (String id:catIds){
            siteId = ctg.getSiteId();
            ascr.setSiteId(siteId);
            ascr.setCatId(id);
            num += super.deleteById(id);
            actSiteCategoryRelMapper.delete(ascr);
        }

        logger.info("批量删除了"+num+"条数据");
        return MapUtil.newMap("num",num);
    }




    @Transactional
    public Map<String,Object> saveDate(ActCategory ctg){
        ActSiteCategoryRel astr = new ActSiteCategoryRel();
        String siteId= ctg.getSiteId();
        boolean flag = true;
        if(StringUtils.isNotBlank(ctg.getCatId())){
            flag = false;
            super.save(ctg);
        }else{
            if(StringUtils.isNotBlank(ctg.getParentId())){
                ActCategory cate=super.queryById(ctg.getParentId());
                if(cate !=null){
                    String  parentIds=cate.getParentId()+",";
                    ctg.setParentIds(parentIds);
                }
                //存在子数据的情况下状态设为1
//                ctg.set("1");
            }else{
                ctg.setParentId("0");
                ctg.setParentIds("0,");
            }
            super.save(ctg);
            if(flag){
                List<PtsetSiteVo> list = SiteUtils.getPubSites(siteId);
                astr.setCatId(ctg.getCatId());
                astr.setSiteId(siteId);
                astr.setShowStatus("1");
                for(PtsetSiteVo pt:list){
                    astr.setSiteId(pt.getSiteId());
                    actSiteCategoryRelMapper.insertSelective(astr);
                }
                super.save(ctg);
            }
        }

        return MapUtil.newMap("id",ctg.getCatId());
    }


}
