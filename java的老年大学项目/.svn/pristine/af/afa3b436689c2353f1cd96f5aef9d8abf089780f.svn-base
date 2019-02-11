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
$(document).ready(function(){
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
    $('#mainForm').submit(function() {
        $("#clazzmanager option").each(function() {
            $("#mainForm").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='" + $(this).val() + "'/>");
        })
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
<small>
<s:if test="clazz.check">
已经审核
</s:if>
</small>
</h3>
</div>
<hr/>

<form id="mainForm" action="clazz!saveallow.action" method="post">
	<input type="hidden" name="id" value="${clazzid}" />
	<input type="hidden" name="clazzid" value="${clazzid}" />
<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<th>培训项目名称</th>
		<td width="35%">${clazzDTO.programName }</td>
		<th width="13%">项目阶段</th>
		<td width="39%">${clazzDTO.phaseName }</td>
	</tr>
	<tr>
		<th>班级名称</th>
		<td width="35%">${clazzDTO.name }</td>
		<th width="13%">班级代码</th>
		<td width="39%">${clazzDTO.code }</td>
	</tr>
	<tr>
		<th>班级类型</th>
		<td width="35%">${clazzDTO.modelString }</td>
		<th width="13%">班级人数</th>
		<td width="39%">${clazzDTO.allStudentCount}</td>
	</tr>
	<tr>
		<th>班级开放时间</th>
		<td width="35%">
		<s:if test="clazzDTO.StudyUndate">
		无限制
		</s:if>
		<s:else>
		<s:date name="clazzDTO.startDate" format="yyyy-MM-dd"/> 至 <s:date name="clazzDTO.closeDate" format="yyyy-MM-dd"/>
		</s:else>
		</td>
		<th width="13%">选课数</th>
		<td width="39%">${clazzDTO.clazzCourseCount }</td>
	</tr>	
</table>
</div>
</div>
<s:if test="!clazzDTO.selfClass">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default mt10">
	<tr>
		<th width="13%">报名人数</th>
		<td>${clazzDTO.noStudentCount }</td>
	</tr>
	<tr>
		<th>学分/人</th>
		<td>${clazzDTO.courseStudyLength }</td>
	</tr>
	<tr>
		<th>费用总计<span class="admin_red">*</span></th>
		<td>${clazzDTO.shouldTotalPrice}</td>
	</tr>
	<tr>
		<th>实收款<span class="admin_red">*</span></th>
		<td valign="middle"><input name="factPrice" type="text" value="${clazzDTO.factPrice}"
			class="txtinput01 fl" /></td>
	</tr>
	<tr>
		<th>备注</th>
		<td valign="middle">${clazzDTO.remarks}</td>
	</tr>	
</table>
</div>
</div>
</s:if>
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<td width="50%" valign="top">
		<s:select size="10"  cssClass="txtwb" cssStyle="width: 100%;margin: 10px auto;border: 1px solid #CCCCCC;height: 90px;"
			id="clazzmanager" list="headerClazzList" listKey="username" listValue="nameplusidcard"  theme="simple">
		</s:select> 
		    <button id="removemanager" class="btn btn-default btn-sm" type="button">
             <span class="glyphicon glyphicon-trash"></span>
                                  删除
             </button>
		</td>
		<td width="50%" valign="top">
			<div class="mb10">
			<p>输入教师的身份证号<span style="color: #737373;">（必须是已注册的用户）</span></p>
			<input type="text" id="idcard" class="form-control"/>
			<div class="btn-group mt5">
            <button class="btn btn-primary btn-sm" type="button" id="adduser">
              <span class="glyphicon glyphicon-plus"></span>
                                  添 加
            </button>
            </div>
			</div>
		</td>
	</tr>
</table>
</div>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-10">	
<s:if test="!clazzDTO.check">
<button class="btn btn-primary btn-sm" type="submit" onclick="window.location.href='clazz!allow.action?clazzid=${id}'" >
<span class="glyphicon glyphicon-ok"></span>
同意开班
</button>
</s:if>
<button name="Submit32" class="btn btn-primary btn-sm" type="button" onclick="window.location='${ctx}/clazz/manage/clazz!vinfo.action?id=${clazzDTO.id }'">
<span class="glyphicon glyphicon-backward"></span>
返回
</button>
</div>
</div>
</div>
</div>
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
</form>
</div>
</section>
</div>
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>