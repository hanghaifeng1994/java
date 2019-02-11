package com.learnyeai.learnai.web.filter;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.support.BusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.tools.common.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自动注册线程上下文的拦截器
 * 设置是否是登录请求标识
 * @author lc3@yitong.com.cn
 */
public class ThreadContextFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(ThreadContextFilter.class);

    public static final String LOGIN_URLS_KEY = "loginUrls";
    public static final String UNCODEC_URL_KEY = "unCodecUrls";

    private final List<String> loginUrlList = new ArrayList<String>();
    private final List<String> unCodecUrlList = new ArrayList<String>();

    public final UrlPathHelper urlPathHelper = new UrlPathHelper();
    public final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initConfig(filterConfig, LOGIN_URLS_KEY, loginUrlList);
        initConfig(filterConfig, UNCODEC_URL_KEY, unCodecUrlList);
    }

    protected void initConfig(FilterConfig filterConfig, String paramKey, List<String> params) {
        String paramsStr = filterConfig.getInitParameter(paramKey);
        if(null != paramsStr && !paramsStr.isEmpty()) {
            paramsStr = paramsStr.trim();
            if(logger.isDebugEnabled()) {
                logger.debug(paramKey + ":" + paramsStr);
            }
            String[] split = paramsStr.split(",|\n|;");
            for (String s : split) {
                s = s.trim();
                if(s.isEmpty() || params.contains(s)) {
                    continue;
                }
                params.add(s);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setHeader("Access-Control-Allow-Origin","*");
            res.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
            res.setHeader("Access-Control-Allow-Methods","GET, POST, PUT,DELETE");

            ThreadContext.remove();
            if (request instanceof HttpServletRequest) {
                // 绑定当前会话到当前线程上下文环境
                HttpServletRequest req = (HttpServletRequest)request;

                // 参数
                Map<String, Object> params = WebUtils.getParametersStartingWith(request, null);
                ThreadContext.setContexts(params);

                ThreadContextUtil.bindHttpRequest(req);

                //总线初始化
                BusinessContext ctx = new BusinessContext();

                // 初始化数据总线
                ctx.init(req, null);
                //将总线加入线程
                ThreadContextUtil.bindCtx(ctx);

                ctx.getParamMap().putAll(params);

                // 是否是json
                String contentType = req.getHeader("content-type");
                if(contentType != null && contentType.toLowerCase().equals("application/json")){
                    String ss = null;
                    try {
                        ss = FileUtil.readFileAsString(req.getInputStream());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ctx.setRequestEntry(ss);
                }

                if(req.getRequestURI().lastIndexOf(".do") < 0){
                    chain.doFilter(req, response);
                    return;
                }

                // 判断是否为登录操作
                String url = urlPathHelper.getPathWithinApplication(req);
                for (String loginUrl : loginUrlList) {
                    if (antPathMatcher.match(loginUrl, url)) {
                        ThreadContextUtil.setIsLogining(true);
                        if (logger.isDebugEnabled()) {
                            logger.debug("接收到登陆请求:" + url);
                        }
                        break;
                    }
                }


                chain.doFilter(req, response);
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            logger.error("拦截器执行异常", e);
        } finally {
        }
    }

    @Override
    public void destroy() {
        ThreadContext.remove();
    }
}
