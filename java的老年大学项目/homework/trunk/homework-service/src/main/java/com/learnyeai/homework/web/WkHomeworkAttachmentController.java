package com.learnyeai.homework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.homework.model.WkHomeworkAttachment;
import com.learnyeai.homework.service.WkHomeworkAttachmentWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + WkHomeworkAttachmentController.BASE_URL)
public class WkHomeworkAttachmentController extends BaseController<WkHomeworkAttachment> {
	public static final String BASE_URL = "/WkHomeworkAttachment/";

	@Autowired
	private WkHomeworkAttachmentWyService wkHomeworkAttachmentWyService;

	@Override
	protected BaseService<WkHomeworkAttachment> getService() {
		return wkHomeworkAttachmentWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		WkHomeworkAttachment atm = wkHomeworkAttachmentWyService.convert2Bean(ctx.getParamMap());
		if ("save".equals(method)) {
			// 根据parentId 查询出所有父类id
			return wkHomeworkAttachmentWyService.saveOrUpdate(atm);
		}

		if ("deleteById".equals(method)) {
			return wkHomeworkAttachmentWyService.deleteAtm(atm);
		}
		
		if ("queryById".equals(method)) {
			return wkHomeworkAttachmentWyService.queryById(atm.getAtmId());
		}

		return super.execute(ctx);
	}
}
