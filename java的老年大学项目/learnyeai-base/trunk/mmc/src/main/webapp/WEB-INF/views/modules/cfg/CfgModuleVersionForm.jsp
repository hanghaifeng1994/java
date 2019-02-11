<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模块版本管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
            $('#mdlVerDate').val(new Date().format("yyyy-MM-dd"));
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgModuleVersion/" onclick="return lasySubmit(bakForm,this.href);">模块版本列表</a></li>
		<li class="active"><a href="javascript:void()">
		模块版本<tags:autoFormLabel editPermission="cfg:CfgModuleVersion:edit" id="${entry.mdlVerId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgModuleVersion/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">模块id：</label>
                    <div class="controls">
                        <form:select path="mdlId" class="input-medium">
                            <form:options items="${mdlList}" itemLabel="mdlName" itemValue="mdlId" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本名称：</label>
                    <div class="controls">
                            <form:input path="mdlVerName"/>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本内容：</label>
                    <div class="controls">
                        <form:textarea path="mdlVerDesc" rows="10" cssStyle="width:80%" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本日期：</label>
                    <div class="controls">
                        <input id="mdlVerDate" name="mdlVerDate" type="text" readonly="readonly" maxlength="20"
                               class="Wdate" value="<fmt:formatDate value="${entry.mdlVerDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgModuleVersion:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>