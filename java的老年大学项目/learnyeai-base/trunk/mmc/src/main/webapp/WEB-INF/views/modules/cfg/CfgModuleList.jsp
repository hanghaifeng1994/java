<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模块管理</title>
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
		<li class="active"><a href="javascipt:void()">模块列表</a></li>
		<shiro:hasPermission name="cfg:CfgModule:edit"><li><a href="${ctx}/cfg/CfgModule/form" onclick="return lasySubmit(reForm,this.href);">模块添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgModule/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">

			<li><label>模块名：</label><form:input path="mdlName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>模块名称</th>
			<th>模块编码</th>
			<th>上下文</th>
			<th>员工扩展表</th>
			<th>用户扩展表</th>
			<shiro:hasPermission name="cfg:CfgModule:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
				<td><a href="${ctx}/cfg/CfgModule/form?isView=1&id=${entity.mdlId}">${entity.mdlName}</a></td>
			<td>${entity.mdlCode}</td>
				<td>${entity.mdlServerContext}</td>
				<td>${entity.mdlStaffTableName}</td>
				<td>${entity.mdlUserTableName}</td>
			<%--<td>${fns:getConsLabel("ENABLE_DISABLE", entity.mdlStatus, "")}</td>--%>
            <shiro:hasPermission name="cfg:CfgModule:edit"><td>
				<%--<a href="${ctx}/cfg/CfgModule/enable?id=${entity.mdlId}&enabled=${entity.mdlStatus=='1'? '0':'1'}"
				   onclick="return lasySubmit(reForm,this.href);">${entity.mdlStatus == '1'? '禁用' : '启用'}</a>--%>
					<a href="${ctx}/cfg/CfgFunction/?mdlId=${entity.mdlId}&funcType=1" onclick="return lasySubmit(reForm,this.href);">功能管理</a>
                <a href="${ctx}/cfg/CfgModule/form?id=${entity.mdlId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgModule/delete?id=${entity.mdlId}"
                   onclick="return lasyConfirm('确认要删除该模块吗？', reForm,this.href);">删除</a>
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