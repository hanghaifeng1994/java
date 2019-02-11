<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.interfaces.bbs.client.BBSClient"%>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<%
String returnjs = new BBSClient().login();
//登录论坛
out.print(returnjs);
%>
<script type="text/javascript">
	function dolocation() {
		var url = '<common:prop name="BBS_WEBAPP_FORUM" propfilename="bbs.properties"></common:prop>';
		window.location.href = url;
	}	
	$(document).ready(function() {
		dolocation();
	});
</script>