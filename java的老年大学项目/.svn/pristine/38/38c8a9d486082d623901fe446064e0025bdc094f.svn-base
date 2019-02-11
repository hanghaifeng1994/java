<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="java.util.Random"%>
<html>
<head>
<title>新增管理员信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp" %>
</head>
<body>
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->

<div class="dr-wrapper">
    <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="managerslist" name="menu" />
	<jsp:param value="student" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->

  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">用户管理</a></li>
     <li class="active">
        <span class="deep_bule">新增管理员 </span>
     </li>
    </ol>
   <div class="dr-page-header">
     <h3>新增管理员信息</h3>
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
<form id="inputForm" name="inputForm" class="form-horizontal dr-form-bordered" 
	action="manager!save.action"
	method="post">
	<input id="shopuser_id" name="shopuser_id" type="hidden" value="" size="30" /> 
 
  <div class="dr-form-title clearfix">
    <div class="col-md-12">
    <h4 class="text-primary">新增管理员基本信息</h4>
    </div>
   </div>
   <div id="detail">
   <div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">用户名<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="username" name="username" type="text" value="" class="form-control"/> 
       </div>
       <span class="help-block" id="error_username"></span>
  </div>
  
     <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">姓名<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="name" name="name" value="" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
  
     <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">手机号<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="mobile" name="mobile" value="" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
     
       <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">密码<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="password" name="password" value="" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
     
     
   </div>
    <div class="panel-footer">
       <div class="row">
       <div class="col-md-offset-2 col-md-10">
     <button class="btn btn-primary"  name="Submit32" id="btnsave" type="button">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     
     <button class="btn btn-default" onclick="window.location.href='manager.action'" type="button">
       <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
     </button>
  
     </div>
     </div>
     
</form>
</div>

</div>
</div>
		  <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	</jsp:include>
</section>
</div>
<script type="text/javascript">
$(function(){
	params.payload.tenant_id='${tenantId}';
	$("#btnsave").click(function (){
		params.payload.username=$.trim($('#username').val())  || '';
		params.payload.name=$.trim($('#name').val())  || '';
		params.payload.mobile=$.trim($('#mobile').val()) || '';
		params.payload.password=$.trim($('#password').val()) || '';
		if(params.payload.name==''||params.payload.mobile==''||params.payload.role==''||params.payload.username==''||params.payload.password=='')
		{
			b_alert('请输入必填信息');
			return ;
		}
		
		params.payload.role='manager';
		params.payload.status=1;
		api.exec('${ctx}','SellApiWeb/api/manage/shopuser/add.do',function (){window.location.href='manager.action';})
		}
	)
});
</script>

</body>
</html>