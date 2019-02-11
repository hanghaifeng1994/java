<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资讯管理</title>
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
		<li class="active"><a href="javascipt:void()">资讯列表</a></li>
		<shiro:hasPermission name="news:News:edit"><li><a href="${ctx}/news/News/form" onclick="return lasySubmit(reForm,this.href);">资讯添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/news/News/" method="post" class="searchForm breadcrumb form-search form-horizontal">
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
			<th>ID</th>
			<th>标题</th>
			<th>标签</th>
			<th>内容</th>
			<th>来源</th>
			<th>封面</th>
			<th>作者</th>
			<th>栏目</th>
			<th>附件ids</th>
			<th>附件名称</th>
			<th>0未置顶、1已置顶</th>
			<th>状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核</th>
			<th>0未发布、1已发布</th>
			<th>发布时间</th>
			<th>审核id</th>
			<th>创建人</th>
			<th>创建时间</th>
			<th>更新人</th>
			<th>更新时间</th>
			<th>删除标记</th>
			<th>站点</th>
			<th>商户id</th>
			<th>商户方案id</th>
			<shiro:hasPermission name="news:News:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/news/News/form?isView=1&id=${entity.newsId}">${entity.newsId}</a></td>
			<td>${entity.title}</td>
			<td>${entity.tags}</td>
			<td>${entity.content}</td>
			<td>${entity.newsSource}</td>
			<td>${entity.photo}</td>
			<td>${entity.author}</td>
			<td>${entity.catId}</td>
			<td>${entity.fileIds}</td>
			<td>${entity.fileIdNames}</td>
			<td>${entity.topStatus}</td>
			<td>${entity.status}</td>
			<td>${entity.pubStatus}</td>
			<td><fmt:formatDate value="${entity.pubDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.auditId}</td>
			<td>${entity.createBy}</td>
			<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.updateBy}</td>
			<td><fmt:formatDate value="${entity.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.delFlag}</td>
			<td>${entity.siteId}</td>
			<td>${entity.mchtId}</td>
			<td>${entity.mchtSchmId}</td>
            <shiro:hasPermission name="news:News:edit"><td>
                <a href="${ctx}/news/News/form?id=${entity.newsId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/news/News/delete?id=${entity.newsId}"
                   onclick="return lasyConfirm('确认要删除该资讯吗？', reForm,this.href);">删除</a>
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