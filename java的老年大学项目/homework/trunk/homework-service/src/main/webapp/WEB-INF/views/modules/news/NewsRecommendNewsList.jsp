<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯推荐管理</title>
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
		<li class="active"><a href="javascipt:void()">资讯推荐列表</a></li>
		<shiro:hasPermission name="news:NewsRecommendNews:edit"><li><a href="${ctx}/news/NewsRecommendNews/form" onclick="return lasySubmit(reForm,this.href);">资讯推荐添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/news/NewsRecommendNews/" method="post" class="searchForm breadcrumb form-search form-horizontal">
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
			<th>资讯id</th>
			<th>栏目id</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>排序</th>
			<th>推荐人</th>
			<th>推荐时间</th>
			<th>商户id</th>
			<th>商户方案id</th>
			<shiro:hasPermission name="news:NewsRecommendNews:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/news/NewsRecommendNews/form?isView=1&id=${entity.newsId}">${entity.newsId}</a></td>
			<td>${entity.catId}</td>
			<td><fmt:formatDate value="${entity.remStartDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${entity.remEndDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.sort}</td>
			<td>${entity.refereeUserId}</td>
			<td><fmt:formatDate value="${entity.recommendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.mchtId}</td>
			<td>${entity.mchtSchmId}</td>
            <shiro:hasPermission name="news:NewsRecommendNews:edit"><td>
                <a href="${ctx}/news/NewsRecommendNews/form?id=${entity.newsId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/news/NewsRecommendNews/delete?id=${entity.newsId}"
                   onclick="return lasyConfirm('确认要删除该资讯推荐吗？', reForm,this.href);">删除</a>
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