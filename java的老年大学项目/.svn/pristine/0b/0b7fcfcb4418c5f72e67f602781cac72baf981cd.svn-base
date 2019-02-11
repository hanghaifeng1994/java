<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>error - 页面出错</title>
	<link href="${ctx }/css/master.css" rel="stylesheet" type="text/css"/>
	<script src="${staticurl}/js/jquery.js" type="text/javascript"></script> 
	<script type="text/javascript">
	   	$(document).ready(function() {
	   		if(self.frameElement.tagName=="IFRAME"){
		   		$("#index_span").hide();
	   		}
	 	});
	</script>	
</head>

<body>
<div style="display: none;">
<%=exception.getCause().toString()%>
</div>
<div class="error_box">
<h1 class="right01">对不起，您访问的页面出错了</h1>
<p class="right02">您可以点击“<span class="colorred">重试</span>”</p>
<p class="right03">
<span><input name="Submit" type="submit" class="yellowbtu" value="重试" style="vertical-align:middle;" onclick="window.location.reload()"/></span>
<span class="ml10" id="index_span"><input name="button" type="button" class="btu_bgbule" id="button" value="返回首页" onclick="window.location.href='<common:prop name="ahstudy.webapp.url" propfilename=""></common:prop>'" /></span>
</p>
</div>
</body>
</html>
