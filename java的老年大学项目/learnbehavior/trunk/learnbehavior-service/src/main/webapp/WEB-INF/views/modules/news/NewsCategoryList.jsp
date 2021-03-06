<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯栏目管理</title>
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
		<li class="active"><a href="javascipt:void()">资讯栏目列表</a></li>
		<shiro:hasPermission name="news:NewsCategory:edit"><li><a href="${ctx}/news/NewsCategory/form" onclick="return lasySubmit(reForm,this.href);">资讯栏目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/news/NewsCategory/" method="post" class="searchForm breadcrumb form-search form-horizontal">
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
			<th>id</th>
			<th>名称</th>
			<th>封面</th>
			<th>创建人</th>
			<th>创建时间</th>
			<th>更新人</th>
			<th>更新时间</th>
			<th>删除标记</th>
			<th>站点</th>
			<th>商户id</th>
			<th>商户方案id</th>
			<shiro:hasPermission name="news:NewsCategory:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/news/NewsCategory/form?isView=1&id=${entity.catId}">${entity.catId}</a></td>
			<td>${entity.catName}</td>
			<td>${entity.catPhoto}</td>
			<td>${entity.createBy}</td>
			<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.updateBy}</td>
			<td><fmt:formatDate value="${entity.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.delFlag}</td>
			<td>${entity.siteId}</td>
			<td>${entity.mchtId}</td>
			<td>${entity.mchtSchmId}</td>
            <shiro:hasPermission name="news:NewsCategory:edit"><td>
                <a href="${ctx}/news/NewsCategory/form?id=${entity.catId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/news/NewsCategory/delete?id=${entity.catId}"
                   onclick="return lasyConfirm('确认要删除该资讯栏目吗？', reForm,this.href);">删除</a>
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