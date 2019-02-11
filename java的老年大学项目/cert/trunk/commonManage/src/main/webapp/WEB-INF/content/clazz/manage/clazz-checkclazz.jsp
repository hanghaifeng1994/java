<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>


<script src="${staticurl}/js/related.js" type="text/javascript"></script>

<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$('#form1').submit(function()
	{
		$("#clazzmanager option").each(function()
	{
	$("#form1").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='"+$(this).val()+"'/>");
	})
	});
});
</script>
</head>

<body>
<!--the beginning of 头部-->
<!--the beginning of 导航-->
<!--the beginning of 中间-->

<div id="content">
<div class="box">

<div class="detailbox">
<div id="message"><s:actionmessage theme="custom"
	cssClass="tipbox" /></div>
<form id="form1" action="clazz!savemanager.action" method="post"><input
	type="hidden" name="id" value="${id}" /> <input type="hidden"
	name="clazzid" value="${clazzid}" /> <input type="hidden"
	value="${flag }" name="flag" />

<div id="news_edit" class="form input mb20">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="adminedit">
	<tr>

		<td width="20%"><select size="10"
			style="height: 200px; width: 200px; display: block;"
			id="clazzmanager">
		</select></td>
		<td align="left">输入教师的身份证号（必须是已注册的用户）<br />
		<input type="text" id="idcard" /> <input type="button" value="添加"
			class="operation_btu1" id="adduser" /> <br />
		选左侧列表中选择用户，然后点击删除 <br />
		<input type="button" class="operation_btu1" value="删除"
			id="removemanager" /></td>
	</tr>

</table>
</div>
<div class="lh32 tc" style="text-align: left; float: left;"><s:if
	test="flag=='group'">
	<input class="operation_btu1 w60 ll ml20" type="submit" value="下一步" />
</s:if> <s:else>
	<input class="operation_btu1 w60 ll ml20" type="submit" value="开班" />
</s:else></div>
</form>
</div>
</div>
</div>
<p>&nbsp;</p>
</body>
</html>
