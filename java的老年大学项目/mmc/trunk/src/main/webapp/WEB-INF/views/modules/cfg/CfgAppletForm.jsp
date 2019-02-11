<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgApplet/" onclick="return lasySubmit(bakForm,this.href);">小程序列表</a></li>
		<li class="active"><a href="javascript:void()">
		小程序<tags:autoFormLabel editPermission="cfg:CfgApplet:edit" id="${entry.apltId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgApplet/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="apltId"/>

		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">

                <div class="control-group span12">
                    <label class="control-label">行业方案：</label>
                    <div class="controls">
                        <wey:schemeSelect nameValue="schmId" idValue="schmId" isAll="0" cssClass="input-medium"></wey:schemeSelect>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">小程序：</label>
                    <div class="controls">
                        <form:input path="apltName" required="required" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">模块编码：</label>
                    <div class="controls">
                        <form:input path="apltMdlCode" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">小程序appid：</label>
                    <div class="controls">
                            <form:input path="apltAppId" required="required" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">小程序secret：</label>
                    <div class="controls">
                            <form:input path="apltAppSecret" required="required" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">小程序描述：</label>
                    <div class="controls">
                            <form:textarea path="apltDesc" rows="12" cssClass="input-xxlarge" required="required" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgApplet:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>