<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	request.setAttribute("courseUrl", PropertyUtils
			.getPropertyWithConfigName("sysconfig.properties",
					"course.webapp.url"));
	request.setAttribute("userUrl", PropertyUtils
			.getPropertyWithConfigName("sysconfig.properties",
					"user.webapp.url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTDS XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="${staticurl}/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() { 

});

function loadparentpic(){
	var width=${width};
	if(width>0){
		parent.loadpic("${avatarname}",${width},${height});
	}
}
loadparentpic();
function onValidate()
{   
	var picFile = document.getElementById('picfile').value;
	var picfileObj = picFile.substr(picFile.lastIndexOf(".")).toLowerCase(); 
		if(picfileObj!=".jpg" && picfileObj!=".JPG"&& picfileObj!=".png"&& picfileObj!=".PNG"&& picfileObj!=".gif"&& picfileObj!=".GIF"){
			alert("上传图片格式不正确，请重新上传.");
			tmpfileName = "";
			document.getElementById('filespan').innerHTML='<center><input type="file" name="picfile" id="picfile" size="30" onchange="onValidate();"/></center>';
			return;
		}else
			document.getElementById("uploadform").submit();
}
</script>
</head>
<body>
<form action="course!upload.action" id="uploadform" enctype="multipart/form-data" method="post">
<input type="hidden" name="picfileFileName" id="picfileFileName" value=""/>

<input type="file" name="picfile" id="picfile" size="30" onchange="onValidate()"/>		  
</form>
</body>
</html>