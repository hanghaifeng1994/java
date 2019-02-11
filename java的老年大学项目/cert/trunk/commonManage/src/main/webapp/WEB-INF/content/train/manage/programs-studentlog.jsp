<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${trainingPrograms.name} <s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">  
	function disblock(obj)
	{
		if($(obj).val()!="true"){
			$(".tmp").hide();
			$("#certificateName").val("");
			$("#certificateOrganization").val("");
		}else
			$(".tmp").show();
	}
	$(document).ready(function() {
		<s:if test="trainingPrograms.haveCertificate">
			$(".tmp").show();
		</s:if>
		<s:else>
			$(".tmp").hide();
		</s:else>
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
			,descr:
			{
			//	required: true
			}
			,xuezhi:
			{
				required: true
			}
			,hours:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入项目名称",
 					maxlength: "项目名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入项目编号"
				} 
				,descr:
				{
					required: "请输入项目介绍"
				} 
				,xuezhi:
				{
					required: "请输入学制"
				} 
				,hours:
				{
					required: "请输入学分"
				} 
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});
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
<label style="margin-right: 10px;">${trainingPrograms.name}</label>项目管理
</h3>
</div>
<hr />

<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li><a href="programs!minput.action?id=${id}">培训项目属性设置</a></li>
        <li><a href="programs!teachplans.action?itemid=${id}&menu=menu">教学计划设置</a></li>
        <li class="active"><a style="cursor: pointer;" href="programs!studentlog.action?id=${id}">学员培训记录查询</a></li>
        <li><a href="${staticurl}/clazz/manage/clazz.action?programsid=${id}">项目班级</a></li>
    </ul>                
</div>
 
<div class="tab-content dr-tabs-panel" style="margin-bottom: 10px;">
<div class="panel-body row">

<table class="table table-bordered dr-table-default">
	<tr>
		<th width="13%">项目类型</th>
		<td colspan="3">${trainingPrograms.catName}</td>
	</tr>
	
	<tr>
		<th>培训项目名称</th>
		<td width="35%">${trainingPrograms.name }</td>
		<th width="13%">培训项目代码</th>
		<td width="39%">${trainingPrograms.code }</td>
	</tr>
	<tr>
		<th>学制</th>
		<td>${trainingPrograms.xuezhi } 年</td>
		<th>毕业学分要求</th>
		<td>${trainingPrograms.hours}学分</td>
	</tr>
</table>

</div>

<div class="panel panel-default">
<div class="panel-heading">
<div class="panel-toolbar">
	<ul class="nav nav-tabs pull-left" id="tab">
	<li class="<s:if test="finished!='true'" >active</s:if><s:else></s:else>"><a
		href="programs!studentlog.action?id=${id }&finished=false">未完成学分要求</a></li>
	<li class="<s:if test="finished!='true'" ></s:if><s:else>active</s:else>"><a
		href="programs!studentlog.action?id=${id }&finished=true"
		class="tt_tabon">已完成学分要求</a></li>
    </ul>                
</div>
</div>
<div class="panel-body">
<div class="dr-searchbar">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="programs!studentlog.action"
	method="post"><input type="hidden"
	name="page2.pageNo" id="pageNo"
	value="${page2.pageNo}" /> <input type="hidden"
	name="page2.orderBy" id="orderBy"
	value="${page2.orderBy}" /> <input type="hidden"
	name="page2.order" id="order"
	value="${page2.order}" />
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="finished" value="${finished}"/>

<div class="form-group">
<label>姓名</label>
			<input name="filter_LIKES_name" class="form-control input-sm" style="width: 90px;"
				value="${param['filter_LIKES_name']}" />
</div>
<div class="form-group">
<label>身份证号</label>
<input name="filter_LIKES_idcard" class="form-control input-sm" style="width: 160px;"
				value="${param['filter_LIKES_idcard']}" /></div>
<div class="form-group">
<label>性别</label>
		 <s:select name="filter_EQS_sex" cssClass="form-control"
			list="#{'-所有-':'','男':'m','女':'f'}" theme="simple" listKey="value" value="@java.lang.Integer@Integer(#parameters.filter_EQS_sex)"
			listValue="key"></s:select>
</div>
<div class="form-group">
<label>单位</label>
 <input name="filter_LIKES_unit" class="form-control input-sm"
				value="${param['filter_LIKES_unit']}" />
</div>
<div class="form-group">
<label>开始年度 </label>
		 <s:select name="filter_EQI_startYear" cssClass="form-control"
			list="#{'-所有-':'','2010':'2010','2011':'2011','2012':'2012','2013':'2013','2014':'2014','2015':'2015','2016':'2016'}" theme="simple" listKey="value" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_startYear)"
			listValue="key"></s:select>
</div>
<div class="form-group">
<button class="btn btn-default btn-sm" type="submit">
<span class="glyphicon glyphicon-search"></span>&nbsp;搜索
</button>
</div>
</form>
</div>


<div class="panel-body row">

<table class="table table-bordered dr-table-default">
	<tr>
		<th>姓名</th>

		<th>性别</th>
		<th>身份证号</th>
		<th>单位</th>
		<th>开始年度</th>
		<th>累计获得学分</th>
		<th>操作</th>
	</tr>

	<s:iterator value="page2.result" status="stat">
		<tr>
			<td>&nbsp;${user.name}</td>
			<td>&nbsp;${user.sexDesc}</td>
			<td>&nbsp;${user.idcard }</td>
			<td>&nbsp;${unit}</td>
			<td>&nbsp;${startYear}</td>
			<td>&nbsp;${expiredCourseStudyLength}</td>
			<td><a target="_blank" href="${ctx }/user/manage/student!info.action?id=${user.id }" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a>
			</td>
		</tr>
	</s:iterator>

</table>
<s:set name="page" value="page2" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>

</div>




</div>
</div>
<div class="panel-body row" align="center">
  		<button name="Submit321" onclick="window.opener=null;window.open('','_self');window.close();"
			class="btn btn-default">
			<span class="glyphicon glyphicon glyphicon-remove-circle"></span>&nbsp;关闭
		</button>
</div>
</div>
</div>
</section>
</div>
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
