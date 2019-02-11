<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本升级信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgSchemeEditionUpdateInfo/" onclick="return lasySubmit(bakForm,this.href);">方案版本升级信息列表</a></li>
		<li class="active"><a href="javascript:void()">
		方案版本升级信息<tags:autoFormLabel editPermission="cfg:CfgSchemeEditionUpdateInfo:edit" id="${entry.edtUpId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionUpdateInfo/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">方案版本名称：</label>
                    <div class="controls">
                            ${edtion.schmEdtName}
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本名称：</label>
                    <div class="controls">
                        ${entry.edtUpVerName}
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">升级类型：</label>
                    <div class="controls">
                            ${fns:getConsLabel('CFG_SCHEME_EDITION_UPDATE_INFO_TYPE', entity.edtUpType, '自定义')}
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本时间：</label>
                    <div class="controls">
                        ${fns:formatDate(entry.edtUpVerDate, 'yyyy-MM-dd')}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">升级内容：</label>
                    <div class="controls">
                        ${entry.edtUpContent}
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>