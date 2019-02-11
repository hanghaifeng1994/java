<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${programDTO.name}教学内容<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />

<script>  
	$(document).ready(function() {
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#inputForm").validate({
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
 					required: "请输入项目名称",
 					maxlength: "项目名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入项目代码"
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
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--正文开始-->
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">

<div class="dr-page-header">
<h3>
<label style="margin-right: 10px;">${programDTO.name}</label>项目管理
</h3>
</div>
<hr />
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
<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
	 	<li><a href="programs!minput.action?id=${programId}">培训项目属性设置</a></li>
        <li><a style="cursor: pointer;" href="phase.action?programId=${programId}">项目阶段</a></li>
        <li class="active"><a style="cursor: pointer;" href="teachcontent.action?programId=${programId}&menu=menu">教学内容设置</a></li>
        <li><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>                
</div>
<div class="tab-content dr-tabs-panel">
	<div class="panel-body row">
		<table class="table table-bordered dr-table-default">
			<tr>
				<th>培训项目名称</th>
				<td>${programDTO.name }</td>
				<th>培训项目代码</th>
				<td>${programDTO.code }</td>
				<th>毕业学分要求</th>
				<td>${programDTO.hours }学分</td>
			</tr>
		</table>
		<div class="panel panel-default">
		<form class="form-horizontal dr-form-bordered" name="inputForm" id="inputForm" action="teachcontent!save.action" method="post">
				<input type="hidden" name="id" value="${id}" />
				<input type="hidden" name="programId" value="${programId}" />
				
				<div class="dr-form-title clearfix">
				<div class="col-md-12">
				<h4 class="text-primary">教学内容信息</h4>
				</div>
				</div>
				
				<s:if test="id!=null">
					<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">教学内容名称<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
					<input type="text" value="${name}" id="name" name="name" class="form-control"></input>
					</div>
					<span class="help-block" id="error_name"></span>
					</div>
				
					<div class="form-group" id="validate_version">
					<label class="col-md-2 control-label">版本号<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
					<input type="text" value="${version}" id="version" name="version" class="form-control"></input>
					</div>
					<span class="help-block" id="error_name"></span>
					</div>
				</s:if>
				<s:else>
					<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">教学内容名称<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
					<input type="text" value="${teachContentName}" id="name" name="name" class="form-control"></input>
					</div>
					<span class="help-block" id="error_name"></span>
					</div>
				</s:else>	
				
				<div class="panel-footer">
				<div class="row">
				<div class="col-md-offset-2 col-md-10">
				 	<button name="Submit32" type="submit" class="btn btn-primary btn-sm" onclick="checkedError()">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
					</button> 
					<button onclick="window.location.href='teachcontent.action?programId=${programId}'" type="button" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-remove"></span>&nbsp;取消
					</button>
				</div>
				</div>
				</div>
		</form>
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