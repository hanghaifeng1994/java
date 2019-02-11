<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>功能包管理</title>
	<meta name="decorator" content="default"/>
    <%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"));
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgFunctionPackage/" onclick="return lasySubmit(bakForm,this.href);">功能包列表</a></li>
		<li class="active"><a href="javascript:void()">
		功能包<tags:autoFormLabel editPermission="cfg:CfgFunctionPackage:edit" id="${entry.pkgId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgFunctionPackage/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="pkgId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">功能包名称：</label>
                    <div class="controls">
                            <form:input path="pkgName" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">模块：</label>
                    <div class="controls">
                        <form:select path="mdlId" class="input-large" disabled="${empty param.id ? 'false':'true'}">
                            <form:options items="${mdlList}" itemLabel="mdlName" itemValue="mdlId"></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">功能包描述：</label>
                    <div class="controls">
                        <form:textarea path="pkgDesc" rows="10" class="input-xxlarge" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgFunctionPackage:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>