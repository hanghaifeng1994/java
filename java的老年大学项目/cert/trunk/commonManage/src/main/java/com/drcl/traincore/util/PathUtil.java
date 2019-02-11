package com.drcl.traincore.util;

import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import cn.common.lib.util.web.PropertyUtils;
import cn.common.lib.util.web.RequestUtils;

public class PathUtil {
	/**
	 * 取得运行容器的根目录
	 * @return
	 */
	public static String getContainerRoot(HttpServletRequest request){
		try {
			String webappPath = RequestUtils.getRealPath(request.getSession().getServletContext(), "/");
			//D:\work\workspace\huihe\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\examiner-webapp\
			webappPath = webappPath.substring(0, webappPath.lastIndexOf("\\"));
			webappPath = webappPath.substring(0, webappPath.lastIndexOf("\\"));
			webappPath = webappPath.substring(0, webappPath.lastIndexOf("\\"));
			webappPath = webappPath.substring(0, webappPath.lastIndexOf("\\"));
			return webappPath;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 取得应用程序的根目录
	 * @return
	 */
	public static String getWebAppRoot(HttpServletRequest request){
		try {
			String webappPath = RequestUtils.getRealPath(request.getSession().getServletContext(), "/");
			//D:\work\workspace\huihe\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\examiner-webapp\
			return webappPath;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 取得应用程序的根目录,不需要request对象
	 * @return  D:/work/workspace/huihe/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/examiner-webapp/
	 */
	public static String getWebAppRoot(){
		URL url = PropertyUtils.class.getClassLoader().getResource("/");
		if(url == null)
			return  System.getProperty("user.dir");
		else
			return url.getPath().replace("WEB-INF/classes/", "");
	}
	
	/**
	 * 获取客户端 真实IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
	     String ipAddress = null;
	     ipAddress = request.getHeader("x-forwarded-for");
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	    	  ipAddress = request.getHeader("Proxy-Client-IP");
	     }
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	          ipAddress = request.getHeader("WL-Proxy-Client-IP");
	     }
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	    	  ipAddress = request.getRemoteAddr();
	      if(ipAddress.equals("127.0.0.1")){
	    	  InetAddress inet=null;
	    try {
	    	inet = InetAddress.getLocalHost();
	    } catch (UnknownHostException e) {
	     e.printStackTrace();
	    }
	    	ipAddress= inet.getHostAddress();
	    }
	         
	    }
	     if(ipAddress!=null && ipAddress.length()>15){ 
	         if(ipAddress.indexOf(",")>0){
	             ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
	         }
	     }
	     return ipAddress; 
	  }
}
