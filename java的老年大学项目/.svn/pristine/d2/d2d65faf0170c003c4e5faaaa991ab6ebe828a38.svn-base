<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">支付结算管理</a> &gt; <span class="deep_bule">退单审核记录</span></div>
<script>
</script>

<form id="mainForm" name="mainForm" action="audit-record.action" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<table class="user_search" cellpadding="0" cellspacing="0" border="0"
	width="100%">
	<tbody>
		<tr>
			<td width="10%">订单号</td>
			<td width="20%"><input name="filter_EQS_sn"
				class="txt_input mr10" value="${param['filter_EQS_sn']}" /></td>
			<td width="10%">审核结果</td>
			<td width="20%"><s:select list="#{'通过':1,'未通过':0}"
				listKey="value" theme="simple" listValue="key" headerValue="所有"
				headerKey=""
				value="@java.lang.Integer@parseInt(#parameters.filter_EQB_checkresult)"
				name="filter_EQB_checkresult"></s:select></td>
			<td width="20%" rowspan="3"><input name="Submit5" class="search_btu mr5"
				value="查 询" type="submit" /></td>
		</tr>
	</tbody>
</table>
</form>

<form name="deleteForm" id="deleteForm" action="order!delete.action"
	method="post">
	<br/>
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="20%" class="tt_line">订单</td>
		<td width="15%" class="tt_line">审核结果</td>
		<td width="15%" class="tt_line">审核人</td>
		<td width="20%" class="tt_line">审核时间</td>
		<td width="30%" class="tt_line">审核备注</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg"><a href="order!info.action?id=${orderform.id }"  target="_blank" >${orderform.sn}</a></td>
			<td class="white_bg">${checkresultStr}</td>
			<td class="white_bg">${checkOperator}</td>
			<td class="white_bg">${checkTime}</td>
			<td class="white_bg">${checkRemark}</td>
		</tr>
	</s:iterator>
</table>
</div>
<div class="operation_list"><%@ include
	file="/common/turnpage.jsp"%></div>
</form>