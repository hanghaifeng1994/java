<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>功能包管理</title>
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

        /*function addPk(url, name){
            top.$.jBox.open("iframe:"+url, name,810,$(top.document).height()-140,{
                buttons:{"确定":"ok",  "关闭":true},submit:function(v, h, f){
                    if (v=="ok"){
                        var pform = $(h.find("iframe")[0].contentWindow.document).find('#inputForm');
                        $('#formCon').empty();
                        $('#formCon').append(pform);
                        $('#formCon').find('form').submit();
                        return true;
                    }
                }, loaded:function(h){
                    $(".jbox-content", top.document).css("overflow-y","hidden");
                }
            });
            return false;
        };*/
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">功能包列表</a></li>
		<shiro:hasPermission name="cfg:CfgFunctionPackage:edit"><li><a href="${ctx}/cfg/CfgFunctionPackage/form" onclick="return lasySubmit(reForm,this.href);">功能包添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgFunctionPackage/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>模块：</label>
				<form:select path="mdlId" class="input-large">
					<option value="">全部</option>
					<form:options items="${mdlList}" itemLabel="mdlName" itemValue="mdlId"></form:options>
				</form:select>
			</li>
			<li><label>功能包名称：</label><form:input path="pkgName" htmlEscape="false" maxlength="50" class="input-medium"/></li>

			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<%--<shiro:hasPermission name="cfg:CfgFunctionPackage:edit">
	<p>
		<a class="btn" href="${ctx}/cfg/CfgFunctionPackage/form"
		   onclick="return addPk(this.href, '添加功能包');">添加功能包</a>
	</p></shiro:hasPermission>--%>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>功能包名称</th>
			<th>模块</th>
			<th>状态</th>
			<shiro:hasPermission name="cfg:CfgFunctionPackage:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/cfg/CfgFunctionPackage/form?isView=1&id=${entity.pkgId}" onclick="return addPk(this.href,'修改功能包');">${entity.pkgName}</a></td>
			<%--<td>${entity.pkgDesc}</td>--%>
			<td>${entity.mdlName}</td>
			<td>${fns:getConsLabel('CFG_FUNCTION_PACKAGE_STATUS', entity.pkgStatus, '未发布')}</td>
            <shiro:hasPermission name="cfg:CfgFunctionPackage:edit"><td>
                <a href="${ctx}/cfg/CfgFunctionPackage/form?id=${entity.pkgId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
				<a href="${ctx}/cfg/CfgFunctionPackage/selFuncForm?pkgId=${entity.pkgId}" onclick="return lasySubmit(reForm,this.href);">功能管理</a>
                <a href="${ctx}/cfg/CfgFunctionPackage/delete?id=${entity.pkgId}"
                   onclick="return lasyConfirm('确认要删除该功能包吗？', reForm,this.href);">删除</a>
				<a href="${ctx}/cfg/CfgFunctionPackage/pub?id=${entity.pkgId}&status=${entity.pkgStatus==1?0:1}"
				   onclick="return lasyConfirm('确认要${entity.pkgStatus==1 ? '取消':''}发布吗？',reForm,this.href);">${entity.pkgStatus==1 ? '取消发布':'发布'}</a>
            </td></shiro:hasPermission>
        </tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
    <form name="reForm" method="post">
		${paramCover.coveredInputs}
    </form>
	<%--<div id="formCon"></div>--%>
</body>
</html>