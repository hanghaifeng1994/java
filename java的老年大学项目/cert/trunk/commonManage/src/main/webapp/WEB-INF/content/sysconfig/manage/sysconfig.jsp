<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>平台设置<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.user.util.UserUtils@getCurUser()"></s:set>
<script src="${staticurl}/js/HighChart/highcharts.js"></script>
<script src="${staticurl}/js/HighChart/highcharts-3d.js"></script>
<script src="${staticurl}/js/HighChart/modules/exporting.js"></script>
<script src="${staticurl}/js/HighChart/modules/export-excel.js"></script> 
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
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="config" name="menu" />
	<jsp:param value="system" name="bigmenu" />
    </jsp:include>
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
<a href="#">平台设置</a> 
</li>
<li class="active">系统配置</li>
</ol>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<div class="bs-example" > 
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li id="config_0"><a style="cursor: pointer;" href="${ctx}/sysconfig/manage/sysconfig.action?type=0">后台设置</a></li>
        <li id="config_1"><a style="cursor: pointer;" href="${ctx}/sysconfig/manage/sysconfig.action?type=1">前台设置</a></li>
        <li id="config_2"> <a style="cursor: pointer;" href="${ctx}/sysconfig/manage/sysconfig.action?type=2">用户中心设置</a></li>
        <li id="config_3"><a style="cursor: pointer;" href="${ctx}/sysconfig/manage/sysconfig.action?type=3">学习平台设置</a></li>
    </ul>                
</div> 
 <div class="panel panel-default  mt10 mb10" >  
 <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" >
<div class="form-group" style="float: left"> 
	<div class="form-group">
		  	<label>配置文件:</label> 
		  	<s:select id="filePath" list="fileLists" onchange="init();" listKey="label" listValue="value" theme="simple"  cssClass="form-control" ></s:select>
	</div>
	<div class="form-group"> 
		  	<label style="color:red;">注意:文件编码为UTF-8</label>
	</div>
</div>       
<div style="clear: both;"></div> 
</form>
 </div>  
<div id="container" style="min-width: 310px; min-height: 550px; margin: 0 auto">

	<div class="panel panel-default">
    	<form id="inputForm" name="inputForm"  method="post" class="form-horizontal dr-form-bordered" role="form">
    	<input type="hidden" name="id" value="${id}" />
		
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">配置信息</h4>
		</div>
		</div>
		<div id="fileitems"></div>
		<div class="panel-footer">
		<div class="row" style="margin: 0 auto;text-align: center;">
		 	<a name="Submit32" onclick="saveItems();" class="btn btn-primary btn-sm" >
		 	<span  class="glyphicon glyphicon-ok"></span>&nbsp;保存 
		 	</a>
		</div>
		</div>  
	    </form>
	    </div>
</div>
</div>
<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section> 
<script type="text/javascript"><!-- 
$(function () {   
	var type = '<s:property value= "type" />';
	$("#config_"+type).addClass("active"); 
	init();
});   
function init(){
var filePath=$("#files").val();
var html = "";
$.get("${ctx }/sysconfig/manage/sysconfig!getItemByFilePath.excsec?filePath="+$("#filePath").val(),function(data) {
	$(data).each(function(index){ 
		if(data[index].label.indexOf("#")==0){
			html+=  ' <div class="form-group" id="validate_name">'+
					' 	<label class="col-md-10 control-label" style="text-align: left;color:red;" /">备注:'+data[index].label.substring(1,data[index].label.length)+ '' +
					' 		</label>'+
					' 		</div>';   
		}else if(data[index].label!=''){ 
			html+=  ' <div class="form-group" id="validate_name">'+
					' 	<label class="col-md-4 control-label">'+data[index].label+ '<span class="text-danger">*</span>' + 
					' 		</label>'+
					' 		<div class="col-md-8">'+
					' 		<input type="text" title="'+data[index].label+ '" value="'+data[index].value+'" id="name" name="name" class="form-control dr-dib" style="width:80%;float: left;" />'+
					' 		<span id="error_name" class="help-block"></span>'+
					' 		</div>'+
					' 		</div>';  
		}
		$("#fileitems").html(html);		
	});
});
}
function saveItems(){
	var json ='[';
	$("#fileitems input").each(function(index, domEle){
		json+='{"value":"'+$(domEle).val()+'","label":"'+$(domEle).attr("title")+'"},'
	});
	json+=']';
	$.post("${ctx }/sysconfig/manage/sysconfig!saveFileItems.excsec?filePath="+$("#filePath").val(), { "itemsjson": json },
			   function(data){
						if(data.success){
							alert("保存成功");
							init();
						}else{
							alert("保存失败");
						}
			   }, "json");
}
</script>
</body>
</html>