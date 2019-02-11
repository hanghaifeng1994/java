<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建班级-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<link href="${staticurl}/css/admin_change.css" rel="stylesheet" type="text/css" />

<script>  
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

var pageprogramsid;
var pageplanid;
var cansubmit=false;

	$(document).ready(function() {
		changeTenant();
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
		//$("#startdate").datepick({dateFormat: 'yy-mm-dd'});
		//$("#closeDate").datepick({dateFormat: 'yy-mm-dd'});
		//$("#limit_start_date").datepick({dateFormat: 'yy-mm-dd'});
		//$("#limit_end_date").datepick({dateFormat: 'yy-mm-dd'});


		
		$('#inputForm').submit(function()
				{
			$("#clazzmanager option").each(function()
				{
				$("#inputForm").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='"+$(this).val()+"'/>");
				})
			});
		
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
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
 	 	  
 		$("#inputForm").validate({
 			rules: {
 			<s:if test="nowUser.super">
			tenantId:{
				required: true,
			},
			</s:if>
 			name: {
				required: true,
				maxlength: 50,
				remote: "clazz!checkName.excsec?oldName="+encodeURIComponent('${name}')
			},
 			code: {
				required: true,
				remote: "clazz!checkCode.excsec?oldCode="+encodeURIComponent('${code}')
			}
			,startDate:
			{
				required: true
			}
			,closeDate:
			{
				required: true,
				compareDate: "#startDate2"
			}
			,limitStartDate:
			{
				required: true
			}
			,limitEndDate:
			{
				required: true,
				limtCompareDate: "#limitStartDate2"
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
 					maxlength: "班级名称最多为50个字符,请重新输入",
 					remote: "班级名称已存在"
 				}
				,code:
				{
					required: "请输入班级代码",
					remote: "班级代码已存在"
				}
				,startDate:
				{
					required: "请输入开始时间"
				} 
				,closeDate:
				{
					required: "请输入结束时间",
				} 
				,limitStartDate:
				{
					required: "请输入报名开始时间"
				} 
				,limitEndDate:
				{
					required: "请输入报名截止时间"
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
	        errorElement: "strong" ,
	        submitHandler: function(){
		       document.inputForm.submit();
	        }
 		});
 		 jQuery("#delete").click(function(){
 	    	$("#clazzmanager option:selected").remove();
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

	function changeTenant(){
		var tenantid ;
		<s:if test="nowUser.super">
			tenantid = $("#tenantId").val();
		</s:if><s:else>
		tenantid = ${nowUser.tenantId}
		</s:else>
		var iframSrc = "${ctx}/clazz/manage/clazz!selectClazzManager.action?id=${nowUser.id}&tenantId="+tenantid;
	    $("#mainFrame").attr("src",iframSrc); 
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
    <jsp:param value="clazzlist" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
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
<s:if test="flag=='group'">创建非项目集体班级</s:if><s:else>创建非项目自主班级</s:else>课程</li>
</ol>
<div class="dr-page-header">
<h3>
<s:if test="flag=='group'">创建非项目集体班级</s:if><s:else>创建非项目自主班级</s:else>课程
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
<form class="form-horizontal dr-form-bordered" id="inputForm" action="clazz!save.action" method="post" enctype="multipart/form-data" name="inputForm">
<input type="hidden" name="id" value="${id}" id="pid"  />
<input type="hidden" name="mstAssignEnable" value="true" id="mstAssignEnable"/>
<input type="hidden" name="randomtemp" value="${randomtemp}" id="randomtemp"/>
<input type="hidden" value="${flag }" name="flag" />
<input type="hidden" name="flag2" value="${flag2}"/>
<input type="hidden" name="flag3" value="${flag3}"/>
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">班级基本信息</h4>
</div>
</div>
	<s:if test="nowUser.super">
      <div class="form-group" id="validate_tenantId">
	    <label class="col-md-2 control-label">租户<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	      <s:select list="tenantLists" listKey="id" onchange="changeTenant()"
			value="tenantId" listValue="name" theme="simple"
			cssClass="form-control" name="tenantId" headerValue="--选择租户--"
			headerKey=""></s:select>
        </div>
        <span class="help-block" id="error_tenantId"></span>
     </div>
     </s:if><s:else><input type="hidden" name="tenantId" value="${nowUser.tenantId}"/></s:else>
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
				value="2"></s:radio> 
		</div>
			<span class="help-block" id="error_clazzUseingType"></span>
	</div>
	<div class="form-group" id="validate_prediction">
		<label class="col-md-2 control-label">是否预报名<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio onclick="$(this).val()=='true'?$('#validate_predictionType').show():$('#validate_predictionType').hide()" theme="simple" listKey="value" listValue="key" list="#{'是':'true','否':'false'}" name="prediction"
				value="false"></s:radio> 
		</div>
			<span class="help-block" id="error_prediction"></span>
	</div>
	
	<div class="form-group" id="validate_predictionType" style="display: none">
		<label class="col-md-2 control-label">预报名类型<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<s:radio theme="simple" listKey="value" listValue="key" list="#{'固定预报名':1,'额满预报名':0}" name="predictionType"
				value="1"></s:radio>
		</div>
			<span class="help-block" id="error_predictionType"></span>
	</div>
	
	<!--<div class="form-group" id="validate_uploadPic">
		<label class="col-md-2 control-label">班级背景图片<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input type="file" id="uploadPic" name="uploadPic"/> 
		</div>
			<span class="help-block" id="error_uploadPic"></span>
	</div>-->
	<div class="form-group" id="validate_startDate">
		<label class="col-md-2 control-label"  >班级开放时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-3" id="startDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control" type="text" value="<s:date name="startDate" format="yyyy-MM-dd" />"
			readonly="readonly" id="startDate2" name="startDate" class="dateinput" /> 
		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_startDate"></span>
	</div>

	<div class="form-group" id="validate_closeDate">
		<label class="col-md-2 control-label">班级截止时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-3" id="closeDate" style="padding-left: 15px;float: left;margin-right: 5px;">
		   <input class="form-control" readonly="readonly" type="text" value="<s:if test="id==null">${defaultCloseTime}</s:if><s:else><s:date name="closeDate" format="yyyy-MM-dd" /></s:else>" name="closeDate" class="dateinput" />
		   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	       <span class="input-group-addon "><span class="glyphicon glyphicon-th"></span></span>	   
		</div>
			<span class="help-block" id="error_closeDate"></span>
	</div>


	<div class="form-group">
		<label class="col-md-2 control-label">班级情况备注</label>
		<div class="col-md-5"><textarea class="form-control" name="remarks" cols="40" rows="5" style="resize: none;">${remarks }</textarea></div>
	</div>

	<div class="form-group"">
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
			<!--<div>
			<div class="mb10">
			<p>输入教师的身份证号<span style="color: #737373;">（必须是已注册的用户）</span></p>
			<input type="text" id="idcard" class="form-control" style="float: left;margin-right: 5px;"/>
			<div class="btn-group">
            <button class="btn btn-primary btn-sm" type="button" id="adduser">
              <span class="glyphicon glyphicon-plus"></span>
                                  添 加
            </button>
            </div>
			</div>
			 <div style="float: left;margin-bottom: 10px;">
			 <button id="removemanager" class="btn btn-default btn-sm" type="button">
             <span class="glyphicon glyphicon-trash"></span>
                                  删除
             </button>
			</div>
			</div>
			-->
			</td>
		</tr>
	</table>
</div>
</s:if>

<div class="panel-footer">
<div class="row">
<s:if test="flag=='group'||flag2=='wxold'">		
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
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='clazz.action'">
        <span class="glyphicon glyphicon-remove"></span>
                               取消
        </button>
        </div>
</s:else>
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
