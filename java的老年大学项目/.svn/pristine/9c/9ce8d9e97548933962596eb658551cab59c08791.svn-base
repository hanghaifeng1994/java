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
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入班级代码"
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
<small>
<s:if test="clazz.check">
已经审核
</s:if>
</small>
</h3>
</div>
<hr/>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" onclick="window.location.href='clazz!allow.action?clazzid=${id}'" >
<span class="glyphicon glyphicon-ok"></span>
同意开班
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" onclick="window.location='clazz!deny.action?clazzid=${id}'">
<span class="glyphicon glyphicon-remove-circle"></span>
不同意开班
</button>
</div>

<div class="panel panel-default mt20">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">

	<tr>
		<th>申请人</th>
		<td width="35%" style="padding-left: 20px;">${clazzDTO.applyUser.name }</td>
		<th width="13%">申请时间</th>
		<td width="39%">
		<s:date name="clazzDTO.applyDate" format="yyyy-MM-dd"/>
		</td>
	</tr>

</table>
</div>
</div>
</div>

<div class="bs-example">
<ul class="nav nav-tabs" id="tab">
	<li><a href="clazz!vinfo.action?id=${id }">班级情况</a> </li>
	<li class="active"><a href="clazz!vcourselist.action?id=${id }">选课情况</a></li>
	<li><a href="clazz!vstudents.action?id=${id }">学员列表</a></li>
</ul>
</div>

<div class="tab-content dr-tabs-panel">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
    <tr>
      <th>报名项目</th>
      <td>${clazzDTO.programName }</td>
      </tr>
    <tr>
      <th>项目阶段</th>
      <td>${clazzDTO.phaseName }</td>
      </tr>
  </table>
  </div>
  </div>
<div class="panel-body row">
<div class="col-md-12">
  <table class="table table-bordered dr-table-default">
		<tr>
			<th>课程名称</th>
			<th>模块属性</th>
			<th>课程属性</th>
			<th>学分</th>
		</tr>
		<s:iterator value="classCoursePage.result" status="stat">
			<tr>
				<td>&nbsp;${course.name}</td>
				<td>&nbsp;${course.courseModelString}</td>
				<td>&nbsp;${coursePropString}</td>
				<td>&nbsp;${course.studylength }</td>
			</tr>
		</s:iterator>
	</table>
	</div>
	</div>	
</div>
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
