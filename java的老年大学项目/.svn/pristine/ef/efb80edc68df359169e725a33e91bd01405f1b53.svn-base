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
	$(function(){
		if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();    
	   	$("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
	   	});
		 $("#batchDelDown").click(function(){
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action="${ctx }/clazzcourse/manage/clazzcourse!batchDeleteTeacherQuestion.action?courseId=${courseId}";
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
	function myreplay(id){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!getQuestionDetail.action",
		    data: {
		    	"id":id
			},
			dataType:"json",
			success: function(data) {
				$("#title").html(data.content);
				$("#clazzCourseQustionId").val(data.id);
		   	}
		});
		
		$('#replaySelect').dialog({
				title : '我要回答',
				width:600,
				height:480,
				autoOpen : true,
				modal : true,
				resizable : false,
				buttons : {
					'确认' : function() {
						addReplay();
						$('#replaySelect').dialog('close');
						
					},
					'取消' : function() {
						$('#replaySelect').dialog('close');
					}
				}
		});
	}
	
	
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
					<h3>在线提问</h3>
				</div>
				<hr />
				<!--信息提示-->
				<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="success"><s:actionmessage  theme="simple"/></span>
				</div>
				<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="error"><s:actionerror theme="simple"/></span>
				</div>
				<div class="dr-searchbar" style="text-align: left;">
					<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/clazzcourse/manage/clazzcourse!teacherQuestion.action" method="GET">
						<div class="dr-searchbar">
						<input type="hidden" name="questionPage.pageNo" id="pageNo" value="${questionPage.pageNo}" />
						<input type="hidden" name="questionPage.orderBy" id="orderBy" value="${questionPage.orderBy}" />
						<input type="hidden" name="questionPage.order" id="order" value="${questionPage.order}" />
						<input type="hidden" name="courseId" value="${courseId }" id="courseId"/>
						<div class="form-group">
							 <label>班级名称</label>
							  <input class="form-control input-sm" type="text" name="clazzName" id="clazzName" value="${clazzName }"/>
						</div>
						<div class="form-group">
							 <label>状态</label>
							<s:select list="#{'false':'未回复','true':'已回复'}" listKey="key" listValue="value" cssClass="form-control input-sm"
									    theme="simple" name="filter_EQB_replay" headerKey="" value="(#parameters.filter_EQB_replay)"
										headerValue="全部"></s:select>	
						</div>
						
						<div class="form-group">
						<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
						<span class="glyphicon glyphicon-search"></span>
						  搜索
						</button>
						</div>
						</div>
						</form>
				</div>

				<div class="panel panel-default">
					<div class="panel-body row">
						<div class="col-md-12">
							<form name="deleteForm" id="deleteForm" action="clazzcourse!question.action" method="post">
								<div class="panel panel-default  mt10 mb10" >
									<div class="btn-toolbar dr-btn-toolbar">
								      	 <div class="btn-group">
											<button id="batchDelDown" class="btn btn-default btn-sm" name="Submit2" type="button">
											<span class="glyphicon glyphicon-trash"></span>
											批量删除
											</button>
										</div>
								    </div>
							    </div>
								<table class="table table-bordered dr-table-default"> 
									<tr>
										<th width="3%"><input type="checkbox" id="checkboxall" /></th>
										<th width="10%">班级名称</th>
										<th width="10%">课程名称</th>
										<th width="10%">学员账号<br/>姓名</th>
										<th width="30%">问题</th>
										<th width="10%">时间</th>
										<th width="10%">状态</th>
										<th width="20%">操作</th>
									</tr>
									<s:iterator value="questionPage.result" status="stat">
										<tr>
										<td ><input type="checkbox" name="ids" value="${id}" /></td>
										<td>${clazzName }</td>
										<td>${courseName }</td>
										<td>${student.username }<br/>${student.name }</td>
										<td>${content }</td>
										<td>${questionTimeStr }</td>
										<td>
											<s:if test="replay"><span style="color:green;">已回复（${replayCount }）</span></s:if><s:else><span style="color:red;">未回复</span></s:else>
										</td>
										<td>
											<button class="btn btn-primary btn-sm" type="button" onclick="myreplay('${id}')">
												<span class="glyphicon glyphicon-cog"></span>&nbsp;我要回答
											</button>
											<a class="btn btn-primary btn-sm" type="button" href="${ctx }/clazzcourse/manage/clazzcourse!teacherQuestionDetail.action?id=${id}" target="_blank">
												<span class="glyphicon glyphicon-cog"></span>&nbsp;详情
											</a>
										</td>
										</tr>
									</s:iterator>
								</table>
								<s:set name="page" value="questionPage" scope="request"></s:set>
								<%@ include file="/common/turnpage.jsp"%>
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
