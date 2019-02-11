<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>附件管理</title>
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
		<li class="active"><a href="${ctx}/attach/attachment/">附件列表</a></li>
		<shiro:hasPermission name="attach:attachment:edit"><li><a href="${ctx}/attach/attachment/form">附件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="attachment" action="${ctx}/attach/attachment/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>附件id：</label>
				<form:input path="id" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>附件id</th>
				<th>附件原名</th>
				<th>文件后缀</th>
				<th>附件类型</th>
				<th>创建人</th>
				<th>创建时间</th>
				<shiro:hasPermission name="attach:attachment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="attachment">
			<tr>
				<td><a href="${ctx}/attach/attachment/form?id=${attachment.id}">
					${attachment.id}
				</a></td>
				<td>
					${attachment.atName}
				</td>
				<td>
					${attachment.atSuffix}
				</td>
				<td>
					${attachment.atType}
				</td>
				<td>
					${attachment.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${attachment.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="attach:attachment:edit"><td>
    				<a href="${ctx}/attach/attachment/form?id=${attachment.id}">修改</a>
					<a href="${ctx}/attach/attachment/delete?id=${attachment.id}" onclick="return confirmx('确认要删除该附件吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>