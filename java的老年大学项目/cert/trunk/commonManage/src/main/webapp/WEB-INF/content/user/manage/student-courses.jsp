<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户课程-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script language="javascript">
$().ready(function(){
	<s:if test='programsid==null'>
	if($("#programsid").val()!=null){
		$('#mainForm').submit();
	} 
	</s:if>
})
</script>
<style type="text/css">
table{
    width: 99%;
}
</style>
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
   <div class="dr-page-header">
     <h3>学员详细信息</h3>
   </div>
   <hr/>

 <div class="panel panel-default">
 
     <div class="panel-heading">
       <h3 class="panel-title">学员详细</h3>
       <div class="panel-toolbar">
          <ul class="nav nav-tabs pull-right">
	         <li ><a href="student!info.action?id=${id }" >用户信息</a></li>
	         <li><a href="student!trainreport.action?id=${id }">项目情况汇总</a></li>
	         <li class="active"><a href="student!courses.action?id=${id }">课程列表</a></li>
          </ul>
       </div>
     </div>
   <div class="panel-body" >
    <div class="panel-body row">
     <div class="col-md-13">  
     
     
 <div class="dr-searchbar">
    <form method="post" action="student!courses.action" id="mainForm" name="mainForm" class="form-inline dr-form-inline">
      <input type="hidden" name="page.pageNo"	id="pageNo" value="${page.pageNo}" />
      <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
      <input type="hidden" name="page.order" id="order" value="${page.order}" />
        <div class="form-group">
          <label>用培训项目</label>
          <s:select id="programsid" list="trainingProgramses"  value="programsid" listKey="id" listValue="name" theme="simple" cssClass="form-control input-sm" name="programsid"></s:select>
           <input type="hidden" name="id" value="${id }"/>
        </div>  
          <button class="btn btn-default btn-sm" type="submit">
          <span class="glyphicon glyphicon-search"></span>
          搜索
         </button>  
    </form>
 </div>

<div class="panel panel-default" >
<s:iterator value="planCourseVOs" status="stat">
  <div class="panel-heading">
        <div class="panel-toolbar text-left dr-slash-text small">
			<span>&nbsp;<font size="5">${userPhase.phase.name }</font></span>
			<span>完成 ${userPhase.finishedCourseStudyLength }学分 (${userPhase.finishedCourseCount }门课程)</span>
			<span>在学${userPhase.learningCourseStudyLength }学分 (${userPhase.learningCourseCount }门课程)</span>
			<span>不合格${userPhase.failedCourseStudyLength }学分 (${userPhase.failedCourseCount }门课程)</span>
			<span>过期${userPhase.expiredCourseStudyLength }学分 (${userPhase.expiredCourseCount }门课程)</span>
	   </div>
   </div>
	
	<table class="table table-bordered dr-table-default">
	   <thead>
		<tr>
			<th width="10%">课程名称</th>
			<th width="10%">&nbsp;课程代码</th>
			<th width="10%">&nbsp;课程学分</th>
			<th width="10%">&nbsp;学习时间(分钟)</th>
			<th width="8%">&nbsp;学习覆盖</th>
			<th width="8%">&nbsp;课程成绩</th>
			<th width="10%">&nbsp;课程状态</th>
			<th width="10%">&nbsp;操作</th>
		</tr>
		</thead>
		<s:iterator value="userCourseVOs" status="stat">
			<tr>
				<td>${course.name }</td>
				<td>&nbsp;${course.serialNo }</td>
				<td>&nbsp;${course.studylength }</td>
				<td>&nbsp;${learnedTime }</td>
				<td>&nbsp;${coverRate}%</td>
				<td>&nbsp;${courseScore}</td>
				<td>&nbsp;${status }</td>
				<td>
				<div class="btn-group">
					<a  class="btn btn-primary btn-sm" href="javascript:openchangeDialog('${id }');">
					<span class="glyphicon glyphicon-cog"></span>&nbsp;更换课程</a>
				</div>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:iterator>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<!--正文结束-->

<!--footer start-->
  	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
  	<jsp:param value="index" name="menu"/>
  	</jsp:include>
<!--footer over-->
<script type="text/javascript">
	function openchangeDialog(userclasscourseId){
		if(userclasscourseId==''||userclasscourseId==null||userclasscourseId=='undefined'){
			alert("请选择课程");
			return;
		}
		var html  =  "<input type=\"hidden\" id=\"changeCourseId\" value=\""+userclasscourseId+"\">"+
				   	 "<lable for=\"changeCourseD\">请输入课程编码</lable>"+
				   	 "<input id=\"coursechangeInput\" class=\"form-control input-sm\" value=\"\" type=\"text\" style=\"margin-top:10px;\"/>"+
				     "<input type=\"button\" class=\"btn btn-primary btn-sm\" value=\"查询课程\" onclick=\"searchCourse();\" style=\"margin-top:5px;float:left;\">"+
			 	  	 "<b id=\"coursename\" style=\"line-height: 40px;float:left;margin-left: 10px;\"></b>";
		b_confirmx(html,savechange);
	}
	function savechange(){
		var userclasscourseId = $("#changeCourseId").val();
		var coursecode = $("#coursechangeInput").val();
		if(coursecode==''||coursecode==null||coursecode=='undefined'){
			alert('请输入课程编码');
			return;
		}
		$.ajax({    
		    url:'${ctx}/user/manage/student!changecourses.action?id=${id }',  
		    data:{    
		    	userclasscourseId : userclasscourseId,    
		    	coursecode : coursecode 
		    },    
		    type:'post',    
		    dataType:'json',    
		    success:function(data) {
		        if(data.value =="true" ){   
			       	alert(data.label);
		        	window.location.replace(window.location.href+"?id=${id}")   
		        }else {
		        	alert(data.label); 
			    }  
		     },    
		     error:function() {    
		          alert("异常！");    
		     }    
		});
	}
	function searchCourse(){
		var coursecode = $("#coursechangeInput").val();
		if(coursecode==''||coursecode==null||coursecode=='undefined'){
			$("#coursename").html('请输入课程编码');
			return;
		}
		$.ajax({    
		    url:'${ctx}/user/manage/student!searchcourse.action',  
		    data:{    
		    	coursecode : coursecode
		    },    
		    type:'post',    
		    dataType:'json',    
		    success:function(data) {
			    $("#coursename").html(data.label);
		     },    
		     error:function() {    
		    	$("#coursename").html("查询异常");
		     }    
		});
	}
</script>
</body>
</html>