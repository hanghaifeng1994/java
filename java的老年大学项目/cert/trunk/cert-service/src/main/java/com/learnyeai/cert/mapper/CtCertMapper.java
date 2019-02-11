package com.learnyeai.cert.mapper;

import java.util.List;

import com.learnyeai.cert.model.CtCert;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

/**
 * @Description: 证书
 * @author twang
 */
@MyBatisDao
public interface CtCertMapper extends BaseMapper<CtCert> {

	public List<CtCert> queryManagePage(CtCert cert);

	public List<CtCert> queryShowPage(CtCert cert);

	public List<CtCert> queryMainPage(CtCert cert);
}
