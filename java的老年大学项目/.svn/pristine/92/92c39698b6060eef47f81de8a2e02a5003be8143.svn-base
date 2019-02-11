package cn.com.weyeyun.commoncert.dao;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;

import cn.com.weyeyun.commoncert.model.UserCertOffline;
import cn.common.lib.springside.orm.BaseDao;
import cn.common.lib.springside.orm.BaseHibernateDao;

@Component
public class UserCertOfflineDao extends BaseHibernateDao<UserCertOffline, Long> implements BaseDao<UserCertOffline, Long> {

	/**
	 * 获得对象
	 * 
	 * @author hli
	 * @param id
	 * @return
	 */
	public UserCertOffline get(Long id) {
		return this.findUniqueBy("id", id);
	}

	/**
	 * 删除
	 * 
	 * @author hli
	 * @param id
	 */
	public void delete(Long id) {
		this.batchExecute("delete UserCertOffline where id=?", id);
	}

	public void batchPrintStatus(String usercertids, boolean printed) {
		String hql = "update UserCertOffline uc set uc.printed = ? where uc.id in (" + usercertids + ")";
		super.batchExecute(hql, true);
	}

	public void updateSqlQuery(String sql) {
		SQLQuery sqlq = this.getSession().createSQLQuery(sql);
		sqlq.executeUpdate();
	}

	public long getUserCertCount(boolean published,Long tenantId,Long userId) {
		String hql = "from UserCertOffline where published=? ";
		if(userId!=null){
			hql += " and userId = " + userId;
		}
		if(tenantId!=null){
			hql += " and tenantId = " + tenantId;
		} 
		
		return super.countHqlResult(hql, published);
	}
}
