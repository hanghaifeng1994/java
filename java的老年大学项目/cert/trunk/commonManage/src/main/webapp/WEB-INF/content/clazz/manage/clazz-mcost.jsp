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
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>
<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
      <div class="dr-page-header">
     <h3>费用结算</h3>
   </div>
   <hr/>
  <div class="panel panel-default">
      <div class="panel-heading">
    <h3 class="panel-title">
       <s:if test='!clazzDTO.selfClass'>集体</s:if><s:else>自主</s:else>报名班级"${clazzDTO.name}"管理
    </h3>
    <div class="panel-toolbar">
       <ul class="nav nav-tabs pull-right">
        <li><a href="clazz!minfo.action?id=${id }<s:if test='!clazzDTO.selfClass'>&flag=group</s:if>" >班级信息</a></li>
        <li><a href="clazz!learningcount.action?id=${id }" >班级学情统计</a></li>
	     <!--<s:if test='!clazz.selfClass'>-->
	     <!--</s:if>-->
	     <li><a href="clazz!mcourse.action?id=${id }">班级课程</a></li>
	     
	    <li><a href="clazz!mstudents.action?id=${id }">班级学员</a></li>
	    <li ><a href="clazz!mmanager.action?id=${id }">班主任任命</a></li>
	    <s:if test='!clazzDTO.selfClass'>
		   <li class="active"><a href="clazz!mcost.action?id=${id }">费用结算</a></li>
	    </s:if>
       </ul>
    </div>    
  </div>
  <div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
<form id="form1" action="clazz!saveclazz.action" method="post">
    <input type="hidden" name="clazz.id" value="${clazzDTO.id}" />
	<input type="hidden" name="id" value="${id}" />
	<table width="98%" align="center" cellspacing="5" class="table table-bordered dr-table-default">
	<tbody>
		<tr>
			<th width="13%">报名人数</th>
			<td>${clazzDTO.allStudentCount }</td>
		</tr>
		<tr>
			<th>学分/人</th>
			<td>${clazzDTO.courseStudyLength }</td>
		</tr>
		<tr>
		<th >费用总计</th>
		<td>${clazzDTO.allStudentCount * clazzDTO.clazzTotalPrice}</td>
		</tr>
		<tr>
			<th>实收款</th>
			<td>${clazzDTO.factPrice}</td>
		</tr>
		<tr>
			<th>折扣</th>
			<td>${clazzDTO.rebate}</td>
		</tr>
		<tr>
			<th>备注</th>
			<td>${clazzDTO.remarks}</td>
		</tr>	
		</tbody>
	</table>
</form>
</div>
</div>
</div>
</section>
</div>

	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>
