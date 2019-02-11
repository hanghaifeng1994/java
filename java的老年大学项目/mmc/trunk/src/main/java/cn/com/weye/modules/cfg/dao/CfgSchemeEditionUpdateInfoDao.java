package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionUpdateInfo;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.vo.CfgSchemeEditionUpdateInfoVo;

import java.util.List;

/**
 * @Description: 方案版本升级信息
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgSchemeEditionUpdateInfoDao extends MybatisBaseDao<CfgSchemeEditionUpdateInfo> {
    /**
     * 查询方案版本升级信息，包括方案版本名称
     * @param query
     * @return
     */
    List<CfgSchemeEditionUpdateInfoVo> queryByCriteriaExt(DBQuery query);
}
