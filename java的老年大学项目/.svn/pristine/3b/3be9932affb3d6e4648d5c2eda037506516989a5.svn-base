<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发布方案版本</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgSchemeEdition/" onclick="return lasySubmit(bakForm,this.href);">方案版本列表</a></li>
		<li class="active"><a href="javascript:void()">发布方案版本</li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="editHis" action="${ctx}/cfg/CfgSchemeEdition/pub" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="schmEdtId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">方案版本名称：</label>
                    <div class="controls">
                            <form:input path="schmEdtName" disabled="true"/>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">升级状态：</label>
                    <div class="controls">
                        <form:input path="schmUpdateStatus" />
                    </div>
                </div>

                <div class="control-group span12">
                    <label class="control-label">版本升级备注：</label>
                    <div class="controls">
                        <form:textarea path="schmUpdateRemark" rows="10" cssClass="input-xxlarge" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">升级内容：</label>
                    <div class="controls">
                        <form:textarea path="schmUpdateContent" rows="10" cssClass="input-xxlarge" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>