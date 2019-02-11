<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理${programDTO.name}教学内容<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>

<%
request.setAttribute("isShzx",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","isShzx"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
%> 
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script>  
	$(document).ready(function() {		
 	});
	
	function addcourse(){
		b_IframeLevel("${ctx}/train/manage/teachcontent!addcourse.action?id=${id}",1050,400,tst);
		//b_IframeLevel("${currentTenant.doname}/train/manage/teachcontent!addcourse.action?id=${id}",1050,400,tst);
    };
   
    function tst(){
	   window.location.reload();
	};
	
	function delcourse(id){
 		var oaction = document.getElementById("mainForm").action;
 		document.getElementById("mainForm").action="${ctx}/train/manage/teachcontent!deleteCourse.action?teachContentCourseId="+id;
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
	   	});
 	}
 	function setStudyLength(teachContentCourseId){
 		var id = $("#id").val();
 		var programId = $("#programId").val();
 		b_IframeLevel("${ctx}/train/manage/teachcontent!setstudylength.action?teachContentCourseId="+teachContentCourseId+"&id="+id+"&programId="+programId,500,100,tst);
 	}
 	
 	function setYear(teachContentCourseId){
 		var id = $("#id").val();
 		var programId = $("#programId").val();
 		b_IframeLevel("${ctx}/train/manage/teachcontent!setyear.action?teachContentCourseId="+teachContentCourseId+"&id="+id+"&programId="+programId,500,100,tst);
 	}
 	
 	function setCategory(teachContentCourseId){
 		var id = $("#id").val();
 		var programId = $("#programId").val();
 		b_IframeLevel("${ctx}/train/manage/teachcontent!setcategory.action?teachContentCourseId="+teachContentCourseId+"&id="+id+"&programId="+programId,500,100,tst);
 	}
 	
 	function setCount(teachContentCourseId){
 		var id = $("#id").val();
 		var programId = $("#programId").val();
 		b_IframeLevel("${ctx}/train/manage/teachcontent!setCount.action?teachContentCourseId="+teachContentCourseId+"&id="+id+"&programId="+programId,500,100,tst);
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

<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
	 	<li><a href="programs!minput.action?id=${programId}">培训项目属性设置</a></li>
        <li><a style="cursor: pointer;" href="phase.action?programId=${programId}">项目阶段</a></li>
        <li class="active"><a style="cursor: pointer;" href="teachcontent.action?programId=${programId}&menu=menu">教学内容设置</a></li>
        <li><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>
</div>

<div class="tab-content dr-tabs-panel">
<div class="panel-body row">
<div class="col-md-12">
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
</div>
</div>
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<!--<th>模块</th>-->
		<th >教学内容名称</th>
		<th>版本号</th>
		<th>必修</th>
		<th>选修</th>
		<th>总计</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>${name}</td>
			<td>第${version}版</td>
			<td>${mustPublicCount }门(${mustPublicLength }课时)</td>
			<td>${selectPublicCount }门(${selectPublicLength }课时)</td>
			<td >${teachcontentCoursesCount }门(${teachcontentCoursesLength }课时)</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>

<form id="mainForm" name="mainForm" action="teachcontent!info.action" class="form-inline dr-form-inline"
	method="post">
	<input type="hidden" name="teachContentCoursePage.pageNo"	id="pageNo" value="${teachContentCoursePage.pageNo}" />
	<input type="hidden" name="teachContentCoursePage.orderBy" id="orderBy" value="${teachContentCoursePage.orderBy}" />
	<input type="hidden" name="teachContentCoursePage.order" id="order" value="${teachContentCoursePage.order}" />
	<input type="hidden" name="t" id="order" value="${t}" /> 
	<input type="hidden" name="id" id="id" value="${id}" /> 
	<input type="hidden" name="programId" id="programId" value="${programId}" /> 
 
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
    <tr >
    <td  colspan="5" width="30%">
	 <div class="form-group">
     <label>课程属性&nbsp;&nbsp;</label><s:select list="#{'2':'必修','1':'选修'}" listKey="key" listValue="value" name="filter_EQI_courseProp" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_courseProp)" cssClass="form-control input-sm"></s:select>
     </div>
     <div class="form-group">
   <button class="btn btn-default btn-sm" type="submit">
	<span class="glyphicon glyphicon-search"></span>
	搜索
	</button>
	</div>
   
	</td>
    </tr>
	<tr>
		<th >课程名称</th>
		<th width="20%">课程代码</th>
		<th width="10%">课程学时</th>
		<s:if test="#request.iswxeduopen=='true'"><th width="10%">学习时长</th></s:if>
		<!--<th>模块</th>-->
		<th width="10%">属性</th>
		
		<th width="10%">年度</th>		
		
		<th width="10%">类型</th>	
		
		<s:if test="#request.isShzx=='true'">	
			<th width="10%">最大报名人数</th>
		</s:if>
		<th width="35%">操作</th>
	</tr>
	<s:iterator value="teachContentCoursePage.result" status="stat">
		<tr>
			<td>&nbsp;${courseName}</td>
			<td>&nbsp;${serialNo}</td>
			<td>&nbsp;${studylength}</td>
			<s:if test="#request.iswxeduopen=='true'"><td>${studyTimeStr }</td></s:if>
			<!--<td>&nbsp;${course.courseModelString }</td>-->
			<td>&nbsp;${coursePropString }</td>
			<td>&nbsp;${year}</td>
			<td>&nbsp;${category}</td>
			<s:if test="#request.isShzx=='true'">	
				<td>&nbsp;${most}</td>
			 </s:if>
			<td>
				<div class="btn-group">
					 <button  name="setButton" class="btn btn-default btn-sm" type="button" onclick="setStudyLength(${id})">
	                <span class="glyphicon glyphicon-plus"></span>&nbsp;设置课程学时
	           		</button>  
				</div>
				<div class="btn-group">
					 <button  name="setButton" class="btn btn-default btn-sm" type="button" onclick="setYear(${id})">
	                <span class="glyphicon glyphicon-plus"></span>&nbsp;设置课程年度
	           		</button>  
				</div>
				<br/>
				<div class="btn-group">
					 <button  name="setButton" class="btn btn-default btn-sm" type="button" onclick="setCategory(${id})">
	                <span class="glyphicon glyphicon-plus"></span>&nbsp;设置课程类型
	           		</button>  
	           		
				</div>
				<s:if test="#request.isShzx=='true'">	
				<div class="btn-group">
					<button  name="setCountButton" class="btn btn-default btn-sm" type="button" onclick="setCount(${id})">
	                <span class="glyphicon glyphicon-plus"></span>&nbsp;设置最大报名人数
	           		</button>
				</div>
				</s:if>
				<div class="btn-group">
					<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="delcourse(${id})">
	                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
	           		</button>
				</div>
			</td>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="teachContentCoursePage" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</div>

</form>

<table style="margin-bottom: 5px;margin-left: 10px;">
	<tr>
		<td class="tdll">&nbsp;</td>
		<td>
		<button class="btn btn-primary btn-sm"  onclick="addcourse()">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;添加新课程</button>
		</td>
		<td>&nbsp;</td>
		<td>
        <button class="btn btn-primary btn-sm"
				onclick="window.location='teachcontent.action?programId=${programId}&menu=menu'">
		<span class="glyphicon glyphicon-backward"></span>&nbsp;返回列表</button>
		</td>
		<td>
			<!--<input type="button" value="添加新课程" class="operation_btu1 colorbox" />
		--></td>
		
		<td class="tdll" style="padding-left: 20px;">
		<button name="Submit321" onclick="window.opener=null;window.open('','_self');window.close();"
			class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon glyphicon-remove-circle"></span>&nbsp;关闭
		</button>
		</td>
	</tr>
</table>

</div>
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