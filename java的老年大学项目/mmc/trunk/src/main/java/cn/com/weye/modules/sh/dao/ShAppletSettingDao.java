package cn.com.weye.modules.sh.dao;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.sh.entity.ShAppletSetting;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.sh.entity.ShAppletSettingExt;

import java.util.List;
import java.util.Map;

/**
 * @Description: 小程序配置
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface ShAppletSettingDao extends MybatisBaseDao<ShAppletSetting> {
    // 查询小程序商户代码列表
    List<Map> queryCodeList(Map params);

    List<ShAppletSettingExt> queryByCriteriaExt(DBQuery query);
}
