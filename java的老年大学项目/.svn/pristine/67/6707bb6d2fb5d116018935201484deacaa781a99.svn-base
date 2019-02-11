<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员项目情况汇总-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
</head>

<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
   <div class="dr-page-header">
     <h3>学员详细信息</h3>
   </div>
   <hr/>
   <div class="panel panel-default">
 
     <div class="panel-heading">
       <h3 class="panel-title">学员详细</h3>
       <div class="panel-toolbar">
          <ul class="nav nav-tabs pull-right">
	         <li><a href="student!info.action?id=${id }" >用户信息</a></li>
	         <li class="active"><a href="student!trainreport.action?id=${id }">项目情况汇总</a></li>
	         <li><a href="student!courses.action?id=${id }">课程列表</a></li>
          </ul>
       </div>
     </div>
<div class="panel-body">
  <div class="panel-body row">
<s:iterator value="userTrainVOs" status="stat">
<table  class="table table-bordered dr-table-default">
  <tbody>
	<tr>
		<th width="13%">项目类型</th>
		<td align="left">${typeName}</td>
		<th width="13%">毕业学分要求</th>
		<td width="39%" align="left">${studylength}学分</td>
	</tr>
	<tr>
		<th>培训项目名称</th>
		<td width="35%" align="left">${name}</td>
		<th width="13%">培训项目代码</th>
		<td width="39%"  align="left">${code}</td>
	</tr>
	<s:if test="hasCert">
	<tr>
		<th>证书</th>
		<td align="left">
		${certName}
		</td>
		<th>证书编号</th>
		<td align="left">${certNo}</td>
	</tr>
	</s:if>
	</tbody>
</table>


<table  class="table table-bordered dr-table-default" style="margin-top: 5px;margin-bottom: 15px;">
  <tbody>
	<tr>
		<th width="20%" rowspan="2" style="text-align: center">项目阶段</th>	
		<th colspan="2"  style="text-align: center">完成的课程</th>
		<th colspan="2"  style="text-align: center">在学的课程</th>
		<th colspan="2"  style="text-align: center">过期的课程</th>
		<th colspan="2"  style="text-align: center">不合格的课程</th>
	</tr>
	<tr>
		<td width="10%" align="center" >课程数</td>
		<td width="10%" align="center" >学分</td>
		<td width="10%" align="center" >课程数</td>
		<td width="10%" align="center" >学分</td>
		<td width="10%" align="center" >课程数</td>
		<td width="10%" align="center" >学分</td>
		<td width="10%" align="center" >课程数</td>
		<td width="10%" align="center" >学分</td>		
	</tr>
	<s:iterator value="teachplans" status="stat">
	<tr>
		<td align="center">&nbsp;${phase.name}</td>
		<td align="center">&nbsp;${finishedCourseCount}</td>
		<td align="center">&nbsp;${finishedCourseStudyLength }</td>
		<td align="center">&nbsp;${learningCourseCount}</td>
		<td align="center">&nbsp;${learningCourseStudyLength }</td>
		<td align="center">&nbsp;${expiredCourseCount}</td>
		<td align="center">&nbsp;${expiredCourseStudyLength }</td>
		<td align="center">&nbsp;${failedCourseCount}</td>
		<td align="center">&nbsp;${failedCourseStudyLength }</td>			
	</tr>
	<s:if test="!hasCert">
	<tr>
		<th style="text-align: center">证书名称</th>
		<td colspan="4" align="center">
		${userCertName}
		</td>
		<th colspan="2" style="text-align: center">证书编号</th>
		<td colspan="2" align="center">${certno}</td>
	</tr>
	</s:if>
	</s:iterator>
	<tr>
		<td align="center" ><strong>汇总</strong></td>
		<td align="center" ><strong>${finishedTotalCourseCount}</strong></td>
		<td align="center" ><strong>${finishedTotalCourseStudyLength }</strong></td>
		<td align="center" ><strong>${learningTotalCourseCount}</strong></td>
		<td align="center" ><strong>${learningTotalCourseStudyLength }</strong></td>
		<td align="center" ><strong>${expiredTotalCourseCount}</strong></td>
		<td align="center" ><strong>${expiredTotalCourseStudyLength }</strong></td>
		<td align="center" ><strong>${failedTotalCourseCount}</strong></td>
		<td align="center" ><strong>${failedTotalCourseStudyLength }</strong></td>		
	</tr>
	</tbody>
</table>

</s:iterator>
</div>
</div>
</div>
</div>
</section>
</div>
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>

