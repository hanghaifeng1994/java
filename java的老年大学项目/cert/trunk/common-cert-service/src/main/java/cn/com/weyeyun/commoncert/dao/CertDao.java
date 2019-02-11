package cn.com.weyeyun.commoncert.dao;

import org.springframework.stereotype.Component;

import cn.com.weyeyun.commoncert.model.Cert;
import cn.common.lib.springside.orm.BaseDao;
import cn.common.lib.springside.orm.BaseHibernateDao;

/**
 * 
 * 好友数据访问类
 * 
 * @author zhaowei
 * @version 1.0
 * @since 2012-11-26
 */
@Component
public class CertDao extends BaseHibernateDao<Cert, Long> implements BaseDao<Cert, Long> {

}
