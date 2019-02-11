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
<title>学员学币记录查询<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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
	<jsp:param value="usercoinrecord" name="menu" />
	<jsp:param value="order" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">学币</a>
</li>
<li>
<a href="#">学员学币记录查询</a>
</li>
</ol>

<div class="dr-page-header">
<h3>
学员学币记录查询
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/coin/manage/usercoinrecord.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>

<div class="form-group">
	 <label>用户名</label>
	  <input class="form-control input-sm" type="text" name="userName" id="userName" value="${userName }"/>
</div>
<div class="form-group">
	 <label>姓名</label>
	  <input class="form-control input-sm" type="text" name="name" id="name" value="${name }"/>
</div>

<div class="form-group">
	 <label>状态</label>
	<s:select list="#{'1':'收入','2':'支出'}" listKey="key" listValue="value" cssClass="form-control input-sm"
			    theme="simple" name="type" headerKey="" value="@java.lang.Integer@parseInt(#parameters.type)"
				headerValue="全部"></s:select>	
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');;document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
</div>
</form>
<form name="deleteForm" id="deleteForm" action="usercoinrecord.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<table  class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="5%">序号</th>
		<th width="10%">用户名/姓名</th>
		<th width="10%">学币变化</th>
		<th width="10%">剩余学币</th>
		<th width="10%">发生时间</th>
		<th width="30%">说明</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
		<td>${stat.index+1 }</td>
		<td>${student.username }<br/>${student.name }</td>
		<td><s:if test="type==1"><span style="color:green;">${changeCoinStr }</span></s:if><s:else><span style="color:red;">${changeCoinStr }</span></s:else></td>
		<td>${afterCoin }</td>
		<td>${createTimeStr }</td>
		<td>${changReason }</td>
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