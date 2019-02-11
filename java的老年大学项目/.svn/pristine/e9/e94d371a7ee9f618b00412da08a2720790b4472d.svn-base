<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	$(function() {
		
		$("#passDate").datetimepicker({
	    	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0
		}); 
		jQuery.validator.addMethod("positiveinteger", function(value, element) {
			   var aint=parseInt(value);	
			    return aint>0&& (aint+"")==value;   
			  }, "请输入正整数");  
		//聚焦第一个输入框
		 $("#lcardForm").validate({
			rules: {
		    	facePrice:{
		    		number:true,
		    		maxlength: 10
		    	},
		    	paperNumber:{
		    		positiveinteger:true
		    	}
	   		},
			messages: {
				facePrice:
				{
					number:"请输入数字"
				},
				paperNumber:
				{
					positiveinteger:"请输入正整数"
				}
			},
			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
			onfocusin : function(element) { $(element).valid(); },
			success : function(label) {
				var e = $(label).parent().attr("id").split("_")[1];
				var oclass = $("#validate_" + e).attr("class");
				if (oclass&& oclass.indexOf("form-group") > -1)
					oclass = "form-group";
				else
					oclass = "";
				$("#validate_" + e).attr("class",oclass + " has-success")
				$(label).remove();
			},
			errorPlacement : function(error,element) {
				if (document.getElementById("error_" + element.attr("name"))) {
					error.appendTo("#error_" + element.attr("name"));
					var oclass = $("#validate_" + element.attr("name")).attr("class");
					if (oclass && oclass.indexOf("form-group") > -1)
						oclass = "form-group";
					else
						oclass = "";
					$("#validate_" + element.attr("name")).attr("class",oclass + " has-error");
				} else {
					error.insertAfter(element);
				}
			},
			invalidHandler : function(form,validator) { //不通过时回调
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
			},
			errorElement : "strong",
			submitHandler : function(form) { //表单提交句柄,为一回调函数，带一个参数：form  
				var v = $('input[name="yyAble"]:checked').val();
				if (v == true || v == "true") {
					if ($.trim($("#yyEndTime").val()) == "") {
							alert("请输入预约考试时间!");
							return false;
					}
					if ($.trim($("#yyPersonCount").val()) == "") {
							alert("请输入预约人数!");
							return false;
					}
				}
				form.submit(); //提交表单   
			}
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
			<jsp:param value="lcardlist" name="menu" />
			<jsp:param value="lcard" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span> <a href="#">平台首页</a></li>
				<li><a href="#">学习卡管理</a></li>
				<li class="active"><span><s:if test="#request.id == null">新增</s:if><s:else>编辑</s:else>学习卡</span>
				</li>
			</ol>
			<!--/breadcrumb-->

			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					<s:if test="#request.id == null">新增</s:if><s:else>编辑</s:else>学习卡<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--页面标题end-->

			<!--表单-->

			<form class="form-horizontal dr-form-bordered" id="lcardForm" name="lcardForm" action="lcard!save.action" method="post">
				<input type="hidden" name="learningCardDTO.id" value="${id}" cssClass="tipbox" /> <input type="hidden" name="id" value="${id}" />

				<div class="panel panel-default">
					<div class="dr-form-title clearfix">
						<div class="col-md-12">
							<h4 class="text-primary"><s:if test="#request.id == null">新增</s:if><s:else>编辑</s:else>学习卡</h4>
						</div>
					</div>
                   <div class="form-group" id="validate_facePrice">
						<label class="col-md-2 control-label">输入面额<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input type="text" value="${learningCardDTO.facePrice}" id="facePrice" name="facePrice" class="form-control" />
						</div>
						<span id="error_facePrice" class="help-block"></span>
					</div>
					<s:if test="learningCardDTO.id==null">
					<div class="form-group" id="validate_paperNumber">
						<label class="col-md-2 control-label">张数<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input type="text" value="${learningCardDTO.paperNumber}" id="paperNumber" name="paperNumber" class="form-control" />
						</div>
						<span id="error_paperNumber" class="help-block"></span>
					</div></s:if>
					 
					<div class="form-group" id="validate_passDate" >
						<label class="col-md-2 control-label">有效期<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input name="learningCardDTO.passDate" id="passDate" value="<s:date name="learningCardDTO.passDate" format="yyyy-MM-dd"/>" class="form-control" />
						</div>
						<span id="error_passDate" class="help-block"></span>
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col-md-offset-2 col-md-10">
								<button name="Submit32" type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
								</button>
								<button onclick="window.location.href='lcard.action'" type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-remove"></span>&nbsp;取消
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<!--表单end-->
		</div>
		<!--footer start--> <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> <!--footer over--> </section>
	</div>
	<!-- container end -->

</body>
</html>