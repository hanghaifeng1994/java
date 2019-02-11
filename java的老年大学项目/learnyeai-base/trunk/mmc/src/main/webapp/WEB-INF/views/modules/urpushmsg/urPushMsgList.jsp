<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推送消息管理</title>
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
		<li class="active"><a href="${ctx}/urpushmsg/urPushMsg/">推送消息列表</a></li>
		<shiro:hasPermission name="urpushmsg:urPushMsg:edit"><li><a href="${ctx}/urpushmsg/urPushMsg/form">推送消息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="urPushMsg" action="${ctx}/urpushmsg/urPushMsg/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>消息来源：</label>
				<form:select path="pmComType" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getConsList('MSG_COM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>推送类型：</label>
				<form:select path="pmPushType" class="input-medium">
					<form:option value="" label="所有"/>
					<form:options items="${fns:getConsList('PM_PUSH_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>类型：</label>
				<form:select path="pmType" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getConsList('PM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>状态：</label>
				<form:select path="pmStatus" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getConsList('PM_STATUS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<%--<th>id</th>--%>
				<th>消息来源</th>
				<th>平台</th>
				<th>消息内容</th>
				<th>业务类型</th>
				<th>对像id</th>
				<th>参数</th>
				<th>推送时间</th>
				<th>推送类型</th>
				<th>接收消息人</th>
				<th>发送人</th>
				<th>主题</th>
				<th>类型</th>
				<th>状态</th>
				<shiro:hasPermission name="urpushmsg:urPushMsg:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="urPushMsg">
			<tr>
				<%--<td><a href="${ctx}/urpushmsg/urPushMsg/form?isView=1&id=${urPushMsg.pmId}">${urPushMsg.pmId}</a></td>--%>
				<td><a href="${ctx}/urpushmsg/urPushMsg/form?isView=1&id=${urPushMsg.pmId}">${fns:getConsLabel("MSG_COM_TYPE", urPushMsg.pmComType, "")}</a></td>
				<td>${urPushMsg.ptId}</td>
				<td>${urPushMsg.pmContent}</td>
				<td>${fns:getConsLabel("PM_SERVICE_TYPE", urPushMsg.pmServiceType, "")}</td>
				<td>${urPushMsg.pmRelObjId}</td>
				<td>${urPushMsg.pmParams}</td>
				<td><fmt:formatDate value="${urPushMsg.pmPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${fns:getConsLabel("PM_PUSH_TYPE", urPushMsg.pmPushType, "")}</td>
				<td>${urPushMsg.pmRecieveCustName}</td>
				<td>${urPushMsg.pmSendCustName}</td>
				<td>${urPushMsg.pmTheme}</td>
				<td>${fns:getConsLabel("PM_TYPE", urPushMsg.pmType, "")}</td>
				<td>${fns:getConsLabel("PM_STATUS", urPushMsg.pmStatus, "")}</td>
				<shiro:hasPermission name="urpushmsg:urPushMsg:edit"><td>
					<c:if test="${'0'.equals(urPushMsg.pmStatus)}">
						<a href="${ctx}/urpushmsg/urPushMsg/form?id=${urPushMsg.pmId}">修改</a>
					</c:if>
					<a href="${ctx}/urpushmsg/urPushMsg/delete?id=${urPushMsg.pmId}" onclick="return confirmx('确认要删除该推送消息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>