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
		$('input[name="yyAble"]').change(function(){
			if($(this).val()=="true"||$(this).val()==true){
				$("#validate_yyEndTime").show();
				$("#validate_yyPersonCount").show();
				$("#validate_lastPersonCount").show();
			}else{
				$("#validate_yyEndTime").hide();
				$("#validate_yyPersonCount").hide();
				$("#validate_lastPersonCount").hide();
				$("#yyEndTime").val("");
				$("#yyPersonCount").val("0");
				$("#lastPersonCount").val("0");
			}
		});
		
		$("#yyEndTime").datetimepicker({
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
		
		$("#cityId").change(function(){
			$("#areaList").html("");
			var cityId = $("#cityId").val();
			if(cityId) {
				$.post("${ctx}/focus/manage/focusbatch!getAreaJson.excsec",{"cityId":cityId},function(data) {
					var practiceUnit = eval(data);
					for(var i = 0 ;i < practiceUnit.length ; i++) {
						$("#areaList").append("<input type=\"checkbox\" name=\"areaIds\"  value=\""+practiceUnit[i].value+"\"/>"+practiceUnit[i].label+"&nbsp;&nbsp;&nbsp;");
					}
				});
			}
		});
		
		//聚焦第一个输入框
		 $("#batchForm").validate({
			rules: {
		    	batchName:{required: true},
		    	yyPersonCount:{
		    		number:true,
		    		maxlength: 10
		    	}
	   		},
			messages: {
		  	 	batchName:{
					required: "请输入批次名称"
				},
				yyPersonCount:
				{
					number:"请输入数字"
				},
				lastPersonCount:
				{
					number:"请输入数字"
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
			<jsp:param value="batch" name="menu" />
			<jsp:param value="focus" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span> <a href="#">平台首页</a></li>
				<li><a href="#">集中考试批次管理</a></li>
				<li class="active"><span>新增批次</span>
				</li>
			</ol>
			<!--/breadcrumb-->

			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					新增批次<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--页面标题end-->

			<!--表单-->

			<form class="form-horizontal dr-form-bordered" id="batchForm" name="batchForm" action="focusbatch!save.action" method="post">
				<input type="hidden" name="userFocusBatchDTO.id" value="${id}" cssClass="tipbox" /> <input type="hidden" name="id" value="${id}" />

				<div class="panel panel-default">
					<div class="dr-form-title clearfix">
						<div class="col-md-12">
							<h4 class="text-primary">新增批次</h4>
						</div>
					</div>

					<div class="form-group" id="validate_name">
						<label class="col-md-2 control-label"> 批次名称<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input type="text" value="${userFocusBatchDTO.batchName}" id="batchName" name="batchName" class="form-control" />
						</div>
						<span id="error_batchName" class="help-block"></span>
					</div>

					<div class="form-group" id="validate_yyAble">
						<label class="col-md-2 control-label">是否允许学员预约<span class="text-danger">*</span> </label>
						<div class="col-md-2">
							<div class="input-group">
								<input name="yyAble" class="yyAble" id="yyAble" type="radio" value="false" 
								<s:if test="userFocusBatchDTO.yyAble!=true">checked</s:if> />否&nbsp;&nbsp; 
								<input name="yyAble" class="yyAble" id="yyAble" type="radio" value="true" 
								<s:if test="userFocusBatchDTO.yyAble==true">checked</s:if> />是&nbsp;&nbsp;
							</div>
						</div>
					</div>

					<div class="form-group" id="validate_yyEndTime" <s:if test="userFocusBatchDTO.yyAble!=true">style="display:none;"</s:if>>
						<label class="col-md-2 control-label">预约截止时间<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input name="yyEndTime" id="yyEndTime" value="<s:date name="userFocusBatchDTO.yyEndTime" format="yyyy-MM-dd"/>" class="form-control" readonly/>
						</div>
						<span id="error_yyEndTime" class="help-block"></span>
					</div>

					<div class="form-group" id="validate_yyPersonCount" <s:if test="userFocusBatchDTO.yyAble!=true">style="display:none;"</s:if>>
						<label class="col-md-2 control-label">总可预约人数<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input type="text" value="${userFocusBatchDTO.yyPersonCount}" id="yyPersonCount" name="yyPersonCount" class="form-control" />
						</div>
						<span id="error_yyPersonCount" class="help-block"></span>
					</div>
					
					<div class="form-group" id="validate_lastPersonCount" <s:if test="userFocusBatchDTO.yyAble!=true">style="display:none;"</s:if>>
						<label class="col-md-2 control-label">剩余可预约人数<span class="text-danger">*</span> </label>
						<div class="col-md-3">
							<input type="text" value="${userFocusBatchDTO.lastPersonCount}" id="lastPersonCount" name="lastPersonCount" class="form-control" readonly/>
						</div>
						<span id="error_lastPersonCount" class="help-block"></span>
					</div>
					
					<div class="form-group" id="validate_cityId" >
						<label class="col-md-2 control-label">指定预约城市</label>（不指定即为所有区域的班级都可以预约）
						<div class="col-md-3">
							<s:select list="citysLists" listKey="id" listValue="name" value="userFocusBatchDTO.cityId" theme="simple" headerValue="--选择城市--" headerKey="" cssClass="form-control" name="cityId" id="cityId"></s:select>
						</div>
						<span id="error_cityId" class="help-block"></span>
					</div>
					
					<div class="form-group" id="validate_areaIds" >
						<label class="col-md-2 control-label">指定预约区域</label>
						<div class="col-md-3" id="areaList">
							<s:iterator value="areasLists" var="area">
								<input type="checkbox" name="areaIds"  value="${area.id }" <s:if test="check">checked="true"</s:if>/>${area.name }&nbsp;&nbsp;&nbsp;
							</s:iterator>
						</div>
						<span id="error_areaIds" class="help-block"></span>
					</div>

					<div class="panel-footer">
						<div class="row">
							<div class="col-md-offset-2 col-md-10">
								<button name="Submit32" type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
								</button>
								<button onclick="window.location.href='focusbatch.action?pid=${pid}'" type="button" class="btn btn-default">
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