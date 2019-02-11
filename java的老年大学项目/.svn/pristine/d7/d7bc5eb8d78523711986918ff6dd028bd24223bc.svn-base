package com.learnyeai.studygroup.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.studygroup.model.SgpSiteStudygroupRel;
import com.learnyeai.studygroup.mapper.SgpSiteStudygroupRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.studygroup.model.SgpStudyGroup;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class SgpSiteStudygroupRelWyService extends WeyeBaseService<SgpSiteStudygroupRel> {

    @Resource
    private SgpSiteStudygroupRelMapper sgpSiteStudygroupRelMapper;
    @Resource
    private SgpStudyGroupWyService sgpStudyGroupWyService;

    @Override
    public BaseMapper<SgpSiteStudygroupRel> getMapper() {
        return sgpSiteStudygroupRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    protected Weekend<SgpSiteStudygroupRel> genSqlExample(SgpSiteStudygroupRel t, Map params) {
        Weekend<SgpSiteStudygroupRel> weekend = super.genSqlExample(t, params);
        WeekendCriteria<SgpSiteStudygroupRel, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getSiteId())){
            c.andEqualTo(SgpSiteStudygroupRel::getSiteId,t.getSiteId());
        }
        if(StringUtils.isNotBlank(t.getSgpId())){
            c.andEqualTo(SgpSiteStudygroupRel::getSgpId,t.getSgpId());
        }
        weekend.and(c);
        return weekend;
    }

    public List<SgpSiteStudygroupRel> queryPageUse(IBusinessContext ctx){
        SgpSiteStudygroupRel t=  super.convert2Bean(ctx.getParamMap());
        if (t != null) {
            t.initPage();
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        List<SgpSiteStudygroupRel> list=sgpSiteStudygroupRelMapper.queryPageUse(t);
        List<SgpStudyGroup> groups=new ArrayList<>();
        for (SgpSiteStudygroupRel s:list){
            String sgpId=s.getSgpId();
            SgpStudyGroup p= sgpStudyGroupWyService.queryById(sgpId);
            groups.add(p);
        }
        MyPage page=new MyPage(list);
        page.setList(groups);
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
