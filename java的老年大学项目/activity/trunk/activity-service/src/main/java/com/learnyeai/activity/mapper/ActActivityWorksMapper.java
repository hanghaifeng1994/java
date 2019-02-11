package com.learnyeai.activity.mapper;

import com.learnyeai.activity.model.ActActivityWorks;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 活动作品
 * @author yl
 */
@MyBatisDao
public interface ActActivityWorksMapper extends BaseMapper<ActActivityWorks> {
    String getMaxCode(ActActivityWorks works);
}
