package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionExt;

import java.util.List;
import java.util.Map;

/**
 * @Description: 方案版本
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgSchemeEditionDao extends MybatisBaseDao<CfgSchemeEdition> {
    // 查询使用小程序的版本列表
    List<CfgSchemeEdition> queryApletEditionList(String apltId);

    /**
     * 删除选择的小程序
     * @param schmEdtId
     * @return
     */
    int deleteAplt(String schmEdtId);

    /**
     * 添加选择的小程序
     * @param params
     * schmEdtId
     * apltIds
     * @return
     */
    int insertAplt(Map params);

    List<CfgSchemeEditionExt> queryAllSchemeByCriteriaExt();
}

