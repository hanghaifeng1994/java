<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户信息管理</title>
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
		<li class="active"><a href="${ctx}/custinfo/custInfo/auList">客户待审核列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="custInfo" action="${ctx}/custinfo/custInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>角色：</label>
				<form:select path="custType" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getConsList('CUST_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>姓名：</label>
				<form:input path="custName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>手机号：</label>
				<form:input path="phone" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>手机号</th>
				<th>金额</th>
				<th>冻结金额</th>
				<th>成交订单数</th>
				<shiro:hasPermission name="custinfo:custInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="custInfo">
			<tr>
				<td><a href="${ctx}/custinfo/custInfo/auForm?id=${custInfo.custId}">
					${custInfo.custName}
				</a></td>
				<td>
					${custInfo.phone}
				</td>
				<td>
					${custInfo.amount}
				</td>
				<td>
					${custInfo.freezingAmount}
				</td>
				<td>
					${custInfo.orderNum}
				</td>
				<shiro:hasPermission name="custinfo:custInfo:edit"><td>
    				<a href="${ctx}/custinfo/custInfo/auForm?id=${custInfo.custId}">查看</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>