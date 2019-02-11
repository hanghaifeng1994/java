<!--<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else>安徽省专业技术人员继续教育在线</s:else></title>
</head>
<%@ include file="/common/admin_meta.jsp" %>
<body>
<s:iterator value="tutorCheckVOs" status="stat">
${userDTO.name}
</s:iterator>
</body>
</html>-->
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
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>

<script type="text/javascript">
function checksel(){
	if(checkSelect()==false)
	{
		$('#div-error2').show();
		$('#error2').text('至少选择一个辅导老师');
	}else $('#dataForm').submit();
}
function checkSelect() {
	var flag = false;
	$("input[name='tutorId']:checked").each(function(){
		flag = true;
	}); 
	return flag;
}
</script>
</head>

<body>
     <div class="dr-page-header">
       <h3>分配辅导老师</h3>
     </div>
     <hr/>
<!--信息提示-->
<div class="alert alert-danger alert-dismissable" id="div-error2" style="display: none">
<span id="error2"></span>
</div>
<!--信息提示 end-->
<form id="dataForm"	action="clazz!saveTutors.action"	method="post">
  <input type="hidden" name="clazzCourseId"	value="${clazzCourseId}"/>
    <input type="hidden" name="id"	value="${id}"/>
  <s:set name="page" value="page3" scope="request"></s:set> 
  <div class="panel panel-default">
<s:if test="tutorCheckVOs.size>0">
  <table class="table table-bordered dr-table-bordered">
   <thead>
	 <tr>
		<th width="10%" class="tt_noline"></th>
		<th width="10%">用户名</th>
		<th width="10%">姓名</th>				
	 </tr>
	</thead>
<tbody>
<s:iterator value="tutorCheckVOs" status="stat">
		<tr>
			<td>
				<input type="radio" <s:if test='checked'>checked="checked" </s:if>  name="tutorId" value="${userDTO.id}" />
			
			</td>
			<td>${userDTO.username}</td>	
			<td>${userDTO.name}</td>			
		</tr>
	</s:iterator>
</tbody>
</table>
<div class="dr-panel-footer">
  <div class="row">
  <div class="text-center">
    		<input type="hidden" value="1" name="courseprop"></input>
        <button class="btn btn-primary" type="button" name="Submit32" onclick="return checksel();">
          <span class="glyphicon glyphicon-ok"></span>
                         确认添加
        </button> 
  </div>
  </div>
</div>
	</s:if><s:else>
	<div class="alert alert-success alert-dismissable" id="div-success">
	<span id="success">该课程没有课程辅导老师，请到课程属性中添加！</span>
	</div>
	</s:else>
</div>
</form>

</body>
</html>
