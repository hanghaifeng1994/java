package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgScheme;

import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Description: 行业方案
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgSchemeDao extends MybatisBaseDao<CfgScheme> {
    /**
     * 删除方案的模块
     * @param id
     * @return
     */
    public int deleteSchmMdl(String id);

    /**
     * 添加方案模块
     * @param params
     *  SCHM_ID 方案id
     *  idList 模块列表
     * @return
     */
    public int insertSchmMdl(Map params);

    /**
     * 更新方案模块排序
     * @param params
     * schmId
     * mdlId
     * sort
     */
    public int updateSchemeMdlSort(Map params);

    /**
     * 删除方案模块
     * @param params
     * schmId
     * mdlId
     * @return
     */
    public int delSchemeMdl(Map params);

    public int countSchemeEdtMdl(Map params);
}
