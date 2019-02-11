<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("traincoreUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincoreuser.webapp.url"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/qrcode.js"></script>
<script src="${staticurl}/js/jquery.qrcode.js"></script>
<script type="text/javascript">
	$(function(){
		jQuery('#resEwm').qrcode({
			width : 200,
			height : 200,
			text : "${traincoreUrl}/wxjs/judges-login.html?r=${userFocusResource.id}"
		});
	});
</script>
</head>
<body>
	<!--正文右边开始-->
	<div style="text-align:center;">
		<div style="margin-top:40px;font-weight:bold;font-size:18px;">考场:${userFocusResource.resName }</div>
		<div style="margin-top:20px;" id="resEwm"></div>
		<div style="margin-top:40px;">
		<c:forEach items="${codes}" var="item" varStatus="st">
			<div style="margin-top:20px;font-weight:bold;font-size:30px;">授权码0${st.index+1}：<span style="margin:30px;">${item.code }</span></div>
		</c:forEach>
		</div>
		<div style="margin-top:40px;">
			登陆地址：${traincoreUrl}/wxjs/judges-login.html?r=${userFocusResource.id}
		</div>
	</div>
</body>
</html>