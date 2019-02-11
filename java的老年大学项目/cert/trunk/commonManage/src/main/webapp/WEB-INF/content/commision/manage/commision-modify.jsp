<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>编辑佣金码规则信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp" %>
</head>

<link href="${staticurl}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${staticurl}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${staticurl}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<body>

<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->

<div class="dr-wrapper">
    <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="commisionlist" name="menu" />
	<jsp:param value="commision" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->

  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">佣金码规则管理</a></li>
     <li class="active">
        <span class="deep_bule">编辑普通佣金码规则 </span>
     </li>
    </ol>
   <div class="dr-page-header">
     <h3>更改佣金码规则信息</h3>
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
    <h4 class="text-primary">更改佣金码规则信息</h4>
    </div>
   </div>
   <div id="detail">
 			<script type="text/x-handlebars-template" id="detailTemplate">
 
      <div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">佣金比例<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="name" name="name" type="text" class="form-control" value="{{data.rate}}"/> 
       </div>
       <span class="help-block" id="error_username"></span>
  </div>

     <div class="form-group" id="validate_startTime">
				<label class="col-md-2 control-label"> 开始时间 <span
					class="text-danger">*</span>
				</label>
				<div class="input-group date col-md-3"
					style="padding-left: 15px; float: left;">
					<input type="text"
						value="{{data.start_time}}"  id="start_time"
						name="start_time" readonly="readonly"
						class="form-control input-sm" /> <span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-th"></span></span>
				</div>
				<span class="help-block" id="error_startTime"></span>
			</div>
     
     
     
  			<div class="form-group" id="validate_endTime">
				<label class="col-md-2 control-label"> 结束时间 <span
					class="text-danger">*</span>
				</label>
				<div class="input-group date col-md-3"
					style="padding-left: 15px; float: left;">
					<input type="text"  id="end_time"
						value="{{data.end_time}}"
						name="end_time" readonly="readonly" class="form-control input-sm" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-th"></span></span>
				</div>
				<span class="help-block" id="error_endTime"></span>
			</div>


  	<div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">是否启用<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <select class="form-control input-sm" id="enabled" name="enabled">
				      <option value="" selected="selected">---是否启用---</option>
				      <option value="1">启用</option>
				      <option value="0">禁用</option>
				    </select>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>

<div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">佣金规则说明</label>
	    <div class="col-md-3">
	      <textarea id="ruledesc" name="ruledesc" class="form-control" style="width:500px; height:120px;">{{data.ruledesc}}</textarea>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
     <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">佣金发放规则说明</label>
	    <div class="col-md-3">
	      <textarea id="senddesc" name="senddesc" class="form-control" style="width:500px; height:120px;">{{data.senddesc}}</textarea> 
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
     
      <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">服务号码</label>
	    <div class="col-md-3">
	        <input id="telephone" name="telephone" type="text" value="{{data.telephone}}" class="form-control"/> 
        </div>
        <span class="help-block" id="error_name"></span>
     </div>


</script>
   </div>
    <div class="panel-footer">
       <div class="row">
       <div class="col-md-offset-2 col-md-10">
     <button class="btn btn-primary"  name="Submit32" id="btnsave" type="button">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     
     <button class="btn btn-default" onclick="window.location.href='commision.action'" type="button">
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
params.payload.tenant_id='${tenantId}';
function inittime(d){
	$("#enabled").val(d.data.enabled);
	$("#start_time").datetimepicker({
		 language : 'zh-CN',  
		    weekStart : 1,  
		    todayBtn : 1,  
		    autoclose : 1,  
		    todayHighlight : 1,  
		    startView : 2,  
		    format: 'yyyy-mm-dd hh:ii:00', 

   }).on('hide', function(event) {  
	    event.preventDefault();  
	    event.stopPropagation();  
	    var startTime = event.date;  
	    $("#end_time").datetimepicker('setStartDate',startTime);  
	    $("#end_time").val("");  
	});  

   
   	$("#end_time").datetimepicker({
   		  language : 'zh-CN',  
 		    weekStart : 1,  
 		    todayBtn : 1,  
 		    autoclose : 1,  
 		    todayHighlight : 1,  
 		    startView : 2,  
 		    format: 'yyyy-mm-dd hh:ii:59',  

   }).on('hide', function(event) {  
	    event.preventDefault();  
	    event.stopPropagation();  
	    var endTime = event.date;  
	    $("#start_time").datetimepicker('setEndDate',endTime);  
	});  
}

$(function(){
	params.payload.commision_id=api.p('id');
	api.load('${ctx}','SellApiWeb/api/manage/commision/detail.do','detailTemplate','detail',inittime)
	$("#btnsave").click(function (){
		params.payload.rate=$.trim($('#name').val())  || '';
		params.payload.start_time=$.trim($('#start_time').val())  || '';
		params.payload.end_time=$.trim($('#end_time').val())  || '';
		params.payload.enabled=$.trim($('#enabled').val())  || 1;
		
		params.payload.ruledesc=$.trim($('#ruledesc').val())  || '';
		params.payload.senddesc=$.trim($('#senddesc').val())  || '';
		params.payload.telephone=$.trim($('#telephone').val())  || '';
		
		if(params.payload.rate==''||params.payload.start_time==''||params.payload.end_time=='')
			{
				b_alert('请输入必填信息');
				return ;
			}
		
		
		api.exec('${ctx}','SellApiWeb/api/manage/commision/modify.do',function (){window.location.href='commision.action';})
		}
	)
});
</script>

</body>
</html>