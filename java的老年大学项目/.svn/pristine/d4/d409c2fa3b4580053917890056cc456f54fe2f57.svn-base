<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员信息-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>

</head>
<s:set name="curUser" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
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
	         <li class="active"><a href="student!info.action?id=${id}" >用户信息</a></li>
	         <li><a href="student!trainreport.action?id=${id }">项目情况汇总</a></li>
	         <li><a href="student!courses.action?id=${id }">课程列表</a></li>
          </ul>
       </div>
     </div>
     
     
  <div class="panel-body" >
    <div class="panel-body row">
     <div class="col-md-13">
    <table  class="table table-bordered dr-table-default">
    <tbody>
	<tr>
		<th width="20%" class="buleleft">姓名</th>
		<td colspan="2">${userDTO.name}</td>
		<td width="10%" rowspan="6" style="text-align: center">
		      <img src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${userDTO.avatarWithDefault}" width="170px" height="200px" />
			 <!--<a href="javascript:void(0)"	class="admin_online" onclick="opendialog('${curUser.username}','${userDTO.username}')">和我联系</a>
	   --></td>
	</tr>

	<tr>
		<th>身份证号</th>
		<td colspan="2">${userDTO.idcard}</td>
	</tr>
	<tr>
		<th>性别</th>
		<td colspan="2">${userDTO.sexDesc}</td>
	</tr>
	<tr>
		<th>政治面貌</th>
		<td colspan="2">${userDTO.political}</td>
	</tr>

	<tr>
		<th>最高学历</th>
		<td colspan="2">${edudegreeName}</td>
	</tr>
	<tr>
		<th>毕业院校</th>
		<td colspan="2">${userDTO.college}</td>
	</tr>
	<tr>
		<th>毕业时间</th>
		<td colspan="3">${userDTO.graduationyear}年${userDTO.graduationmonth}月</td>
	</tr>
	<tr>
		<th>参加工作时间</th>
		<td colspan="3">${userDTO.workyear}年${userDTO.workmonth}月</td>
	</tr>
	
		<!--  <tr>
		<th>组织机构代码</th>
		<td colspan="3">${userDTO.unitcode}</td>
	</tr>-->
	
	<tr>
		<th>所学专业</th>
		<td colspan="3">${userDTO.major}</td>
	</tr>
	<tr>
		<th>工作单位所属地区</th>
		<td colspan="3">${userDTO.unitcity}-${userDTO.unitarea}</td>
	</tr>
	
	<tr>
		<th>工作单位全称</th>
		<td colspan="3">${userDTO.unit}</td>
	</tr>
		<tr>
		<th>单位地址</th>
		<td colspan="3">${userDTO.unitaddress}</td>
	</tr>

	<tr>
		<th rowspan="${rowspan }">专业技术资格</th>
		<th width="21%">获得年月</th>
		<th width="39%">专业技术资格</th>
		<th>单位确认</th>
	</tr>
	<s:iterator value="jobexperiences" status="stat">
		<tr>
			<td>${getyear}.${getmonth}</td>
			<td>${qulificationStr}</td>
			<td><img src="${ctx}/css/image/right.png" width="16" height="16" class="vm mr5" />${confirmUnit}</td>
		</tr>
	</s:iterator>
	<tr>
		<th>职称</th>
		<td colspan="3">${userDTO.tecposition}</td>
	</tr>
	<!--<tr>
		<th>管理职务</th>
		<td colspan="3">${userDTO.manageposition}</td>
	</tr>-->
	<tr>
		<th>手机</th>
		<td colspan="3">${userDTO.mobilephone}</td>
	</tr>
	<tr>
		<th>联系电话</th>
		<td colspan="3">${userDTO.areacode}-${userDTO.realphone}</td>
	</tr>
	</tbody>
</table>
<br/>
<table class="table table-bordered dr-table-default">
<tbody>
	<tr>
		<th width="20%" class="buleleft">注册时间</th>
		<td width="80%"><s:date name="userDTO.createdate"
			format="yyyy.MM.dd"></s:date></td>
	</tr>
	<tr>
		<th class="buleleft">登录次数</th>
		<td>${userDTO.loginnum}</td>
	</tr>
  </tbody>
</table>
</div>
</div>
</div>
</div>
</div>
<!--dr-container-fluid结束-->
</section>
</div>
<!--dr-wrapper结束-->
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>

