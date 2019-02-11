<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 引用自clazzHeader界面的部分开始 -->
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
function changeClazz(value){
	window.location.href="${ctx}/clazz/manage/headerclazz!schedule.action?headerClazzId="+value
}
</script>
<!-- 结束 -->
<!-- 班主任管理的班级主页面 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp" %>
<title>没有班级可管理<%@ include file="/common/title.jsp" %></title>
<!--<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />-->
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

<div class="dr-searchbar">
<div class="form-inline dr-form-inline">
<div class="form-group">
<label>我管理的班级</label>
<!-- 	private int openClazzNum;//开放班级数量
	private int unClazzNum;//未开始班级数量
	private int endClazzNum;//结束班级数量 -->
<span class="help-block" style="display: inline">（开放中：${openClazzNum} | 未开始：${unClazzNum} | 结束：${endClazzNum}）</span>
</div>
<!--<s:select cssStyle="float:right;" list="curHeaderClazzs" listKey="id" listValue="clazz.nameplusStatus" cssClass="form-control input-sm" value="headerClazzId" onchange="changeClazz(this.value)"></s:select>
-->
</div>
</div>

<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12" style="align:center;">
<h1 align="center"><font color="#333333">您暂无管理的班级</font></h1>
</div>
</div>
</div>

</div>
</section>
</div>

<!--正文结束-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>
