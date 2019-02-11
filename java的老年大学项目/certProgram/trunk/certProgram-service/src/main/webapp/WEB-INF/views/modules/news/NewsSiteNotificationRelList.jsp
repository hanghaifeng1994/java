<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>站点-通知管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">站点-通知列表</a></li>
		<shiro:hasPermission name="news:NewsSiteNotificationRel:edit"><li><a href="${ctx}/news/NewsSiteNotificationRel/form" onclick="return lasySubmit(reForm,this.href);">站点-通知添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/news/NewsSiteNotificationRel/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	${paramCover.unCoveredInputs}
        <div id="searchDiv">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </div>
	</form:form>
	<tags:message />
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>站点</th>
			<th>通知id</th>
			<th>别名</th>
			<th>0没有权限、1有权限</th>
			<th>发布状态</th>
			<th>发布时间</th>
			<th>创建站点</th>
			<th>商户id</th>
			<th>商户方案id</th>
			<shiro:hasPermission name="news:NewsSiteNotificationRel:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/news/NewsSiteNotificationRel/form?isView=1&id=${entity.siteId}">${entity.siteId}</a></td>
			<td>${entity.ntId}</td>
			<td>${entity.ntAsTitle}</td>
			<td>${entity.ntManageStatus}</td>
			<td>${entity.ntPubStatus}</td>
			<td><fmt:formatDate value="${entity.ntPubDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.ntCrtSiteId}</td>
			<td>${entity.mchtId}</td>
			<td>${entity.mchtSchmId}</td>
            <shiro:hasPermission name="news:NewsSiteNotificationRel:edit"><td>
                <a href="${ctx}/news/NewsSiteNotificationRel/form?id=${entity.siteId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/news/NewsSiteNotificationRel/delete?id=${entity.siteId}"
                   onclick="return lasyConfirm('确认要删除该站点-通知吗？', reForm,this.href);">删除</a>
            </td></shiro:hasPermission>
        </tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
    <form name="reForm" method="post">
		${paramCover.coveredInputs}
    </form>
</body>
</html>