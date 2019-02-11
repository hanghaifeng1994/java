<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考场安排<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else>-安徽省专业技术人员继续教育在线</s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
	$(document).ready(function() {
		if($("#success").text()!="") $("#div-success").show();
	    if($("#error").text()!="") $("#div-error").show();   
			 
	   $("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
	        }else {
	          $("input[name='ids']").removeAttr("checked");
	         }
	   });
	  //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
		   function(){
			   var oaction = document.getElementById("mainForm").action;
			   document.getElementById("mainForm").action="${ctx }/focus/manage/arrangetest!batchDelete.action";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       } 
	    	   b_confirm('您确定要进行此操作吗?', function() {
					$("#mainForm").submit();
					document.getElementById("mainForm").action = oaction;
	    	   });
		 }); 		
	 });
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
	 }	 
 	function delPhase(id){
 		var oaction = document.getElementById("mainForm").action;
 		document.getElementById("mainForm").action="${ctx }/focus/manage/arrangetest!delete.action?id="+id;
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
	   	});
 	}
 	function addTest(batchId){
 		window.location="arrangetest!input.action?batchId="+batchId
 	}
 	function closemain(){
 		window.close();
 	}
</script>

</head>
<body>
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--正文开始-->
	<div class="dr-wrapper">
		<section id="main" role="main">
		<div class="dr-container-fluid">
			<div class="dr-page-header">
				<h3>
					<label style="margin-right: 10px;">考场安排</label>
				</h3>
			</div>
			<hr></hr>
			<div class="tab-content dr-tabs-panel">
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

				<div class="panel panel-default">
					<div class="btn-toolbar dr-btn-toolbar">
						<button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
							<span class="glyphicon glyphicon-trash"></span> 批量删除
						</button>
						<button class="btn btn-primary btn-sm" type="button" align="right" onclick="addTest('${batchId}')">
							<span class="glyphicon glyphicon-plus"></span> 新增考场
						</button>
					</div>
					<form name="mainForm" id="mainForm" action="arrangetest.action?batchId=${batchId}" method="post">
						<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
						<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
						<input type="hidden" name="page.order" id="order" value="${page.order}" />
						<table class="table table-bordered dr-table-default">
							<tr>
								<th width="5%"><input type="checkbox" id="checkboxall" /></th>
								<th width="20%">考次名称</th>
								<th>考场名称</th>
								<th>时间开始</th>
								<th>时间结束</th>
								<th>操作</th>
							</tr>
							<s:iterator value="page.result" status="stat">
								<tr>
									<td><input type="checkbox" name="ids" value="${id}" /></td>
									<td>${userFocusBatch.batchName}</td>
									<td>${userFocusResource.resName}</td>
									<td><s:date name="startTime" format="yyyy.MM.dd HH:mm" /></td>
									<td><s:date name="endTime" format="yyyy.MM.dd HH:mm" /></td>
									<td><a href="${ctx}/focus/manage/arrangetest!input.action?batchId=${batchId}&id=${id}" class="btn btn-primary btn-sm"> <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
										<div class="btn-group">
											<button name="Submit2" class="btn btn-default btn-sm" type="button" onclick="delPhase('${id}')">
												<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
											</button>
										</div>
									</td>
								</tr>
							</s:iterator>
						</table>
					</form>
					<%@ include file="/common/turnpage.jsp"%>
				</div>
				<div class="">
					<div class="row">
						<div class="col-md-offset-6 col-md-6">
							<div class="btn-group">
								<button class="btn btn-default btn-sm" type="button" onclick="closemain()">
									<span class="glyphicon glyphicon-remove"></span>关闭
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		</section>
	</div>
	<!--footer start-->
	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
		<jsp:param value="index" name="menu" />
	</jsp:include>
	<!--footer over-->
</body>
</html>