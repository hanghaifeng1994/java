package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.net.INetTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 统一渠道服务调用
 * @author LQ
 */
@Service
public class AresInteTransOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());
 
	@Autowired
	@Qualifier("netTools4HttpXml")
	private INetTools netTools;

	public int execute(IBusinessContext ctx) {
		logger.debug("--run---");
        String _transCode = ctx.getParam(AppR._TRANS_CODE);
		netTools.execute((com.learnyeai.learnai.support.IBusinessContext) ctx, _transCode);
		return NEXT;
	}
}
