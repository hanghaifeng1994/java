package com.learnyeai.core.utils;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * 应用工具
 * 
 * @author yaoym
 * 
 */
public class MessageSoureUtil {
	private static MessageSource messageSource;
	private static Locale locale = new Locale("zh_CN");

	private static MessageSource getMessageSource(){
		if(messageSource != null)
			return messageSource;
		messageSource = SpringContextUtils.getBean("messageSource");
		return messageSource;
	}
	private MessageSoureUtil() {
	}

	public static String getMessage(String code, Object[] params, Locale local) {
		try{
			return getMessageSource().getMessage(code, params, local);
		}catch (Exception e){

		}
		return null;
	}

	public static String getMessage(String code, Object... params) {
		return getMessage(code, params, locale);
	}

	/**
	 * 获得i18n字符串
	 */
	/*public static String getMessage(String code, Object[] args) {
		LocaleResolver localLocaleResolver = SpringContextUtils.getBean(LocaleResolver.class);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Locale localLocale = localLocaleResolver.resolveLocale(request);
		return AresApp.mvcCtx.getMessage(code, args, localLocale);
	}*/


}
