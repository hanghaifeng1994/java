<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户方案管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
    <style>
        .ordBuyNum{
            width: 163px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 4px;
            height: 26px;
            line-height: 30px;
        }
        .Wdate{
            width: 53%!important;
        }
        .schmEdtPayType{
            width:60%;
        }

    </style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShMerchantScheme/" onclick="return lasySubmit(bakForm,this.href);">商户方案列表</a></li>
		<li class="active"><a href="javascript:void()">
		商户方案<tags:autoFormLabel editPermission="sh:ShMerchantScheme:edit" id="${entry.mchtSchmId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShMerchantScheme/createOreder" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
            <form:hidden path="mchtSchmId" />
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">商户名称</label>
                    <div class="controls">
                        <form:input path="mchtName" class="input-medium" readonly="true"></form:input>
                    </div>
                </div>
                        <div class="control-group span6">
                            <label class="control-label">行业方案：</label>
                            <div class="controls">
                                <form:input path="schmName" class="input-medium" readonly="true"></form:input>
                            </div>
                        </div>
                <div class="control-group span6">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        <form:input path="schmEdtName" class ="input-medium" readonly="true"></form:input>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">付费状态</label>
                    <div class="controls">
                        <form:select path="mchtSchmPayStatus"  readonly="true" class="input-medium  readonly" required="true">
                            <form:option value="0">未付费</form:option>
                            <form:option value="1">已付费</form:option>
                            <form:option value="2">欠费</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="control-group  span6">
                    <label class="control-label">到期时间：</label>
                    <div class="controls">
                        <input id="mchtSchmExpireDate"   required="true" name="mchtSchmExpireDate" type="text" readonly="readonly" maxlength="20"
                               class="Wdate input-large " value="<fmt:formatDate value="${entry.mchtSchmExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">是否升级</label>
                    <div class="controls">
                        <form:select path="mchtUpgradeStatus" class="input-medium " readonly="readonly" required="true">
                            <form:option value="0">不升级</form:option>
                            <form:option value="1">免费升级</form:option>
                        </form:select>
                    </div>
                </div>
            </div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShMerchantScheme:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="缴 费">&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>