<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>站点-资讯管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/NewsNewsSiteRel/" onclick="return lasySubmit(bakForm,this.href);">站点-资讯列表</a></li>
		<li class="active"><a href="javascript:void()">
		站点-资讯<tags:autoFormLabel editPermission="news:NewsNewsSiteRel:edit" id="${entry.siteId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/NewsNewsSiteRel/save" method="post" class="form-search form-horizontal">
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
                    <label class="control-label">资讯id：</label>
                    <div class="controls">
                            <form:input path="newsId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">栏目id：</label>
                    <div class="controls">
                            <form:input path="catId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">别名：</label>
                    <div class="controls">
                            <form:input path="newsAsTitle" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">管理状态：</label>
                    <div class="controls">
                            <form:input path="newsManageStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">发布状态0未发布，已发布：</label>
                    <div class="controls">
                            <form:input path="newsPubStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">发布时间：</label>
                    <div class="controls">
                            <input id="newsPubDate" name="newsPubDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.newsPubDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">创建站点：</label>
                    <div class="controls">
                            <form:input path="newsCrtSiteId" />
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
			<shiro:hasPermission name="news:NewsNewsSiteRel:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>