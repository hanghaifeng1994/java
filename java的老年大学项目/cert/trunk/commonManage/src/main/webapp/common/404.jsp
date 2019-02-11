<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>404 - 资源暂未找到</title>
<%@ include file="/common/admin_meta.jsp" %>
	<script type="text/javascript">
	   	$(document).ready(function() {
	   		if(self.frameElement.tagName=="IFRAME"){
		   		$("#index_span").hide();
	   		}
	 	});
	</script>	
</head>

<body class="dr-error-page">
   	<div class="dr-error-wrapper">
    	<img src="${staticurl}/wx_css/images/smiley.png" />
    	<h2>404!</h2>
    	<h3>无法找到网页!</h3>
        <button type="button" class="btn btn-primary" onclick="window.location.href='<common:prop name="ahstudy.webapp.url" propfilename=""></common:prop>'"><span class="glyphicon glyphicon-backward"></span>&nbsp;返回首页</button>
    </div>
</body>
</html>