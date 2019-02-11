package com.learnyeai.base.web.common;

import com.learnyeai.base.model.SmsTmpl;
import com.learnyeai.base.service.SmsTmplWyService;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.learnai.utils.smg.ISmsService;
import com.learnyeai.learnai.utils.smg.SmsFactory;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.security.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class DynCodeSendController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SmsTmplWyService smsTmplWyService;

    @Autowired
    private IAresSerivce smsSendOp;

    @SuppressWarnings("unchecked")
    @ResponseBody
    public Map<String, Object> execute(IBusinessContext ctx) {
        String mobile = ctx.getParam("mobile");
        // 通过模版类型，查询第三方平台上的模板编号。
        String tplId = "";//模板ID
        String msgTemp = "";//模板内容
        List<SmsTmpl> list = smsTmplWyService.queryList(null, ctx.getParamMap());
        if(list.size() > 0){
            msgTemp = list.get(0).getStCont();
            tplId = list.get(0).getStNo();
        }
        if(tplId==null||tplId.length()<=0){
            throw new AresRuntimeException(ReportErrorKey.sms_tpl_id_miss);
        }
//        tplId= ConfigUtils.getValue("MSG_TPL_ID");

        // 获取6位随机验证码
        long curTime = new Date().getTime();
        String dynCode = RandomUtil.randomInt(4);
        logger.debug("--run---{}", dynCode);
ctx.saveSessionObject(SessR.DYN_CODE, dynCode);
			ctx.saveSessionObject(SessR.DYN_TIME, curTime);

        Session session = ThreadContextUtil.getSessionRequired();
        session.setAttribute(SessR.DYN_CODE, dynCode);
        session.setAttribute(SessR.DYN_TIME, curTime);
        //获取验证码的手机号
        session.setAttribute(SessR.DYN_NO, mobile);

        String vars[] = {dynCode};
        if(msgTemp==null||msgTemp.length()<=0){
            msgTemp="{0}是你本次交易的的短信验证码，请勿泄露他人。";
        }
        String modeContent = StringUtils.getMessage(msgTemp, vars);
        ctx.setParam("msg", modeContent);
//			ctx.setParam("DYN_CODE",vars[0]);

        // 调用发送短信
        SmsFactory smsFactory = SmsFactory.getFactory();
        ISmsService iSmsService = smsFactory.getImp();
        try {
//			iSmsService.sendSmg(mobile,tplId, "#code#="+dynCode);
        } catch (Exception e) {
            throw new AresRuntimeException(ReportErrorKey.sms_send_error);
        }
        return ctx.getParamMap();
    }
}
