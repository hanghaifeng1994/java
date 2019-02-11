<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
request.setAttribute("isShzx",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","isShzx"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短信发送-后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@include file="/common/admin_meta.jsp"%>
    <script src="${ctx}/layer/layer.js"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  
 	<script src="${ctx}/layer/layer.js"></script>
<script type="text/javascript" language="javascript">   
var index;
var threadName;
var sNum;
var eNum;
var upindex;
$(document).ready(function() { 
	
	if('${threadName}' != ''){
		checkimpover();
		}
		var flag = '${flag}';
	    if(flag == 'true'){
	    	$("#div-success").show();
		  	$("#success").text("上传完成，请查看导入结果记录表。");
	    	$('#errorResult').show();
	    	$('#importnum').show();
	    	 $("#flag").val("false");
	    }
	    
	index=setTimeout('checksend()',1000);
});   

function checksend(){
	$.ajax({
        type: "POST",
        url: "${ctx}/mspush/manage/mspush!countGainSucceed.action",
        data: {
        	"msId": '${id}',
        	"threadName": threadName
		},
		dataType:"json",
        success: function(data) {
        	$("#dsend").html(data.tagentNum+"人");
        	index=setTimeout('checksend()',2000);
      	  var p=(data.succeedNum)/(data.tagentNum);
        	 //$("#progress").css("width",p*100+"%"); 
        	 $("#succeedNum").html("已发送失败人数"+data.errorNum+"  |   已发送成功人数"+data.succeedNum); 
			 if(data.tagentNum==0){
				 clearInterval(index);	
			 $("#send").hide();
			 //$("#validate_progress").hide();
			 $("#fanhui").show(); 
            }else{ 
            	$("#send").show();
            }
        }
	});
}


function sendtipe(tr){
	$.ajax({
        type: "POST",
        url: "${ctx}/mspush/manage/mspush!countGainSucceed.action",
        data: {
        	"msId": '${id}',
        	"threadName": tr
		},  
		dataType:"json",
        success: function(data) {  
        	layer.msg("该短信系统正在发送中请勿操作！！！"+"<br>已发送失败人数 "+data.errorNum+" | 已发送成功人数 "+data.succeedNum, {
        		  time: 5000, 
        		  btn: ['关闭']
        		});
        	
        	
        	//b_alert("该短信系统正在发送中请勿操作！！！"+"已发送失败人数"+data.errorNum+"| 已发送成功人数"+data.succeedNum);
           }  
	});
}
function sendMs(){
	$.ajax({
        type: "POST",
    	dataType:"text",
        url: "${ctx}/mspush/manage/mspush!sendMs.action",
        data: {
        	"id": '${id}',
		},
        success: function(data) {
			 $("#div-success").hide();
        	if(data=="sending"){
        		if(threadName!=null){
        		    sendtipe(threadName);
        		}else{
        			sendtipe('${mspushDTO.sendingUser}');
        		}
        	}else{
        	threadName=data;
        	 $("#validate_progress").show();
			 $("#send").show();
			 $("#fanhui").hide(); 
			 $("#update").hide();
        	}
        }
	});
}



function updateMs(){ 
	$.ajax({
        type: "POST",
    	dataType:"text",
        url: "${ctx}/mspush/manage/mspush!updateMsdetail.action",
        data: {
        	"id": '${id}',
        	<s:if test="mspushDTO.serviceType==3">
        	"clazzId":'${mspushDTO.clazzId}',
        	</s:if>
		},
        success: function(data) {
        	 threadName=data;
        	$("#success").html("     更新中。。。。");
        	$("#div-success").show();
        	 upindex=setTimeout('checkover()',1000);
        	}
	});
}


function checkover(){
	$.ajax({
        type: "POST",
        url: "${ctx}/mspush/manage/mspush!isFinishUpdate.action",
        data: {
        	"threadName": threadName,
		},
		dataType:"json",
        success: function(data) {  
        	upindex=setTimeout('checkover()',1000);
			 if(data.value=="true"){
				 var num = data.label.split("_");
				 $("#success").html("     更新中！！！成功更新人数："+num[0]+" 失败更新人数："+num[1]);
			 }else{
				 var num = data.label.split("_");
				 $("#success").html("     更新中！！！成功更新人数："+num[0]+" 失败更新人数："+num[1]);
				 clearInterval(upindex);
				 setTimeout('checksend()',1000);
		     } 
        }
	});
}



function checkimpover(){
	$.ajax({
        type: "POST",
        url: "${ctx}/mspush/manage/mspush!isFinishSaveUser.action",
        data: {
        	"threadName": '${threadName}',
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
				 setTimeout('checkimpover()',1000);
			 }else{
				 var num = data.label.split("_");
				 $("#flag").val('true');
				 $("#sImportNum").val(num[0]);
				 $("#uImportNum").val(num[1]);
				 $("#mainForm").submit();   
		     } 
        }
	});
}

function  checkupload(){
    var upload = $("#upload").val();
    if(upload == "" || upload == null){
     b_alertx("上传文件不能为空！");
     }else {
  	   $("#mainForm").submit();   
     }
}
</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="mspushlist" name="menu" />
	<jsp:param value="mspush" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
		</li>
		<li>
		<a href="#">短信管理</a>
		</li>
		<li class="active"><span>发送短信</span></li>
		</ol> 
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>发送短信<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
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

   <!--导入模块-->
   <form id="mainForm" name="mainForm" action="mspush!tosendhome.action?id=${id}" class="form-inline dr-form-inline" method="post" enctype="multipart/form-data">
   <input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
	<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
    <input type="hidden" id="flag" name="flag" value=""/>
	
      <div class="dr-searchbar">
		<div  id="uploadDiv" style="display: inline;">
        <div class="form-group">
  		<label>下载数据文件包样本：
  		<a href="${ctx}/template/msdetailtemp.xlsx"  target="_blank">导入样本.xls</a>
		</label>
		</div>
		<div class="form-group">
		<label >上传数据Excel文件</label>
		<input type="file" id="upload" name="upload" style="display: inline;" onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();"/>
		</div>
		<div class="form-group">
		<button class="btn btn-primary btn-sm" type="button" id="Submit32" onclick="checkupload()">
		<span class="glyphicon glyphicon-open"></span>上传</button>
		</div>
		</div>
		<div class="form-group ml30" id="uploadResult" style="display: none">
		<label>正在上传，请稍等、、、</label>
		</div>
		
		<div class="form-group ml30" id="errorResult" style="display: none">&nbsp;&nbsp;&nbsp;
		<label><a href="${uploadPath}" target="_blank">下载导入结果记录excel表格</a></label>
		</div>
		&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
	 </div>
   </form>
   <!--导入模块-->
    <!--表单模块-->
    	<div class="panel panel-default">
    	<div class="form-horizontal dr-form-bordered" >
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">短信基本信息</h4>
		</div>
		</div>   
		<div class="form-group">
		<label class="col-md-2 ">业务类型</label>
		<div class="col-md-3">
		${mspushDTO.typeStr}
	    </div>	
		</div>
		<div class="form-group" id="validate_content" >
		<label class="col-md-2 ">短信内容<span class="text-danger"></span>
		</label>
		<div class="col-md-5">
		${mspushDTO.content}
		</div>
		<span id="error_content" class="help-block" ></span>
		</div>
		
		<s:if test="mspushDTO.serviceType==3">
		<div class="form-group" id="validate_program">
		<label class="col-md-2 ">所属 班级</label>
		<div class="col-md-3">
		${mspushDTO.clazzName}
	    </div>
		</div>
		</s:if>
		<s:else>
		<div class="form-group" id="validate_program">
		<label class="col-md-2 ">所属项目</label>
		<div class="col-md-3">
			<s:if test="mspushDTO.programName!=null">
					${mspushDTO.programName}
			</s:if><s:else>
					暂无项目
			</s:else>
	    </div>
		</div>
		</s:else>
		<div class="form-group" id="validate_program">
		<label class="col-md-2 ">待发送人数</label>
		<div class="col-md-3" id="dsend">
	    </div>
		</div>
		
		
<!-- 		<div class="form-group" id="validate_program">
		<label class="col-md-2 ">已发送成功人数</label>
		<div class="col-md-3" id="succeedNum">
	    </div>
		</div>
		
		<div class="form-group" id="validate_program">
		<label class="col-md-2 ">失败发送人数</label>
		<div class="col-md-3" id="errorNum">
	    </div>
		</div> -->
		
		<div class="form-group" id="validate_progress" style="display: none;">
		<label class="col-md-2 ">发送状态</label>
<!-- 		<div class="col-md-3" >
			<div class="progress">
	      <div style="background-color: #8bc638;" id="progress" class="progress-bar" role="progressbar" aria-valuenow="1"
		   aria-valuemin="0" aria-valuemax="100">
		  <span class="sr-only"></span>
	      </div>
          </div>
	    </div> -->
	    <div class="col-md-3" id="succeedNum"></div>
		</div> 
		
	  

		
		<div class="panel-footer"> 
		<div class="row">
		<div class="col-md-offset-2 col-md-10">
		    <a id="update" onclick="updateMs()" type="button"  class="btn btn-primary btn-sm"  >
			<span class="glyphicon glyphicon-bell"></span>&nbsp; 更新人数
			</a>
			
		 	<a  onclick=" sendMs();" id="send" type="button" class="btn btn-primary btn-sm" >
			<span class="glyphicon glyphicon-ok"></span>&nbsp;<s:if test="mspushDTO.statue==0"> 确认发送 </s:if><s:else> 重新发送</s:else>
			</a>    
			
		  <!--   <a id="zzsend" type="button" class="btn btn-primary btn-sm"  style="display:none">
			&nbsp;  正在发送 
			</a> --> 
			<a href="mspush.action" type="button" class="btn btn-primary btn-sm" id="fanhui" >
			<span class="glyphicon glyphicon-ok"></span>&nbsp;返回
			</a> 
		</div>
		</div>
		</div>
	    </div>
	    </div>
    <!--表单模块end-->
    
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
	</section>
</div>
<!-- container end -->
</body>
</html>