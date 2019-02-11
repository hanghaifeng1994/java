<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模块管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgModule/" onclick="return lasySubmit(bakForm,this.href);">模块列表</a></li>
		<li class="active"><a href="javascript:void()">
		模块<tags:autoFormLabel editPermission="cfg:CfgModule:edit" id="${entry.mdlId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgModule/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="mdlId"></form:hidden>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">模块编码：</label>
                    <div class="controls">
                        <c:if test="${empty entry.mdlId}">
                            <form:input path="mdlCode" />
                        </c:if>
                        <c:if test="${not empty entry.mdlId}">
                            <form:input disabled="true" path="mdlCode" />
                        </c:if>

                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">模块名称：</label>
                    <div class="controls">
                            <form:input path="mdlName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">模块上下文：</label>
                    <div class="controls">
                        <form:input path="mdlServerContext" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">员工扩展表：</label>
                    <div class="controls">
                        <form:input path="mdlStaffTableName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">用户扩展表：</label>
                    <div class="controls">
                        <form:input path="mdlUserTableName" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgModule:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>