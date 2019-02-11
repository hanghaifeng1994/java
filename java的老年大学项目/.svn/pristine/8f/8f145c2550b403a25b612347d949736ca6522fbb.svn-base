package com.learnyeai.learnai.net.netMsg.common;

import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.engine.RequestReport;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.JsonMapper;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * 通用渠道请求解析
 * Created by zpz on 2017/9/6.
 */
@Component
public class NetRequest4Common implements IRequstBuilder{
    private String sessionToken = "0000000000100111";
    @Override
    public boolean buildSendMessage(IBusinessContext busiContext, INetConfParser confParser, String transCode) {

        // 把请求参数map转换成请求报文
        /*
{
 "header":
  {
  "SESSION_TOKEN":"0000001388057767",
  "UUID":"1388057767",
  "CLIENT_OS":"O",
  "REQ_TIME":"1504678109429"},
 "payload":
  {
  "MSG_ID":"1"
  }
}
         */
        if(busiContext.getReqHead().containsKey(CtxCommonUtils.SESSION_TOKEN)){
            Object sessid = busiContext.getReqHead().get(CtxCommonUtils.SESSION_TOKEN);
            if(null != sessid && sessid.toString().length() > 0)
                sessionToken = sessid.toString();
        }
        String uuid = CtxCommonUtils.getUUID(busiContext.getReqHead());
        if(uuid == null || uuid.length() == 0)
            uuid = sessionToken;

        Object oClient = CtxCommonUtils.getClientOs(busiContext.getReqHead());
        String clientOs = "A";
        if(clientOs == null)
            clientOs = oClient.toString();

        RequestReport report = new RequestReport();
        Map head = report.getHeader();
        head.putAll(busiContext.getReqHead());
        Map payload = report.getPayload();
        head.put(CtxCommonUtils.SESSION_TOKEN, sessionToken);
        head.put(CtxCommonUtils.UUID, uuid);
        head.put(CtxCommonUtils.CLIENT_OS, clientOs);
        head.put(CtxCommonUtils.REQ_TIME, Calendar.getInstance().getTimeInMillis());
        payload.putAll(busiContext.getParamMap());
        busiContext.setRequestEntry(JsonMapper.toJsonString(report));
        return true;
    }
}
