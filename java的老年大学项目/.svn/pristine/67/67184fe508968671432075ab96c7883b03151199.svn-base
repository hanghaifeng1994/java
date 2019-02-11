<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if>
	<s:else><%@ include file="/common/title.jsp" %></s:else>
</title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		//为registerForm注册validate函数
		$("#form1").validate({
			rules : {
				name : {
					required : true,
					maxlength : 20
				},
				code : {
					required : true
				}
			},
			messages : {
				name : {
					required : "请输入班级名称",
					maxlength : "班级名称最多为20个字符,请重新输入"
				},
				code : {
					required : "请输入班级代码"
				}

			},
			errorPlacement : function(error, element) {
				if (document.getElementById("error_" + element.attr("name"))) {
					error.appendTo("#error_" + element.attr("name"));
				} else
					error.insertAfter(element);
			},
			errorElement : "strong"
		});
	});
</script>
<%-- <script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script> --%>
</head>

<body>
	<!--header start-->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--header over-->
	<div class="dr-wrapper">
		<section id="main" role="main">
		<div class="dr-container-fluid">
			<div class="dr-page-header">
				<h3>
					班级申请审核 <small><s:if test="clazz.check">已经审核</s:if></small>
				</h3>
			</div>
			<hr />
			<div class="btn-group">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.location.href='clazz!allow.action?clazzid=${id}'">
					<span class="glyphicon glyphicon-ok"></span> 同意开班
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default btn-sm" type="button" onclick="window.location='clazz!deny.action?clazzid=${id}'">
					<span class="glyphicon glyphicon-remove-circle"></span> 不同意开班
				</button>
			</div>

			<div class="panel panel-default mt20">
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tr>
								<th>申请人</th>
								<td width="35%" style="padding-left: 20px;">${clazzDTO.applyUser.name }</td>
								<th width="13%">申请时间</th>
								<td width="39%"><s:date name="clazzDTO.applyDate" format="yyyy-MM-dd" /></td>
							</tr>

						</table>
					</div>
				</div>
			</div>
			<div class="bs-example">
				<ul class="nav nav-tabs" id="tab">
					<li><a href="clazz!vinfo.action?id=${id }">班级情况</a></li>
					<li><a href="clazz!vcourselist.action?id=${id }">选课情况</a>
					</li>
					<li class="active"><a href="clazz!vstudents.action?id=${id }">学员列表</a>
					</li>
				</ul>
			</div>
			<div class="tab-content dr-tabs-panel">
				<%--@ include file="/common/turnpage.jsp"--%>

				<form name="deleteForm" id="mainForm" action="clazz!vstudents.action" method="post">
					<s:set name="page" value="page2" scope="request"></s:set>
					<input type="hidden" name="page2.pageNo" id="pageNo" value="${page2.pageNo}" /> <input type="hidden" name="page2.orderBy" id="orderBy" value="${page2.orderBy}" /> <input type="hidden" name="page2.order" id="order" value="${page2.order}" />
				
					<input type="hidden" name="id" value="${id }" />
					<div class="panel-body row">
						<div class="col-md-12">
							<table class="table table-bordered dr-table-default">
								<tr>
									<th>姓名</th>
									<th>性别</th>
									<th>身份证号</th>
									<th class="buleleft">单位</th>
									<th>操作</th>
								</tr>
								<s:iterator value="page2.result" status="stat">

									<tr>
										<td>&nbsp;${student.name}</td>
										<td>&nbsp;${student.sexDesc}</td>
										<td>&nbsp;${student.idcard }</td>
										<td>&nbsp;${student.unit}</td>
										<td><a href="${ctx}/user/manage/student!info.action?id=${student.id}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a>
										</td>
									</tr>

								</s:iterator>
							</table>
						</div>
					</div>
					<%@ include file="/common/turnpage.jsp"%>
				</form>
			</div>
		</div>
		<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include>
		</section>
	</div>
</body>
</html>
