<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>通知管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/NewsNotification/" onclick="return lasySubmit(bakForm,this.href);">通知列表</a></li>
		<li class="active"><a href="javascript:void()">
		通知<tags:autoFormLabel editPermission="news:NewsNotification:edit" id="${entry.ntId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/NewsNotification/save" method="post" class="form-search form-horizontal">
        <tags:message />
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">id：</label>
                    <div class="controls">
                            <form:input path="ntId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">主题：</label>
                    <div class="controls">
                            <form:input path="ntTitle" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">内容：</label>
                    <div class="controls">
                            <form:input path="ntCotent" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">标签：</label>
                    <div class="controls">
                            <form:input path="ntTag" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">封面：</label>
                    <div class="controls">
                            <form:input path="ntPhoto" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">班级、小组：</label>
                    <div class="controls">
                            <form:input path="ntServiceType" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">上传附件：</label>
                    <div class="controls">
                            <form:input path="ntDocs" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">上传附件名称：</label>
                    <div class="controls">
                            <form:input path="ntDocsNames" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核：</label>
                    <div class="controls">
                            <form:input path="ntStatus" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">审核id：</label>
                    <div class="controls">
                            <form:input path="ntAuditId" />
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
                    <label class="control-label">机构id：</label>
                    <div class="controls">
                            <form:input path="orgId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">机构名称：</label>
                    <div class="controls">
                            <form:input path="orgName" />
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
			<shiro:hasPermission name="news:NewsNotification:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>