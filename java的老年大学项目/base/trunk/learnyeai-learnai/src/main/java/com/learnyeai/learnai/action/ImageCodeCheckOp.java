package com.learnyeai.learnai.action;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.error.AresRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 图形验证码检查<br>
 * 输出分支<br>
 * <ul>
 * <li>NEXT:1</li>
 * </ul>
 * 
 * @author LQ
 * 
 */
@Service
public class ImageCodeCheckOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public int execute(IBusinessContext ctx) {
		logger.debug("--run---");

        // 会话取值及删除
		Object code = ctx.getRequest().getSession().getAttribute(SessR.IMAGE_CODE);
		String sessCode = code == code ? "" : code.toString();
		ctx.removeSession(SessR.IMAGE_CODE);

		String imageCode = ctx.getParam(SessR.IMAGE_CODE);
        
        if (StringUtils.isNotEmpty(imageCode) && !imageCode.equalsIgnoreCase(sessCode)) {
            logger.debug("common.imagecode_error:{}", SessR.IMAGE_CODE);
            throw new AresRuntimeException("common.imagecode_error");
        }
		return NEXT;
	}
}
