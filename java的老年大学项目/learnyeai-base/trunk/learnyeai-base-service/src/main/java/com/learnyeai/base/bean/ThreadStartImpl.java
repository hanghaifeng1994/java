package com.learnyeai.base.bean;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.PtsetSite;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.service.PtsetSiteWyService;
import com.learnyeai.common.engine.ILearnAiThreadStart;
import com.learnyeai.common.utils.WeyeCons;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.support.CurrentUserHelp;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/8/4.
 */
@Component
public class ThreadStartImpl implements ILearnAiThreadStart {
    @Autowired
    private CustInfoWyService custInfoWyService;

    @Autowired
    private PtsetSiteWyService siteWyService;

    @Override
    public void initUserSession(IBusinessContext ctx) {

        // 取到用户帐号
        String accountId = null;
        // 没有登录，获取请求head中的user帐号
        HttpServletRequest request = ThreadContextUtil.getHttpRequest();
        accountId = request.getHeader("__account_id");
        // 再从head中取得帐号
        if(null == accountId && ctx.getReqHead().containsKey("__account_id")){
            accountId = ctx.getReqHead().get("__account_id").toString();
        }
        if(null == accountId){
            /*AresRuntimeException e = new AresRuntimeException(ReportErrorKey.RTN_TIME_OUT);
            e.setCauseMsg("请求头部没有帐户信息");
            throw e;*/
            // 没有用户信息，不作初始化
            return;
        }

        CustInfo custInfo = custInfoWyService.queryById(accountId);
        if(null == custInfo){
            AresRuntimeException e = new AresRuntimeException(ReportErrorKey.RTN_TIME_OUT);
        }


        Session session = ThreadContextUtil.getSessionRequired();

        session.setAttribute(SessR.CLIENT_OS, ctx.getReqHead().get(SessR.CLIENT_OS)); // 操作系统
        session.setAttribute(SessR.CLIENT_TYPE, ctx.getReqHead().get(SessR.CLIENT_TYPE)); // 客户端类型
        session.setAttribute(SessR.CLIENT_INFO, ctx.getReqHead().get(SessR.CLIENT_INFO)); // 客户端详情


        // 设置登录成功标识
        session.setAttribute(SessR.LOGIN_FLAG, SessR.TRUE);
        // 创建用户会话
        String userId = custInfo.getCustId();
        session.setUserId(userId);

        // currentUser所需基本信息
        session.setAttribute(SessR.MOBILE_NO, custInfo.getPhone()); // 手机号
        session.setAttribute(SessR.CUST_LGN,custInfo.getLoginName());//登录名
        session.setAttribute(SessR.CUST_NAME,custInfo.getShortName());//用户名
        session.setAttribute(SessR.CUST_TYPE,custInfo.getCustType());//用户类型
        session.setAttribute(SessR.CUST_SEX, custInfo.getSex());

        Map custMap = new HashMap();
        try {
            custMap = BeanMapUtils.convertBean(custInfo);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        session.setAttribute(SessR.USER_INFO,custMap);
    }

    @Override
    public void initThreadContex(IBusinessContext ctx) {
        String curSiteId = MapUtil.singleNodeText(ctx.getReqHead(), "SITE_ID");
        String mchtId = null;
        String shSchemeId= null;
        if(StringUtils.isBlank(curSiteId)){
            // 如果站点为空，如果用户登录，并且是客户类型，取用户站点
            Map userMap = CurrentUserHelp.getUserInfo();
            if(null != userMap) { // 已登录
                String custType = MapUtil.singleNodeText(userMap, CustInfoVo.CF.custType);
                if(BaseCons.CUST_INFO_TYPE.KH.getVal().equals(custType)) {
                    curSiteId = MapUtil.singleNodeText(userMap, CustInfoVo.CF.siteId);
                }
                mchtId = MapUtil.singleNodeText(userMap, CustInfoVo.CF.mchtId);
                shSchemeId = MapUtil.singleNodeText(userMap, CustInfoVo.CF.mchtSchmId);
            }
        }

        if(mchtId != null && mchtId.length() > 0)
            ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT, mchtId);
        if(shSchemeId != null && shSchemeId.length() > 0)
            ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT_SCHEME, shSchemeId);

        if(StringUtils.isBlank(curSiteId)){
            return;
        }
        ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_SITE, curSiteId);

        PtsetSite site = siteWyService.queryById(curSiteId);

        ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT, site.getMchtId());
        ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT_SCHEME, site.getMchtSchmId());
        ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_PLATFORM, site.getPtId());
    }
}
