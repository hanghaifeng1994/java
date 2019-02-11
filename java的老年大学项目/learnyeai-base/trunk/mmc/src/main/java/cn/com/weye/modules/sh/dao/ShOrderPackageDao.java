package cn.com.weye.modules.sh.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.sh.entity.ShOrderPackage;

import cn.com.weye.core.persistence.annotation.MyBatisDao;

import java.util.List;

/**
 * @Description: 订单功能包
 * @author yl
 */
@MyBatisDao
public interface ShOrderPackageDao extends MybatisBaseDao<ShOrderPackage> {
}
