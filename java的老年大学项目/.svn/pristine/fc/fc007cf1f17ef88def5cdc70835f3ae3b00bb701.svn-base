package com.learnyeai.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resource.model.StdStudyObjectStatistics;
import com.learnyeai.resource.service.StdStudyObjectStatisticsWyService;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("${adminPath}" + StdStudyObjectStatisticsController.BASE_URL)
public class StdStudyObjectStatisticsController extends BaseController<StdStudyObjectStatistics> {
	public static final String BASE_URL = "/StdStudyObjectStatistics/";

	@Autowired
	private StdStudyObjectStatisticsWyService stdStudyObjectStatisticsWyService;

	@Override
	protected BaseService<StdStudyObjectStatistics> getService() {
		return stdStudyObjectStatisticsWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		StdStudyObjectStatistics os = stdStudyObjectStatisticsWyService.convert2Bean(ctx.getParamMap());
		if ("queryByResId".equals(method)) {
			return stdStudyObjectStatisticsWyService.queryByResId(os);
		}
		return super.execute(ctx);
	}
}
