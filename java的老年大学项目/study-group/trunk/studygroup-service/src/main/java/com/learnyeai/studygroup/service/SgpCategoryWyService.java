package com.learnyeai.studygroup.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.studygroup.mapper.SgpSiteCategoryMapper;
import com.learnyeai.studygroup.model.SgpCategory;
import com.learnyeai.studygroup.mapper.SgpCategoryMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.studygroup.model.SgpSiteCategory;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import com.learnyeai.studygroup.api.vo.SgpSiteCategoryVo;



import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class SgpCategoryWyService extends WeyeBaseService<SgpCategory> {
    @Autowired
    private BaseInfoDao baseInfoDao;
    @Autowired
    private SgpSiteCategoryWyService sgpSiteCategoryWyService;

    @Resource
    private SgpCategoryMapper sgpCategoryMapper;
    @Resource
    private SgpSiteCategoryMapper sgpSiteCategoryMapper;
    @Override
    public BaseMapper<SgpCategory> getMapper() {
        return sgpCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected Weekend<SgpCategory> genSqlExample(SgpCategory t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<SgpCategory,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getSiteId())){
            c.andEqualTo(SgpCategory::getSiteId,t.getSiteId());
        }
        if(StringUtils.isNotBlank(t.getCatName())){
            c.andLike(SgpCategory::getCatName,t.getCatName());
        }
        w.and(c);
        w.setOrderByClause("CREATE_DATE desc");
        return w;
    }

    /**
     * 现在分类表中新建记录，然后在分类站点关联表中新建记录
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> saveData(IBusinessContext ctx){
       SgpCategory sc= super.convert2Bean(ctx.getParamMap());

       boolean flag=true;
       if(StringUtils.isNotBlank(sc.getCatId())){
           flag=false;
       }

       super.save(sc);
       //在站点栏目关联表中新建记录（修改时不改变关联表中数据）
        String siteId=sc.getSiteId();
        if(flag){
            List<PtsetSiteVo> sites = SiteUtils.getPubSites(siteId);
            SgpSiteCategory ssc=new SgpSiteCategory();
            ssc.setCatId(sc.getCatId());
            ssc.setCatCrtSiteId(sc.getSiteId());
            ssc.setSiteId(sc.getSiteId());
            //默认都为显示
            ssc.setShowStatus("1");
            for (PtsetSiteVo pt:sites){
                ssc.setSiteId(pt.getSiteId());
                sgpSiteCategoryMapper.insertSelective(ssc);
            }

        }
       return MapUtil.newMap("id",sc.getCatId()) ;
    }
    @Transactional
    public Map<String,Object> delBatch(String catId){
        String[] catIds=catId.split(",");
        String siteId;
        SgpSiteCategory ssc=new SgpSiteCategory();
        int count=0;
        for (String id:catIds){
            //先通过id 获取到siteId
            SgpCategory sc=super.queryById(id);
            siteId=sc.getSiteId();
            ssc.setSiteId(siteId);
            ssc.setCatId(id);
            count+= super.deleteById(id);
            sgpSiteCategoryMapper.delete(ssc);
        }
        return MapUtil.newMap("num",count);
    }

    /**
     * 查询可用分类列表
     * @param ctx
     * @return
     */
    public List<SgpCategory> queryShowPage(IBusinessContext ctx){
        SgpCategory t= super.convert2Bean(ctx.getParamMap());
        if (t != null) {
            t.initPage();
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        Weekend w =super.genSqlExample(t,ctx.getParamMap());
        WeekendCriteria<SgpCategory,Object> c=w.weekendCriteria();
        c.andCondition("EXISTS (SELECT 1 FROM sgp_site_category s WHERE sgp_category.`CAT_ID`=s.`CAT_ID` AND s.`SHOW_STATUS`='1')");
        String siteIds=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
            String[] siteIdArr=siteIds.split(",");
            c.andIn(SgpCategory::getSiteId,Arrays.asList(siteIdArr));
        }
        if(StringUtils.isNotBlank(t.getCatName())){
            c.andLike(SgpCategory::getCatName,"%"+t.getCatName()+"%");
        }
        w.and(c);
        List<SgpCategory> list=sgpCategoryMapper.selectByExample(w);
        return list;
    }
}
