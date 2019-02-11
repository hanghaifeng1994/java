package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.RegexValidateUtil;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.security.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 通过邮箱获取验证码
 * Created by XieLina on 2016/5/13 0013.
 */
@Component
public class DynCodeEmailSendController implements IController {
    @Autowired
    private IAresSerivce emailSendOp;

    @SuppressWarnings("unchecked")
    @ResponseBody
    public Map<String, Object> execute(IBusinessContext ctx) {
        String email = ctx.getParam("EMAIL");
        boolean isValidate = RegexValidateUtil.checkEmail(email);
        if(!isValidate){
            CtxReportUtil.showAresError(ctx, ReportErrorKey.send_email_notvalidate);
            return null;
        }

        String msgTemp = "{0}是你本次修改密码的验证码，请勿泄露他人。";

        // 获取6位随机验证码
        long curTime = new Date().getTime();
        String dynCode = RandomUtil.randomInt(6);
        /*ctx.saveSessionObject(SessR.EMAIL_DYN_CODE, dynCode);
        ctx.saveSessionObject(SessR.EMAIL_DYN_TIME, curTime);*/

        Session session = ThreadContextUtil.getSessionRequired();
        session.setAttribute(SessR.EMAIL_DYN_CODE, dynCode);
        session.setAttribute(SessR.EMAIL_DYN_TIME, curTime);

        String vars[] = { dynCode };
        String modeContent = StringUtils.getMessage(msgTemp, vars);
        ctx.setParam("msg", modeContent);

        // 调用发送邮件
        emailSendOp.execute(ctx);
        return ctx.getParamMap();
    }
}
