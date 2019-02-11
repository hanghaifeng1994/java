package cn.com.weyeyun.commoncert.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.com.weyeyun.commoncert.dto.CertDTO;
import cn.com.weyeyun.commoncert.model.Cert;
import cn.com.weyeyun.commoncert.model.CertTemplate;
import cn.com.weyeyun.commoncert.service.CertService;
import cn.com.weyeyun.commoncert.service.CertTemplateService;
import cn.com.weyeyun.commoncert.util.BeanUtil;
import cn.common.lib.springside.orm.ExtPropertyFilter;
import cn.common.lib.springside.orm.page.ExtPage;

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
public class CertManager {
	@Autowired
	private CertService certService;
	@Autowired
	private CertTemplateService certTemplateService;

	public Cert convertDTOToEntity(CertDTO certDTO) {
		Cert cert = null;
		CertTemplate certTemplate = null;
		if (certDTO.getId() == null)
			cert = new Cert();
		else
			cert = certService.get(certDTO.getId());
		BeanUtil.copyProperties(cert, certDTO);
		if (certDTO.getCerttemplateId() != null)
			certTemplate = certTemplateService.get(certDTO.getCerttemplateId());
		cert.setCertTemplate(certTemplate);
		return cert;
	}

	/**
	 * @author sli
	 * @param cert
	 * @return
	 */
	public CertDTO convertEntityToDTO(Cert cert) {
		CertDTO certDTO = new CertDTO();
		BeanUtil.copyProperties(certDTO, cert);
		CertTemplate ct = cert.getCertTemplate();
		if (ct != null) {
			certDTO.setCerttemplateId(ct.getId());
			certDTO.setCertTemplateName(ct.getName());
		}
		if (cert.getTenantId() != null) {
			certDTO.setTenantId(cert.getTenantId());
		} else
			certDTO.setTenantName("大平台");
		return certDTO;
	}

	public List<CertDTO> convertListToDTO(List<Cert> certs) {
		List<CertDTO> certDTOs = new ArrayList<CertDTO>();
		for (Cert cert : certs) {
			certDTOs.add(convertEntityToDTO(cert));
		}
		return certDTOs;
	}

	@SuppressWarnings({ "unchecked" })
	public Page convertPageToDTO(Page desc, Page orig) {
		if (orig == null) {
			return null;
		}
		try {
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
	public Page<Cert> convertDTOToPage(Page<CertDTO> page) {
		Page<Cert> page2 = new ExtPage<Cert>(page.getPageSize());
		page2.setOrder(page.getOrder());
		page2.setOrderBy(page.getOrderBy());
		page2.setPageNo(page.getPageNo());
		return page2;
	}

	@SuppressWarnings("unchecked")
	public Page<CertDTO> extSearch(Page<CertDTO> page, List<ExtPropertyFilter> filters) {
		return convertPageToDTO(page, certService.extSearch(convertDTOToPage(page), filters));
	}

	/**
	 * 根据id取得DTO
	 * 
	 * @param id
	 * @return
	 */
	public CertDTO get(Long id) {
		return convertEntityToDTO(certService.get(id));
	}

	/**
	 * 保存
	 * 
	 * @param certDTO
	 */
	public void save(CertDTO certDTO) {
		certService.save(convertDTOToEntity(certDTO));
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		certService.delete(id);
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
		return certService.isNameUnique(newName, oldName);
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
		return certService.isSerialNoUnique(newSerialNo, oldSerialNo);
	}

	/**
	 * 更加地区取得其证书
	 * 
	 * @param tenantId
	 * @return
	 */
	public List<CertDTO> getAll(Long tenantId) {
		return convertListToDTO(certService.getAll(tenantId));
	}

	public List<CertDTO> getCertByType(int certType, Long tenantId) {
		return convertListToDTO(certService.getCertByType(certType, tenantId));
	}
}