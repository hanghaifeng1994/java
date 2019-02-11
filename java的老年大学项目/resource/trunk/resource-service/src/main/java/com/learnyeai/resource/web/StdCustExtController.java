package com.learnyeai.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resource.model.StdCustExt;
import com.learnyeai.resource.service.StdCustExtWyService;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("${adminPath}" + StdCustExtController.BASE_URL)
public class StdCustExtController extends BaseController<StdCustExt> {
	public static final String BASE_URL = "/StdCustExt/";

	@Autowired
	private StdCustExtWyService stdCustExtWyService;

	@Override
	protected BaseService<StdCustExt> getService() {
		return stdCustExtWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		StdCustExt custExt = stdCustExtWyService.convert2Bean(ctx.getParamMap());
		if ("queryByUserId".equals(method)) {
			return stdCustExtWyService.queryByUserId(custExt);
		}
		return super.execute(ctx);
	}
}
