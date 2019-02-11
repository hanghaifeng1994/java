<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>站点-资讯管理</title>
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
		<li class="active"><a href="javascipt:void()">站点-资讯列表</a></li>
		<shiro:hasPermission name="news:NewsNewsSiteRel:edit"><li><a href="${ctx}/news/NewsNewsSiteRel/form" onclick="return lasySubmit(reForm,this.href);">站点-资讯添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/news/NewsNewsSiteRel/" method="post" class="searchForm breadcrumb form-search form-horizontal">
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
			<th>资讯id</th>
			<th>栏目id</th>
			<th>别名</th>
			<th>管理状态</th>
			<th>发布状态0未发布，已发布</th>
			<th>发布时间</th>
			<th>创建站点</th>
			<th>商户id</th>
			<th>商户方案id</th>
			<shiro:hasPermission name="news:NewsNewsSiteRel:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/news/NewsNewsSiteRel/form?isView=1&id=${entity.siteId}">${entity.siteId}</a></td>
			<td>${entity.newsId}</td>
			<td>${entity.catId}</td>
			<td>${entity.newsAsTitle}</td>
			<td>${entity.newsManageStatus}</td>
			<td>${entity.newsPubStatus}</td>
			<td><fmt:formatDate value="${entity.newsPubDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.newsCrtSiteId}</td>
			<td>${entity.mchtId}</td>
			<td>${entity.mchtSchmId}</td>
            <shiro:hasPermission name="news:NewsNewsSiteRel:edit"><td>
                <a href="${ctx}/news/NewsNewsSiteRel/form?id=${entity.siteId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/news/NewsNewsSiteRel/delete?id=${entity.siteId}"
                   onclick="return lasyConfirm('确认要删除该站点-资讯吗？', reForm,this.href);">删除</a>
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