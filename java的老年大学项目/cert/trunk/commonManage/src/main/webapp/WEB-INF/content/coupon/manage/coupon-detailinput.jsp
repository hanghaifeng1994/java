<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>新增优惠码规则明细信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp" %>
</head>
<link href="${staticurl}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${staticurl}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${staticurl}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {
	params.payload.tenant_id='${tenantId}';
	$("#start_time").datetimepicker({
		   language : 'zh-CN',  
		    weekStart : 1,  
		    todayBtn : 1,  
		    autoclose : 1,  
		    todayHighlight : 1,  
		    startView : 2,  
		    minView: "month",  
		    format: 'yyyy-mm-dd',  
		    forceParse : 0  

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
			    minView: "month",  
			    format: 'yyyy-mm-dd',  
			    forceParse : 0  

    }).on('hide', function(event) {  
	    event.preventDefault();  
	    event.stopPropagation();  
	    var endTime = event.date;  
	    $("#start_time").datetimepicker('setEndDate',endTime);  
	});  

    
});
</script>
<body>

<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->

<div class="dr-wrapper">
    <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="couponlist" name="menu" />
	<jsp:param value="coupon" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->

  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">优惠码优惠规则管理</a></li>
     <li class="active">
        <span class="deep_bule">新增优惠码规则明细 </span>
     </li>
    </ol>
   <div class="dr-page-header">
     <h3>新增优惠码规则明细信息</h3>
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
    <h4 class="text-primary">新增优惠码规则明细基本信息</h4>
    </div>
   </div>
   <div id="detail">
   <div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">优惠金额<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="discount_price" name="discount_price" type="text" value="" class="form-control"/> 
       </div>
       <span class="help-block" id="error_username"></span>
  </div>
  
     
     
<div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">优惠起始金额<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="min_price" name="min_price" type="text" value="" class="form-control"/> 
       </div>
       <span class="help-block" id="error_username"></span>
  </div>
  
  <div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">优惠截止金额<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="max_price" name="max_price" type="text" value="" class="form-control"/> 
       </div>
       <span class="help-block" id="error_username"></span>
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
     
     
  
   </div>
    <div class="panel-footer">
       <div class="row">
       <div class="col-md-offset-2 col-md-10">
     <button class="btn btn-primary"  name="Submit32" id="btnsave" type="button">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     
     <button class="btn btn-default" rel="rewrite" url="coupon!detaillist.action?id=$cid" onclick="window.location.href=$(this).attr('url')" type="button">
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
	 $("*[rel='rewrite']").each(function (){
         $(this).attr("url",$(this).attr("url").replace("$cid",api.p('cid')));
         })
         
	$("#btnsave").click(function (){
		params.payload.discount_price=$.trim($('#discount_price').val())  || '';
		params.payload.min_price=$.trim($('#min_price').val())  || '';
		params.payload.max_price=$.trim($('#max_price').val())  || '';
		params.payload.enabled=$.trim($('#enabled').val())  || 1;
		params.payload.coupon_id=api.p('cid');
		params.payload.category_id=1;
		
		if(params.payload.name==''||params.payload.start_time==''||params.payload.end_time=='')
		{
			b_alert('请输入必填信息');
			return ;
		}
		
		api.exec('${ctx}','SellApiWeb/api/manage/couponDetail/add.do',function (){window.location.href='coupon!detaillist.action?id='+params.payload.coupon_id;})
		}
	)
});
</script>

</body>
</html>