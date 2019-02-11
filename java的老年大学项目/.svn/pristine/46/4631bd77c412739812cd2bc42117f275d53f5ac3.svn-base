<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导入班级学员-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/ajaxfileupload.js" type="text/javascript"></script>
<style type="text/css">
    .form-control{width:250px;} 
    </style>
<script>
$(document).ready(function() {
	if('${threadName}' != ''){
		checkover();
		}
	var uplaodflag = $("#uplaodflag").val();
    if(uplaodflag == 'true'){
    	$("#div-success").show();
	  	$("#success").text("上传完成，请查看导入结果记录表。");
    	$('#errorResult').show();
    	$('#importnum').show();
    	$("#uplaodflag").val("false");
    }
      
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();

    
	$("#inputform").validate({
		rules: {
			upload: {
				required: true
			}
		},
		messages: {
			upload: {
				required: "请选择导入文件包"
			}
		},
		errorPlacement: function(error, element) {
			if (document.getElementById("error_" + element.attr("name"))) {
				error.appendTo("#error_" + element.attr("name"));
			} else error.insertAfter(element);
		},
		onsubmit: function(element) { $(element).valid(); },
		onfocusout: function(element) { $(element).valid(); },			
		onkeyup: function(element) { $(element).valid(); },
	    onfocusin: function(element) { $(element).valid(); },
        success: function(label) { 
			var e = $(label).parent().attr("id").split("_")[1];
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
        errorElement: "strong" ,
	});

})

 function  checkupload(){
		 var upload = $("#upload").val();
         if(upload == "" || upload == null){
          b_alert("上传文件不能为空！");
          }else {
        	  $("#uploadForm").submit(); 
          }
    } 
	 function checkover(){
			$.ajax({
		        type: "POST",
		        url: "${ctx}/clazz/manage/clazz!isFinishSaveStudent.action",
		        data: {
		        	"threadName":'${threadName}',
				},
				dataType:"json",
		        success: function(data) {
					 if(data.value=="true"){
						 var num = data.label.split("_");
						 $("#uploadDiv").hide();
						 $("#uploadResult").show();
						 $('#importnum').show();
						 $('#sucessImport').text(num[0]);
						 $('#uSucessImport').text(num[1]);
						 setTimeout("checkover()",1000);
					 }else{
						 var num = data.label.split("_");
						 $("#uplaodflag").val("true");
						 $("#sImportNum").val(num[0]);
						 $("#uImportNum").val(num[1]);
						 $("#mainForm").submit();   
				     } 
		        }
			});
		}
		
function uploadZip(){
	 if(upload == "" || upload == null){
	       b_alertx("上传文件不能为空！");
	       }else {
	    	   $("#next").attr("disabled","disabled");
	    	   $("#div-success").show();
	           $("#success").text("正在上传，请稍等、、、");
	           //b_alert("正在上传，请稍等、、、");
	    	   $.ajaxFileUpload(
	                   {
	                url:'${ctx}/clazz/manage/clazz!saveimportphoto.action',   //需要链接到服务器地址
	                secureuri:false,
	                fileElementId:'uploadPicZip',                        //文件选择框的id属性
	                dataType: 'json',                                     
	                success: function (data, status)            
	                {      
	                if(data.value == "true"){
	                	// $("#mainForm").submit();
	                	$("#next").removeAttr("disabled","disabled");
	                	$("#div-success").show();
	                    $("#success").text("上传完成！");
	                    }else if(data.value == "false"){
	                    }else{
	                    	if($("#success").text()!=""){
	                          	$("#div-success").hide();
	                          	$("#success").text("");
	                          	}
	                    	b_alert(data.label);
	                    	window.setTimeout('$("#mainForm").submit()',3000);
	                    }
	                },
	                error: function (data, status, e)  
	                {
	                	b_alert('添加失败');
	                	$('#line').val(0);
	                   	$('#uplaodflag').val(data.value);
	                   	$("#div-success").hide();
	                   	$("#success").text("");
	                   	window.setTimeout('$("#mainForm").submit()',3000);
	                }
	            }
	                   
	               );
	       }
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
<s:if test="flag2=='wxold'">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="input-group" name="menu" />
	<jsp:param value="clazz" name="bigmenu" />
    </jsp:include>
</s:if>
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
<li class="active">导入班级学员</li>
</ol>

<div class="dr-page-header">
<h3>
导入班级学员
</h3>
</div>
<hr/>

<div class="panel panel-default">
<div class="dr-steps clearfix">
   <ul role="tablist">
      <li class="first done" role="tab"><a href="#"><span class="current-info">current step: </span><span class="number">1.</span><span class="title">填写班级信息</span></a></li>
      <li class="done" role="tab"><a href="#"><span class="number">2.</span><span class="title">课程选择</span></a></li>
      <li class="current" role="tab"><a href="#"><span class="number">3.</span><span class="title">导入学员</span></a></li>
      <li class="last" role="tab"><a href="#"><span class="number">4.</span><span class="title">费用结算和管理设置</span></a></li>
      </ul>
</div>

<div class="dr-callout dr-callout-info">
<h4>XLS文件编辑规则：</h4>
<p>1.使用MicroSoft Office Excel编辑数据并生成XSL后缀的文件。<br />
2. xsl文件的表格中每一行单元格只能填写一个用户的数据，单元格字段顺序为：<font class="colorred">身份证*、姓名*、所在区划*、所在街道*、所在社区*、单位*、性别*、</font>课程代码<br />
3. 带星号标记 * 并且标为红色的字段为必填字段，请务必填写。 <br />
4.导入用户的初始密码则系统默认为与身份证号码最后6位</p>
</div>
<div class="dr-callout dr-callout-info">
<h4>个人照片文件编辑规则：</h4>
<p>1.个人照片需符合2寸报名照要求，即3.5*5.3cm （以3000dpi计算，则对应像素尺寸为413px*626px） <br />
2.个人照片的文件命名必须是身份证号，并且格式为jpg。</p>
<h4>文件包规则：</h4>
<p>1.将xls文件直接上传 <br />
2.将所有照片打包生成ZIP压缩格式并上传<br />
3.照片压缩包内不能有目录<br />
4.压缩包大小不超过80M大小</p>
</div>
<div class="alert alert-info alert-dismissable mt10">数据文件样本下载
 <span>下载数据文件包样本：
 <a href="${ctx}/template/clazzstudent.xls" class="bule" target="_blank">导入样本.xls
</a>
</span>
</div>
<form id="mainForm" class="form-horizontal dr-form-bordered" action="clazz!importstudent.action?id=${id}" method="post" enctype="multipart/form-data">
	<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}"/>
	<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
	<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="phaseId" value="${phaseId}" />
	<input type="hidden" name="programId" value="${programId}" />
	<input type="hidden" name="flag2" value="${flag2}" />
	<input type="hidden" name="flag" value="${flag}" />
	<input type="hidden" name="isdown" value="${isdown}" />
</form>
<form id="uploadForm" class="form-horizontal dr-form-bordered" action="clazz!saveimport.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="phaseId" value="${phaseId}" />
	<input type="hidden" name="programId" value="${programId}" />
	<input type="hidden" name="flag2" value="${flag2}" />
	<input type="hidden" name="flag" value="${flag}" />
	<input type="hidden" name="isdown" value="${isdown}" />
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">上传数据Excel文件和照片zip包</h4>
</div>
</div>
	<div class="form-group" id="validate_upload">
		<label class="col-md-2 control-label">数据Excel文件*：</label>
	    <div class="col-md-9"><input type="file" id="upload" name="upload" style="display: inline;" onclick="$('#errorResult').hide();$('#div-success').hide();$('#importnum').hide();"/>
	    <button id="uploadDiv" class="btn btn-primary btn-sm" name="Submit32" id="Submit32" type="button" onclick="checkupload()">
        <span class="glyphicon glyphicon-open"></span>&nbsp;上传
        </button>
		<span class="ml30" style="display: none" id="uploadResult">
		<label>正在上传，请稍等、、、</label>
		</span>
		<span class="ml30" style="display: none" id="errorResult">&nbsp;&nbsp;&nbsp;
		<label><a href="${uploadPath}" target="_blank">下载导入结果记录excel表格</a></label>
		</span>
		<span class="ml20" style="display: none" id="importnum"><span>成功导入数据：<label id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
	    </div>
		<!--<span id="error_upload" class="help-block"></span> -->
	</div>
	<div class="form-group" id="validate_uploadPicZip">
		<label class="col-md-2 control-label">照片zip包：</label>
	    <div class="col-md-9"><input type="file" id="uploadPicZip" name="uploadPicZip" style="display: inline;"/>
	    <button class="btn btn-primary btn-sm" name="Submit3" id="Submit3" type="button" onclick="uploadZip()">
        <span class="glyphicon glyphicon-open"></span>&nbsp;上传
        </button>
	    </div>
	</div>
	
	<div>
    </div>

<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<div class="panel-footer">
<center class="row">
<div class="col-md-12">
		<button id="next" class="btn btn-primary pull-right" type="button" onclick="window.location.href='clazz!cost.action?id=${id}&flag=${flag}&programId=${programId}&isdown=${isdown}'">
                       下一步<span class="glyphicon glyphicon-step-forward"></span>
        </button>
        </div>
</center>
</div>
</form>
</div>
</div>

<s:if test="unsuccesslist.size>0">		
   <div class="panel panel-default mt5 mb10 ml5 mr5">
		<div class="panel-heading"><label class="mt10 mb10" style="color:red;"> 未成功注册的学员 </label></div>
			<table class="table table-bordered dr-table-default">
				<thead>
				<tr>
					<th width="20%">用户名</th>
					<th width="20%">姓名</th>
					<th width="20%">身份证号</th>
					<th width="40%">失败描述</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="unsuccesslist" status="stat">
					<tr>
						<td style="color:red;">${userName}</td>
						<td style="color:red;">${name}</td>
						<td style="color:red;">${IDNo}</td>
						<td style="color:red;">${errorDesc}</td>
					</tr>
				</s:iterator>
			  </tbody>
			</table>
	</div>
</s:if>

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
