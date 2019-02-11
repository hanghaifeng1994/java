package cn.com.weyeyun.commoncert.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import cn.com.weyeyun.commoncert.dto.CertTemplateDTO;
import cn.com.weyeyun.commoncert.model.CertTemplate;
import cn.com.weyeyun.commoncert.service.CertTemplateService;
import cn.com.weyeyun.commoncert.util.BeanUtil;
import cn.com.weyeyun.commoncert.vo.CertplateGroupVO;
import cn.com.weyeyun.commoncert.vo.CertplateVO;
import cn.common.lib.springside.orm.page.ExtPage;

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
public class CertTemplateManager {
	@Autowired
	private CertTemplateService certTemplateService;

	public CertTemplate convertDTOToEntity(CertTemplateDTO certTemplateDTO) {
		CertTemplate certTemplate = null;
		if (certTemplateDTO.getId() == null)
			certTemplate = new CertTemplate();
		else
			certTemplate = certTemplateService.get(certTemplateDTO.getId());
		BeanUtil.copyProperties(certTemplate, certTemplateDTO);
		return certTemplate;
	}

	/**
	 * @author sli
	 * @param CertTemplate
	 * @return
	 */
	public CertTemplateDTO convertEntityToDTO(CertTemplate certTemplate) {
		CertTemplateDTO certTemplateDTO = new CertTemplateDTO();
		BeanUtil.copyProperties(certTemplateDTO, certTemplate);
		return certTemplateDTO;
	}

	public List<CertTemplateDTO> convertListToDTO(List<CertTemplate> certTemplates) {
		List<CertTemplateDTO> certTemplateDTOs = new ArrayList<CertTemplateDTO>();
		for (CertTemplate certTemplate : certTemplates) {
			certTemplateDTOs.add(convertEntityToDTO(certTemplate));
		}
		return certTemplateDTOs;
	}

	@SuppressWarnings({ "unchecked" })
	public Page convertPageToDTO(Page desc, Page orig) {
		if (orig == null) {
			return null;
		}
		try {
			// desc = orig;
			BeanUtil.copyProperties(desc, orig);
			List list = orig.getResult();
			List listDTO = new ArrayList();
			listDTO = convertListToDTO(list);
			desc.setResult(listDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}

	/**
	 * pageDTO转换为page
	 * 
	 * @param page
	 * @return
	 */
	public Page<CertTemplate> convertDTOToPage(Page<CertTemplateDTO> page) {
		Page<CertTemplate> page2 = new ExtPage<CertTemplate>(page.getPageSize());
		convertPageToDTO(page2, page);
		return page2;
	}

	/**
	 * 获得对象dto
	 * 
	 * @author hli
	 * @param id
	 */
	public CertTemplateDTO get(Long id) {
		return convertEntityToDTO(certTemplateService.get(id));
	}

	/**
	 * 分页数据
	 * 
	 * @author hli
	 * @param page
	 * @param filters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<CertTemplateDTO> search(Page<CertTemplateDTO> page, List<PropertyFilter> filters) {
		return convertPageToDTO(page, certTemplateService.search(convertDTOToPage(page), filters));
	}

	/**
	 * 搜索是否开启的证书模板
	 * 
	 * @author hli
	 * @param status
	 * @return
	 */
	public List<CertTemplateDTO> getCertTemplates(boolean status) {
		return convertListToDTO(certTemplateService.getCertTemplates(status));
	}

	/**
	 * 保存模板
	 * 
	 * @since 2013-1-31
	 * @see cn.common.lib.springside.service.EntityManager#save(java.lang.Object)
	 */
	public void save(CertTemplateDTO certTemplateTemplate) {
		certTemplateService.save(convertDTOToEntity(certTemplateTemplate));
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
		certTemplateService.cancleUse(idsList);
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
		certTemplateService.batchUse(idsList);
	}

	/**
	 * 获取模板集合
	 * 
	 * @author hli
	 * @return
	 * @throws Exception
	 */
	public CertplateGroupVO getCertplateGroup() throws Exception {
		return certTemplateService.getCertplateGroup();
	}

	public CertplateVO getCertplate(Long certtemplateId) throws Exception {
		return certTemplateService.getCertplate(certtemplateId);
	}
}
