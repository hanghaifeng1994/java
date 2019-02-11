<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="editPermission" type="java.lang.String" required="true" description="修改权限" %>
<%@ attribute name="id" type="java.lang.Object" required="false" description="主键"%>
<c:if test="${not empty param.isView}">
    <c:set var="optType" value="view" />
</c:if>
<c:if test="${empty param.isView}">
    <shiro:hasPermission name="${editPermission}">
        <c:set var="optType" value="${not empty id?'modi':'add'}" />
    </shiro:hasPermission>
    <shiro:lacksPermission name="${editPermission}">
        <c:set var="optType" value="view" />
    </shiro:lacksPermission>
</c:if>
<c:if test="${optType == 'add'}">添加</c:if>
<c:if test="${optType == 'modi'}">修改</c:if>
<c:if test="${optType == 'view'}">查看</c:if>
<script>
    function cancelHander() {
        return false;
    }
    function readonlyHander(i, e) {
    	var thiz = e && $(e) || $(this);
    	thiz.addClass("readonly").attr("readonly", "readonly").attr("onclick", cancelHander);
    }
    var __nav_title =  '修改';
//<c:if test="${optType == 'add'}">
    __nav_title = '添加';
    //</c:if>
    $(function() {
        $(".hide-${optType}").hide();
        $(".readonly-${optType}").each(readonlyHander);
        //<c:if test="${optType == 'view'}">
        __nav_title = '查看';
        $("input, select, textarea").not(".view-edit, .btn").each(readonlyHander);
        $("input[type=submit]").hide();
        //</c:if>
        //<c:if test="${optType != 'view'}">
        $(".hide-edit").hide();
        //</c:if>
        $('select.readonly option').not(":selected").hide().attr('disabled', true);
    })
</script>
