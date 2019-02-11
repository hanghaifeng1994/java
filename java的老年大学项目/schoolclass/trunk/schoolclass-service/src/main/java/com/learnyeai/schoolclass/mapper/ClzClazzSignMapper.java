package com.learnyeai.schoolclass.mapper;

import com.learnyeai.schoolclass.model.ClzClazzSign;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Description: 
 * @author twang
 */
@MyBatisDao
public interface ClzClazzSignMapper extends BaseMapper<ClzClazzSign> {

    List<Map<String,Object>> getPersent(ClzClazzSign sign);
}
