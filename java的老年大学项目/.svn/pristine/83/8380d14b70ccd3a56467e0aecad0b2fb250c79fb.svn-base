package cn.com.weyeyun.commoncert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.com.weyeyun.commoncert.dao.CertDao;
import cn.com.weyeyun.commoncert.model.Cert;
import cn.common.lib.springside.orm.ExtPropertyFilter;

/**
 * 
 * 通过rmi待用webchat接口取得好友的业务
 * 
 * @author zhaowei
 * @version 1.0
 * @param <T>
 * @since 2010-11-2
 */

@Component
@Transactional
public class CertService extends CacheEntityService<Cert, Long> {
	@Autowired
	private CertDao certDao;

	@Override
	protected CertDao getEntityDao() {
		return certDao;
	}

	/**
	 * 
	 * 判断证书名称是否唯一
	 * 
	 * @since 2012-6-8
	 * @author qingang
	 * @param newName
	 *            新名称
	 * @param oldName
	 *            旧名称
	 * @return
	 */
	@Transactional(readOnly = true)
	public Boolean isNameUnique(String newName, String oldName) {
		return certDao.isPropertyUnique("name", newName, oldName);
	}

	/**
	 * 分页数据
	 * 
	 * @author hli
	 * @param page
	 * @param filters
	 * @return
	 */
	public Page<Cert> extSearch(Page<Cert> page, List<ExtPropertyFilter> filters) {
		return certDao.extFindPage(page, filters);
	}

	/**
	 * 
	 * 判断证书编号是否唯一
	 * 
	 * @since 2012-6-8
	 * @author qingang
	 * @param newSerialNo
	 *            新证书编号
	 * @param oldSerialNo
	 *            旧证书编号
	 * @return
	 */
	@Transactional(readOnly = true)
	public Boolean isSerialNoUnique(String newSerialNo, String oldSerialNo) {
		return certDao.isPropertyUnique("code", newSerialNo, oldSerialNo);
	}

	/**
	 * 更加地区取得其证书
	 * 
	 * @param tenantId
	 * @return
	 */
	public List<Cert> getAll(Long tenantId) {
		if (tenantId == null) {
			return certDao.find("from Cert where tenantId is null ");
		} else {
			return certDao.find("from Cert where tenantId=?", tenantId);
		}
	}

	public List<Cert> getCertByType(int certType, Long tenantId) {
		String hql = "from Cert where 1=1 and certType = " + certType;
		if (tenantId == null) {
			hql += " and tenantId is null";
		} else {
			hql += " and tenantId =" + tenantId;
		}
		return certDao.find(hql);
	}
}