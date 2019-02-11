<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.Random"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<title>课程试读版本管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script type="text/javascript">
function isvalidatefile(){ 
	var form = document.getElementById("inputForm");
	var filevalue = form.uploadVedio.value;
	if(filevalue==""){
		$("#error_uploadVedio").html("请选择文件!"); 
		return false;
	}
	var filename = document.getElementById("uploadVedio").value;
    var extend = filename.substring(filename.lastIndexOf(".")+1); 
   	if(extend!=""){ 
   	   	extend=extend.toLocaleLowerCase();
		if(!(extend=="flv"||extend=="wmv"||extend=="mp4")){ 
		    $("#error_uploadVedio").html("请上传wmv、mp4、flv等视频文件!"); 
		    return false; 
		}else
		    return true;
   	} 
    return true; 
}

function submitForm(){
	 return isvalidatefile();
}

function cleartryreadvideo(id)
{
	 $.get("${ctx}/course/manage/course!tryreadVideoDelete.excsec", {id:id}, function (data){
   	 if(data!="")
			alert(data);
	 window.location.reload();
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
      <ol class="dr-breadcrumb">
        <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">课程管理</a></li>
        <li class="active">课程试读版本管理</li>
       </ol>
   <div class="dr-page-header">
     <h3>课程试读版本管理 </h3>
   </div>
   <hr/>
<form id="inputForm" class="form-horizontal dr-form-bordered" name="inputForm" action="course!saveRryread.action" method="post" enctype="multipart/form-data" onsubmit="return submitForm();">
<div class="tab-content dr-tabs-panel" style="padding: 0px;">
	  <input id="id" name="id" type="hidden" value="${course.id}" size="30" />

	 <div class="form-group" id="validate_name">
     <label class="col-md-2 control-label">试读视频<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="uploadVedio" id="uploadVedio" value="" type="file"/>
     <span class="help-block">提醒：请上传wmv、mp4、flv等视频文件格式作为课程试读版本：</span>
     </div>
     <div class="col-md-3">
      <s:if test="course.tryreadFile!=null">
	      	<span>目前视频文件：${course.tryreadFile}</span>
	      </s:if>
     </div>
     <span class="help-block" id="error_uploadVedio"></span>
     </div>
     
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">	
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>&nbsp;上 传
        </button>
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="cleartryreadvideo(${course.id})">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;删除试读视频
        </button>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="parent=null;window.close();">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;关闭管理窗口
        </button>
</div>
</div>
</div>
</div>
</form>
  </div>
  </section>
</div>
<!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
