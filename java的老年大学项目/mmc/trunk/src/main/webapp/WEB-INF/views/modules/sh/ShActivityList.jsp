<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动管理</title>
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
		<li class="active"><a href="javascipt:void()">活动列表</a></li>
		<shiro:hasPermission name="sh:ShActivity:edit"><li><a href="${ctx}/sh/ShActivity/form" onclick="return lasySubmit(reForm,this.href);">活动添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShActivity/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">

            <li class="btns">
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
            </li>

            <li class="clearfix"></li>
        </ul>

	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>活动id</th>
			<th>活动名称</th>
			<th>活动描述</th>
			<th>优惠金额</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>状态</th>
			<shiro:hasPermission name="sh:ShActivity:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/sh/ShActivity/form?isView=1&id=${entity.actId}">${entity.actId}</a></td>
			<td>${entity.actName}</td>
			<td>${entity.actDesc}</td>
			<td>${entity.actDiscountAmount}</td>
			<td><fmt:formatDate value="${entity.actStartDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${entity.actEndDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>
				<c:choose>
					<c:when test="${entity.actStatus eq 1}">
						已发布
					</c:when>
					<c:when test="${entity.actStatus eq 0 }">
						未发布
					</c:when>
					<c:otherwise>
						作废
					</c:otherwise>
				</c:choose>
			</td>
            <shiro:hasPermission name="sh:ShActivity:edit"><td>
				<c:choose>
					<c:when test="${entity.actStatus == 0}">
						<a href="${ctx}/sh/ShActivity/form?id=${entity.actId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
						<a href="${ctx}/sh/ShActivity/delete?id=${entity.actId}"
						   onclick="return lasyConfirm('确认要删除该活动吗？', reForm,this.href);">删除</a>
						<a href="${ctx}/sh/ShActivity/publish?actId=${entity.actId}&&actStatus=1"
						   onclick="return lasyConfirm('确认要发布该活动吗？', reForm,this.href);">发布</a>
						<a href="${ctx}/sh/ShActivity/publish?actId=${entity.actId}&&actStatus=2"
						   onclick="return lasyConfirm('确认要作废该活动吗？', reForm,this.href);">作废</a>
					</c:when>
					<c:when test="${entity.actStatus == 1}">
						<a href="${ctx}/sh/ShActivity/publish?actId=${entity.actId}&&actStatus=0"
						   onclick="return lasyConfirm('确认要取消发布吗？', reForm,this.href);">取消发布</a>
						<a href="${ctx}/sh/ShActivity/publish?actId=${entity.actId}&&actStatus=2"
						   onclick="return lasyConfirm('确认要作废该活动吗？', reForm,this.href);">作废</a>
					</c:when>
					<c:when test="${entity.actStatus==2}">
						<a href="${ctx}/sh/ShActivity/publish?actId=${entity.actId}&&actStatus=0"
						   onclick="return lasyConfirm('确认要取消作废活动吗？', reForm,this.href);">取消作废</a>
					</c:when>
				</c:choose>
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