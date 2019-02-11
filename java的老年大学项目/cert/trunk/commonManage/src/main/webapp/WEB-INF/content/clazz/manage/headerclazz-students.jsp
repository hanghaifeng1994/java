<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>班级学员查询<%@ include file="/common/title.jsp" %></title>
<%@ include file="/common/admin_meta.jsp"%>
<style type="text/css">
.white_content {
	display: none;
	position: fixed;
	top: 27%;
	left: 35%;
	width: 400px;
	height: 210px;
	border-radius: 5px 5px 0 0;
	background-color: white;
	z-index: 1002;
	overflow: auto;
	text-align: center;
}
.up-header {
	border: 10px 0 #2285C7 outset;
	background-color: #2285C7;
	color: #E5F8FF;
	background-position: 0 -350px;
	font-size: 16px;
	height: 37px;
	line-height: 35px;
	padding: 0 20px;
	position: relative;
	text-align: left;
}
.up-box-bd {
	text-align: center;
	display: inline-block;
	background: none repeat scroll 0 0 #FFFFFF;
	border-radius: 0 0 5px 5px;
	line-height: 25px;
	padding: 10px 30px;
}
.lay-btn {
	margin-top: 20px;
	height: 30px;
	text-align: center;
}
.btn92,.btn92s {
	border-radius: 4px;
	color: #333333;
	display: inline-block;
	text-align: center;
}
.btn92 {
	width: 90px;
	border: 1px solid #CCCCCC;
	height: 28px;
	line-height: 28px;
}
.btn92s {
	width: 90px;
	background-color: #FF8000;
	color: #FFFFFF;
	height: 30px;
	line-height: 30px;
}
.btn92s:hover {
	background: #FF9B00;
	color: black;
}
a:link {
	text-decoration: none;
	color: balck;
}
a:active {
	text-decoration: blink;
}
a:visited {
	text-decoration: none;
	color: green;
}
</style>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<script>

	if("${export}"==true||"${export}"=="true"){
		   $('#exportbut').hide();
		   checkover();
	}


function idcardcheck(){
    var idcard = $.trim($("#idcard").val());
    var checkidcard=idCardNoUtil.checkIdCardNo(idcard);
    if(idcard!=""){
    	if(!checkidcard){  
          alert("身份证输入不合法");  
          return  false;  
       } 
    } 
}

function exportexcel(){
	 $('#export').val('true');
	 document.mainForm.submit();
}

function checkover(){
	$.ajax({
        type: "POST",
        url: "headerclazz!isFinishExport.action",
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

function change(studentClazzId,clazzname){
	$("#curClazz").html(clazzname);
	$("#studentClazzId").val(studentClazzId);
    $("#confirm").css("display","block");
	$("#fade").css("display","block");	

	$.getJSON("${ctx}/clazz/manage/clazz!changeclazz.action",{"studentClazzId":studentClazzId,"model":0},function(data){
		        $("#targetclazz option[value!='']").remove();
				var clazzname = eval(data);
				if(clazzname.length>0){
				for(var i = 0 ;i < clazzname.length ; i++) {
					$("#targetspan").show();
					$("#targetspan0").hide();
					$("#ok").show();
					$("#targetclazz").append("<option value='"+clazzname[i].value+"'>"+clazzname[i].label+"</option>");
				}
				}else{
					$("#ok").hide();
					$("#targetspan").hide();
					$("#targetspan0").show();
					}
	});
}

function changeclazz()
{
	var targetclazzid = $("#targetclazz").val();
	var studentClazzId = $("#studentClazzId").val();
		$.ajax({
			type:"POST",
			dataType: "text",
			url: "${ctx}/related/clazz!savechange.action",
			data: {targetclazzid:targetclazzid,studentClazzId:studentClazzId},
		    success: function(result){
			      if(result=='true'){
			            paysuccess();
			        }else{
			            alert('调换班级失败');
			        }
		      }
		});		
}

function cancel(){
	$("#confirm").css("display","none");
	$("#fade").css("display","none");
	
}
function paysuccess(){
	$("#confirm").css("display","none");
	$("#fade").css("display","none");
	window.location.reload();
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
			<s:if test="#request.iswxeduopen=='false'">
			<%@ include	file="/common/tagtitle.jsp"%>
			<div class="tab-content dr-tabs-panel">
				<div class="dr-searchbar">
					<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="headerclazz!students.action" method="post">
						<input type="hidden" name="studentClazzPage.pageNo" id="pageNo" value="${studentClazzPage.pageNo}" /> 
						<input type="hidden" name="studentClazzPage.orderBy" id="orderBy" value="${studentClazzPage.orderBy}" /> 
						<input type="hidden" name="studentClazzPage.order" id="order" value="${studentClazzPage.order}" /> 
						<input type="hidden" name="headerClazzId" id="order" value="${headerClazzId}" />
						<input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
						<input type="hidden" name="tabnum" id="tabnum" value="2" />
						<input type="hidden" name="export" value="false" id="export" />
					
						<div class="form-group">
							<label>用户名</label> 
							<input name="userName" type="text" class="form-control input-sm" value="${userName}" />
						</div>
						<div class="form-group">
							<label>姓名</label> 
							<input name="name" type="text" class="form-control input-sm" value="${name}" />
						</div>
						<div class="form-group">
							<label>完成学时</label> <input class="form-control input-sm" type="text" style="width: 57px" name="finishstudylengthstart" id="finishstudylengthstart" value="${finishstudylengthstart }" maxlength="6" />
							-<input class="form-control input-sm" type="text" style="width: 57px" name="finishstudylengthend" id="finishstudylengthend" value="${finishstudylengthend }" maxlength="6" />
						</div>
						<div class="form-group">
							<label>未完成学时</label> 
							<input class="form-control input-sm" type="text" style="width: 57px" name="learningstudylengthstart" id="learningstudylengthstart" value="${learningstudylengthstart }" maxlength="6" />
							-<input class="form-control input-sm" type="text" style="width: 57px" name="learningstudylengthend" id="learningstudylengthend" value="${learningstudylengthend }" maxlength="6" />
						</div>
						<div class="form-group">
							<button name="Submit" class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');document.mainForm.submit()">
								<span class="glyphicon glyphicon-search"></span>搜索
							</button>
						</div>
					<s:if test="#request.iswxeduopen=='false'">
							<div class="form-group">
								<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" onclick="$('#export').val('true');document.mainForm.submit();">
									<span class="glyphicon glyphicon-export"></span>&nbsp;导出表格
								</button>
								<span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"> <a href="" target="_blank">班级学员导出excel文件下载</a> </label> </span>
							</div>
					</s:if>
					</form>
				</div>
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tr>
								<td class="buleleft">姓名</td>
								<td class="buleleft">性别</td>
								<td class="buleleft">身份证号</br>单位</th></td>
								<td class="buleleft">选课学时</td>
								<td class="buleleft">完成学时</td>
								<td class="buleleft">未完成学时</td>
								<td class="buleleft">完成课时(分钟)</td>
								<td class="buleleft">作业是否完成</td>
								<td class="buleleft">考试成绩(分)</td>
								<td class="buleleft">操作</td>
							</tr>
							<s:iterator value="studentClazzPage.result" status="stat">
								<tr>
									<td>${student.name}</td>
									<td>${student.sexDesc}</td>
									<td>${student.idcard }</br>${student.unit}</td>
									<td>${learningCourseNum+finishedCourseNum+failedCourseNum}门
										${learningCourseTime+finishedCourseTime+failedCourseTime}学时</td>
									<td>${finishedCourseNum}门 ${finishedCourseTime}学时</td>
									<td>${learningCourseNum}门 ${learningCourseTime}学时</td>
									
									<td>
										<c:forEach items="${learnedTimeList}" var="temp1">
										      
										      ${temp1.name }:${temp1.value }<br/>
										 </c:forEach>
									 </td>
									<td>
										<c:forEach items="${homeworkList}" var="temp">
										    
										      ${temp.name }:${temp.value }<br/>
										      
										 </c:forEach>
									 </td>
									 
									 <td>
										<c:forEach items="${courseScoreList}" var="temp2">
										     
										      ${temp2.name }:${temp2.value }<br/>
										 </c:forEach>
									 </td>
									<td>
										<s:if test="clazzDTO.open && normal">
							            	<a href="javascript:void(0);" style="color: white;" class="btn btn-primary btn-sm" onclick="change('${id}','${clazzDTO.name}')">换班</a>
							            </s:if>
										<a href="${ctx}/user/manage/student!info.action?id=${studentId}" target="_blank" class="btn btn-primary btn-sm">
										<span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a>
									</td>
								</tr>
							</s:iterator>
							<s:set name="page" value="studentClazzPage" scope="request" />
						</table>
						<div class="dr-panel-footer">
							<%@ include file="/common/turnpage.jsp"%>
						</div>
					</div>
				</div>
			</div>
			</s:if>
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
	
<div id="confirm" class="white_content">
<input  id="studentClazzId" type="hidden" value="${studentClazzId}"/>
<div class="up-header">调换班级</div>
<div class="up-box-bd">
<div style="text-align: left;margin-top: 10px"><span style="text-align: left;font-weight: bold">当前班级:</span>
<span id="curClazz" style="margin-left: 10px"></span></div>
<div style="text-align: left;"><span style="text-align: left;font-weight: bold;">目标班级:</span>
<span id="targetspan0" style="display: none;margin-left: 10px">该教学计划下仅有该一门课程开放！</span>
<span id="targetspan" style="display: none">
<select id="targetclazz" style="margin-left: 10px">
<option value="">--选择班级--</option>
</select>
</span></div>
<div class="lay-btn">
<a id="ok" class="btn92s" href="#" onclick="changeclazz()">确定</a>
<a id="cancel" class="btn92" href="javascript:" onclick="cancel()">取消</a>
</div>
</div>
</div>

</body>
</html>
