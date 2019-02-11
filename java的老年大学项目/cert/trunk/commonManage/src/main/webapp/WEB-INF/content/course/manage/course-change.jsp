<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>前台显示<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
    <%@ include file="/common/admin_meta.jsp"%>
	<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
	<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>

 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	<link rel="stylesheet" href="${ctx}/jcrop_zh/css/jquery.Jcrop.css" type="text/css" />
    <script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/jcrop_zh/js/jquery.Jcrop.js"></script>
	<link href="${staticurl}/css/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${staticurl}/js/layer.js" type="text/javascript"></script>
    <script src="${ctx}/js/cutpic.js" type="text/javascript"></script>        
    
<script>
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
});
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="change-course" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">区域课程属性设置</a>
</li>
<li class="active">前台显示</li>
</ol>

<div class="dr-page-header">
<h3>
设置前台显示的课程
</h3>
</div>
<hr/>	
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
<div class="panel panel-default">
<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="course!coursesave.action" method="post">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>
<input id="id" name="finishedneed" type="hidden" value="" size="30"/>

<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">租户课程属性设置</h4>
</div>
</div>
<div class="form-group" id="validate_isdiplay">
    <label class="col-md-3 control-label">显示其他租户开放课程<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
    <s:radio cssClass="ml5 mr5" onchange="" cssStyle="font-weight: normal;" list="#{0:'不显示',1:'显示'}" id="selectperm" value="isdisplay"  name="isdisplay" theme="simple"></s:radio>
    <span class="text-danger" id="error_coursePermission"></span>
</div>
</div>

<div class="form-group" id="validate_display">
    <label class="col-md-3 control-label">开放私有课程给其它租户<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
    <s:radio cssClass="ml5 mr5" onchange="" cssStyle="font-weight: normal;" list="#{false:'不显示',true:'显示'}" id="select1perm" value="display"  name="display" theme="simple"></s:radio>
    <span class="text-danger" id="error_coursePermission"></span>
</div>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">	
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
        </button>
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='course.action'">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
        </button>
</div>
</div>
</div>

</form>
</div>
</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
</section>
</div>
</body>
</html>
