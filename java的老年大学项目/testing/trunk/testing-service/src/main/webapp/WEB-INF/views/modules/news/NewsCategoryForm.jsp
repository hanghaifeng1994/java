<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯栏目管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/NewsCategory/" onclick="return lasySubmit(bakForm,this.href);">资讯栏目列表</a></li>
		<li class="active"><a href="javascript:void()">
		资讯栏目<tags:autoFormLabel editPermission="news:NewsCategory:edit" id="${entry.catId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/NewsCategory/save" method="post" class="form-search form-horizontal">
        <tags:message />
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">id：</label>
                    <div class="controls">
                            <form:input path="catId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">名称：</label>
                    <div class="controls">
                            <form:input path="catName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">封面：</label>
                    <div class="controls">
                            <form:input path="catPhoto" />
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
                <div class="control-group span6">
                    <label class="control-label">更新人：</label>
                    <div class="controls">
                            <form:input path="updateBy" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">更新时间：</label>
                    <div class="controls">
                            <input id="updateDate" name="updateDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">删除标记：</label>
                    <div class="controls">
                            <form:input path="delFlag" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">站点：</label>
                    <div class="controls">
                            <form:input path="siteId" />
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
			<shiro:hasPermission name="news:NewsCategory:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>