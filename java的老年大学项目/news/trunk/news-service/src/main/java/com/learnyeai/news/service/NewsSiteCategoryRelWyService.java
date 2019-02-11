package com.learnyeai.news.service;

import com.learnyeai.news.model.NewsSiteCategoryRel;
import com.learnyeai.news.mapper.NewsSiteCategoryRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class NewsSiteCategoryRelWyService extends WeyeBaseService<NewsSiteCategoryRel> {

    @Resource
    private NewsSiteCategoryRelMapper newsSiteCategoryRelMapper;

    @Override
    public BaseMapper<NewsSiteCategoryRel> getMapper() {
        return newsSiteCategoryRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected Weekend genSqlExample(NewsSiteCategoryRel t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<NewsSiteCategoryRel,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getShowStatus())){
            c.andEqualTo(NewsSiteCategoryRel::getShowStatus,t.getShowStatus());
        }
        if(StringUtils.isNotBlank(t.getSiteId())){
            String[] arr=(t.getSiteId()).split(",");
            c.andIn(NewsSiteCategoryRel::getSiteId,Arrays.asList(arr));
        }
        w.setOrderByClause("CAT_SORT asc");
        w.and(c);
        return  w;
    }

    public int deleteByIdAndsiteId(String siteId,String catId){
        NewsSiteCategoryRel nr=new NewsSiteCategoryRel();
        nr.setSiteId(siteId);
        nr.setCatId(catId);
        return  newsSiteCategoryRelMapper.deleteByIdAndsiteId(nr);
    }
}
