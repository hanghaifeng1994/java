<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>项目统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
</head>
<body>
<c:forEach var="name" items="map"></c:forEach>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="programsCount" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
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
<li>
<a href="#">培训项目管理</a>
</li>
<li class="active">项目统计</li>
</ol>

<div class="dr-page-header">
<h3>
项目统计
</h3>
</div>
<hr/>
<form id="mainForm" name="mainForm" action="programs!programsCount.action" method="post">
	<input type="hidden" name="teachPlanPage.pageNo"	id="pageNo" value="1" />
	<input type="hidden" name="teachPlanPage.orderBy" id="orderBy" value="${teachPlanPage.orderBy}"/>
	<input type="hidden" name="teachPlanPage.order" id="order" value="${teachPlanPage.order}"/>
<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
 <table class="table table-bordered dr-table-default">
    <tr>
      <th width="160px">&nbsp;教学计划</th>
      <th width="60px">&nbsp;课程数量</th>
      <th width="130px">&nbsp;班级</th>
      <th width="60px">&nbsp;学员数</th>
      <th width="60px">&nbsp;青年</th>
	  <th width="60px">&nbsp;中年</th>
	  <th width="60px">&nbsp;老年</th>
	  <th width="40px">&nbsp;男</th>   
	  <th width="40px">&nbsp;女</th>    
    </tr>
    
    <s:set  name="page" value="teachPlanPage" scope="request"/>
    <s:iterator value="teachStatisticsVOs" status="status">
    <tr>    
      <td>&nbsp;${teachPlanName}(${programName})</td>
      <td>&nbsp;${coursesize}</td>
      <s:if test="clazzStatisticsVOs.size==0">
      <td>&nbsp;</td><td>&nbsp;0</td><td>&nbsp;0</td><td>&nbsp;0</td><td>&nbsp;0</td><td>&nbsp;0</td><td>&nbsp;0</td>
      </s:if><s:else>
      <td colspan="7" style="border-bottom: 0px;border-top: 0px">
      <table border="0px">
      <s:iterator value="clazzStatisticsVOs" status="status">
      <s:if test="clazzStatisticsVOs.size==1">
      <tr style="border: 0px">
        <td width="130px" style="border-left:0px;border-top: 0px;border-bottom: 0px;">&nbsp;${clazzName}</td>
        <td width="60px" style="border-top: 0px;border-bottom: 0px;">&nbsp;${studentsCount}</td>
        <td width="60px" style="border-top: 0px;border-bottom: 0px;">&nbsp;${youngCount}</td>
        <td width="60px" style="border-top: 0px;border-bottom: 0px;">&nbsp;${adultCount}</td>
        <td width="60px" style="border-top: 0px;border-bottom: 0px;">&nbsp;${oldCount}</td>
        <td width="40px" style="border-top: 0px;border-bottom: 0px;">&nbsp;${manCount}</td>
        <td width="40px" style="border-top:0px;border-right: 0px;border-bottom: 0px;">&nbsp;${womanCount}</td>
      </tr>
      </s:if><s:else>
      <s:if test="#status.first">
      <tr style="border: 0px">
        <td width="130px" style="border-left:0px;border-top: 0px">&nbsp;${clazzName}</td>
        <td width="60px" style="border-top: 0px">&nbsp;${studentsCount}</td>
        <td width="60px" style="border-top: 0px">&nbsp;${youngCount}</td>
        <td width="60px" style="border-top: 0px">&nbsp;${adultCount}</td>
        <td width="60px" style="border-top: 0px">&nbsp;${oldCount}</td>
        <td width="40px" style="border-top: 0px">&nbsp;${manCount}</td>
        <td width="40px" style="border-top:0px;border-right: 0px">&nbsp;${womanCount}</td>
      </tr>
      </s:if><s:elseif test="#status.last">
      <tr style="border: 0px">
        <td width="130px" style="border-left:0px;border-bottom: 0px">&nbsp;${clazzName}</td>
        <td width="60px" style="border-bottom: 0px">&nbsp;${studentsCount}</td>
        <td width="60px" style="border-bottom: 0px">&nbsp;${youngCount}</td>
        <td width="60px" style="border-bottom: 0px">&nbsp;${adultCount}</td>
        <td width="60px" style="border-bottom: 0px">&nbsp;${oldCount}</td>
        <td width="40px" style="border-bottom: 0px">&nbsp;${manCount}</td>
        <td width="40px" style="border-bottom: 0px;border-right: 0px">&nbsp;${womanCount}</td>
      </tr>
      </s:elseif>
      <s:else>
      <tr style="border: 0px">
        <td width="130px" style="border-left:0px;">&nbsp;${clazzName}</td>
        <td width="60px">&nbsp;${studentsCount}</td>
        <td width="60px">&nbsp;${youngCount}</td>
        <td width="60px">&nbsp;${adultCount}</td>
        <td width="60px">&nbsp;${oldCount}</td>
        <td width="40px">&nbsp;${manCount}</td>
        <td width="40px" style="border-right: 0px">&nbsp;${womanCount}</td>
      </tr>
      </s:else>     
      </s:else>
      </s:iterator></table>
      </td>
      </s:else>
    </tr>
     <tr style="background: #F2F9F9;color: #5BB1B9;line-height: 20px;border-top: 0px">
      <td>&nbsp;小计</td>
      <td>&nbsp;${coursesize}</td>
      <td>&nbsp;${clazzTotal}</td>
      <td>&nbsp;${studentTotal}</td>
      <td>&nbsp;${youngTotal}</td>
      <td>&nbsp;${adultTotal}</td>
      <td>&nbsp;${oldTotal}</td>
      <td>&nbsp;${manTotal}</td>
      <td>&nbsp;${womanTotal}</td>
      </tr>
      <s:if test="!#status.last">
      <tr style="height: 10px;"><td colspan="9" style="line-height: 10px;border-right: 0px;border-left: 0px">&nbsp;</td></tr></s:if>      
      </s:iterator>
  </table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</div>
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