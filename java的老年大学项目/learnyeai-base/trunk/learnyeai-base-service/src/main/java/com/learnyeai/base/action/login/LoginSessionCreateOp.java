package com.learnyeai.base.action.login;

import com.learnyeai.base.action.beans.CustSessionCreate;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建登录会话;
 *
 * @author yaoym
 *
 */

@Service
public class LoginSessionCreateOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private CustSessionCreate loginSessionCreate;

//	@Value("${RESOURCE_APP}")
//	private String resourceRootPath;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int execute(IBusinessContext ctx) {
		logger.debug("--run---");

        // 创建用户会话
		ThreadContextUtil.resetSession();

		// 如果是web重新生成sessionToken，都重新生成
//		if(CtxCommonUtils.getClientOs() == ConfigEnum.CLIENT_OS.O)
		// 不是免登录，就重新生成key
		if(ThreadContext.get(ThreadContextUtil.LOGIN_NO_PASS_KEY) == null)
			ThreadContext.put(ThreadContextUtil.SESSION_ID_KEY, null);

		Session sess = ThreadContextUtil.getSessionRequired();
        //密码初始状态，判断是否需要重置密码
//        ctx.saveSessionObject(AppR.PWD_PRE_FLAG, ctx.getParam(AppR.PWD_PRE_FLAG));

		loginSessionCreate.execute(ctx);
		sess.setAttribute(SessR.LOGIN_FLAG, SessR.TRUE);

		// 输出SESSION_TOKEN
		ctx.setParam(CtxCommonUtils.SESSION_TOKEN,sess.getId() );
		SessionManagerUtils.login(sess);
		return NEXT;
	}
}
