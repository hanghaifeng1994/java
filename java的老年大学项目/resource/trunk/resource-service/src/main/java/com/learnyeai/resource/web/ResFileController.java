package com.learnyeai.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resource.model.ResFile;
import com.learnyeai.resource.service.ResFileWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ResFileController.BASE_URL)
public class ResFileController extends BaseController<ResFile> {
	public static final String BASE_URL = "/ResFile/";

	@Autowired
	private ResFileWyService resFileWyService;

	@Override
	protected BaseService<ResFile> getService() {
		return resFileWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		ResFile rf = resFileWyService.convert2Bean(ctx.getParamMap());
		if ("save".equals(method)) {
			// 根据parentId 查询出所有父类id
			return resFileWyService.saveOrUpdate(rf);
		}

		if ("deleteById".equals(method)) {
			return resFileWyService.deleteResFile(rf);
		}

		if ("detail".equals(method)) {
			return resFileWyService.queryById(rf.getResFielId());
		}
		return super.execute(ctx);
	}
}
