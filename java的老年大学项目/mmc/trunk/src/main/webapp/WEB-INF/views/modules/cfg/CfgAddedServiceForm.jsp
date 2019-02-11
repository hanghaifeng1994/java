<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>增值服务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgAddedService/" onclick="return lasySubmit(bakForm,this.href);">增值服务列表</a></li>
		<li class="active"><a href="javascript:void()">
		增值服务<tags:autoFormLabel editPermission="cfg:CfgAddedService:edit" id="${entry.asId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgAddedService/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <form:hidden path="asId"/>
                <div class="control-group span6">
                    <label class="control-label">增值服务名称：</label>
                    <div class="controls">
                            <form:input path="asName" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">服务价格：</label>
                    <div class="controls">
                            <form:input path="asPrice" class="number" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">编码：</label>
                    <div class="controls">
                            <form:input path="asCode" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">状态：</label>
                    <div class="controls">
                        <form:select path="asStatus" class="input-large" required="true">
                            <form:option value="0">未启用</form:option>
                            <form:option value="1">启用</form:option>
                            <form:option value="2">作废</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">描述：</label>
                    <div class="controls">
                        <form:textarea path="asDesc" rows="10" cssStyle="width:98%" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgAddedService:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>