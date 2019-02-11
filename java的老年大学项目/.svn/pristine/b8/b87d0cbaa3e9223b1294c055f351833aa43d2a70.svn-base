<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>


<script src="${staticurl}/js/related.js" type="text/javascript"></script>

<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script>  

	$(document).ready(function() {
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入班级代码"
				} 
			
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});
</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>

<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>

<div class="admin_tc">
<div class="seemore0">
<div class="ttu"><span class="admin_f14 admin_fw">个人订单详细</span><span
	class="light_black"></span></div>
<strong style="text-indent: 15px; float: left;">用户信息</strong> <br />
<input type="hidden" name="clazz.id" value="${clazz.id}" /> <input
	type="hidden" name="id" value="${clazz.id}" />


<table width="98%" align="center" cellspacing="5" bordercolor="#ACCEE8"
	class="admin_tab10">
	<tr>
		<td width="13%" class="buleleft">身份证/用户名</td>
		<td>${orderform.useridcard }</td>
	</tr>
	<tr>
		<td class="buleleft">姓名</td>
		<td></td>
	</tr>
	<tr>
		<td class="buleleft">下单时间</td>
		<td><s:date name="orderform.createTime"
			format="yyyy.MM.dd HH:mm:ss" /></td>
	</tr>
	<tr>
		<td class="buleleft">截止时间</td>
		<td><s:date name="orderform.endTime" format="yyyy.MM.dd HH:mm:ss" />
		</td>
	</tr>

</table>
<strong style="text-indent: 15px; float: left;">订单内容</strong>
<table width="98%" align="center" cellspacing="5" bordercolor="#ACCEE8"
	class="admin_tab10">
	<tr>
		<td width="13%" class="buleleft">订单号</td>
		<td>${orderform.sn }</td>
	</tr>
	<tr>
		<td class="buleleft">订单状态</td>
		<td>${orderform.statusdesc }</td>
	</tr>
	<tr>
		<td class="buleleft">订单类型</td>
		<td>${orderform.typedesc }</td>
	</tr>
	<tr>
		<td class="buleleft">订单名称</td>
		<td>${orderform.name }</td>
	</tr>
	<tr>
		<td class="buleleft">原始金额</td>
		<td>${orderform.needPrice }</td>
	</tr>
	<tr>
		<td class="buleleft">实际金额</td>
		<td>${orderform.realPrice }</td>
	</tr>
</table>
<table class="tabcleck" cellspacing="0" align="center" border="0"
	width="96%">
	<tbody>
		<tr>
			<td class="buleleft">课程名称</td>
			<td class="buleleft">课程代码</td>
			<td class="buleleft">学时</td>
			<td class="buleleft">数量</td>
		</tr>

		<s:iterator value="orderform.details" status="stat">
			<tr>
				<td>${course.name }</td>
				<td>${course.serialNo }</td>
				<td>${course.studylength }</td>
				<td>${itemnum }</td>
			</tr>
		</s:iterator>

	</tbody>
</table>
<s:if test="curTenantID==null">
<s:if test="orderform.status==3">

	<form method="post" action="order!returnpayment.action">
	<div class="operation_list0"><span class="fl"> <input
		name="Submit32" class="operation_btu1" value="退单" type="button"
		onclick="$('#return_container').toggle();" /> <input name="Submit32"
		class="operation_btu1" value="关闭" type="button"
		onclick="window.close()" /> </span></div>

<input type="hidden" name="id" value="${orderform.id}" />
<table width="98%" align="center" cellspacing="5" id="return_container"
		style="display: none" class="admin_tab10">
		
		<tr>
			<td class="buleleft">退单情况描述</td>
			<td><textarea rows="8" cols="40" name="remark">${orderform.remark }</textarea></td>
		</tr>
		<tr>
			<td class="buleleft"></td>
			<td><input name="Submit32" class="operation_btu1" value="确认退单"
				type="submit" /> <input name="Submit32" class="operation_btu1"
				value="取消" type="button" onclick="$('#return_container').toggle();" />
			</td>
		</tr>
	</table>
	
	
	
</form>

</s:if>
<s:elseif
	test="orderform.status==1">
	<%if(SpringSecurityUtils.getCurrentUserName().equals("anonymousUser")){}else{
		  UserDTO curUser = UserUtils.getCurUser();
		  request.setAttribute("curUser",curUser);%>
	 
	<form method="post" action="order!savepayment.action">
	<div class="operation_list0"><span class="fl"> <input
		name="Submit32" class="operation_btu1" value="线下支付" type="button"
		onclick="$('#wait_container').toggle();" /> <input name="Submit32"
		class="operation_btu1" value="关闭" type="button"
		onclick="window.close()" /> </span></div>
	<input type="hidden" name="id" value="${orderform.id}" />
	<table width="98%" align="center" cellspacing="5" id="wait_container"
		style="display: none" class="admin_tab10">
		<tr>
			<td width="13%" class="buleleft">支付方式</td>
			<td>线下支付</td>
		</tr>
		<tr>
			<td class="buleleft">支付渠道</td>
			<td><s:select list="#{'现场缴费':1,'银行汇款':2}" listKey="value"
				name="paytype" listValue="key" theme="simple" headerKey="" value="orderform.payType"
				headerValue="--选择支付渠道--"></s:select></td>
		</tr>
		<tr>
			<td class="buleleft">支付金额</td>
			<td><input type="text" name="realPrice"
				value="${orderform.needPrice }"></input></td>
		</tr>
		<tr>
			<td class="buleleft">备注</td>
			<td><textarea rows="8" cols="40" name="remark">${orderform.remark }</textarea></td>
		</tr>
		<tr>
			<td class="buleleft"></td>
			<td><input name="Submit32" class="operation_btu1" value="确认支付"
				type="submit" /> <input name="Submit32" class="operation_btu1"
				value="取消" type="button" onclick="$('#wait_container').toggle();" />
			</td>
		</tr>
	</table>
	</form>
<%}%>


</s:elseif>


<s:elseif test="orderform.status==6">
<strong style="text-indent: 15px; float: left;">退单信息</strong>
<table width="98%" align="center" cellspacing="5"  class="admin_tab10">
		<tr>
			<td class="buleleft">退单详细情况</td>
			<td><textarea rows="8" cols="40" name="remark">${orderform.remark }</textarea></td>
		</tr>
	</table>
</s:elseif>
</s:if>
</div>
</div>

</body>
</html>
