<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单功能包管理</title>
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
		<li class="active"><a href="javascipt:void()">订单功能包列表</a></li>
		<shiro:hasPermission name="sh:ShOrderFuncPackage:edit"><li><a href="${ctx}/sh/ShOrderFuncPackage/form" onclick="return lasySubmit(reForm,this.href);">订单功能包添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShOrderFuncPackage/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <div id="searchDiv">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </div>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>订单功能包id</th>
			<th>商户订单id</th>
			<th>功能包id</th>
			<th>功能包名称</th>
			<th>功能包描述</th>
			<th>功能包金额</th>
			<th>1基础，2增值</th>
			<th>创建时间</th>
			<shiro:hasPermission name="sh:ShOrderFuncPackage:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/sh/ShOrderFuncPackage/form?isView=1&id=${entity.ordPkgId}">${entity.ordPkgId}</a></td>
			<td>${entity.ordId}</td>
			<td>${entity.pkgId}</td>
			<td>${entity.pkgName}</td>
			<td>${entity.pkgDesc}</td>
			<td>${entity.ordPkgAmount}</td>
			<td>${entity.pkgType}</td>
			<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <shiro:hasPermission name="sh:ShOrderFuncPackage:edit"><td>
                <a href="${ctx}/sh/ShOrderFuncPackage/form?id=${entity.ordPkgId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/sh/ShOrderFuncPackage/delete?id=${entity.ordPkgId}"
                   onclick="return lasyConfirm('确认要删除该订单功能包吗？', reForm,this.href);">删除</a>
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