<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本管理</title>
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
		<li class="active"><a href="javascript:void()">
		方案版本<tags:autoFormLabel editPermission="cfg:CfgSchemeEdition:edit" id="${entry.schmEdtId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEdition/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="schmEdtId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">方案版本名称：</label>
                    <div class="controls">
                            <form:input path="schmEdtName" />
                    </div>
                </div>
                <%--<div class="control-group span6">
                    <label class="control-label">图片：</label>
                    <div class="controls">
                            <form:input path="schmEdtPhoto" />
                    </div>
                </div>--%>
                <div class="control-group span12">
                    <label class="control-label">行业方案：</label>
                    <div class="controls">
                        <form:select path="schmId" cssClass="input-medium">
                            <form:options itemValue="schmId" itemLabel="schmName" items="${schemeList}" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本描述：</label>
                    <div class="controls">
                        <textarea:textarea path="schmEdtDesc" rows="12" cssClass="input-xxlarge" />
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