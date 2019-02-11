<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>

<script type="text/javascript" language="javascript">
	$(document).ready(function() { 
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
		//聚焦第一个输入框
		//$('input[name="title"]').focus();
		
		$("#inputForm").validate({
			rules: {
				title: {
					required: true
				},
				content: {
					required: true
				}
			},
			messages: {
				title:{
					required:"请输入标题",
					maxlength:"字数小于10位"
				},
				content:{
					required:"请输入内容"
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
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="aboutme" name="menu" />
	<jsp:param value="message" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="#">平台首页 </a>
		</li>
		<li>
		<a href="#">信息发布管理</a>
		</li>
		<li class="active"><span class="deep_bule"><s:if
			test="id==null">发布</s:if><s:else>编辑</s:else>信息</span></li>
		</ol>
	<!--/breadcrumb-->
	
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>发布信息<small>&nbsp;关于我们</small></h3>
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
    <!--表单-->
    	<div class="panel panel-default">
    		<form id="inputForm" name="inputForm" action="aboutme!save.action" method="post" enctype="multipart/form-data" 
    		class="form-horizontal dr-form-bordered" role="form">
    		<input id="id" name="id" type="hidden" value="${id}" size="30" />
    		<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
    		  <div class="dr-form-title clearfix">
    		  <div class="col-md-12">
    		    <h4 class="text-primary">基本信息</h4>
    		  
    		  </div>
    		
    		</div>
    		
    		
    		<div class="form-group" id="validate_title">
			<label class="col-md-2 control-label">
			标题
			<span class="text-danger">*</span>
			</label>
			<div class="col-md-3">
			<input name="title" value="${title}" type="text" class="form-control dr-dib" />
			</div>
			<span class="help-block" id="error_title"></span>
			</div>
			
			<div class="form-group" id="validate_content">
			<label class="col-md-2 control-label">
			内容
			<span class="text-danger">*</span>
			</label>
			<div class="col-md-4">
			<textarea rows="15" cols="116" name="content" class="form-control">${content}</textarea>
			<span class="help-block" id="error_content"></span>
			<script type="text/javascript">
			createCkEditor("${ctx}/fckeditor/","content",700,380,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
			function FCKeditor_OnComplete(editorInstance) { 
				//IE,搜狗浏览器的
				if(document.all){
					editorInstance.EditorDocument.attachEvent("onkeyup", editor_keyup); 
				}else{//火狐浏览器
					editorInstance.EditorDocument.addEventListener('keyup', editor_keyup,false) ;
				}
			}
			function editor_keyup(e) 
			   { 
			    if(getLength()>0)
					$('#error_content').hide();
			    else
			    	$('#error_content').show();
			   }
			</script>
			</div>
			</div>
			
			<div class="panel-footer">
		    	<div class="row">
					<div class="col-md-offset-2 col-md-10">
						<button class="btn btn-primary btn-sm"  type="submit" name="Submit32">
						<span class="glyphicon glyphicon-ok"></span>
						保存
						</button>
						<button class="btn btn-default btn-sm" onclick="window.location.href='aboutme.action'" type="button">
						<span class="glyphicon glyphicon-remove" ></span>&nbsp;取消
						</button>
					</div>
				</div>
			</div>
    		</form>
    	</div>
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