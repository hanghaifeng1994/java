<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推送消息管理</title>
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
		<li><a href="${ctx}/urpushmsg/urPushMsg/">推送消息列表</a></li>
		<li class="active"><a href="${ctx}/urpushmsg/urPushMsg/form?id=${urPushMsg.id}">推送消息详情
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="urPushMsg" action="${ctx}/urpushmsg/urPushMsg/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
	    <div class="container-fluid">
		<div class="control-group span6">
			<label class="control-label">消息来源：</label>
			<div class="controls">
				<form:select path="pmComType" class="input-medium" disabled="true">
					<form:options items="${fns:getConsList('MSG_COM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<%--<div class="control-group span6">
			<label class="control-label">平台：</label>
			<div class="controls">
				<form:input path="ptId" htmlEscape="false" maxlength="20" class="input-medium " disabled="true"/>
			</div>
		</div>--%>
		<div class="control-group span12">
			<label class="control-label">消息内容：</label>
			<div class="controls">
				<form:textarea path="pmContent" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge" disabled="true"/>
			</div>
		</div>
		<div class="control-group span12">
			<label class="control-label">业务类型：</label>
			<div class="controls">
				<form:select path="pmServiceType" class="input-xlarge" disabled="true">
					<form:options items="${fns:getConsList('PM_SERVICE_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group span6">
			<label class="control-label">对像id：</label>
			<div class="controls">
				<form:input path="pmRelObjId" htmlEscape="false" maxlength="20" class="input-medium " disabled="true"/>
			</div>
		</div>
		<div class="control-group span6">
			<label class="control-label">参数：</label>
			<div class="controls">
				<form:input path="pmParams" htmlEscape="false" maxlength="200" class="input-medium " disabled="true"/>
			</div>
		</div>
		<div class="control-group span6">
			<label class="control-label">推送时间：</label>
			<div class="controls">
				<input name="pmPushDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${urPushMsg.pmPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" disabled="disabled"/>
			</div>
		</div>
		<div class="control-group span6">
			<label class="control-label">推送消息类型：</label>
			<div class="controls">
				<form:select path="pmPushType" class="input-medium" disabled="true">
					<form:options items="${fns:getConsList('PM_PUSH_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group span12">
			<label class="control-label">发送消息人：</label>
			<div class="controls">
				<form:input path="pmSendCustName" htmlEscape="false" maxlength="20" class="input-medium " disabled="true"/>
			</div>
		</div>
		<c:if test="${'1'.equals(urPushMsg.pmPushType)}">
			<div class="control-group span12">
				<label class="control-label">接收消息人：</label>
				<div class="controls">
					<form:textarea path="pmRecieveCustName" htmlEscape="false" rows="4" maxlength="2000" class="input-xxlarge" disabled="true"/>
				</div>
			</div>
		</c:if>
		<c:if test="${'2'.equals(urPushMsg.pmPushType)}">
			<div class="control-group span6">
				<label class="control-label">主题：</label>
				<div class="controls">
					<form:input path="pmTheme" htmlEscape="false" maxlength="20" class="input-medium " disabled="true"/>
				</div>
			</div>
		</c:if>
		<div class="control-group span6">
			<label class="control-label">类型：</label>
			<div class="controls">
				<form:select path="pmType" class="input-medium" disabled="true">
					<form:options items="${fns:getConsList('PM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		</div>
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>