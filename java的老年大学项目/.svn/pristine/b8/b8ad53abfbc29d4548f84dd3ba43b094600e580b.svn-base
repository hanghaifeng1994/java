<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url"));
request.setAttribute("manageUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","manage.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<html>
<head>
<title>新增兑换规则<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
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
	        $("#startTime").datetimepicker({
				 format: 'yyyy-mm-dd hh:ii',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 0,
				 forceParse: 0,
			}); 
			
			$("#rate").focus();

			$("#inputForm").validate({
				rules: {
				    rate: {
						required: true,
						number:true
					},
					startTime:{
						required: true
					}
				},
				messages: {
					rate: {
						required:"请输入兑换比例",
						number:"兑换比例只能是数字"
					},
					startTime:{
						required:"请输入开始启用日期"
					}
				},
				onsubmit: function(element) { $(element).valid(); },
				onfocusout: function(element) { $(element).valid(); },			
				onkeyup: function(element) { $(element).valid(); },
			    onfocusin: function(element) { $(element).valid(); },
		        success: function(label) {
			        var divId = $(label).parent().attr("id");
			    	var startindex = divId.indexOf("_"); 
			    	var e = divId.substring(startindex+1);
					//var e = $(label).parent().attr("id").split("_")[1];
					var oclass=$("#validate_"+e).attr("class");
					if(oclass && oclass.indexOf("form-group")>-1)
						oclass = "form-group";
					else
						oclass="";
		        	$("#validate_"+e).attr("class",oclass+" has-success")     
		    		$(label).remove();
		        },
		        errorPlacement: function(error, element) { 
			        if (document.getElementById("error_"+element.attr("name")))  {
			            error.appendTo("#error_"+element.attr("name")); 
						var oclass=$("#validate_"+element.attr("name")).attr("class");
						if(oclass && oclass.indexOf("form-group")>-1)
							oclass = "form-group";
						else
							oclass="";
			        	$("#validate_"+element.attr("name")).attr("class",oclass+" has-error");    
			        }	
			        else{
		            	error.insertAfter(element);   
			        }       
		        },
			    invalidHandler: function(form, validator) {  //不通过时回调
					$(".error").each(function(i){
						var id = $(this).parent().attr("id");
						if(id && id.indexOf("_")>0){
						    var f = id.split("_")[1];
							var oclass=$("#validate_"+f).attr("class");
							if(oclass && oclass.indexOf("form-group")>-1)
								oclass = "form-group";
							else
								oclass="";
						    $("#validate_"+f).attr("class",oclass+" has-success")
						    $(this).remove();
						}
					});
			    } ,
				submitHandler: function(form) {
					form.submit();
				}			
			});
		});
		
function close(){
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
}
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
	<jsp:param value="coinrule" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">基础数据管理</a>
</li>
<li>
<a href="#">兑换规则设置</a>
</li>
<li class="active"><s:if test="id==null">新增</s:if><s:else>编辑</s:else>兑换规则</li>
</ol>

<div class="dr-page-header">
<h3>
<s:if test="id==null">新增</s:if><s:else>编辑</s:else>兑换规则
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
<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="coinrule!save.action" method="post" enctype="multipart/form-data">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>
<div class="form-group" id="validate_rate">
     <label class="col-md-2 control-label">兑换比例<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="rate" value="${rate}" type="text" class="form-control"/>
     </div>
     <span class="help-block" id="error_rate"></span>
</div>
<div class="form-group">
    <label class="col-md-2 control-label">开始启用日期</label>
    <div class="input-group date col-md-3"  id="startTime" style="padding-left: 15px;float: left;margin-right: 5px;"> 
    <input type="text"  value="<s:date name="startTime" format="yyyy-MM-dd HH:mm" />"
			readonly="readonly" name="startTime" class="form-control" />
	    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>
	<span class="text-danger" id="error_startTime"></span>
</div>

</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">	
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
        </button>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='coinrule.action'">
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
