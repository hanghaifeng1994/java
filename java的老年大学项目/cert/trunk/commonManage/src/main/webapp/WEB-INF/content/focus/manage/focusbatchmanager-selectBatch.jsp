<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if> <s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/related.js" type="text/javascript"></script>
<script type="text/javascript">
	function saveBatch() {
		var batchId = $("#batchSelect").val();
		$("#batchId").val(batchId);
		selectBatchCallBack();
	}
</script>
</head>

<body>
	<div class="dr-page-header">
		<h3>选择批次</h3>
	</div>
	<hr />
	<form id="mainForm" action="" method="post" class="form-horizontal dr-form-bordered">
		<div class="form-group">
			<label>考试批次</label> <select name="batchSelect" style="width: 300px; height: 30px;" id="batchSelect">
				<c:forEach items="${NPKBatchList}" var="item">
					<option value="${item.id }" pkFlag="${item.focusResult }" <c:if test="${item.id eq param['filter_EQL_userFocusBatch$id'] }">selected="selected"</c:if>>${item.batchName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="panel-footer">
			<div class="row">
				<div class="col-md-offset-4 col-md-8">
					<div class="btn-group">
						<button name="Submit32" class="btn btn-primary btn-sm" type="button" onclick="saveBatch()">
							<span class="glyphicon glyphicon-ok"></span> 确定
						</button>
					</div>
					<div class="btn-group">
						<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='focusexamuser.action'">
							<span class="glyphicon glyphicon-remove"></span> 取消
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
