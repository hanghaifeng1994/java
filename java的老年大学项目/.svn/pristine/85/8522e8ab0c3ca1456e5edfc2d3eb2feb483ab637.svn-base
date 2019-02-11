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
<a href="#" class="grey">支付结算管理</a> &gt; <span class="deep_bule"></span></div>
<script>
function idcardcheck(){
    var idcard = $("#idcard").val();
    if(idcard!=""){
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
    if(reg.test(idcard) === false)  
      {  
          alert("身份证输入不合法");  
          return  false;  
       } 
    } 
	}
$(document).ready(function(){
	$("#creatTime01").datepick({dateFormat: 'yy-mm-dd'});
	$("#creatTime02").datepick({dateFormat: 'yy-mm-dd'});
})

function refund(id,paytype){
			if (confirm("退费？")){
				if(paytype==1){
					$.ajax({
						url:"order!rollbackpayment.action?id="+id,
						type:"post",
						dataType:"text" ,
						success: function(data) {
							alert(data)
							$("#mainForm").submit();
						}
					}) ;
				}else{
					window.location.href='order!refundRemark.action?id='+id;
				}
			}
		}
</script>

<form id="mainForm" name="mainForm" action="order!refundlist.action" method="post">
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	
	<table class="user_search" cellpadding="0" cellspacing="0" border="0" width="100%">
	<tbody>
		<tr>
			<td width="8%">订单号</td>
			<td width="20%"><input name="filter_EQS_sn"
				class="txt_input mr10" value="${param['filter_EQS_sn']}" /></td>
			<td width="10%">订单名称</td>
			<td width="20%"><input name="filter_LIKES_name"
				class="txt_input mr10" value="${param['filter_LIKES_name']}" /></td>
			<td>金额</td>
			<td><input name="filter_GEN_realPrice" class="txt_input mr10"
				style="width: 50px" value="${param['filter_GEN_realPrice']}" /> - <input
				name="filter_LEN_realPrice" class="txt_input mr10"
				value="${param['filter_LEN_realPrice']}" style="width: 50px" /></td>
			<td width="11%" rowspan="3"><input name="Submit5" class="search_btu mr5"
				value="查 询" type="submit" /></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input name="filter_LIKES_username" class="txt_input mr10"
				value="${param['filter_LIKES_username']}" /></td>
			<td>身份证</td>
			<td><input name="filter_EQS_idcard" id="idcard" onchange="idcardcheck()" class="txt_input mr10"
				value="${param['filter_EQS_idcard']}" /></td>
		
		</tr>
		<tr>
			<td>时间</td>
			<td colspan="2" align="left">
			<input name="filter_GED_createTime" id="creatTime01" class="dateinput" style="width: 90px"
				value="${param['filter_GED_createTime']}"/>- <input
				id="creatTime02" name="filter_LED_createTime" class="dateinput" value="${param['filter_LED_createTime']}" style="width: 90px"
				/></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tbody>
</table>




</form>

<form name="deleteForm" id="deleteForm" action="order!delete.action" method="post">
	<br/>
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="13%" class="tt_line">订单号</td>
		<td width="30%" class="tt_line">订单名称</td>
		<td width="10%" class="tt_line">金额(元)</td>
		<td width="10%" class="tt_line">下单人姓名</td>
		<td width="13%" class="tt_line">下单时间</td>
		<td width="10%" class="tt_line">支付类型</td>
		<td width="15%" class="tt_line">操作</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg"><a href="order!info.action?id=${id }"  target="_blank" >${sn}</a></td>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${realPrice}</td>
			<td class="white_bg">${user.name }</td>
			<td class="white_bg"><s:date name="createTime"
				format="yyyy.MM.dd HH:mm:ss" /></td>
			<td class="white_bg">${PayTypeStr}</td>
			<td class="white_bg"><input id="refund_${id}" type ="button" class="option" value="退费" onclick="refund(${id},${payType})"></input></td>
		</tr>
	</s:iterator>
</table>
</div>
<div class="operation_list"><%@ include
	file="/common/turnpage.jsp"%></div>
</form>