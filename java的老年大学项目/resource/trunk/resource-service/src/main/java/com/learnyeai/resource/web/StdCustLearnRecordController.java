package com.learnyeai.resource.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resource.model.StdCustLearnRecord;
import com.learnyeai.resource.service.StdCustLearnRecordWyService;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("${adminPath}" + StdCustLearnRecordController.BASE_URL)
public class StdCustLearnRecordController extends BaseController<StdCustLearnRecord> {
	public static final String BASE_URL = "/StdCustLearnRecord/";

	@Autowired
	private StdCustLearnRecordWyService stdCustLearnRecordWyService;

	@Override
	protected BaseService<StdCustLearnRecord> getService() {
		return stdCustLearnRecordWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		StdCustLearnRecord learnRecord = stdCustLearnRecordWyService.convert2Bean(ctx.getParamMap());
		if ("learnSave".equals(method)) {
			return stdCustLearnRecordWyService.learnSave(learnRecord);
		}

		if ("queryPage".equals(method)) {
			Map<String, String> params = Maps.newHashMap();
			params.put("sorts", "startDate=1");
			return rtnPageList4Report(stdCustLearnRecordWyService.queryPage(learnRecord, params));
		}

		return super.execute(ctx);
	}
}
