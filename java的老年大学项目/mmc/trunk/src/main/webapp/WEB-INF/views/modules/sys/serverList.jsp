<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
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
		<li class="active"><a href="${ctx}/sys/dict/toServerList">服务配置列表</a></li>
		<shiro:hasPermission name="sys:dict:edit"><li><a href="${ctx}/sys/dict/toServerForm?sort=10">服务配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dict" action="${ctx}/sys/dict/toServerList" method="post" class="searchForm breadcrumb form-search form-horizontal">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div class="container-fluid">
			<div class="row">
                <div class="control-group span3">
                    <label class="control-label">配置项：</label>
                    <div class="controls">
                        <form:input path="label" htmlEscape="false" maxlength="100"/>
                    </div>
                </div>
				<div class="control-group span3">
					<label class="control-label">描述：</label>
					<div class="controls">
						<form:input path="description" htmlEscape="false" maxlength="50"/>
					</div>
				</div>
			</div>
		</div>
		<div id="searchDiv" >
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		</div>
		<%--&nbsp;&nbsp;<label>描述 ：</label><form:input path="description" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>--%>
	</form:form>
	<tags:message />
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>配置项</th><th>配置内容</th><th>描述</th><th>排序</th><shiro:hasPermission name="sys:dict:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="dict">
			<tr>
				<td>${dict.label}</td>
				<td><a href="${ctx}/sys/dict/toServerForm?isView=1&id=${dict.id}">${dict.value}</a></td>
				<td>${dict.description}</td>
				<td>${dict.sort}</td>
				<shiro:hasPermission name="sys:dict:edit"><td>
    				<a href="${ctx}/sys/dict/toServerForm?id=${dict.id}">修改</a>
					<a href="${ctx}/sys/dict/deleteServer?id=${dict.id}" onclick="return confirmx('确认要删除该服务配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>