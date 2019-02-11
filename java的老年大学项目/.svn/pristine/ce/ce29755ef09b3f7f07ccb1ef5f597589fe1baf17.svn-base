<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模块版本管理</title>
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
		<li class="active"><a href="javascipt:void()">模块版本列表</a></li>
		<shiro:hasPermission name="cfg:CfgModuleVersion:edit"><li><a href="${ctx}/cfg/CfgModuleVersion/form" onclick="return lasySubmit(reForm,this.href);">模块版本添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgModuleVersion/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>模块：</label>
				<form:select path="mdlId" class="input-medium">
					<form:options items="${mdlList}" itemLabel="mdlName" itemValue="mdlId" htmlEscape="false"/>
				</form:select>
			</li>
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
			<th>版本号</th>
			<th>版本编码</th>
			<th>版本日期</th>
			<th>创建人</th>
			<th>创建时间</th>
			<shiro:hasPermission name="cfg:CfgModuleVersion:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
			<td>${entity.mdlName}</td>
			<td>${entity.mdlVerName}</td>
			<td>${entity.mdlVerCode}</td>
			<td><fmt:formatDate value="${entity.mdlVerDate}" pattern="yyyy-MM-dd" /></td>
			<td>${entity.createBy}</td>
			<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <shiro:hasPermission name="cfg:CfgModuleVersion:edit"><td>
				<a href="${ctx}/cfg/CfgModuleVersion/form?isView=1&id=${entity.mdlVerId}">查看</a>

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