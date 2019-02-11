<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script>
	function effectStudent(id){
		var oaction = document.getElementById("mainForm").action;
		document.getElementById("mainForm").action="${ctx }/clazz/manage/clazz!effectStudent.action?clazzCourseId="+id;
	    b_confirm('您确定要进行此操作吗?', function() {
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
	   	});
	}
</script>
</head>
<body>
<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
	<div class="panel-heading">
		<h3 class="panel-title">已删除班课记录</h3>
	</div>
	<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="clazz!deleteClassCourse.action" method="post" >
	<input type="hidden" name="deleteClassCoursePage.pageNo" id="pageNo" value="${deleteClassCoursePage.pageNo}" />
	<input type="hidden" name="deleteClassCoursePage.orderBy" id="orderBy" value="${deleteClassCoursePage.orderBy}" /> 
	<input type="hidden" name="deleteClassCoursePage.order" id="order" value="${deleteClassCoursePage.order}" />
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="programId" value="${programId}" />
	<table  class="table table-bordered dr-table-bordered" style="width:98%;">
		<thead>
		<tr>
			<th >课程名称</th>
			<th >模块属性</th>
			<th >课程属性</th>
			<th >学时</th>
			<th >操作</th>
		</tr>
	  	</thead>
	  	<tbody>
	  	<s:iterator value="deleteClassCoursePage.result" status="stat">
			<tr>
				<td>&nbsp;${course.name}</td>
				<td>&nbsp;${course.courseModelString}</td>
				<td>&nbsp;${coursePropString}</td>
				<td>&nbsp;${course.studylength }</td>
				<td>
				<div class="btn-group">
						<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="effectStudent('${id}')">
		                <span class="glyphicon glyphicon-trash"></span>&nbsp;影响现有学员
		           		</button>
				</div>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<s:set name="page" value="deleteClassCoursePage" scope="request"></s:set>
	<%@ include file="/common/turnpage.jsp"%>
</form>
</div>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/js/table.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/js/related.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-modalmanager.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-modal.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-mymodal.js"></script>
</body>
</html>