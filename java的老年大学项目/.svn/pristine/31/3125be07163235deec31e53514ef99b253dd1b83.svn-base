package cn.com.weye.modules.sh.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.sh.entity.ShMerchant;

import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.util.List;

/**
 * @Description: 商户
 * @author yl
 */
@MyBatisDao
public interface ShMerchantDao extends MybatisBaseDao<ShMerchant> {
    int startOrForbiddenUse(ShMerchant entry);

    List<ShMerchant> queryByCriteriaExt(DBQuery params);
}
