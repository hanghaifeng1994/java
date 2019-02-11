<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户管理</title>
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
		<li class="active"><a href="javascipt:void()">商户列表</a></li>
		<shiro:hasPermission name="sh:ShMerchant:edit"><li><a href="${ctx}/sh/ShMerchant/form" onclick="return lasySubmit(reForm,this.href);">商户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShMerchant/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <div id="searchDiv">
			<ul class="ul-form">
				<li><span><label>商户名称：</label></span>
					<form:input path="mchtName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			</ul>
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </div>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>商户名称</th>
			<th>商户shortname</th>
			<th>联系人</th>
			<th>手机号</th>
			<th>座机</th>
			<th>状态</th>
			<th>地址</th>
			<th>行业</th>
			<%--<th>客户经理名称</th>--%>
			<c:choose>
				<c:when test="${isManager ne 'yes'}">
					<shiro:hasPermission name="sh:ShMerchant:edit"><th>操作</th></shiro:hasPermission>
				</c:when>
			</c:choose>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
			<td><a href="${ctx}/sh/ShMerchant/form?isView=1&id=${entity.mchtId}">${entity.mchtName}</a></td>
			<td>${entity.mchtShortname}</td>
			<td>${entity.mchtLinkman}</td>
			<td>${entity.mchtPhone}</td>
			<td>${entity.mchtTelephone}</td>
			<td>${fns:getConsLabel("ENABLE_DISABLE", entity.mchtStatus, "")}</td>
			<td>${entity.mchtAdress}</td>
			<td>${entity.mchtIndustry}</td>
			<%--<td>${entity.clientManagerName}</td>--%>
			<%--<td>${entity.mchtAddType}</td>--%>
				<c:choose>
				<c:when test="${isManager ne 'yes'}">
            <shiro:hasPermission name="sh:ShMerchant:edit"><td>
                <c:choose>
					<c:when test="${entity.mchtStatus eq '1'}">
						<a href="${ctx}/sh/ShMerchant/startOrForbiddenUse?mchtId=${entity.mchtId}&&mchtStatus=${entity.mchtStatus}" onclick="return lasyConfirm('确认要禁用该商户吗？',reForm,this.href);">禁用</a>
					</c:when>
					<c:when test="${entity.mchtStatus eq '0'}">
						<a href="${ctx}/sh/ShMerchant/startOrForbiddenUse?mchtId=${entity.mchtId}&&mchtStatus=${entity.mchtStatus}" onclick="return lasyConfirm('确认要启用该商户吗？',reForm,this.href);">启用</a>
						<a href="${ctx}/sh/ShMerchant/form?id=${entity.mchtId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
						<a href="${ctx}/sh/ShMerchant/delete?id=${entity.mchtId}"
						   onclick="return lasyConfirm('确认要删除该商户吗？', reForm,this.href);">删除</a>
					</c:when>
				</c:choose>
				<a href="${ctx}/sh/ShMerchant/toManager?mchtId=${entity.mchtId}" onclick="return lasySubmit(reForm,this.href);">指定客户经理</a>
			</td></shiro:hasPermission>
				</c:when>
				</c:choose>
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