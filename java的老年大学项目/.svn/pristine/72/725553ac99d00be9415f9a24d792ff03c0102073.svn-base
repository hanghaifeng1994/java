<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<%@ include file="/common/title.jsp" %></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/related.js" type="text/javascript"></script>
<script>  
	$(document).ready(function() {
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
	 			name: {
					required: true,
					maxlength: 50
				}  
 			},
 			messages: {
 				name: {
 					required: "请输入资格名称",
 					maxlength: "资格名称最多为50个字符,请重新输入"
 				}
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});
</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>

<body>
<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">资格管理</a> &gt; <span class="deep_bule"><s:if
	test="id == null">新增</s:if><s:else>编辑</s:else>资格</span></div>
<form id="form1" action="qualification!save.action" method="post">
<input type="hidden" name="id" value="${id}" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="adminedit">
	<tr>
		<td class="tdll" style="width:10%">资格名称<span class="admin_red">*</span></td>
		<td style="width:20%"><input type="text" value="${name}" id="name" name="name"
			class="txtinput01" /> <span class="ml10 font999"> </span></td>
		<td style="width:40%"><strong id="error_name" class="admin_woring_x"></strong></td>
	</tr>
	<tr>
		<td class="tdll" style="width:10%">资格等级</td>
		<td valign="middle">${qualificationLevel}<input type="hidden" name="qualificationLevel"
			value="${qualificationLevel}" /> <span class="ml10 font999"> <strong
			id="error_code"></strong> </span></td>
	</tr>
<s:if test="qualificationLevel>1">
	<tr>
		<td class="tdll" style="width:10%">上级资格</td>
		<td valign="middle"><input type="hidden" name="parentId"
			value="${parent.id}" /> ${parent.name}<span class="ml10 font999"></span></td>
	</tr>
</s:if>
	<tr>
		<td class="tdll">&nbsp;</td>
		<td><span class="fl"> <input name="Submit32" type="submit"
			class="operation_btu1" value="保 存" /> <input
			onclick="window.location.href='qualification.action'" type="button"
			class="operation_btu2" value="取 消" /> </span></td>
	</tr>
</table>
</form>
</body>
</html>
