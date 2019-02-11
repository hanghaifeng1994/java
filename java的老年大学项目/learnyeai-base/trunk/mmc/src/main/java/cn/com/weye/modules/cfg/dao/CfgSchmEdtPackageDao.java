package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionPrice;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackage;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackageExt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description: 方案版本功能包
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgSchmEdtPackageDao extends MybatisBaseDao<CfgSchmEdtPackage> {
    /**
     * 包含功能包名称、模块名称
     * @param params
     * @return
     */
    List<CfgSchmEdtPackageExt> queryByCriteriaExt(DBQuery params);

    /**
     * 查询方案版本对应模块所有功能包
     * @param schmEdtId
     * @return
     */
    List<CfgSchmEdtPackageExt> querySchmEditFuncPkg(String schmEdtId);

    /**
     * 查询方案版本未选的功能包
     * @param params
     * schmId
     * schmEdtId
     * @return
     */
    List<CfgSchmEdtPackageExt> querySchmEdtUnSelPkg(Map params);

    List<Map<String,Object>> getPackageList(String schmEdtId);

    BigDecimal getPkPrice(Map<String,Object> map);

}
