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
		function getSchm(obj){
		    var schmId=$(".schmId").val();
            $.post("${ctx}/sh/ShMerchantScheme/getSchmId", {"schmId":schmId}, function(data){
                var html="";
                html+="<option value=\"\">请选择</option>"
                $.each(data,function(index,info){
                    html+='<option value="'+info.schmEdtId+'">'+info.schmEdtName+'</option>';
                })
                $("#schmEdtId").html(html);
            });
        }
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

    </style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShMerchantScheme/" onclick="return lasySubmit(bakForm,this.href);">商户方案列表</a></li>
		<li class="active"><a href="javascript:void()">
		商户方案<tags:autoFormLabel editPermission="sh:ShMerchantScheme:edit" id="${entry.mchtSchmId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShMerchantScheme/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
            <form:hidden path="mchtSchmId" />
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">商户：</label>
                    <div class="controls">
                        <form:select path="mchtId" class="input-medium" required="true" onchange="getSchm(this)" >
                            <c:forEach items="${shMerchantList}" var="list">
                                <form:option value="${list.mchtId}">${list.mchtName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                        <div class="control-group span6">
                            <label class="control-label">行业方案：</label>
                            <div class="controls">
                                <form:select path="" class="input-medium schmId" required="true" onchange="getSchm(this)" >
                                    <form:option value="">请选择</form:option>
                                    <c:forEach items="${schemeList}" var="list">
                                        <form:option value="${list.schmId}">${list.schmName}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                <div class="control-group span6">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        <form:select path="schmEdtId" class="input-medium" required="true" onchange="getPackageList();">
                            <form:option value="">请选择</form:option>
                            <c:forEach items="${mapList}" var="list">
                                <form:option value="${list.schmEdtId}">${list.schEdtName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">到期时间：</label>
                    <div class="controls">
                        <input id="mchtSchmExpireDate"   required="true" name="mchtSchmExpireDate" type="text" readonly="readonly" maxlength="20"
                               class="Wdate" value="<fmt:formatDate value="${entry.mchtSchmExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">付费状态</label>
                    <div class="controls">
                        <form:select path="mchtSchmPayStatus" class="input-medium"  required="true">
                            <form:options items="${fns:getConsList('ord_pay_status')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">是否升级</label>
                    <div class="controls">
                        <form:select path="mchtUpgradeStatus" class="input-medium" required="true">
                            <form:option value="0">不升级</form:option>
                            <form:option value="1">免费升级</form:option>
                        </form:select>
                    </div>
                </div>
            </div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShMerchantScheme:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>