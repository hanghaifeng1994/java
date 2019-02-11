<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="cn.common.lib.util.web.RequestUtils"%>
<%@page import="cn.common.lib.util.date.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.drcl.traincore.contants.Switch"%>
<%@page import="com.drcl.traincore.user.adapter.UserLocalAdapter"%>
<%@page import="com.drcl.traincore.user.util.*"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
%>

<s:set name="curUser" value="@com.drcl.traincore.util.UserUtils@getCurUser()" scope="session"></s:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建班级-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	<%-- <link href="${staticurl}/css/admin_change.css" rel="stylesheet" type="text/css" />
	<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script> --%>

<script type="text/javascript">  
var clazzManagerValue;
var clazzManagerText;
function checklimit()
{
	if($('input[name="limitnumtype"]:checked').val()=='-1')
	{
	 var aint=parseInt($("#limit_number").val());	
	 var result= aint>0&& (aint+"")==$("#limit_number").val(); 
	 if(!result)
		b_alert('限定人数请输入大于0的正整数');
	 return result;  
	}
}

function checkedError(){
	$(".error").each(function(i){
		if($(this).text() != ""){
			var e = $(this).parent().attr("id").split("_")[1];
	   		$("#validate_"+e).attr("class","form-group has-error")
	    }
	});
}

	$(document).ready(function() {
		jQuery("#delete").click(function(){
 	    	$("#clazzmanager option:selected").remove();
 	    });
		
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
 		//聚焦第一个输入框
 		/* $("#name").focus(); */
 	// tree初始化
       /*  var o = {
                showcheck: true,          
                //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
				isfolder:false,
				iscascade: false, //是否选中节点后向下遍历
                isbubble: true //是否选中节点后向上上溯
                //onnodeclick:function(item){alert(item.text);}
        }; */
      /*   o.data = "${catTreeData}";
        $("#navigation").treeview(o); */
 		//为registerForm注册validate函数
 	 /*  jQuery.validator.addMethod("positiveinteger", function(value, element) {
	   var aint=parseInt(value);	
	    return aint>0&& (aint+"")==value;   
  		}, "请输入大于0的正整数");  */

 		/* jQuery.validator.addMethod("compareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
 			if(startDate!=''){
 				var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
 	            var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
 	           if(value=='' && startDate==''){
 	        	   return true;
 	           }else{
 	        	  return date1 < date2;
 	           }
 			}else{
 				return true;
 			}
           
            return date1 < date2;
 	  }, "结束时间必须大于开始时间"); */

 		jQuery.validator.addMethod("limtCompareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
 			if(startDate!=''){
 				var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
 	            var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
 	           if(value=='' && startDate==''){
 	        	   return true;
 	           }else{
 	        	  return date1 < date2;
 	           }
 			}else{
 				return true;
 			}
           
            return date1 < date2;
 	  }, "结束时间必须大于开始时间");
 	 	  
 		$("#inputForm").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 50
				//remote: "clazz!checkName.excsec?oldName="+encodeURIComponent('${name}')
			},
 			code: {
				required: true,
				remote: "clazz!checkCode.excsec?oldCode="+encodeURIComponent('${code}')
				},
			phaseId:{
				required: true
			},
			limitEndDate:{
				limtCompareDate:"#limitStartDate2"
			}
 			},
 			messages: {
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
 			},
			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
		    onfocusin: function(element) { $(element).valid(); },
	        success: function(label) { 
		    	var divId = $(label).parent().attr("id");
		    	var startindex = divId.indexOf("_"); 
		    	var e = divId.substring(startindex+1);
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
		   /*  submitHandler: function(form) {
                var s=$("#navigation").getTSVs();
                if(s !=null){
					$("#checkCats").val(s.join(","));
	            }
				form.submit();
			},	 */
	        errorElement: "strong" 
 		});
 		 
		
 	});

	function iFrameHeight() {
		var ifm= document.getElementById("mainFrame");   
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;  
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight+10;
		}   
	}

	function setValue(f,d){
		clazzManagerValue=f;
		clazzManagerText=d;
	}
	
	function addclick(){
		$("<option></option>").val(clazzManagerValue).text(clazzManagerText).appendTo(jQuery("#clazzmanager:not(:has(option[value="+clazzManagerValue+"]))"));
	}

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
	
	/* $('#inputForm').submit(function()
			{
		$("#clazzmanager option").each(function()
			{
			$("#inputForm").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='"+$(this).val()+"'/>");
			})
		}); */
	
	function changearea(){
		var areaId = $("#areaId").val();
		if(areaId!="") $("#area").val($("#areaId").find("option:selected").text());
		else $("#area").val("");
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
<s:if test="flag2!='wxold'">
<security:authorize ifAnyGranted="ROLE_市县级班级管理">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
    <jsp:param value="novalidateclazz" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
    </jsp:include>
<!--the end of left-->
</security:authorize>
</s:if>
<s:if test="flag2=='wxold'">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
    <jsp:param value="clazzlist" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
    </jsp:include>
<!--the end of left-->
</s:if>
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">班级管理</a>
</li>
<li class="active">
<s:if test="flag=='group'">创建集体班级</s:if><s:else>创建自主班级</s:else>课程</li>
</ol>
<div class="dr-page-header">
<h3>
<s:if test="flag=='group'">创建集体班级</s:if><s:else>创建自主班级</s:else>课程
</h3>
</div>
<hr/>
<div class="panel panel-default">
<s:if test="flag=='group'||flag3=='noprograms'">
<div class="dr-steps clearfix">
   <ul role="tablist">
      <li class="current" role="tab"><a href="#"><span class="current-info">current step: </span><span class="number">1.</span><span class="title">填写班级信息</span></a></li>
      <li class="last" role="tab"><a href="#"><span class="number">2.</span><span class="title">课程选择</span></a></li>
      <s:if test="flag=='group'">
      <li class="last" role="tab"><a href="#"><span class="number">3.</span><span class="title">导入学员</span></a></li>
      <li class="last" role="tab"><a href="#"><span class="number">4.</span><span class="title">费用结算和管理设置</span></a></li>
      </s:if>
   </ul>
</div>
</s:if>
<s:else>
<div class="dr-steps clearfix">
   <ul role="tablist">
      <li class="current" role="tab"><a href="#"><span class="current-info">current step: </span><span class="number">1.</span><span class="title">填写班级信息</span></a></li>
      <li class="last" role="tab"><a href="#"><span class="number">2.</span><span class="title">课程选择</span></a></li>
      <!--<li class="last" role="tab"><a href="#"><span class="number">3.</span><span class="title">管理设置</span></a></li>
   --></ul>
</div>
</s:else>
<form class="form-horizontal dr-form-bordered" id="inputForm" action="clazz!save.action" method="post" enctype="multipart/form-data" name="inputForm">
<input type="hidden" name="id" value="${id}" id="id"  />
<input type="hidden" value="${flag}" name="flag" />
<input type="hidden" name="programId" value="${programId}" id="programId"  />
<input type="hidden" name="mstAssignEnable" value="true" id="mstAssignEnable"/>
<input type="hidden" name="randomtemp" value="${randomtemp}" id="randomtemp"/>
<input type="hidden" name="flag2" value="${flag2}"/>
<input type="hidden" name="isdown" value="${isdown}"/>

<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">班级基本信息</h4>
</div>
</div>
	
	<div class="form-group" id="validate_phaseId">
	     <label class="col-md-2 control-label">项目阶段<span class="text-danger">*</span></label>
			<div class="col-md-3"><s:select list="phaseList"
				value="phaseId" listKey="id" listValue="name"
				theme="simple" cssClass="form-control" name="phaseId"
				headerValue="--选择项目阶段--" headerKey=""></s:select>
				</div>
				<span class="help-block" id="error_phaseId"></span>
	</div>
	
	<div class="form-group" id="validate_teachContent">
		<label class="col-md-2 control-label">教学内容</label>
		<div class="col-md-3">
		<s:select list="teachContentList" listKey="id"
			value="teachContentId" listValue="name+'(第'+version+'版)'" theme="simple"
			cssClass="form-control" name="teachContentId" headerValue="--选择教学内容--"
			headerKey=""></s:select>
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
		<div class="col-md-3"><input type="text" value="${name}" id="name" name="name" onchange="$('#isexistclazz').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_name"></span>
	</div>
	
	<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">班级代码<span class="text-danger">*</span></label>
		<div class="col-md-3"><input type="text" value="${code}" id="code" name="code" onchange="$('#isexistclazz2').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_code"></span>
	</div>
	<div class="form-group" id="validate_classroomName">
		<label class="col-md-2 control-label">上课地点</label>
		<div class="col-md-3"><input type="text" value="${classroomName}" id="classroomName" name="classroomName" onchange="$('#isexistclazz2').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_classroomName"></span>
	</div>
	
	<div class="form-group" id="validate_classroomName">
		<label class="col-md-2 control-label">上课时间</label>
		<div class="col-md-3"><input type="text" value="${studyTime}" id="studyTime" name="studyTime" onchange="$('#isexistclazz2').hide()"
			class="form-control" /> 
		</div>
			<span class="help-block" id="error_classroomName"></span>
	</div>
	<div class="form-group" id="validate_clazzUseingType">
		<label class="col-md-2 control-label">班级报名方式<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple" listKey="value" listValue="key" list="#{'网页':0,'终端':2,'同时':1}" name="clazzUseingType"
				value="0"></s:radio> 
		</div>
			<span class="help-block" id="error_clazzUseingType"></span>
	</div>
    <div class="form-group" id="validate_prediction">
		<label class="col-md-2 control-label">是否预报名<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple" onclick="$(this).val()=='true'?$('#validate_predictionType').show():$('#validate_predictionType').hide()" listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="prediction"
				value="false"></s:radio> 
		</div>
			<span class="help-block" id="error_prediction"></span>
	</div>
	<div class="form-group" id="validate_predictionType" style="display: none">
		<label class="col-md-2 control-label">预报名类型<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio disabled="disabled" theme="simple" listKey="value" listValue="key" list="#{'固定预报名':1,'额满预报名':0}" name="predictionType"
				value="1"></s:radio>
		</div>
			<span class="help-block" id="error_predictionType"></span>
	</div>
	<div class="form-group" id="validate_uploadPic">
		<label class="col-md-2 control-label">班级背景图片<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input type="file" id="uploadPic" name="uploadPic"/><span>(190x110)</span>
		</div>
			<span class="help-block" id="error_uploadPic"></span>
	</div>
	<s:if test="#request.iswxeduopen=='true'">
	<div class="form-group" id="validate_openWorkshop">
		<label class="col-md-2 control-label">是否开启工作坊<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple"  listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="openWorkshop"
				value="openWorkshop"></s:radio> 
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
	<s:if test="#request.iswxeduopen=='true'">
	<div class="form-group">
    	<label class="col-md-2 control-label">前测班级</label>
    	<div class="col-md-5">
    	   	<label class="radio-inline">
    			<input id="qianceCheckbox" type="radio" value="true"  name="beforeTestClazz" <s:if test="beforeTestClazz==true">checked="checked"</s:if>/>是</label>
    		<label class="radio-inline">
    			<input id="qianceCheckbox" type="radio" value="false"  name="beforeTestClazz" <s:if test="beforeTestClazz==false">checked="checked"</s:if>/>否</label>
   	    </div> 
	</div> 
	<div class="form-group" id="validate_offline">
	    <label class="col-md-2 control-label">教学方式：<span class="text-danger">*</span></label>
	    <div class="col-md-5 mt5">
	   		<s:radio list="#{true:'线下',false:'线上'}" value="offlined" name="offlined" theme="simple" cssStyle="font-weight: normal;"></s:radio>
	    	<span class="text-danger" id="error_offline"></span>
		</div>
	</div>
	</s:if> 
	
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
	
	<div class="form-group" id="validate_startDate" style="display: none">
		<label class="col-md-2 control-label"  >班级开放时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-3" id="startDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control" type="text" value="<s:date name="startDate" format="yyyy-MM-dd" />"
			readonly="readonly" id="startDate2" name="startDate" class="dateinput" /> 
		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_startDate"></span>
	</div>

	<div class="form-group" id="validate_closeDate" style="display: none">
		<label class="col-md-2 control-label">班级截止时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-3" id="closeDate" style="padding-left: 15px;float: left;margin-right: 5px;">
		   <input class="form-control" readonly="readonly" type="text" value="<s:if test="id==null">${defaultCloseTime}</s:if><s:else><s:date name="closeDate" format="yyyy-MM-dd" /></s:else>" name="closeDate" class="dateinput" />
		   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	       <span class="input-group-addon "><span class="glyphicon glyphicon-th"></span></span>	   
		</div>
		 <span style="color:red;">(更改截止日期后请同步更改任务日程)</span>
			<span class="help-block" id="error_closeDate"></span>
	</div>


	<div class="form-group">
		<label class="col-md-2 control-label">班级情况备注</label>
		<div class="col-md-5"><textarea class="form-control" name="remarks" cols="40" rows="5" style="resize: none;">${remarks }</textarea></div>
	</div>

	<div class="form-group">
		<label class="col-md-2 control-label">班级类型<span class="text-danger">*</span></label>
		<div class="col-md-3 mt5"><s:if test="flag=='group'">
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
			     <input class="form-control" type="text" readonly="readonly" value="<s:date name="limitStartDate" format="yyyy-MM-dd" />" 
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
				value="<s:date name="limitEndDate" format="yyyy-MM-dd" />"  name="limitEndDate"
				class="dateinput" />
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
			</div>
				<span class="help-block" id="error_limitEndDate"></span>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label">人数限制</label>
			<div class="col-md-3 mt5">
			<s:radio theme="simple" listKey="value" listValue="key" list="#{'不限制':'0','限定':'-1'}" name="limitnumtype" value="limit_number" onclick="if(this.value=='0')$('#limit_number').val(0)"></s:radio>
			<input	type="text" value="0" style="width: 50px" id="limit_number"	name="limit_number"></input>人
			</div>
			<span class="help-block" id="error_limit_number"></span>
		</div>
	</s:if>

	<s:if test="flag!='group'">
	<div class="panel panel-default">
	<div class="panel-heading">班主任分配</div>
	<table class="table table-bordered dr-table-bordered">
		<tr>
			<td width="35%" valign="top">
			<select name="" size="10" id="clazzmanager" style="width: 100%;margin: 10px auto;border: 1px solid #CCCCCC;height: 90px;">
			</select>
			<button class="btn btn-default" type="button" id="delete" name="Submit32222">
               <span class="glyphicon glyphicon-trash"></span>
                                      删除班主任
           </button> 
			</td>
			<td width="2%" valign="top">
			<a href="javascript:void(0)">
			<span id="moveright" class="glyphicon glyphicon-arrow-left" style="margin-top: 130px;" title="左移" onclick="addclick()"></span>
			</a>
			</td>
			<td width="63%">
			<iframe src="${ctx}/clazz/manage/clazz!selectClazzManager.action?id=${curUser.id}" id="mainFrame" name="mainFrame" frameborder=0 scrolling=yes width="100%" onLoad="iFrameHeight()"></iframe>
			</td>
		</tr>
	</table>
	</div>
	</s:if>

<div class="panel-footer">
<div class="row">
	<div class="col-md-12">
			<button class="btn btn-primary pull-right"   type="submit">
	        <span class="glyphicon glyphicon-step-forward"></span>
	         &nbsp;下一步
	        </button>
	</div>
<!--<s:if test="flag=='group'">		
<div class="col-md-12">
		<button class="btn btn-primary pull-right" type="submit">
        <span class="glyphicon glyphicon-step-forward"></span>
         &nbsp;下一步
        </button>
</div>
</s:if> 
<s:else>			
    <div class="col-md-offset-2 col-md-10">
		<button class="btn btn-primary btn-sm" type="submit" onclick="return checklimit()">
        <span class="glyphicon glyphicon-ok"></span>
                     保存
        </button>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='clazz!list.action'">
        <span class="glyphicon glyphicon-remove"></span>
                     取消
        </button>
        </div>
</s:else>
-->
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
