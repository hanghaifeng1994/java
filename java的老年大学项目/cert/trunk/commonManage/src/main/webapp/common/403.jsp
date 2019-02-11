<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>403 - 缺少权限</title>
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
    	<h2>对不起，您无权访问该页面</h2>
    	<h3>您可以点击“重试”或者联系  <common:prop name="jsp.constant.403.telephone" propfilename=""/>！</h3>
    	<span>
    	    <button onclick="window.location.reload()" type="button"class="btn btn-primary">
			 <span class="glyphicon glyphicon-refresh"></span>&nbsp;重试</button>
    	</span>
        <button id="index_span" type="button" class="btn btn-primary" onclick="window.location.href='<common:prop name="ahstudy.webapp.url" propfilename=""></common:prop>'"><span class="glyphicon glyphicon-backward"></span>&nbsp;返回首页</button>
    </div>

</body>
</html>