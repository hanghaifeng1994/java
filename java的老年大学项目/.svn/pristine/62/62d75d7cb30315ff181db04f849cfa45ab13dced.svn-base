package cn.com.weyeyun.commoncert.web;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.orm.Page;

import cn.com.weyeyun.commoncert.core.CertManager;
import cn.com.weyeyun.commoncert.core.CertTemplateManager;
import cn.com.weyeyun.commoncert.dto.CertDTO;
import cn.com.weyeyun.commoncert.model.Cert;
import cn.common.lib.springside.orm.ExtPropertyFilter;
import cn.common.lib.springside.orm.page.ExtPage;

import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/cert/certoffline")
public class CertofflineController {
	@Autowired
	private CertTemplateManager certTemplateManager;

	@Autowired
	private CertManager certManager;

	@RequestMapping("/manage/save")
	public Object save(CertDTO cert, String selTextOne, String selTextTwo, String selTextThree, String selTextFour, String selTextFive, String selTextSix, String selTextSeven, String selTextEight,
			String selTextNine, String selTextTen, String selTextEleven, String selTextTwelve, String selTextThirteen, String selTextFourteen, String selTextFifteen, String selImageOne,
			String selImageTwo, String selImageThree, String selImageFour, String selImageFive) {
		String templateText = "";
		if (StringUtils.isNotBlank(selTextOne)) {
			templateText += ";" + selTextOne;
		}
		if (StringUtils.isNotBlank(selTextTwo)) {
			templateText += ";" + selTextTwo;
		}
		if (StringUtils.isNotBlank(selTextThree)) {
			templateText += ";" + selTextThree;
		}
		if (StringUtils.isNotBlank(selTextFour)) {
			templateText += ";" + selTextFour;
		}
		if (StringUtils.isNotBlank(selTextFive)) {
			templateText += ";" + selTextFive;
		}
		if (StringUtils.isNotBlank(selTextSix)) {
			templateText += ";" + selTextSix;
		}
		if (StringUtils.isNotBlank(selTextSeven)) {
			templateText += ";" + selTextSeven;
		}
		if (StringUtils.isNotBlank(selTextEight)) {
			templateText += ";" + selTextEight;
		}
		if (StringUtils.isNotBlank(selTextNine)) {
			templateText += ";" + selTextNine;
		}
		if (StringUtils.isNotBlank(selTextTen)) {
			templateText += ";" + selTextTen;
		}
		if (StringUtils.isNotBlank(selTextEleven)) {
			templateText += ";" + selTextEleven;
		}
		if (StringUtils.isNotBlank(selTextTwelve)) {
			templateText += ";" + selTextTwelve;
		}
		if (StringUtils.isNotBlank(selTextThirteen)) {
			templateText += ";" + selTextThirteen;
		}
		if (StringUtils.isNotBlank(selTextFourteen)) {
			templateText += ";" + selTextFourteen;
		}
		if (StringUtils.isNotBlank(selTextFifteen)) {
			templateText += ";" + selTextFifteen;
		}
		if (StringUtils.isNotBlank(templateText)) {
			cert.setTemplateText(templateText.substring(1));
		}

		String templateImage = "";
		if (StringUtils.isNotBlank(selImageOne)) {
			templateImage += ";" + selImageOne;
		}
		if (StringUtils.isNotBlank(selImageTwo)) {
			templateImage += ";" + selImageTwo;
		}
		if (StringUtils.isNotBlank(selImageThree)) {
			templateImage += ";" + selImageThree;
		}
		if (StringUtils.isNotBlank(selImageFour)) {
			templateImage += ";" + selImageFour;
		}
		if (StringUtils.isNotBlank(selImageFive)) {
			templateImage += ";" + selImageFive;
		}
		if (StringUtils.isNotBlank(templateImage)) {
			cert.setTemplateImage(templateImage.substring(1));
		}

		certManager.save(cert);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/list")
	public Object list(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, String name, Boolean status) {
		Page<CertDTO> page = new ExtPage<CertDTO>(20);
		page.setPageNo(pageNo);
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.DESC);
		}
		List<ExtPropertyFilter> filters = Lists.newArrayList();
		filters.add(new ExtPropertyFilter("EQI_certType", "1"));
		page = this.certManager.extSearch(page, filters);
		JSONObject result = JSONObject.fromObject(page);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/info")
	public Object info(long id) {
		CertDTO cert = certManager.get(id);
		JSONObject result = JSONObject.fromObject(cert);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/del")
	public Object delete(Long[] ids) {
		for (Long id : ids) {
			certManager.delete(id);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}
	
	@RequestMapping("/manage/certlist")
	public Object certlist() {
		List<CertDTO> certs = this.certManager.getCertByType(Cert.CERT_OFFLINE, null);
		JSONArray result = JSONArray.fromObject(certs);
		return "successCallback(" + result.toString() + ")";
	}
	

}
