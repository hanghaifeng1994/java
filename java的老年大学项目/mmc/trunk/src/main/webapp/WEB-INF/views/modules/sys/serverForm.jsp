<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(function() {
			$("#value").focus();

			$("#inputForm").validate({
				
                rules: {
                    label: {
                        required: true,
                        repeatCheck: true,
						maxlength: 30
                    },
					value: { maxlength: 50, required: true },
					description: { maxlength: 50, required: true },
					sort: { number: true, required: true }
                },
                messages: {
                    label: {repeatCheck: "配置项不能重复"}
                }
            });
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/dict/toServerList">服务配置列表</a></li>
		<li class="active"><a href="${ctx}/sys/dict/toServerForm?id=${dict.id}">服务配置<tags:autoFormLabel editPermission="sys:dict:edit" id="${dict.id}" /></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="dict" action="${ctx}/sys/dict/serverSave" method="post" class="from-search form-horizontal">
		<form:hidden path="id"/>
		<tags:message />
        <input type="hidden" name="type" value="${dict.type}" />
		<div class="container-fluid">
			<div class="row">
				<div class="control-group span6">
					<label class="control-label" for="label">配置项：</label>
					<div class="controls">
						<form:input path="label" htmlEscape="false" maxlength="100" class="required"
                                    data-checkUrl="${ctx}/sys/dict/serverConfigRepeatCheck.json"
                                    data-oldValue="${dict.label}"/>
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label" for="value">配置内容：</label>
					<div class="controls">
						<form:input path="value" htmlEscape="false" maxlength="100" class="required"/>
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label" for="description">描述：</label>
					<div class="controls">
						<form:input path="description" htmlEscape="false" maxlength="50" class="required"/>
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label" for="sort">排序：</label>
					<div class="controls">
						<form:input path="sort" htmlEscape="false" maxlength="11" class="required digits"/>
					</div>
				</div>
			</div>
		</div>


		<div class="form-actions">
			<shiro:hasPermission name="sys:dict:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>