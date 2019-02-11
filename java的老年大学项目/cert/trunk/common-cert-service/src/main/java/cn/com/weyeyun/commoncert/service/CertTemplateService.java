package cn.com.weyeyun.commoncert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.weyeyun.commoncert.dao.CertTemplateDao;
import cn.com.weyeyun.commoncert.model.CertTemplate;
import cn.com.weyeyun.commoncert.vo.CertplateGroupVO;
import cn.com.weyeyun.commoncert.vo.CertplateVO;

/**
 * 
 * 证书模板的业务逻辑类.
 * 
 * @author fangyong
 * @version 1.0
 * @since 2012-9-3
 */
@Component
@Transactional
public class CertTemplateService extends CacheEntityService<CertTemplate, Long> {
	@Autowired
	protected CertTemplateDao certTemplateDao;

	/**
	 * 获得对象
	 * 
	 * @author hli
	 * @param id
	 */
	public CertTemplate get(Long id) {
		return certTemplateDao.get(id);
	}

	/**
	 * 搜索是否开启的证书模板
	 * 
	 * @param status
	 * @return
	 */
	public List<CertTemplate> getCertTemplates(boolean status) {
		return certTemplateDao.getCertTemplates(status);
	}

	/**
	 * 保存模板 checked by hbqian at 20150818 service里面不能取得用户，应该用参数传过来其他地方也类似
	 * 
	 * @since 2013-1-31
	 * @see cn.common.lib.springside.service.EntityManager#save(java.lang.Object)
	 */
	@Override
	public void save(CertTemplate certTemplate) {
		super.save(certTemplate);
	}

	/**
	 * 
	 * 批量取消启用
	 * 
	 * @since 2013-1-30
	 * @author fangyong
	 * @param idsList
	 * @return
	 */
	public void cancleUse(List<Long> idsList) {
		certTemplateDao.cancleUse(idsList);
	}

	/**
	 * 
	 * 批量启用
	 * 
	 * @since 2013-1-30
	 * @author fangyong
	 * @param idsList
	 * @return
	 */
	public void batchUse(List<Long> idsList) {
		certTemplateDao.batchUse(idsList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.common.lib.springside.service.EntityManager#getEntityDao()
	 */
	@Override
	protected CertTemplateDao getEntityDao() {
		// TODO Auto-generated method stub
		return certTemplateDao;
	}

	/**
	 * 获取模板集合
	 * 
	 * @author hli
	 * @return
	 * @throws Exception
	 */
	public CertplateGroupVO getCertplateGroup() throws Exception {
		try {
			CertplateGroupVO certplateList = new CertplateGroupVO();
			List<CertTemplate> lists = certTemplateDao.getCertTemplates(true);
			List<CertplateVO> gsv = new ArrayList<CertplateVO>();
			CertplateVO ev = null;
			for (CertTemplate t : lists) {
				ev = new CertplateVO(t.getId(), t.getName());
				gsv.add(ev);
			}
			certplateList.setCerttemplateVOs(gsv);
			return certplateList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CertplateVO getCertplate(Long certtemplateId) throws Exception {
		if (certtemplateId != null) {
			try {
				CertTemplate certTemplate = certTemplateDao.get(certtemplateId);
				CertplateVO ctv = new CertplateVO(Long.valueOf(certtemplateId), certTemplate.getName(), certTemplate.getTextOne(), certTemplate.getTextTwo(), certTemplate.getTextThree(),
						certTemplate.getTextFour(), certTemplate.getTextFive(), certTemplate.getTextSix(), certTemplate.getTextSeven(), certTemplate.getTextEight(), certTemplate.getTextNine(),
						certTemplate.getTextTen(), certTemplate.getTextEleven(), certTemplate.getTextTwelve(), certTemplate.getTextThirteen(), certTemplate.getTextFourteen(),
						certTemplate.getTextFifteen(), certTemplate.getImageUrlOne(), certTemplate.getImageUrlTwo(), certTemplate.getImageUrlThree(), certTemplate.getImageUrlFour(),
						certTemplate.getImageUrlFive());

				return ctv;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
