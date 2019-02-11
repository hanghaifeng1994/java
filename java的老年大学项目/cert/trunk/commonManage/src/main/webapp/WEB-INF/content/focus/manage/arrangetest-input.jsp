<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考场安排<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<!--<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
-->
<%@ include file="/common/admin_meta.jsp"%>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script>  
	$(document).ready(function() {
		 $("#startTime").datetimepicker({
	    	 customFormat: "yyyy-mm-dd hh:ii:ss",
			 format: "yyyy-mm-dd hh:ii",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 0,
			 forceParse: 0,
		}); 
		 $("#finishedTime").datetimepicker({
	    	 customFormat: "yyyy-mm-dd hh:ii:ss",
			 format: "yyyy-mm-dd hh:ii",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 0,
			 forceParse: 0,
		}); 
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		jQuery.validator.addMethod("compareDate", function(value, element, param) {
	 			var startDate = jQuery(param).val();
				if(startDate!=''){
	            var date1 = new Date(parseInt(Date.parse(startDate.replace(/\-/g, "/")),10));
	            var date2 = new Date(parseInt(Date.parse(value.replace(/\-/g, "/")),10));
	            if(value=='' && startDate=='')return true;
	            else
	            	return date1 < date2;
				}else 
					return true;
 	  		}, "结束时间必须大于开始时间");
 		$("#form1").validate({
 			rules: {
 			startTime: {
				required: true
			}  
			,finishedTime:
			{
				required: true,
				compareDate:"#startTime"
			}
 			 
 			},
 			messages: {
 				startTime: {
 					required: "请输入开始时间"
 				}
				,finishedTime:
				{
					required: "请输入结束时间"
				} 
 			},
 			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
		    onfocusin: function(element) { $(element).valid(); },
	        success: function(label) { 
				var e = $(label).parent().attr("id").split("_")[1];
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
					//alert($(this).html())
				});
		    } ,
	        errorElement: "strong" 
 		});

 		
 	});
	function back(id){
 		window.location='arrangetest.action?batchId='+id
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
<a href="#">考场安排</a>
</li>
<li class="active">新增考场
</li>
</ol>

<div class="dr-page-header">
<h3>
新增考场
</h3>
</div>
<hr/>
<div class="panel panel-default">
<form id="form1" action="arrangetest!save.action" method="post" class="form-horizontal dr-form-bordered" role="form">
<input type="hidden" name="id" value="${id}" />
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">考场基本信息</h4>
</div>
</div>

<div class="form-group">
<input type="hidden" name="batchId" value="${batchId }" />
<label class="col-md-2 control-label">考场<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<select name="resId" style="width:300px;height:30px;">
           	<c:forEach items="${userFocusResourceDTOList}" var="item">
           	   <option  value="${item.id }" <c:if test="${item.id eq userFocusExamtimeDTO.userFocusResource.id}">selected="selected"</c:if>>${item.resName}</option>
           	</c:forEach>
           </select>
		</div>
		<span id="error_name" class="help-block"></span>
</div>
<div class="form-group" id="validate_startTime">
<label class="col-md-2 control-label">开始时间<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input name="startTime" id="startTime" style="width: 300px" value="<s:date name="userFocusExamtimeDTO.startTime" format="yyyy-MM-dd HH:mm"/>" class="form-control input-sm"/>
		</div>
		<span id="error_startTime" class="help-block"></span>
</div>
<div class="form-group" id="validate_finishedTime">
<label class="col-md-2 control-label">结束时间<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input name="finishedTime" id="finishedTime" value="<s:date name="userFocusExamtimeDTO.endTime" format="yyyy-MM-dd HH:mm"/>" style="width: 300px" class="form-control input-sm"/>
		</div>
		<span id="error_finishedTime" class="help-block"></span>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">
    <div class="btn-group">
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit" >
        <span class="glyphicon glyphicon-ok"></span>
        保存
        </button>
    </div>
    <div class="btn-group">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="back('${batchId}')">
        <span class="glyphicon glyphicon-remove"></span>
                     取消
        </button>
    </div>
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
<!--正文结束-->
</body>
</html>
