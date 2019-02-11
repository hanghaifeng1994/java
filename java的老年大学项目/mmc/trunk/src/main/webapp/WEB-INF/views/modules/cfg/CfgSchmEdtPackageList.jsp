<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本功能包管理</title>
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
		<li class="active"><a href="javascipt:void()">方案版本功能包列表</a></li>
		<shiro:hasPermission name="cfg:CfgSchmEdtPackage:edit"><li><a href="${ctx}/cfg/CfgSchmEdtPackage/form" onclick="return lasySubmit(reForm,this.href);">方案版本功能包添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchmEdtPackage/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <div id="searchDiv">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </div>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>方案版本功能包id</th>
			<th>功能包id</th>
			<th>方案版本id</th>
			<th>0禁用、1启用</th>
			<th>1基础、2增值</th>
			<th>年价格</th>
			<th>月价格</th>
			<th>模块id</th>
			<th>创建人</th>
			<th>创建时间</th>
			<th>更新人</th>
			<th>更新时间</th>
			<shiro:hasPermission name="cfg:CfgSchmEdtPackage:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/cfg/CfgSchmEdtPackage/form?isView=1&id=${entity.edtPkgId}">${entity.edtPkgId}</a></td>
			<td>${entity.pkgId}</td>
			<td>${entity.schmEdtId}</td>
			<td>${entity.edtPkgStatus}</td>
			<td>${entity.edtPkgType}</td>
			<td>${entity.edtPkgYearPrice}</td>
			<td>${entity.edtPkgMonthPrice}</td>
			<td>${entity.mdlId}</td>
			<td>${entity.createBy}</td>
			<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${entity.updateBy}</td>
			<td><fmt:formatDate value="${entity.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <shiro:hasPermission name="cfg:CfgSchmEdtPackage:edit"><td>
                <a href="${ctx}/cfg/CfgSchmEdtPackage/form?id=${entity.edtPkgId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgSchmEdtPackage/delete?id=${entity.edtPkgId}"
                   onclick="return lasyConfirm('确认要删除该方案版本功能包吗？', reForm,this.href);">删除</a>
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