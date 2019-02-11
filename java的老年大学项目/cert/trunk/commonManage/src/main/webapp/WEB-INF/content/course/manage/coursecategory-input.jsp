<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<!--<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
-->
<%@ include file="/common/admin_meta.jsp"%>

<script>  
	$(document).ready(function() {
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 10
			}  
			,code:
			{
				required: true
			}
 			 
 			},
 			messages: {
 				name: {
 					required: "请输入分类名称",
 					maxlength: "分类名称最多为10个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入分类编号"
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
	        errorElement: "strong" 
 		});
 	});
 	
 	function uploadpic(){
		$("#iframePic").show();
		$("#col-md").attr("class","col-md-10");
	}

	function saveEditorPic(avatarname){
		var picPath = "<common:prop name="traincore.uploadpath.url" propfilename=""/>"+avatarname
		$("#pic").val(avatarname);
		$("#cruPic").attr("src",picPath);
		$("#iframePic").hide();
		$("#col-md").attr("class","col-md-2");
	}
</script>

</head>

<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="input-coursecategory" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">课程资源库管理</a>
</li>
<li class="active"><s:if test="id == null">新增</s:if><s:else>编辑</s:else>课程分类
</li>
</ol>

<div class="dr-page-header">
<h3>
<s:if test="id == null">新增</s:if><s:else>编辑</s:else>课程分类
</h3>
</div>
<hr/>
<div class="panel panel-default">
<form id="form1" action="coursecategory!save.action" method="post" class="form-horizontal dr-form-bordered" role="form">
<input type="hidden" name="id" value="${id}" />
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">课程分类基本信息</h4>
</div>
</div>

<div class="form-group" id="validate_name">
		<label class="col-md-2 control-label">分类名称<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input class="form-control" type="text" value="${name}" id="name" name="name"/>
		<input class="form-control" type="hidden" value="${isMy}" name="isMy"/>
		</div>
		<span id="error_name" class="help-block"></span>
</div>
<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">分类编号<span class="text-danger">*</span></label>
		<div class="col-md-3">
		<input type="text" value="${code}" id="code" name="code" class="form-control"/>
		</div>
		<span id="error_code" class="help-block"></span>
</div>
<div class="form-group">    
		<label class="col-md-2 control-label">分类等级</label>
		<div class="col-md-3">
		<p class="help-block">${level}</p><input type="hidden" name="level" value="${level}" />			
		</div>
</div>

<div class="form-group">    
		<label class="col-md-2 control-label">分类图片</label>
		<div class="col-md-3" id="col-md">
		 <input id="pic" name="pic" type="hidden" value="${pic}"/>
     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
		 <span class="glyphicon glyphicon-open mr5"></span>上传图片
		 </button>
		 <div  style="display: none;" id="iframePic" >
		 <iframe src="${ctx}/course/manage/coursecategory!uploadphoto.action?picfileFileName=${pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
		 </div>
		<s:if test="pic!=null">
		<div class="img-thumbnail mt10" style="width:300px;">
         <img id="cruPic" alt="294x170" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${pic}" style="width:294px; height:170px;"/>
        </div>
        </s:if>
		</div>
		<span id="error_uploadPic" class="help-block"></span>
</div>

<s:if test="level>1">
<div class="form-group">
	<label class="col-md-2 control-label">上级分类</label>
	<div class="col-md-3">
		<p class="help-block">${parentName}</p><input type="hidden" name="parentId" value="${parentId}"/>
	</div>
</div>
</s:if>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">
    <div class="btn-group">
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>
        保存
        </button>
    </div>
    <div class="btn-group">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='coursecategory.action?parentId=${parentId}&isMy=${isMy}'">
        <span class="glyphicon glyphicon-remove"></span>
                     取消
        </button>
    </div>
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
<!--正文结束-->
</body>
</html>
