package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgAppletVersion;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.vo.CfgAppletVersionVo;

import java.util.List;

/**
 * @Description: 小程序版本
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgAppletVersionDao extends MybatisBaseDao<CfgAppletVersion> {

    /**
     * 查询方案上程序版本，包括方案版本名称、小程序名称
     * @param query
     * @return
     */
    List<CfgAppletVersionVo> queryByCriteriaExt(DBQuery query);
}
