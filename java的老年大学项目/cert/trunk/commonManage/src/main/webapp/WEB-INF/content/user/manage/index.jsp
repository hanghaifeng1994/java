<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理（<%@ include file="/common/title.jsp" %>-backend.js-study.cn）</title>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<link href="${staticurl}/css/backend.css" rel="stylesheet" type="text/css"/>
<link href="${staticurl}/css/structure.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript">   
	$(document).ready(function() {
		 
		iFrameHeight();
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
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--the end of 头部-->
<div id="content">
      <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="coursecategory" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
  <!--the end of left-->
  <iframe class="mainpart" src="main.action" id="mainFrame" name="mainFrame" frameborder=0 scrolling=no width="100%" onLoad="iFrameHeight()" ></iframe>
  <!--the end of main-->
</div>
<div class="del_float"></div>
<!--the end of content-->  
	    	<jsp:include page="/common/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	    	 
</html>

