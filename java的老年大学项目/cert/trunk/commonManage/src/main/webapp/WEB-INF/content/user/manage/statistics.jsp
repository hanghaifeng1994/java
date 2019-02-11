<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<%@ include file="/common/admin_meta.jsp" %>
<title>用户统计-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
</head>


<body>
<!--正文开始-->
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->

<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="statistics" name="menu" />
	<jsp:param value="student" name="bigmenu" />
    </jsp:include>
   <!--adminLeft结束-->


  <section id="main" role="main"> 
  <div class="dr-container-fluid">

   <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">用户管理</a></li>
     <li class="active">用户统计</li>
   </ol>
   <div class="dr-page-header">
     <h3>用户统计信息</h3>
   </div>
   <hr>

<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table  class="table table-bordered dr-table-default" style="font-size: 14px;">
<tbody>
	<tr>
		<th width="20%" >平台用户数</th>
		<td width="15%" >${userCountNum}人</td>
		<th width="20%" >学员数</th>
		<td width="15%" >${studentCountNum}人</td>
	</tr>
	<tr>
		<th colspan="4" style="text-align: center;">项目分布</th>
	</tr>
	<tr>
		<th colspan="2" >项目名称</th>
		<th colspan="2" >学员数 (人)</th>
	</tr>
	<c:forEach var="item" items="${progarmStudentMap}">
	<tr>
		<th colspan="2" >${item.key}</th>
		<td colspan="2" >${item.value}</td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="4" style="text-align: center;">地区分布</th>
	</tr>
	<tr>
		<th colspan="2">地区</th>
		<th colspan="2">用户数 (人)</th>
	</tr>
	<c:forEach var="item" items="${cityStudentMap}">
	<tr>
		<th colspan="2">${item.key}</th>
		<td colspan="2">${item.value}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>