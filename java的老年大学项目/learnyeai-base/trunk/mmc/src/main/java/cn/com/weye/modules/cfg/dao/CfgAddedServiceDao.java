package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description: 增值服务
 * @author yl
 */
@MyBatisDao
public interface CfgAddedServiceDao extends MybatisBaseDao<CfgAddedService> {
    List<CfgAddedService> queryByCriteriaExt(DBQuery params);

    BigDecimal asPrice(Map<String,Object> map);

    List<CfgAddedService> queryByOrdId(DBQuery params);
}
