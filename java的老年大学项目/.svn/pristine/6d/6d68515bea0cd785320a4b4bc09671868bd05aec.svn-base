<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>集体订单管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script type="text/javascript" language="javascript">   
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
	//$("#creatTime01").datepick({dateFormat: 'yy-mm-dd'});
	//$("#creatTime02").datepick({dateFormat: 'yy-mm-dd'});
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
})
</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="teamlist" name="menu" />
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
		<li class="active"><span>集体订单管理</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>集体订单管理<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    
    
    <ul class="nav nav-tabs nav-justified">
    	<s:if test="CurTenantID==null">
	 	<li class="<s:if test='isOther!="other"'>active</s:if><s:else></s:else>" ><a href="order!teamlist.action">大平台订单</a></li>
	 	</s:if>
	    <li class="<s:if test='isOther=="other"'>active</s:if><s:else></s:else>"><a href="order!teamlist.action?isOther=other">租户订单</a></li>
	</ul>
	
	<div class="tab-content dr-tabs-panel">
    
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="order!teamlist.action" method="post">
			<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<input type="hidden" name="isOther" value="${isOther}" id="isOther"/>			
			<s:if test="CurTenantID==null&&isOther=='other'">
					<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"
					value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
			</s:if>
			<div class="form-group">
				<label>姓名</label>
				<input class="form-control input-sm" type="text" name="filter_LIKES_studentName" value="${param['filter_LIKES_studentName']}"/>
			</div>
			<div class="form-group">
				<label>身份证号</label>
				<input class="form-control input-sm" type="text" id="idcard" onchange="idcardcheck()" name="filter_EQS_idcard" value="${param['filter_EQS_idcard']}"/>
			</div>
			<div class="form-group">
				<label>订单号</label>
				<input class="form-control input-sm" type="text" name="filter_EQS_sn" value="${param['filter_EQS_sn']}"/>
			</div>
			<div class="form-group">
				<label>订单名称</label>
				<input class="form-control input-sm" type="text" name="filter_LIKES_name" value="${param['filter_LIKES_name']}"/>
			</div>
			<div class="form-group">
			<label>金额</label>
			<input style="width:80px" class="form-control input-sm" type="text" name="filter_GEN_realPrice" value="${param['filter_GEN_realPrice']}"/>
			-
			<input style="width:80px" class="form-control input-sm" type="text" name="filter_LEN_realPrice" value="${param['filter_LEN_realPrice']}"/>
			</div>
			<div class="form-group">
			<label>时间</label>
			<input name="filter_GED_createTime" id="creatTime01" style="width: 90px" value="${filter_GED_createTime}" class="form-control input-sm"/>
			- 
			<input name="filter_LED_createTime" id="creatTime02" value="${filter_LED_createTime}" style="width: 90px" class="form-control input-sm"/>
			</div>
			<div class="form-group">
			<label>订单状态</label>
			<s:select list="#{'待付':1,'完成':3,'退单':6}" listKey="value" theme="simple" 
					  listValue="key" headerValue="所有" 	headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_status)"
					  name="filter_EQI_status" cssClass="form-control input-sm" >
			</s:select>
			</div>
			<div class="form-group">
			<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();" name="Submit5">
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
			<div class="panel-heading">
		        <div class="panel-toolbar dr-slash-text small">
		        <span>总订单数：<font style="color: #11B1CD;">${allCount}</font></span>
		        <span>待付订单数：<font style="color: #11B1CD;">${waitCount}</font></span>
		        <span>完成订单数：<font style="color: #11B1CD;">${finishedCount}</font></span>
		        <span>已退订单数：<font style="color: #11B1CD;">${refundCount}</font></span>
		        <span>完成总金额：<font style="color: #11B1CD;">${sumprice} 元</font></span>
		        </div>
		    </div>
		    
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="13%" class="tt_line">订单号</th>
					<th width="30%" class="tt_line">订单名称</th>
					<th width="10%" class="tt_line">金额(元)</th>
					<th width="10%" class="tt_line">下单人</th>
					<th width="13%" class="tt_line">下单时间</th>
					<th width="15%" class="tt_line">状态</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
					<tr>
						<td class="white_bg"><a href="order!info.action?id=${id }"  target="_blank" >${sn}</a></td>
						<td class="white_bg">${name}</td>
						<td class="white_bg">${realPrice}</td>
						<td class="white_bg">${user.name }</td>
						<td class="white_bg"><s:date name="createTime" format="yyyy.MM.dd HH:mm:ss" /></td>
						<td class="white_bg"><a href="order!info.action?id=${id }" target="_blank">${statusdesc}</a></td>
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
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
	</section>
</div>
<!-- container end -->

</body>