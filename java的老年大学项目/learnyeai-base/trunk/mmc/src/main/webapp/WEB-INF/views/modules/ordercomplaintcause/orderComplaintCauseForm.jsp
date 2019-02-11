<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>投诉原因管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				rules:{
					ccCode: {
						remote: "${ctx}/ordercomplaintcause/orderComplaintCause/checkCcCode?oldCode="+ encodeURIComponent('${orderComplaintCause.ccCode}'),
						maxlength: 10,
						required: true
					},
					ccDesc:{
						maxlength: 100,
						required: true
					}
				},
				messages: {
					ccCode: {remote: "编码已存在"}
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ordercomplaintcause/orderComplaintCause/">投诉原因列表</a></li>
		<li class="active">
			<a href="${ctx}/ordercomplaintcause/orderComplaintCause/form?id=${orderComplaintCause.id}">投诉原因<tags:autoFormLabel editPermission="ordercomplaintcause:orderComplaintCause:edit" id="${orderComplaintCause.id}" />
			</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="orderComplaintCause" action="${ctx}/ordercomplaintcause/orderComplaintCause/save" method="post" class="form-search form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="container-fluid">
			<div class="row">
				<div class="control-group span6">
					<label class="control-label">类型：</label>
					<div class="controls">
						<form:select path="ccType" class="input-medium">
							<form:options items="${fns:getConsList('CC_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">投诉编码：</label>
					<div class="controls">
						<input id="oldCode" name="oldCode" type="hidden" value="${orderComplaintCause.ccCode}">
						<form:input path="ccCode" htmlEscape="false" maxlength="20" class="input-medium"/>
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
				<div class="control-group span12">
					<label class="control-label">投诉原因：</label>
					<div class="controls">
						<form:textarea path="ccDesc" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ordercomplaintcause:orderComplaintCause:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>