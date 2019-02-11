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
	action="student!editor.action"
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
  
   <div class="form-group" id="validate_password">
	 <label class="col-md-2 control-label">新密码<span class="text-danger">*</span></label>
	 <div class="col-md-3">
	    <input id="password" name="password" value="" type="password" class="form-control"/>
    </div>
    <span class="help-block" id="error_password"></span>
  </div>
  
  <div class="form-group" id="validate_qpassword">
	 <label class="col-md-2 control-label" >确认密码<span class="text-danger">*</span></label>
	 <div class="col-md-3">
	    <input class="form-control" type="password" id="qpassword" name="qpassword"> 
	    <!--<input id="password" name="oldpassword" value="${password}" type="hidden" class="form-control" />-->
    </div>
     <span class="help-block" id="error_qpassword"></span> 
  </div>
 
     <div class="form-group" id="validate_name">
	    <label class="col-md-2 control-label">姓名<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="name" name="name" value="${userDTO.name}" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_name"></span>
     </div><!--
     
     <div class="form-group" id="validate_nick">
	    <label class="col-md-2 control-label">昵称<span class="text-danger">*</span></label>
	    <div class="col-md-3">
	       <input id="nick" name="nick" value="${userDTO.nick}" type="text" class="form-control"/>
        </div>
        <span class="help-block" id="error_nick"></span>
     </div>
	
	 --><div class="form-group" id="validate_idcard">
	    <label class="col-md-2 control-label">身份证号</label>
	    <div class="col-md-3">
	       <input id="idcard" name="idcard" value="${userDTO.idcard}" type="text" class="form-control"/>
	       <input type="hidden" value="${form}" name="form" />
        </div>
        <span class="help-block" id="error_idcard"></span> 
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