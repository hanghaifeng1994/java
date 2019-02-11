package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackage;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackageExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: 功能包
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgFunctionPackageDao extends MybatisBaseDao<CfgFunctionPackage> {


    /**
     * 条件查询，支持分页
     * @param query
     * @return
     */
    List<CfgFunctionPackageExt> queryByCriteriaExt(DBQuery query);

    /**
     * 删除功能包功能
     * @param pkgId
     * @return
     */
    public int deletePkgFunc(String pkgId);

    /**
     * 插入功能包功能
     *  pkgId
     *  funcIds
     * @return
     */
    public int insertPkgFunc(Map params);

    List<CfgFunctionPackageExt> getPkQueryByOrdId(DBQuery params);

}