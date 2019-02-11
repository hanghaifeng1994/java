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
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<style>
.form-control{
width:350px;
float:left;
margin-right:10px;
}
</style>
<script>  

	var pageprogramsid;
	var pageplanid;

	function initcategory()
	{		
		$("#itemid").change();
		pageprogramsid=${clazzDTO.programId};
		pageplanid=${clazzDTO.phaseId};
	}

	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();   
		$("#programsid option:selected").text("${clazzDTO.programName}")
		$("#programsid option:selected").val(${clazzDTO.programId})
		$("#phaseId option:selected").text("${clazzDTO.phaseName}")
		$("#phaseId option:selected").val(${clazzDTO.phaseId})
		
        $("#startDate").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0          
         }); 
       $("#closeDate").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0          
        });   
       $("#limitStartDate").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0         
       });    
       $("#limitEndDate").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0        
      }); 
		

		
		initcategory();
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			clazzname: {
				required: true,
				maxlength: 20
			}  
			,clazzcode:
			{
				required: true
			}
 			},
 			messages: {
 				clazzname: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,clazzcode:
				{
					required: "请输入班级代码"
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
	        errorElement: "strong" ,
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
<s:if test="!clazz.check">
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" onclick="window.location.href='clazz!allow.action?clazzid=${id}'" >
<span class="glyphicon glyphicon-ok"></span>&nbsp;同意开班</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" onclick="window.location='clazz!deny.action?clazzid=${id}'">
<span class="glyphicon glyphicon-remove"></span>&nbsp;不同意开班</button>
</div>
</s:if>
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
	<li class="active"><a href="clazz!vinfo.action?id=${id }">班级情况</a> </li>
	<li><a href="clazz!vcourselist.action?id=${id }">选课情况</a></li>
	<li><a href="clazz!vstudents.action?id=${id }">学员列表</a></li>
</ul>
</div>
<div class="tab-content dr-tabs-panel">
<form id="form1" action="clazz!saveclazz.action" method="post" class="form-horizontal dr-form-bordered">
<input	type="hidden" name="clazz.id" value="${clazzDTO.id}" />
<input	type="hidden" name="id" value="${clazzDTO.id}" />
<input	type="hidden" name="fromPage" value="check" />
<div class="panel-body row">
   <div class="dr-form-title clearfix">
     <div class="col-md-12">
       <h4 class="text-primary">班级基本信息</h4>
     </div>
    </div>
    
    <div class="form-group">
     <label class="col-md-2 control-label">报名项目<span class="text-danger">*</span></label>
		<div class="col-md-3">
		    <s:select list="programList" value="clazzDTO.programId" listKey="id" listValue="name"
			theme="simple" cssClass="form-control" name="programsid" disabled="true"
			headerValue="--选择报名项目--" headerKey="">
			</s:select>
		</div>
     </div>
     
     <div class="form-group">
		<label class="col-md-2 control-label">项目阶段</label>
		<div class="col-md-3"><s:select list="phaseList" listKey="id"
			value="clazzDTO.phaseId" listValue="name" theme="simple" disabled="true"
			cssClass="form-control" name="phaseId" headerValue="--选择项目阶段--"
			headerKey=""></s:select>
			</div>
	</div>
     
	<div class="form-group" id="validate_clazzname">
		<label class="col-md-2 control-label">班级名称<span class="text-danger">*</span></label>
		<div class="col-md-3"><input type="text" value="${clazzDTO.name}" id="name" name="clazzname" class="form-control" /> 
		</div>
		<span class="help-block" id="error_clazzname"></span><s:if test="isExistClazzName==true"><span id="isexistclazz" class="help-block text-danger">该班级名称在该教学计划下已存在</span></s:if>
		
	</div>
	
	<div class="form-group" id="validate_clazzcode">
		<label class="col-md-2 control-label">班级代码<span class="text-danger">*</span></label>
		<div class="col-md-3">
		   <input type="text" value="${clazzDTO.code}" id="code" name="clazzcode" class="form-control" /> 
		</div>
		<span class="help-block" id="error_clazzcode"></span><s:if test="isExistClazzCode==true"><span class="help-block text-danger" id="isexistclazz2">该班级代码已存在</span></s:if>
	</div>

	<s:if test='clazzDTO.selfClass'>
	
		<div class="form-group">
			<label class="col-md-2 control-label">报名开始时间</label>
			<div class="input-group date col-md-3" id="limitStartDate" style="padding-left: 15px;float: left;">
			     <input class="form-control" type="text" readonly="readonly" value="<s:date name="clazzDTO.limitStartDate" format="yyyy-MM-dd" />" 
				name="limitStartDate" class="dateinput" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>				
			</div>
		</div>
	    <div class="form-group">
			<label class="col-md-2 control-label">报名截止时间</label>
			<div class="input-group date col-md-3" id="limitEndDate" style="padding-left: 15px;float: left;">
			    <input class="form-control" readonly="readonly" type="text"
				value="<s:date name="clazzDTO.limitEndDate" format="yyyy-MM-dd" />"  name="limitEndDate"
				class="dateinput" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
			</div>
		</div>
	</s:if>	
	
	<div class="form-group">
		<label class="col-md-2 control-label"  >班级开放时间</label>
		<div class="input-group date col-md-3" id="startDate" style="padding-left: 15px;float: left;"> 
		   <input class="form-control" type="text" value="<s:date name="clazzDTO.startDate" format="yyyy-MM-dd" />"
			readonly="readonly" name="startDate" class="dateinput" /> 
		   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	       <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">班级截止时间</label>
		<div class="input-group date col-md-3" id="closeDate" style="padding-left: 15px;float: left;">
		   <input class="form-control" readonly="readonly" type="text" value="<s:date name="clazzDTO.closeDate" format="yyyy-MM-dd" />" name="closeDate" class="dateinput" />
		   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	       <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	   
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">班级情况备注</label>
		<div class="col-md-5"><textarea class="form-control" name="remarks" cols="40" rows="5" style="resize: none;">${clazzDTO.remarks }</textarea></div>
	</div>

	<div class="form-group"">
		<label class="col-md-2 control-label">班级类型<span class="text-danger">*</span></label>
		<div class="col-md-3">
		  <s:if test="clazzDTO.selfClass">
			<s:radio theme="simple" listKey="value" listValue="key"
				disabled="true" list="#{'集体报名':'True','自主报名':'False'}" name="model"
				value="'False'"></s:radio>
		</s:if> <s:else>
			<s:radio theme="simple" listKey="value" listValue="key"
				disabled="true" list="#{'集体报名':'True','自主报名':'False'}" name="model"
				value="'True'"></s:radio>
		</s:else></div>
	</div>
	 <div class="panel-footer">
	 <div class="row">
	   <div class="col-md-offset-2 col-md-10">
	     <button class="btn btn-primary" type="submit">
         <span class="glyphicon glyphicon-ok"></span>
         	保存
         </button>
	     <button class="btn btn-default" type="button" onclick="window.opener=null;window.open('','_self');window.close();">
         <span class="glyphicon glyphicon-remove-circle"></span>
            关闭
         </button>
	   </div>
	 </div>
	 </div>
</div>
</form>
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
