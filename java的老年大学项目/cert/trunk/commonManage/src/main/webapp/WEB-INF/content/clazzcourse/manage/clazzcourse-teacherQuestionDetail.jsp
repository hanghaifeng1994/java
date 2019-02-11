<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 辅导老师辅导的课程 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<title>课程的在线提问<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp"%></s:else></title>
<link href="${staticurl}/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="${ctx}/js/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function addReplay(){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!replay.action",
		    data: {
		    	"clazzCourseQustionId":$("#clazzCourseQustionId").val(),
		    	"content":$("#content").val()
			},
			dataType:"json",
			success: function(data) {
				$("#mainForm").submit();
		   	}
		});
	}
</script>
</head>

<body>
	<center>
		<!--header start-->
		<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
			<jsp:param value="" name="menu" />
		</jsp:include>
		<!--header over-->

		<div class="dr-wrapper">
			<section id="main" role="main">
			<div class="dr-container-fluid">
				<!--正文开始-->
				<div class="dr-page-header" style="text-align: left;">
					<h3>回复详情</h3>
				</div>
				<hr />
				<div class="dr-searchbar" style="text-align: left;">
					<div style="margin:15px;"><span>提问人：${clazzCourseQuestion.student.name }</span><span style="margin-left:100px;">提问时间：${clazzCourseQuestion.questionTimeStr }</span></div>
					<div style="margin:15px;">提问：${clazzCourseQuestion.content }</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-body row">
						<div class="col-md-12">
							<form name="deleteForm" id="deleteForm" action="clazzcourse!question.action" method="post">
								<div class="panel panel-default  mt10 mb10" >
								<table  class="table table-bordered dr-table-bordered"  > 
									<tr>
										<th width="30%">回复内容</th>
										<th width="10%">回复人</th>
										<th width="10%">回复时间</th>
										<th width="10%">操作</th>
									</tr>
									<s:iterator value="questionDetailPage.result" status="stat" var="obj">
										<tr>
										<td>${content }</td>
										<td>${replayUser.username }<br/>${student.name }</td>
										<td>${createTimeStr }</td>
										<td>
											<a class="btn btn-primary btn-sm" type="button" href="${ctx }/clazzcourse/manage/clazzcourse!deleteTeacherQuestionDetail.action?id=${clazzCourseQuestion.id }&detailId=${obj.id }">
												<span class="glyphicon glyphicon-cog"></span>&nbsp;删除
											</a>
										</td>
										</tr>
									</s:iterator>
								</table>
								<s:set name="page" value="questionDetailPage" scope="request"></s:set>
								<%@ include file="/common/turnpage.jsp"%>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
		<!--正文结束-->
		<div id="replaySelect" style="display:none;" >
			<form class="well form-inline" name="addForm" id="addForm" action="clazzcourse!replay.action" method="post">
				<input type="hidden" value="" name="clazzCourseQustionId" id="clazzCourseQustionId" />
				<div id="title" style="margin-bottom:30px;font-weight:bold;"></div>
				<div>
					<textarea rows="3" cols="20" name="content" id="content" style="width:500px;height:220px;"></textarea>
				</div>
			</form>
			<div id="replaySelectTable" >
			</div>
		</div>
<!--footer start-->
   	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
   	<jsp:param value="index" name="menu"/>
   	</jsp:include>
<!--footer over-->
</body>
</html>
