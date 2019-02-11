<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script>
	function checksubmit()
	{
		if($("#remark").val()=="")
		{
			alert('请输入备注内容');
			return false
		}
		return true;
	}
</script>
<style>
.tdll {
	width: 12%;
}
</style>

<style>
#return_container td{ border:none;}
#wait_container  td{ border:none;}

</style>
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
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end -->
<!-- container start -->
<div class="dr-wrapper">
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>订单详细<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    <!-- 信息表格 -->
        <div class="panel panel-default">
        	<div class="panel-heading">
			<h3 class="panel-title">下单信息</h3>
			</div>
			<input type="hidden" name="clazz.id" value="${clazz.id}" />
			<input type="hidden" name="id" value="${clazz.id}" />
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default">                       
					<tbody>
						<tr>
							<th width="13%" class="buleleft">身份证/用户名</th>
							<td>${orderformDTO.user.idcard }</td>
						</tr>
						<tr>
							<th class="buleleft">姓名</th>
							<td>${orderformDTO.user.name}</td>
						</tr>
						<tr>
							<th class="buleleft">下单时间</th>
							<td><s:date name="orderformDTO.createTime" format="yyyy.MM.dd HH:mm" /></td>
						</tr>
						<tr>
							<th class="buleleft">截止时间</th>
							<td><s:date name="orderformDTO.endTime" format="yyyy.MM.dd HH:mm" />
							</td>
						</tr>
					</tbody>
				</table>                    
				</div>
			</div>
		</div>
		<div class="panel panel-default">
        	<div class="panel-heading">
			<h3 class="panel-title">订单内容</h3>
			</div>
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default">                       
					<tbody>
						<tr>
							<th width="13%" class="buleleft">订单号</th>
							<td>${orderformDTO.sn }</td>
						</tr>
						<tr>
							<th class="buleleft">订单状态</th>
							<td>${orderformDTO.statusdesc }</td>
						</tr>
						<s:if test="orderformDTO.fqStatus=='true'">
							<tr>
								<th class="buleleft">废弃时间</th>
								<td><s:date name="orderformDTO.fqTime" format="yyyy.MM.dd HH:mm" /></td>
							</tr>
						</s:if>
						<tr>
							<th class="buleleft">订单类型</th>
							<td>${orderformDTO.typedesc }</td>
						</tr>
						<tr>
							<th class="buleleft">订单名称</th>
							<td>${orderformDTO.name }</td>
						</tr>
						<tr>
							<th class="buleleft">原始金额</th>
							<td>${orderformDTO.needPrice }</td>
						</tr>
						<tr>
							<th class="buleleft">实际金额</th>
							<td>${orderformDTO.realPrice }</td>
						</tr>
					</tbody>
				</table>
				<div class="btn-toolbar dr-btn-toolbar"></div>
				<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th >商品名称</th>
					<th >数量</th>
					<th >金额</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="orderformDetails" status="stat">
				<tr>
					<td>${name }</td>
					<td>${itemnum }</td>
					<td>${price}</td>
				</tr>
				</s:iterator>
				</tbody>
				</table>                   
				</div>
			</div>
		</div>
		<s:if test="orderformDTO.status==3">
		<div class="panel panel-default">
        	<div class="panel-heading">
			<h3 class="panel-title">支付信息</h3>
			</div>
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default">                       
					<tbody>
						<tr>
							<th width="13%" class="buleleft">支付时间</th>
							<td><s:date name="orderformDTO.payDate" format="yyyy.MM.dd HH:mm" />
							</td>
						</tr>
						<tr>
							<th class="buleleft">支付方式</th>
							<td>${orderformDTO.payTypeStr}</td>
						</tr>
						<tr>
							<th class="buleleft">支付渠道</th>
							<td>${orderformDTO.payPathdesc }</td>
						</tr>
						<tr>
							<th class="buleleft">下单应用类型</th>
							<td>${orderformDTO.payMethod }</td>
						</tr>
						<tr>
							<th class="buleleft">支付应用类型</th>
							<td>${orderformDTO.payFactMethod }</td>
						</tr>
						<tr>
							<th class="buleleft">支付金额</th>
							<td>${orderformDTO.realPrice}</td>
						</tr>
						<tr>
							<th class="buleleft">备注</th>
							<td>${orderformDTO.remark }
							</td>
						</tr>
						<tr>
							<th class="buleleft">操作用户</th>
							<td>${orderformDTO.payOperator }</td>
						</tr>

					</tbody>
				</table>
				<!--<s:if test="orderform.applyquit&&orderform.auditStatus==1">
				<form method="post" action="order!checkapplyrefund.action" id="checkform">
				<input type="hidden" name="id" value="${orderform.id}" />
				<input type="hidden" name="allow" value="true" id="allow"/>
				<table class="table table-bordered dr-table-default" id="return_container" align="center">
					<tbody>
						<tr>
							<th class="tdll">审核备注</th>
							<td><textarea rows="5" cols="40" name="checkRemark">${checkrecord.checkRemark}</textarea></td>
						</tr>
						<tr>
							<td class="tdll"></td>
							<td><input name="Submit32" class="operation_btu1" value="审核通过"
								type="submit"/> 
								<input name="Submit32" class="operation_btu1"
								value="审核不通过" type="button" onclick="$('#allow').val('false');$('#checkform').submit();" />
							</td>
						</tr>
					</tbody>
				</table>
				</form>
				</s:if>-->                    
				</div>
			</div>
		</div>
		</s:if>
		<s:elseif test="orderformDTO.status==1">
		<form method="post" action="order!savepayment.action">
		<s:if test="curTenantID==null">
		<%if(!SpringSecurityUtils.getCurrentUserName().equals("anonymousUser")){%>
		<button class="btn btn-primary" type="button" name="Submit32" onclick="$('#wait_container').toggle();$('#realPrice').get(0).focus();">线下支付</button>
		<%} %>
		</s:if>
		<button class="btn btn-default" type="button" name="Submit32" onclick="window.close()">
		<span class="glyphicon glyphicon-remove-circle"></span>关闭
		</button>
		<input type="hidden" name="id" value="${orderformDTO.id}" />
		<div class="panel panel-default" id="wait_container" style="display:none;">
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default" align="center">
					<tbody>
						<tr>
							<th class="tdll">支付方式</th>
							<td>线下支付</td>
						</tr>
						<tr>
							<th class="tdll">支付渠道</th>
							<td>
							<s:select list="#{'现场缴费':2,'银行汇款':1}" listKey="value" name="paysource" listValue="key" theme="simple" value="orderformDTO.payType"></s:select>
							</td>
						</tr>
						<tr>
							<th class="tdll">支付金额</th>
							<td>
							<input type="text" name="realPrice" id="realPrice" value="${orderformDTO.needPrice }"></input></td>
						</tr>
						<tr>
							<th class="tdll">备注</th>
							<td><textarea rows="5" cols="40" id="remark" name="remark">${orderformDTO.remark }</textarea></td>
						</tr>
						<tr>
							<td class="tdll"></td>
							<td>
							<button class="btn btn-primary" type="submit" name="Submit32" onclick="return checksubmit();">确认支付</button>
							<button class="btn btn-default" type="button" name="Submit32" onclick="$('#wait_container').toggle();">
							<span class="glyphicon glyphicon-remove-circle"></span>取 消
							</button>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
		</div>
		</form>
		</s:elseif>
		<s:elseif test="orderformDTO.status==6&&orderformDTO.payType==2">
		<div class="panel panel-default">
        	<div class="panel-heading">
			<h3 class="panel-title">退单信息</h3>
			</div>
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default">                       
					<tbody>
						<tr>
							<th class="tdll" style="border:none">退单详细情况</th>
							<td style="border:none">${orderformDTO.rollbackRemark}</td>
						</tr>
					</tbody>
				</table>                    
				</div>
			</div>
		</div>
		</s:elseif>
		<s:elseif test="status==2">
		<form method="post" action="order!delay.action">
		<s:if test="curTenantID==null">
		<button class="btn btn-primary" type="button" name="Submit32" onclick="$('#delay_container').toggle();$('#delayDay').get(0).focus();">延长有效期</button>
		</s:if>
		<button class="btn btn-default" type="button" name="Submit32" onclick="window.close()">
		<span class="glyphicon glyphicon-remove-circle"></span>关闭
		</button>
		<input type="hidden" name="id" value="${orderformDTO.id}" />
		<div class="panel panel-default" id="delay_container" style="display:none;">
			<div class="panel-body row">
				<div class="col-md-12">
				<table class="table table-bordered dr-table-default" align="center">
					<tbody>
						<tr>
							<th class="tdll">延长天数</th>
							<td>
							<input type="text" name="delayDay" id="delayDay" value=""></input></td>
						</tr>
						<tr>
							<td class="tdll"></td>
							<td>
							<button class="btn btn-primary" type="submit" name="Submit32" onclick="return checksubmit();">确认延长</button>
							<button class="btn btn-default" type="button" name="Submit32" onclick="$('#delay_container').toggle();">
							<span class="glyphicon glyphicon-remove-circle"></span>取 消
							</button>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
		</div>
		</form>
		</s:elseif>
	</div>
	</section>
</div>
<!-- container end -->
<!--footer start-->
    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
    	<jsp:param value="index" name="menu"/>
    	</jsp:include>
<!--footer over-->
</body>
</html>
