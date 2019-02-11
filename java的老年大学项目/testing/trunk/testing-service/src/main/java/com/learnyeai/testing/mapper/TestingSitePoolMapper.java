package com.learnyeai.testing.mapper;

import com.learnyeai.testing.model.TestingSitePool;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 将平台下面的题库自动下发到所有平台的站点。如果创建题库是选择了主站id，那么只自动下放到本平台其他子站。
 * @author twang
 */
@MyBatisDao
public interface TestingSitePoolMapper extends BaseMapper<TestingSitePool> {
}
