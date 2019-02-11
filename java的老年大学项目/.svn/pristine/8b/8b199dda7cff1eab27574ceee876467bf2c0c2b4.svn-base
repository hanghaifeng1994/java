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
<table width="98%" align="center" cellspacing="5" bordercolor="#ACCEE8"
	class="admin_tab10">
	<tbody>
		<tr>
			<td class="buleleft" width="20%">报名人数</td>
			<td width="82%">${clazz.studentCount }人</td>
		</tr>
		<tr>
			<td class="buleleft">学分/人</td>
			<td>${clazz.courseStudyLength } 学分</td>
		</tr>
		<tr>
			<td colspan="2"><s:if test="flag=='group'">
				<input class="operation_btu1 w60 ll ml20" type="submit" value="上一步" />
			</s:if> <s:else>
				<input class="operation_btu1 w60 ll ml20" type="button" value="提交审核"
					onclick="window.close()" />
			</s:else></td>
		</tr>
	</tbody>
</table>
</div>

</form>
</div>
</div>
</div>
<p>&nbsp;</p>
</body>
</html>
