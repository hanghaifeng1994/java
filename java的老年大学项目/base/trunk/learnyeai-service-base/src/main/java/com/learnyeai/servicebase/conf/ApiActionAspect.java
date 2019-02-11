package com.learnyeai.servicebase.conf;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.support.BusinessContext;
import com.learnyeai.learnai.support.IApiController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zpz on 2018/4/10.
 */
@Aspect
@Configuration
public class ApiActionAspect {
    Logger logger = LoggerFactory.getLogger(getClass());
    // 定义切点Pointcut
    @Pointcut("execution(public * com.learnyeai..*.*Action.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 构建threadcontex
        buildCtx(request);

        // 从头部获取token、os，初始化session
        String clientOs = request.getHeader("CLIENT_OS");
        String sessionToken = request.getHeader("SESSION_TOKEN");

        CtxCommonUtils.setClientOs(clientOs);
        ThreadContext.put(ThreadContextUtil.SESSION_ID_KEY, sessionToken);
        // 不用设置session，只需初始化上下文
        Session session = ThreadContextUtil.getSessionRequired();

        ConfigEnum.CLIENT_OS client = CtxCommonUtils.getClientOs();
        /*boolean bWeb = client ==  ConfigEnum.CLIENT_OS.O;
        if(!bWeb) {
            session.setDeviceCode(sessionToken);
        }*/
        SessionManagerUtils.getDefaultManager().submit(session);


        IBusinessContext ctx = ThreadContextUtil.getCtx();
        Map params = ctx.getParamMap();

//        String os = CtxCommonUtils.getClientOs(params);
//        CtxCommonUtils.setClientOs(os);


        if(logger.isDebugEnabled()){
            logger.debug("参数：{}", params);
        }

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        Object target = pjp.getTarget();
        if(target instanceof IApiController){
            String baseUrl = ((IApiController)target).getBaseUrl();
            String trancode = baseUrl;
            int i = uri.lastIndexOf(baseUrl);
            String subUrl = uri.substring(i+baseUrl.length());
            if(subUrl.length() > 0){
                trancode = trancode + subUrl.split("/")[0];
            }
            MDC.put(AppR.MDC_TRANS_CODE, trancode);
            logger.debug(trancode);
        }

        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        logger.info("请求结束，controller的返回值是 {}" , result);
        return result;
    }

    private void buildCtx( HttpServletRequest request){
        ThreadContext.remove();
        // 参数
        Map<String, Object> params = WebUtils.getParametersStartingWith(request, null);
        ThreadContext.setContexts(params);

        ThreadContextUtil.bindHttpRequest(request);

        //总线初始化
        BusinessContext ctx = new BusinessContext();

        // 初始化数据总线
        ctx.init(request, null);
        //将总线加入线程
        ThreadContextUtil.bindCtx(ctx);

        ctx.getParamMap().putAll(params);

        Object oSiteId = request.getHeader(FeignThreadContextCons.CTX_CUR_SITE);
        if(null != oSiteId) {
            ThreadContext.put(FeignThreadContextCons.CTX_CUR_SITE, oSiteId.toString());
        }
        Object ptId = request.getHeader(FeignThreadContextCons.CTX_CUR_PLATFORM);
        if(ptId != null){
            ThreadContext.put(FeignThreadContextCons.CTX_CUR_PLATFORM, ptId.toString());
        }
        Object shId = request.getHeader(FeignThreadContextCons.CTX_CUR_MERCHANT);
        if(null != shId){
            ThreadContext.put(FeignThreadContextCons.CTX_CUR_MERCHANT, shId.toString());
        }
        Object schmId = request.getHeader(FeignThreadContextCons.CTX_CUR_MERCHANT_SCHEME);
        if(null != schmId){
            ThreadContext.put(FeignThreadContextCons.CTX_CUR_MERCHANT_SCHEME, schmId.toString());
        }
    }

}
