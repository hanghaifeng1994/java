<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<!--<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>-->
<link href="${ctx}/js/jquery-datepicker/jquery.datepick.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/jquery-datepicker/jquery.datepick.js"type="text/javascript"></script>
<script src="${ctx}/js/jquery-datepicker/jquery.datepick-zh-CN.js" type="text/javascript"></script>
<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">支付结算管理</a> &gt; <a href="#" class="grey">线下支付退费管理</a><span class="deep_bule"></span></div>
<style>
	#return_container td{ border:none;}
	#wait_container  td{ border:none;}
</style>
<script>

</script>
<table width="98%" align="center" cellspacing="5" bordercolor="#ACCEE8"
	class="admin_tab10">
	<tr>
		<td width="13%" class="buleleft">身份证/用户名</td>
		<td>${orderform.useridcard }</td>
	</tr>
	<tr>
		<td class="buleleft">姓名</td>
		<td>${orderform.user.name}</td>
	</tr>
	<tr>
		<td width="13%" class="buleleft">订单号</td>
		<td>${orderform.sn }</td>
	</tr>
	<tr>
		<td class="buleleft">下单时间</td>
		<td><s:date name="orderform.createTime" format="yyyy.MM.dd HH:mm" /></td>
	</tr>
	<tr>
		<td class="buleleft">实际金额</td>
		<td>${orderform.realPrice }</td>
	</tr>
</table>
<form id="inputForm" name="inputForm" action="order!offlinerollbackpayment.action"
	method="post" enctype="multipart/form-data"><input id="id"
	name="id" type="hidden" value="${id}" size="30" />
<table width="98%" align="center" cellspacing="5" id="return_container" class="admin_tab10">
<tr>
		<td class="tdll">退费情况备注</td>
		<td><textarea rows="5" cols="40" name="refundRemark">${orderform.rollbackRemark}</textarea></td>
	</tr>
	<tr>
		<td class="tdll">&nbsp;</td>
		<td><span class="fl"> <input name="Submit32" type="submit"
			class="operation_btu1" value="确认退费" /> 
		<input onclick="window.location.href='order!refundlist.action'" type="button"
			class="operation_btu2" value="取 消" /> </span></td>
	</tr>
</table>
</form>
<div class="operation_list"><%@ include
	file="/common/turnpage.jsp"%></div>