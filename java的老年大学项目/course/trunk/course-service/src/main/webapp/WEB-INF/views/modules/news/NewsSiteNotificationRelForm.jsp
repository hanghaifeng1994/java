<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>站点-通知管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/NewsSiteNotificationRel/" onclick="return lasySubmit(bakForm,this.href);">站点-通知列表</a></li>
		<li class="active"><a href="javascript:void()">
		站点-通知<tags:autoFormLabel editPermission="news:NewsSiteNotificationRel:edit" id="${entry.siteId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/NewsSiteNotificationRel/save" method="post" class="form-search form-horizontal">
        <tags:message />
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">站点：</label>
                    <div class="controls">
                            <form:input path="siteId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">通知id：</label>
                    <div class="controls">
                            <form:input path="ntId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">别名：</label>
                    <div class="controls">
                            <form:input path="ntAsTitle" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">0没有权限、1有权限：</label>
                    <div class="controls">
                            <form:input path="ntManageStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">发布状态：</label>
                    <div class="controls">
                            <form:input path="ntPubStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">发布时间：</label>
                    <div class="controls">
                            <input id="ntPubDate" name="ntPubDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.ntPubDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">创建站点：</label>
                    <div class="controls">
                            <form:input path="ntCrtSiteId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户id：</label>
                    <div class="controls">
                            <form:input path="mchtId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商户方案id：</label>
                    <div class="controls">
                            <form:input path="mchtSchmId" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="news:NewsSiteNotificationRel:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>