<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
</head>
<body>
<form id="dataForm" action="${ctx}/train/manage/teachcontent!savestudylength.action" method="post" class="form-inline dr-form-inline">
	<input type="hidden" name="id" value="${id}"></input>
  	<input type="hidden" name="programId" value="${programId}"></input>
  	<input type="hidden" name="teachContentCourseId" value="${teachContentCourseId}"></input> 	
  	<div class="dr-searchbar"> 
  	<div class="form-group">
     <label>课程学时:</label>
       <input  name="studylength" value="${studylength}" class="form-control input-sm" />
     </div>
  	<button class="btn btn-primary btn-sm" type="submit" name="Submit32">
     <span class="glyphicon glyphicon-ok"></span>
      &nbsp;保存
   </button> 
   </div>
</form>
</body>
</html>