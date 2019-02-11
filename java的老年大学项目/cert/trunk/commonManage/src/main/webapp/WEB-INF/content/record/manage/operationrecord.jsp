<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/common/admin_meta.jsp" %>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  

<script>
$(document).ready(function(){
    $("#creatTime01").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	}); 
   $("#creatTime02").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	 }); 
	
})
</script>

</head>
<body>

<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
 <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="operationdetail" name="menu" />
	<jsp:param value="operation" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
      <li> <span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#" >平台首页</a></li>
      <li> <a href="#" >日志</a> </li>
      <li class="active">操作日志 </li>
    </ol>
   <div class="dr-page-header">
     <h3>操作日志 </h3>
   </div>
   <hr/>
    <s:if test="curTenantID==null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="operationrecord.action?isMy=true">大平台操作日志</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="operationrecord.action?isMy=false">租户操作日志</a></li>
     </ul>
    </s:if>
    <div class="tab-content dr-tabs-panel"> 

<form id="mainForm" name="mainForm" action="operationrecord.action" method="post" class="form-inline dr-form-inline">
	        <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	        <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	        <input type="hidden" name="page.order"	id="order" value="${page.order}" />
	        <input type="hidden" name="isMy" id="isMy" value="${isMy}" />
	<div class="dr-searchbar">
	<s:if test="curTenantID==null">
    <s:if test="!isMy">
	  <div class="form-group">
    	<label>租户</label>
  	   <s:select list="tenantLists" listKey="id" headerValue="--选择租户--" headerKey="" value="tenantId" listValue="name" theme="simple" 
	    cssClass="form-control" name="tenantId"></s:select>
	  </div>
    </s:if>
  </s:if>

	 <div class="form-group">
                <label>操作人</label>
                <input style="width: 118px" name="filter_LIKES_operator" type="text"  class="form-control input-sm" value="${param['filter_LIKES_operator']}"/>
     </div>
     
     <div class="form-group">
                <label>用户名</label>
                <input style="width: 118px" name="filter_EQS_username" type="text" onchange="idcardcheck()" class="form-control input-sm" value="${param['filter_EQS_username']}"/>
     </div>	
     
     <div class="form-group">
                <label>内容</label>
                <input style="width: 118px" name="filter_LIKES_operationThing" type="text"  class="form-control input-sm" value="${param['filter_LIKES_operationThing']}"/>
     </div>
     
     
      <div class="form-group">
                <label>类型</label>
                <s:select list="#{'线下支付':1,'班级审核':2,'追加学员':3,'更换课程':4,'更换班级':5,'删除用户':6,'删除班级学员':7,'删除班级':8,'删除课程':9,'删除阶段':10,'阶段开放关闭':11,'删除项目':12}" cssClass="form-control" listKey="value" theme="simple" 
				listValue="key" headerValue="所有" headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_actionType)"
				name="filter_EQI_actionType">
				</s:select>
     </div>	
     <div class="form-group">
                <label>时间</label>
                <input name="filter_GED_operationDate" id="creatTime01" class="form-control input-sm" style="width: 90px"
				value="${param['filter_GED_createTime']}"/>- <input
				id="creatTime02" name="filter_LED_operationDate" class="form-control input-sm" value="${param['filter_LED_createTime']}" style="width: 90px"
				/>
     </div>	
       <div class="form-group">
               	<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
           </div>
     
	</div>
</form>


<form name="deleteForm" id="deleteForm" action="operationrecord.action" method="post">	
<table class="table table-bordered dr-table-bordered">
	<tr>
		<th width="20%">操作人</th>
		<s:if test="curTenantID==null && !isMy">
		<th width="8%" > 来自</th>
		</s:if>
		<th  width="20%">时间</th >
		<th  width="20%">类型</th >
		<th  width="40%">内容</th >
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>${operator}(${username})</td>
			<s:if test="curTenantID==null && !isMy">
			<td >${tenantName} </td>
			</s:if>
			<td><s:date name="operationDate" format="yyyy.MM.dd HH:mm:ss" /></td>
			<td>${typedesc}</td>
			<td>${operationThing}</td>
		</tr>
		
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</form>
</div>
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