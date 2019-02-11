<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script type="text/javascript">
	$(document).ready(function() {
		$("#genTime").datetimepicker({
	    	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
		}); 
	});
	function genCode(){
		$("#mainForm").attr("action","licensecode!genCode.action");
		$("#mainForm").submit();
	}
	
	function printCode(){
		var resId = $("#resId").val();
		var genTime = $("#genTime").val();
		if(resId==""){
			alert("请选择考场资源!");
			return;
		}
		$("#printBtn").attr("href","licensecode!printCode.action?genTime="+genTime+"&resId="+resId);
		document.getElementById("printBtn").click();
	}
	
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->
 
<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="licensecode" name="menu" />
	<jsp:param value="focus" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li class="active">
<a href="#">授权码管理</a>
</li>
</ol>

<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->

<form id="mainForm" name="mainForm" action="licensecode.action" class="form-inline dr-form-inline" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<div class="dr-searchbar mt10 mb10 ml5 mr5">
	<div class="form-group">
		<label>考试资源</label> <select name="resId" style="width: 200px; height: 30px;" id="resId">
		<option value="">--全部--</option>
			<c:forEach items="${resourseList}" var="item">
				<option value="${item.id }" <c:if test="${item.id eq resId }">selected="selected"</c:if>>${item.resName}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>日期</label>	
		<input name="genTime" id="genTime" style="width: 120px" value="${genTime}" class="form-control input-sm"/>
	</div>
   	<div class="form-group">
      	<label>授权码</label>
      	<input class="form-control input-sm" type="text" style="width: 120px" name="code" id="code" value="${code}"  />
   	</div>  
   	<div class="form-group">
   		<button class="btn btn-default btn-sm" type="submit" onclick="$('#pageNo').val(1);">
		<span class="glyphicon glyphicon-search"></span>
		搜索
		</button>
	</div>
	<div class="form-group">
   		<button class="btn btn-primary btn-sm" type="button" onclick="genCode();">
		<span class="glyphicon glyphicon-ok"></span>
		生成授权码
		</button>
	</div>
	
	<div class="form-group">
		<a href="/index.action" target="_blank" id="printBtn"></a>
   		<button class="btn btn-primary btn-sm" type="button" onclick="printCode();">
		<span class="glyphicon glyphicon-ok"></span>
		打印授权码页面
		</button>
	</div>
</div>

<div class="panel panel-default">
<table class="table table-bordered dr-table-default">
	<tr>
		<th>考场</th>
	    <th>授权码</th>
		<th>时间</th>
	</tr>
		<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg">${resName}</td>
			<td class="white_bg">${code}</td>
			<td class="white_bg">${genTime }</td>
		</tr>
		</s:iterator>

</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
</body>
</html>