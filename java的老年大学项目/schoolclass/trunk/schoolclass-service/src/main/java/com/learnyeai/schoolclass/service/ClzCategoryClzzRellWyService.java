package com.learnyeai.schoolclass.service;

import com.learnyeai.schoolclass.model.ClzCategoryClzzRell;
import com.learnyeai.schoolclass.mapper.ClzCategoryClzzRellMapper;
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
public class ClzCategoryClzzRellWyService extends WeyeBaseService<ClzCategoryClzzRell> {

    @Resource
    private ClzCategoryClzzRellMapper clzCategoryClzzRellMapper;

    @Override
    public BaseMapper<ClzCategoryClzzRell> getMapper() {
        return clzCategoryClzzRellMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<ClzCategoryClzzRell> genSqlExample(ClzCategoryClzzRell t, Map params) {
        Weekend<ClzCategoryClzzRell> w=super.genSqlExample(t,params);
        WeekendCriteria<ClzCategoryClzzRell,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCzId())){
            c.andEqualTo(ClzCategoryClzzRell::getCzId,t.getCzId());
        }
        if(StringUtils.isNotBlank(t.getCatId())){
            c.andEqualTo(ClzCategoryClzzRell::getCatId,t.getCatId());
        }
        w.and(c);
        return w;
    }

}
