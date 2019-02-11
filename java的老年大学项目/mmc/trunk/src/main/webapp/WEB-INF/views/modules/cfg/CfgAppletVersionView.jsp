<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序版本管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgAppletVersion/" onclick="return lasySubmit(bakForm,this.href);">小程序版本列表</a></li>
		<li class="active"><a href="javascript:void()">
		小程序版本<tags:autoFormLabel editPermission="cfg:CfgAppletVersion:edit" id="${entry.apltVerId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgAppletVersion/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="apltVerId"/>
        <form:hidden path="apltId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">小程序appid：</label>
                    <div class="controls">
                            <form:input path="apltAppId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">小程序appsecret：</label>
                    <div class="controls">
                            <form:input path="apltAppSecret" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">小程序名称：</label>
                    <div class="controls">
                            <form:input path="apltName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本编码：</label>
                    <div class="controls">
                            <form:input path="apltVerCode" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本名称：</label>
                    <div class="controls">
                            <form:input path="apltVerName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本描述：</label>
                    <div class="controls">
                            <form:input path="apltVerDesc" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户升级信息添加状态：0未添加升级信息、1添加升级信息，所有关联此小程序方案版本都添加升级信息：</label>
                    <div class="controls">
                            <form:input path="apltVerStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">包路径：</label>
                    <div class="controls">
                            <form:input path="apltVerZipPath" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">自动上线：0未开启、1开启，商户小程序是否自动上线：</label>
                    <div class="controls">
                            <form:input path="apltVerAutoOnline" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">小程序代码模版ID：</label>
                    <div class="controls">
                            <form:input path="apltVerTemplateId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户小程序上传代码数量：</label>
                    <div class="controls">
                            <form:input path="apltVerUploadNum" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户小程序审核数量：</label>
                    <div class="controls">
                            <form:input path="apltVerAuditNum" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户小程序发布数量：</label>
                    <div class="controls">
                            <form:input path="apltVerPubNum" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">创建人：</label>
                    <div class="controls">
                            <form:input path="createBy" />
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
			<shiro:hasPermission name="cfg:CfgAppletVersion:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>