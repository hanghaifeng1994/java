<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本历史管理</title>
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
		<li class="active"><a href="javascript:void(0)">
		新版本</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionHis/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}

        <form:hidden path="schmEdtId"/>
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">方案版本名称：</label>
                    <div class="controls">
                        ${edition.schmEdtName}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">修改类型：</label>
                    <div class="controls">
                            ${fns:getConsLabel("CFG_SCHEME_EDITION_MOD_STATUS", edition.schmEdtModStatus, '修改信息')}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本升级备注：</label>
                    <div class="controls">
                        <form:textarea path="schmEdtHisRemark" rows="10" cssClass="input-xxlarge" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgSchemeEditionHis:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="增 加"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>