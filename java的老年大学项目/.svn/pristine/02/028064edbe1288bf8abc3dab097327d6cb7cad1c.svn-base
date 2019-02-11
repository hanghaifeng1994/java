package com.learnyeai.album.service;

import com.learnyeai.album.model.AbmCategory;
import com.learnyeai.album.model.AbmSiteCategoryRel;
import com.learnyeai.album.mapper.AbmSiteCategoryRelMapper;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class AbmSiteCategoryRelWyService extends WeyeBaseService<AbmSiteCategoryRel> {

    @Resource
    private AbmSiteCategoryRelMapper abmSiteCategoryRelMapper;
    @Resource
    private AbmCategoryWyService abmCategoryWyService;

    @Override
    public BaseMapper<AbmSiteCategoryRel> getMapper() {
        return abmSiteCategoryRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<AbmSiteCategoryRel> genSqlExample(AbmSiteCategoryRel t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<AbmSiteCategoryRel,Object> c=w.weekendCriteria();
        String siteIds=MapUtil.singleNodeText(params,"siteIds");
        if(StringUtils.isNotBlank(siteIds)){
           String[] arr=(siteIds).split(",");
           c.andIn(AbmSiteCategoryRel::getSiteId, Arrays.asList(arr));
       }
       if(StringUtils.isNotBlank(t.getShowStatus())){
           c.andEqualTo(AbmSiteCategoryRel::getShowStatus,t.getShowStatus());
       }
       w.setOrderByClause("CAT_SORT asc");
       w.and(c);
        return w;
    }

    /**
     * 查询站点可用分类
     * @param ctx
     * @return
     */
    public List<AbmCategory> queryPageUse(IBusinessContext ctx){
        MyPage page= super.queryPage(null,ctx.getParamMap());
        List<AbmSiteCategoryRel> list=page.getList();
        List<AbmCategory> ls=new ArrayList<>();
        for(AbmSiteCategoryRel r:list){
            String catId=r.getCatId();
            AbmCategory ac=abmCategoryWyService.queryById(catId);
            ac.setsId(r.getSiteId());
            ls.add(ac);
        }
        page.setList(ls);
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

}
