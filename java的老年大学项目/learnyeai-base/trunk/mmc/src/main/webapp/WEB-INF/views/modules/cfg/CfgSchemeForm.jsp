<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>行业方案管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgScheme/" onclick="return lasySubmit(bakForm,this.href);">行业方案列表</a></li>
		<li class="active"><a href="javascript:void()">
		行业方案<tags:autoFormLabel editPermission="cfg:CfgScheme:edit" id="${entry.schmId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgScheme/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="schmId"></form:hidden>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">行业方案名称：</label>
                    <div class="controls">
                            <form:input path="schmName" cssClass="input-medium" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">行业：</label>
                    <div class="controls">
                        <form:select path="schmIndustry" class="input-medium">
                            <form:options items="${fns:getDictList('Industry_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">简介：</label>
                    <div class="controls">
                        <form:textarea path="schmBrief" rows="10" class="input-xxlarge" />
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">描述：</label>
                    <div class="controls">
                        <form:textarea path="schmDesc" rows="10" class="input-xxlarge" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgScheme:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>