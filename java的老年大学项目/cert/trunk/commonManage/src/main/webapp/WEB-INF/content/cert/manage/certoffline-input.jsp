<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if>
	<s:else><%@ include file="/common/title.jsp"%></s:else>
</title>
<%@ include file="/common/admin_meta.jsp"%>

<script type="text/javascript" language="javascript">   
var textStr = new Array(15);
var imgStr = new Array(5);
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
	//初始化证书模板及其关联项显示
	//
	//alert(123);
	if('${id}'!=''){
		init();
	}else{
		addCerttemplate();
	}
	
	
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
				maxlength: 20
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
					maxlength: "证书名称最多为20个字符,请重新输入"
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
			onsubmit: function(element) { 
				$(element).valid(); 
			},
			submitHandler:function(form){
	            onSave();
        	},
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

	function init(){
		$.ajax({
			type:"post",    //请求方式
			url:"${certapiurl}/cert/certoffline/manage/info",
			dataType:"jsonp",    //跨域json请求一定是jsonp
			jsonp: "callback",    //跨域请求的参数名，默认是callback
			jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			data:{
				"id":$("#id").val()
			},    //请求参数
			success: function(data) {
			    //请求成功处理，和本地回调完全一样
			    //oldObj = data;
			    $("#name").val(data.name);
			    $("#code").val(data.code);
			    $("#unit").val(data.unit);
			    $("#templateId").val(data.certtemplateId);
			    $("#certtemplateId").val(data.certtemplateId);
			    
			    
			    if(data.templateText){
			    	$.each(data.templateText.split(";"),function(i,v){
			    		textStr[i] = v;
			    	});
			    }
			    if(data.templateImage){
			    	$.each(data.templateImage.split(";"),function(i,v){
			    		imgStr[i] = v;
			    	});
			    }
			    $("#selTextOne").val(textStr[0]);
			    $("#selTextTwo").val(textStr[1]);
			    $("#selTextThree").val(textStr[2]);
			    $("#selTextFour").val(textStr[3]);
			    $("#selTextFive").val(textStr[4]);
			    $("#selTextSix").val(textStr[5]);
			    $("#selTextSeven").val(textStr[6]);
			    $("#selTextEight").val(textStr[7]);
			    $("#selTextNine").val(textStr[8]);
			    $("#selTextTen").val(textStr[9]);
			    $("#selTextEleven").val(textStr[10]);
			    $("#selTextTwelve").val(textStr[11]);
			    $("#selTextThirteen").val(textStr[12]);
			    $("#selTextFourteen").val(textStr[13]);
			    $("#selTextFifteen").val(textStr[14]);
			    $("#imageOne").val(imgStr[0]);
			    $("#imageTwo").val(imgStr[1]);
			    $("#imageThree").val(imgStr[2]);
			    $("#imageFour").val(imgStr[3]);
			    $("#imageFive").val(imgStr[4]);
			    addCerttemplate();
			},
			error: function() {
			    //请求出错处理
			}
		});
	}
function onSave(){

	$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certoffline/manage/save",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"id":$("#id").val(),
			    	"certType":1,
			    	"certtemplateId":$("#certtemplateId").val(),
			    	"name":$("#name").val(),
			    	"code":$("#code").val(),
			    	"unit":$("#unit").val(),
			    	"selTextOne":$("#selTextOne").val(),
			    	"selTextTwo":$("#selTextTwo").val(),
			    	"selTextThree":$("#selTextThree").val(),
			    	"selTextFour":$("#selTextFour").val(),
			    	"selTextFive":$("#selTextFive").val(),
			    	"selTextSix":$("#selTextSix").val(),
			    	"selTextSeven":$("#selTextSeven").val(),
			    	"selTextEight":$("#selTextEight").val(),
			    	"selTextNine":$("#selTextNine").val(),
			    	"selTextTen":$("#selTextTen").val(),
			    	"selTextEleven":$("#selTextEleven").val(),
			    	"selTextTwelve":$("#selTextTwelve").val(),
			    	"selTextThirteen":$("#selTextThirteen").val(),
			    	"selTextFourteen":$("#selTextFourteen").val(),
			    	"selTextFifteen":$("#selTextFifteen").val(),
			    	"selImageOne":$("#imageOne").val(),
			    	"selImageTwo":$("#imageTwo").val(),
			    	"selImageThree":$("#imageThree").val(),
			    	"selImageFour":$("#imageFour").val(),
			    	"selImageFive":$("#imageFive").val()
			    },    //请求参数
			    success: function(data) {
			        //请求成功处理，和本地回调完全一样
			        location.href="${ctx}/cert/manage/certoffline.action";
			    },
			    error: function() {
			        //请求出错处理
			    }
			});
}

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
 	  x.action="certoffline.action";
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
			<jsp:param value="certofflinelist" name="menu" />
			<jsp:param value="programs" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="#" />平台首页</a></li>
				<li><a href="#">证书管理</a></li>
				<li class="active"><span class="deep_bule">
						<s:if test="id == null">新增</s:if>
						<s:else>编辑</s:else>
						证书
					</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					证书管理<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--页面标题end-->
			<!--表单模块-->
			<div class="panel panel-default">
			
				    	<form id="inputForm" name="inputForm" action="${certapiurl}/cert/certoffline/manage/save" method="post" class="form-horizontal dr-form-bordered" role="form">
				
				<input type="hidden" name="id" id="id" value="${id}"/>
				<input type="hidden" name="certType" id="certType" value="1" />
				<input type="hidden" name="templateId" id="templateId" />

				<div class="dr-form-title clearfix">
					<div class="col-md-12">
						<h4 class="text-primary">证书基本信息</h4>
					</div>
				</div>
				
				<div class="form-group" id="validate_name">
					<label class="col-md-2 control-label">
						证书名称
						<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
						<input type="text" id="name" name="name" class="form-control" />
					</div>
					<span id="error_name" class="help-block"></span>
				</div>


				<div class="form-group" id="validate_code">
					<label class="col-md-2 control-label">
						证书编码
						<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
						<input type="text" id="code" name="code" class="form-control" />
					</div>
					<span id="error_code" class="help-block"></span>
				</div>

				<div class="form-group" id="validate_unit">
					<label class="col-md-2 control-label">
						发证单位<span class="text-danger">*</span>
					</label>
					<div class="col-md-3">
						<input type="text" id="unit" name="unit" class="form-control" />
						<input type="hidden" name="imageName" />
					</div>
					<span id="error_unit" class="help-block"></span>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label">证书模版 </label>
					<div class="col-md-10">
						<%@ include file="/common/certplateinputoffline.jsp"%>
						<span id="error_code" class="help-block"></span>
					</div>
				</div>

				<div class="panel-footer">
					<div class="row">
						<div class="col-md-offset-2 col-md-10">
							<button class="btn btn-primary btn-sm" type="submit"  name="Submit32">
								<span class="glyphicon glyphicon-ok"></span>
								保存
							</button>
							<button class="btn btn-default btn-sm" onclick="window.location.href='certoffline.action'"
								type="button">
								<span class="glyphicon glyphicon-remove"></span>
								取消
							</button>
						</div>
					</div>
				</div>
				
				</form>
			</div>
			<!--表单模块end-->
		</div>
		<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include>
		</section>
	</div>
	<!-- container end -->
</body>
</html>