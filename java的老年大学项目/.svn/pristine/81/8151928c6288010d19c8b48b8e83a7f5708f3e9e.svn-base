<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShActivity/" onclick="return lasySubmit(bakForm,this.href);">活动列表</a></li>
		<li class="active"><a href="javascript:void()">
		活动<tags:autoFormLabel editPermission="sh:ShActivity:edit" id="${entry.actId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShActivity/invalid" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <form:hidden path="actId" />
                <div class="control-group span6">
                    <label class="control-label">活动名称：</label>
                    <div class="controls">
                            <form:input path="actName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">优惠金额：</label>
                    <div class="controls">
                            <form:input path="actDiscountAmount" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">开始时间：</label>
                    <div class="controls">
                            <input id="actStartDate" name="actStartDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.actStartDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">结束时间：</label>
                    <div class="controls">
                            <input id="actEndDate" name="actEndDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.actEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">活动描述：</label>
                    <div class="controls">
                        <form:textarea path="actDesc" rows="10" cssStyle="width:98%" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShActivity:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>