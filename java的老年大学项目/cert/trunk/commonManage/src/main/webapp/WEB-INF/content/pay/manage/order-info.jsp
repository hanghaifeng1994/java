<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<%@ include file="/common/title.jsp"%></title>
<%@ include file="/common/admin_meta.jsp"%>
<script>
	function checksubmit() {
		if ($("#remark").val() == "") {
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
#return_container td {
	border: none;
}

#wait_container  td {
	border: none;
}
</style>
</head>
<body>
	<!-- navbar start -->
	<jsp:include page="/common/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!-- navbar end -->
	<!-- container start -->
	<div class="dr-wrapper">
		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					订单详细<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--页面标题end-->
			<!-- 信息表格 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">下单信息</h3>
				</div>
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tbody>
								<tr>
									<th width="13%" class="buleleft">用户姓名</th>
									<td>${orderformDTO.userName }</td>
								</tr>
								<tr>
									<th width="13%" class="buleleft">导购姓名</th>
									<td>${orderformDTO.dgName }</td>
								</tr>
								<tr>
									<th class="buleleft">下单时间</th>
									<td>
										<s:date name="orderformDTO.createTime" format="yyyy.MM.dd HH:mm" />
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
									<td>${orderformDTO.orderNo }</td>
								</tr>
								<tr>
									<th class="buleleft">订单状态</th>
									<td>${orderformDTO.statusStr }</td>
								</tr>
								<tr>
									<th class="buleleft">订单佣金状态</th>
									<td>${orderformDTO.commisionStatusStr }</td>
								</tr>
								<tr>
									<th class="buleleft">实际总金额</th>
									<td><fmt:formatNumber type="number" value="${orderformDTO.actTotalPrice}"  minFractionDigits="2"/></td>
								</tr>
								<tr>
									<th class="buleleft">原总金额</th>
									<td><fmt:formatNumber type="number" value="${orderformDTO.totalPrice}"  minFractionDigits="2"/></td>
								</tr>
								<tr>
									<th class="buleleft">核销总金额</th>
									<td><fmt:formatNumber type="number" value="${orderformDTO.checkTotalPrice}"  minFractionDigits="2"/></td>
								</tr>
								<tr>
									<th class="buleleft">总价优惠金额</th>
									<td><fmt:formatNumber type="number" value="${orderformDTO.checkCouponPrice}"  minFractionDigits="2"/></td>
								</tr>
								<tr>
									<th class="buleleft">优惠码优惠金额</th>
									<td><fmt:formatNumber type="number" value="${orderformDTO.couponTotalPrice}"  minFractionDigits="2"/></td>
								</tr>
								<tr>
									<th class="buleleft">优惠码</th>
									<td>${orderformDTO.couponNo }</td>
								</tr>
							</tbody>
						</table>
						<div class="btn-toolbar dr-btn-toolbar"></div>
						<table class="table table-bordered dr-table-bordered">
							<thead>
								<tr>
									<th>商品品牌</th>
									<th>商品分类</th>
									<th>商品数量</th>
									<th>商品价格</th>
									<th>核销价格</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="orderformDTO.details" status="stat" var="product">
									<tr>
										<td>${product.brandName }</td>
										<td>${product.categoryName }</td>
										<td>${product.productNum }</td>
										<td>${product.price }</td>
										<td>${product.actPrice}</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
	<!-- container end -->
	<!--footer start-->
	<jsp:include page="/common/adminFooter.jsp">
		<jsp:param value="index" name="menu" />
	</jsp:include>
	<!--footer over-->
</body>
</html>
