<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序管理</title>
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
		<li class="active"><a href="javascipt:void()">小程序列表</a></li>
		<shiro:hasPermission name="cfg:CfgApplet:edit"><li><a href="${ctx}/cfg/CfgApplet/form" onclick="return lasySubmit(reForm,this.href);">小程序添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgApplet/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><span><label>行业方案：</label></span>
				<wey:schemeSelect nameValue="schmId" idValue="schmId" val="${entry.schmId}" isAll="1" cssClass="input-medium"></wey:schemeSelect>
			</li>
			<li><span><label>小程序appid：</label></span>
				<form:input path="apltAppId"/>
			</li>
			<li class="clearfix"></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>小程序名称</th>
			<th>行业方案名称</th>
			<th>小程序appid</th>
			<th>小程序secret</th>
			<th>模块编码</th>
			<shiro:hasPermission name="cfg:CfgApplet:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/cfg/CfgApplet/form?isView=1&id=${entity.apltId}">${entity.apltName}</a></td>
				<td>${entity.schmName}</td>
				<td>${entity.apltAppId}</td>
			<td>${entity.apltAppSecret}</td>
			<td>${entity.apltMdlCode}</td>
            <shiro:hasPermission name="cfg:CfgApplet:edit"><td>
                <a href="${ctx}/cfg/CfgApplet/form?id=${entity.apltId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
				<a href="${ctx}/cfg/CfgApplet/form?id=${entity.apltId}" onclick="return lasySubmit(reForm,this.href);">管理商户小程序</a>
                <a href="${ctx}/cfg/CfgApplet/delete?id=${entity.apltId}"
                   onclick="return lasyConfirm('确认要删除该小程序吗？', reForm,this.href);">删除</a>
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