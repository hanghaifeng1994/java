package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.tools.security.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 单次会话检查，可用于防止重复提交 <br>
 * 输入参数：_OnceSessionCheck; 输入参数：_RandomCodek;
 * 
 * @author yaoym
 * 
 */
@Service
public class OnceTokenGetOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
		String token = null;
		long curTime = new Date().getTime();
		// 有效时间
		Long lastTime = ctx.getSessionObject(SessR.TOKEN_TIME);
		if (lastTime == null || (curTime - lastTime) > SessR.TOKEN_TIME_OUT) {
			token = RandomUtil.randomString(6);
			logger.debug("--run---{}", token);
			ctx.saveSessionObject(SessR.TOKEN_CODE, token);
			ctx.saveSessionObject(SessR.TOKEN_TIME, curTime);
		} else {
			token = ctx.getSessionObject(SessR.TOKEN_CODE);
		}
		ctx.setParam(SessR.TOKEN_CODE, token);
		return NEXT;
	}

}
