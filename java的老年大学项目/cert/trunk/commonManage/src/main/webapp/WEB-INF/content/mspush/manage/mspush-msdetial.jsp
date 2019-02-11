<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短信详情列表-后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
</script>
</head>

<body>
	<!-- navbar start -->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!-- navbar end -->

	<!-- container start -->
	<div class="dr-wrapper">

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li><a href="#">考试管理</a></li>
				<li class="active"><span>短信列表</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					短信列表<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>

			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none;">
				<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
				<span id="success"><s:actionmessage theme="simple" /></span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none;">
				<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
				<span id="error"><s:actionerror theme="simple" /></span>
			</div>
			<!--信息提示 end-->

			<!--搜索模块-->
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="mspush!mslist.action?id=${id}" method="post">
				<input type="hidden" name="mspage.pageNo" id="pageNo" value="${mspage.pageNo}" /> 
				<input type="hidden" name="mspage.orderBy" id="orderBy" value="${mspage.orderBy}" />
				<input type="hidden" name="mspage.order" id="order" value="${mspage.order}" />
				<div class="dr-searchbar">
					<div class="form-group">
				     <label>用户名</label>
				     <input class="form-control input-sm" type="text" name="userName" id="userName" value="${param['userName']}"/>
			      </div>

					<div class="form-group">
						<button class="btn btn-default btn-sm" name="Submit5" onclick="$('#pageNo').val('1');document.mainForm.submit()">
							<span class="glyphicon glyphicon-search"></span> 搜索
						</button>
					</div>
<%-- 					<div class="form-group">
						<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" onclick="exportexcel();">
							<span class="glyphicon glyphicon-export"></span>&nbsp;导出
						</button>
						<span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"> <a href="" target="_blank">待考人员导出excel文件下载</a> </label> </span>
					</div> --%>
				</div>
				<!--搜索模块end-->
				<div class="panel panel-default">
					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<!-- <td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall" />-->
								</td>
								<th width="12%">用户名</th>
								<th width="12%">姓名</th>
								<th width="12%">项目/班级</th>
								<th width="10%">手机号码</th>
								<th width="10%">发送时间</th>
								<th width="8%">发送状态</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="mspage.result" status="stat">
								<tr>
									<td>${userName}</td>
									<td>${name}</td>
									<s:if test="programName!=null&&programName!=''">
										<td>${programName}</td>
									</s:if> 
									<s:else> 
										<td>
										<s:if test="clazzName!=null&&clazzName!=''">
										${clazzName}
										</s:if>
										<s:else>
										 暂无项目
										</s:else>
										</td>
									</s:else>
									<td>${telephone}</td>
									<td><s:date name="gainData" format="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
									<s:if test="gainSucceed==2">
									成功</s:if>
									<s:if test="gainSucceed==0">
									待发送</s:if>
									<s:if test="gainSucceed==1">
									失败</s:if>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</form> 
			<s:set name="page" value="mspage" scope="request"></s:set>
			 <%@ include file="/common/turnpage.jsp"%>
		</div>
		<!--footer start--> 
		<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> 
		<!--footer over--> 
		</section>
	</div>
	<!-- container end -->
</body>

</html>