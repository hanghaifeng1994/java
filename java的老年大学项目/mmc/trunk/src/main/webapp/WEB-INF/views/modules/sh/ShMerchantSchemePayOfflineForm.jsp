<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户方案管理</title>
	<meta name="decorator" content="blank"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});

			var nfPrice = ${schemeEdition.schmEdtYearPrice};
			var yfPrice = ${schemeEdition.schmEdtMonthPrice};
			$('#schmEdtPrice').html(nfPrice);
			$('input[name="schmEdtPayType"]').change(function () {
				var price = nfPrice;
				if(1 == $(this).val())
					price = yfPrice;
				$('#schmEdtPrice').html(price);
			});
			var dt = new Date();
			var ssDate = dt.format('yyyy')+'-'+dt.format('MM') +'-'+ dt.format("dd");
			$('#startDate').val(ssDate);
		});
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShMerchantScheme/payOffline" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
		<form:hidden path="mchtSchmId"></form:hidden>
		<form:hidden path="schmEdtId"></form:hidden>
		<form:hidden path="mchtId"></form:hidden>
        <div class="container-fluid">
			<div class="row">

				<%--<div class="control-group span6">
					<label class="control-label">方案版本名称：</label>
					<div class="controls">
						${mchtSchm.schmEdtName}
					</div>
				</div>--%>
				<div class="control-group span6">
					<label class="control-label">购买方式：</label>
					<div class="controls">
							<form:radiobuttons path="schmEdtPayType" items="${fns:getConsList('SH_SCHM_EDT_PAY_TYPE')}" itemLabel="label" itemValue="value"></form:radiobuttons>
					</div>
				</div>

				<div class="control-group span6">
					<label class="control-label">价格：</label>
					<div class="controls">
						<%--<form:hidden path="schmEdtPrice"></form:hidden>--%>
						<span id="schmEdtPrice"></span>&nbsp;元
					</div>
				</div>
                <div class="control-group span6">
                    <label class="control-label">购买数量：</label>
                    <div class="controls">
						<form:input path="ordBuyNum"></form:input>
                    </div>
                </div>

				<div class="control-group span6">
					<label class="control-label">增值包金额：</label>
					<div class="controls">
						<%--<form:input path="schmEdtIncreasePrice"></form:input>--%>
						${entry.schmEdtIncreasePrice}&nbsp;元
					</div>
				</div>

				<div class="control-group span6">
					<label class="control-label">优惠价格：</label>
					<div class="controls">
						<form:input path="ordDiscountAmount"></form:input> &nbsp;元
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">销售类型：</label>
					<div class="controls">
						<form:select path="ordSaleType" items="${fns:getConsList('SH_ORDER_SALE_TYPE')}" itemLabel="label" itemValue="value"></form:select>
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">生效日期：</label>
					<div class="controls">
						<input id="startDate" name="serviceStartDate" type="text" readonly="readonly" maxlength="20"
							   class="Wdate" value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
					</div>
				</div>


			</div>
		</div>

		<%--<div class="form-actions">
			<shiro:hasPermission name="sh:ShMerchantScheme:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>--%>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>