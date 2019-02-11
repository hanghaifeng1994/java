<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户方案管理</title>
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
		<li class="active"><a href="javascipt:void()">商户方案列表</a></li>
		<shiro:hasPermission name="sh:ShMerchantScheme:edit"><li><a href="${ctx}/sh/ShMerchantScheme/form" onclick="return lasySubmit(reForm,this.href);">商户方案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShMerchantScheme/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
				<li><span><label>商户名称：</label></span>
					<form:input path="mchtName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
            <li class="btns">
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
            </li>

            <li class="clearfix"></li>
        </ul>

	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>方案名称</th>
			<th>商户</th>
			<th>到期时间</th>
			<th>状态</th>
			<th>缴费状态</th>
			<th>免费升级</th>
			<shiro:hasPermission name="sh:ShMerchantScheme:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/sh/ShMerchantScheme/view?mchtSchmId=${entity.mchtSchmId}&&ordId=${entity.ordId}">${entity.schmEdtName}</a></td>
				<td>${entity.mchtName}</td>
				<td><fmt:formatDate value="${entity.mchtSchmExpireDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>
				${entity.mchtSchmStatus eq  1 ?"启用":"禁用"}
			</td>
			<td>
				<c:choose>
					<c:when test="${entity.mchtSchmPayStatus eq '0'}">
						未付费
					</c:when>
					<c:when test="${entity.mchtSchmPayStatus eq '1'}">
						已付费
					</c:when>
					<c:when test="${entity.mchtSchmPayStatus eq '2'}">
						欠费
					</c:when>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${entity.mchtUpgradeStatus eq '0'}">
						不升级
					</c:when>
					<c:when test="${entity.mchtUpgradeStatus eq '1'}">
						免费升级
					</c:when>
				</c:choose>
			</td>
            <shiro:hasPermission name="sh:ShMerchantScheme:edit"><td>
			<c:choose>
				<c:when test="${entity.mchtSchmStatus eq 1 }">
					<a href="${ctx}/sh/ShMerchantScheme/startOrForbiddenUse?mchtSchmId=${entity.mchtSchmId}&&mchtSchmStatus=${entity.mchtSchmStatus}" onclick="return lasyConfirm('确认要禁用该商户方案吗？',reForm,this.href);">禁用</a>
				</c:when>
				<c:otherwise>
					<a href="${ctx}/sh/ShMerchantScheme/startOrForbiddenUse?mchtSchmId=${entity.mchtSchmId}&&mchtSchmStatus=${entity.mchtSchmStatus}" onclick="return lasyConfirm('确认要启用该商户方案吗？',reForm,this.href);">启用</a>
				</c:otherwise>
			</c:choose>
				<a href="${ctx}/sh/ShMerchantScheme/form?mchtSchmId=${entity.mchtSchmId}&&schmEdtName=${entity.schmEdtName}&&mchtName=${entity.mchtName}&&schmId=${entity.schmId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/sh/ShMerchantScheme/delete?mchtSchmId=${entity.mchtSchmId}"
                   onclick="return lasyConfirm('确认要删除该商户方案吗？', reForm,this.href);">删除</a>
				<a href="${ctx}/sh/ShMerchantScheme/toPayment?mchtSchmId=${entity.mchtSchmId}&&schmEdtName=${entity.schmEdtName}&&mchtName=${entity.mchtName}&&schmId=${entity.schmId}" onclick="return lasySubmit(reForm,this.href);">缴费</a>
				<a href="${ctx}/sh/ShAppletSetting/configSmallOrdList?mchtSchmId=${entity.mchtSchmId}" onclick="return lasySubmit(reForm,this.href);">商户小程序配置</a>
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