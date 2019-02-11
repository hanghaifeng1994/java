<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单汇总<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"><!--   
function idcardcheck(){
    var idcard = $.trim($("#idcard").val());
    var checkidcard=idCardNoUtil.checkIdCardNo(idcard);
    if(idcard!=""){
        if(!checkidcard)  
          {  
        	b_alert("身份证输入不合法");  
              return  false;  
           } 
        } 
	}

$(document).ready(function(){
	//$("#creatTime01").datepick({dateFormat: 'yy-mm-dd'});
	//$("#creatTime02").datepick({dateFormat: 'yy-mm-dd'});
	//$("#upopTime01").datepick({dateFormat: 'yy-mm-dd'});
	//$("#upopTime02").datepick({dateFormat: 'yy-mm-dd'});

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
    $("#upopTime01").datetimepicker({
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
   $("#upopTime02").datetimepicker({
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

   //if(${export}){
  	   //$('#exportbut').hide();
  	//   $('#exportspan').html = '<input name="Submit2" type="button" class="operation_btu1 export mr5" style="width: 75px;margin-top: 5px" value="导     出" id="exportbut"/>';
  	 //  checkover();
  //  }
   if(${export}){
	   $('#exportbut').hide();
	   checkover();
   }
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



//function exportexcel(){
//	$.ajax({
//        type: "POST",
//        url: "order!isFinishExport.action",
//        data: {
//        	"export": true,
//		},
//		dataType:"json" ,
//        success: function(data) {
//			 if(data.value=="true"){
//				 $('#font').show();
//				 $('#downLoad').hide();
//				 //$('#exportbut').hide();
//				 $('#export').val('true');
//				 document.mainForm.submit();
//				 $('#export').val('false');
//			 }else{
//				 alert("此刻有其他用户正在导出，请稍后再试！");
//		     } 
//        }
//	});
//}

//function checkover(){
//$.ajax({
//    type: "POST",
//    url: "order!isFinishExport.action",
//    data: {
//    	"export": true,
//	},
//	dataType:"json" ,
//    success: function(data) {
//		 if(data.value=="true"){
//			 $('#downLoad').show();
//			 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
//			 $('#font').hide();
//			 //$('#exportbut').show();
//			 $('#exportspan').html = '<input name="Submit2" type="button" class="operation_btu1 export mr5" style="width: 75px;margin-top: 5px" value="导     出" id="exportbut" onclick="exportexcel()" />';
//		 }else{
//			 setTimeout('checkover()',3000);
//	     } 
//   }
//});
//}
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
	<jsp:param value="sumlist" name="menu" />
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
		<li class="active"><span>订单汇总</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>订单汇总<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    
    
    
    <!--<ul class="nav nav-tabs nav-justified">
    	<s:if test="CurTenantID==null">
	 	<li class="<s:if test='isOther!="other"'>active</s:if><s:else></s:else>" ><a href="order.action">大平台订单</a></li>
	 	</s:if>
	    <li class="<s:if test='isOther=="other"'>active</s:if><s:else></s:else>"><a href="order.action?isOther=other">租户订单</a></li>
	</ul>
    -->
    <div class="tab-content dr-tabs-panel">
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="order!sumlist.action" method="post" >
			<input type="hidden" name="page.pageNo" id="pageNo"	value="${page.pageNo}" />
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<input type="hidden" name="page.order" id="order" value="${page.order}" />			
			<input type="hidden" name="isOther" value="${isOther}" id="isOther"/>
			<input type="hidden" name="export" value="false" id="export"/>
			
			
			<div class="form-group">
			<label>完成时间</label>
			<input name="filter_GED_upopTime" id="upopTime01" style="width: 90px" value="${filter_GED_upopTime}" class="form-control input-sm"/>
			- 
			<input name="filter_LED_upopTime" id="upopTime02" value="${filter_LED_upopTime}" style="width: 90px" class="form-control input-sm"/>
			</div>
			
			<div class="form-group">
			<button class="btn btn-default btn-sm"  name="Submit5" onclick="$('#export').val('false');$('#pageNo').val('1');document.mainForm.submit()">
			<span class="glyphicon glyphicon-search"></span>
			 搜索
			</button>
			</div><!--
			<div class="form-group" id="exportspan">
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" id="exportbut" onclick="exportexcel()" >
			<span class="glyphicon glyphicon-export"></span>
			 导出
			</button>
			</div>
			--></form>
		</div>
    <!--搜索模块end-->
    <!--订单汇总-->
    <form name="deleteForm" id="deleteForm" action="order!delete.action" method="post">
    	<div class="panel panel-default">
	    	
			<!--<div class="panel-heading">
		        <div class="panel-toolbar dr-slash-text small">
		        <span>总订单数：<font style="color: #11B1CD;">${allCount}</font></span>
		        <span>待付订单数：<font style="color: #11B1CD;">${waitCount}</font></span>
		        <span>完成订单数：<font style="color: #11B1CD;">${finishedCount}</font></span>
		        <span>失效订单数：<font style="color: #11B1CD;">${novaildCount}</font></span>
		        <span>已退订单数：<font style="color: #11B1CD;">${refundCount}</font></span>
		        </div>
		    </div>
		    <div class="panel-heading">
		   		<div class="panel-toolbar dr-slash-text small">
		        <span>总金额：<font style="color: #11B1CD;">${sumprice} 元</font></span>
		        <span>线上总额：<font style="color: #11B1CD;">${onlineprice} 元</font></span>
		        <span>线下总额：<font style="color: #11B1CD;">${offlineprice} 元</font></span>
		        </div>
		    </div>
			-->
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="6%" >来源</th>
					<th width="10%" >订单汇总类</th>
					<th width="9%" >完成订单数</th>
					<th width="9%" >待付订单数</th>
					<th width="9%" >失效订单数</th>
					<th width="9%" >已退订单数</th>
					<th width="9%" >总订单数</th>
					<th width="13%" >线上完成总金额(元)</th>
					<th width="13%" >线下完成总金额(元)</th>
					<th width="13%" >完成总金额(元)</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="orderlist" status="stat">
					<s:if test="currentTenant!=null">
					<s:if test="#stat.index>=3&&#stat.index<=5">
					<tr>
					<s:if test="#stat.index==3">
						<td class="white_bg" rowspan="3" style="vertical-align:middle;">&nbsp;${source}</td>
					</s:if>
					<s:if test="#stat.index==6">
						<td class="white_bg" style="vertical-align:middle;">&nbsp;${source}</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${name}</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${finishedCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${waitCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${novaildCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${refundCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${allCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${onlineprice }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${offlineprice }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${sumprice }</td>
					</s:if>
					<s:else>
						<td class="white_bg">&nbsp;${name}</td>
						<td class="white_bg">&nbsp;${finishedCount }</td>
						<td class="white_bg">&nbsp;${waitCount }</td>
						<td class="white_bg">&nbsp;${novaildCount }</td>
						<td class="white_bg">&nbsp;${refundCount }</td>
						<td class="white_bg">&nbsp;${allCount }</td>
						<td class="white_bg">&nbsp;${onlineprice }</td>
						<td class="white_bg">&nbsp;${offlineprice }</td>
						<td class="white_bg">&nbsp;${sumprice }</td>
					</s:else>
					<s:if test="#stat.index==6">
						<td class="white_bg" style="vertical-align:middle;">&nbsp;${source}</td>
					</s:if>
					</tr>
					</s:if>
					</s:if>
					<s:else>
					<tr>
					<s:if test="#stat.index==3||#stat.index==0">
						<td class="white_bg" rowspan="3" style="vertical-align:middle;">&nbsp;${source}</td>
					</s:if>
					<s:if test="#stat.index==6">
						<td class="white_bg" style="vertical-align:middle;">&nbsp;${source}</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${name}</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${finishedCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${waitCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${novaildCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${refundCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;${allCount }</td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;<fmt:formatNumber type="number" value="${onlineprice }"  minFractionDigits="2"/></td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;<fmt:formatNumber type="number" value="${offlineprice }"  minFractionDigits="2"/></td>
						<td class="white_bg" style="font-weight:bold;">&nbsp;<fmt:formatNumber type="number" value="${sumprice }"  minFractionDigits="2"/></td>
					</s:if>
					<s:else>
						<td class="white_bg">&nbsp;${name}</td>
						<td class="white_bg">&nbsp;${finishedCount }</td>
						<td class="white_bg">&nbsp;${waitCount }</td>
						<td class="white_bg">&nbsp;${novaildCount }</td>
						<td class="white_bg">&nbsp;${refundCount }</td>
						<td class="white_bg">&nbsp;${allCount }</td>
						<td class="white_bg">&nbsp;<fmt:formatNumber type="number" value="${onlineprice }"  minFractionDigits="2"/></td>
						<td class="white_bg">&nbsp;<fmt:formatNumber type="number" value="${offlineprice }"  minFractionDigits="2"/></td>
						<td class="white_bg">&nbsp;<fmt:formatNumber type="number" value="${sumprice }"  minFractionDigits="2"/></td>
					</s:else>
					
					</s:else>
					</s:iterator>
				</tbody>
			</table>
			<!--<%@ include file="/common/turnpage.jsp"%>-->
			</div>
			</form>
		
    <!--订单汇总end-->
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
</html>