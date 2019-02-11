package cn.com.weyeyun.commoncert.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import cn.com.weyeyun.commoncert.core.CertTemplateManager;
import cn.com.weyeyun.commoncert.dto.CertTemplateDTO;
import cn.com.weyeyun.commoncert.vo.CertplateGroupVO;
import cn.com.weyeyun.commoncert.vo.CertplateVO;
import cn.common.lib.springside.orm.page.ExtPage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RestController
@RequestMapping(value = "/cert/certtemplate")
public class CerttemplateController {
	@Autowired
	private CertTemplateManager certTemplateManager;

	@RequestMapping("/manage/save")
	public Object save(CertTemplateDTO certTemplate) {
		certTemplateManager.save(certTemplate);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/list")
	public Object list(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, String name, Boolean status) {
		Page<CertTemplateDTO> page = new ExtPage<CertTemplateDTO>(20);
		page.setPageNo(pageNo);
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.DESC);
		}
		List<PropertyFilter> filters = Lists.newArrayList();
		if (StringUtils.isNotBlank(name)) {
			name = name.trim();
			filters.add(new PropertyFilter("LIKES_name", name));
		}
		if (status != null) {
			filters.add(new PropertyFilter("EQB_status", status + ""));
		}
		page = certTemplateManager.search(page, filters);
		JSONObject result = JSONObject.fromObject(page);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/info")
	public Object info(long id) {
		CertTemplateDTO certTemplate = certTemplateManager.get(id);
		JSONObject result = JSONObject.fromObject(certTemplate);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/singleViewPrint")
	public String singleViewPrint(Long id) {
		CertTemplateDTO certTemplate = certTemplateManager.get(id);
		Map<String, String> map = Maps.newHashMap();
		map.put("imageUrl", certTemplate.getImageName());
		map.put("subject", certTemplate.getSubject());
		JSONObject result = JSONObject.fromObject(map);
		return "successCallback(" + result.toString() + ")";
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
	@RequestMapping("/manage/cancleUse")
	public Object cancleUse(Long[] ids) {
		List<Long> idList = Arrays.asList(ids);
		if (idList != null && idList.size() > 0) {
			certTemplateManager.cancleUse(idList);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
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
	@RequestMapping("/manage/batchUse")
	public Object batchUse(Long[] ids) {
		List<Long> idList = Arrays.asList(ids);
		if (idList != null && idList.size() > 0) {
			certTemplateManager.batchUse(idList);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/all")
	public Object all() throws Exception {
		List<CertplateVO> certtemplateVOs = new ArrayList<CertplateVO>();
		// 模板相关
		CertplateGroupVO gvs = certTemplateManager.getCertplateGroup();
		if (gvs != null) {
			certtemplateVOs = gvs.getCerttemplateVOs();
		}
		JSONObject result = JSONObject.fromObject(gvs);
		return "successCallback(" + result.toString() + ")";
	}

	@RequestMapping("/manage/ajaxCertplateText")
	public String ajaxCertplateText(Long certtemplateId) throws Exception {
		CertplateVO cvo = certTemplateManager.getCertplate(certtemplateId);
		if (cvo != null) {
			Map<String, String> map = Maps.newHashMap();
			map.put("textOne", cvo.getTextOne());
			map.put("textTwo", cvo.getTextTwo());
			map.put("textThree", cvo.getTextThree());
			map.put("textFour", cvo.getTextFour());
			map.put("textFive", cvo.getTextFive());
			map.put("textSix", cvo.getTextSix());
			map.put("textSeven", cvo.getTextSeven());
			map.put("textEight", cvo.getTextEight());
			map.put("textNine", cvo.getTextNine());
			map.put("textTen", cvo.getTextTen());
			map.put("textEleven", cvo.getTextEleven());
			map.put("textTwelve", cvo.getTextTwelve());
			map.put("textThirteen", cvo.getTextThirteen());
			map.put("textFourteen", cvo.getTextFourteen());
			map.put("textFifteen", cvo.getTextFifteen());

			map.put("imageOne", cvo.getImageOne());
			map.put("imageTwo", cvo.getImageTwo());
			map.put("imageThree", cvo.getImageThree());
			map.put("imageFour", cvo.getImageFour());
			map.put("imageFive", cvo.getImageFive());
			JSONObject result = JSONObject.fromObject(map);
			return "successCallback(" + result.toString() + ")";
		}
		return "successCallback()";
	}
}
