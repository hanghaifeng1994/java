<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯推荐管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/news/NewsRecommendNews/" onclick="return lasySubmit(bakForm,this.href);">资讯推荐列表</a></li>
		<li class="active"><a href="javascript:void()">
		资讯推荐<tags:autoFormLabel editPermission="news:NewsRecommendNews:edit" id="${entry.newsId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/news/NewsRecommendNews/save" method="post" class="form-search form-horizontal">
        <tags:message />
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
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
                    <label class="control-label">开始时间：</label>
                    <div class="controls">
                            <input id="remStartDate" name="remStartDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.remStartDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">结束时间：</label>
                    <div class="controls">
                            <input id="remEndDate" name="remEndDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.remEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">排序：</label>
                    <div class="controls">
                            <form:input path="sort" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">推荐人：</label>
                    <div class="controls">
                            <form:input path="refereeUserId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">推荐时间：</label>
                    <div class="controls">
                            <input id="recommendDate" name="recommendDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.recommendDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
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
			<shiro:hasPermission name="news:NewsRecommendNews:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>