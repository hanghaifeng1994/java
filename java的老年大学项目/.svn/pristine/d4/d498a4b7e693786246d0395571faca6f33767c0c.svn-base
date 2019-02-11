package com.drcl.traincore.contants;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.common.lib.util.web.PropertyUtils;


/**
 * 
 * 系统开关功能
 * @author zhaowei
 *
 */
public class Switch {

	public static Map<String,Boolean> isSynLms = Maps.newHashMap();
	
	/**
	 * 学员和课程释放已经跳过到lms
	 * @param usercourses
	 * @return
	 */
	public static boolean isToLmsed(String usercourses){
		return isSynLms.containsKey(usercourses);
	}
	
	public static void setToLmsed(String usercourses,boolean isOk){
		if(isOk)
			isSynLms.put(usercourses, isOk);
		else
			isSynLms.remove(usercourses);
			
	}
	
	
	/**
	 * 是否开启webchat功能
	 * @return
	 */
	public static boolean isOpenWebchat(){
        String webchat = PropertyUtils.getPropertyWithConfigName("chat.properties","webchat.enable", "false");
        if("true".equals(webchat)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否为开发环境
	 * @return
	 */
	public static boolean isDevelopEnv(){
        String developEnv = PropertyUtils.getProperty("develop.env", "false");
        if("true".equals(developEnv)){
        	return true;
        }
        return false;
	}
	
	
	/**
	 * 是否开启单点登录信息系统功能
	 * @return
	 */
	public static boolean isOpenSsoLogin(){
        String ssoCert = PropertyUtils.getProperty("ssologin", "false");
        if("true".equals(ssoCert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步用户到BBS系统功能
	 * @return
	 */
	public static boolean isOpenSynUserToBBS(){
		//是否同步用户到信息系统
		String check_syncertuser = PropertyUtils.getProperty("check.synuser.tobbs", "false");
        if("true".equals(check_syncertuser)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步用户到信息系统功能
	 * @return
	 */
	public static boolean isOpenSynUserToCert(){
		//是否同步用户到信息系统
		String check_syncertuser = PropertyUtils.getProperty("check.synuser.tocert", "false");
        if("true".equals(check_syncertuser)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步用户到webchat系统功能
	 * @return
	 */
	public static boolean isOpenSynUserToWebchat(){
		//是否同步用户到webchat
		String check_synwebchatuser = PropertyUtils.getProperty("check.synuser.towebchat", "false");
        if("true".equals(check_synwebchatuser)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步用户到lms系统功能
	 * @return
	 */
	public static boolean isOpenSynUserToLMS(){
		//是否同步用户到webchat
		String check_synwebchatuser = PropertyUtils.getProperty("check.synuser.tolms", "false");
        if("true".equals(check_synwebchatuser)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动服务是将用户同步到sso
	 * @return
	 */
	public static boolean isOpenSynUserToSSO(){
		String check_synstudytocert = PropertyUtils.getProperty("check.synuser.tosso", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	
	/**
	 * 是否启动服务是将用户项目学时同步到信息系统
	 * @return
	 */
	public static boolean isOpenSynStudyToCert(){
		String check_synstudytocert = PropertyUtils.getProperty("check.synstudy.tocert", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动服务是将txt中列出的epcourse的课程也在scorm里面创建
	 * @return
	 */
	public static boolean isOpenMoveEpCourseToEpscorm(){
		String check_createepscorm = PropertyUtils.getProperty("check.create.ep.scorm", "false");
        if("true".equals(check_createepscorm)){
        	return true;
        }
        return false;
	}
	
	
	/**
	 * 是否启动服务复制一份课程为（新）
	 * @return
	 */
	public static boolean isCopy(){
		String check_createepscorm = PropertyUtils.getProperty("check.copycourse", "false");
        if("true".equals(check_createepscorm)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动服务是生成项目证书
	 * @return
	 */
	public static boolean isOpenGenCert(){
		String checkGencert = PropertyUtils.getProperty("check.gencert", "false");
        if("true".equals(checkGencert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动新学习平台
	 * @return
	 */
	public static boolean isOpenLp3(){
		String openLp3 = PropertyUtils.getProperty("lp3.open", "false");
        if("true".equals(openLp3)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动处理完成课程到生成证书
	 * @return
	 */
	public static boolean isOpenFinishedToCert(){
		String check_synstudytocert = PropertyUtils.getProperty("check.finished.tocert", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	
	/**
	 * 是否启动服务是取出用户重复在学课程或者完成课程
	 * @return
	 */
	public static boolean isCheckRepeatlearningcourse(){
		String check_synstudytocert = PropertyUtils.getProperty("check.repeatlearningcourse", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启单点登录信息系统功能
	 * @return
	 */
	public static boolean isOpenSsoLoginCert(){
        String ssoCert = PropertyUtils.getProperty("ssologin.cert", "false");
        if("true".equals(ssoCert)){
        	return true;
        }
        return false;
	}
	
	public static boolean isJinsai(){
		String check_synstudytocert = PropertyUtils.getProperty("jinsai.open", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启考核
	 * @return
	 */
	public static boolean isCheck(){
		String check_synstudytocert = PropertyUtils.getProperty("check.open", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启强制完善信息功能
	 * @return
	 */
	public static boolean isInputUserInfo(){
		String check_synstudytocert = PropertyUtils.getProperty("input.userinfo.open", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否启动服务是将学分同步到无锡学分银行
	 * @return
	 */
	public static boolean isOpenScoreToWxbank(){
		String check_synstudytocert = PropertyUtils.getProperty("check.synscore.towxbank", "false");
        if("true".equals(check_synstudytocert)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步到南京惟精系统
	 * @return
	 */
	public static boolean isOpenNjwj(){
		String check_sysusertonjwj = PropertyUtils.getProperty("check.sysuser.tonjwj", "false");
        if("true".equals(check_sysusertonjwj)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启同步到汽轮小学
	 * @return
	 */
	public static boolean isOpenQlxx(){
		String check_sysusertoqlxx = PropertyUtils.getProperty("check.sysuser.toqlxx", "false");
        if("true".equals(check_sysusertoqlxx)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启安徽专技系统
	 * @return
	 */
	public static boolean isOpenAhstudy(){
		String check_sysusertonjwj = PropertyUtils.getProperty("ahstudy.open", "false");
        if("true".equals(check_sysusertonjwj)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启无锡系统
	 * @return
	 */
	public static boolean isOpenWxedu(){
		String check_sysusertonjwj = PropertyUtils.getProperty("wxedu.open", "false");
        if("true".equals(check_sysusertonjwj)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启河北电大
	 * @return
	 */
	public static boolean isOpenHbdd(){
		String check_sysusertonjwj = PropertyUtils.getProperty("hbdd.open", "false");
        if("true".equals(check_sysusertonjwj)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启将公告同步到信息系统
	 * @return
	 */
	public static boolean isOpenNoticeSyncInfoSystem(){
		String noticeSyncInfoSystem = PropertyUtils.getPropertyWithConfigName("systemSwitch.properties", "noticeSyncInfoSystem.open");
        if("true".equals(noticeSyncInfoSystem)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启支付功能
	 * @return
	 */
	public static boolean isOpenPaySystem(){
		String noticeSyncInfoSystem = PropertyUtils.getPropertyWithConfigName("systemSwitch.properties", "pay.open");
        if("true".equals(noticeSyncInfoSystem)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启证书功能
	 * @return
	 */
	public static boolean isOpenCertificateSystem(){
		String noticeSyncInfoSystem = PropertyUtils.getPropertyWithConfigName("systemSwitch.properties", "certificate.open");
        if("true".equals(noticeSyncInfoSystem)){
        	return true;
        }
        return false;
	}
	
	
	
	/**
	 * 是否开启sso
	 * @return
	 */
	public static boolean isOpenSso(){
		String open = PropertyUtils.getProperty("sso.open", "false");
        if("true".equals(open)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否测试环境
	 * @return
	 */
	public static boolean isTest(){
		String open = PropertyUtils.getProperty("is.test", "false");
        if("true".equals(open)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启全文索引功能
	 * @return
	 */
	public static boolean isFullIndex(){
		String open = PropertyUtils.getProperty("is.fullindex", "false");
        if("true".equals(open)){
        	return true;
        }
        return false;
	}
	
	/**
	 * 是否开启首页静态化
	 * @return
	 */
	public static boolean isPageStatic(){
		String open = PropertyUtils.getProperty("pagestaticize.isopen", "false");
		if("true".equals(open)){
			return true;
		}
		return false;
	}
	
	/**
	 * 从配置文件sysconfig.properites中取得pay.istestmoney 是否开启测试支付金额	
	 * @return
	 */
	public static boolean isOpenTestmoney(){
		String istestmoney = PropertyUtils.getProperty("pay.istestmoney", "false");
        if("true".equals(istestmoney)){
        	return true;
        }
        if("1".equals(istestmoney))
        	return true;
		return false;
	}
}