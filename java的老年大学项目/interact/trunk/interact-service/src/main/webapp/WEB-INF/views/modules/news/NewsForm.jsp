<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/News/" onclick="return lasySubmit(bakForm,this.href);">资讯列表</a></li>
		<li class="active"><a href="javascript:void()">
		资讯<tags:autoFormLabel editPermission="news:News:edit" id="${entry.newsId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/News/save" method="post" class="form-search form-horizontal">
        <tags:message />
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">ID：</label>
                    <div class="controls">
                            <form:input path="newsId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">标题：</label>
                    <div class="controls">
                            <form:input path="title" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">标签：</label>
                    <div class="controls">
                            <form:input path="tags" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">内容：</label>
                    <div class="controls">
                            <form:input path="content" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">来源：</label>
                    <div class="controls">
                            <form:input path="newsSource" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">封面：</label>
                    <div class="controls">
                            <form:input path="photo" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">作者：</label>
                    <div class="controls">
                            <form:input path="author" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">栏目：</label>
                    <div class="controls">
                            <form:input path="catId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">附件ids：</label>
                    <div class="controls">
                            <form:input path="fileIds" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">附件名称：</label>
                    <div class="controls">
                            <form:input path="fileIdNames" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">0未置顶、1已置顶：</label>
                    <div class="controls">
                            <form:input path="topStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核：</label>
                    <div class="controls">
                            <form:input path="status" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">0未发布、1已发布：</label>
                    <div class="controls">
                            <form:input path="pubStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">发布时间：</label>
                    <div class="controls">
                            <input id="pubDate" name="pubDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.pubDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">审核id：</label>
                    <div class="controls">
                            <form:input path="auditId" />
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
			<shiro:hasPermission name="news:News:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>