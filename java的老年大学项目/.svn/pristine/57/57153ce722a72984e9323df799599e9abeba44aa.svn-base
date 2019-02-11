package com.learnyeai.learnai.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.consts.CoreR;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.error.OtherRuntimeException;
import com.learnyeai.core.utils.MessageSoureUtil;
import com.learnyeai.learnai.support.BusinessContext;
import com.learnyeai.tools.common.StringUtils;

import com.learnyeai.learnai.error.AresRuntimeException;

/**
 * 响应报文处理工具
 * 
 */
public class CtxReportUtil {
    private static final String extResultKey = "__extResultKey";
    // 添加分页等信息
    public static Map getListExtResultMap(){
        Object o = ThreadContext.get(extResultKey);
        if(o == null){
            o = new HashMap<>();
            ThreadContext.put(extResultKey, o);
        }
        return (Map)o;
    }

    public static IBusinessContext newCtx(Map dataMap){
        return new BusinessContext(dataMap);
    }
    public static IBusinessContext newCtx(){
        return new BusinessContext();
    }
    public static IBusinessContext newCtx(Object ...keyVals){
        BusinessContext ctx = new BusinessContext();
        Map pp = ctx.getParamMap();
        for(int i=0; i<keyVals.length/2; i++){
            pp.put(keyVals[i*2], keyVals[i*2 + 1]);
        }
        return ctx;
    }
    public static void copyCtx(IBusinessContext source, IBusinessContext target){
        target.getParamMap().putAll(source.getParamMap());
        target.getReqHead().putAll(source.getReqHead());

//        BeanHelper.copy(source, target);
    }


    /**
     * 错误信息显示
     * 
     * @param e
     * @param ctx
     * @return
     */
    public static Map showAresError(AresRuntimeException e, IBusinessContext ctx) {
//        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map = ctx.getParamMap();
        String causeMsg = e.getCauseMsg();
        if(null != causeMsg){
            map.put(AppR.RTN_CAUSE, causeMsg);
        }

        if (e instanceof OtherRuntimeException) {
            OtherRuntimeException other = (OtherRuntimeException) e;
            map.put(AppR.RTN_CODE, other.getErrorCode());
            map.put(AppR.RTN_MSG, other.getErrorMessage());
            return map;
        } else {
//            String msg = MessageSoureUtil.getMessage(e.getMessageCode(), e.getArgs(), ctx.getLocale());
            String msg = e.getMessage();
            map.put(AppR.RTN_CODE, e.getMessageCode());
            map.put(AppR.RTN_MSG, msg);
            map.put(AppR.RTN_DATA, e.getData());
        }
        return map;
    }

    /**
     * 全部的异常
     * 
     * @param e
     * @param ctx
     * @return
     */
    public static Map showErrorResult(Exception e, IBusinessContext ctx) {
        if (e instanceof AresRuntimeException) {
            return showAresError((AresRuntimeException) e, ctx);
        }
        Map<String, String> map = ctx.getParamMap();
        String error = "common.system_error";
        String msg = MessageSoureUtil.getMessage(error, CoreR.EMPTY_PARAMS, ctx.getLocale());
        map.put(AppR.RTN_CODE, error);
        map.put(AppR.RTN_MSG, msg);
        return map;
    }
    public static Map showAresError(IBusinessContext ctx, String errCode, String ... args){
        return showAresError(new AresRuntimeException(errCode, args), ctx);
    }
    public static Map showBuisinessError(BusinessException e, IBusinessContext ctx){
        Map<String, Object> map = ctx.getParamMap();
        String error = "common.buisiness_error";
        if(!"999".equals(e.getMessageCode()))
            error = e.getMessageCode();

        map.put(AppR.RTN_CODE, error);
        map.put(AppR.RTN_MSG, e.getMessage());
        map.put(AppR.RTN_DATA, e.getData());

        String causeMsg = e.getCauseMsg();
        if(null != causeMsg){
            causeMsg = e.getMessage();
            map.put(AppR.RTN_CAUSE, causeMsg);
        }
        return map;
    }

    /**
     * 简单成功信息返回
     * 
     * @param ctx
     * @return
     */
    public static Map showSuccessResult(IBusinessContext ctx, Map<String, Object> outMap) {
//        if(outMap == null)
//            outMap = ctx.getParamMap();
        String msg = MessageSoureUtil.getMessage(AppR.RTN_SUCCESS, CoreR.EMPTY_PARAMS, ctx.getLocale());
        outMap.put(AppR.RTN_CODE, AppR.RTN_SUCCESS);
        outMap.put(AppR.RTN_MSG, msg);
        
        // 过滤非必要字段
        outMap.remove(SessR.CLIENT_NO);
        outMap.remove(SessR.CLIENT_OS);
        outMap.remove(SessR.CLIENT_TYPE);
        outMap.remove(SessR.CLIENT_INFO);
        outMap.remove(SessR.CLIENT_IP);
        outMap.remove(SessR.REQ_TIME);
        
        return outMap;
    }

    public static boolean transPrev(IBusinessContext ctx, String transCode,
                                    INetConfParser confParser, IRequstBuilder requestBuilder) {

        // 检查报文定义
        if (requestBuilder.buildSendMessage(ctx, confParser, transCode)) {
            return true;
        }
        return false;
    }

    private static boolean checkResult(IBusinessContext ctx){

        return checkResult(ctx, null);
    }

    /**
     * 检查结果，是否正确
     * @param ctx
     * @param rst
     * @return
     */
    public static boolean checkResult(IBusinessContext ctx, Map rst){
        String rtnCode = ctx.getParam(AppR.RTN_CODE);

        // 如果是错误，返回错误报文
        if(StringUtils.isNotBlank(rtnCode) && !rtnCode.equals(AppR.RTN_SUCCESS)){
            if(null != rst){
                String rtnMsg = ctx.getParam(AppR.RTN_MSG);
                Object data = ctx.getParamMap().get(AppR.RTN_DATA);
                rst.put(AppR.RTN_CODE, rtnCode);
                rst.put(AppR.RTN_MSG, rtnMsg);
                rst.put(AppR.RTN_DATA, data);
                rst.put(AppR.RTN_CAUSE, ctx.getParam(AppR.RTN_CAUSE));
            }

            return false;
        }
        return true;
    }

    /**
     * 交易处理后，生成报文
     * @param ctx
     * @param transCode
     * @param confParser
     * @param parser
     * @return
     */
    public static Map transAfter(IBusinessContext ctx, String transCode
            , INetConfParser confParser, IResponseParser parser) {

        Map rstMap = new HashMap();
        if(!checkResult(ctx, rstMap)){
            return rstMap;
        }

        if(StringUtils.isBlank(transCode))
            transCode = ctx.getTransCode();

        parser.parserResponseData(ctx, confParser, transCode);

        Map data = ctx.getParamMap();

        data.remove(AppR.RTN_CODE);
        data.remove(AppR.RTN_MSG);

        rstMap.put(AppR.RTN_CODE, AppR.RTN_SUCCESS);
        String rtnMsg = MessageSoureUtil.getMessage(AppR.RTN_SUCCESS, CoreR.EMPTY_PARAMS, ctx.getLocale());
        rstMap.put(AppR.RTN_MSG, rtnMsg);

        rstMap.put(AppR.RTN_DATA, data);

        return rstMap;
    }

    /**
     * 根据具体返回报文，作调整
     * @param ctx
     * @param data
     * @param transCode
     * @param confParser
     * @param parser
     * @return
     */
    public static Map transAfter(IBusinessContext ctx, Object data, String transCode
            , INetConfParser confParser, IResponseParser parser){
        boolean isList = false;
        if(null != data)
            if(data instanceof Collection){
                ctx.getParamMap().put(AppR.RTN_LIST, data);
                isList = true;
            }else{
                ctx.getParamMap().putAll((Map)data);
            }
        Map rst = transAfter(ctx, transCode, confParser, parser);

        // 对集合结果{data:{list:[]}}，转换成{data:[]}
        if(isList){
            Map d = (Map)rst.get(AppR.RTN_DATA);
            Object l = d.get(AppR.RTN_LIST);
            rst.put(AppR.RTN_DATA, l);


            // 如果是分页请求，添加totalCount
            /*Object page = ThreadContext.get(CtxHeadUtil.REPORT_TOTAL_COUNT);
            MyPage p = null;
            if(page != null && page instanceof MyPage) {
                p = (MyPage) page;
                rst.put(AppR.RTN_TOTAL, p.getTotal());
                rst.put(AppR.RTN_PAGE_NO, p.getPageNo());
                rst.put(AppR.RTN_PAGE_SIZE, p.getPageSize());
            }*/
            Map extData = getListExtResultMap();
            extData.forEach((k, v)->{
                rst.put(k,v);
            });
        }
        return rst;
    }
    public static Map transAfter(IBusinessContext ctx, Object data) {
        Map rst = new HashMap();
        rst.put(AppR.RTN_CODE, AppR.RTN_SUCCESS);
        String rtnMsg = MessageSoureUtil.getMessage(AppR.RTN_SUCCESS, CoreR.EMPTY_PARAMS, ctx.getLocale());
        rst.put(AppR.RTN_MSG, rtnMsg);

        rst.put(AppR.RTN_DATA, data);
        if(data instanceof Collection){
            Map extData = getListExtResultMap();
            extData.forEach((k, v)->{
                rst.put(k,v);
            });
        }
        return rst;
    }
}
