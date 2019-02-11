<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>班级学员查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script>
$(document).ready(function() {
	        if($("#success").text()!="")$("#div-success").show();
	        if($("#error").text()!="")$("#div-error").show();
})
</script>
</head>
<body>
<!--header start-->
<    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
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

<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="50%">课程名称</th>	
		<th>操作</th>
	</tr>
	<s:iterator value="classCourseDTOs" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;
			<s:if test="course.newlp">
			<a href="#" onclick="lpoperaction(${course.id})" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;课程实施</a>
			</s:if>
			<s:else>
			<a href="${ctx }/course/manage/course!schedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;作业日程管理</a>
			<a href="${ctx}/course/manage/course!examSchedule.action?id=${course.id}&headerClazzId=${headerClazzId}" target="_blank" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-cog"></span>&nbsp;测验日程管理</a>
			</s:else>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
</div>
<%@ include	file="/common/tagtitle.jsp"%>
<div class="panel panel-default">
<form class="form-inline dr-form-inline" method="post" action="headerclazz!savebgimage.action"
	enctype="multipart/form-data">
<input type="hidden" name="headerClazzId" value="${headerClazzId }"/>
<div class="panel-body row">
<div class="col-md-12">
<table class="table">
	<tr>
		<td width="2%" class="tdll">&nbsp;</td>
		<td width="94%">
		<div class="radio">
        <label>
		<input type="radio" name="defaultbg"  id="radio"	value="true" style="vertical-align: middle"  <s:if test="curHeaderClazz.clazz.pic==null">checked="checked"</s:if>/>
		 系统默认
        </label>
        </div>
	   </td>
	</tr>
	<tr>
		<td class="tdll">&nbsp;</td>
		<td valign="middle">
		<div class="radio">
         <label>
		 <input type="radio" name="defaultbg" id="radio2" value="false" <s:if test="curHeaderClazz.clazz.pic!=null">checked="checked"</s:if>/>
		    自定义			
         </label>
	     <span style="float: right;" class="color999 ml10">最佳尺寸960*116;最大不能超过2M；支持jpg,png,gif。</span>
	     <input style="float: right;margin: 0 10px;" name="uploadPic" id="uploadPic" value="" class="txtinput01" type="file" />
       </div>
	   </td>
	</tr>

	<tr>
		<td height="150" valign="middle" class="tdll">&nbsp;</td>
		<td>
		<s:if test="curHeaderClazz.clazz.pic==null">
		<img src="${ctx}/css/image/bj01.jpg" width="960" height="116"  class="mt20"/>
		</s:if>
		<s:else>
		<img src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${curHeaderClazz.clazz.pic}" width="960" height="116" class="mt20" />
		</s:else>
		</td>
	</tr>

	<tr>
		<td class="tdll">&nbsp;</td>
		<td>	<div class="btn-group">
        <button class="btn btn-primary btn-sm" type="submit" name="Submit32">
         <span class="glyphicon glyphicon-ok"></span>
         保存
        </button>
        </div>
        		<div class="btn-group">
        <button name="Submit2" class="btn btn-default btn-sm" type="submit">
         <span class="glyphicon glyphicon-remove"></span>
                         返回
        </button>
        </div> &nbsp;<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end--></td>
	</tr>
</table>
</div>
</div>
</form>
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
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="ahstudy"/>
<input name="teacherName" id="teacherName" type="hidden" value="${user.name}"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="${user.username}"/>           
</form>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->

</body>
</html>
