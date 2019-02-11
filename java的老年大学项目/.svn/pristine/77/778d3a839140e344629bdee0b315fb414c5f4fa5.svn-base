<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<link href="${staticurl}/css/admin_change.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
 .txtwb {
    border: 1px solid #CCCCCC;
    height: 80px;
    margin: 10px auto;
    width: 96%;
</style>
<script >
$(document).ready(function() {
	$("#userPage").click(function(){
		selectVal = $("#userPage option:selected").val();
		selectText = $("#userPage option:selected").text();
		parent.setValue(selectVal,selectText);
		});
})
</script>
</head>
<body>
<!--正文开始-->
<div>
<section id="main" role="main">
<div style="background-color:#f5f5f5; padding:10px;box-shadow: 0 -8px 6px 4px rgba(0, 0, 0, 0.2);">
  <!--查询条件 -->
  <div class="dr-searchbar">
	<form class="form-horizontal dr-form-bordered" id="mainForm" action="clazz!selectClazzManager.action" method="post" enctype="multipart/form-data" name="mainForm">
	<input type="hidden" name="page.pageNo" id="pageNo" value="1"/>
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}"/>
	<input type="hidden" name="id" id="order" value="${id}"/>
	<input type="hidden" name="tenantId" value="${tenantId}"/>
	<table class="table table-bordered dr-table-bordered">
		<tr>
			<td>
			<table>
			<tbody>
			<tr>
			<td width="3%" style="padding-right:5px">姓名</td>
			<td width="15%" style="padding-right:5px"><input style="display: inline"  name="name" type="text" class="form-control input-sm" value="${name}"/></td>
			<td width="4%" style="padding-right:5px">用户名</td>
			<td width="15%" style="padding-right:5px"><input style="display: inline" name="username" type="text" class="form-control input-sm" value="${username}"/></td>
			<td width="11%">
			<button name="Submit" class="btn btn-default btn-sm" type="submit">
	        <span class="glyphicon glyphicon-search"></span>
	                       搜索
	        </button>
			</td>
			</tr>
			</tbody>
			</table>
			<s:select size="10"  cssClass="txtwb"
			id="userPage" list="userPage.result" listKey="username" listValue="name+'('+idcard+')'"  theme="simple">
			</s:select> 
			<s:set name="page" value="userPage" scope="request"></s:set>
			<%@ include file="/common/turnpageClazzManager.jsp"%>
			</td>
		</tr>
	</table>
	</form>
  </div>  
  </div>
  </section>
</div>
<!--正文结束-->
</body>
</html>