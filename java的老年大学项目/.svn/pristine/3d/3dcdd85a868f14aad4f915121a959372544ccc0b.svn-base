<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/validate/messages_cn.js"
	type="text/javascript"></script>
<script src="${staticurl}/js/list2list.js" type="text/javascript"></script>
<link href="${staticurl}/css/admin_change.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
.form-control {
	width: 250px;
	float: left
}
</style>
<script>  
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
    $('#mainForm').submit(function() {
        $("#clazzmanager option").each(function() {
            $("#mainForm").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='" + $(this).val() + "'/>");
        })
    });
    jQuery("#moveright").click(function(){
		var num = 6;
		if (($("#clazzmanager option").length + $("#userPage option:selected").length) <= num){
			jQuery(this).listTolist("userPage","clazzmanager","append",false);
		}
		//else {
			//b_alert("最多"+num+"个班主任！");
		//}
		$("#userPage option:selected").each(function(){
			$(this).attr("selected","");
		});
	});

    jQuery("#delete").click(function(){
    	$("#clazzmanager option:selected").remove();
    });
});
function check() {
    var a = $('#rebate').val();
    if (a <=0 || a >1 ) {
        alert('您输入的折扣需要在0~1之间'); 
    }
   }
function createClazz(falg){
	if(falg){
		alert("完成建班后请及时修改班级测验日程");
	}
	$("#mainForm").submit();
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
<div class="dr-wrapper"><s:if test="flag2=='wxold'">
	<!--正文左边开始-->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
		<jsp:param value="input-group" name="menu" />
		<jsp:param value="clazz" name="bigmenu" />
	</jsp:include>
</s:if> <!--the end of left--> <!--正文右边开始--> 
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
	<li><span class="glyphicon glyphicon-home"></span> <a
		href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
	</li>
	<li><a href="#">班级管理</a></li>
	<li class="active">费用结算与管理</li>
</ol>
<div class="dr-page-header">
<h3>费用结算与管理</h3>
</div>
<hr />
<div class="dr-steps clearfix">
<ul role="tablist">
	<li class="first done" role="tab"><a href="#"><span
		class="current-info">current step: </span><span class="number">1.</span><span
		class="title">填写班级信息</span></a></li>
	<li class="done" role="tab"><a href="#"><span class="number">2.</span><span
		class="title">课程选择</span></a></li>
	<li class="done" role="tab"><a href="#"><span class="number">3.</span><span
		class="title">导入学员</span></a></li>
	<li class="current" role="tab"><a href="#"><span
		class="number">4.</span><span class="title">费用结算和管理设置</span></a></li>
</ul>
</div>
<div class="panel panel-default">
<form class="form-horizontal dr-form-bordered" id="mainForm"
	action="clazz!saveprice.action?programId=${programId}" method="post">
<div class="panel-body row">
<div class="col-md-12"><input type="hidden" name="id"
	value="${id}" /> <input type="hidden" name="clazzid" value="${id}" />
<input type="hidden" name="flag2" value="${flag2}" /> <input
	type="hidden" name="isdown" value="${isdown}" />

<table class="table table-bordered dr-table-default">
	<tr>
		<th width="13%">报名人数</th>
		<td>${clazzDTO.allStudentCount} 人</td>
	</tr>
	<tr>
		<th>学分/人</th>
		<td>${clazzDTO.courseStudyLength }</td>
	</tr>
	<tr>
		<th>费用总计</th>
		<td>${clazzDTO.shouldTotalPrice}</td>
	</tr>
	<tr>
		<th>实收款</th>
		<td><input name="factPrice" type="text"
			value="${clazzDTO.shouldTotalPrice}" class="txtinput01 fl" /></td>
	</tr>
	<tr>
		<th>折扣</th>
		<td><input type="text"  onblur='check()' name="rebate" id ="rebate" value="1.0" class="txtinput01 fl"/></td>
	</tr>
	<tr>
		<th>备注</th>
		<td><input name="notes" type="text" value="${clazzDTO.remarks}"
			class="txtinput01 fl" /></td>
	</tr>
	<!-- 
	<tr>
		<td class="buleleft">实收款</td>
		<td><input name="textfield38" type="text" class="txtinput01 fl" />
		</td>
	</tr> -->
</table>
</div>
</div>
</form>
<!-- 新增加的 -->
<form class="form-horizontal dr-form-bordered" id="deleteForm" name="deleteForm" action="clazz!cost.action?id=${id }&flag=${flag }&programId=${programId}&isdown=${isdown}" method="post">
<input type="hidden" name="userPage.pageNo" id="pageNo" value="${userPage.pageNo}" /> 
<input type="hidden" name="userPage.orderBy" id="orderBy" value="${userPage.orderBy}" />
<input type="hidden" name="userPage.order" id="order" value="${userPage.order}" />
<input type="hidden" name="clazzid" value="${id}" /> 
<input type="hidden" name="flag2" value="${flag2}" />
<div class="panel panel-default mt10 ">
<div class="panel-heading">
<h3 class="panel-title">班主任分配</h3>
<div class="panel-toolbar text-right dr-slash-text small"></div>
</div>
<table width="96%" class="table table-bordered dr-table-default">
	<tr>
		<td width="45%" valign="top"><s:select size="30" cssClass="txtwb" 
			id="clazzmanager" list="clazzDTO.headerClazzs" listKey="username"
			listValue="nameplusidcard" theme="simple" style="width: 100%;margin: 10px auto;border: 1px solid #CCCCCC;height: 96px;">
		</s:select>
		<button class="btn btn-default" type="button" id="delete"
			name="Submit32222"><span class="glyphicon glyphicon-trash"></span>
		删除班主任</button>
		</td>
		<td width="2%" valign="top"><a href="javascript:void(0)"> <span
			id="moveright" class="glyphicon glyphicon-arrow-left"
			style="margin-top: 130px;" title="左移"></span> </a></td>
		<td>
		<table>
			<tbody>
				<tr>
					<td width="5%" style="padding-right: 5px">姓名</td>
					<td width="15%" style="padding-right: 5px"><input
						style="display: inline; width: 150px;" name="name" type="text"
						class="form-control input-sm" value="${name}" /></td>
					<td width="8%" style="padding-right: 8px">用户名</td>
					<td width="15%" style="padding-right: 5px"><input
						style="display: inline; width: 150px;" name="username" type="text"
						class="form-control input-sm" value="${username}" /></td>
					<td width="11%">
					<button name="Submit" class="btn btn-default btn-sm" type="submit">
					<span class="glyphicon glyphicon-search"></span> 搜索</button>
					</td>
				</tr>
			</tbody>
		</table>
		<s:select size="30" cssClass="txtwb" id="userPage"
			list="userPage.result" listKey="username"
			listValue="name+'('+idcard+')'" theme="simple" style="width: 100%;margin: 10px auto;border: 1px solid #CCCCCC;height: 96px;">
		</s:select> <s:set name="page" value="userPage" scope="request"></s:set> <%@ include
			file="/common/turnpageClazzManager.jsp"%></td>
	</tr>
</table>
</div>

</form>


<div class="panel-footer">
<div class="row">
<div class="col-md-12"><s:if test="flag=='group'">
	<button class="btn btn-default pull-left" type="button"
		onclick="window.location.href='clazz!importstudent.action?id=${clazzDTO.id}&planid=${planid }'">
	<span class="glyphicon glyphicon-step-backward"></span> 上一页</button>
</s:if> <s:if test="clazzDTO.cityLevel">
	<button class="btn btn-primary pull-right" type="submit"><span
		class="glyphicon glyphicon-ok"></span> 提交建班申请</button>
</s:if> <s:else>
	<button class="btn btn-primary pull-right" type="button"
		onclick="createClazz(${iffocus})"><span
		class="glyphicon glyphicon-ok"></span> 完成建班</button>
</s:else></div>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success"
	style="display: none">
<button class="close" type="button" data-dismiss="alert"
	aria-hidden="true">×</button>
<span id="success"><s:actionmessage theme="simple" /></span></div>
<div class="alert alert-danger alert-dismissable" id="div-error"
	style="display: none">
<button class="close" type="button" data-dismiss="alert"
	aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple" /></span></div>
<!--信息提示 end-->
</div>
</div>
</div>
</div>
</section>
</div>
<!--footer start-->
<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="index" name="menu" />
</jsp:include>
<!--footer over-->
<!--正文结束-->
</body>
</html>
