<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<title>课程${manageType}管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/wx_js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/wx_js${currentTenant.contents}/css/drcl.css" rel="stylesheet"/>
<script type="text/javascript" language="javascript">   
	function iFrameHeight() {
		var ifm= document.getElementById("mainFrame");   
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;  
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight;
		}   
	}   
	<s:if test="manageTypeCode!=null">
	$(document).ready(function(){
		$("#${manageTypeCode}Form").submit();
	});
	</s:if>
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
<div class="dr-searchbar">
<div class="form-inline dr-form-inline">
<div class="form-group">
<label>课程管理</label><label style="margin-left: 10px;">${course.name} &gt; ${manageType}</label>
</div>
</div>
</div>

<!--<div class="kcglico">
<span class="lsp">课程管理</span>
<span class="rsp">${course.name} &gt; ${manageType}</span>
</div>
  -->
<div class="panel panel-default">
  <iframe src="${course.epurl}" width="100%" scrolling=auto frameborder="0" id="mainFrame" name="mainFrame" onLoad="iFrameHeight()" style="min-height: 700px;"></iframe>
  </div>
</div>
</section>
</div>
<!--正文结束-->
<!-- 中转换乘的form，用于将到相关具体管理界面用post方式提交参数，而不是get，突破get参数长度的限制，解决班级过多无法传递的问题 -->
<!-- 作业日程管理提交表单 -->
<form id="scheduleForm" target="mainFrame" method="post" action="<common:prop name="course.schedule.web.path" propfilename=""></common:prop><common:prop name="course.schedule.manage" propfilename=""></common:prop>">
<input name="code" value="${manageParam_code}" type="hidden"/>
<input name="site" value="${manageParam_site}" type="hidden"/>
<input name="currentgroup" value="${manageParam_currentgroup}" type="hidden"/>
<input name="groupjson" value="${manageParam_groupjson}" type="hidden"/>
</form>
<!-- 测验日程管理提交表单 -->
<form id="examScheduleForm" target="mainFrame" method="post" action="<common:prop name="course.examschedule.web.path" propfilename=""></common:prop><common:prop name="course.examschedule.manage" propfilename=""></common:prop>">
<input name="groupContent" value="${manageParam_groupContent}" type="hidden"/>
</form>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>