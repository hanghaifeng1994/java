package com.learnyeai.activity.service;

import com.learnyeai.activity.model.ActSiteCategoryRel;
import com.learnyeai.activity.mapper.ActSiteCategoryRelMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class ActSiteCategoryRelWyService extends WeyeBaseService<ActSiteCategoryRel> {

    @Resource
    private ActSiteCategoryRelMapper actSiteCategoryRelMapper;

    @Override
    public BaseMapper<ActSiteCategoryRel> getMapper() {
        return actSiteCategoryRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
