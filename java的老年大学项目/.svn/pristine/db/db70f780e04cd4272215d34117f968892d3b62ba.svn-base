<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户订单管理</title>
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
	<style>
		#mchtName{
			background-color: #fff;
			border: 1px solid #ccc;
			height: 20px;
			padding: 4px 6px;
			font-size: 14px;
			line-height: 20px;
			color: #555;
			border-radius: 4px;
		}
	</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">商户订单列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShOrder/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
				<li><label>订单号：</label>
					<form:input path="ordId" htmlEscape="false" maxlength="50" class="input-medium"/>
				</li>
				<li><label>商户名称：</label>
					<form:input path="mchtName"  htmlEscape="false" maxlength="50" class="input-medium"/>
				</li>
				<li><label>方案版本：</label>
					<form:select path="schmEdtHisId" class="input-medium">
						<option value="">全部</option>
						<c:forEach items="${list}" var="li">
							<form:option value="${li.schmEdtId}">${li.schmEdtName}</form:option>
						</c:forEach>
					</form:select>
				</li>
				<li class="pay"><label>缴费状态：</label>
					<form:select path="ordPayStatus" class="input-medium">
						<option value="">全部</option>
						<form:option value="0" >未缴费</form:option>
						<form:option value="1" >已缴费</form:option>
						<form:option value="2" >欠费</form:option>
					</form:select>
				</li>
            <li class="btns">
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
            </li>

            <li class="clearfix"></li>
        </ul>

	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class=" table table-striped table-bordered table-condensed tab_css_1">
		<thead><tr>
			<th>订单号</th>
			<th>商户</th>
			<th>方案版本名称</th>
			<th>缴费状态</th>
			<th>状态</th>
			<th>方案价格</th>
			<th>增值包价格</th>
			<th>购买数量</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>总金额</th>
			<th>优惠金额</th>
			<th>实际金额</th>
			<%--<th>交费时间</th>--%>
			<c:choose>
				<c:when test="${isManager ne 'yes'}">
					<shiro:hasPermission name="sh:ShOrder:edit"><th>操作</th></shiro:hasPermission>
				</c:when>
			</c:choose>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/sh/ShOrder/form?isView=1&ordId=${entity.ordId}&&actId=${entity.actId}">${entity.ordNum}</a></td>
				<td>${entity.mchtName}</td>
				<td>${entity.schmEdtName}</td>
				<td>
					<c:choose>
						<c:when test="${entity.ordPayStatus eq '0'}">
							未缴费
						</c:when>
						<c:when test="${entity.ordPayStatus eq '1'}">
							已缴费
						</c:when>
						<c:when test="${entity.ordPayStatus eq '2'}">
							欠费
						</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${entity.ordStatus eq '0'}">
							正常
						</c:when>
						<c:when test="${entity.ordStatus eq '1'}">
							作废
						</c:when>
						<c:when test="${entity.ordStatus eq '2'}">
							系统作废
						</c:when>
					</c:choose>
				</td>
				<td>${entity.schmEdtPrice}</td>
				<td>${entity.schmEdtIncreasePrice}</td>
				<td>${entity.ordBuyNum}</td>
				<td><fmt:formatDate value="${entity.serviceStartDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${entity.serviceEndDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${entity.ordTotalAmount}</td>
				<td>${entity.ordDiscountAmount}</td>
				<td>${entity.ordRealAmount}</td>
				<%--<td><fmt:formatDate value="${entity.ordPayDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>--%>
				<c:choose>
				<c:when test="${isManager ne 'yes'}">
					<shiro:hasPermission name="sh:ShOrder:edit"><td>
						<a href="${ctx}/sh/ShOrder/toInvalid?id=${entity.ordId}" onclick="return lasySubmit(reForm,this.href);">${entity.ordStatus==0?'作废':''}</a>
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