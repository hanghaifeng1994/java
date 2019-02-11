<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户扩展信息管理</title>
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
		<li class="active"><a href="${ctx}/custext/custExt/">客户扩展信息列表</a></li>
		<shiro:hasPermission name="custext:custExt:edit"><li><a href="${ctx}/custext/custExt/form">客户扩展信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="custExt" action="${ctx}/custext/custExt/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客户id：</label>
				<form:input path="custId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>公司名称：</label>
				<form:input path="companyName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>公司法人：</label>
				<form:input path="companyLegalPerson" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>0未审核、1成功、2失败：</label>
				<form:input path="auditStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<shiro:hasPermission name="custext:custExt:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="custExt">
			<tr>
				<td><a href="${ctx}/custext/custExt/form?isView=1&id=${custExt.custId}">
					<fmt:formatDate value="${custExt.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="custext:custExt:edit"><td>
    				<a href="${ctx}/custext/custExt/form?id=${custExt.custId}">修改</a>
					<a href="${ctx}/custext/custExt/delete?id=${custExt.custId}" onclick="return confirmx('确认要删除该客户扩展信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>