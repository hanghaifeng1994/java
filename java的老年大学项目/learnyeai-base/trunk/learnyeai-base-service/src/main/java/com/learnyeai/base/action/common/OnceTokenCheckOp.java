package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.error.AresRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 单次会话检查，可用于防止重复提交 <br>
 * 一次性验证码，最长有效时间为120秒 ，过期不能用<br>
 * 输入参数：_RandomCode;
 * 
 * @author yaoym
 * 
 */
@Component
public class OnceTokenCheckOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
		// 防重复提交交易检查
		long curTime = new Date().getTime();
		Long lastTime = ctx.getSessionObject(SessR.TOKEN_TIME);
		String token = ctx.getSessionObject(SessR.TOKEN_CODE);
		ctx.removeSession(SessR.TOKEN_CODE);
		ctx.removeSession(SessR.TOKEN_TIME);

		if (lastTime == null || (curTime - lastTime) > SessR.TOKEN_TIME_OUT) {
			logger.warn("交易检证码过期，请重新获取！");
			throw new AresRuntimeException("common.token_timeout");
		}

//		ctx.saveSessionObject("LAST_TOKEN", token);
		if (StringUtils.isEmpty(token)) {
			logger.warn("forbid_repeat_to_do 100"); // 重复提交
			throw new AresRuntimeException("100");
		}
		String reqToken = ctx.getParam("TOKEN");
		if (!token.equals(reqToken)) {
			logger.warn("交易检证码检查失败");
			throw new AresRuntimeException("common.token_error");
		}
		return NEXT;
	}

}
