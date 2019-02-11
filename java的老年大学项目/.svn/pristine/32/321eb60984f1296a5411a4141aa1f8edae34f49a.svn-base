<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  

<script type="text/javascript" language="javascript">   

	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();

		 $("#pubTime").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 1
				 });       
		//$("#pubTime").datepick({dateFormat: 'yy-mm-dd'});
		 
		//聚焦第一个输入框
		//$('input[name="title"]').focus();
		
		$("#inputForm").validate({
			rules: {
				<s:if test="nowUser.super">
				tenantId:{
					required: true,
				},
				</s:if>
				title: {
					required: true
				},
				content: {
					required: true
				}
			},
			messages: {
				<s:if test="nowUser.super">
				tenantId:{
					required: "请选择租户"
				},
				</s:if>
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
	<jsp:param value="notice" name="menu" />
	<jsp:param value="message" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="#">平台首页</a>
		</li>
		<li>
		<a href="#">公告管理</a>
		</li>
		<li class="active"><span class="deep_bule"><s:if
			test="id==null">发布</s:if><s:else>编辑</s:else>公告</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>公告管理<small>&nbsp;</small></h3>
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
    	<form id="inputForm" name="inputForm" action="notice!save.action" method="post" class="form-horizontal dr-form-bordered" role="form">
    	<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
    	<input id="id" name="id" type="hidden" value="${id}" size="30" />
		
	    <div class="dr-form-title clearfix">
           <div class="col-md-12">
              <h4 class="text-primary">发布公告基本信息</h4>
          </div>
       </div>
		<!--
		<s:if test="nowUser.super">
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
	    
	    
		<div class="form-group" id="validate_title">
		<label class="col-md-2 control-label">标题<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input name="title" value="${title}" type="text" class="form-control dr-dib" />
		</div>
		<span class="help-block" id="error_title"></span>
		</div>
		
		<div class="form-group">
		<label class="col-md-2 control-label">来源
		</label>
		<div class="col-md-3">
		<input name="author" value="${author}" type="text" class="form-control dr-dib"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="col-md-2 control-label" >发布时间
		</label>
		<div class="input-group date col-md-3" style="padding-left: 15px;" id="pubTime">
		  <input type="text" value="<s:date name="pubTime" format="yyyy-MM-dd" />"  name="pubTime" readonly="readonly" class="form-control dr-dib"/>
		  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		</div>

		</div>
		
		<div class="form-group" id="validate_content">
		<label class="col-md-2 control-label">内容<span class="text-danger">*</span>
		</label>
		<div class="col-md-10">
		<textarea class="form-control" rows="3" name="content">${content}</textarea>
		<span class="help-block" id="error_content"></span>
		<script type="text/javascript">
		createCkEditor("${ctx}/fckeditor/","content",700,320,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
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
			<button class="btn btn-default btn-sm" onclick="window.location.href='notice.action?isMy=${isMy}'" type="button">
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