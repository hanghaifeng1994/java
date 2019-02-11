<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript">
	function resetPassword(uid)
	{
		 b_confirm('密码将重置成身份证后6位数字，确认操作吗?', function() {
			 $.post("clazz!resetPassword.action",{id:uid},function(result){
				    if(result=='true')
					    b_alert('修改密码成功');
				    else
				    	b_alert('修改密码失败，稍后重试'); 
			 });
 	   });
		
	}
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
				 // document.getElementById("deleteForm").action = oaction;
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
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
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
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
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
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
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
	<jsp:param value="validateclazz" name="menu" />
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
<li class="active">班级学员</li>
</ol>

<div class="mt20">
<form id="mainForm" name="mainForm" action="clazz!students.action"
	method="post"><input type="hidden" name="page.pageNo"
	id="pageNo" value="${page.pageNo}" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="id" value="${id }"/>

</form>
</div>

<form name="deleteForm" id="deleteForm" action="item!delete.action"
	method="post">

<div class="panel panel-default">
<table class="table table-bordered dr-table-default">
	<tr>
	    <th>姓名</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>单位</th>
		<th>是否在线</th>		
		<th>操作</th>
	</tr>
		<s:iterator value="page2.result" status="stat">
		<tr>
			<td class="white_bg">&nbsp;${student.name}</td>
			<td class="white_bg">&nbsp;${student.sexDesc}</td>
			<td class="white_bg">&nbsp;${student.idcard }</td>
			<td class="white_bg">&nbsp;${student.unit}</td>
			<td class="white_bg">&nbsp;<s:if test="student.online">在线</s:if><s:else>离线</s:else></td>			
			<td class="white_bg">
			<a href="${ctx}/user/manage/student!info.action?id=${student.id}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a> &nbsp;&nbsp;
			<a href="#" class="btn btn-primary btn-sm" onclick="resetPassword(${student.id}) "><span class="glyphicon glyphicon-repeat"></span>&nbsp;重置密码</a>
			</td>
		</tr>
	</s:iterator>

</table>
<s:set name="page" value="page2" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
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
</body>
</html>