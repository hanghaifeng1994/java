<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="java.util.Random"%>
<html>
<head>
<title>新增管理员-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if>
	<s:else><%@ include file="/common/title.jsp"%></s:else>
</title>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp"%>
    <link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
	<script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>
<script>
	$(document).ready(function() {
		if ($("#success").text() != "")
			$("#div-success").show();
		if ($("#error").text() != "")
			$("#div-error").show();
			
		var o = {
                showcheck: true,          
                //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
				isfolder:false,
				iscascade: true, //是否选中节点后向下遍历
                isbubble: false //是否选中节点后向上上溯
                //onnodeclick:function(item){alert(item.text);}
        	};
        	o.data = ${catTreeData};
        	$("#navigation").treeview(o);
	});
	
	function submitHandler() {
	        var s=$("#navigation").getTSVs();
	        if(s !=null){
				$("#checkCats").val(s.join(","));
	        }
		}
</script>
</head>
<body>

	<!--adminHeader开始-->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--adminHeader结束-->

	<div class="dr-wrapper">
		<!--adminLeft结束-->
		<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
			<jsp:param value="module" name="menu" />
			<jsp:param value="system" name="bigmenu" />
		</jsp:include>
		<!--adminLeft结束-->

		<section id="main" role="main">
			<div class="dr-container-fluid">
				<ol class="dr-breadcrumb">
					<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a
						href="#">平台首页</a></li>
					<li><a href="#">功能模块设置</a></li>
					<li class="active"><span class="deep_bule">编辑</span>
					</li>
				</ol>
				<div class="panel panel-default">
					<form id="inputForm" name="inputForm"
						class="form-horizontal dr-form-bordered"
						action="moduleconfig!save.action?rmd=<%=new Random().nextInt()%>"
						method="post" onsubmit="submitHandler();">
						<input id="tenantId" name="tenantId" type="hidden" value="${tenantId}" size="30" />

						<div class="form-group" id="validate_tenantId">
							<label class="col-md-2 control-label" >
								<s:if test="tenant==null">大平台</s:if>
								<s:if test="tenant!=null">${tenant.logo }</s:if>
							</label>
							<span class="help-block" id="error_tenantId"></span>
						</div>
						<div class="form-group" id="validate_aids">
					    <label class="col-md-2 control-label">功能模块<span class="admin_red">*</span></label>
					    <div class="col-md-3">
							<div id="tree" style="width:440px;height:400px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
								<ul id="navigation">
								</ul>
								<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
							</div>
							<span class="help-block" id="error_aids"></span>
						</div>

						<div class="panel-footer">
							<div class="row">
								<div class="col-md-offset-2 col-md-10">
									<button class="btn btn-primary" name="Submit32" type="submit">
										<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
									</button>

									<button class="btn btn-default"
										onclick="cancelModule();" type="button">
										<span class="glyphicon glyphicon-remove"></span>&nbsp;取消
									</button>
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
			<!--footer start-->
			<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
				<jsp:param value="index" name="menu" />
			</jsp:include>
			<!--footer over-->
		</section>
	</div>
<script>
	function cancelModule(){
		var tenantId = $("#tenantId").val();
		window.location='moduleconfig.action?tenantId='+tenantId;
	}
</script>

</body>
</html>