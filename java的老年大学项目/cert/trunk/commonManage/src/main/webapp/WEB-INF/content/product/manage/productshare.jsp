<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书籍分享<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%>

<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }
		   else{
		   $("input[name='ids']").removeAttr("checked");
			   } 
	   });
	   
	   $("#checked").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/productshare!checked.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
	   }); 	
	   $("#unchecked").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/productshare!unchecked.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
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
	<jsp:param value="productshare" name="menu" />
	<jsp:param value="product" name="bigmenu" />
    </jsp:include>
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">书籍资源库管理</a>
</li>
<li class="active">书籍分享</li>
</ol>

<div class="dr-page-header">
<h3>
我的分享审核列表
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

<ul class="nav nav-tabs nav-justified">
 	<li><a href="productshare!apply.action">书籍分享 </a></li>
 	<li><a href="productshare!myapply.action">我的分享申请</a></li>
 	<li class="active"><a href="productshare.action">分享审核</a></li>
</ul>
<div class="tab-content dr-tabs-panel">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/product/manage/productshare.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<div class="form-group">
  <label>来自</label>
  <s:select list="tenantLists" listKey="id" value="tenantId" listValue="name" theme="simple"
	cssClass="form-control" name="tenantId" headerValue="--申请分享的租户--"
	headerKey=""></s:select>
</div> 
<div class="form-group">
<label>书籍名称</label>
<input name="productName" type="text" class="form-control input-sm" value="${param['productName']}"/>
</div>
<div class="form-group">
<label>书籍代码</label>
<input name="productCode" class="form-control input-sm" value="${param['productCode']}"/>
</div>
<div class="form-group">
	<label>审核状态</label>
	<select id="filter_EQI_checked" class="form-control input-sm" name="filter_EQI_checked">
		<option value="" >全部</option>
		<option value="0" <c:if test="${param.filter_EQI_checked=='0' }">selected="selected"</c:if>>未审核</option>
		<option value="1" <c:if test="${param.filter_EQI_checked=='1' }">selected="selected"</c:if>>审核通过</option>
		<option value="2" <c:if test="${param.filter_EQI_checked=='2' }">selected="selected"</c:if>>审核不通过</option>
	</select>
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
     
</div>
</form>

<form name="deleteForm" id="deleteForm" action="productshare!apply.action" method="post">
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<div class="btn-group">
<button name="Submit23"  type="button" class="btn btn-primary btn-sm" id="checked"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量审核通过</button>
</div>
<div class="btn-group">
<button name="Submit24"  type="button" class="btn btn-default btn-sm" id="unchecked"><span class="glyphicon glyphicon-trash"></span>&nbsp;批量审核不通过</button>
</div>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="4%"><input type="checkbox" id="checkboxall"/></th>
		<th width="20%">书籍名称</th>
		<th width="20%">书籍编码</th>
		<th width="20%">来自</th>
		<th width="10%">审核状态</th>
		<th width="20%">操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids"	value="${id}" /></td>
			<td title="${productName}"><common:cut len="30" string="${productName}"/></td>
			<td>&nbsp;${productCode}</td>
			<td>${applyTenantName }</td>
			<td>${checkedStr }</td>
			<td>
				<a href="${ctx }/product/manage/productshare!checked.action?ids=${id}">
				<button class="btn btn-primary btn-sm" type="button">
					<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;审核通过
				</button>
				</a>
				<a href="${ctx }/product/manage/productshare!unchecked.action?ids=${id}">
				<button class="btn btn-default btn-sm" type="button">
					<span class="glyphicon glyphicon-trash"></span>&nbsp;审核不通过
				</button>
				</a>
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>    
</div>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
<!--正文结束-->
</div>
</html>