package com.learnyeai.base.web.common;

import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: SysdateController
 * @Description: 获取系统时间
 * @author: LQ
 * @date: 2015年7月20日
 * 
 */

@Component
public class SysdateController implements IController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/common/sysdate.do")
	@ResponseBody
	public Map execute(@RequestBody IBusinessContext ctx) {
		logger.info("---------start-------------");
        // 创建数据总线
		try {
			Map<String,Object> outMap = new HashMap<String,Object>();
			outMap.put("CUR_DATE", DateHelper.getDate());
			outMap.put("CUR_TIME", DateHelper.getTime());

			/*outMap.put("ii", 2);

			outMap.put("fs", 0.1f);
			outMap.put("fl", 0.1555f);
			outMap.put("ds", 0.1);
			outMap.put("dl", 0.1555);

			outMap.put("bs", new BigDecimal("0.1"));
			outMap.put("bl", new BigDecimal("0.1555"));

			Double dd = null;
			outMap.put("dn", dd);*/

			return outMap;
//			return CtxReportUtil.showSuccessResult(ctx, outMap);
		} catch (Exception e) {
			return CtxReportUtil.showErrorResult(e, ctx);
		}
	}
}
