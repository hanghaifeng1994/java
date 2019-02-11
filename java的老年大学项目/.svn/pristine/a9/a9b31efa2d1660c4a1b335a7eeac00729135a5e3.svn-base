<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" language="javascript">   
	$(document).ready(function() {
		window.domain="localhost"; 
	});

	function iFrameHeight() {
		var ifm= document.getElementById("mainFrame");   
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;  
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight;
		}   
	}   
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="certtemplatelist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<section id="main" role="main">
	<iframe class="mainpart" src="<common:prop name="certtemplate.webapp.url" propfilename="certtemplate.properties" />/cert/manage/certtemplate.excsec" id="mainFrame" name="mainFrame" frameborder=0 scrolling=no width="100%" onLoad="iFrameHeight()" ></iframe>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->
</body>
</html>
