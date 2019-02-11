<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>友情链接管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script>  
	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {required: true,maxlength: 20},  
		    url:{required: true},
		    upload:{required: true}
		},
 			messages: {
 				name: {
 					required: "请输入项目名称",
 					maxlength: "项目名称最多为20个字符,请重新输入"
 				},
				url:
				{required: "请输入链接地址"
 					}
				,upload:
				{
					required: "请选择一张图片上传"
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

<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
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
	<jsp:param value="friendlink" name="menu" />
	<jsp:param value="menuHead" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
       <li> <span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a>    </li>
       <li> <a href="#" >友情链接管理</a> </li>
       <li class="active"><s:if test="id == null">新增</s:if><s:else>编辑</s:else>友情链接 </li>
    </ol>
      <div class="dr-page-header">
     <h3><s:if test="id == null">新增</s:if><s:else>编辑</s:else>友情链接 </h3>
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
<form id="form1" action="friendlink!save.action?isMy=${isMy}" method="post"  class="form-horizontal dr-form-bordered" 
	enctype="multipart/form-data">
	<input type="hidden" name="id" value="${id}" />
	<div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">友情链接信息</h4>
	  </div>
	</div>
   <div class="form-group" id="validate_name">
    <label class="col-md-2 control-label">链接名称<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${name}" id="name" name="name" class="form-control"/>
		
    </div>
    <span id="error_name" class="help-block"></span>
  </div>

   <div class="form-group" id="validate_url">
    <label class="col-md-2 control-label">链接地址<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${url}" id="url" name="url" class="form-control"/>
		
		<input type="hidden" name="imageName" value="${imageName}"/>
    </div>
    <span id="error_url" class="help-block"></span>
  </div>
   
   <div class="form-group" id="validate_upload">
    <label class="col-md-2 control-label">链接图片<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="file" id="uploadPic" name="uploadPic"  />
	    <div class="img-thumbnail mt10">
	    <img src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>/${imageName}" title="${name}" alt="${name}" />
	    </div>
    </div>
    <span id="error_upload" class="help-block"></span>
  </div>   

  <div class="panel-footer">
    <div class="row">
       <div class="col-md-offset-2 col-md-10">
            <button name="Submit32" type="submit" class="btn btn-primary" >
 			 <span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
 			<button onclick="window.location.href='friendlink.action?isMy=${isMy}'" type="button"class="btn btn-default" >
			 <span class="glyphicon glyphicon-remove"></span>&nbsp;取消</button>
         
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
