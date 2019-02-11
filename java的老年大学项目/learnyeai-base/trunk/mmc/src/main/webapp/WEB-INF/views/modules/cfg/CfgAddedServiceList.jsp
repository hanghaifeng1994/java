<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>增值服务管理</title>
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
	   function check(){
            var beginDate=$("#beginDate").val();
            var endDate=$("#endDate").val();
            var flag=true;
            if(beginDate!="" && endDate!=""){
                if(parseInt(beginDate.replace("-","").replace("-",""))>parseInt(endDate.replace("-","").replace("-",""))){
                    flag=false;
                    top.$.jBox.info("起始时间不能大于结束时间！","系统提示");
                }
            }
            if(flag){
                return page();
            }
		}

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">增值服务列表</a></li>
		<shiro:hasPermission name="cfg:CfgAddedService:edit"><li><a href="${ctx}/cfg/CfgAddedService/form" onclick="return lasySubmit(reForm,this.href);">增值服务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgAddedService/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
            <li><span><label>增值服务名称：</label></span>
                <form:input path="asName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
            <li><span><label>状态：</label></span>
                <form:select path="asStatus" class="input-large">
                    <option value="">全部</option>
                    <form:option value="0">未启用</form:option>
                    <form:option value="1">启用</form:option>
                    <form:option value="2">作废</form:option>
                </form:select></li>
            <li>
                <label>创建时间：</label>
                <input id="beginDate"  name="beginDate"  type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
                       value="<fmt:formatDate value="${entry.beginDate}" pattern="yyyy-MM-dd"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
                　--　
                <input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
                       value="<fmt:formatDate value="${entry.endDate}" pattern="yyyy-MM-dd"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
            </li>
            <li class="clearfix"></li>
            <li class="btns">
                <input id="btnSubmit" class="btn btn-primary" type="button" value="查询" onclick="check()" />
            </li>
            <li class="clearfix"></li>
        </ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>增值服务名称</th>
			<th>服务价格</th>
			<th>状态</th>
			<th>创建人</th>
			<shiro:hasPermission name="cfg:CfgAddedService:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
			<td><a href="${ctx}/cfg/CfgAddedService/form?isView=1&id=${entity.asId}">${entity.asName}</a></td>
			<td>${entity.asPrice}</td>
			<td>
				<c:choose>
					<c:when test="${entity.asStatus eq '0'}">
						未启用
					</c:when>
					<c:when test="${entity.asStatus eq '1'}">
						启用
					</c:when>
					<c:when test="${entity.asStatus eq '2'}">
						作废
					</c:when>
				</c:choose>
			</td>
			<td>${entity.createBy}</td>
            <shiro:hasPermission name="cfg:CfgAddedService:edit"><td>
                <a href="${ctx}/cfg/CfgAddedService/form?id=${entity.asId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgAddedService/delete?id=${entity.asId}"
                   onclick="return lasyConfirm('确认要删除该增值服务吗？', reForm,this.href);">删除</a>
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