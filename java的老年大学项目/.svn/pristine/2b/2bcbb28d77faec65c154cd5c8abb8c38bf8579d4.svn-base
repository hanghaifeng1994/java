package com.drcl.traincore.contants;

import org.apache.commons.lang.StringUtils;

import cn.common.lib.util.web.PropertyUtils;

/**
 * 系统配置项目
 * @author zhaowei
 *
 */
public class Configuration {

	/**
	 * 从配置文件sysconfig.properites中取得平台配置配置代码
	 * 参见：Constants.
	 * @return
	 */
	public static String getPlatform(){
		String platform = PropertyUtils.getProperty("platform", "");
		return platform;
	}
	
	/**
	 * 从配置文件sysconfig.properites中取得平台名称 外网地址
	 * @return
	 */
	public static String getPlatformName(){
		String mainlp3Url = PropertyUtils.getProperty("platform.name", "");
		return mainlp3Url;
	}
	
	/**
	 * 从配置文件sysconfig.properites中取得lms服务url配置 外网地址
	 * @return
	 */
	public static String getLmsUrl() throws Exception{
		String mainlp3Url = PropertyUtils.getProperty("lp3.url", "");
		
		if(StringUtils.isEmpty(mainlp3Url))
			throw new Exception("请配置应用平台代码");
		return mainlp3Url;
	}
	
	public static String mainlp3Url = PropertyUtils.getProperty("lp3.url", "");
	/**
	 * 从配置文件sysconfig.properites中取得订单有效期配置
	 * 单位：天
	 * @return
	 */
	public static int getOrderfromPeriod(){
		String orderformPeriod = PropertyUtils.getProperty("orderform.period", "30");
		try{
			int day = Integer.parseInt(orderformPeriod);
		       return day;
		}catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
	}
	
	/**
	 * 从配置文件sysconfig.properites中取得新跳转页面路径	
	 * @return
	 */
	public static String getCommonDir(){
		String commondir = PropertyUtils.getProperty("styledir", "");
		try{
		       return commondir;
		}catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}

}
