package com.learnyeai.schoolclass.mapper;

import com.learnyeai.schoolclass.model.ClzSiteClazz;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 站点-班级
 * @author twang
 */
@MyBatisDao
public interface ClzSiteClazzMapper extends BaseMapper<ClzSiteClazz> {
    int deleteByCzId(String id);
}
