package com.learnyeai.studygroup.service;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.studygroup.model.SgpCategory;
import com.learnyeai.studygroup.model.SgpSiteCategory;
import com.learnyeai.studygroup.mapper.SgpSiteCategoryMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class SgpSiteCategoryWyService extends WeyeBaseService<SgpSiteCategory> {

    @Resource
    private SgpSiteCategoryMapper sgpSiteCategoryMapper;
    @Resource
    private SgpCategoryWyService sgpCategoryWyService;

    @Override
    public BaseMapper<SgpSiteCategory> getMapper() {
        return sgpSiteCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<SgpSiteCategory> genSqlExample(SgpSiteCategory t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<SgpSiteCategory,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getSiteId())){
            c.andEqualTo(SgpSiteCategory::getSiteId,t.getSiteId());
        }
        if(StringUtils.isNotBlank(t.getShowStatus())){
            c.andEqualTo(SgpSiteCategory::getShowStatus,t.getShowStatus());
        }
        w.and(c);
        return w;
    }

    public Map<String,Object> showAndHideBatch(IBusinessContext ctx){
        SgpSiteCategory ssc=super.convert2Bean(ctx.getParamMap());
        List<SgpSiteCategory> list=ssc.getList();
        int num =0;
        if(list !=null && list.size()>0){
            for (SgpSiteCategory ca:list){
                num+=sgpSiteCategoryMapper.updateByPrimaryKeySelective(ca);
            }
        }
        return MapUtil.newMap("num",num);
    }

    public List<SgpCategory> queryPageExt(IBusinessContext ctx){
        MyPage page=   super.queryPage(null,ctx.getParamMap());
        List<SgpSiteCategory> list=page.getList();
        List<SgpCategory> result=new ArrayList<>();
        if(list !=null){
            for (SgpSiteCategory ssc:list){
                SgpCategory a=  sgpCategoryWyService.queryById(ssc.getCatId());
                result.add(a);
            }
        }
        page.setList(result);
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
