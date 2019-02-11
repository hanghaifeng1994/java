package com.learnyeai.common.engine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.learnyeai.common.support.BaseUserDao;
import com.learnyeai.common.utils.WeyeCons;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.engine.AbstractChannelEngine;
import com.learnyeai.learnai.engine.RequestReport;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.error.DaoException;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionException;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2016/4/19.
 */
public class WeyeChannelEngine extends AbstractChannelEngine {

    @Autowired
    @Qualifier("netConfParser")
    private INetConfParser conf;

    @Autowired
    @Qualifier("responseFilter4Web")
    private IResponseParser parser;

    @Autowired
    @Qualifier("requestBuilder4Web")
    private IRequstBuilder requstBuilder;


    @Autowired
    @Qualifier("commonFlow")
    private IAresFlowDispatch commonFlow;
    @Autowired
    ILearnAiThreadStart learnAiThreadStart;
    @Autowired
    private BaseUserDao baseUserDao;

    private Logger logger = LoggerFactory.getLogger(getClass());


    private void init(HttpServletRequest request, IBusinessContext ctx) {
        // 读取报文内容
        String reqStr = null;
        if(ctx.getRequestEntry() == null){
            throw new BusinessException("报文数据为空"); // 没有报文
        }
        reqStr = ctx.getRequestEntry();

        // 解密
        String msg = (String)codecFactory.decode(getCoderKey(), reqStr);
        RequestReport reqMsg = JsonMapper.getInstance().fromJson(msg, RequestReport.class);
        ctx.getParamMap().putAll(reqMsg.getPayload());
        ctx.setReqHead(reqMsg.getHeader());

        // 如果是小程序登录,APP_ID,拆分成APLT_ID、APP_ID，添加OPEN_ID
        String clientOs = CtxCommonUtils.getClientOs(ctx.getReqHead());
        CtxCommonUtils.setClientOs(clientOs);
        if(CtxCommonUtils.getClientOs() == ConfigEnum.CLIENT_OS.WA){
            String ss = MapUtil.getMapValue(ctx.getReqHead(), CtxCommonUtils.APP_ID, "");
            String[] ids = ss.split("_");
            if(ids.length != 2){
                throw new RuntimeException();
            }
            ctx.getReqHead().put(CtxCommonUtils.APLT_ID, ids[0]);
            ctx.getReqHead().put(CtxCommonUtils.APP_ID, ids[1]);
        }

        initSession(ctx);
        // 防重复检查
        commonFlow.execute(ctx);


    }

    /**
     * 渠道处理
     * @param request
     * @param ctx
     * @return
     */
    public String execute(HttpServletRequest request, IBusinessContext ctx ){
        try{
            init(request, ctx);
            String rst = super.execute(request, ctx);

            // 加密
            if(logger.isDebugEnabled()){
                logger.debug(rst);
            }
            String ss = codecFactory.encode(getCoderKey(), rst);
            if(logger.isDebugEnabled()){
                logger.debug(ss);
            }
            return ss;

        }catch (DaoException e){
            AresRuntimeException ae = new AresRuntimeException(ReportErrorKey.common_system_error);
            CtxReportUtil.showAresError(ae, ctx);
            logger.error("数据库访问错误", e);
            e.printStackTrace();
        }catch (SessionException e){
            logger.error("error", e);
            CtxReportUtil.showAresError(new AresRuntimeException(ReportErrorKey.RTN_TIME_OUT), ctx);
        }
        catch (AresRuntimeException e){
            CtxReportUtil.showAresError(e, ctx);
            logger.error(e.getMessageCode(), e);
            e.printStackTrace();

        }catch (BusinessException e){ // 业务异常
            CtxReportUtil.showBuisinessError(e, ctx);
            e.printStackTrace();
        }catch (Exception e){
            logger.error("error", e);
            e.printStackTrace();
            AresRuntimeException ae = new AresRuntimeException(ReportErrorKey.inte_service_not_found_or_error);
            ae.setCauseMsg(e.getMessage());
            CtxReportUtil.showAresError(ae, ctx);
        }

        Map resutMap = new HashMap();
        CtxReportUtil.checkResult(ctx, resutMap);

        String errMsg = JSON.toJSONString(resutMap, new SerializerFeature[0]);


        if(logger.isDebugEnabled()){
            logger.debug(errMsg);
        }
        String ss = codecFactory.encode(getCoderKey(), errMsg);
        if(logger.isDebugEnabled()){
            logger.debug(ss);
        }
        return ss;
    }

    @Override
    protected Object doAction(IBusinessContext ctx, IController action) {
        ctx.setReport(requstBuilder, parser,conf);
        Map rst = new HashMap();
        Object data = null;
        // 报文是否是通用报文
        MBTransConfBean transConfBean = null;
        try{
            transConfBean = conf.findTransConfById(ctx.getTransCode(), NetConst.WEB_XML_PATH);
        }catch (Exception e){
            // 如果是common接口没有找到报文，可能是通用接口，修改为api接口
            String ss = ctx.getTransCode();
            int idx = ss.indexOf("common");

            if(idx == 0) {
                ss = "api" + ss.substring(idx + "common".length());
                transConfBean = conf.findTransConfById(ss, NetConst.WEB_XML_PATH);
                String isCommon = transConfBean.getProperty("isCommon");
                if(isCommon == null) {
                    AresRuntimeException a = new AresRuntimeException();
                    a.setCauseMsg("接口不存在");
                    throw a;
                }
                ctx.setTransCode(ss);
            }
        }

        {
            // 是否需要检查用户是否存在
            String custIdKey= transConfBean.getProperty("custIdKey");
            if(custIdKey!= null && custIdKey.length() > 0){
                String custId = ctx.getParam(custIdKey);
                if(custId != null && custId.length() > 0){
                    if(!baseUserDao.userExists(custId)){
                        throw AresRuntimeException.build("custInfo.userNotExits").iniMessage("用户不存在");
                    }
                }
            }
        }
        // 需要检查输入参数，把多余的参数去掉
        boolean isPre = false;
        {
            if(transConfBean.getProperty("preNotCheck") == null)
                isPre = true;
        }
        if(isPre){
            CtxReportUtil.transPrev(ctx, ctx.getTransCode(), conf, requstBuilder);
        }
        //调用业务方法
        data = action.execute(ctx);

        try {
            if(data == null) {
            }else if(data instanceof String){
            }else if(data instanceof Map){
                // 是map什么都不做
            }else if(data instanceof Collection){ // 如果不是List,查看其中的元素是否是map
                Collection ll = (Collection)data;
                if(ll.size() > 0 && !(ll.iterator().next() instanceof Map)){
//                把集合转成map
                    data = BeanMapUtils.convert2ListMap(ll);

                }
            }else {
                data = BeanMapUtils.convertBean(data);
            }
        }catch (Exception e){
            logger.error("对应转换出错", e);
            throw AresRuntimeException.build(null).iniMessage(e.getMessage());
        }
        // 不检查返回报文
        if(CtxHeadUtil.getReportDataDealType(ctx).equals("1"))
            rst = CtxReportUtil.transAfter(ctx, data);
        else
            rst = CtxReportUtil.transAfter(ctx, data, ctx.getTransCode(),conf, parser);

        return rst;
    }
    // 添加登录session
    private void initSession(IBusinessContext ctx){
        // sessionid必传
        // app版必须传设备号

        // 判断客户端类型，A:android、I:ios、WA:小程序 O:浏览器
        ConfigEnum.CLIENT_OS client = CtxCommonUtils.getClientOs();
        if(client == null)
            throw new AresRuntimeException();

        boolean bWeb = client ==  ConfigEnum.CLIENT_OS.O;

        // 获取sessionid、设备号
        String sessionId = CtxCommonUtils.getSessionToken(ctx.getReqHead());
        String deviceCode =CtxCommonUtils.getUUID(ctx.getReqHead());

        if(StringUtils.isBlank(deviceCode)&&!bWeb){
            throw new RuntimeException();
        }

        if(ThreadContextUtil.isLogining()){
            sessionId = null;
        }else {
            if(StringUtils.isBlank(sessionId)){
                throw new RuntimeException();
            }
        }

        // 初始化session
        ThreadContext.put(ThreadContextUtil.SESSION_ID_KEY, sessionId);
        Session session = ThreadContextUtil.getSessionRequired();
        if(!bWeb) {
            session.setDeviceCode(deviceCode);
        }
        //  提交session
        SessionManagerUtils.getDefaultManager().submit(ThreadContextUtil.getSession(false));

        if(ThreadContextUtil.isLogining()){
            logger.debug("正在登录");
        }else {
            // 需要检查登录，// 需不需要检查，没有登录都初始化会话
            /*Boolean checkLoging = ThreadContext.getValue(ThreadContextUtil.CHECK_LOGINING_KEY, Boolean.class);
            if(null != checkLoging && checkLoging.booleanValue())*/
            {
                if (!SessR.isLogined()) {
                    // 初始化用户session;
                    learnAiThreadStart.initUserSession(ctx);
                }else{
                    // 已登录检查用户是否一致
                    HttpServletRequest request = ThreadContextUtil.getHttpRequest();
                    String accountId = request.getHeader("__account_id");
                    String sessUserId = session.getUserId();
                    if(null != accountId && !sessUserId.equals(accountId)){
                        logger.warn("用户与缓存中用户信息不一致");
                        AresRuntimeException e = new AresRuntimeException();
                        e.setCauseMsg("用户与缓存中用户信息不一致");
                        throw e;
                    }
                }

            }

            // 初始化线程
            learnAiThreadStart.initThreadContex(ctx);
        }
    }
}
