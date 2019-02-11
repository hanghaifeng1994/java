<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本功能包管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
        <li class=""><a href="${ctx}/cfg/CfgSchemeEdition/assignPkgFrom" onclick="return lasySubmit(bakForm,this.href);">配置功能包</a></li>
		<li class="active"><a href="javascript:void()">
		方案版本功能包<tags:autoFormLabel editPermission="cfg:CfgSchmEdtPackage:edit" id="${entry.edtPkgId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchmEdtPackage/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <form:hidden path="edtPkgId"/>
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        ${param.schmEdtName}
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">模块：</label>
                    <div class="controls">
                        ${param.mdlName}
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">功能包：</label>
                    <div class="controls">
                        ${param.pkgName}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">类型：</label>
                    <div class="controls">
                        <form:select path="edtPkgType" cssClass="input-medium" disabled="${entry.edtPkgStatus==1? 'true': 'false'}">
                                <form:options items="${fns:getConsList('CFG_SCHM_EDT_PACKAGE_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">年价格：</label>
                    <div class="controls">
                            <form:input path="edtPkgYearPrice" class="number"/>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">月价格：</label>
                    <div class="controls">
                            <form:input path="edtPkgMonthPrice" class="number"/>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgSchmEdtPackage:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>