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
<title>兑换学币设置<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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
	<jsp:param value="coinrule" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
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
<a href="#">基础数据管理</a>
</li>
<li class="active">兑换学币设置</li>
</ol>

<div class="dr-page-header">
<h3>
兑换学币设置
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

<form name="deleteForm" id="deleteForm" action="coinrule.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<div class="btn-toolbar dr-btn-toolbar">
    <button class="btn btn-primary btn-sm" type="button" onclick="window.location='coinrule!input.action'">
	<span class="glyphicon glyphicon-plus"></span>
	新增兑换规则
	</button>
</div>
<table  class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="5%">序号</th>
		<th width="10%">兑换比例</th>
		<th width="20%">开始启用日期</th>
		<th width="10%">创建人</th>
		<th width="20%">创建时间</th>
		<th width="10%">是否在用</th>
		<th width="10%">操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
		<td>${stat.index+1 }</td>
		<td>${rate }</td>
		<td>${startTimeStr }</td>
		<td>${student.name }</td>
		<td>${createTimeStr }</td>
		<td><s:if test="used">是</s:if><s:else>否</s:else></td>
		<td>
			<a class="btn btn-primary btn-sm" type="button" href="${ctx }/coin/manage/coinrule!input.action?id=${id}">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;修改
			</a>
		</td>
		</tr>
	</s:iterator>
</table>
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