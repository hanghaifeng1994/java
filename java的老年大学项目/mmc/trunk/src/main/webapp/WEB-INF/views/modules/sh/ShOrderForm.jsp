<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户订单管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
    <style>
        .activity{
            margin-top:10px;
        }
    </style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sh/ShOrder/" onclick="return lasySubmit(bakForm,this.href);">商户订单列表</a></li>
		<li class="active"><a href="javascript:void()">
		商户订单<tags:autoFormLabel editPermission="sh:ShOrder:edit" id="${entry.ordId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShOrder/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                 <form:hidden path="ordId" />
                <div class="control-group span6">
                    <label class="control-label">订单号：</label>
                    <div class="controls">
                            <form:input path="ordNum" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">方案版本历史id：</label>
                    <div class="controls">
                            <form:input path="schmEdtHisId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">方案版本价格id：</label>
                    <div class="controls">
                            <form:input path="edtPrcId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">付款方式：</label>
                    <div class="controls">
                        <form:select path="schmEdtPayType" class="input-medium">
                            <form:options items="${fns:getConsList('schm_edt_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">方案价格：</label>
                    <div class="controls">
                            <form:input path="schmEdtPrice" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">增值包价格：</label>
                    <div class="controls">
                            <form:input path="schmEdtIncreasePrice" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">购买数量：</label>
                    <div class="controls">
                            <form:input path="ordBuyNum" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">开始时间：</label>
                    <div class="controls">
                            <input id="serviceStartDate" name="serviceStartDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.serviceStartDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">结束时间：</label>
                    <div class="controls">
                            <input id="serviceEndDate" name="serviceEndDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.serviceEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">总金额：</label>
                    <div class="controls">
                            <form:input path="ordTotalAmount" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">交费状态：</label>
                    <div class="controls">
                        <form:select path="ordPayStatus" class="input-medium">
                            <form:options items="${fns:getConsList('ord_pay_status')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">优惠金额：</label>
                    <div class="controls">
                            <form:input path="ordDiscountAmount" class="number"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">实际金额：</label>
                    <div class="controls">
                            <form:input path="ordRealAmount" class="number"/>
                    </div>
                </div>
                <div class="control-group span6 activity" >
                    <label class="control-label">活动：</label>
                    <div class="controls">
                       <a href="${ctx}/sh/ShActivity/form?isView=1&id=${ac.actId}">${ac.actName}</a>
                    </div>
                </div>
                    <div class="control-group span6">
                    <label class="control-label">增值包：</label>
                    <div class="controls">
                            <c:forEach items="${spList}" var="list">
                                <a href="${ctx}/cfg/CfgFunctionPackage/form?isView=1&id=${list.pkgId}">${list.pkgName}</a>
                            </c:forEach>
                    </div>
                </div>
                    <div class="control-group span6">
                        <label class="control-label">增值服务：</label>
                        <div class="controls">
                                <c:forEach items="${asList}" var="list">
                                    <a href="${ctx}/cfg/CfgAddedService/form?isView=1&id=${list.asId}">${list.asName}</a>
                                </c:forEach>
                        </div>
                    </div>
                <div class="control-group span6">
                    <label class="control-label">订单状态：</label>
                    <div class="controls">
                        <form:select path="ordStatus" class="input-medium">
                            <form:options items="${fns:getConsList('ord_status')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">1购买、2升级：</label>
                    <div class="controls">
                        <form:select path="ordType" class="input-medium">
                            <form:options items="${fns:getConsList('ord_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">原订单id：</label>
                    <div class="controls">
                            <form:input path="ordOldId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">客户经理id：</label>
                    <div class="controls">
                            <form:input path="clientManagerId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">客户经理名称：</label>
                    <div class="controls">
                            <form:input path="clientManagerName" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商家方案id：</label>
                    <div class="controls">
                            <form:input path="mchtSchmId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">商家id：</label>
                    <div class="controls">
                            <form:input path="mchtId" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">缴费方式：</label>
                    <div class="controls">
                        <form:select path="ordPayType" class="input-medium" readonly="readonly">
                            <form:options items="${fns:getConsList('ord_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">交费时间：</label>
                    <div class="controls">
                            <input id="ordPayDate" name="ordPayDate" type="text" readonly="readonly" maxlength="20"
                                   class="Wdate" value="<fmt:formatDate value="${entry.ordPayDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">交费人名称：</label>
                    <div class="controls">
                            <form:input path="ordPayUsername" />
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">销售方式：</label>
                    <div class="controls">
                        <form:select path="ordSaleType" class="input-medium" readonly="readonly">
                            <form:options items="${fns:getConsList('ord_pay_type')}" itemLabel="label" itemValue="value" ></form:options>
                        </form:select>
                    </div>
                </div>
                 <c:choose >
                     <c:when test="${entry.ordStatus ne '0'}">
                         <div class="control-group span6">
                             <label class="control-label">作废时间：</label>
                             <div class="controls">
                                 <input id="ordCancelDate" name="ordCancelDate" type="text" readonly="readonly" maxlength="20"
                                        class="Wdate" value="<fmt:formatDate value="${entry.ordCancelDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                             </div>
                         </div>
                         <div class="control-group span6">
                             <label class="control-label">作废人名称：</label>
                             <div class="controls">
                                 <form:input path="ordCancelUsername" />
                             </div>
                         </div>
                         <div class="control-group span12">
                             <label class="control-label">作废人原因：</label>
                             <div class="controls">
                                 <form:textarea path="ordCancelCause" rows="10"   class="input-xxlarge"></form:textarea>
                             </div>
                         </div>
                     </c:when>
                 </c:choose>
                <div class="control-group span6">
                    <label class="control-label">备注：</label>
                    <div class="controls">
                            <form:input path="remarks" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sh:ShOrder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>