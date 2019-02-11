package com.learnyeai.schoolclass.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzClazzNews;
import com.learnyeai.schoolclass.mapper.ClzClazzNewsMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzNewsWyService extends WeyeBaseService<ClzClazzNews> {

    @Resource
    private ClzClazzNewsMapper clzClazzNewsMapper;

    @Override
    public BaseMapper<ClzClazzNews> getMapper() {
        return clzClazzNewsMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<ClzClazzNews> genSqlExample(ClzClazzNews t, Map params) {
        Weekend<ClzClazzNews> weekend = super.genSqlExample(t, params);
        WeekendCriteria<ClzClazzNews, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCreateBy())){
            c.andEqualTo(ClzClazzNews::getCreateDate,t.getCreateDate());
        }
        if(StringUtils.isNotBlank(t.getCzId())){
            c.andEqualTo(ClzClazzNews::getCzId,t.getCzId());
        }
        weekend.and(c);
        return weekend;
    }



    public void saveData(ClzClazzNews clzClazzNews){
        clzClazzNewsMapper.insertSelective(clzClazzNews);
    }
}
