<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<!DOCTYPE html>
<html lang="de">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
</head>
<body>
<!-- navbar start -->	
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="diquCount" name="menu" />
	<jsp:param value="xueqing" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">  
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
          <li>
             <span class="glyphicon glyphicon-home"></span>
              <a href="#">平台首页</a>
         </li>
         <li>
             <a href="#">学情统计</a>
         </li>
       <li class="active"><span>地区学情</span></li>
      </ol>
	<!--/breadcrumb-->
<div class="bs-example" > 
	<ul class="nav nav-tabs nav-justified" id="tab" style="padding: 0px;">
        <li  class="active"><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituation!diqu.action">地区学情统计</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituation!diquhighchart.action">地区图表统计</a></li>
   </ul>                
</div> 
	<!--页面标题-->
<div>
	<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/learningsituation!diqu.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />

<!--<div class="form-group">
	  	<label>所属项目</label>
	  	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" headerValue="--所属项目--"
			headerKey="" cssClass="form-control" name="programesId"></s:select>
</div>
-->
<s:if test="currentTenant == null ">
	<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"
					id="tenantId"   value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
</s:if>

<div class="form-group">
	  	<label>所属城市</label>
	  	<s:select list="citysLists" listKey="id" value="cityid" listValue="name" theme="simple" headerValue="--所属城市--"
			headerKey="" cssClass="form-control" name="cityid"></s:select>
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>

</div>
</form>

	<form class="form-inline dr-form-inline"  id="mainForm2" name="mainForm2" action="${ctx}/count/manage/learningsituationclazz!list.action"
	 method="post" enctype="multipart/form-data">
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
      <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
      <input type="hidden" name="page.order" id="order" value="${page.order}" />
<table class="table table-bordered dr-table-default">
	<tbody  >
		<tr>
			<th width="80px;">地区</th>
			<th width="40px;">报名人数</th>
			<th width="40px;">学习人数</th>
			<th width="60px;">总学习时间（分钟）</th>
			<th width="60px;">平均学习时间（分钟）</th>
			<th width="60px;">作业提交待批阅数</th>
			<th width="60px;">作业评阅数</th>
			<th width="60px;">作业全部完成人数</th>
			<th width="60px;">作业未完成人数</th>
			<th width="50px;">作业完成率</th>
			
			<!--<th width="50px;">研修讨论主题数</th>
			-->
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			
			</s:if>
			<s:else>
				<th width="60px;">提交研修成果人数</th>
				<th width="60px;">研修成果已评数</th>
				<th width="50px;">研修成果完成率</th>
				<th width="60px;">研修讨论发帖数</th>  
				<th width="60px;">平均研修讨论发帖数</th>
				<th width="60px;">研修日志发布数</th>
				<th width="60px;">平均研修日志发布数</th>
			</s:else>
			<th width="40px;">平均测验成绩</th>
			<th width="40px;">平均成绩</th>
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			<th width="40px;">平均学时</th>
			<th width="40px;">总通过率</th>
			</s:if>
			<s:else>
			<th width="40px;">总合格率</th>
			</s:else>
			</tr>

 <s:iterator value="learninglist" status="stat">
		<tr>
			<td width="80px;">${areaname}</td>
			<td width="40px;">${signupnum}</td>
			<td width="40px;">${studynum}</td>		
			<td width="60px;"><fmt:formatNumber type="number" value="${allhour}" maxFractionDigits="1"/></td>
			<td width="50px;"><fmt:formatNumber type="number" value="${averagehour}" maxFractionDigits="1"/></td>
			<td width="60px;">${hwnum}</td>
			<td width="60px;">${hwrearmknum}</td>
			<td width="60px;">${hwcompletnum}</td>
			<td width="60px;">${unhwcompletnum}</td>
			<!--<td width="50px;">${hwcompleted}</td>-->
			<td width="50px;"><fmt:formatNumber value="${hwcompleted}" type="percent"/></td>
			
			<!--<td width="50px;">${dbnum}</td>
			
			-->
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			
			</s:if>	
			<s:else>
				<td width="60px;">${resnum}</td>
				<td width="60px;">${resremarknum}</td>
				<!--<td width="50px;">${rescompleted}</td>-->
				<td width="50px;"><fmt:formatNumber value="${rescompleted}" type="percent"/></td>
				<td width="60px;">${dbcommentnum}</td>
				
				<td width="60px;"><fmt:formatNumber type="number" value="${averdbcommentnum}" maxFractionDigits="1"/></td>
				
				<td width="60px;">${blognum}</td>
				
				<td width="60px;"><fmt:formatNumber type="number" value="${averblognum}" maxFractionDigits="1"/></td>
			</s:else>
			<td width="40px;"><fmt:formatNumber type="number" value="${averageexamscore}" maxFractionDigits="1"/></td>
			<td width="40px;"><fmt:formatNumber type="number" value="${grate}" maxFractionDigits="1"/></td>
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			<td width="40px;"><fmt:formatNumber type="number" value="${averagelearnhour}" maxFractionDigits="1"/></td>
			</s:if>
			<td width="60px;"><fmt:formatNumber value="${qualifiedRate}" type="percent"/></td>
            </tr>
</s:iterator>
	</tbody>
</table>
<%@ include file="/common/turnpage.jsp"%>

</form>
</div>
</div>

	

<!-- container end -->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>

</body>
</html>