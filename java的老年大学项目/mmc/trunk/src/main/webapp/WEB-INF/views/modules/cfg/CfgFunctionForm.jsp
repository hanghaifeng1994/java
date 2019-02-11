<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>功能管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgFunction/" onclick="return lasySubmit(bakForm,this.href);">${entry.funcType==1? '后管':'前台'}-功能列表</a></li>
		<li class="active"><a href="javascript:void()">
		功能<tags:autoFormLabel editPermission="cfg:CfgFunction:edit" id="${entry.funcId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgFunction/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="funcId"/>
        <form:hidden path="funcType"/>
        <form:hidden path="mdlId"/>

		${paramCover.unCovered_Inputs}
        <div class="control-group">
            <label class="control-label">上级菜单:</label>
            <div class="controls">
                <sys:treeselect id="parent" name="parentId" value="${entry.parentId}" labelName="${parent.funcName}" labelValue="${parent.funcName}"
                                title="菜单" url="/cfg/CfgFunction/treeData?funcType=${param.funcType}&mdlId=${param.mdlId}" extId="${entry.funcId}" cssClass="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">功能名称：</label>
            <div class="controls">
                <form:input path="funcName" htmlEscape="false" maxlength="50" class="required input-xlarge"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <%--<c:if test="${entry.funcType == 1}">--%>
        <div class="control-group">
            <label class="control-label">接口html：</label>
            <div class="controls">
                <form:select path="funcMngType">
                    <form:options items="${fns:getConsList('CFG_FUNCTION_MNG_TYPE')}" itemLabel="label" itemValue="value" ></form:options>
                </form:select>

            </div>
        </div>
        <%--</c:if>--%>
        <div class="control-group">
            <label class="control-label">链接：</label>
            <div class="controls">
                <form:input path="funcUrl" htmlEscape="false" maxlength="2000" class="input-xxlarge"/>
                <span class="help-inline">点击菜单跳转的页面</span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">排序:</label>
            <div class="controls">
                <form:input path="sort" htmlEscape="false" maxlength="50" class="required digits input-small"/>
                <span class="help-inline">排列顺序，升序。</span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">权限标识：</label>
            <div class="controls">
                <form:input path="funcPermission" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">可见:</label>
            <div class="controls">
                <form:radiobuttons path="funcShowStatus" items="${fns:getDictList('show_hide')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
                <span class="help-inline">该菜单或操作是否显示到菜单中</span>
            </div>
        </div>
        <div class="form-actions">
            <shiro:hasPermission name="cfg:CfgFunction:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
            <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
        </div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>