<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>

<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">班级报名</a> &gt; <span class="deep_bule">班级列表</span></div>


<form id="mainForm" name="mainForm" action="order.action" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>

<table class="user_search" cellpadding="0" cellspacing="0" border="0"
	width="100%">
	<tbody>
		<tr>
			<td width="30%">订单号 <input name="filter_EQS_sn"
				class="txt_input mr10" value="${param['filter_EQS_sn']}" /></td>
			<td width="30%">订单名称 <input name="filter_LIKES_name"
				class="txt_input mr10" value="${param['filter_LIKES_name']}" /></td>
			<td width="30%">订单状态
			
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>姓名  <input name="filter_LIKES_username"
				class="txt_input mr10" value="${param['filter_LIKES_username']}"  style="width:20px" />
			</td>
			<td>身份证  <input name="filter_EQS_idcard"
				class="txt_input mr10" value="${param['filter_EQS_idcard']}" /></td>
			<td>金额 <input name="filter_GEN_realPrice"
				class="txt_input mr10" style="width:30px" value="${param['filter_GEN_realPrice']}" />-  <input name="filter_LEN_realPrice"
				class="txt_input mr10" value="${param['filter_LEN_realPrice']}"  style="width:30px" /></td>
			<td align="center"></td>
		</tr>
		<tr>
			<td colspan="2">下单时间 <input name="filter_GED_createTime"
				class="txt_input mr10 Wdate" style="width:100px" value="${param['filter_GED_createTime']}"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>-  
				<input name="filter_LED_createTime" class="txt_input mr10 Wdate" value="${param['filter_LED_createTime']}"  style="width:100px"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
			<td></td>
			<td align="center">
				<input name="Submit5" class="search_btu mr5" value="查 询" type="submit"/>&nbsp;
  				<input name="Submit2" type="button" class="operation_btu1 export" value="导出" id="" onclick="$('#export').val('true');document.mainForm.submit();" />				
			</td>
		</tr>
	</tbody>
</table>
</form>

<form name="deleteForm" id="deleteForm" action="order.action"
	method="post">
<div class="operation_list"><%@ include
	file="/common/turnpage.jsp"%></div>
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="13%" class="tt_line">订单号</td>
		<td width="13%" class="tt_line">银联订单号</td>
		<td width="13%" class="tt_line">订单种类</td>
		<td width="13%" class="tt_line">订单名称</td>
		<td width="13%" class="tt_line">金额</td>
		<td width="13%" class="tt_line">下单人姓名</td>
		<td width="13%" class="tt_line">下单时间</td>
		<td width="10%" class="tt_line">订单状态</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg"><a href="order!info.action?id=${id }"  target="_blank" >${sn}</a></td>
			<td class="white_bg"><a href="#"></a></td>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${realPrice}</td>
			<td class="white_bg">${username}</td>
			<td class="white_bg"><s:date name="createTime"
				format="yyyy.MM.dd HH:mm " /></td>
			<td class="white_bg">${statusdesc}</td>
		</tr>
	</s:iterator>
</table>
</div>
<div class="operation_list"><%@ include
	file="/common/turnpage.jsp"%></div>
</form>