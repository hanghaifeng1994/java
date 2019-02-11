<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>广告管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script>  
	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
        
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			webSite: {required: true},
 			uploadPic:{required: true} 
 			  },
 			messages: {
 				webSite: {
 					required: "请输入链接地址"
 				}
				,uploadPic:
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
<style>
.form-control{
float: left;
margin-right:10px;
}
</style>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>

<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>

<div class="dr-wrapper">
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="advertise" name="menu" />
	<jsp:param value="menuHead" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
  <ol class="dr-breadcrumb">
    <li> <span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a> </li>
    <li> <a href="#" >首页管理</a> </li>
    <li class="active"><s:if test="id == null">新增</s:if><s:else>编辑</s:else>广告位 </li>
  </ol>
   <div class="dr-page-header">
     <h3><s:if test="id == null">新增</s:if><s:else>编辑</s:else>广告位 </h3>
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
<div style="margin-top:2px;" class="panel panel-default">
<form id="form1" action="advertise!save.action?isMy=${isMy}" method="post" class="form-horizontal dr-form-bordered"
		enctype="multipart/form-data">
	<input type="hidden" name="id" value="${id}" />

    <div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">      
	      <s:if test="id == null">新增</s:if><s:else>编辑</s:else>广告位信息</h4>
	  </div>
	</div>

    <div class="form-group">
    <label class="col-md-2 control-label" style="float: left;">广告位类型</label>
    <div class="col-md-3">
        <s:select name="type" list="#{'首页顶部':'0','首页中间':'1','首页底部':'2','首页左边':'3'}" theme="simple" listKey="value" listValue="key" value="type" cssClass="form-control">
		</s:select>
    </div>
  </div>
    
    <div class="form-group" id="validate_uploadPic">
    <label class="col-md-2 control-label">图片或者flash<span class="text-danger">*</span></label>
    <div class="col-md-3">
          <input type="file" value="${picSite}" id="upload" name="uploadPic"/>
    </div>
    <span id="error_uploadPic" class="help-block"></span>
  </div>

    <div class="form-group" id="validate_webSite">
    <label class="col-md-2 control-label">地址<span class="text-danger">*</span></label>
    <div class="col-md-3">
          <input type="text" value="${webSite}" id="webSite" name="webSite" class="form-control input-sm"/>
          <input type="hidden" value="${advertise.picSite}" name="picSite" />
          <img src="<common:prop name="ahstudy.uploadpath.url" propfilename=""/>/${picSite }"
			title="${ webSite}" alt="${ webSite}" />
          
    </div>
    <span id="error_webSite" class="help-block"></span>
  </div>

   <div class="panel-footer">
   <div class="row">
    <div class="col-md-offset-2 col-md-10">
       		<button name="Submit22" type="submit" class="btn btn-primary btn-sm" >
 			<span class="glyphicon glyphicon-ok"></span>保存</button>
 		<button
			onclick="window.location.href='advertise.action?isMy=${isMy}'" type="button"class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-remove"></span>取消</button>
    </div>
    </div>
    </div>
</form>
</div>
</div>
    <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
</section>
</div>

</body>
</html>
