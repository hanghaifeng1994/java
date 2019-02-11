<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导入班级学员<%@ include file="/common/title.jsp" %></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/css/reset.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"	type="text/javascript"></script>
<script src="${staticurl}/js/related.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"	rel="stylesheet" />
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script>

</script>
</head>
<body>
<!--the beginning of 头部-->
<!--the beginning of 导航-->
<!--the beginning of 中间-->
<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">班级管理</a> &gt; <span class="deep_bule">导入班级学员</span></div>
<div class="admin_lc"><img
	src="${ctx}/css/admin_image/admincx03.jpg" width="760" height="35" /></div>
<p>&nbsp;</p>
<!--<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<s:iterator value="errorList" status="stat" id="error">
	<tr><s:property value="error"/></tr>
	</s:iterator>
</table>
-->
<ul>
<s:iterator value="errorList" status="stat" id="error">
	<li><s:property value="error"/></li>
</s:iterator>
</ul>
<form id="inputform" action="clazz!saveimport.action" method="post"
	enctype="multipart/form-data">
    <input type="hidden"name="clazzid" value="${clazzid}" />
	<input type="hidden"name="planid" value="${planid}" />
	<input type="hidden" name="isSuccess" value="false" />
	<!--<input type="hidden" name="uploadFileName" value="${uploadFileName}" />
	<input type="file" id="upload" name="upload" class="wjy" value="${upload}"/>
--><div style="clear: both"></div>
<center>
<input type="submit" id="next" value="下一步" class="operation_btu1" /></center>
</form>
</body>
</html>
