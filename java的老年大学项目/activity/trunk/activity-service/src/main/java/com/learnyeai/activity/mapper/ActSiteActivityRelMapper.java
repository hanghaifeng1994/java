package com.learnyeai.activity.mapper;

import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.model.ActActivityExt;
import com.learnyeai.activity.model.ActSiteActivityRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Description: 站点-活动
 * @author yl
 */
@MyBatisDao
public interface ActSiteActivityRelMapper extends BaseMapper<ActSiteActivityRel> {
    int deleteBySiteIdAndActId(ActActivity actActivity);

    int updateBySelective(ActSiteActivityRel asar);

    List<ActSiteActivityRel> queryPageByUse(Map<String,Object> map);
}
