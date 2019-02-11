package com.learnyeai.learnai.context;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 * 请求报文头解析，及报文处理相关数据
 * Created by zpz on 2016/5/4.
 */
public class CtxHeadUtil {
//    public final static String REPORT_TOTAL_COUNT ="totalCount";      //总数
    // 线程变量key------------// 接口controller方法
    private static final String controller_method = CtxHeadUtil.class.getName() + "__controller_method";
    // 接口报文类型
    private static final String report_data_type = CtxHeadUtil.class.getName() + "report_data_direct";



    /**
     * 渠道解析时，保存方法名
     * @return
     */
    public static String getControllerMethod(){
        return ThreadContext.getValue(controller_method, String.class);
    }
    public static void setControllerMethod(String method){
        ThreadContext.put(controller_method, method);
    }
    /**
     * 报文处理类型，1：不校验报文
     * @param ctx
     * @return
     */
    public static String getReportDataDealType(IBusinessContext ctx){

        if(ThreadContext.getContexts().containsKey(report_data_type))
            return ThreadContext.getValue(report_data_type, String.class);
        return "";

    }

    /**
     * 报文处理类型，1：不校验报文
     * @param type
     */
    public static void setReportDataDealType(String type){
        ThreadContext.put(report_data_type, type);
    }

    /*public static Page getPage(IBusinessContext ctx){
        String count = "-2"; // 不统计总数
        if(getClientOs() == PtCons.CLIENT_OS.O) // 统计总数
            count = "-1";

        String pageNo = PtCons.MYPAGE.pageNo.getVal();
        String pageSize = PtCons.MYPAGE.pageSize.getVal();

        Map opMap = (Map) ctx.getParamMap();
        pageNo = MapUtil.getMapValue(opMap,OPTIONS_PAGE_NO, pageNo);
        pageSize = MapUtil.getMapValue(opMap,OPTIONS_PAGE_SIZE, pageSize);
        count = MapUtil.getMapValue(opMap,OPTIONS_COUNT, count);

        return new Page(pageNo,pageSize,count);
    }*/


}
