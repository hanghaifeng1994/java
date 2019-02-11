package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.error.AresRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 账号有效性检查，只允许操作自已的附属账号，查询账号、付款账号，不对同名户收款账号作处理
 * 
 * @author LQ
 * 
 */
@Component
public class AccountCheckOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int execute(IBusinessContext ctx) {
		
//		List list = new ArrayList();
//		Map map = new HashMap();
//		map.put("ACCT_NO", "6225");
//		map.put("ACCT_NAME", "test");
//		list.add(map);
//		
//		Map map2 = new HashMap();
//		map2.put("ACCT_NO", "6226");
//		map2.put("ACCT_NAME", "test2");
//		list.add(map2);
//		
//		ctx.saveSessionObject(SessR.ACCTS, list);
		
		logger.debug("--run---");
		String acctNo = ctx.getParam(AppR.ACCT_NO, "");// 检查账号
		if (StringUtils.isEmpty(acctNo)) {
			logger.info("交易不含有账号参数，无需校验");
			return NEXT;
		}
		List<Map> accts = ctx.getSessionObject(SessR.ACCTS);
		if (null != accts) {
			for(Map m : accts){
				String acct = m.get(AppR.ACCT_NO)+"";
				if(acctNo.equals(acct)){
					logger.info("交易账号合法性校验通过");
					return NEXT;
				}
			}
		}
		logger.warn("security.account_has_no_right:{}", acctNo);
		throw new AresRuntimeException("security.account_has_no_right", acctNo);
	}

}
