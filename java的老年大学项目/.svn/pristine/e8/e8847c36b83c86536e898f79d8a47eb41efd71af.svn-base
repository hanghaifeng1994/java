<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>投诉管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
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
		<li><a href="${ctx}/ordercomplaint/orderComplaint/zjList">投诉列表</a></li>
		<li class="active"><a href="${ctx}/ordercomplaint/orderComplaint/zjform?id=${orderComplaint.id}">投诉
		<tags:autoFormLabel editPermission="ordercomplaint:orderComplaint:edit" id="${orderComplaint.id}" />
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="orderComplaint" action="${ctx}/ordercomplaint/orderComplaint/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">订单id：</label>
			<div class="controls">
				<form:input path="cmtOrdId" htmlEscape="false" maxlength="20" class="input-xlarge " disabled="true"/>
			</div>
		</div>
        <div class="control-group">
            <label class="control-label">货源名称：</label>
            <div class="controls">
                <form:input path="title" htmlEscape="false" maxlength="20" disabled="true" class="input-xlarge"  />
            </div>
        </div>
		<div class="control-group">
			<label class="control-label">业务类型：</label>
			<div class="controls">
				<form:input path="cmtServiceType" htmlEscape="false" maxlength="20" class="input-xlarge " disabled="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投诉内容：</label>
			<div class="controls">
				<form:textarea path="cmtContent" htmlEscape="false" maxlength="2000" class="input-xlarge " disabled="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:input path="cmtImgs" htmlEscape="false" maxlength="200" class="input-xlarge " disabled="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投诉人名称：</label>
			<div class="controls">
				<form:input path="cmtCustName" htmlEscape="false" maxlength="200" class="input-xlarge " disabled="true"/>
			</div>
		</div>
        <div class="control-group">
            <label class="control-label">处理类型：</label>
            <div class="controls">
                <form:select path="cmtStatus" class="input-medium" >
                    <form:option value="1">同意</form:option>
                    <form:option value="2">驳回</form:option>
                </form:select>
            </div>
        </div>
		<div class="control-group">
			<label class="control-label">处理备注：</label>
			<div class="controls">
				<form:textarea path="cmtAuditRemark" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处理图片：</label>
			<div class="controls">
                <input type="hidden" name="cmtAuditImgs" value="${orderComplaint.cmtAuditImgs}" />
                <input class="fileupload" id="cmtAuditImgs" type="file" data-url="${ctx}/resourceUpload" data-display-id="photo"
                       data-preview="true" data-rule-accept="image/*"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">金额：</label>
			<div class="controls">
				<form:input path="cmtAmount" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="form-actions">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
            <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>