<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>新增品牌<<%@ include file="/common/title.jsp" %>
</title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
<!-- mytreeview js-->
<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript"></script>
<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript"></script>

<script>
	$(document).ready(function() {
		if ($("#success").text() != "")
			$("#div-success").show();
		if ($("#error").text() != "")
			$("#div-error").show();
		//聚焦第一个输入框
		$("#name").focus();

		// tree初始化
		var o = {
			showcheck : true,
			//url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
			theme : "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
			isfolder : false,
			iscascade : false, //是否选中节点后向下遍历
			isbubble : true //是否选中节点后向上上溯
		//onnodeclick:function(item){alert(item.text);}
		};
		o.data = ${catTreeData};
		$("#navigation").treeview(o);

		$("#inputForm").validate({
			rules : {
				name : {
					required : true
				}
			},
			messages : {
				name : {
					required : "请输入品牌名称"
				}
			},
			onsubmit : function(element) {
				$(element).valid();
			},
			onfocusout : function(element) {
				$(element).valid();
			},
			onkeyup : function(element) {
				$(element).valid();
			},
			onfocusin : function(element) {
				$(element).valid();
			},
			success : function(label) {
				var divId = $(label).parent().attr("id");
				var startindex = divId.indexOf("_");
				var e = divId.substring(startindex + 1);
				//var e = $(label).parent().attr("id").split("_")[1];
				var oclass = $("#validate_" + e).attr("class");
				if (oclass && oclass.indexOf("form-group") > -1)
					oclass = "form-group";
				else
					oclass = "";
				$("#validate_" + e).attr("class", oclass + " has-success")
				$(label).remove();
			},
			errorPlacement : function(error, element) {
				if (document.getElementById("error_" + element.attr("name"))) {
					error.appendTo("#error_" + element.attr("name"));
					var oclass = $("#validate_" + element.attr("name")).attr("class");
					if (oclass && oclass.indexOf("form-group") > -1)
						oclass = "form-group";
					else
						oclass = "";
					$("#validate_" + element.attr("name")).attr("class", oclass + " has-error");
				} else {
					error.insertAfter(element);
				}
			},
			invalidHandler : function(form, validator) { //不通过时回调
				$(".error").each(function(i) {
					var id = $(this).parent().attr("id");
					if (id && id.indexOf("_") > 0) {
						var f = id.split("_")[1];
						var oclass = $("#validate_" + f).attr("class");
						if (oclass && oclass.indexOf("form-group") > -1)
							oclass = "form-group";
						else
							oclass = "";
						$("#validate_" + f).attr("class", oclass + " has-success")
						$(this).remove();
					}
					//alert($(this).html())
				});
			},
			submitHandler : function(form) {
				var s = $("#navigation").getTSVs();
				if (s != null) {
					$("#checkCats").val(s.join(","));
				}
				form.submit();
			}
		});
		window.domain = "localhost";
	});

	function iFrameHeight() {
		var ifm = document.getElementById("main");

		var subWeb = document.frames ? document.frames["main"].document : ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
		}
	}
	function close() {
		$("#iframePic").hide();
		$("#col-md").attr("class", "col-md-2");
	}
</script>
</head>
<body>
	<!--header start-->
	<jsp:include page="/common/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--header over-->

	<!--正文开始-->
	<div class="dr-wrapper">
		<!--正文左边开始-->
		<jsp:include page="/common/adminLeft.jsp">
			<jsp:param value="brandlist" name="menu" />
			<jsp:param value="brand" name="bigmenu" />
		</jsp:include>
		<!--正文右边开始-->
		<!--the end of left-->
		<!--正文右边开始-->
		<section id="main" role="main">
			<div class="dr-container-fluid">
				<ol class="dr-breadcrumb">
					<li><span class="glyphicon glyphicon-home"></span> <a
						href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a></li>
					<li><a href="#">品牌管理</a></li>
					<li class="active"><s:if test="id==null">新增</s:if> <s:else>编辑</s:else>品牌</li>
				</ol>

				<div class="dr-page-header">
					<h3>
						<s:if test="id==null">新增</s:if>
						<s:else>编辑</s:else>
						品牌
					</h3>
				</div>
				<hr />
				<!--信息提示-->
				<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
					<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
					<span id="success"><s:actionmessage theme="simple" /></span>
				</div>
				<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
					<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
					<span id="error"><s:actionerror theme="simple" /></span>
				</div>
				<!--信息提示 end-->
				<div class="panel panel-default">
					<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm"
						name="inputForm" action="brand!save.action" method="post">
						<input id="brandId" name="brandId" type="hidden" value="${brandId}" size="30" />
						<div class="dr-form-title clearfix">
							<div class="col-md-12">
								<h4 class="text-primary">品牌基本信息</h4>
							</div>
						</div>

						<div class="form-group" id="validate_name">
							<label class="col-md-2 control-label">
								品牌名称
								<span class="text-danger">*</span>
							</label>
							<div class="col-md-3">
								<input id="name" name="name" value="${name}" type="text" class="form-control" />
							</div>
							<span class="help-block" id="error_name"></span>
						</div>

						<div class="form-group" id="validate_checkCats">

							<label class="col-md-2 control-label">品牌分类</label>
							<div class="col-md-5">
								<div id="tree"
									style="width:250px;height:250px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
									<ul id="navigation">
									</ul>
									<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}" />
								</div>
								<span class="help-block" id="error_checkCats"></span>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-offset-2 col-md-10">
									<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
										<span class="glyphicon glyphicon-ok"></span>
										&nbsp;保存
									</button>
									<button name="Submit32" class="btn btn-default btn-sm" type="button"
										onclick="window.location.href='brand.action'">
										<span class="glyphicon glyphicon-remove"></span>
										&nbsp;取消
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!--footer start-->
			<jsp:include page="/common/adminFooter.jsp">
				<jsp:param value="index" name="menu" />
			</jsp:include>
			<!--footer over-->
		</section>
	</div>
</body>
</html>
