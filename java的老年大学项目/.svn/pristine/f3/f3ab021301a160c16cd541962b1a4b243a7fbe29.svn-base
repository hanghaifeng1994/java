<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>待审批班级-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<!-- 市级管理员 待审核班级列表-->
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
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/clazz!delete.action";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
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
<a href="#">班级审批</a>
</li>
<li class="active">我的待审批班级</li>
</ol>
<div class="dr-page-header">
<h3>
我的待审批班级
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
<div class="btn-toolbar dr-btn-toolbar">
<button class="btn btn-primary btn-sm" onclick="window.location='clazz!input.action?flag=self'" type="button">
<span class="glyphicon glyphicon-plus"></span>
新增自主班级
</button>
<button class="btn btn-primary btn-sm" onclick="window.location='clazz!input.action?flag=group'" type="button">
<span class="glyphicon glyphicon-plus"></span>
新增集体班级
</button>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="15%">培训项目</th>
		<th width="15%">年度教学计划</th>
		<th width="13%">班级名称</th>
		<th width="13%">班级代码</th>
		<th width="13%">申请人</th>
		<th width="13%">申请时间</th>
		<th width="18%">操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg">${trainingPrograms.name}</td>
			<td class="white_bg">${teachPlan.name}</td>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${code }</td>
			<td class="white_bg">${applyUser.name }</td>
			<td class="white_bg"><s:date name="applyDate" format="yyyy-MM-dd"/></td>
			<td class="white_bg">
			<a class="btn btn-primary btn-sm" 
				href="clazz!input.action?id=${id}&programid=${trainingPrograms.id}<s:if test="!selfClass">&flag=group&randomtemp=${randomNo}</s:if>"><span class="glyphicon glyphicon-edit" style="padding-right: 17px;"></span>编辑</a>
			<button type="button" class="btn btn-default btn-sm" 	onclick="delRecord('${ctx }/clazz/manage/clazz!deletenovalid.action?ids=${id}<s:if test='flag=="group"'>&flag=group</s:if>');"><span class="glyphicon glyphicon-trash" style="padding-right: 17px;"></span>删除</button>			
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