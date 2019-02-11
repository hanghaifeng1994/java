<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/common/admin_meta.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
%> 
<title>班级公告管理</title>
<script type="text/javascript">
$(document).ready(function() {
	 
	 
});
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
<section id="main" role="main">
<div class="dr-container-fluid">
<%@ include file="/common/clazzHeader.jsp"%>
<div class="bs-example">
<ul class="nav nav-tabs" id="tab">
<li class="active"><a href="#">课程实施管理</a></li>
</ul>
</div>
<div class="tab-content dr-tabs-panel">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="50%">课程名称</th>	
		<th>操作</th>
	</tr>
	<s:iterator value="classCourseDTOs" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;
			<s:if test="course.newlp">
			<a href="#" onclick="lpoperaction(${course.id})" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;课程实施</a>
			</s:if>
			<s:else>
			<a href="${ctx }/course/manage/course!schedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;作业日程管理</a>
			<a href="${ctx}/course/manage/course!examSchedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;测验日程管理</a>
			</s:else>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
</div>
<s:if test="#request.iswxeduopen=='false'">
<%@ include	file="/common/tagtitle.jsp"%> 
</s:if>
<div class="tab-content dr-tabs-panel">
<div class="panel-body row">
<div class="col-md-12">
<form id="mainForm" name="mainForm" action="headerclazz!bulletin.action"
	method="post"><input type="hidden" name="page.pageNo"
	id="pageNo" value="${page.pageNo}" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="headerClazzId" value="${headerClazzId }"/>
</form>
<div class="panel panel-default">
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="50%">标题</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>&nbsp;${title }</td>
			<td>&nbsp; <s:date name="createdate" format="yyyy.MM.dd HH:mm" />
			</td>
			<td>
			&nbsp;
			<s:if test="clazzId!=null">
			<button name="Submit32" class="btn btn-primary btn-sm" type="submit" onclick="window.location.href='${ctx}/clazz/manage/headerclazz!editbulletin.action?bulletinid=${id}&headerClazzId=${headerClazzId}'">
            <span class="glyphicon glyphicon-edit"></span>
                                   编辑
            </button>
            <button class="btn btn-default btn-sm" type="button" onclick="delRecord('${ctx}/clazz/manage/headerclazz!deletebulletin.action?bulletinid=${id}&headerClazzId=${headerClazzId}')">
            <span class="glyphicon glyphicon-trash"></span>
                                   删除
            </button>
            </s:if>
				<!--   <a href="${ctx }/clazz/manage/headerclazz!topbulletin.action?bulletinid=${id}&headerClazzId=${headerClazzId}">${topString}</a> -->
				  <!--<a href="${ctx }/clazz/manage/headerclazz!pubbulletin.action?bulletinid=${id}&headerClazzId=${headerClazzId}">${pubString}</a> -->				 
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include	file="/common/turnpage.jsp"%>
</div>

<div class="form-group mt10">
<button name="Submit32" class="btn btn-primary btn-sm" type="submit" onclick="window.location.href='headerclazz!editbulletin.action?headerClazzId=${headerClazzId}'">
<span class="glyphicon glyphicon-plus"></span>
 新增公告
</button>
</div>
</div>
</div>
</div>
</div>
</section>
</div>
<!--正文结束-->

<script type="text/javascript">
<!--
//选择一项操作动作
function lpoperaction(id){
   var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
		var hrefvalue = "3";
		if(hrefvalue=="")return;
		var target = "_blank";

		if(hrefvalue=="1" || hrefvalue=="2" || hrefvalue=="3"){
			$("#outItemId").val(id);
			$("#roleType").val(hrefvalue);			
			hrefvalue = hreflp;
		}
		openlpUrl(hrefvalue,target,id);
}

function openlpUrl(url,target,id){
	$("#lpwindowFrom").attr("action",url);
	$("#lpwindowFrom").attr("target",target);
	$("#lpwindowFrom").submit();
}
//-->
</script>

<form id="lpwindowFrom" action="" method="get" target="_blank">
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="${tenantsCode}"/>
<input name="teacherName" id="teacherName" type="hidden" value="${user.name}"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="${user.username}"/>           
</form>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
