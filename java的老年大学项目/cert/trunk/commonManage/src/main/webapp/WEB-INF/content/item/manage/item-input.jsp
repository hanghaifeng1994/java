<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<style>
.form-control{
float: left;
margin-right:10px;
}
</style>
<script type="text/javascript" language="javascript">   
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
		//聚焦第一个输入框
		//$("#name").focus();
		//为registerForm注册validate函数
		$("#inputForm").validate({
			rules: {
			name: {
			required: true,
			maxlength: 20
			}  
			,code:{
				required: true
			}
			,tenantId:{
				required: true
			}
			 
			},
			messages: {
				name: {
					required: "请输入类型名称",
					maxlength: "类型名称最多为20个字符,请重新输入"
				}
			,code:
				{
					required: "请输入类型代码"
				}
			,tenantId:{
				required: "请选择租户"
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
		})
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
	<jsp:param value="itemlist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="#"/>平台首页</a>
		</li>
		<li>
		<a href="#">培训项目管理</a>
		</li>
		<li class="active"><span class="deep_bule">
		<s:if test="#request.id == null">新增</s:if><s:else>编辑</s:else><s:if test="#request.isqlxx=='true'">课程内容</s:if><s:else>项目类型</s:else>
		</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3><s:if test="#request.id == null">新增</s:if><s:else>编辑</s:else>项目类型<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
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
    <!--表单模块-->
    	<div class="panel panel-default">
    	<form id="inputForm" name="inputForm" action="item!save.action" method="post" class="form-horizontal dr-form-bordered" role="form">
    	<input type="hidden" name="id" value="${id}" />
		
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">项目类型基本信息</h4>
		</div>
		</div>
		
		<!--<s:if test="nowUser.super">
	      <div class="form-group" id="validate_tenantId">
		    <label class="col-md-2 control-label">租户<span class="text-danger">*</span></label>
		    <div class="col-md-3">
		      <s:select list="tenantLists" listKey="id"
				value="tenantId" listValue="name" theme="simple"
				cssClass="form-control" name="tenantId" headerValue="--选择租户--"
				headerKey=""></s:select>
	        </div>
	        <span class="help-block" id="error_tenantId"></span>
	     </div>
	    </s:if><s:else><input type="hidden" name="tenantId" value="${nowUser.tenantId}"/></s:else>
		-->
		<div class="form-group" id="validate_name">
		<label class="col-md-2 control-label">类型名称<span class="text-danger">*</span>
		</label>
		<div class="col-md-10">
		<input type="text" value="${itemCategory.name}" id="name" name="name" class="form-control dr-dib" style="width:220px;float: left;" />
		<span id="error_name" class="help-block"></span>
		</div>
		</div>
		
		<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">类型代码<span class="text-danger">*</span>
		</label>
		<div class="col-md-10">
		<input type="text" value="${itemCategory.code}" id="code" name="code" class="form-control dr-dib" style="width:220px;float: left;"/> 
		<span id="error_code" class="help-block"></span>
		</div>
		</div>

		<div class="panel-footer">
		<div class="row">
		<div class="col-md-offset-2 col-md-10">
		 	<button name="Submit32" type="submit" class="btn btn-primary btn-sm" >
		 	<span  class="glyphicon glyphicon-ok"></span>&nbsp;保存 
		 	</button>
			<button onclick="window.location.href='item.action'" type="button" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-remove" ></span>&nbsp;取消
			</button>
		</div>
		</div>
		</div>
	    </form>
	    </div>
    <!--表单模块end-->
    
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