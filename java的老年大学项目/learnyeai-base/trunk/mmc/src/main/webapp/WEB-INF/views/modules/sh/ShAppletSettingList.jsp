<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序配置管理</title>
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
		<li class="active"><a href="javascipt:void()">小程序配置列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/sh/ShAppletSetting/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <div id="searchDiv">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </div>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<td>商户名称</td>
			<td>商户方案名称</td>
			<th>AppId</th>
			<th>AppSecret</th>
			<th>小程序名称</th>
			<%--<th>商户名称</th>
			<th>商户号</th>--%>
			<th>商户密钥</th>
			<%--<th>公众号appid</th>--%>
			<%--<th>公众号appsecrete</th>--%>
			<shiro:hasPermission name="sh:ShAppletSetting:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
			<td>${entity.mchtName}</td>
			<td>${entity.schmEdtName}</td>
			<td>${entity.appId}</td>
			<td>${entity.appSecret}</td>
			<td>${entity.appName}</td>
			<%--<td>${entity.publicNumAppid}</td>
			<td>${entity.publicNumAppsecrete}</td>--%>
			<td>${entity.wechatMerchantPasswod}</td>
            <shiro:hasPermission name="sh:ShAppletSetting:edit"><td>
                <a href="${ctx}/sh/ShAppletSetting/form?id=${entity.apltSetId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
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