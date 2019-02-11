package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgModule;

import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Description: 模块
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgModuleDao extends MybatisBaseDao<CfgModule> {

    /**
     * 根据方案查询模块
     * @param schmId
     * @return
     */
    List<Map> queryBySchmId(String schmId);

    /**
     * 查询方案未选中的模块
     * @param schmId
     * @return
     */
    List<CfgModule> queryUnSelMdlBySchmId(String schmId);
}
