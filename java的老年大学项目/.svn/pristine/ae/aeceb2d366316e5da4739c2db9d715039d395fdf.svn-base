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
$(document).ready(function(){
		//聚焦第一个输入框
		//$("#name").focus();
		//为registerForm注册validate函数
		$("#inputForm").validate({
			rules: {
				<s:if test="nowUser.super">
				tenantId:{
					required: true,
				},
				</s:if>
				name: {
				required: true,
				maxlength: 20
				}  
			},
			messages: {
				<s:if test="nowUser.super">
				tenantId:{
					required: "请选择租户"
				},
				</s:if>
				name: {
					required: "请输入分类名称",
					maxlength: "分类名称最多为20个字符,请重新输入"
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
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="category" name="menu" />
	<jsp:param value="brand" name="bigmenu" />
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
		<a href="#">分类管理</a>
		</li>
		<li class="active"><span>发布分类</span></li>
		</ol>
	<!--/breadcrumb-->
	
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>发布分类<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    
    <!--表单-->
    	
    		<form class="form-horizontal dr-form-bordered" id="inputForm" action="category!save.action" method="post">
    			<input type="hidden" name="id" value="${id}"/>
				<input type="hidden" name="parentId" id="parentId" value="${parentId}"/>
				<input type="hidden" name="level" id="parentId" value="${level}"/>　　
				<input type="hidden" name="code" id="code" value="${code}"/>
				<input type="hidden" name="orderNum" id="orderNum" value="${orderNum}"/>
				<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
				<div class="panel panel-default">
	          <div class="dr-form-title clearfix">
	              <div class="col-md-12">
	                <h4 class="text-primary">新增/编辑分类</h4>
	              </div>
	          </div>
			
				<div class="form-group" id="validate_name">
				<label class="col-md-2 control-label">
				    名称<span class="text-danger">*</span>
				</label>
				<div class="col-md-3">
				   <input id="name"  name="name" value="${name}" type="text" class="form-control"/>
				</div>
			       <span class="help-block" id="error_name"></span>
				</div>

				<s:if test="parentId != '' && parentId != null">
				<div class="form-group">
				<label class="col-md-2 control-label">
				上级分类
				<span class="text-danger">*</span>
				</label>
				<div class="col-md-3">
				<input name="parentName" disabled="disabled" value="${parentCategoryName}" type="text" class="form-control"  />
				</div>
				</div>
				</s:if>
				
				<div class="form-group" id="validate_name">
				<label class="col-md-2 control-label">
				    分类图片<span class="text-danger">*</span>
				</label>
				<div class="col-md-3" id="col-md">
				 <input id="pic" name="pic" type="hidden" value="${pic}"/>
		     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
				 <span class="glyphicon glyphicon-open mr5"></span>上传图片
				 </button>
				 <div  style="display: none;" id="iframePic" >
				 <iframe src="${ctx}/news/manage/category!uploadphoto.action?picfileFileName=${pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
				 </div>
				<s:if test="pic!=null">
				<div class="img-thumbnail mt10" style="width:300px;">
		         <img id="cruPic" alt="294x170" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${pic}" style="width:294px; height:170px;"/>
		        </div>
		        </s:if>
				</div>
				<span id="error_uploadPic" class="help-block"></span>
				</div>
				
				<div class="panel-footer">
			    	<div class="row">
						<div class="col-md-offset-2 col-md-10">
							<button class="btn btn-primary"  type="submit" name="Submit32">
							<span class="glyphicon glyphicon-ok"></span>
							保存
							</button>
							<button class="btn btn-default" onclick="window.location.href='category.action?parentId=${parentId}&position=true&isMy=${isMy}'" type="button">
							<span class="glyphicon glyphicon-remove"></span>
							取消
							</button>
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