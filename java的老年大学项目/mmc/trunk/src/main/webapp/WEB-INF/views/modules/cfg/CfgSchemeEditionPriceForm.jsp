<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本价格管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
		function btnSumbit(){
		    var edtPrcYearPrice=$("#edtPrcYearPrice").val();
		    var edtPrcMonthPrice=$("#edtPrcMonthPrice").val();
		    var flag=true;
		    if(parseInt(edtPrcYearPrice)>parseInt(edtPrcMonthPrice)*12){
                top.$.jBox.info("年价格不能大于月价格的十二倍！","系统提示");
                flag=false;
            }
            if(flag){
                $("#inputForm").submit();

                <%--var schmEdtId=$("#schmEdtId").val();--%>
                <%--window.location.href="${ctx}/cfg/CfgSchemeEdition/priceManger?id=${entity.schmEdtId}"--%>
            }
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgSchemeEdition/" onclick="return lasySubmit(bakForm,this.href);">方案版本列表</a></li>
		<li class="active"><a href="javascript:void();">
		方案版本价格<tags:autoFormLabel editPermission="cfg:CfgSchemeEditionPrice:edit" id="${entry.edtPrcId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionPrice/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
            <form:hidden path="edtPrcId"/>
            <form:hidden path="schmEdtId"/>
			<div class="row">
                <div class="control-group span6">
                    <label class="control-label">名称：</label>
                    <div class="controls">
                            <form:input path="edtPrcName" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">年价格：</label>
                    <div class="controls">
                            <form:input path="edtPrcYearPrice" class="number" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">月价格：</label>
                    <div class="controls">
                            <form:input path="edtPrcMonthPrice" class="number" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">门店数：</label>
                    <div class="controls">
                            <form:input path="edtPrcStoreNum" class="number" required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">状态</label>
                    <div class="controls">
                        <form:select path="edtPrcStatus" class="input-medium" required="true">
                            <form:option value="0">未启用</form:option>
                            <form:option value="1">启用</form:option>
                            <form:option value="2">作废</form:option>
                        </form:select>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgSchemeEditionPrice:edit"><input id="btnSubmit" class="btn btn-primary" type="button" onclick="btnSumbit()" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>