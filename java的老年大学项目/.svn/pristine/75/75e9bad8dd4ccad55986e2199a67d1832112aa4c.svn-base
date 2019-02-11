<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>

<script>
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
$("#inputForm").validate({
 			rules: {
				denyinfo: {
					required: true
				}  
 			},
 			messages: {
 				denyinfo: {
 					required: "请输入不同意理由"
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
</head>

<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over--> 
<div class="dr-wrapper">
<section id="main" role="main">

<div class="dr-container-fluid">
<div class="dr-page-header">
<h3>
班级申请审核
</h3>
</div>
<hr/>

<form id="inputForm" name="inputForm"
	action="${ctx}/clazz/manage/clazz!savedeny.action" method="post">
<input type="hidden" name="id" value="${clazzid}" /> <input
	type="hidden" name="clazzid" value="${clazzid}" />
<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">

	<tr>
		<th>项目类型</th>
		<td width="35%">${clazz.itemCategoryName }</td>
		<th width="13%">培训项目名称</th>
		<td width="39%">${clazz.trainingProgramsName }</td>
	</tr>
	<tr>
		<th>年度教学计划</th>
		<td width="35%">${clazz.planName }</td>
		<th width="13%">培训项目代码</th>
		<td width="39%">${clazz.trainingProgramsCode }</td>
	</tr>
	<tr>
		<th>班级名称</th>
		<td width="35%">${clazz.name }</td>
		<th width="13%">班级代码</th>
		<td width="39%">${clazz.code }</td>
	</tr>
	<tr>
		<th>班级类型</th>
		<td width="35%">${clazz.modelString }</td>
		<th width="13%">班级人数</th>
		<td width="39%">0</td>
	</tr>
	<tr>
		<th>班级开放时间</th>
		<td width="35%">${clazz.startDate }</td>
		<th width="13%">选课数</th>
		<td width="39%">${clazz.courseCount }</td>
	</tr>
	<tr>
		<th>不同意理由<span class="text-danger mt5">*</span></th>
		<td colspan="3"><textarea name="denyinfo" rows="8" cols="50" class="fl">${clazz.denyinfo }</textarea>
		
		<span id="error_denyinfo" class="admin_woring_x fr"></span>
		</td>
	</tr>
	<tr>
		<td colspan="4">
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
		<span class="glyphicon glyphicon-ok"></span>
		同意开班
		</button>
		<button name="Submit32" class="btn btn-primary btn-sm" type="button" onclick="window.location='${ctx}/clazz/manage/clazz!vinfo.action?id=${clazz.id }'">
		<span class="glyphicon glyphicon-backward"></span>
		返回
		</button>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
</td>
	</tr>
</table>
</div>
</div>
</div>
</form>
</div>
</section>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
