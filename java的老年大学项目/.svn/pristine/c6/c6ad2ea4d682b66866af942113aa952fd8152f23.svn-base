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
	    setClazzNames();//设置班级自动补充
	    
    }); 
    
    function setClazzNames(){
    	$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!getClazzs.action",
		    data: {
		    	"tenantId":$("#tenantId").val()
			},
			dataType:"json",
			success: function(data) {
				$("#clazzName").autocomplete({
				    source: data
				});	
		   	}
		});
    }
    
	function changeTenant(){				
		var tenantId = $("#tenantId").val();
		setClazzNames();
	}
	
	function myreplay(id){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!getQuestionDetail.action",
		    data: {
		    	"id":id
			},
			dataType:"json",
			success: function(data) {
				$("#title").html(data.content);
				$("#clazzCourseQustionId").val(data.id);
		   	}
		});
		
		$('#replaySelect').dialog({
				title : '我要回答',
				width:600,
				height:480,
				autoOpen : true,
				modal : true,
				resizable : false,
				buttons : {
					'确认' : function() {
						addReplay();
						$('#replaySelect').dialog('close');
						
					},
					'取消' : function() {
						$('#replaySelect').dialog('close');
					}
				}
		});
	}
	
	
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
<li class="active">在线提问</li>
</ol>

<div class="dr-page-header">
<h3>
在线提问
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/clazzcourse/manage/clazzcourse!question.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="questionPage.pageNo" id="pageNo" value="${questionPage.pageNo}" />
<input type="hidden" name="questionPage.orderBy" id="orderBy" value="${questionPage.orderBy}" />
<input type="hidden" name="questionPage.order" id="order" value="${questionPage.order}" />
<input type="hidden" name="export" value="false" id="export"/>
<s:if test="currentTenant == null ">
	<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id" onchange="changeTenant()"
					id="tenantId" value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
	</div>
</s:if>
<%-- <div class="form-group">
	 <label>所属班级</label>
	 <s:select list="clazzs" listKey="id" listValue="name"  value="clazzId" theme="simple" headerValue="--所属班级--"
			headerKey="" cssClass="form-control" name="clazzId"></s:select>
</div> --%>
<div class="form-group">
	 <label>班级名称</label>
	  <input class="form-control input-sm" type="text" name="clazzName" id="clazzName" value="${clazzName }"/>
</div>
<div class="form-group">
	 <label>课程名称</label>
	  <input class="form-control input-sm" type="text" name="courseName" id="courseName" value="${courseName }"/>
</div>

<div class="form-group">
	 <label>状态</label>
	<s:select list="#{'false':'未回复','true':'已回复'}" listKey="key" listValue="value" cssClass="form-control input-sm"
			    theme="simple" name="filter_EQB_replay" headerKey="" value="(#parameters.filter_EQB_replay)"
				headerValue="全部"></s:select>	
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
</div>
</form>
<form name="deleteForm" id="deleteForm" action="clazzcourse!question.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<table  class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="10%">班级名称</th>
		<th width="10%">课程名称</th>
		<th width="10%">学员账号<br/>姓名</th>
		<th width="30%">问题</th>
		<th width="10%">时间</th>
		<th width="10%">状态</th>
		<th width="20%">操作</th>
	</tr>
	<s:iterator value="questionPage.result" status="stat">
		<tr>
		<td>${clazzName }</td>
		<td>${courseName }</td>
		<td>${student.username }<br/>${student.name }</td>
		<td>${content }</td>
		<td>${questionTimeStr }</td>
		<td>
			<s:if test="replay"><span style="color:green;">已回复（${replayCount }）</span></s:if><s:else><span style="color:red;">未回复</span></s:else>
		</td>
		<td>
			<button class="btn btn-primary btn-sm" type="button" onclick="myreplay('${id}')">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;我要回答
			</button>
			<a class="btn btn-primary btn-sm" type="button" href="${ctx }/clazzcourse/manage/clazzcourse!questionDetail.action?id=${id}" target="_blank">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;详情
			</a>
		</td>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="questionPage" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>

<div id="replaySelect" style="display:none;" >
	
	<form class="well form-inline" name="addForm" id="addForm" action="clazzcourse!replay.action" method="post">
	<input type="hidden" value="" name="clazzCourseQustionId" id="clazzCourseQustionId" />
	<div id="title" style="margin-bottom:30px;font-weight:bold;"></div>
	<div>
		<textarea rows="3" cols="20" name="content" id="content" style="width:500px;height:220px;"></textarea>
	</div>
	</form>
	<div id="replaySelectTable" >
	</div>
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