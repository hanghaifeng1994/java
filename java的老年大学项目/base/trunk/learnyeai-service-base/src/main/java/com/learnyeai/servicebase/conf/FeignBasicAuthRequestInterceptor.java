package com.learnyeai.servicebase.conf;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.support.CurrentUserInfoDao;
import com.learnyeai.tools.common.MapUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Feign请求拦截器
 * Created by zpz on 2018/4/25.
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void apply(RequestTemplate template) {
        CurrentUserInfoDao currentUserInfoDao = SpringContextUtils.getBean(CurrentUserInfoDao.class);
//        template.query("CLIENT_OS", CtxCommonUtils.getClientOs().name());
//        template.query("SESSION_TOKEN", ThreadContextUtil.getSessionRequired().getId());

        template.header("CLIENT_OS", CtxCommonUtils.getClientOs()==null?"":CtxCommonUtils.getClientOs().name());
        template.header("SESSION_TOKEN", ThreadContextUtil.getSessionRequired().getId());
        Object oSiteId = ThreadContext.get(FeignThreadContextCons.CTX_CUR_SITE);
        if(null != oSiteId) {
            template.header(FeignThreadContextCons.CTX_CUR_SITE, oSiteId.toString());
        }
        Object ptId = ThreadContext.get(FeignThreadContextCons.CTX_CUR_PLATFORM);
        if(ptId != null){
            template.header(FeignThreadContextCons.CTX_CUR_PLATFORM, ptId.toString());
        }
        Object shId = ThreadContext.get(FeignThreadContextCons.CTX_CUR_MERCHANT);
        if(null != shId){
            template.header(FeignThreadContextCons.CTX_CUR_MERCHANT, shId.toString());
        }
        Object schmId = ThreadContext.get(FeignThreadContextCons.CTX_CUR_MERCHANT_SCHEME);
        if(null != schmId){
            template.header(FeignThreadContextCons.CTX_CUR_MERCHANT_SCHEME, schmId.toString());
        }
        // _current_platform

        Map<String, Collection<String>> headers = template.headers();

        if(!headers.containsKey("Content-Type") && !headers.containsKey("content-type")){
            template.header("Content-Type", "text/plain");
        }

    }
}
