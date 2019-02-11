<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>集中考试管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		if($("#success").text()!="")$("#div-success").show();
	    if($("#error").text()!="")$("#div-error").show(); 
	   
	   
		$("#pkButton").click(function(){
			var oaction = document.getElementById("mainForm").action;
		    b_confirmx('您确定要进行此操作吗?', function() {
		    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!pkOption.action";
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
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
	<div class="dr-wrapper">
		<!-- sidebar start -->
		<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
			<jsp:param value="focusbatchmanager" name="menu" />
			<jsp:param value="focus" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li><a href="#">集中考试管理</a>
				</li>
				<li class="active"><span>批次检查结果</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					批次检查结果列表<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
				<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
				<span id="success"><s:actionmessage theme="simple" /></span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
				<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
				<span id="error"><s:actionerror theme="simple" /></span>
			</div>
			<!--信息提示 end-->

			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="focusbatchmanager.action" method="post">
				<!--搜索模块-->
					<input type="hidden" name="focusErrorLogPage.pageNo" id="pageNo" value="${focusErrorLogPage.pageNo}" /> 
					<input type="hidden" name="focusErrorLogPage.orderBy" id="orderBy" value="${focusErrorLogPage.orderBy}" /> 
					<input type="hidden" name="focusErrorLogPage.order" id="order" value="${focusErrorLogPage.order}" /> 
					<input type="hidden" name="batchId" id="batchId" value="${batchId}" /> 
				<!--搜索模块end-->
				<div class="panel panel-default">
					<div class="btn-toolbar dr-btn-toolbar">
					<s:if test="kaikao">
						<button class="btn btn-primary btn-sm" type="button" id="pkButton" name="Submit2">
							<span class="glyphicon glyphicon-share-alt"></span> 继续排考
						</button>
					</s:if>
						<a class="btn btn-primary btn-sm" type="button" href="${ctx }/focus/manage/focusbatchmanager.action?batchId=${batchId}">
							<span class="glyphicon glyphicon-asterisk"></span> 返回
						</a>
					</div>
					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<th width="8%">类型</th>
								<th width="90%">内容</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="focusErrorLogPage.result" status="stat">
								<tr>
									<td>${typeStr}</td>
									<td>${content}</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<!-- </form> -->
				</div>
			</form>
			<s:set name="page" value="focusErrorLogPage" scope="request"></s:set>
			<%@ include file="/common/turnpage.jsp"%>
			<!--订单列表end-->
		</div>
		<!--footer start--> <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> <!--footer over--> </section>
	</div>
	<!-- container end -->
</body>
</html>