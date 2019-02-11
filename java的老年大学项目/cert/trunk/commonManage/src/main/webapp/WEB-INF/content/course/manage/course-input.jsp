<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url"));
request.setAttribute("manageUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","manage.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<html>
<head>
<title>新增课程<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
    <%@ include file="/common/admin_meta.jsp"%>
    <script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
	<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>

 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	<link rel="stylesheet" href="${ctx}/jcrop_zh/css/jquery.Jcrop.css" type="text/css" />
    <script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/jcrop_zh/js/jquery.Jcrop.js"></script>
	<link href="${staticurl}/css/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${staticurl}/js/layer.js" type="text/javascript"></script>
    <script src="${ctx}/js/cutpic.js" type="text/javascript"></script>        
    
<script>
		$(document).ready(function() {
	        if($("#success").text()!="")$("#div-success").show();
	        if($("#error").text()!="")$("#div-error").show();
	        $("#free_starttime").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0,
				
					 }); 
			 $("#pubDate").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0
				 
					 }); 
			 $("#free_endtime").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0
			
					 }); 
			 				            
			//$("#validDate").datepick({dateFormat: 'yy-mm-dd'});
			//$("#pubDate").datepick({dateFormat: 'yy-mm-dd'});
			//$("#free_starttime").datepick({dateFormat: 'yy-mm-dd'});
			//$("#free_endtime").datepick({dateFormat: 'yy-mm-dd'});
			//聚焦第一个输入框
			$("#name").focus();

			// tree初始化
            var o = {
                    showcheck: true,          
                    //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                    theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
    				isfolder:false,
    				iscascade: false, //是否选中节点后向下遍历
                    isbubble: true //是否选中节点后向上上溯
                    //onnodeclick:function(item){alert(item.text);}
            };
            o.data = ${catTreeData};
            $("#navigation").treeview(o);
            
			//为inputForm注册validate函数
			//jQuery.validator.addMethod("isStudylen", function(value, element) {
				//	if(element.checked)
					//		if($("#finishedLearnedLen").val()<=0)return false;    
				//	return true;
		  		//}, "课程完成时长必须大于0");

			//	jQuery.validator.addMethod("isCoverrate", function(value, element) {
				//	if(element.checked)
					//		if($("#finishedCoverageRate").val()<=0)return false;    
				//	return true;
		  		//}, "课程完成覆盖率必须大于0");

			//jQuery.validator.addMethod("isScore", function(value, element) {
				//if(element.checked)
					//	if($("#neededFinishedScore").val()<=0)return false;    
				//return true;
			//}, "课程完成要求的合格分必须大于0");

			//jQuery.validator.addMethod("isFinishedneed", function(value, element) {
				//if(!$('form #studyneed').is(':checked') && !$('form #rateneed').is(':checked') && !$('form #scoreneed').is(':checked'))
		  			//return false;
		  		//return true;
			//}, "必须设置一种课程完成条件");
			
			jQuery.validator.addMethod("compareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
			if(startDate!=''){
            var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
            var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
            if(value=='' && startDate=='')return true;
            else
            return date1 < date2;
			}else return true;
 	  }, "结束时间必须大于开始时间");
		 	  
			$("#inputForm").validate({
				rules: {
				    name: {
						required: true,
						remote: "course!checkName.excsec?oldName="+encodeURIComponent('${name}')
					},
					serialNo: {
						remote: "course!checkCourseSerialNo.excsec?oldSerialNo="+encodeURIComponent('${serialNo}')
					},
					validDate: {
						required: true
					},	
					courseModel: {
						required: true
					},
					coursePermission:{
						required: true
					},
					free_endtime:{
						compareDate:"#free_starttime2"
					},
					subject:{
						required: true
					},			
					courseType: {
						required: true
					},			
					price: {
						required: true,
						number:true
					},
					studylength: {
						required: true,
						number:true
					},				
					examNum: {
						required: true,
						number:true
					},
					homeworkNum: {
						required: true,
						number:true
					},
					studyTime: {
						number:true
					}
				},
				messages: {
					name: {
						required:"请输入课程名称",
						remote: "课程名称已存在"
					},
					serialNo: {
						remote: "课程代码已存在"
					},
					validDate: {
						required:"请输入课程有效期"
					},	
					courseModel: {
						required:"请选择课程属性"
					},
					coursePermission:{
						required:"请设置课程权限"
					},
					subject:{
						required: "请输入课程介绍"
					},		
					courseType: {
						required:"请选择课程类型"
					},	
					price:{
						required:"请输入课程价格",
						number:"课程价格只能是数字"
					},
					studylength:{
						required:"请输入课程可得学分",
						number:"课程可得学分只能是数字"
					},	
					examNum:{
						required:"请输入考试次数",
						number:"考试次数只能是数字"
					},	
					homeworkNum:{
						required:"请输入作业数量",
						number:"作业数量只能是数字"
					},
					studyTime:{
						number:"课程学习时长只能是数字"
					}				
				},
				onsubmit: function(element) { $(element).valid(); },
				onfocusout: function(element) { $(element).valid(); },			
				onkeyup: function(element) { $(element).valid(); },
			    onfocusin: function(element) { $(element).valid(); },
		        success: function(label) {
			        var divId = $(label).parent().attr("id");
			    	var startindex = divId.indexOf("_"); 
			    	var e = divId.substring(startindex+1);
					//var e = $(label).parent().attr("id").split("_")[1];
					var oclass=$("#validate_"+e).attr("class");
					if(oclass && oclass.indexOf("form-group")>-1)
						oclass = "form-group";
					else
						oclass="";
		        	$("#validate_"+e).attr("class",oclass+" has-success")     
		    		$(label).remove();
		        },
		        errorPlacement: function(error, element) { 
			        if (document.getElementById("error_"+element.attr("name")))  {
			            error.appendTo("#error_"+element.attr("name")); 
						var oclass=$("#validate_"+element.attr("name")).attr("class");
						if(oclass && oclass.indexOf("form-group")>-1)
							oclass = "form-group";
						else
							oclass="";
			        	$("#validate_"+element.attr("name")).attr("class",oclass+" has-error");    
			        }	
			        else{
		            	error.insertAfter(element);   
			        }       
		        },
			    invalidHandler: function(form, validator) {  //不通过时回调
					$(".error").each(function(i){
						var id = $(this).parent().attr("id");
						if(id && id.indexOf("_")>0){
						    var f = id.split("_")[1];
							var oclass=$("#validate_"+f).attr("class");
							if(oclass && oclass.indexOf("form-group")>-1)
								oclass = "form-group";
							else
								oclass="";
						    $("#validate_"+f).attr("class",oclass+" has-success")
						    $(this).remove();
						}
						//alert($(this).html())
					});
			    } ,
				submitHandler: function(form) {
	                var s=$("#navigation").getTSVs();
	                if(s !=null){
						$("#checkCats").val(s.join(","));
		            }
					form.submit();
				}			
			});
			window.domain="localhost"; 
		});
		
		function iFrameHeight() {
			var ifm= document.getElementById("main");
			
			var subWeb = document.frames ? document.frames["main"].document : ifm.contentDocument;  
			if(ifm != null && subWeb != null) {
			   ifm.height = subWeb.body.scrollHeight;
			}   
		}
        function sel(){
	        var zt = document.getElementsByName("courseModel");
	        for(var i=0;i<zt.length;i++){
	        	if(zt[i].checked&&zt[i].value==3) 
		        	{
		        	$("#price").val("0.0");
		        	$('#price').attr('disabled',"true");
		        	}
	        	else{
	        		$('#price').removeAttr('disabled');
		        	}
	        	}
        	}
function uploadpic(){
	$("#iframePic").show();
	$("#col-md").attr("class","col-md-10");
}

function saveEditorPic(avatarname){
	var picPath = "<common:prop name="traincore.uploadpath.url" propfilename=""/>"+avatarname
	$("#pic").val(avatarname);
	$("#cruPic").attr("src",picPath);
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
}
function close(){
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
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
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="input-course" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">课程资源库管理</a>
</li>
<li class="active"><s:if test="id==null">新增</s:if><s:else>编辑</s:else>课程</li>
</ol>

<div class="dr-page-header">
<h3>
<s:if test="id==null">新增</s:if><s:else>编辑</s:else>课程
</h3>
</div>
<hr/>	
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
<div class="panel panel-default">
<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="course!save.action" method="post" enctype="multipart/form-data">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>
<input id="id" name="finishedneed" type="hidden" value="" size="30"/>
<input id="id" name="tabFlag" type="hidden" value="${tabFlag}" size="30"/>

<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">课程基本信息</h4>
</div>
</div>
<div class="form-group" id="validate_name">
     <label class="col-md-2 control-label">课程名称<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="name" value="${name}" type="text" class="form-control"/>
     </div>
     <span class="help-block" id="error_name"></span>
</div>

<div class="form-group" id="validate_serialNo">
     <label class="col-md-2 control-label">课程代码</label>
     <div class="col-md-3">
     <input name="serialNo" value="${serialNo}" type="text" class="form-control"/>
     <span class="help-block">（不填则系统生成）</span>
     </div>
     <span class="help-block" id="error_serialNo"></span>
</div>

<div class="form-group" id="validate_studylength">
     <label class="col-md-2 control-label">可得学分<span class="text-danger">*</span></label>
     <div class="col-md-3"><input name="studylength" value="${studylength}" type="text" class="form-control" />
     </div>
     <span class="help-block" id="error_studylength"></span>
</div>

<div class="form-group" id="validate_price">
    <label class="col-md-2 control-label">价格<span class="text-danger">*</span></label>
    <div class="col-md-3"><input name="price" value="${price}" type="text" class="form-control" id="price"/>
    </div>
    <span class="help-block" id="error_price"></span>
</div> 
<s:if test="#request.iswxeduopen=='true'"> 
<div class="form-group" id="validate_courseModel">
    <label class="col-md-2 control-label">课程性质<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
    <s:radio cssClass="ml5 mr5" onchange="sel()" cssStyle="font-weight: normal;" list="#{1:'必修课',2:'选修课',3:'开放课(免费,价格为0.0)'}" value="courseModel"  name="courseModel" theme="simple"></s:radio>
    <span class="text-danger" id="error_courseModel"></span>
</div>
</div>
</s:if>
<s:else>
<div class="form-group" id="validate_courseModel">
    <label class="col-md-2 control-label">课程性质<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
    <s:radio cssClass="ml5 mr5" onchange="sel()" cssStyle="font-weight: normal;" list="#{1:'公需课',2:'专业课',3:'开放课(免费,价格为0.0)'}" value="courseModel"  name="courseModel" theme="simple"></s:radio>
    <span class="text-danger" id="error_courseModel"></span>
</div>
</div>
</s:else>

<div class="form-group">
    <label class="col-md-2 control-label">限免开始</label>
    <div class="input-group date col-md-3" id="free_starttime" style="padding-left: 15px;;float: left;margin-right: 5px;">
     <input class="form-control" id="free_starttime2" type="text" value="<s:date name="free_starttime" format="yyyy-MM-dd"/>"  readonly="readonly" name="free_starttime"/>
       <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>	
	<span class="help-block" id="error_free_starttime"></span>
</div>
 
<div class="form-group" id="validate_free_endtime">
    <label class="col-md-2 control-label">限免截止</label>
    <div class="input-group date col-md-3" id="free_endtime" style="padding-left: 15px;;float: left;margin-right: 5px;">
       <input class="form-control" type="text" value="<s:date name="free_endtime" format="yyyy-MM-dd"/>" 
			readonly="readonly" name="free_endtime"/>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>
	<span class="help-block" id="error_free_endtime"></span>
</div>   
  <!-- 
  <div>
    <div class="divll">考试次数<span class="text-danger">*</span></div>
    <div><input name="examNum" value="${examNum}" type="text" class="form-condivol" /><span class="text-danger" id="error_examNum"></span></div>
  </div>
  <div>
    <div class="divll">作业次数<span class="text-danger">*</span></div>
    <div><input name="homeworkNum" value="${homeworkNum}" type="text" class="form-condivol" /><span class="text-danger" id="error_homeworkNum"></span></div>
  </div>   
  <div>
    <div class="divll">课程有效期<span class="text-danger">*</span></div>
    <div>
    <input style="width:250px" type="text" value="<s:date name="validDate" format="yyyy-MM-dd"/>" id="validDate" readonly="readonly" name="validDate" class="dateinput" />
	<span class="text-danger" id="error_validDate"></span>
	</div>
  </div>
  -->
   
<div class="form-group">
    <label class="col-md-2 control-label">发布时间</label>
    <div class="input-group date col-md-3"  id="pubDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
    <input type="text"  value="<s:if test="id==null">${nowtime}</s:if><s:else><s:date name="pubDate" format="yyyy-MM-dd" /></s:else>"
			readonly="readonly" name="pubDate" class="form-control" />
	    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>
	
	<span class="text-danger" id="error_pubDate"></span>
</div>
<div class="form-group" id="validate_checkCats">
    <label class="col-md-2 control-label">所属分类</label>
    <div class="col-md-3">
		<div id="tree" style="width:250px;height:250px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
			<ul id="navigation">
			</ul>
			<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
		</div>
		<span class="help-block" id="error_checkCats"></span>
    </div>
  </div>  
   
  <!-- 
  <div>
    <div class="divll">课程类型</div>
    <div><div style="float: left;"><s:radio list="#{0:'普通',1:'scorm'}" value="courseType"  name="courseType" theme="simple"></s:radio></div><div style="padding-left: 10px;"><span class="text-danger" id="error_courseType"></span></div></div>
  </div>  
  -->
  
<div class="form-group">
    <label class="col-md-2 control-label">课程封面</label>
    <div class="col-md-2" id="col-md">
      <input id="pic" name="pic" type="hidden" value="${pic}"/>
     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
		 <span class="glyphicon glyphicon-open mr5"></span>上传图片
		 </button>&nbsp;&nbsp;(90x120)
		 <div  style="display: none;" id="iframePic" >
		 <iframe src="${ctx}/course/manage/course!uploadphoto.excsec?picfileFileName=${pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
		 </div>
        <div class="img-thumbnail mt10">
         <img id="cruPic" alt="90x120" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${pic}" style="width:90px; height:120px;"/>
       </div>
    </div>
</div>
  
<div class="form-group" id="validate_subject">
    <label class="col-md-2 control-label">课程介绍<span class="text-danger">*</span></label>
    <div class="col-md-8">
        <textarea name="subject" cols="60" rows="3" class="form-control">${subject}</textarea>
         <script type="text/javascript">
        
			createCkEditor("${ctx}/fckeditor/","subject",700,320,"Basic",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
		</script>
    </div>
    <br/>
	<span class="help-block" id="error_subject"></span>
</div>

<div class="form-group" id="validate_courseModel">
    <label class="col-md-2 control-label">教学方式：<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
   <s:radio onclick="$(this).val()=='true'?$('#coursetype').hide():$('#coursetype').show()" list="#{true:'线下',false:'线上'}" value="offline"  name="offline" theme="simple" cssStyle="font-weight: normal;"></s:radio>
    <span class="text-danger" id="error_courseModel"></span>
</div>
</div>
<s:if test="#request.iswxeduopen=='true'"> 
<div class="form-group" id="validate_studyTime">
     <label class="col-md-2 control-label">课程学习时长(分钟)</label>
     <div class="col-md-3"><input name="studyTime" value="${studyTime}" type="text" class="form-control" />
     </div>
     <span class="help-block" id="error_studyTime"></span>
</div>
</s:if>
<div class="form-group" id="validate_homeworkDesc">
     <label class="col-md-2 control-label">作业要求</label>
     <div class="col-md-8"><input name="homeworkDesc" value="${homeworkDesc}" type="text" class="form-control" />
     </div>
     <span class="help-block" id="error_homeworkDesc"></span>
</div>

<div id="coursetype" style="display: <s:if test="id!=null&&offline">none</s:if>">
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">课程主讲教师</h4>
</div>
</div>
<!--
  <div>
    <div class="divll unline" colspan="2" valign="bottom"><span style="font-weight: bold;">课程主讲教师</span></div>
  </div>  
  -->
<div class="form-group">
    <label class="col-md-2 control-label">姓名</label>
    <div class="col-md-3"><input name="mainTeacherName" type="text" class="form-control" value="${mainTeacher.name}"/>
    </div>
  </div>

<div class="form-group">
    <label class="col-md-2 control-label">职称</label>
    <div class="col-md-3">
      <input name="mainTeacherProfessional" type="text" class="form-control" value="${mainTeacher.professional}"/>
    </div>
  </div>

<div class="form-group">
    <label class="col-md-2 control-label">单位</label>
    <div class="col-md-4">
      <input name="mainTeacherOrganization" type="text" class="form-control" value="${mainTeacher.organization}"/>      
      <span class="woring_x" id="error_organization"></span>
      </div>
</div>  

<div class="form-group">
    <label class="col-md-2 control-label">简介</label>
    <div class="col-md-8">
      <textarea rows="5" cols="40" name="mainTeacherDescription" class="form-control" style="resize: none;">${mainTeacher.description}</textarea>
      <span class="woring_x" id="error_mainTeacherName"></span></div>
  </div>  

<div class="form-group">
    <label class="col-md-2 control-label">个人照片</label>
    <div class="col-md-10">
      <input name="uploadPic" type="file"/>
      <span class="woring_x" id="error_uploadPic"></span>
      <div class="img-thumbnail mt10">
      <img alt="140x140" data-src="holder.js/140x140" style="width:140px; height:140px;" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${mainTeacher.pic}" width="10" height="16"/>
      </div>
    </div>
  </div>
  
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">学习成果认定设置</h4>
</div>
</div>

<div class="form-group" id="validate_finishedneed">
    <label class="col-md-2 control-label">完成条件</label>
        <div class="col-md-5">
        <div class="row mb10">
        <div class="checkbox col-md-6">
          <label>
          <s:checkbox name="studyneed" theme="simple"></s:checkbox>
                            学习时长大于等于
          </label>
        </div>     
           <div class="input-group col-md-5">
           <input class="form-control" name="finishedLearnedLen"  id="finishedLearnedLenx" type="text" value="${finishedLearnedLen}" >
           <span class="input-group-addon">分钟以上</span>
           </div>         
           </div>
        
        <div class="row mb10">  
        <div class="checkbox col-md-6">
          <label>
          <s:checkbox name="rateneed" theme="simple"></s:checkbox>
                            知识点学习覆盖率
          </label>
        </div>
           <div class="input-group col-md-5">           
           <input class="form-control"  name="finishedCoverageRate" id="finishedCoverageRatex" type="text" size="20" value="${finishedCoverageRate}"/>
           <span class="input-group-addon">%</span>      
           </div>
            <p class="help-block col-md-offset-6">（该课程对SCORM课件无效）</p>
           </div>
           
        <div class="row mb10">   
        <div class="checkbox col-md-6">
          <label>
          <s:checkbox name="scoreneed" theme="simple"></s:checkbox>
                           课程成绩大于等于
          </label>
        </div>
           <div class="input-group col-md-5">
           <input class="form-control" name="neededFinishedScore" id="neededFinishedScorex" type="text" class="form-control" value="${neededFinishedScore}"/>
           <span class="input-group-addon">分以上</span>
           </div>
            <div class="help-block col-md-offset-6">（满分为100分制度）</div>
           </div>
  <div>
          <span class="help-block" id="error_finishedneed"></span>
          <span class="help-block" id="error_studyneed"></span>
          <span class="help-block" id="error_rateneed"></span>
          <span class="help-block" id="error_scoreneed"></span>
  </div>
           </div>
 </div>
 
<div class="form-group">
    <label class="col-md-2 control-label">学分前置</label>
    <div class="col-md-5">
    <label class="radio-inline">
    <input id="inlineCheckbox1" type="radio" value="true"  name="timebefore" <s:if test="timebefore==true">checked="checked"</s:if>>是</label>
    <label class="radio-inline">
    <input id="inlineCheckbox1" type="radio" value="false"  name="timebefore" <s:if test='timebefore==false'>checked="checked"</s:if>>否</label>
    <div style="padding-left: 10px;"><span class="help-block" id="error_timebefore"></span></div>
    <div class="help-block">（即是否达到学分要求才能进行后续作业和考试活动）</div></div>
</div>  

<%-- <s:if test="#request.iswxeduopen=='true'">
<div class="form-group">
    <label class="col-md-2 control-label">前测课程</label>
    <div class="col-md-5">
    <label class="radio-inline">
    <input id="qianceCheckbox" type="radio" value="true"  name="beforeTest" <s:if test="beforeTest==true">checked="checked"</s:if>>是</label>
    <label class="radio-inline">
    <input id="qianceCheckbox" type="radio" value="false"  name="beforeTest" <s:if test="beforeTest==false">checked="checked"</s:if>>否</label>
    <div style="padding-left: 10px;"><span class="help-block" id="error_timebefore"></span></div>
    </div>
</div>  
</s:if>  --%>

  <div style="display:none;">
    <div class="divll">新学习平台</div>
    <div><div style="float: left;">
    <s:if test="id==null">
    <s:radio list="#{true:'是',false:'否'}" value="newlp"  name="newlp" theme="simple" cssStyle="readonly"></s:radio>
    </s:if>
    <s:else>
    <s:if test="newlp">
    	是
    </s:if>
    <s:else>否</s:else>
    </s:else>
    </div><div style="padding-left: 10px;"></div><div class="light_black">（一旦设置后即不能修改）</div></div>
  </div> 
 
 	<div class="form-group">
		<label class="col-md-2 control-label">是否在移动段显示</label>
		<div class="col-md-3">
		<s:select list="#{'1':'否','0':'是'}" listKey="key" listValue="value" name="mobileshow" theme="simple" headerKey="" 
		value="mobileshow" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="mobileshow"></s:select>	
	    </div>	
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">作业用测验代替</label>
		<div class="col-md-3">
		<s:select list="#{'false':'否','true':'是'}" listKey="key" listValue="value" name="testRpHw" theme="simple" headerKey="" 
		value="testRpHw" cssClass="form-control input-sm" cssStyle="width:60px" id="testRpHw"></s:select>	
	    </div>	
	</div>
		
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary" id="tutor_div">课程辅导教师</h4>
</div>
</div>

<div class="form-group" style="margin-left: 15px;">
    <div id="coursetutor_container">
        <c:import url="${manageUrl}/course/manage/tutor.excsec?id=${curUser.id}">
        <c:param name="tutorUserIds" value="${teacherstr}"></c:param>
        </c:import>
    </div>
</div>

</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">	
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
        </button>
        <s:if test="curTenantID==null">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='course.action?tabFlag=${tabFlag}'">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
        </button>
        </s:if>
        <s:else>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='course!courseTenant.action?tabFlag=${tabFlag}'">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
        </button>
        </s:else>
</div>
</div>
</div>

</form>
</div>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
</body>
</html>
