<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${programDTO.name}阶段<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />

<script>  
	$(document).ready(function() {
		if($("#success").text()!="")$("#div-success").show();
	    if($("#error").text()!="")$("#div-error").show();   
 	});

 	function delPhase(id){
 		var oaction = document.getElementById("deleteForm").action;
 		document.getElementById("deleteForm").action="${ctx }/train/manage/phase!delete.action?id="+id+"&programId=${programId}";
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
	   	});
 	}
</script>

</head>
<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--正文开始-->
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">

<div class="dr-page-header">
<h3>
<label style="margin-right: 10px;">${programDTO.name}</label>项目管理
</h3>
</div>
<hr />

<!--信息提示 end-->
<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li><a href="programs!minput.action?id=${programId}">培训项目属性设置</a></li>
        <li class="active"><a style="cursor: pointer;" href="phase.action?programId=${programId}&menu=menu">项目阶段</a></li>
        <li><a style="cursor: pointer;" href="teachcontent.action?programId=${programId}">教学内容设置</a></li>
        <!--<li><a href="programs!studentlog.action?id=${itemid}">学员培训记录查询</a></li>
        --><li><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>                
</div>


<div class="tab-content dr-tabs-panel">
	<!--信息提示-->
	<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
	<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
	<span id="success"><s:actionmessage  theme="simple"/></span>
	</div>
	<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
	<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
	<span id="error"><s:actionerror theme="simple"/></span>
	</div>
	
	<table class="table table-bordered dr-table-default">
	<tr>
		<th>培训项目名称</th>
		<td>${programDTO.name }</td>
		<th>培训项目代码</th>
		<td>${programDTO.code }</td>
		<th>毕业学分要求</th>
		<td>${programDTO.hours }学分</td>
	</tr>
	</table>
	<form name="deleteForm" id="deleteForm" action="phase.action"method="post">
		<div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
				<button class="btn btn-primary btn-sm" type="button"
				onclick="window.location='phase!input.action?programId=${programDTO.id}'">
				<span class="glyphicon glyphicon-plus"></span>
				新增项目阶段
				</button>
			</div>
			<table class="table table-bordered dr-table-default">
			<tr>
				<th width="20%">阶段名称</th>
				<th>要求学时</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			<s:iterator value="page.result" status="stat">
				<tr>
					<td>${name}</td>
					<td>${hours}</td>
					<td>${openstr}</td>
					<td >
					<div class="btn-group">
					<a class="btn btn-primary btn-sm"
						href="phase!input.action?id=${id }&programId=${programId}">
						<span class="glyphicon glyphicon-cog"></span>&nbsp;修改</a>
					</div>
					<div class="btn-group">
					<a class="btn btn-primary btn-sm"
						href="phase!open.action?id=${id}&programId=${programId}">
						<span class="glyphicon glyphicon-cog"></span>&nbsp;开放</a>
					</div>
					<div class="btn-group">
					<a class="btn btn-default btn-sm"
						href="phase!open.action?id=${id}&programId=${programId}&cancle=cancle">
						<span class="glyphicon glyphicon-cog"></span>&nbsp;取消开放</a>
					</div>
					<div class="btn-group">
					<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="delPhase(${id})">
	                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
	           		</button>
					<!--<a href="#" class="btn btn-default  btn-sm"
						onclick="delRecord('${ctx }/train/manage/programs!teachplandelete.action?id=${id }&itemid=${itemid }&menu=menu');">
						<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
					-->
					</div>
					</td>
				</tr>
			</s:iterator>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
		</div>
	</form>
</div>
<!--<div class="tab-content dr-tabs-panel">
<div class="panel-body row">

<table class="table table-bordered dr-table-default">
	<tr>
		<th>培训项目名称</th>
		<td>${programDTO.name }</td>
		<th>培训项目代码</th>
		<td>${programDTO.code }</td>
		<th>毕业学分要求</th>
		<td>${programDTO.hours }学分</td>
	</tr>
	<tr>
		
	</tr>
</table>

</div>

<div class="panel-body row">
<div class="btn-toolbar dr-btn-toolbar">
	<div class="btn-group">
		<button class="btn btn-primary btn-sm" type="button">
		<span class="glyphicon glyphicon-edit"></span>
		 新增阶段
		</button>
	</div>
<table class="table table-bordered dr-table-default">
	<tr>
		<th>模块</th>
		<th width="20%">阶段名称</th>
		<th>要求学时</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>${name}</td>
			<td>${hours}</td>
			<td>${openstr}</td>
			<td >
			<div class="btn-group">
			<a class="btn btn-primary btn-sm"
				href="programs!teachplan.action?planid=${id }&itemid=${trainingPrograms.id}&t=m">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;修改</a>
			</div>
			<div class="btn-group">
			<a class="btn btn-primary btn-sm"
				href="phase!open.action?id=${id}">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;开放</a>
			</div>
			<div class="btn-group">
			<a href="#" class="btn btn-default  btn-sm"
				onclick="delRecord('${ctx }/train/manage/programs!teachplandelete.action?id=${id }&itemid=${itemid }&menu=menu');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
			</div>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
	
</div>
-->
</div>
</section>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>