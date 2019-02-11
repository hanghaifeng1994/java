package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionPrice;
import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description: 方案版本价格
 * @author yl.com
 */
@MyBatisDao
public interface CfgSchemeEditionPriceDao extends MybatisBaseDao<CfgSchemeEditionPrice> {

    /**
     * 通过版本号查询所有的版本价格
     * @param schmEdtId
     * @return
     */
    List<CfgSchemeEditionPrice> queryPriceListById(String schmEdtId);

    Integer getIsUsing(Map<String,Object> map);

    void forbidden(Map<String,Object> map);

    void startUse(Map<String,Object> map);

    BigDecimal getEdtPrice(Map<String,Object> map);
}
