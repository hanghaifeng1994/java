<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="cn.common.interfaces.bbs.client.BBSClient"%>
<%@page import="cn.common.lib.web.filter.ActiveLoginFilter"%>
<%
//退出处理需要登录cookie
//处理需要主动登录标识cookie，每次退出成功要删除
final Cookie cookie = new Cookie(ActiveLoginFilter.REQUEST_COOKIE_NEEDACTIVE,null);
cookie.setMaxAge(0);
cookie.setPath("/");
cookie.setSecure(false);
response.addCookie(cookie);

// 生成同步退出的代码
//BBSClient uc = new BBSClient();
///String returnjs = uc.uc_user_synlogout();
//out.print(returnjs);
StringBuffer url = new StringBuffer();
int port = request.getServerPort();
if (port < 0) {
    port = 80; // Work around java.net.URL bug
}
String scheme = request.getScheme();

url.append(scheme);
url.append("://");
String value = request.getHeader("Host");  
String host = !StringUtils.isBlank(value) && !"unknown".equalsIgnoreCase(value) ? value : "";  
if(StringUtils.isNotBlank(host)){
   	url.append(host);
}else{
    url.append(request.getServerName());

    if ((scheme.equals("http") && (port != 80))
            || (scheme.equals("https") && (port != 8443))) {
        url.append(':');
        url.append(port);
    }
}
%>

<%@page import="org.apache.commons.lang.StringUtils"%><script>
	function dolocation() {
		var url = "";
		if(url=="" || url==null || url=="null"){
			url = "${ctx}/admin/index.action"
		}
		window.location.href = url;
	}	
	window.onload = dolocation();
</script>