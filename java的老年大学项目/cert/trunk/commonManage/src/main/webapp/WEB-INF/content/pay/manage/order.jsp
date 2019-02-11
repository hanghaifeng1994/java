<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>核销管理订单<%@ include file="/common/title.jsp" %></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
	 $("#creatTime01").datetimepicker({
		 customFormat: "yyyy-mm-dd hh:ii:ss",
		 format: "yyyy-mm-dd 00:00:00",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	}); 
    $("#creatTime02").datetimepicker({
    	 customFormat: "yyyy-mm-dd hh:ii:ss",
		 format: "yyyy-mm-dd 23:59:59",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	 }); 
    $("#createTime01").datetimepicker({
    	 customFormat: "yyyy-mm-dd hh:ii:ss",
		 format: "yyyy-mm-dd 00:00:00",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	}); 
   $("#createTime02").datetimepicker({
	   	 customFormat: "yyyy-mm-dd hh:ii:ss",
		 format: "yyyy-mm-dd 23:59:59",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	 }); 
	 
   /* if(${export}){
	   $('#exportbut').hide();
	   checkover();
   } */
}) 

	function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
	function checkover(){
		$.ajax({
	        type: "POST",
	        url: "order!isFinishExportNew.action",
	        data: {
	        	"threadName": '${threadName}',"fileName":'${fileName}'
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.value=="false"){
					 $('#downLoad').show();
					 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
					 $('#font').hide();
					 $('#exportbut').show();
				 }else{
					 setTimeout('checkover()',3000);
			     } 
	        }
		});
	}


</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="orderlist" name="menu" />
	<jsp:param value="order" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
		</li>
		<li>
		<a href="#">支付结算管理</a>
		</li>
		<li class="active"><span>核销订单管理</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>核销订单管理<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    
	 
    <div class="tab-content dr-tabs-panel">
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="order.action" method="post" >
			<input type="hidden" name="page.pageNo" id="pageNo"	value="${page.pageNo}" />
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<input type="hidden" name="page.order" id="order" value="${page.order}" />			
			<input type="hidden" name="export" value="false" id="export"/>
			<%-- <div class="form-group">
				<label>姓名</label>
				<input class="form-control input-sm" type="text" name="filter_LIKES_userName" value="${param['filter_LIKES_studentName']}"/>
			</div> --%>
			<div class="form-group">
				<label>导购姓名</label>
				<input class="form-control input-sm" type="text" name="filter_LIKES_dgName" value="${param['filter_LIKES_dgName']}"/>
			</div>
			<div class="form-group">
				<label>用户姓名</label>
				<input class="form-control input-sm" type="text" name="filter_LIKES_userName" value="${param['filter_LIKES_userName']}"/>
			</div>
			<div class="form-group">
				<label>订单号</label>
				<input class="form-control input-sm" type="text" name="filter_EQS_orderNo" value="${param['filter_EQS_orderNo']}"/>
			</div>
			<div class="form-group">
			<label>订单状态</label>
			<s:select list="#{'待核销':0,'核销中':1,'已核销':2,'已完成':3,'已失效':9}" listKey="value" theme="simple" 
					  listValue="key" headerValue="所有" 	headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_status)"
					  name="filter_EQI_status" cssClass="form-control input-sm">
			</s:select>
			</div>
			<div class="form-group">
			<label>佣金状态</label>
			<s:select list="#{'未发放':0,'已发放':1}" listKey="value" theme="simple" 
					  listValue="key" headerValue="所有" 	headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_commisionStatus)"
					  name="filter_EQI_commisionStatus" cssClass="form-control input-sm">
			</s:select>
			</div>
			<div class="form-group">
			<label>订单时间</label>	
			<input name="filter_GED_createTime" id="createTime01" style="width: 90px" value="${filter_GED_createTime}" class="form-control input-sm"/>		- 
			<input name="filter_LED_createTime" id="createTime02" value="${filter_LED_createTime}" style="width: 90px" class="form-control input-sm"/>
			</div>
			<div class="form-group">
			<button class="btn btn-default btn-sm"  name="Submit5" onclick="$('#export').val('false');$('#pageNo').val('1');document.mainForm.submit()">
			<span class="glyphicon glyphicon-search"></span>
			 搜索
			</button>
			</div>
			</form>
		</div>
    <!--搜索模块end-->
    <!--订单列表-->
    <form name="deleteForm" id="deleteForm" action="order!delete.action" method="post">
    	<div class="panel panel-default">
	    	<div class="btn-toolbar dr-btn-toolbar" style="display:none;">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">订单导出excel文件下载</a>
				</label>
			    </span>
		   </div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="10%" >订单号</th>
					<th width="10%" >导购姓名</th>
					<th width="10%" >用户姓名</th>
					<th width="8%" >原总金额</th>
					<th width="8%" >核销总金额</th>
					<th width="8%" >总价优惠金额</th>
					<th width="8%" >优惠码优惠金额</th>
					<th width="8%" >实际总金额</th>
					<th width="8%" >优惠码</th>
					<th width="8%" >订单状态</th>
					<th width="8%" >订单佣金状态</th>
					<th width="10%" >订单时间</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
					<tr>
						<td class="white_bg"><a href="order!info.action?id=${orderformId }" target="_blank">${orderNo}</a></td>
						<td class="white_bg">${dgName }</td>
						<td class="white_bg">${userName}</td>
						<td><fmt:formatNumber type="number" value="${totalPrice}"  minFractionDigits="2"/></td>
						<td><fmt:formatNumber type="number" value="${checkTotalPrice}"  minFractionDigits="2"/></td>
						<td><fmt:formatNumber type="number" value="${checkCouponPrice}"  minFractionDigits="2"/></td>
						<td><fmt:formatNumber type="number" value="${couponTotalPrice}"  minFractionDigits="2"/></td>
						<td><fmt:formatNumber type="number" value="${actTotalPrice}"  minFractionDigits="2"/></td>
						<td class="white_bg">${couponNo}</td>
						<td class="white_bg">${statusStr}</td>
						<td class="white_bg">${commisionStatusStr}</td>
						<td class="white_bg"><s:date name="createTime" format="yyyy.MM.dd HH:mm:ss" /></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
			</div>
			</form>
		
    <!--订单列表end-->
    </div>
	</div>
	<!--footer start-->
	    	<jsp:include page="/common/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
	</section>
</div>
<!-- container end -->

</body>
</html>