<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>功能管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgModule/" onclick="return lasySubmit(bakForm,this.href);">模块列表</a></li>
		<li class="${entity.funcType==1? 'active':''}"><a href="${ctx}/cfg/CfgFunction/?mdlId=${entity.mdlId}&funcType=1">${mdlName}-后管列表</a></li>
		<li class="${entity.funcType==2? 'active':''}"><a href="${ctx}/cfg/CfgFunction/?mdlId=${entity.mdlId}&funcType=2">${mdlName}-前台列表</a></li>
	</ul>
	<sys:message content="${message}"/>
	<form id="listForm" method="post">
		<shiro:hasPermission name="cfg:CfgFunction:edit">
		<p>
			<a class="btn" href="${ctx}/cfg/CfgFunction/form?mdlId=${entity.mdlId}&funcType=${entity.funcType}"
			   onclick="return lasySubmit(reForm,this.href);">添加${entity.funcType==1? '后管':'前台'}功能</a>
		</p></shiro:hasPermission>
		${paramCover.coveredInputs}
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr><th>名称</th><th>类型</th><th>链接</th><th style="text-align:center;">排序</th><th>权限标识</th><shiro:hasPermission name="cfg:CfgFunction:edit"><th>操作</th></shiro:hasPermission></tr></thead>
			<tbody><c:forEach items="${list}" var="func">
				<tr id="${func.funcId}" pId="${func.parentId ne '1'?func.parentId:'0'}">
					<td nowrap><a href="${ctx}/cfg/CfgFunction/form?funcId=${func.funcId}&mdlId=${entity.mdlId}&funcType=${entity.funcType}" onclick="return lasySubmit(reForm,this.href);">${func.funcName}</a></td>
					<td>${fns:getConsLabel('CFG_FUNCTION_MNG_TYPE', func.funcMngType, '接口')}</td>
					<td title="${func.funcUrl}">${fns:abbr(func.funcUrl,30)}</td>
					<td style="text-align:center;">
						<shiro:hasPermission name="cfg:CfgFunction:edit">
							<input type="hidden" name="ids" value="${func.funcId}"/>
							<input name="sorts" type="text" value="${func.sort}" style="width:50px;margin:0;padding:0;text-align:center;">
						</shiro:hasPermission><shiro:lacksPermission name="cfg:CfgFunction:edit">
							${func.sort}
						</shiro:lacksPermission>
					</td>
					<td title="${func.funcPermission}">${fns:abbr(func.funcPermission,30)}</td>
					<shiro:hasPermission name="cfg:CfgFunction:edit"><td nowrap>
						<a href="${ctx}/cfg/CfgFunction/form?id=${func.funcId}&&mdlId=${entity.mdlId}&funcType=${entity.funcType}" onclick="return lasySubmit(reForm,this.href);">修改</a>
						<a href="${ctx}/cfg/CfgFunction/delete?id=${func.funcId}" onclick="return lasyConfirm('要删除该菜单及所有子菜单项吗？',reForm, this.href)">删除</a>
						<a href="${ctx}/cfg/CfgFunction/form?parentId=${func.funcId}&mdlId=${entity.mdlId}&funcType=${entity.funcType}" onclick="return lasySubmit(reForm,this.href);">添加下级菜单</a>
					</td></shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
		<shiro:hasPermission name="cfg:CfgFunction:edit"><div class="form-actions pagination-left">
			<a  class="btn btn-primary" href="${ctx}/cfg/CfgFunction/updateSort" onclick="return lasySubmit(listForm,this.href);;">保存排序</a>
		</div></shiro:hasPermission>
	 </form>
	<form name="reForm" method="post">
		${paramCover.coveredInputs}
	</form>
</body>
</html>