package cn.com.weye.modules.sh.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.sh.entity.ShOrder;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.sh.entity.ShOrderExt;

import java.util.List;

/**
 * @Description: 商户订单
 * @author yl
 */
@MyBatisDao
public interface ShOrderDao extends MybatisBaseDao<ShOrder> {
    List<ShOrderExt> queryByCriteriaExt(DBQuery dbQuery);
}
