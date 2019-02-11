<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShMerchant/" onclick="return lasySubmit(bakForm,this.href);">商户列表</a></li>
		<li class="active"><a href="javascript:void()">
		商户<tags:autoFormLabel editPermission="sh:ShMerchant:edit" id="${entry.mchtId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShMerchant/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <form:hidden path="mchtId"></form:hidden>
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">商户名称：</label>
                    <div class="controls">
                            <form:input path="mchtName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户shortname：</label>
                    <div class="controls">
                            <form:input path="mchtShortname" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">联系人：</label>
                    <div class="controls">
                            <form:input path="mchtLinkman" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">手机号：</label>
                    <div class="controls">
                            <form:input path="mchtPhone" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">座机：</label>
                    <div class="controls">
                            <form:input path="mchtTelephone" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">状态：</label>
                    <div class="controls">
                        <form:select path="mchtStatus" class="input-medium">
                            <%--<form:option value="" label="--请选择--"/>--%>
                            <form:options items="${fns:getConsList('ENABLE_DISABLE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">地址：</label>
                    <div class="controls">
                            <form:input path="mchtAdress" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">行业：</label>
                    <div class="controls">
                        <form:select path="mchtIndustry" class="input-medium">
                            <form:options items="${fns:getDictList('Industry_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">备注：</label>
                    <div class="controls">
                        <for:textarea path="remarks"></for:textarea>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShMerchant:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>