<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
</head>
<body>
<!--header start-->
<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="index" name="menu"/>
</jsp:include>
<!--header over-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="courselist" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
	<section id="main" role="main">
	<center>
		<h3>欢迎进入后台管理</h3>	
		<h3>轻松管理从这里开始</h3>
	</center>
						<div class="bs-docs-example" style="padding-bottom: 24px;">
						<a data-trigger="modal" href="http://www.bootcss.com/p/sco.js/lipsum.html" data-title="Modal title" class="btn btn-primary btn-large">Launch demo modal</a>
					</div>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>