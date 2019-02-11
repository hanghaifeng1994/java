package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.tools.email.MailSenderInfo;
import com.learnyeai.tools.email.SimpleMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件
 * Created by XieLina on 2016/5/13 0013.
 */
@Component
public class EmailSendOp implements IAresSerivce {
    @Override
    public int execute(IBusinessContext context) {
        com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
        // 设置邮件服务器信息
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);

        // 邮箱用户名
        mailInfo.setUserName("15665433478@163.com");
        // 邮箱密码
        mailInfo.setPassword("xielina123456789");
        // 发件人邮箱
        mailInfo.setFromAddress("15665433478@163.com");
        // 收件人邮箱
        mailInfo.setToAddress(ctx.getParam("EMAIL"));
        // 邮件标题
        mailInfo.setSubject("验证码");
        // 邮件内容
        StringBuffer buffer = new StringBuffer();
        buffer.append(ctx.getParam("msg"));
        mailInfo.setContent(buffer.toString());

        // 发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        // 发送文体格式
        /*boolean isSuccess = sms.sendTextMail(mailInfo);
        if(!isSuccess){
            CtxReportUtil.showAresError(ctx, ReportErrorKey.send_email_fail);
            return EXIT;
        }*/
        return NEXT;
    }
}
