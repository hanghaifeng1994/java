<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>租户管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>

<script>  
	$(document).ready(function() {
		
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 				rules: {
 				<s:if test="id==null">
 				idnum: {
				digits:true,
				remote: "tenant!checkId.excsec"
				},
				</s:if>
	 			logo: {
					required: true,
					maxlength: 50
				},
				doname:{
					required: true,
					remote: "tenant!checkDoname.excsec?oldDoname=" + encodeURIComponent('${tenant.doname}')
				},
				name:{
					required: true
					}
 			},
 			messages: {
 				<s:if test="id==null">
 				idnum: {
					digits:"请输入整数",
					remote: "该id已存在，请重新输入"
				},
				</s:if>
 				logo: {
 					required: "请输入租户名称",
 					maxlength: "分类名称最多为50个字符,请重新输入"
 				},
 				doname:{
					required: "请输入租户域名",
					remote:"该域名已存在"
				},
				name:{
					required: "请输入租户简称"
					}
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
</script>
</head>

<body>
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="tenantlist" name="menu" />
	<jsp:param value="tenant" name="bigmenu" />
    </jsp:include>
   <!--adminLeft结束-->  
 
  <section id="main" role="main">
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">租户管理</a></li>
     <li class="active">
       <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>租户
     </li>
    </ol>
    
    
   <div class="dr-page-header">
     <h3> 
      <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>租户
     </h3>
   </div>
   <hr/>

<div class="panel panel-default">
<form id="form1" name="form1" action="tenant!save.action" method="post"  class="form-horizontal dr-form-bordered" enctype="multipart/form-data">
<input type="hidden" name="id" value="${id}" />
    <div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">      
	       <s:if test="id == null">新增</s:if>
           <s:else>编辑</s:else>租户信息</h4>
	  </div>
	</div>
	
  <div class="form-group" id="validate_idnum">
    <label class="col-md-3 control-label">租户id</label>
    <div class="col-md-3">
	    <input type="text" <s:if test="id!=null">readonly="readonly"</s:if> value="${tenant.id}" id="idnum" name="idnum" class="form-control"  />
     	<span class="help-block">（不填则系统生成）</span>
    </div>
    <span id="error_idnum" class="help-block"></span>
  </div>
  <div class="form-group" id="validate_logo">
    <label class="col-md-3 control-label">租户名称<span class="text-danger">*</span></label>
    <div class="col-md-3">
    	<input type="text" value="${tenant.logo}" id="logo" name="logo" class="form-control"  />
    </div>
    <span id="error_logo" class="help-block"></span>
  </div>
    <!--
    <div class="form-group" id="validate_code">
    <label class="col-md-2 control-label">租户代码<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${code}" id="code" name="code" class="form-control"  />
    </div>
    <span id="error_code" class="help-block"></span>
  </div>
   -->
   
   <div class="form-group" id="validate_doname">
    <label class="col-md-3 control-label">租户域名<span class="text-danger">*</span></label>
    <div class="col-md-6">
	    <input type="text" value="${tenant.doname}" id="doname" name="doname" class="form-control"  />
	    <span style="color: #888;">（请输入带http或者https前缀的完整域名比如：http://learn.wxjy.com.cn/nc）</span>
    </div>
    <span id="error_doname" class="help-block"></span>
   </div>
      <div class="form-group" id="validate_contents">
    <label class="col-md-3 control-label">租户样式和头部文件相对目录</label>
    <div class="col-md-3">
	    <input type="text" value="${tenant.contents}" id="contents" name="tenant.contents" class="form-control"  />
    </div>
	    <span class="help-block">（请系统维护人员手工指定后给出，应以'/'开头）</span>
    <span id="error_contents" class="help-block"></span>
   </div>
   <div class="form-group" id="validate_name">
    <label class="col-md-3 control-label">租户简称</label>
    <div class="col-md-3">
    	<input type="text" value="${tenant.name}" id="name" name="tenant.name" class="form-control"  />
    </div>
    <span id="error_name" class="help-block"></span>
   </div>
   
    <div class="form-group" id="validate_name">
    <label class="col-md-3 control-label">是否开放注册</label>
    <div class="col-md-5 mt5">
        <s:radio cssClass="ml5 mr5" cssStyle="font-weight: normal;" list="#{false:'开放',true:'不开放'}" id="isregister" value="tenant.isregister"  name="isregister" theme="simple"></s:radio>
    </div>

   </div>
   <!--
   <div class="form-group" id="validate_sublogo">
    <label class="col-md-3 control-label">租户首页副logo名称</label>
    <div class="col-md-3">
	    <input type="text" value="${tenant.sublogo}" id="sublogo" name="tenant.sublogo" class="form-control"  />
    </div>
    <span id="error_sublogo" class="help-block"></span>
   </div>
  	-->
  <div class="form-group">
    <label class="col-md-3 control-label">首页Logo图片</label>
    <div class="col-md-6">
      <input name="uploadPic" type="file"/>
      <span class="woring_x" id="error_uploadPic"></span>
      <div class="img-thumbnail mt10">
      <img alt="140x140" data-src="holder.js/140x140" style="width:140px; height:140px;" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>${tenant.pic}" width="10" height="16"/>
      </div>
    </div>
  </div>
   
   <div class="panel-footer">
   <div class="row">
    <div class="col-md-offset-3 col-md-10">
	 <button class="btn btn-primary"  name="Submit32" type="submit">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     <button class="btn btn-default" onclick="window.location.href='tenant.action?rnd=${rnd}'" type="button">
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
