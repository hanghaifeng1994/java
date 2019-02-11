<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.interfaces.bbs.client.BBSClient"%>
<%@page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<%@page import="com.drcl.traincore.user.dto.BaseUserDTO"%>
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.contants.Switch"%>
<%@page import="cn.common.lib.web.filter.ActiveLoginFilter"%>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<%
//处理需要主动登录标识cookie，每次登录成功要将需要登录标识置为ture
final Cookie cookie = new Cookie(ActiveLoginFilter.REQUEST_COOKIE_NEEDACTIVE,"true");
cookie.setMaxAge(-1);//生存时间随浏览器存亡，这样下次打开浏览器只会按照是否有记住我标识进行主动登录操作
cookie.setPath("/");
cookie.setSecure(false);
response.addCookie(cookie);

UserDTO userDTO = UserUtils.getCurUser();
request.setAttribute("synloginUrlInserver",PropertyUtils.getProperty("ssologin.url.inserver"));
if(Switch.isOpenSsoLogin() && !userDTO.isManager()){
//同步登录专技平台 
%>
<c:import url="${synloginUrlInserver}">
<c:param name="username"><%=userDTO.getUsername()%></c:param>
<c:param name="password"><%=userDTO.getPassword()%></c:param>
<c:param name="service"><common:prop name="ahcert.webapp.url" propfilename=""/>/auth_check</c:param>
</c:import>
<%}
Object tourl = request.getSession().getAttribute("curRequestUrl");
String redirectUrl = "";
if(tourl != null) {
	 redirectUrl = tourl.toString();
	if(redirectUrl.indexOf("manage-webapp") >= 0) {
		redirectUrl = redirectUrl.replaceAll("manage-webapp/", StringUtils.EMPTY);
	}
	response.sendRedirect(redirectUrl);
}else {
	redirectUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "index.action";
	response.sendRedirect(redirectUrl); 
}
%>

