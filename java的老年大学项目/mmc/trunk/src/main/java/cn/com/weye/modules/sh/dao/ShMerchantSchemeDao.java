package cn.com.weye.modules.sh.dao;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.sh.entity.ShMerchant;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.modules.sh.entity.ShMerchantSchemeExt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description: 商户
 * @author yl
 */
@MyBatisDao
public interface ShMerchantSchemeDao extends MybatisBaseDao<ShMerchantScheme> {
    List<ShMerchantScheme> queryCodeList(Map<String,Object> map);

    int startOrForbiddenUse(ShMerchantScheme shMerchantScheme);

    List<Map<String ,Object>> getEditionList(String schmEdtId);

    List<ShMerchantSchemeExt> queryByCriteriaExt(DBQuery q);
}
