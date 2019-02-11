<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序代码管理</title>
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
	    //查看体验版二维码
	    function  getExpressCode(appId){
            $.post('localhost:8080/mmp/api/sh/getExpressCode.do', {
                APP_ID: appId,
				PATH  : ""
            }, function(data) {
               window.open(data.URL);
            });
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">小程序代码管理</a></li>
		<%--<shiro:hasPermission name="sh:ShAppletSetting:edit"><li><a href="${ctx}/sh/ShAppletSetting/form" onclick="return lasySubmit(reForm,this.href);">小程序配置添加</a></li></shiro:hasPermission>--%>
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
			<th>小程序名称</th>
			<th>商户名称</th>
			<th>方案版本</th>
			<th>当前版本</th>
			<th>最新版本</th>
			<th>自动上线</th>
			<th>代码上传</th>
			<th>代码审核</th>
			<th>代码发布</th>
			<th>体验码查看</th>
			<%--<shiro:hasPermission name="sh:ShAppletSetting:edit"><th>操作</th></shiro:hasPermission></tr></thead>--%>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
				<td>${entity.APLT_NAME}</td>
				<td>${entity.MCHT_NAME}</td>
				<td>${entity.SCHM_EDT_NAME}</td>
				<td>${entity.APLT_VER_NAME}</td>
				<td>${entity.APLT_LAST_VER_NAME}</td>
				<td>
					${fns:getConsLabel('CFG_APPLET_VERSION_ONLINE', entity.APLT_VER_AUTO_ONLINE, '未开启')}
				</td>
				<td>
					<c:choose>
						<c:when test="${entity.APLT_VER_AUTO_ONLINE == '1'}">
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_UPLOAD', entity.APP_CODE_UPLOAD_STATUS, '未上传')}
						</c:when>
						<c:when test="${not empty entity.APLT_VER_AUTO_ONLINE && entity.APLT_VER_AUTO_ONLINE == '0' && entity.APP_CODE_UPLOAD_STATUS=='0'}">
							<a href="${ctx}/sh/ShAppletSetting/codeUpdateStatus?upType=1&apltSetId=${entity.APLT_SET_ID}&apltVerId=${entity.APLT_LAST_VER_ID}" onclick="return lasyConfirm('确认要上传商户“${entity.MCHT_NAME}” 小程序“${entity.APLT_NAME}”的代码吗？', reForm,this.href);">上传代码</a>
						</c:when>
						<c:otherwise>
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_UPLOAD', entity.APP_CODE_UPLOAD_STATUS, '没有新版本')}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${entity.APLT_VER_AUTO_ONLINE == '1'}">
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_AUDIT', entity.APP_AUDIT_STATUS, '未提交')}
						</c:when>
						<c:when test="${not empty entity.APLT_VER_AUTO_ONLINE && entity.APLT_VER_AUTO_ONLINE == '0' && entity.APP_AUDIT_STATUS=='0'}">
							<a href="${ctx}/sh/ShAppletSetting/codeUpdateStatus?upType=2&apltSetId=${entity.APLT_SET_ID}" onclick="return lasyConfirm('确认要提交商户“${entity.MCHT_NAME}” 小程序“${entity.APLT_NAME}”审核吗？', reForm,this.href);">提交审核</a>
						</c:when>
						<c:otherwise>
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_AUDIT', entity.APP_AUDIT_STATUS, '没有新版本')}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${entity.APLT_VER_AUTO_ONLINE == '1'}">
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_PUB', entity.APP_AUDIT_STATUS, '未发布')}
						</c:when>
						<c:when test="${not empty entity.APLT_VER_AUTO_ONLINE && entity.APLT_VER_AUTO_ONLINE == '0' && entity.APP_PUB_STATUS=='0'}">
							<a href="${ctx}/sh/ShAppletSetting/codeUpdateStatus?upType=3&apltSetId=${entity.APLT_SET_ID}" onclick="return lasyConfirm('确认要发布商户“${entity.MCHT_NAME}” 小程序“${entity.APLT_NAME}”代码吗？', reForm,this.href);">发布</a>
						</c:when>
						<c:otherwise>
							${fns:getConsLabel('SH_APPLET_SETTING_CODE_PUB', entity.APP_PUB_STATUS, '没有新版本')}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${entity.APP_AUDIT_STATUS eq '3' and entity.APP_PUB_STATUS ne '2' and entity.APP_PUB_STATUS ne '3'}">
							<a  onclick='getExpressCode("${entity.APP_ID}")'>查看体验码</a>
						</c:when>
						<c:otherwise>
							没有体验码
						</c:otherwise>
					</c:choose>
				</td>

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