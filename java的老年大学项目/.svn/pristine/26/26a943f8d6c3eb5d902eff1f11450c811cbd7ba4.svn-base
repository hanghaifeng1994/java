<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="java.util.Random"%>
<html>
<head>
<title>编辑用户信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp" %>

<script type="text/javascript"><!--
		$(document).ready(function() {
	        if($("#success").text()!="")$("#div-success").show();
	        if($("#error").text()!="")$("#div-error").show(); 
			//聚焦第一个输入框
			$("#username").focus();
			jQuery.validator.addMethod("isUsername", function(value, element) {    
		  		var name =/^[a-zA-Z0-9]{1}[a-zA-Z0-9]{2,}$/;     
		  		return this.optional(element) || (name.test(value));    
			}, "用户名由数字字母组成,首位必须为字母或数字");

			jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
				  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
				},"输入的身份证号码不正确");

			$("#inputForm").validate({
				rules: {
					<s:if test="id!=null">
					username: {
						required: true,
						isUsername:true,
						/*remote: "student!checkUserName.excsec?oldUserName=" + encodeURIComponent('${userDTO.username}')*/
					},
					</s:if>
					name: {
						required: true,
						maxlength:10
					},
					idcard:
					{
						isIdCardNo:true
					},
					password: {
						minlength:6,
						maxlength:18
					},
					qpassword: {
						equalTo:"#password",
						maxlength:18
					},
				},
				messages: {
					<s:if test="id!=null">
					username: {
						//remote: "用户登录名已存在",
						required:"请输入用户名"
					},
					</s:if>
					name:{
						required:"请输入姓名",
						maxlength:"字数小于10位"
					},
					password:{
						minlength:"密码最少6位",
						maxlength:"密码不大于18位"
					},
					qpassword:{
						equalTo:"两次输入的密码不相同"
					},
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

			$("#Submit32").click(function(){
				var username = $("#username").val();
				var id = $("#id").val();
				if(username){
					$.getJSON("student!usernamecheck.action",{"username":username,"id":id},function(data){
						var dates = eval(data); //后台传入的数据
						if(data){
							$("#inputForm").submit();
							}else{
								$("#error").html("保存失败，用户名已存在！");
								$("#div-error").show();
								}
					});	
				}
				});
		});
		
	--></script>
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
	<jsp:param value="studentlist" name="menu" />
	<jsp:param value="student" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->

  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">用户管理</a></li>
     <li class="active">
        <span class="deep_bule">编辑普通用户 </span>
     </li>
    </ol>
   <div class="dr-page-header">
     <h3>更改用户信息</h3>
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
	action="student!editorwxjs.action"
	method="post">
	<input id="id" name="id" type="hidden" value="${id}" size="30" /> 
 
  <div class="dr-form-title clearfix">
    <div class="col-md-12">
    <h4 class="text-primary">更改用户基本信息</h4>
    </div>
   </div>
 
 
   <div class="form-group" id="validate_username">
	 <label class="col-md-2 control-label">用户名<span class="text-danger">*</span></label>
        <div class="col-md-3">
	    <input id="username" name="username" type="text" value="${userDTO.username}" class="form-control"/> 
       </div>
       <span class="help-block" id="error_username"></span>
  </div>
  
     <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">姓名<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="name" name="name" value="${userDTO.name}" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_name"></span>
     </div>
	
	  <div class="form-group" id="validate_college">
	    <label class="col-md-2 control-label">学校</label>
	    <div class="col-md-3">
	       <input id="college" name="college" value="${userDTO.college}" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_college"></span>
     </div>
     
     <div class="form-group" id="validate_grade">
	    <label class="col-md-2 control-label">年级</label>
	    <div class="col-md-3">
	       <select title="请选择所在年级！" id="grade" class="form-control" name="grade" >
				<option  <s:if test="userDTO.grade=='一年级'">selected</s:if> cid="1" value='一年级'  style='color:#999;'>一年级</option>
				<option  <s:if test="userDTO.grade=='二年级'">selected</s:if> cid="2" value='二年级'  style='color:#999;'>二年级</option>
				<option  <s:if test="userDTO.grade=='三年级'">selected</s:if> cid="3" value='三年级'  style='color:#999;'>三年级</option>
				<option  <s:if test="userDTO.grade=='四年级'">selected</s:if> cid="4" value='四年级'  style='color:#999;'>四年级</option>
				<option  <s:if test="userDTO.grade=='五年级'">selected</s:if> cid="5" value='五年级'  style='color:#999;'>五年级</option>
				<option  <s:if test="userDTO.grade=='六年级'">selected</s:if> cid="6" value='六年级'  style='color:#999;'>六年级</option>
				<option  <s:if test="userDTO.grade=='七年级'">selected</s:if> cid="7" value='七年级'  style='color:#999;'>七年级</option>
				<option  <s:if test="userDTO.grade=='八年级'">selected</s:if> cid="8" value='八年级'  style='color:#999;'>八年级</option>
				<option  <s:if test="userDTO.grade=='九年级'">selected</s:if> cid="9" value='九年级'  style='color:#999;'>九年级</option>
				<option  <s:if test="userDTO.grade=='高中一年级'">selected</s:if> cid="10" value='高中一年级'  style='color:#999;'>高中一年级</option>
				<option  <s:if test="userDTO.grade=='高中二年级'">selected</s:if> cid="11" value='高中二年级'  style='color:#999;'>高中二年级</option>
				<option  <s:if test="userDTO.grade=='高中三年级'">selected</s:if> cid="12" value='高中三年级'  style='color:#999;'>高中三年级</option>
				<option  <s:if test="userDTO.grade=='中职一年级'">selected</s:if> cid="13" value='中职一年级'  style='color:#999;'>中职一年级</option>
				<option  <s:if test="userDTO.grade=='中职二年级'">selected</s:if> cid="14" value='中职二年级' style='color:#999;'>中职二年级</option>
				<option  <s:if test="userDTO.grade=='中职三年级'">selected</s:if> cid="15" value='中职三年级'  style='color:#999;'>中职三年级</option>
				<option  <s:if test="userDTO.grade=='中职四年级'">selected</s:if> cid="16" value='中职四年级'  style='color:#999;'>中职四年级</option>
				<option  <s:if test="userDTO.grade=='中职五年级'">selected</s:if> cid="17" value='中职五年级'  style='color:#999;'>中职五年级</option>
				<option  <s:if test="userDTO.grade=='高校/高职一年级'">selected</s:if> cid="18" value='高校/高职一年级'  style='color:#999;'>高校/高职一年级</option>
				<option  <s:if test="userDTO.grade=='高校/高职二年级'">selected</s:if> cid="19" value='高校/高职二年级'  style='color:#999;'>高校/高职二年级</option>
				<option  <s:if test="userDTO.grade=='高校/高职三年级'">selected</s:if> cid="20" value='高校/高职三年级'  style='color:#999;'>高校/高职三年级</option>
				<option  <s:if test="userDTO.grade=='高校/高职四年级'">selected</s:if> cid="21" value='高校/高职四年级'  style='color:#999;'>高校/高职四年级</option>
			</select>
        </div>
        <span class="help-block" id="error_grade"></span>
     </div>
     
     <div class="form-group" id="validate_clazz">
	    <label class="col-md-2 control-label">班级</label>
	    <div class="col-md-3">
	       <select title="请选择所在班级！" id="clazz" class="form-control" name="clazz" > 
				<option  <s:if test="userDTO.clazz==1">selected</s:if> cid="1" value='1'  style='color:#999;'>1班</option>
				<option  <s:if test="userDTO.clazz==2">selected</s:if> cid="2" value='2'  style='color:#999;'>2班</option>
				<option  <s:if test="userDTO.clazz==3">selected</s:if> cid="3" value='3'  style='color:#999;'>3班</option>
				<option  <s:if test="userDTO.clazz==4">selected</s:if> cid="4" value='4'  style='color:#999;'>4班</option>
				<option  <s:if test="userDTO.clazz==5">selected</s:if> cid="5" value='5'  style='color:#999;'>5班</option>
				<option  <s:if test="userDTO.clazz==6">selected</s:if> cid="6" value='6'  style='color:#999;'>6班</option>
				<option  <s:if test="userDTO.clazz==7">selected</s:if> cid="7" value='7'  style='color:#999;'>7班</option>
				<option  <s:if test="userDTO.clazz==8">selected</s:if> cid="8" value='8'  style='color:#999;'>8班</option>
				<option  <s:if test="userDTO.clazz==9">selected</s:if> cid="9" value='9'  style='color:#999;'>9班</option>
				<option  <s:if test="userDTO.clazz==10">selected</s:if> cid="10" value='10'  style='color:#999;'>10班</option>
				<option  <s:if test="userDTO.clazz==11">selected</s:if> cid="11" value='11'  style='color:#999;'>11班</option>
				<option  <s:if test="userDTO.clazz==12">selected</s:if> cid="12" value='12'  style='color:#999;'>12班</option>
				<option  <s:if test="userDTO.clazz==13">selected</s:if> cid="13" value='13'  style='color:#999;'>13班</option>
				<option  <s:if test="userDTO.clazz==14">selected</s:if> cid="14" value='14'  style='color:#999;'>14班</option>
				<option  <s:if test="userDTO.clazz==15">selected</s:if> cid="15" value='15'  style='color:#999;'>15班</option>
				<option  <s:if test="userDTO.clazz==16">selected</s:if> cid="16" value='16'  style='color:#999;'>16班</option>
				<option  <s:if test="userDTO.clazz==17">selected</s:if> cid="17" value='17'  style='color:#999;'>17班</option>
				<option  <s:if test="userDTO.clazz==18">selected</s:if> cid="18" value='18'  style='color:#999;'>18班</option>
				<option  <s:if test="userDTO.clazz==19">selected</s:if> cid="19" value='19'  style='color:#999;'>19班</option>
				<option  <s:if test="userDTO.clazz==20">selected</s:if> cid="20" value='20'  style='color:#999;'>20班</option>
				<option  <s:if test="userDTO.clazz==21">selected</s:if> cid="21" value='21'  style='color:#999;'>21班</option>
				<option  <s:if test="userDTO.clazz==22">selected</s:if> cid="22" value='22'  style='color:#999;'>22班</option>
				<option  <s:if test="userDTO.clazz==23">selected</s:if> cid="23" value='23'  style='color:#999;'>23班</option>
				<option  <s:if test="userDTO.clazz==24">selected</s:if> cid="24" value='24'  style='color:#999;'>24班</option>
				<option  <s:if test="userDTO.clazz==25">selected</s:if> cid="25" value='25'  style='color:#999;'>25班</option>
				<option  <s:if test="userDTO.clazz==26">selected</s:if> cid="26" value='26'  style='color:#999;'>26班</option>
				<option  <s:if test="userDTO.clazz==27">selected</s:if> cid="27" value='27'  style='color:#999;'>27班</option>
				<option  <s:if test="userDTO.clazz==28">selected</s:if> cid="28" value='28'  style='color:#999;'>28班</option>
				<option  <s:if test="userDTO.clazz==29">selected</s:if> cid="29" value='29'  style='color:#999;'>29班</option>
				<option  <s:if test="userDTO.clazz==30">selected</s:if> cid="30" value='30'  style='color:#999;'>30班</option>
				<option  <s:if test="userDTO.clazz==31">selected</s:if> cid="31" value='31'  style='color:#999;'>31班</option>
				<option  <s:if test="userDTO.clazz==32">selected</s:if> cid="32" value='32'  style='color:#999;'>32班</option>
				<option  <s:if test="userDTO.clazz==33">selected</s:if> cid="33" value='33'  style='color:#999;'>33班</option>
				<option  <s:if test="userDTO.clazz==34">selected</s:if> cid="34" value='34'  style='color:#999;'>34班</option>
				<option  <s:if test="userDTO.clazz==35">selected</s:if> cid="35" value='35'  style='color:#999;'>35班</option>
				<option  <s:if test="userDTO.clazz==36">selected</s:if> cid="36" value='36'  style='color:#999;'>36班</option>
				<option  <s:if test="userDTO.clazz==37">selected</s:if> cid="37" value='37'  style='color:#999;'>37班</option>
				<option  <s:if test="userDTO.clazz==38">selected</s:if> cid="38" value='38'  style='color:#999;'>38班</option>
				<option  <s:if test="userDTO.clazz==39">selected</s:if> cid="39" value='39'  style='color:#999;'>39班</option>
				<option  <s:if test="userDTO.clazz==40">selected</s:if> cid="40" value='40'  style='color:#999;'>40班</option>
			</select>
        </div>
        <span class="help-block" id="error_clazz"></span>
     </div>
     
	
     <div class="panel-footer">
       <div class="row">
       <div class="col-md-offset-2 col-md-10">
     <button class="btn btn-primary"  name="Submit32" id="Submit32" type="button">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     
     <button class="btn btn-default" onclick="window.location.href='student.action'" type="button">
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