<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>投诉原因管理</title>
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
		<li class="active"><a href="${ctx}/ordercomplaintcause/orderComplaintCause/">投诉原因列表</a></li>
		<shiro:hasPermission name="ordercomplaintcause:orderComplaintCause:edit"><li><a href="${ctx}/ordercomplaintcause/orderComplaintCause/form">投诉原因添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="orderComplaintCause" action="${ctx}/ordercomplaintcause/orderComplaintCause/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类别</label>
				<form:select path="ccType" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getConsList('CC_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>投诉编码：</label>
				<form:input path="ccCode" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编码</th>
				<th>投诉类型</th>
				<th>投诉原因</th>
				<shiro:hasPermission name="ordercomplaintcause:orderComplaintCause:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="orderComplaintCause">
			<tr>
				<td>
					<a href="${ctx}/ordercomplaintcause/orderComplaintCause/form?isView=1&id=${orderComplaintCause.ccId}">
							${orderComplaintCause.ccCode}
					</a>
				</td>
				<td>
						${fns:getConsLabel("CC_TYPE", orderComplaintCause.ccType, "")}
				</td>
				<td>
					<c:choose>
						<c:when test="${fn:length(orderComplaintCause.ccDesc) > 10}">
							<c:out value="${fn:substring(orderComplaintCause.ccDesc, 0, 10)}......" />
						</c:when>
						<c:otherwise>
							<c:out value="${orderComplaintCause.ccDesc}" />
						</c:otherwise>
					</c:choose>
				</td>
				<shiro:hasPermission name="ordercomplaintcause:orderComplaintCause:edit"><td>
    				<a href="${ctx}/ordercomplaintcause/orderComplaintCause/form?id=${orderComplaintCause.ccId}">修改</a>
					<a href="${ctx}/ordercomplaintcause/orderComplaintCause/delete?id=${orderComplaintCause.ccId}" onclick="return confirmx('确认要删除该投诉原因吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>