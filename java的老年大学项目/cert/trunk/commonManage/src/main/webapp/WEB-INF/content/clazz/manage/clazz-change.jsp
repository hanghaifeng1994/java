<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调换班级-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<%@ include file="/common/admin_meta.jsp"%>
<style type="text/css">
    .control-label{
         float: left;
         color:#6F6F6F;
         width:130px;
         padding-left: 27px;
    }
    .form-control{width:250px;float:left} 
    .checkbox > lable{
    float:left;
    } 
    </style>
<script>
$().ready(function(){
	$("#curclazz").change(function(){
		 $.get("${ctx}/clazz/manage/clazz!userteachplanclazz.action", {username:$("#username").val(),curclazzid:$("#curclazz").val()}, function (result){
			var obj = eval('( ' + result + ' )');
			$("#targetclazz option[value!='']").remove(); 
			for(var i=0;i<obj.length;i++)
			{
				$("#targetclazz").append("<option value='"+obj[i].id+"'>"+obj[i].name+"</option>"); 
			}
		});
	})
})
function loaduserclazz()
{
	 $.get("${ctx}/clazz/manage/clazz!loaduserclazz.action", {username:$("#username").val()}, function (result){
		var obj = eval('( ' + result + ' )')
	    
		if(obj.username==null || obj.username=='')
			$("#name").val("无此用户！");
		else
			$("#name").val(obj.username);
			
		var clazz=obj.clazzVOs;
		$("#curclazz option[value!='']").remove(); 
		for(var i=0;i<clazz.length;i++)
		{
			$("#curclazz").append("<option value='"+clazz[i].id+"'>"+clazz[i].name+"</option>"); 
		}
	});
}

function changeclazz()
{
	if(confirm('您确定要调换班级吗？'))
	{
		 $.get("${ctx}/clazz/manage/clazz!savechange.action", {username:$("#username").val(),curclazzid:$("#curclazz").val(),targetclazzid:$("#targetclazz").val()}, function (result){
			 if(result=='true')
				 alert('调换班级成功');
			 else
				 alert('调换班级失败');
			 loaduserclazz();
			 $("#targetclazz option[value!='']").remove(); 
		});
	}
}
</script>
<style>
.tdll {
	width: 15%
}
</style>

<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>

<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
 <s:if test="flag=='group'">
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
    <jsp:param value="validateclazz" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
    </jsp:include>
    </s:if><s:else>
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
    <jsp:param value="change" name="menu"/>
	<jsp:param value="clazz" name="bigmenu"/>
    </jsp:include>
    </s:else>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">班级管理</a>
</li>
<li class="active">换班级</li>
</ol>

<s:if test="flag=='group'">
<div class="dr-form-title clearfix" style="text-align: center;padding: 10px 0;">
<img src="${ctx}/css/admin_image/admincx01.jpg" width="760" height="35" /></div>
</s:if>
<form class="form-horizontal dr-form-bordered" id="mainForm"  method="post" enctype="multipart/form-data" name="mainForm">
	<div class="form-group">
		<label class="col-md-2 control-label">用户名<span class="text-danger">*</span></label>
		<div class="col-md-10"><input type="text" value="" id="username" name="username" onblur="loaduserclazz()"
			class="form-control" /></div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">姓名</label>
		<div class="col-md-10"><input type="text" value="" id="name" name="name" disabled="disabled"
			class="form-control" /></div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">当前班级</label>
		<div class="col-md-10">
		<select id="curclazz" class="form-control input-sm">
		 <option value="">--选择班级--</option>
		</select></div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">目标班级</label>
		<div class="col-md-10"><select id="targetclazz" class="form-control input-sm">
		 <option value="">--选择班级--</option>
		</select></div>
	</div>
	<div class="form-group">
	<label class="col-md-2 control-label"></label>
		<div class="col-md-10">
		<button class="btn btn-primary btn-sm" type="button" onclick="return changeclazz()">
        <span class="glyphicon glyphicon-cog"></span>&nbsp;调换班级
        </button>
        </div>
        </div>
        </form>
</div>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->
</body>
</html>
