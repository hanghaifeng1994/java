<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单功能包管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShOrderFuncPackage/" onclick="return lasySubmit(bakForm,this.href);">订单功能包列表</a></li>
		<li class="active"><a href="javascript:void()">
		订单功能包<tags:autoFormLabel editPermission="sh:ShOrderFuncPackage:edit" id="${entry.ordPkgId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShOrderFuncPackage/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">订单功能包id：</label>
                    <div class="controls">
                            <form:input path="ordPkgId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户订单id：</label>
                    <div class="controls">
                            <form:input path="ordId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">功能包id：</label>
                    <div class="controls">
                            <form:input path="pkgId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">功能包名称：</label>
                    <div class="controls">
                            <form:input path="pkgName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">功能包描述：</label>
                    <div class="controls">
                            <form:input path="pkgDesc" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">功能包金额：</label>
                    <div class="controls">
                            <form:input path="ordPkgAmount" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">1基础，2增值：</label>
                    <div class="controls">
                            <form:input path="pkgType" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">创建时间：</label>
                    <div class="controls">
                            <input id="createDate" name="createDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShOrderFuncPackage:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>