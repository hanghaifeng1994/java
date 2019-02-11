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
<%@ include file="/common/admin_meta.jsp" %>
	<link rel="stylesheet" href="${ctx}/jcrop_zh/css/jquery.Jcrop.css" type="text/css" />
    <script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/jcrop_zh/js/jquery.Jcrop.js"></script>
	<link href="${staticurl}/css/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${staticurl}/js/layer.js" type="text/javascript"></script>
    <script src="${ctx}/js/cutpic.js" type="text/javascript"></script>  

<script type="text/javascript">
$(document).ready(function() { 
	
	//设置剪裁参数 
	setJcrop(0,0,140,185,"<common:prop name='traincore.uploadpath.url' propfilename=''></common:prop>","${picfileFileName}","${ctx}/course/manage/course!ajaxCutStuPic.excsec","${ctx}/upload!uploadCourseImage.excsec");		
});
function loadpic(avatarname,width,height){
	var fileName = avatarname; 
	$("#avatarname").val(avatarname);
	var fullImgPath = picfile_path +fileName;
	//保存图片名称用于裁剪图片 
	tmpfileName = fileName;
	//保存原始图片，用于还原
	opicfileName = fileName;
	$("#avatarname").val(fileName);
	//设置高和宽
	oht = height;
	owt = width;
	//给操作区赋新图片
	document.getElementById('define_ava_div').innerHTML='<center style="margin-top: 10px;"><img width="'+owt+'" height="'+oht+'" id="xuwanting" src="'+fullImgPath+'" /></center>';
	document.getElementById('define_ava_div').style.height="600px";
	//重新初始化剪裁 
	initJcrop(selectX,selectY,selectW,selectH);
	//$("#filespan").hide();
	//$("#my_uploadframe").hide();
	isInit=false;//上传后就不是初始化状态了，可以进行操作了
}
function saveEditorPic(){
	var avatarname = $("#avatarname").val();
	parent.saveEditorPic(avatarname);
}
function closePic(){
	parent.close();
}
</script>
</head>
<body>
<section id="main" role="main"> 
   <div class="dr-container-fluid">
   <div class="dr-page-header">
     <h3>裁剪图片</h3>
   </div>
   <hr/>

 <form action="" class="form-inline dr-form-inline" id="form1" enctype="multipart/form-data" method="post">
 <input type="hidden" value="" name="avatarname" id="avatarname"/>
 <div  class="dr-searchbar">
			<div class="form-group text-center" id="my_uploadframe">
			<iframe name="uploadimage" id="uploadimage" src="course!uploadpic.excsec" frameborder="0"  style="overflow-x:none" width="150px" height="30px" scrolling="no"></iframe>			
			
			<!--<input type="hidden" name="picfileFileName" id="picfileFileName" value=""/>
			<input type="file" name="picfile" id="picfile" size="30" onchange="onValidate()"/>		  
			--></div>
		  <div class="form-group text-center">
          <a href="javascript:void(0);" class="btn btn-primary btn-sm" onclick="saveEditorPic()">
          <span class="glyphicon glyphicon-ok"></span>保存图片</a>
          <a href="javascript:void(0);" class="btn btn-default  btn-sm mr30" onclick="closePic()">
          <span class="glyphicon glyphicon-remove"></span>取消</a>
          <a href="javascript:void(0)" class="btn btn-primary btn-sm" id="twoa" style="outline:none;blr:expression(this.onFocus=this.blur())" onclick="onCut()">图片裁剪</a>
          <a href="javascript:void(0)" class="btn btn-primary btn-sm" onclick="reset()" style="outline:none;blr:expression(this.onFocus=this.blur())" id="threea">还原图片</a>
    	  <a href="javascript:void(0);" class="btn btn-primary btn-sm"  onclick="onLagr(1.1);"  style="outline:none;blr:expression(this.onFocus=this.blur())"  id="foura">放大图片</a>
		  <a href="javascript:void(0);" class="btn btn-primary btn-sm" onclick="onSmall(0.9);" style="outline:none;blr:expression(this.onFocus=this.blur())"  id="fivea">缩小图片</a>
          </div>
 </div>
</form>

          <!-- 图片操作区 -->
          <span class="col-md-12 text-center" id="define_ava_div" style="overflow: auto;max-height: 500px">
          		<img src="" alt="" id="xuwanting"/>
          </span>
</div>
</section>
</body>
</html>