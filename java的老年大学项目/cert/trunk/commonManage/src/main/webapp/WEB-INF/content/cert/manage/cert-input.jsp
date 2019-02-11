<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("hbdd",PropertyUtils.getProperty("hbdd.open","false"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>

<script type="text/javascript" language="javascript">   
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
	 	//初始化证书模板及其关联项显示
		onCertplateText($("#certtemplateId").val(),false);
		$.validator.addMethod("validTextOne",function(value,element,params){
			return valideCertpText("textOne","selTextOne");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextTwo",function(value,element,params){
			return valideCertpText("textTwo","selTextTwo");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextThree",function(value,element,params){
			return valideCertpText("textThree","selTextThree");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextFour",function(value,element,params){
			return valideCertpText("textFour","selTextFour");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextFive",function(value,element,params){
			return valideCertpText("textFive","selTextFive");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextSix",function(value,element,params){
			return valideCertpText("textSix","selTextSix");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextSeven",function(value,element,params){
			return valideCertpText("textSeven","selTextSeven");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextEight",function(value,element,params){
			return valideCertpText("textEight","selTextEight");
	},"请选择模板关联项");
		$.validator.addMethod("validTextNine",function(value,element,params){
			return valideCertpText("textNine","selTextNine");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextTen",function(value,element,params){
			return valideCertpText("textTen","selTextTen");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextEleven",function(value,element,params){
			return valideCertpText("textEleven","selTextEleven");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextTwelve",function(value,element,params){
			return valideCertpText("textTwelve","selTextTwelve");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextThirteen",function(value,element,params){
			return valideCertpText("textThirteen","selTextThirteen");
	},"请选择模板关联项");
		$.validator.addMethod("validTextFourteen",function(value,element,params){
			return valideCertpText("textFourteen","selTextFourteen");
	},"请选择模板关联数据项");
		$.validator.addMethod("validTextFifteen",function(value,element,params){
			return valideCertpText("textFifteen","selTextFifteen");
	},"请选择模板关联数据项");
	
		$.validator.addMethod("valideImageOne",function(value,element,params){
			return valideCertpImage("imageOneUrl","imageOne");
	},"请选择模板关联数据项");
		$.validator.addMethod("valideImageTwo",function(value,element,params){
			return valideCertpImage("imageTwoUrl","imageTwo");
	},"请选择模板关联数据项");
		$.validator.addMethod("valideImageThree",function(value,element,params){
			return valideCertpImage("imageThreeUrl","imageThree");
	},"请选择模板关联数据项");
		$.validator.addMethod("valideImageFour",function(value,element,params){
			return valideCertpImage("imageFourUrl","imageFour");
	},"请选择模板关联数据项");
		$.validator.addMethod("valideImageFive",function(value,element,params){
			return valideCertpImage("imageFiveUrl","imageFive");
	},"请选择模板关联数据项");
	
		//聚焦第一个输入框
		//$("#name").focus();
		//为registerForm注册validate函数
		$("#inputForm").validate({
			rules: {
			code: {
				required:true,
				maxlength: 20,
				remote: "cert!checkSerialNoExist.action?oldSerialNo="+encodeURIComponent('${code}')
				},
				numCode: {
					required:true,
					},
				name: {
					required:true,
					maxlength: 40				
					//remote: "cert!checkNameExist.action?oldName="+encodeURIComponent('${name}')
				},
			unit:{
				required: true
			},
			
				selTextOne:"validTextOne",
				selTextTwo:"validTextTwo",
				selTextThree:"validTextThree",
				selTextFour:"validTextFour",
				selTextFive:"validTextFive",
				selTextSix:"validTextSix",
				selTextSeven:"validTextSeven",
				selTextEight:"validTextEight",
				selTextNine:"validTextNine",
				selTextTen:"validTextTen",
				selTextEleven:"validTextEleven",
				selTextTwelve:"validTextTwelve",
				selTextThirteen:"validTextThirteen",
				selTextFourteen:"validTextFourteen",
				selTextFifteen:"validTextFifteen",

				selImageOne:"valideImageOne",
				selImageTwo:"valideImageTwo",
				selImageThree:"valideImageThree",
				selImageFour:"valideImageFour",
				selIimageFive:"valideImageFive"
			},
			messages: {
				code: {
					required: "请输入证书编码",
					maxlength: "证书名称最多为20个字符,请重新输入",
					remote:"证书编号已存在"
				},
				numCode: {
					required: "请输入证书位数",
				},
				name: {
					required: "请输入证书名称",
					maxlength: "证书名称最多为40个字符,请重新输入"
					//remote:"证书名称已存在"
				}, 				
				unit:{
					required: "请输入发证单位"
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
		});
	});

//判断非空
function isNull(value){
	return (value==null || ""==value)?true:false;
}

//判断模板关联下拉列表是否为空,用于保存时的验证
function valideCertpText(certtextValue,templateValue){
	if(isNotNull($("#"+certtextValue).val()) && isNull($("#"+templateValue).val())){
		return false;
 	}
 	return true; 
}

//判断模板关联下拉列表是否为空,用于保存时的验证
function valideCertpImage(certImageValue,templateValue){
	if(isNotNull($("#"+certImageValue).attr("src")) && isNull($("#"+templateValue).val())){
		return false;
 	}
 	return true; 
}

	//清空上传文件文本框
	function clearFileInput(){
	 	var file= document.getElementById('picfile');  
		  var form=document.createElement('form');  
		  document.body.appendChild(form);  
		  var pos = file.nextSibling;  
		  form.appendChild(file);  
		  form.reset();  
		  pos.parentNode.insertBefore(file, pos);  
		  document.body.removeChild(form);  
	} 
	function onSearch(){
	  var x=document.getElementById("form1");
 	  x.action="cert.action";
 	  x.submit();
} 	
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
	<jsp:param value="certlist" name="menu" />
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
		<a href="#">证书管理</a>
		</li>
		<li class="active"><span class="deep_bule"><s:if test="id == null">新增</s:if><s:else>编辑</s:else>证书</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>证书管理<small>&nbsp;</small></h3>
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
    	<form id="inputForm" name="inputForm" action="cert!save.action" method="post" class="form-horizontal dr-form-bordered" role="form">
    	<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="certType" value="0" />
		
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">证书基本信息</h4>
		</div>
		</div>
		
		<div class="form-group" id="validate_name">
		<label class="col-md-2 control-label">证书名称<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${name}" id="name" name="name" class="form-control"/>
		</div>
		<span id="error_name" class="help-block"></span>
		</div>
		
		<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">证书编码<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${code}" id="code" name="code" class="form-control"/> 
		</div>
		<span id="error_code" class="help-block"></span>
		</div>
		<c:if test="${hbdd==true}">
		<div class="form-group" id="validate_numCode">
		<label class="col-md-2 control-label">证书位数<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${numCode}" id="numCode" name="numCode" class="form-control"/> 
		</div>
		<span id="error_numCode" class="help-block"></span>
		</div>
		</c:if>
		
		<div class="form-group" id="validate_unit">
		<label class="col-md-2 control-label">发证单位<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${unit}" id="unit" name="unit" class="form-control"/>
		<input type="hidden" name="imageName" value="${imageName}"/> 
		</div>
		<span id="error_unit" class="help-block"></span>
		</div>
		
		<div class="form-group">
		<label class="col-md-2 control-label">证书模版
		</label>
		<div class="col-md-10">
		<%@ include file="/common/certplateinput.jsp"%> 
		<span id="error_code" class="help-block"></span>
		</div>
		</div>

		<div class="panel-footer">
		<div class="row">
		<div class="col-md-offset-2 col-md-10">
		 	<button class="btn btn-primary btn-sm"  type="submit" name="Submit32">
			<span class="glyphicon glyphicon-ok"></span>
			保存
			</button>
			<button class="btn btn-default btn-sm" onclick="window.location.href='cert.action'" type="button">
			<span class="glyphicon glyphicon-remove" ></span>
			取消
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