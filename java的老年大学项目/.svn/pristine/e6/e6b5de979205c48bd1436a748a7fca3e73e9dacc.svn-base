<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  

<script>
function checklimit()
{
	if($('input[name="limitnumtype"]:checked').val()=='-1')
	{
	 var aint=parseInt($("#limit_number").val());	
	 var result= aint>0&& (aint+"")==$("#limit_number").val(); 
	 if(!result)
		alert('限定人数请输入大于0的正整数');
	 return result;  
	}
}

	$(document).ready(function() {
		if($("#success").text()!="")$("#div-success").show();
		if($("#error").text()!="")$("#div-error").show();
		
		var s = $("#signUpUndate option:selected").val();
		 if(s==0){
			 $("#validate_limitStartDate").show();
			 $("#validate_limitEndDate").show();
		 }else{
			 $("#validate_limitStartDate").hide();
			 $("#validate_limitEndDate").hide();
		 }

		 var t = $("#studyUndate option:selected").val();
		 if(t==0){
			 $("#validate_startDate").show();
			 $("#validate_closeDate").show();
		 }else{
			 $("#validate_startDate").hide();
			 $("#validate_closeDate").hide();
		 }
				
		if("${clazz.bgimage}"!=null && "${clazz.bgimage}"!=""){
			$("#uploadPic").attr("name","ddd")
		}
		
		 $("#studyStart").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0          
         }); 
		 
       $("#studyend").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0          
        });   
		
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

		
		//$("#startDate").datepick({dateFormat: 'yy-mm-dd'});
		//$("#closeDate").datepick({dateFormat: 'yy-mm-dd'});
		//$("#limit_start_date").datepick({dateFormat: 'yy-mm-dd'});
		//$("#limit_end_date").datepick({dateFormat: 'yy-mm-dd'});
		
 		jQuery.validator.addMethod("positiveinteger", function(value, element) {
 		   var aint=parseInt(value);	
 		    return aint>0&& (aint+"")==value;   
 	  }, "请输入大于0的正整数");   

 		jQuery.validator.addMethod("compareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
 	    var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
 	    var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
 	    return date1 < date2;
 	}, "结束时间必须大于开始时间");

 		jQuery.validator.addMethod("limtCompareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
 	    var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
 	    var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
 	    return date1 < date2;
 	}, "结束时间必须大于开始时间");
 	 	
 		$("#mainForm").validate({
 			rules: {
 			<s:if test="nowUser.super">
			tenantId:{
				required: true,
			},
			</s:if>
 			name: {
				required: true,
				maxlength: 50
				//remote: "clazz!checkName.excsec?oldName="+encodeURIComponent('${clazzDTO.name}')
			} 
		,code:
		{
			required: true,
			remote: "clazz!checkCode.excsec?oldCode="+encodeURIComponent('${clazzDTO.code}')
		}
		,phaseId:{
				required: true
			}

 			},
 			messages: {
 				<s:if test="nowUser.super">
				tenantId:{
					required: "请选择租户"
				},
				</s:if>
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为50个字符,请重新输入"
 					//remote: "班级名称已存在"
 				}
			,code:
			{
				required: "请输入班级代码",
				remote: "班级代码已存在"
			} 
			,phaseId:
				{
					required: "请选择项目阶段"
				}
			//,startDate:
			//{
			//	required: "请输入开始时间"
			//} 
			//,closeDate:
			//{
			//	required: "请输入结束时间"
			//}
			//,limitStartDate:
			//{
			//	required: "请输入报名开始时间"
			//} 
			//,limitEndDate:
			//{
			//	required: "请输入报名截止时间"
			//}  
 			},
			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
		    onfocusin: function(element) { $(element).valid(); },
	        success: function(label) { 
 		        //alert($(label).parent().attr("id"))
				var e = $(label).parent().attr("id").split("_")[1];
				//$(label).parent().attr("class")
				var oclass=$("#validate_"+e).attr("class");
				if(oclass && oclass.indexOf("form-group")>-1)
					oclass = "form-group";
				else
					oclass="";
	        	$("#validate_"+e).attr("class",oclass+" has-success")     
	    		$(label).remove();
	        },
	        errorPlacement: function(error, element) { 
 				//alert("errorPlacement") 
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

	function selectSignupDate(){
		var s = $("#signUpUndate option:selected").val();
		 if(s==0){
			 $("#validate_limitStartDate").show();
			 $("#validate_limitEndDate").show();
		 }else{
			 $("#validate_limitStartDate").hide();
			 $("#validate_limitEndDate").hide();
		 }
	}

	function selectStudyDate(){
		 var s = $("#studyUndate option:selected").val();
		 if(s==0){
			 $("#validate_startDate").show();
			 $("#validate_closeDate").show();
		 }else{
			 $("#validate_startDate").hide();
			 $("#validate_closeDate").hide();
		 }
	}
	function changecity(){				
		var cityId = $("#cityId").val();
		if(cityId) {
			$("#city").val($("#cityId").find("option:selected").text());
			$.post("${ctx}/clazz/manage/clazz!getAreaJson.excsec",{"cityId":cityId},function(data) {
				$("#areaId option[value!='']").remove();
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#areaId option[value!='']").remove();
				$("#area").val("");
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${clazzDTO.areaId}"==practiceUnit[i].value){
						    $("#areaId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
						    $("#area").val(practiceUnit[i].label);
					 }else{
						    $("#areaId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }
				}
			});
		}else{
			$("#areaId").val("");
			$("#city").val("");
			$("#area").val("");
		}
	}
	
	function changearea(){
		var areaId = $("#areaId").val();
		if(areaId!="") $("#area").val($("#areaId").find("option:selected").text());
		else $("#area").val("");
	}
</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>

</head>
<body>
<!--页头部-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
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
<section id="main" role="main">
<div class="dr-container-fluid">
     <div class="dr-page-header">
     <h3>班级信息</h3>
   </div>
   <hr/>
   <div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
    <button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
    <span id="success"><s:actionmessage  theme="simple"/></span>
   </div>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">
       <s:if test='!clazzDTO.selfClass'>集体</s:if><s:else>自主</s:else>报名班级"${clazzDTO.name}"管理
    </h3>
    <div class="panel-toolbar">
       <ul class="nav nav-tabs pull-right">
	     <li class="active"><a href="clazz!minfo.action?id=${id }<s:if test='!clazzDTO.selfClass'>&flag=group</s:if>" >班级信息</a></li>
       	 <li><a href="clazz!learningcount.action?id=${id }" >班级学情统计</a></li>
		 <li><a href="clazz!mcourse.action?id=${id}">班级课程</a></li>
	     <li><a href="clazz!mstudents.action?id=${id}">班级学员</a></li>
	     <li><a href="clazz!mmanager.action?id=${id}">班主任任命</a></li>
	     <s:if test='!clazzDTO.selfClass'>
		 <li><a href="clazz!mcost.action?id=${id}">费用结算</a></li>
	    </s:if>
       </ul>
    </div>

  </div>
<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">	
<form id="mainForm" action="clazz!saveclazz.action" method="post" class="form-horizontal dr-form-bordered" enctype="multipart/form-data">
<input type="hidden" name="id" value="${id}" id="id"  />
<input type="hidden" name="clazzDTO.id" value="${clazzDTO.id}"/>
<input type="hidden" name="flag" value="${flag}"></input>
   	<div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">班级信息</h4>
	  </div>
	</div>
	
	<%-- <s:if test="programDTO.showPhase"> --%>
	<div class="form-group" id="validate_phaseId">
	     <label class="col-md-2 control-label">项目阶段<span class="text-danger">*</span></label>
			<div class="col-md-3"><s:select list="phaseList"
				value="phaseId" listKey="id" listValue="name"
				theme="simple" cssClass="form-control" name="phaseId"
				headerValue="--选择项目阶段--" headerKey=""></s:select>
				</div>
				<span class="help-block" id="error_phaseId"></span>
	</div>
	<%-- </s:if> --%>
	
	<div class="form-group" id="validate_teachContent">
		<label class="col-md-2 control-label">教学内容</label>
		<div class="col-md-3">
		<s:select list="teachContentList" listKey="id"
			value="teachContentId" listValue="name+'(第'+version+'版)'" theme="simple"
			cssClass="form-control" name="teachContentId" headerValue="--选择教学内容--"
			headerKey="" ></s:select>
		</div>
		<span class="help-block" id="error_planid"></span>
	</div>
	
	<div class="form-group" id="validate_cityId" >
		<label class="col-md-2 control-label">班级所属市</label>
		<div class="col-md-3"> 
			<s:select cssClass="form-control" onchange="changecity()" list="citysVLists" listKey="id" theme="simple" 
				listValue="name" name="cityId" value="clazzDTO.cityId" id="cityId" headerKey="" headerValue="--所在市--"/>
			<input type="hidden" name="city" id="city" value="${clazzDTO.city}"/>
	    </div>
	    <span class="help-block" id="error_cityId"></span>
	</div>
	<div class="form-group" id="validate_areaId" >
		<label class="col-md-2 control-label">班级所属区县</label>
		<div class="col-md-3"> 
			<s:select cssClass="form-control" onchange="changearea()" list="areaVLists" listKey="id" theme="simple" 
				listValue="name" name="areaId" value="clazzDTO.areaId " headerKey="" headerValue="--所在区县--" id="areaId" />
			<input type="hidden" name="area" id ="area" value="${clazzDTO.area}"/>
	    </div>
	    <span class="help-block" id="error_areaId"></span>
	</div>
	
   <div class="form-group" id="validate_name">
		<label class="col-md-2 control-label">班级名称<span class="text-danger">*</span></label>
		<div class="col-md-3"><input type="text" value="${clazzDTO.name}" id="name" name="name" onclick="$('#isexistclazz').hide()"
			class="form-control"/>
	 </div>
		<span class="help-block" id="error_name"></span>
		<s:if test="isExistClazzName==true"><span id="isexistclazz" class="help-block">该班级名称在该教学计划下已存在</span></s:if>
	</div>

	<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">班级代码<span class="text-danger">*</span></label>
		<div class="col-md-3"><input type="text" value="${clazzDTO.code}" id="code" name="code" onclick="$('#isexistclazz2').hide()"
			class="form-control" />
	    </div>
	    <span class="help-block" id="error_code"></span>
	 <s:if test="isExistClazzCode==true"><span class="help-block" id="isexistclazz2">该班级代码已存在</span></s:if>
	</div>
     <div class="form-group" id="validate_classroomName">
		<label class="col-md-2 control-label">上课地点</label>
		<div class="col-md-3"><input type="text" value="${clazzDTO.classroomName}" id="classroomName" name="classroomName" onchange="$('#isexistclazz2').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_classroomName"></span>
	</div>
	
	<div class="form-group" id="validate_classroomName">
		<label class="col-md-2 control-label">上课时间</label>
		<div class="col-md-3"><input type="text" value="${clazzDTO.studyTime}" id="studyTime" name="studyTime" onchange="$('#isexistclazz2').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_classroomName"></span>
	</div>
	
	<div class="form-group" id="validate_clazzUseingType">
		<label class="col-md-2 control-label">班级报名方式<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple" listKey="value" listValue="key" list="#{'网页':0,'终端':2,'同时':1}" name="clazzUseingType"
				value="clazzDTO.clazzUseingType"></s:radio> 
		</div>
			<span class="help-block" id="error_clazzUseingType"></span>
	</div>
	 <div class="form-group" id="validate_prediction">
		<label class="col-md-2 control-label">是否预报名班级<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple" onclick="$(this).val()=='true'?$('#validate_predictionType').show():$('#validate_predictionType').hide()" listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="prediction"
				value="clazzDTO.prediction"></s:radio> 
		</div>
			<span class="help-block" id="error_prediction"></span>
	</div>
	
	<div class="form-group" id="validate_uploadPic">
		<label class="col-md-2 control-label">班级背景图片 </br>(202x158)<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input type="file" id="uploadPic" name="uploadPic"/> 
		</div>
		<div class="img-thumbnail mt10">
         <img id="cruPic" alt="202x158" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${clazzDTO.pic}" style="width:90px; height:120px;"/>
       </div>
			<span class="help-block" id="error_uploadPic"></span>
	</div>
	<s:if test="#request.iswxeduopen=='true'">
	<div class="form-group">
    <label class="col-md-2 control-label">前测班级</label>
   		<div class="col-md-5">
    	<label class="radio-inline">
    		<input id="qianceCheckbox" type="radio" value="true"  name="clazzDTO.beforeTestClazz" <s:if test="clazzDTO.beforeTestClazz==true">checked="checked"</s:if>/>是</label>
    	<label class="radio-inline">
    		<input id="qianceCheckbox" type="radio" value="false"  name="clazzDTO.beforeTestClazz" <s:if test="clazzDTO.beforeTestClazz==false">checked="checked"</s:if>/>否</label>
    	<div style="padding-left: 10px;"><span class="help-block" id="error_timebefore"></span></div>
    </div>
	</div> 
	<div class="form-group" id="validate_offline">
	    <label class="col-md-2 control-label">教学方式：<span class="text-danger">*</span></label>
	    <div class="col-md-5 mt5">
	   		<s:radio list="#{true:'线下',false:'线上'}" value="clazzDTO.offlined" name="clazzDTO.offlined" theme="simple" cssStyle="font-weight: normal;"></s:radio>
	    	<span class="text-danger" id="error_offline"></span>
		</div>
	</div>
	</s:if>
	<div class="form-group" id="validate_predictionType" style="display: <s:if test="!clazzDTO.prediction">none</s:if>">
		<label class="col-md-2 control-label">预报名类型 <span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio disabled="disabled" theme="simple" listKey="value" listValue="key" list="#{'固定预报名':1,'额满预报名':0}" name="predictionType"
				value="clazzDTO.predictionType"></s:radio>
		</div>
			<span class="help-block" id="error_predictionType"></span>
	</div>
     <!--<div class="form-group" id="validate_uploadPic">
		<label class="col-md-2 control-label">班级背景图片<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input type="file" id="uploadPic" name="uploadPic" /> 
		<s:if test="clazz.bgimage!=null">
		 <div class="img-thumbnail mt10">
         <img  alt="140x140" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${clazz.bgimage}" style="width:140px; height:140px;"/>
      	 </div>
		</s:if>
		<s:else>
		<img src="${ctx}/css/image/bj01.jpg" width="140" height="140"  class="mt20"/>
		</s:else>
		</div>
			<span class="help-block" id="error_uploadPic"></span>
	</div>-->
	
	 <div class="form-group" id="validate_studyStart">
       <label class="col-md-2 control-label">学习时间起自<span class="text-danger"></span></label>
       <div class="input-group date col-md-3" id="studyStart"  style="padding-left: 15px;float: left;margin-right: 5px;">
          <input type="text" id="studyStart2" value='<s:date name="clazzDTO.studyStart" format="yyyy-MM-dd"></s:date>' readonly="readonly"
			 name="studyStart" class="form-control" /> 
		  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>			  
       </div>
        <span id="error_studyStart" class="help-block"></span>
    </div>
     
    
     <div class="form-group" id="validate_studyEnd">
       <label class="col-md-2 control-label">学习时间截至<span class="text-danger"></span></label>
       <div class="input-group date col-md-3" id="studyend"  style="padding-left: 15px;float: left;margin-right: 5px;">
          <input type="text" id="studyEnd2" value='<s:date name="clazzDTO.studyEnd" format="yyyy-MM-dd"></s:date>' readonly="readonly"
			 name="studyEnd" class="form-control" /> 
		  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>			  
       </div>
        <span id="error_studyEnd" class="help-block"></span>
    </div>  
    
    <div class="form-group">
        <label class="col-md-2 control-label">是否开放无限期</label>	
		<div class="col-md-3">
		<s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="studyUndate" theme="simple" headerKey="" 
		value="studyUndate" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectStudyDate()" id="studyUndate"></s:select>	
	    </div>
	</div>
    
     <div class="form-group" id="validate_startDate">
       <label class="col-md-2 control-label">开放时间起自<span class="text-danger">*</span></label>
       <div class="input-group date col-md-3" id="startDate"  style="padding-left: 15px;float: left;margin-right: 5px;">
          <input type="text" id="startDate2" value='<s:date name="clazzDTO.startDate" format="yyyy-MM-dd"></s:date>' readonly="readonly"
			 name="startDate" class="form-control" /> 
		  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>			  
       </div>
        <span id="error_startDate" class="help-block"></span>
    </div>
    <div class="form-group" id="validate_closeDate">
       <label class="col-md-2 control-label">开放时间截止<span class="text-danger">*</span></label>
       <div class="input-group date col-md-3" id="closeDate" style="padding-left: 15px;float: left;margin-right: 5px;">
         <input type="text"  value='<s:date name="clazzDTO.closeDate" format="yyyy-MM-dd"></s:date>'
			 name="closeDate" class="form-control" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	         
       </div>
       <span style="color:red;">(更改截止日期后请同步更改任务日程)</span>
       <span id="error_closeDate" class="help-block"></span>
    </div>    

    <div class="form-group">
		<label class="col-md-2 control-label">班级情况备注</label>
		<div class="col-md-3"><textarea class="form-control" name="remarks" cols="40" rows="5">${clazzDTO.remarks }</textarea></div>
	</div>
	<s:if test="#request.iswxeduopen=='true'">
	<div class="form-group" id="validate_openWorkshop">
		<label class="col-md-2 control-label">是否开启工作坊<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple"  listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="openWorkshop"
				value="clazzDTO.openWorkshop"></s:radio> 
		</div>
			<span class="help-block" id="error_openWorkshop"></span>
	</div>
	 </s:if>
	<div class="form-group" id="validate_delayStudy">
		<label class="col-md-2 control-label">结束是否可以继续学习<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple"  listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="delayStudy"
				value="clazzDTO.delayStudy"></s:radio> 
		</div>
			<span class="help-block" id="error_delayStudy"></span>
	</div>
    <div class="form-group">
		<label class="col-md-2 control-label">班级类型<span class="text-danger">*</span></label>
		<div class="col-md-10"><s:if test='!clazzDTO.selfClass'>
			<s:radio theme="simple" listKey="value" listValue="key"
				disabled="true" list="#{'集体报名':'True','自主报名':'False'}" name="model"
				value="'True'"></s:radio>
		</s:if> <s:else>
			<s:radio theme="simple" listKey="value" listValue="key"
				disabled="true" list="#{'集体报名':'True','自主报名':'False'}" name="model"
				value="'False'"></s:radio>
		</s:else></div>
	</div>
    
    <s:if test="flag!='group'">
		<div class="form-group">
        <label class="col-md-2 control-label">是否报名无限期</label>	
		<div class="col-md-3">
		<s:select list="#{'0':'否','1':'是'}" listKey="key" listValue="value" name="signUpUndate" theme="simple" headerKey="" 
		value="signUpUndate" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectSignupDate()" id="signUpUndate"></s:select>	
	    </div>
	    </div>
		
		<div class="form-group" id="validate_limitStartDate">
			<label class="col-md-2 control-label">报名开始时间<span class="text-danger">*</span></label>
			<div class="input-group date col-md-3" id="limitStartDate" style="padding-left: 15px;float: left;margin-right: 5px;">
			     <input class="form-control" type="text" readonly="readonly" value="<s:date name="clazzDTO.limitStartDate" format="yyyy-MM-dd" />" 
				id="limitStartDate2" name="limitStartDate" class="dateinput" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>				
			</div>
			<span class="help-block" id="error_limitStartDate"></span>
		</div>

		<div class="form-group" id="validate_limitEndDate">
			<label class="col-md-2 control-label">报名截止时间<span class="text-danger">*</span></label>
			<div class="input-group date col-md-3" id="limitEndDate" style="padding-left: 15px;float: left;margin-right: 5px;">
			    <input class="form-control" readonly="readonly" type="text"
				value="<s:date name="clazzDTO.limitEndDate" format="yyyy-MM-dd" />"  name="limitEndDate"
				class="dateinput" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
			</div>
				<span class="help-block" id="error_limitEndDate"></span>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label">人数限制</label>
			<div class="col-md-10">
               		<s:if test="clazzDTO.limit_number>0">
			<s:radio theme="simple" listKey="value" listValue="key"
				list="#{'不限制':'0','限定':'-1'}" name="limitnumtype" value="-1"
				onclick="if(this.value=='0'){$('#limit_number').val(0);$('#limit_number').hide();}else{$('#limit_number').show()}"></s:radio>
			<input type="text" value="${clazzDTO.limit_number}" style="width: 50px"
				id="limit_number" name="limit_number"></input>人<span class="admin_woring_x lr fr" style="float:right; padding-right:50px;" id="error_limit_number"></span>
	    </s:if>
	    <s:else>
			<s:radio theme="simple" listKey="value" listValue="key"
				list="#{'不限制':'0','限定':'-1'}" name="limitnumtype" value="0"
				onclick="if(this.value=='0'){$('#limit_number').val(0);$('#limit_number').hide();}else{$('#limit_number').show()}"></s:radio>
			<input type="text" value="${clazzDTO.limit_number}" style="width: 50px"
				id="limit_number" name="limit_number" style="display:none;"></input>人<span class="admin_woring_x lr fr" style="float:right; padding-right:50px;" id="error_limit_number"></span>
	    </s:else>
            </div>
       </div>
	</s:if>
    
    
      <div class="panel-footer">
    <div class="row">
       <div class="col-md-offset-2 col-md-10">
       <button class="btn btn-primary btn-sm" type="submit" >
        <span class="glyphicon glyphicon-ok"></span>
                     保存
       </button>
       <button class="btn btn-default btn-sm" style="margin-left: 20px;" type="submit" onclick="window.opener=null;window.open('','_self');window.close();">
        <span class="glyphicon glyphicon-remove-circle"></span>
               关闭
       </button>      
    </div>
    </div>
    </div>   
</form>
</div>
</div>
</div>
</section>
</div>

	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>
