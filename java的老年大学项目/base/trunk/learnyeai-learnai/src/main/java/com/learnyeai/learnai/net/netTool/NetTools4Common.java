package com.learnyeai.learnai.net.netTool;

import com.learnyeai.learnai.net.*;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 通用请求工具类
 * Created by zpz on 2017/9/6.
 */
@Service
public class NetTools4Common implements INetTools {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    @Qualifier("netConfParser")
    INetConfParser confParser;

    @Autowired
    @Qualifier("requestBuilder4Web")
    private IRequstBuilder requstBuilder;

    @Autowired
    @Qualifier("netRequest4Common")
    IRequstBuilder netRequestBuilder;

    @Autowired
    @Qualifier("netConnect4Common")
    private INetConnect netConnect;
    @Autowired
    @Qualifier("netResponse4Common")
    private IResponseParser netResponseParse;

    @Override
    public boolean execute(IBusinessContext ctx, String transCode) {
        String tranUrl = ctx.getParam(NetConst.TRAN_URL);
        // 解析报文
        /*if (!requstBuilder.buildSendMessage(ctx, confParser, transCode)) {
            return false;
        }*/
        // 拼接报文
        if (!netRequestBuilder.buildSendMessage(ctx, confParser, transCode)){
            return false;
        }
        ctx.setParam(NetConst.TRAN_URL, tranUrl);

        if(logger.isDebugEnabled()){
            logger.debug(ctx.getRequestEntry().toString());
        }
        // 请求数据
        if(!netConnect.connect(ctx, transCode))
            return false;

        // 解析报文
        return netResponseParse.parserResponseData(ctx, confParser,transCode);
    }
}
