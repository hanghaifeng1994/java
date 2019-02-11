<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>行业方案管理</title>
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
		<li class="active"><a href="javascipt:void()">行业方案列表</a></li>
		<shiro:hasPermission name="cfg:CfgScheme:edit"><li><a href="${ctx}/cfg/CfgScheme/form" onclick="return lasySubmit(reForm,this.href);">行业方案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgScheme/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><span><label>方案名称：</label></span>
				<form:input path="schmName" htmlEscape="false" maxlength="50" class="input-medium"/></li>

			<li class="clearfix"></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>行业方案名称</th>
			<th>行业</th>
			<th>状态</th>
			<shiro:hasPermission name="cfg:CfgScheme:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
			<td><a href="${ctx}/cfg/CfgScheme/form?isView=1&id=${entity.schmId}">${entity.schmName}</a></td>
			<td>${fns:getDictLabel( entity.schmIndustry,"Industry_type", "")}</td>
			<td>${fns:getConsLabel("CFG_SCHEME_STATUS", entity.schmStatus, "")}</td>
            <shiro:hasPermission name="cfg:CfgScheme:edit"><td>
				<a href="${ctx}/cfg/CfgScheme/enable?schmId=${entity.schmId}&schmStatus=${entity.schmStatus==1 ? '0':'1'}"
				   onclick="return lasySubmit(reForm,this.href);">${entity.schmStatus==1 ? '取消发布':'发布'}</a>
				<a href="${ctx}/cfg/CfgScheme/assignMdlForm?id=${entity.schmId}">配置模块</a>
				<%--<a href="${ctx}/cfg/CfgSchemeEdition/?schmId=${entity.schmId}">管理版本</a>--%>
                <a href="${ctx}/cfg/CfgScheme/form?id=${entity.schmId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgScheme/delete?id=${entity.schmId}"
                   onclick="return lasyConfirm('确认要删除该行业方案吗？', reForm,this.href);">删除</a>
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