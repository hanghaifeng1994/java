<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include
		file="/common/title.jsp"%></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">  
$(document).ready(function(){
	$.ajaxSetup({
		  async: false
	});
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   
	 
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }
		   else{
		   $("input[name='ids']").removeAttr("checked");
			   } 
	   });
	
	 function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
	 $("#batchPubDown").click(
		   function(){
			   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/news/manage/noticetenant!pub.action?isMy=${isMy}&issignup=true";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       } 
		       b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	   	   		});
		}); 
    $("#batchCancelPubDown").click(
 		   function(){
 			   var oaction = document.getElementById("deleteForm").action;
 			   document.getElementById("deleteForm").action="${ctx }/news/manage/noticetenant!cancelPub.action?isMy=${isMy}&issignup=true";
 		       if(!checkSelect()) {
 		            b_alert("没有可操作记录,请勾选");
 		            return false;
 		       } 
 		       b_confirm('您确定要进行此操作吗?', function() {
 					$("#deleteForm").submit();
 					document.getElementById("deleteForm").action = oaction;
 	   	   		});
 	}); 
		
 });
</script>
</head>

<body>
<!-- navbar start -->
<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
</jsp:include>
<!-- navbar end -->

<!-- container start -->
<div class="dr-wrapper"><!-- sidebar start --> <jsp:include
	page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="notice" name="menu" />
	<jsp:param value="message" name="bigmenu" />
</jsp:include> <!-- sidebar end --> <section id="main" role="main">
<div class="dr-container-fluid"><!--breadcrumb-->
<ol class="dr-breadcrumb" style="">
	<li><span class="glyphicon glyphicon-home"></span> <a
		href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
	</li>
	<li><a href="#">信息发布管理</a></li>
	<li class="active"><span>公告管理</span></li>
</ol>
<!--/breadcrumb--> <!--页面标题-->
<div class="dr-page-header">
<h3>公告管理<small>&nbsp;</small></h3>
</div>
<hr></hr>
<!--页面标题end--> <!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success"
	style="display: none">
<button class="close" type="button" data-dismiss="alert"
	aria-hidden="true">×</button>
<span id="success"><s:actionmessage theme="simple" /></span></div>
<div class="alert alert-danger alert-dismissable" id="div-error"
	style="display: none">
<button class="close" type="button" data-dismiss="alert"
	aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple" /></span></div>
<!--信息提示 end-->
<ul class="nav nav-tabs nav-justified">
	<li class="<s:if test='isMy'>active</s:if><s:else></s:else>"><a
		href="notice.action?isMy=true">我的公告</a></li>
	<li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a
		href="${ctx}//news/manage/noticetenant.action?isMy=false&issignup=true">下发的公告</a></li>
</ul>
<div class="tab-content dr-tabs-panel"><!--表单模块-->
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm"
	action="noticetenant.action" method="post"><input type="hidden"
	name="page.pageNo" id="pageNo" value="1" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" /> <input
	type="hidden" name="isMy" id="isMy" value="${isMy}" /> <input
	type="hidden" name="issignup" id="issignup" value="${issignup}" />
</form>
<!--表单模块end-->
 <!--订单列表-->
<form name="deleteForm" id="deleteForm" action="noticetenant.action"
	method="post" class="form-inline dr-form-inline"><input
	type="hidden" name="isMy" id="isMy" value="${isMy}" />
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<div class="btn-group btn-group-sm">
<button name="Submit2" class="btn btn-primary btn-sm" type="button"
	id="batchPubDown"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;发布
</button>
</div>
<div class="btn-group btn-group-sm">
<button name="Submit2" class="btn btn-default btn-sm" type="button"
	id="batchCancelPubDown"><span 
	class="glyphicon glyphicon-bullhorn"></span>&nbsp;取消发布</button>
</div>
</div>
<table class="table table-bordered dr-table-bordered">
	<thead>
		<tr>
			<td><input type="checkbox" id="checkboxall" /></td>
			<th>标题</th>
			<th>来自于</th>
			<th>发布日期</th>
			<th>是否置顶</th>
			<th>是否发布</th>
			<th>是否重要</th>
			<th>是否下发</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="page.result" status="stat">
			<tr>
				<td class="white_bg"><input type="checkbox" name="ids" id="ids"
					value="${id}" /></td>
				<td title="${notice.title}" class="white_bg"><common:cut
					len="30" string="${notice.title}" /></td>
				<td title="${notice.tenantName}" class="white_bg">${notice.tenantName}
				</td>
				<td class="white_bg"><s:date name="notice.createTime"
					format="yyyy.MM.dd" /></td>
				<td title="${notice.topStr}" class="white_bg"><common:cut
					len="30" string="${notice.topStr}" /></td>
				<td title="${publishStr}" class="white_bg"><common:cut len="30"
					string="${publishStr}" /></td>
				<td title="${notice.importantStr}" class="white_bg"><common:cut
					len="30" string="${notice.importantStr}" /></td>
				<td><s:if test="notice.issignup">已下发</s:if> <s:else>未下发</s:else></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<%@ include file="/common/turnpage.jsp"%></div>
</form>
</div>
<!--订单列表end--></div>
<!--footer start--> <jsp:include
	page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="index" name="menu" />
</jsp:include> <!--footer over--> </section></div>
<!-- container end -->
</body>
</html>