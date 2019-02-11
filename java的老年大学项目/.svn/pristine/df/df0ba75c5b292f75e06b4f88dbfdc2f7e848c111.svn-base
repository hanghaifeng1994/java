<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>课程分享<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%>

<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }
		   else{
		   $("input[name='ids']").removeAttr("checked");
			   } 
	   });
	   
	   $("#applyShare").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/courseshare!shareCourse.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
	   }); 	

    }); 
	
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
	 }

</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="courseshare" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">课程资源库管理</a>
</li>
<li class="active">课程分享</li>
</ol>

<div class="dr-page-header">
<h3>
课程分享列表
</h3>
</div>
<hr/>

<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->

<ul class="nav nav-tabs nav-justified">
 	<li class="active"><a href="courseshare!apply.action">课程分享 </a></li>
 	<li><a href="courseshare!myapply.action">我的分享申请</a></li>
 	<li><a href="courseshare.action">分享审核</a></li>
</ul>
<div class="tab-content dr-tabs-panel">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/course/manage/courseshare!apply.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="coursePage.pageNo" id="pageNo" value="${coursePage.pageNo}" />
<input type="hidden" name="coursePage.orderBy" id="orderBy" value="${coursePage.orderBy}" />
<input type="hidden" name="coursePage.order" id="order" value="${coursePage.order}" />
<div class="form-group">
  <label>租户</label>
  <s:select list="tenantLists" listKey="id" value="tenantId" listValue="name" theme="simple"
	cssClass="form-control" name="tenantId" headerValue="--大平台--"
	headerKey=""></s:select>
</div> 

<div class="form-group">
<label>课程名称</label>
<input name="courseName" type="text" class="form-control input-sm" value="${param['courseName']}"/>
</div>
<div class="form-group">
<label>课程代码</label>
<input name="courseCode" class="form-control input-sm" value="${param['courseCode']}"/>
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
     
</div>
</form>

<form name="deleteForm" id="deleteForm" action="courseshare!apply.action" method="post">
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="applyShare">
<span class="glyphicon glyphicon-share mr5"></span>
申请分享
</button>
</div>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="4%"><input type="checkbox" id="checkboxall"/></th>
		<th width="23%">课程名称<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">课程编码<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">学分<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">教学方式</th>
	</tr>
	<s:iterator value="coursePage.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids"	value="${id}" /></td>
			<td title="${name}"><common:cut len="30" string="${name}"/></td>
			<td>&nbsp;${serialNo}</td>
			<td>${studylength}</td>
			<td>${offlineType}</td>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="coursePage" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>    
</div>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
<!--正文结束-->
</div>
</body>
</html>