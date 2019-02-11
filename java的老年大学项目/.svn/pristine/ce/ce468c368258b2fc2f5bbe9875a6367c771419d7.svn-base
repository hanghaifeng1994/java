package com.learnyeai.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resource.model.StdCustLearnResource;
import com.learnyeai.resource.service.StdCustLearnResourceWyService;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("${adminPath}" + StdCustLearnResourceController.BASE_URL)
public class StdCustLearnResourceController extends BaseController<StdCustLearnResource> {
	public static final String BASE_URL = "/StdCustLearnResource/";

	@Autowired
	private StdCustLearnResourceWyService stdCustLearnResourceWyService;

	@Override
	protected BaseService<StdCustLearnResource> getService() {
		return stdCustLearnResourceWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		StdCustLearnResource learnResource = stdCustLearnResourceWyService.convert2Bean(ctx.getParamMap());
		if ("queryResourcePage".equals(method)) {
			String orderType = (String) ctx.getParamMap().get("orderType");
			String resinfo = (String) ctx.getParamMap().get("resinfo");
			return rtnPageList4Report(
					stdCustLearnResourceWyService.queryResourcePage(learnResource, orderType, resinfo));
		}

		if ("queryResources".equals(method)) {
			String orderType = (String) ctx.getParamMap().get("orderType");
			String resinfo = (String) ctx.getParamMap().get("resinfo");
			return stdCustLearnResourceWyService.queryResources(learnResource, orderType, resinfo);
		}

		if ("save".equals(method)) {
			return stdCustLearnResourceWyService.saveOrUpdate(learnResource);
		}

		if ("queryUserPage".equals(method)) {
			return rtnPageList4Report(stdCustLearnResourceWyService.queryUserPage(learnResource));
		}

		return super.execute(ctx);
	}
}
