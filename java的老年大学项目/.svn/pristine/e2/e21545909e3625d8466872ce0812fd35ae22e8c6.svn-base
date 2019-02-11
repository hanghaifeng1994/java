<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<s:set name="user"
	value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>班级学员查询<%@ include file="/common/title.jsp" %></title>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css"
	type="text/css" rel="stylesheet" />
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"
	type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript"></script>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	if("${export}"==true||"${export}"=="true"){
		   $('#exportbut').hide();
		   checkover();
		}
})
$(function(){
	 $("#finishedTime01,#finishedTime02").datetimepicker({
    	 customFormat: "yyyy-mm-dd hh:ii:ss",
		 format: "yyyy-mm-dd hh:ii:ss",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	}); 
});
function idcardcheck(){
    var idcard = $.trim($("#idcard").val());
    var checkidcard=idCardNoUtil.checkIdCardNo(idcard);
    if(idcard!=""){
    if(!checkidcard)  
      {  
          alert("身份证输入不合法");  
          return  false;  
       } 
    } 
	}

function checkover(){
	$.ajax({
        type: "POST",
        url: "headerclazz!isFinishExportNew.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
				 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
				 $('#font').hide();
				 $('#exportbut').show();
			 }else{
				 setTimeout('checkover()',3000);
		     } 
        }
	});
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
		<section id="main" role="main">
		<div class="dr-container-fluid">
			<%@ include file="/common/clazzHeader.jsp"%>

			<div class="bs-example">
				<ul class="nav nav-tabs" id="tab">
					<li class="active"><a href="#">课程实施管理</a></li>
				</ul>
			</div>

			<div class="tab-content dr-tabs-panel">
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tr>
								<td class="buleleft" width="50%">课程名称</td>
								<td class="buleleft">操作</td>
							</tr>
							<s:iterator value="classCourseDTOs" status="stat">
								<tr>
									<td>&nbsp;${course.name}</td>
									<td>&nbsp; <s:if test="course.newlp">
											<a href="#" onclick="lpoperaction(${course.id})"
												class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;课程实施</a>
										</s:if> <s:else>
											<a
												href="${ctx }/course/manage/course!schedule.action?id=${course.id}&headerClazzId=${headerClazzId}"
												target="_blank" class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;作业日程管理</a>
											<a
												href="${ctx}/course/manage/course!examSchedule.action?id=${course.id}&headerClazzId=${headerClazzId}"
												target="_blank" class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;测验日程管理</a>
										</s:else>
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			<%@ include	file="/common/tagtitle.jsp"%>
			<div class="tab-content dr-tabs-panel">
				<div class="dr-searchbar">
					<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="headerclazz!examStudents.action" method="post">
						<input type="hidden" name="examStudentPage.pageNo" id="pageNo" value="${examStudentPage.pageNo}" /> 
						<input type="hidden" name="examStudentPage.orderBy" id="orderBy" value="${examStudentPage.orderBy}" /> 
						<input type="hidden" name="examStudentPage.order" id="order" value="${examStudentPage.order}" /> 
						<input type="hidden" name="headerClazzId" id="order" value="${headerClazzId}" />
						<input type="hidden" name="tabnum" id="tabnum" value="3" />
						<input type="hidden" name="export" value="false" id="export"/>
						<div class="form-group">
							<label class="control-label"> 完成时间 </label>
						</div>
						<div class="form-group" style="width: 300px;">
							<div class="input-group date" id="finishedTime01">
								<input type="text" value="${param['filter_GED_finishedTime']}"
									name="filter_GED_finishedTime" readonly="readonly"
									class="form-control input-sm" style="width: 100%;" /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-th"></span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">-</label>
						</div>
						<div class="form-group" style="width: 300px;">
							<!--<input name="filter_GED_finishedTime" id="finishedTime01" style="width: 90px" value="${param['filter_GED_finishedTime']}" class="form-control input-sm"/>-->
							<div class="input-group date" id="finishedTime02">
								<input type="text" value="${param['filter_LED_finishedTime']}"
									name="filter_LED_finishedTime" readonly="readonly"
									class="form-control input-sm" style="width: 100%;" /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-th"></span></span>
							</div>
							<!--<input name="filter_LED_finishedTime" id="finishedTime02" value="${param['filter_LED_finishedTime']}" style="width: 90px" class="form-control input-sm"/>-->
						</div>
						<div class="form-group">
							<label>预约批次</label> <select name="filter_EQS_focusExamTime" id="filter_EQS_focusExamTime" style="width:160px;height:30px;">
								<option value="">--全部--</option>
								<c:forEach items="${YYBatch}" var="item">
									<option value="${item.id }" <c:if test="${item.id eq param['filter_EQS_focusExamTime'] }">selected="selected"</c:if>>${item.batchName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
						    <label>用户名</label>
						    <input class="form-control input-sm" type="text" name="userName" value="${param['userName']}"/>
					     </div>
					     <div class="form-group">
						    <label>姓名</label>
						    <input class="form-control input-sm" type="text" name="name" value="${param['name']}"/>
					     </div>
						<div class="form-group">
							<button class="btn btn-default btn-sm" name="Submit5"
								onclick="$('#pageNo').val('1');document.mainForm.submit()">
								<span class="glyphicon glyphicon-search"></span> 搜索
							</button>
						</div>
							<div class="form-group">
				       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
				         onclick="$('#export').val('true');document.mainForm.submit()"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
					    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
						    <label class="ml10" id="downLoad" style="display: none">
								<a href="" target="_blank">待考人员导出excel文件下载</a>
							</label>
			            </span>
		           </div>
					</form>
				</div>
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tr>
								<th class="buleleft">用户名</th>
								
								<th class="buleleft">姓名</th>
								<th class="buleleft">联系方式</th>
								<th class="buleleft">单位</th>
								<th class="buleleft">班级</th>
								<th class="buleleft">课程</th>
								<th class="buleleft">完成时间</th>
								<th class="buleleft">预约批次</th>
								<th class="buleleft">排考情况</th>
								<th class="buleleft">考试情况</th>
							</tr>
							<s:iterator value="examStudentPage.result" status="stat" id="dto">
								<tr>
									<td><s:property value='user.username' /></td>
									<td><s:property value='user.name' /></td>
									<td><s:property value='user.mobilephone' /></td>
									<td><s:property value='user.unit' /></td>
									<td><s:property value='clazz.name' /></td>
									<td><s:property value='course.name' /></td>
									<td><s:date name="finishedTime" format="yyyy.MM.dd HH:mm:ss" /></td>
									<td><s:property value='focusBatchName' /></td>
									<td><s:if test="focusResult == 2">${userFocusBatchUserDTO.userFocusExamtimeDTO.userFocusResource.resName}<br/><s:date name="userFocusBatchUserDTO.userFocusExamtimeDTO.startTime" format="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;-&nbsp;&nbsp;<s:date name="userFocusBatchUserDTO.userFocusExamtimeDTO.endTime" format="yyyy-MM-dd HH:mm"/></s:if><s:else>未排考</s:else></td>
									<td><s:if test="userFocusBatchUserDTO.status == 2">已开考</s:if><s:elseif test="userFocusBatchUserDTO.status == 3">已参考</s:elseif><s:elseif test="userFocusBatchUserDTO.status == 4">缺考</s:elseif><s:else>未开考</s:else></td>
								</tr>
							</s:iterator>
							<s:set name="page" value="examStudentPage" scope="request" />
						</table>
						<div class="dr-panel-footer">
							<%@ include file="/common/turnpage.jsp"%>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
	<!--正文结束-->
	<script type="text/javascript">
<!--
//选择一项操作动作
function lpoperaction(id){
   var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
		var hrefvalue = "3";
		if(hrefvalue=="")return;
		var target = "_blank";

		if(hrefvalue=="1" || hrefvalue=="2" || hrefvalue=="3"){
			$("#outItemId").val(id);
			$("#roleType").val(hrefvalue);			
			hrefvalue = hreflp;
		}
		openlpUrl(hrefvalue,target,id);
}

function openlpUrl(url,target,id){
	$("#lpwindowFrom").attr("action",url);
	$("#lpwindowFrom").attr("target",target);
	$("#lpwindowFrom").submit();
}
//-->
</script>

	<form id="lpwindowFrom" action="" method="get" target="_blank">
		<input name="outItemId" id="outItemId" type="hidden" /> <input
			name="roleType" id="roleType" type="hidden" /> <input
			name="tenantsCode" id="tenantsCode" type="hidden" value="ahstudy" />
		<input name="teacherName" id="teacherName" type="hidden"
			value="${user.name}" /> <input name="teacherUsername"
			id="teacherUsername" type="hidden" value="${user.username}" />
	</form>
	<!--footer start-->
	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
		<jsp:param value="index" name="menu" />
	</jsp:include>
	<!--footer over-->
</body>
</html>
