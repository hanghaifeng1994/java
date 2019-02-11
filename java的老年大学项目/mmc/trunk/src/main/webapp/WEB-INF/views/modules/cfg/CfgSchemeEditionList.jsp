<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本管理</title>
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
        function pubVer(id, status) {
            if(status == '1'){
                return lasySubmit(reForm,'${ctx}/cfg/CfgSchemeEdition/unPub?id=' + id);
			}

			// 发布版本
            return lasySubmit(reForm,'${ctx}/cfg/CfgSchemeEdition/pubForm?id=' + id);
        }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
	<li class="active"><a href="javascipt:void()">方案版本列表</a></li>
	<shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><li><a href="${ctx}/cfg/CfgSchemeEdition/form" onclick="return lasySubmit(reForm,this.href);">方案版本添加</a></li></shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEdition/" method="post" class="searchForm breadcrumb form-search form-horizontal">
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
	<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	<ul class="ul-form">

		<li><span><label>方案版本名称：</label></span>
			<form:input path="schmEdtName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
		<li><span><label>行业方案：</label></span>
			<form:select path="schmId" cssClass="input-medium">
				<form:option value="">全部</form:option>
				<form:options itemValue="schmId" itemLabel="schmName" items="${schemeList}" ></form:options>
			</form:select>
		</li>
		<li><span><label>可用状态：</label></span>
			<form:select path="schmEnableStatus" cssClass="input-medium">
				<form:option value="">全部</form:option>
				<form:options itemValue="value" itemLabel="label" items="${fns:getConsList('ENABLE_DISABLE')}" ></form:options>
			</form:select>
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
		<th>方案版本</th>
		<th>方案</th>
		<%--<th>图片</th>--%>
		<th>发布状态</th>
		<th>可用状态</th>
		<th>版本状态</th>
		<th>已上线版本</th>
		<shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><th>操作</th></shiro:hasPermission></tr></thead>
	<tbody>
	<c:forEach items="${page.list}" var="entity">
		<tr>
			<td><a href="${ctx}/cfg/CfgSchemeEdition/form?isView=1&id=${entity.schmEdtId}">${entity.schmEdtName}</a></td>
			<td>
				<c:forEach items="${schemeList}" var="schm">
					<c:if test="${entity.schmId == schm.schmId}">
						${schm.schmName}
					</c:if>
				</c:forEach>
			</td>
			<td>${fns:getConsLabel("CFG_SCHEME_EDITION_STATUS", entity.schmEdtStatus, '未发布')}
			</td>
			<td>${fns:getConsLabel("ENABLE_DISABLE", entity.schmEnableStatus, '禁用')}
			</td>
			<td>
			<%--${fns:getConsLabel("CFG_SCHEME_EDITION_MOD_STATUS", entity.schmEdtModStatus, '修改信息')}--%>
				<%--${entity.schmEdtModStatus == '1' || entity.schmEdtModStatus=='2' || entity.schmEdtModStatus=='3'? '已修改':'未修改'}--%>
				<c:if test="${entity.schmEnableStatus==1}">
				<c:if test="${entity.schmEdtModStatus == '1' || entity.schmEdtModStatus=='2' || entity.schmEdtModStatus=='3'}">
					<a href="${ctx}/cfg/CfgSchemeEditionHis/form?schmEdtId=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">上线新版本</a>
				</c:if>
				<c:if test="${empty entity.schmEdtModStatus || entity.schmEdtModStatus=='0'}">
					未修改
				</c:if>
				</c:if>
			</td>
			<td>
				<a href="${ctx}/cfg/CfgSchemeEditionHis/view?isView=1&schmEdtHisId=${entity.schmEdtHisId}" onclick="return lasySubmit(reForm,this.href);">线上版本</a>
				<%--<a href="${ctx}/cfg/CfgSchemeEditionHis/?schmEdtId=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">历史列表</a>--%>
			</td>
			<shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><td>

				<c:if test="${entity.schmEnableStatus==1}">
				<a href="${ctx}/cfg/CfgSchemeEdition/form?id=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
				<a href="${ctx}/cfg/CfgSchemeEdition/assignPkgFrom?id=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">配置功能包</a>
					<a href="${ctx}/cfg/CfgSchemeEdition/selApletForm?schmEdtId=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">选择小程序</a>
					<c:if test="${entity.schmEdtStatus==0}">
				<a href="${ctx}/cfg/CfgSchemeEdition/delete?id=${entity.schmEdtId}"
				   onclick="return lasyConfirm('确认要删除该方案版本吗？', reForm,this.href);">删除</a>
					</c:if>
				<c:if test="${not empty entity.schmEdtHisId}">
				<a href="${ctx}/cfg/CfgSchemeEdition/pub?id=${entity.schmEdtId}&status=${entity.schmEdtStatus==1?0:1}"
				   onclick="return lasyConfirm('确认要${entity.schmEdtStatus==1 ? '取消':''}发布吗？',reForm,this.href);">${entity.schmEdtStatus==1 ? '取消发布':'发布'}</a>
					</c:if>
				</c:if>

				<c:if test="${entity.schmEdtStatus==0}">
					<a href="${ctx}/cfg/CfgSchemeEdition/enable?id=${entity.schmEdtId}&status=${entity.schmEnableStatus==1?0:1}"
					   onclick="return lasyConfirm('确认要${entity.schmEnableStatus==1 ? '禁用':'启用'}吗？', reForm,this.href);">${entity.schmEnableStatus==1 ? '禁用':'启用'}</a>
				</c:if>
				<a  href="${ctx}/cfg/CfgSchemeEditionPrice/priceManger?schmEdtId=${entity.schmEdtId}" onclick="return lasySubmit(reForm,this.href);">价格管理</a>
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