package com.learnyeai.cert.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.learnyeai.cert.api.vo.CtUserCertVo;
import com.learnyeai.cert.mapper.CtUserCertMapper;
import com.learnyeai.cert.model.CtCert;
import com.learnyeai.cert.model.CtUserCert;
import com.learnyeai.cert.util.CertUtil;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.tools.common.BeanHelper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CtUserCertWyService extends WeyeBaseService<CtUserCert> {

	@Resource
	private CtUserCertMapper ctUserCertMapper;
	@Resource
	private CtCertWyService ctCertWyService;

	@Override
	public BaseMapper<CtUserCert> getMapper() {
		return ctUserCertMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(CtUserCert userCert) {
		Map<String, Object> map = new HashMap();
		boolean isNew = false;
		if (StringUtils.isBlank(userCert.getUcId())) {
			userCert.setUcGenTime(new Date());
			if (StringUtils.isBlank(userCert.getUcPubStatus())) {
				userCert.setUcPubStatus("0");
			}
			if (StringUtils.isBlank(userCert.getUcCertNo())) {
				CtCert cert = ctCertWyService.queryById(userCert.getCtId());
				String ucCertNo = generateSn(cert);
				userCert.setUcCertNo(ucCertNo);
				ctCertWyService.save(cert);
			}

			isNew = true;
		}
		super.save(userCert);
		map.put("status", 0);
		map.put("msg", "保存成功!");
		return map;

	}

	/**
	 * 生成证书编号
	 * 
	 * @param year
	 * @return
	 */
	private String generateSn(CtCert cert) {
		long serialNum = this.getNexSerialNum(cert);
		String serial = CertUtil.format(serialNum, 6);
		String certNo = "";
		if (StringUtils.isNotBlank(cert.getCtCode())) {
			certNo += cert.getCtCode();
		}
		certNo = certNo + DateUtils.formatDate(new Date(), "yyyy") + serial;
		return certNo;
	}

	private long getNexSerialNum(CtCert cert) {
		cert.setSerialNum(cert.getSerialNum() + 1);
		return cert.getSerialNum();
	}

	@Transactional
	public Map<String, Object> publish(CtUserCert userCert) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String ucId : userCert.getUcId().split(",")) {
			CtUserCert obj = super.queryById(ucId);
			if (obj != null) {
				obj.setUcPubStatus(userCert.getUcPubStatus());
				obj.setUcPubDate(new Date());
				super.save(obj);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public MyPage<CtUserCert> queryManagePage(CtUserCert userCert) {
		if (userCert != null && userCert.getPage() != null && userCert.getRows() != null) {
			PageHelper.startPage(userCert.getPage(), userCert.getRows());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "ucGenTime=0");
		MyPage<CtUserCert> page = super.queryPage(userCert, params);
		return page;
	}

	@Transactional
	public MyPage<CtUserCert> queryUserPage(CtUserCert userCert) {
		if (userCert != null && userCert.getPage() != null && userCert.getRows() != null) {
			PageHelper.startPage(userCert.getPage(), userCert.getRows());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "ucGenTime=0");
		MyPage<CtUserCert> page = super.queryPage(userCert, params);
		return page;
	}

	@Transactional
	public Map<String, Object> saveUserCertApi(CtUserCertVo uc) {
		Map<String, Object> map = new HashMap();
		if (StringUtils.isBlank(uc.getUcUserId())) {
			map.put("status", 1);
			map.put("msg", "用户id不能为空,生成证书失败!");
			return map;
		}
		if (StringUtils.isBlank(uc.getCtId())) {
			map.put("status", 1);
			map.put("msg", "证书id不能为空,生成证书失败!");
			return map;
		}
		CtUserCert userCert = new CtUserCert();
		userCert.setUcUserId(uc.getUcUserId());
		userCert.setCtId(uc.getCtId());
		userCert = super.queryOne(userCert);
		if (userCert == null) {
			CtCert cert = ctCertWyService.queryById(userCert.getCtId());
			userCert = new CtUserCert();
			userCert.setUcGenTime(new Date());
			userCert.setUcUserId(uc.getUcUserId());
			userCert.setCtId(uc.getCtId());
			userCert.setMchtId(cert.getMchtId());
			userCert.setMchtSchmId(cert.getMchtSchmId());
			if (StringUtils.isBlank(uc.getUcPubStatus())) {
				userCert.setUcPubStatus("0");
			}
			if (StringUtils.isBlank(uc.getUcCertNo())) {
				String ucCertNo = generateSn(cert);
				userCert.setUcCertNo(ucCertNo);
				ctCertWyService.save(cert);
			}
		}
		BeanHelper.copy(uc, userCert);
		super.save(userCert);
		map.put("ucId", userCert.getUcId());
		map.put("status", 0);
		map.put("msg", "生成证书成功.");
		return map;
	}

	@Override
	protected Weekend<CtUserCert> genSqlExample(CtUserCert t, Map params) {
		Weekend<CtUserCert> w = super.genSqlExample(t, params);
		WeekendCriteria<CtUserCert, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getUcUserId())) {
			c.andEqualTo(CtUserCert::getUcUserId, t.getUcUserId());
		}
		if (StringUtils.isNotBlank(t.getCtId())) {
			c.andEqualTo(CtUserCert::getCtId, t.getCtId());
		}
		if (StringUtils.isNotBlank(t.getUcPubStatus())) {
			c.andEqualTo(CtUserCert::getUcPubStatus, t.getUcPubStatus());
		}
		if (StringUtils.isNotBlank(t.getUcIdcard())) {
			c.andLike(CtUserCert::getUcIdcard, "%" + t.getUcIdcard() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcName())) {
			c.andLike(CtUserCert::getUcName, "%" + t.getUcName() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcUnit())) {
			c.andLike(CtUserCert::getUcUnit, "%" + t.getUcUnit() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcProgram())) {
			c.andLike(CtUserCert::getUcProgram, "%" + t.getUcProgram() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcYear())) {
			c.andLike(CtUserCert::getUcYear, "%" + t.getUcYear() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcCertName())) {
			c.andLike(CtUserCert::getUcCertName, "%" + t.getUcCertName() + "%");
		}
		if (StringUtils.isNotBlank(t.getUcCertNo())) {
			c.andLike(CtUserCert::getUcCertNo, "%" + t.getUcCertNo() + "%");
		}
		if (t.getSiteIds() != null) {
			c.andIn(CtUserCert::getSiteId, t.getSiteIds());
		}
		w.and(c);
		return w;
	}

}
