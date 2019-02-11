package com.learnyeai.learnai.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.tools.common.StringUtils;

/**
 * 添加是否检查登录标识，检查脚本注入
 */
public class SessionFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Pattern[] regPatterns = new Pattern[0];
	private Locale locale = new Locale("zh_CN");
	/**
	 * 请求参数前缀
	 */
	private final static String REQ_PREFIX = "{";

	@Override
	public void init(FilterConfig config) throws ServletException {
		String exclude = config.getInitParameter("exclude");
		logger.debug("session filter exclude:{}", exclude);
		if (StringUtils.isNotEmpty(exclude)) {
			String[] patterns = exclude.trim().split(",|;");
			regPatterns = new Pattern[patterns.length];
			for (int i = 0; i < patterns.length; i++) {
				if (StringUtils.isNotEmpty(patterns[i])) {
					regPatterns[i] = Pattern.compile(patterns[i]);
				}
			}
			logger.debug("session filter pattern size:{}", regPatterns.length);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		// 日志分类为基础输出--交易号
		HttpServletRequest req = (HttpServletRequest) request;

		if(req.getRequestURI().lastIndexOf(".do") < 0){
			filterChain.doFilter(req, response);
			return;
		}

		// 设置mdc默认值，在rootController中还会设置具体业务
		String MDC_TRANS_CODE = "commons";
		// 这里不能确定具体业务 zpz
		/*try {
			String url = req.getRequestURL() + "";
			if (!StringUtils.isBlank(url)) {
				int start = url.lastIndexOf("/");
				int end = url.lastIndexOf(".");

				MDC_TRANS_CODE = url.substring(start + 1, end);
			}
		} catch (Exception e) {
		}*/

		MDC.put(AppR.MDC_TRANS_CODE, MDC_TRANS_CODE);


		showHeadValues(req);
		String url = req.getRequestURL().toString();
		// 检查JS注入脚本
		if (!checkJsScript(req)) {
			response.getOutputStream().close();
			return;
		}

		for (Pattern pattern : regPatterns) {
			if (checkUrlPattern(url, pattern)) {
				logger.debug("skip session filter:{}", url);
				filterChain.doFilter(request, response);
				return;
			}
		}
		ThreadContext.put(ThreadContextUtil.CHECK_LOGINING_KEY, true);
		filterChain.doFilter(request, response);
	}

	/**
	 * 检查JS注入,SQL注入检查
	 * 
	 * @param request
	 * @return
	 */
	private boolean checkJsScript(HttpServletRequest request) {
		// 请求原文
		Map<String, String[]> params = request.getParameterMap();
		if (null == params || params.isEmpty()) {
			return true;
		}
		StringBuffer bf = new StringBuffer();
		for (String key : params.keySet()) {
			bf.append(key);
			Object value = params.get(key);
			if (value instanceof String[]) {
				String[] values = (String[]) value;
				for (String text : values) {
					bf.append(text);
				}
			} else {
				bf.append(value);
			}
		}
		// 检查是否含有JS脚本或可疑字符
		String url = bf.toString();
		if (url.contains("<") || url.contains("(") || url.contains("\"")) {
			logger.warn("---req warn chars---", url);
			return false;
		}
		return true;
	}

	private boolean checkUrlPattern(String url, Pattern pattern) {
		java.util.regex.Matcher m = pattern.matcher(url);
		return m.find();
	}

	/**
	 * 显示请求内容
	 * 
	 * @param request
	 */
	private void showHeadValues(HttpServletRequest request) {
		if (!logger.isDebugEnabled()) {
			return;
		}
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String a = (String) e.nextElement();
			logger.debug("{}:{}", a, request.getHeader(a));
		}
	}

	@Override
	public void destroy() {
		regPatterns = null;
		logger = null;
	}
}