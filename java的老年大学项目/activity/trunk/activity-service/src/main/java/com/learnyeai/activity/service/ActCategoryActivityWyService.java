package com.learnyeai.activity.service;

import com.learnyeai.activity.model.ActCategory;
import com.learnyeai.activity.model.ActCategoryActivity;
import com.learnyeai.activity.mapper.ActCategoryActivityMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class ActCategoryActivityWyService extends WeyeBaseService<ActCategoryActivity> {

    @Resource
    private ActCategoryActivityMapper actCategoryActivityMapper;

    @Override
    public BaseMapper<ActCategoryActivity> getMapper() {
        return actCategoryActivityMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ActCategoryActivity t, Map params) {
        Weekend<ActCategoryActivity> w = super.genSqlExample(t,params);
        WeekendCriteria<ActCategoryActivity,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getActId())){
            c.andEqualTo(ActCategoryActivity::getActId,t.getActId());
        }
        w.and(c);
        return  w;
    }

}
