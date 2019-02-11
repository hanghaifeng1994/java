<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShAppletSetting/configSmallOrdList" onclick="return lasySubmit(bakForm,this.href);">小程序配置列表</a></li>
		<li class="active"><a href="javascript:void()">
		小程序配置<tags:autoFormLabel editPermission="sh:ShAppletSetting:edit" id="${entry.appId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShAppletSetting/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <form:hidden path="apltSetId" />
                <div class="control-group span6">
                    <label class="control-label">AppId：</label>
                    <div class="controls">
                            <form:input path="appId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">AppSecret：</label>
                    <div class="controls">
                            <form:input path="appSecret" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">小程序名称：</label>
                    <div class="controls">
                            <form:input path="appName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户名称：</label>
                    <div class="controls">
                            <form:input path="wechatMerchantName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户号：</label>
                    <div class="controls">
                            <form:input path="wechatMerchantNum" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户密钥：</label>
                    <div class="controls">
                            <form:input path="wechatMerchantPasswod" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">公众号appid：</label>
                    <div class="controls">
                            <form:input path="publicNumAppid" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">公众号appsecrete：</label>
                    <div class="controls">
                            <form:input path="publicNumAppsecrete" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户方案id：</label>
                    <div class="controls">
                            <form:input path="mchtSchmId" readonly="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户id：</label>
                    <div class="controls">
                            <form:input path="mchtId" readonly="true"/>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShAppletSetting:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>