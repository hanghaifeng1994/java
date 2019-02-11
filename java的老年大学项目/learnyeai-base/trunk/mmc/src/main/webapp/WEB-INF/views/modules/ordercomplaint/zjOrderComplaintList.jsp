<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>投诉管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/ordercomplaint/orderComplaint/zjList">中介投诉列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="orderComplaint" action="${ctx}/ordercomplaint/orderComplaint/zjList"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>投诉状态：</label>
            <form:select path="cmtStatus" class="input-medium">
                <form:option value="" label="全部"/>
                <form:options items="${fns:getConsList('CMT_STATUS')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            <label>时间：</label>
            <input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate" style="width:163px;"
                   value="<fmt:formatDate value="${orderComplaint.beginDate}" pattern="yyyy-MM-dd"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
            　--　
            <input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                   style="width:163px;"
                   value="<fmt:formatDate value="${orderComplaint.endDate}" pattern="yyyy-MM-dd"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>订单id</th>
        <th>货源名称</th>
        <th>处理状态</th>
        <th>业务类型</th>
        <th>投诉人名称</th>
        <th>处理人</th>
        <th>处理时间</th>
        <shiro:hasPermission name="ordercomplaint:orderComplaint:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="orderComplaint">
        <tr>
            <td><a href="${ctx}/ordercomplaint/orderComplaint/zjform?isView=1&id=${orderComplaint.cmtId}">
                    ${orderComplaint.cmtOrdId}
            </a></td>
            <td>
                    ${orderComplaint.title}
            </td>
            <td>
                    ${fns:getConsLabel("CMT_STATUS", orderComplaint.cmtStatus, "")}
            </td>
            <td>
                    ${fns:getConsLabel("CMT_SERVICE_TYPE", orderComplaint.cmtServiceType, "")}
            </td>
            <td>
                    ${orderComplaint.cmtCustName}
            </td>
            <td>
                    ${orderComplaint.cmtAuditUserName}
            </td>
            <td>
                <fmt:formatDate value="${orderComplaint.cmtAuditDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <shiro:hasPermission name="ordercomplaint:orderComplaint:edit">
                <td>
                   <c:if test="${orderComplaint.cmtStatus=='0'}"> <a href="${ctx}/ordercomplaint/orderComplaint/zjClForm?id=${orderComplaint.cmtId}">处理</a> </c:if>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>