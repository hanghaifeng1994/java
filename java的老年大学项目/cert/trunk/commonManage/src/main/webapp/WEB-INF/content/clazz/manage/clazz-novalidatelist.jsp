<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>待审批班级-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript">
    $(document).ready(function(){   
		 
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
		});

		//验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/item/manage/item!delete.action?ID=${itemCategory.id}";
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
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
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
	<jsp:param value="novalidateclazz" name="menu" />
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
<li class="active">待审批班级</li>
</ol>
<div class="dr-page-header">
<h3>
待审批班级
</h3>
</div>
<hr/>
<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<form id="mainForm" name="mainForm" action="clazz!novalidateclazz.action" method="post">
<input type="hidden" name="page.pageNo" id="pageNo"
	value="${page.pageNo}" /> <input type="hidden" name="page.orderBy"
	id="orderBy" value="${page.orderBy}" /> <input type="hidden"
	name="page.order" id="order" value="${page.order}" /></form>
<form name="deleteForm" id="deleteForm" action="clazz!novalidateclazz.action"
	method="post">
<div class="panel panel-default">
<table class="table table-bordered dr-table-default">
	<tr>
	   <th width="12%">班级名称</th>
		<th width="12%">班级代码</th>
		<th width="13%">培训项目</th>
		<th width="12%">项目阶段</th>
		<th width="12%">申请人</th>
		<th width="12%">申请时间</th>
		<s:if test="currentTenant!=null"><th width="15%">来自</th></s:if>
		<th width="13%">操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${code }</td>
			<td class="white_bg">${programName}</td>
			<td class="white_bg">${phaseName}</td>
			<td class="white_bg">${applyUser.name }</td>
			<td class="white_bg"><s:date name="applyDate" format="yyyy-MM-dd"/></td>
			<s:if test="currentTenant!=null"><td>${currentTenant.name}</td></s:if>
			<td class="white_bg">			
			<button type="button" class="btn btn-primary btn-sm" onclick="window.open('clazz!vinfo.action?id=${Id}')">
				<span class="glyphicon glyphicon-edit" style="padding-right: 17px;"></span>审核</button>      
  		    </td>

		</tr>
	</s:iterator>
</table>
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
<!--正文结束-->

</body>
</html>