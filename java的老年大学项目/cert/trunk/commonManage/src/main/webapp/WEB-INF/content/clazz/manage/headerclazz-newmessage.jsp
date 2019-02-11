<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>班级公告管理</title>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp"%>
<script>
$(document).ready(function() {
	        if($("#success").text()!="")$("#div-success").show();
	        if($("#error").text()!="")$("#div-error").show();
})
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
	<!--<li><a href="headerclazz!schedule.action?headerClazzId=${headerClazzId}">教学日程管理</a></li>
	--><li><a href="headerclazz!bulletin.action?headerClazzId=${headerClazzId }">班级公告管理</a></li>
	<li><a href="headerclazz!students.action?headerClazzId=${headerClazzId }">班级学员查询</a></li>
	<!--<li class="active"><a href="headerclazz!message.action?headerClazzId=${headerClazzId }">群发系统消息</a></li>
	--><li><a href="headerclazz!bgimage.action?headerClazzId=${headerClazzId }">班级背景图管理</a></li>
</ul>
</div>

<div class="panel panel-default">
<form class="form-horizontal dr-form-bordered" id="form1" action="headerclazz!batchsendmessage.action" method="post"
	enctype="multipart/form-data">
<input type="hidden" name="headerClazzId" value="${headerClazzId}"/>
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
	
<div class="form-group">
     <label class="col-md-2 control-label">内容</label>
	 <div class="col-md-10"><textarea class="form-control" rows="10" cols="60" name="message.content"></textarea>
	 </div>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">
        <button class="btn btn-primary btn-sm" type="submit" name="Submit32">
         <span class="glyphicon glyphicon-ok"></span>保存
        </button>

        <button class="btn btn-default btn-sm" type="button" onclick="window.location.href='headerclazz!message.action?headerClazzId=${headerClazzId}'">
         <span class="glyphicon glyphicon-remove"></span>取消
        </button>
</div>
</div>
</div>

</form>
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
