<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
		//聚焦第一个输入框
		 $("#form1").validate({
			rules: {
			resAddress:{required: true},
			resName:{required: true},
			resCount:{required: true}
	   },
			messages: {
		       resName:{
	   		required: "请输入考场名称"
	            },
		   resAddress:{
					required: "请输入考场地址"
				},
				
			resCount:{
					required: "请输入座位数量"
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
			});
	    } ,
	     errorElement: "strong"	
		});
		
	});

</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="focusresource" name="menu" />
	<jsp:param value="focus" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb">
		<li>
		  <span class="glyphicon glyphicon-home"></span>
		  <a href="#">平台首页</a>
		</li>
		<li>
		<a href="#">考场资源列表</a>
		</li>
		<li class="active"><span>新增考场</span></li>
		</ol>
	<!--/breadcrumb-->
	
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>新增考场<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    
    <!--表单-->
    	
    		<form class="form-horizontal dr-form-bordered" id="form1" action="focusresource!save.action" method="post">
    			<input type="hidden" name="userFocusResourceDTO.id" value="${id}" cssClass="tipbox"/>
			
				<div class="panel panel-default">
	          <div class="dr-form-title clearfix">
	              <div class="col-md-12">
	                <h4 class="text-primary">新增考场</h4>
	              </div>
	          </div>
			
			<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">
					    考场名称<span class="text-danger">*</span>
					</label>
				<div class="col-md-3">
				   <input type="text" value="${userFocusResourceDTO.resName}" id="resName" name="resName" class="form-control" <s:if test="!editable">readonly</s:if> />
				</div>
			        <span id="error_resName" class="help-block"></span>
			</div>
			
			<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">
					    考场编码
					</label>
				<div class="col-md-3">
				   <input type="text" value="${userFocusResourceDTO.code}" id="code" name="code" class="form-control" />
				</div>
			    <span id="error_code" class="help-block"></span>
			</div>
			
			
			<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">
					    考场地址<span class="text-danger">*</span>
					</label>
				<div class="col-md-3">
				   <input type="text" value="${userFocusResourceDTO.resAddress}" id="resAddress" name="resAddress" class="form-control" <s:if test="!editable">readonly</s:if>/>
				</div>
			        <span id="error_resAddress" class="help-block"></span>
			</div>
			
			
			
			<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">
					    座位数量<span class="text-danger">*</span>
					</label>
				<div class="col-md-3">
				   <input type="text" value="${userFocusResourceDTO.resCount}" id="resCount" name="resCount" class="form-control"/>
				</div>
			        <span id="error_resCount" class="help-block"></span>
			</div>

				
				  <div class="panel-footer">
    <div class="row">
       <div class="col-md-offset-2 col-md-10">
            <button name="Submit32" type="submit" class="btn btn-primary" >
 			 <span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
 			<button onclick="window.location.href='focusresource.action?pid=${pid}'" type="button"class="btn btn-default" >
			 <span class="glyphicon glyphicon-remove"></span>&nbsp;取消</button>
         
       </div>
      
    </div>
  </div>
			    
			    </div>
    		</form>
    	
    <!--表单end-->
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
	</section>
</div>
<!-- container end -->

</body>
</html>