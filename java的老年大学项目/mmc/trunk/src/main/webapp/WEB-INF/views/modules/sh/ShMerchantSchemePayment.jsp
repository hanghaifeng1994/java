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
        function getPackageList(){
		    var schmEdtId=$("#schmEdtId").val();
            $.post("${ctx}/sh/ShMerchantScheme/getPackageList", {"schmEdtId":schmEdtId}, function(data){
                var html="";
                if(data.length!=0){
                    $.each(data,function (index,info){
                        html+=" <input name='pkgId' type='checkbox' value='"+info.pkgId+"'>"+info.pkgName+" &nbsp;&nbsp;";
                    } )
                }else{
                    html+="该方案无增值包"
                }
                $(".add-price").html(html);

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
        .time{
            display: none;
        }
        #schmEdtPayType{
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
            <input type="hidden" value="${entry.mchtId} " name="mchtId"/>
            <input type="hidden" value="${entry.schmId}" name="schmId"/>
            <input type="hidden" value="${entry.schmEdtId}" name="schmEdtId"/>
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
                <div class="control-group span12">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        <form:input path="schmEdtName" class="input-medium" readonly="true"></form:input>

                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">增值包：</label>
                    <div class="controls">
                        <label class="add-price">
                            <c:forEach items="${increasePaklist}" var="list">
                                <input name='pkgId' class="input-medium" type='checkbox' value='${list.pkgId}'>${list.pkgName} &nbsp;&nbsp;
                            </c:forEach>
                        </label>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">增值服务：</label>
                    <div class="controls">
                        <label class="add-service">
                            <c:forEach items="${serviceList}" var="list">
                                <input name='asId' type='checkbox' value="${list.asId}">${list.asName} &nbsp;&nbsp;
                            </c:forEach>
                        </label>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">活动</label>
                    <div class="controls">
                        <form:select path="actId" class="input-medium">
                            <option value="">请选择</option>
                            <c:forEach items="${acList}" var="list">
                                <option value="${list.actId}">${list.actName}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">付费状态</label>
                    <div class="controls">
                        <form:select path="mchtSchmPayStatus" class="input-medium" required="true">
                            <form:option value="0">未付费</form:option>
                            <form:option value="1">已付费</form:option>
                            <form:option value="2">欠费</form:option>
                        </form:select>
                    </div>
                </div>

                <div class="control-group  span6">
                    <label class="control-label">开始时间：</label>
                    <div class="controls">
                        <input id="serviceStartDate" name="serviceStartDate"   required="true" type="text" maxlength="20"
                               class="Wdate" value="<fmt:formatDate value="${entry.mchtSchmExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group time span6">
                    <label class="control-label">到期时间：</label>
                    <div class="controls">
                        <input id="mchtSchmExpireDate"   required="true" name="mchtSchmExpireDate" type="text" maxlength="20"
                               class="Wdate" value="<fmt:formatDate value="${entry.mchtSchmExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">购买数量</label>
                    <div class="controls">
                            <input id="ordBuyNum" name="ordBuyNum" class="input-medium　 ordBuyNum"   required="true"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">缴费人</label>
                    <div class="controls">
                        <input id="ordPayUsername" name="ordPayUsername" class="input-medium　 ordBuyNum"   required="true"/>
                    </div>
                </div>
                <div class="control-group  span6">
                    <label class="control-label">缴费时间：</label>
                    <div class="controls">
                        <input id="ordPayDate"   required="true" name="ordPayDate" type="text" required="true" maxlength="20"
                               class="Wdate" value="<fmt:formatDate value="${entry.ordPayDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">缴费方式</label>
                    <div class="controls">
                        <form:select path="ordPayType" class="input-medium" required="true" >
                            <form:option value="">请选择</form:option>
                            <form:options items="${fns:getConsList('ord_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">销售方式</label>
                    <div class="controls">
                        <form:select path="ordSaleType" class="input-medium" required="true">
                            <form:option value="">请选择</form:option>
                            <form:options items="${fns:getConsList('ord_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">付费类型</label>
                    <div class="controls">
                        <form:select path="schmEdtPayType" class="input-medium" required="true">
                           <form:option value="">请选择</form:option>
                            <form:options items="${fns:getConsList('schm_edt_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
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