<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>班级审批-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){   
		 
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
		});

		//验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action?ID=${id}";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
			 }); 

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/clazz!delete.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
			 }); 	
		 

		 
	   $("#batchEnableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!enable.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
			 }); 

	   $("#batchDisableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!disable.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
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
    <jsp:param value="validateclazz" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
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
<li class="active"><span>已审批班级</span></li>
</ol>
<div class="dr-page-header">
<h3>
已审批班级
</h3>
</div>
<hr/>
<div class="dr-searchbar">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="clazz!validateclazz.action"
	method="post">
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/> 
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/> 
	<input type="hidden" name="page.order" id="order" value="${page.order}"/>
		
		<div class="form-group">
		<label>培训项目</label>
				<s:select list="programList" listKey="id" cssClass="form-control input-sm"
				listValue="name"
				value="@java.lang.Integer@parseInt(#parameters.filter_EQL_program$id)"
				name="filter_EQL_program$id" theme="simple"
				headerValue="请选择培训项目" headerKey="" id="programsid"></s:select>
		</div>
		<div class="form-group">
		<label>项目阶段</label>
			<s:select list="phaseList" listKey="id" cssClass="form-control input-sm"
				listValue="name"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_phase$id)"
				name="filter_EQL_phase$id" theme="simple"
				headerValue="--请选择项目阶段--" headerKey="" id="phaseId"></s:select>
		</div>
		<div class="form-group">
		<label>教学内容</label>
			<s:select list="teachContentList" listKey="id" cssClass="form-control input-sm"
				listValue="name+'(第'+version+'版)'"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_teachContent$id)"
				name="filter_EQL_teachContent$id" theme="simple"
				headerValue="--请选择教学内容--" headerKey="" id="teachContentId"></s:select>	 
		<input type="hidden" name="programId" value="${programId }" id="hiddenprogramsid" />
		<input type="hidden" name="phaseId" value="${phaseId }" id="hiddenplanid" />
		</div>	
	    <div class="form-group">
		<label>班级名称</label>
		<input name="filter_LIKES_name" value="${param['filter_LIKES_name']}" class="form-control" />
		</div>	
		<div class="form-group">
		<label>班级代码</label>
		<input name="filter_LIKES_code" class="form-control" value="${param['filter_LIKES_code']}" />
		</div>
		
		<div class="form-group">
		<label>状态:</label>
		<input id="filter_EQI_validate_status-1" type="checkbox" value="3" name="filter_EQI_validate_status"/>
		<span>通过</span>
		<input id="filter_EQI_validate_status-2" type="checkbox" value="2" name="filter_EQI_validate_status"/>
		<span>未通过</span>
		<input id="__multiselect_filter_EQI_validate_status" type="hidden" value="#parameters.filter_EQI_validate_status" name="__multiselect_filter_EQI_validate_status"/> 
		</div>

<div class="form-group">
<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
 搜索
</button>
</div>
</form>
</div>
<form name="deleteForm" id="deleteForm" action="clazz!validateclazz.action"
	method="post">
<div class="panel panel-default">

<table class="table table-bordered dr-table-default">
	<tr>
		<!--<th width="3%"><input type="checkbox"
			id="checkboxall" /></th> -->
		<th width="15%">培训项目</th>
		<th width="13%">培训阶段</th>
		<th width="11%">班级名称</th>
		<th width="7%">班级代码</th>
		<th width="10%">申请人</th>
		<th width="10%">申请时间</th>
		<th width="8%">审批状态</th>
		<s:if test="currentTenant==null"><th width="15%">来自</th></s:if>
		<th width="10%">管理</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<!--<td class="white_bg"><input type="checkbox" name="ids"
				value="${id}" /></td> -->
			<td class="white_bg">${programName}</td>
			<td class="white_bg">${phaseName}</td>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${code}</td>
			<td class="white_bg">${applyUser.name }</td>
			<td class="white_bg">&nbsp;<s:date name="applyDate" format="yyyy-MM-dd"/></td>
			<td class="white_bg">
			<s:if test="validate_status==3">通过</s:if> 
			<s:if test="validate_status==2">不通过</s:if>
			<s:if test="validate_status==1">待审</s:if>
			</td>
			<s:if test="currentTenant==null"><td>${tenant.name}</td></s:if>
			<td class="white_bg">
			<a class="btn btn-primary btn-sm" href='clazz!students.action?id=${id }'>
			<span class="glyphicon glyphicon-list-alt"></span>&nbsp;学员列表</a>
			</td>
		</tr>
	</s:iterator>

</table>

<div class="operation_list"><%@ include file="/common/turnpage.jsp"%></div>
</div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->
</body>
</html>