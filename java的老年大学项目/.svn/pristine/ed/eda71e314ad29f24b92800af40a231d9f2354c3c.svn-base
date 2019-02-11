<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>在线提问<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<link href="${staticurl}/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="${ctx}/js/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
    }); 
    
	function addReplay(){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!replay.action",
		    data: {
		    	"clazzCourseQustionId":$("#clazzCourseQustionId").val(),
		    	"content":$("#content").val()
			},
			dataType:"json",
			success: function(data) {
				$("#mainForm").submit();
		   	}
		});
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
	<jsp:param value="clazzcoursequestion" name="menu" />
	<jsp:param value="clazz" name="bigmenu" />
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
<a href="#">班级管理</a>
</li>
<li class="active">回复详情</li>
</ol>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/clazzcourse/manage/clazzcourse!question.action" method="post">
	<div style="margin-bottom:30px;"><span>提问人：${clazzCourseQuestion.student.name }</span><span style="margin-left:100px;">提问时间：${clazzCourseQuestion.questionTimeStr }</span></div>
	<div style="margin-bottom:30px;">提问：${clazzCourseQuestion.content }</div>
</form>
<hr/>
<form name="deleteForm" id="deleteForm" action="clazzcourse!questionDetail.action?id=${id }" method="post">
<div class="panel panel-default  mt10 mb10" >
<table  class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="30%">回复内容</th>
		<th width="10%">回复人</th>
		<th width="10%">回复时间</th>
		<th width="10%">操作</th>
	</tr>
	<s:iterator value="questionDetailPage.result" status="stat" var="obj">
		<tr>
		<td>${content }</td>
		<td>${replayUser.username }<br/>${student.name }</td>
		<td>${createTimeStr }</td>
		<td>
			<a class="btn btn-primary btn-sm" type="button" href="${ctx }/clazzcourse/manage/clazzcourse!deleteQuestionDetail.action?id=${clazzCourseQuestion.id }&detailId=${obj.id }">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;删除
			</a>
		</td>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="questionDetailPage" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>

<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>
</body>
</html>