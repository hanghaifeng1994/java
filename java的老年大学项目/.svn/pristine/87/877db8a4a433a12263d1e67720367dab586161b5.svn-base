<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政区划管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>

<script>  
	$(document).ready(function() {
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
	 			name: {
					required: true,
					maxlength: 50
				},
				code:{
					required: true
				}
 			},
 			messages: {
 				name: {
 					required: "请输入区划名称",
 					maxlength: "分类名称最多为50个字符,请重新输入"
 				},
 				code:{
 					required: "请输入区划代码"
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
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="cantonlist" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
    </jsp:include>
   <!--adminLeft结束-->  
 
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">基础数据管理</a></li>
     <li class="active">
       <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>区划
     </li>
    </ol>
    
    
   <div class="dr-page-header">
     <h3> 
      <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>区划
     </h3>
   </div>
   <hr/>

<div class="panel panel-default">
<form id="form1" name="form1" action="canton!save.action" method="post"  class="form-horizontal dr-form-bordered" enctype="multipart/form-data">
<input type="hidden" name="id" value="${id}" />
<input id="parentId" name="parentId" type="hidden" value="${parentId}" size="30"/>
    <div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">      
	       <s:if test="id == null">新增</s:if>
           <s:else>编辑</s:else>区划信息</h4>
	  </div>
	</div>
  <div class="form-group" id="validate_name">
    <label class="col-md-2 control-label">区划名称<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${name}" id="name" name="name" class="form-control"  />
    </div>
    <span id="error_name" class="help-block"></span>
  </div>

    <div class="form-group" id="validate_code">
    <label class="col-md-2 control-label">区划代码<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${code}" id="code" name="code" class="form-control"  />
    </div>
    <span id="error_code" class="help-block"></span>
  </div>
  <s:if test="(id!=null && parentId!=null && type==2)||(id==null && parentId!=null && parentType==1)"><!--
  
  
   <div class="form-group" id="validate_doname">
    <label class="col-md-2 control-label">区划域名<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${doname}" id="doname" name="doname" class="form-control"  />
    </div>
    <span id="error_doname" class="help-block"></span>
   </div>
   <div class="form-group" id="validate_logo">
    <label class="col-md-2 control-label">区划首页Logo名称<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${logo}" id="logo" name="logo" class="form-control"  />
    </div>
    <span id="error_logo" class="help-block"></span>
   </div>
   
   --><div class="form-group" id="validate_sublogo">
    <label class="col-md-2 control-label">区划首页副logo名称<span class="text-danger"></span></label>
    <div class="col-md-3">
	    <input type="text" value="${sublogo}" id="sublogo" name="sublogo" class="form-control"  />
    </div>
    <span id="error_sublogo" class="help-block"></span>
   </div>
   
  <div class="form-group">
    <label class="col-md-2 control-label">区划首页Logo图片<span class="text-danger"></span></label>
    <div class="col-md-10">
      <input name="uploadPic" type="file"/>
      <span class="woring_x" id="error_uploadPic"></span>
      <div class="img-thumbnail mt10">
      <img alt="140x140" data-src="holder.js/140x140" style="width:140px; height:140px;" src="<common:prop name="ahstudy.uploadpath.url" propfilename=""/>${pic}" width="10" height="16"/>
      </div>
    </div>
  </div>
   
  </s:if>
      <s:if test='advanceName!=""'>
    <div class="form-group">
		<strong>上级区划: ${advanceName}</strong>
	</div>
	</s:if>
   <div class="panel-footer">
   <div class="row">
    <div class="col-md-offset-2 col-md-10">
	 <button class="btn btn-primary"  name="Submit32" type="submit">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     <button class="btn btn-default" onclick="window.location.href='canton.action?pid=${pid}'" type="button">
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
