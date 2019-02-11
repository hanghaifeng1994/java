<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%UserDTO user = UserUtils.getCurUser(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>教学日程管理</title>
<link href="${staticurl}/wx_js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/wx_js/bootstrap/drcl_css/drcl.css" rel="stylesheet"/> 
<link href="${staticurl}/css/admin_change.css" rel="stylesheet" type="text/css"/>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<style>
.dr-table-bordered{
margin-left:18px;
}
</style>
<script type="text/javascript">
function openUrl(url,target,id){
	$("#newwindowFrom").attr("action",url);
	$("#newwindowFrom").attr("target",target);
	$("#newwindowId").val(id);
	$("#newwindowFrom").submit();
}
//选择一项操作动作
function newoperaction(id){
    var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
	var target = "_blank";
	$("#outItemId").val(id);
	$("#roleType").val(3);			
	openUrl(hreflp,target,id);
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
<div class="admin_tc">
<div class="seemore0">
<%@ include file="/common/clazzHeader.jsp"%>

<div class="bs-example">
<ul class="nav nav-tabs" id="tab">
	<!--<li class="active"><a href="headerclazz!schedule.action?headerClazzId=${headerClazzId}">教学日程管理</a></li>
	--><li><a href="headerclazz!bulletin.action?headerClazzId=${headerClazzId }">班级公告管理</a></li>
	<li><a href="headerclazz!students.action?headerClazzId=${headerClazzId }">班级学员查询</a></li>
	<!--<li><a href="headerclazz!message.action?headerClazzId=${headerClazzId }">群发系统消息</a></li>
	--><li><a href="headerclazz!bgimage.action?headerClazzId=${headerClazzId }">班级背景图管理</a></li>
</ul>
</div>
<br></br>
<table style="width: 96%;" class="table table-bordered dr-table-bordered">
	<tr>
		<td class="buleleft" width="50%">课程名称</td>	
		<td class="buleleft">操作</td>
	</tr>
	<s:iterator value="curHeaderClazz.clazz.classCourses" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;
			<s:if test="course.newlp">
			<a href="javascript:void(0)" onclick="newoperaction(${course.id})">日程管理</a>
			</s:if>
			<s:else>
			<a href="${ctx }/course/manage/course!schedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank">作业日程管理</a>
			<a href="${ctx}/course/manage/course!examSchedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank">测验日程管理</a>
			</s:else>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
<!--正文结束-->
<form id="newwindowFrom" action="" method="get" target="_blank">
<input name="id" id="newwindowId" type="hidden"/>
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="ahstudy"/>
<input name="teacherName" id="teacherName" type="hidden" value="<%=user.getName()%>"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="<%=user.getUsername()%>"/>           
</form>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
