<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<html>
<head>
<title>继教学时证书查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script  type="text/javascript"  src="${ctx}/js/LodopFuncs.js?v=1.2">${ctx}</script>
<script  type="text/javascript"  src="${ctx}/js/certprint.js?v=1.2"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="${ctx}/js/install_lodop64.exe"></embed>
</object>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script type="text/javascript">
    $(document).ready(function(){
	   $("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
	   });	
	   $("#batchAdd").click(function(){   
	 		var uccIds = $("#ids").val();
	 		if(uccIds==""){    
	 			 b_alert("没有可操作记录,请勾选");
	 			return false;
	 		}
	 		$.ajax({
	 	        type: "POST",
	 	        url: "certprint!publish.action",
	 	        data: {
	 	        	ids:uccIds,
	 			},
	 			dataType:"json" ,
	 	        success: function(data) {
	 	        }
	 		});
	     });
	   $("#batchPublishDown").click(function(){
		   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/certprint!publish.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	    $("#checked").click(function(){
   	       $("#pagenum").val($('#pageNo').val());
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/certprint!checked.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#unchecked").click(function(){
   	   	   $("#pagenum").val($('#pageNo').val());
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/certprint!unchecked.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#printedButton").click(function(){
   	       $("#pagenum").val($('#pageNo').val());
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/certprint!printed.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#unprintedButton").click(function(){
   	   	   $("#pagenum").val($('#pageNo').val());
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/certprint!unprinted.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#genTime01").datetimepicker({
	    	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
		}); 
		
	   $("#genTime02").datetimepicker({
		   	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
		 }); 
   	   

	    if("${export}"==true||"${export}"=="true"){
		   $('#exportbut').hide();
		   $('#exporttdbut').hide();
		   $('#exportexcelbut').hide();
		   checkover();
		} 
		
		if("${exporttd}"==true||"${exporttd}"=="true"){
		 	$('#exportbut').hide();
		 	$('#exporttdbut').hide();
		   $('#exportexcelbut').hide();
		   checkoverTd();
		} 
		
		if("${exportExcel}"==true||"${exportExcel}"=="true"){
		 	$('#exportbut').hide();
		 	$('#exporttdbut').hide();
		   $('#exportexcelbut').hide();
		   checkoverExcel();
		} 
	      // if(!confirm('您确定要进行此操作吗?')) return  false;

		 //  $("#deleteForm").submit();
		 //  document.getElementById("deleteForm").action = oaction;
		//}); 		
     });  
	 function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	 }

	 function downLoadPicture(id){
			//文件导出中不在响应
		
			
			var form=$("<form id=\"downLoadPicture\">");
			form.attr("style","display:none");
			form.attr("target","");  
			form.attr("method","post");
			form.attr("action","${ctx}/certviewprint!downloadUserCert.action");
			var certprintId=$("<input />");
			certprintId.attr("type","hidden");
			certprintId.attr("name","id");
			certprintId.attr("value",id);
			form.append(certprintId);
			$("body").append(form);
			form.submit();
			$("#downLoadPicture").remove();
			//timer =  window.setInterval("isFinsh()",1000);
		}

	 function download(id){
		 //alert($("#downloadcert_"+id).attr("href"));
			$("#downloadcert_"+id).attr("href",$("#downloadcert_"+id).attr("href")+"1");
		//alert($("#downloadcert_"+id).attr("href"));	
	}
	
function printeds(){
	b_confirm('您确定要按查询条件更新导出状态吗?', function() {
		var ids=""
		$("input[name='ids']:checked").each(function(){
			ids+=","+$(this).val();
		});
		if(ids!="") ids= ids.substr(1);
		$("#usercertids").val(ids);
		 $('#printedStatus').val('1');
		 $('#exportExcel').val('false');
		 $('#export').val('false');
		 $('#exporttd').val('false');
		 document.mainForm.submit();
	 }); 
}
	
function exportexcel(){
	var ids=""
	$("input[name='ids']:checked").each(function(){
		ids+=","+$(this).val();
	});
	if(ids!="") ids= ids.substr(1);
	$("#usercertids").val(ids);
	 $('#export').val('true');
	 $('#exportExcel').val('false');
	  $('#exporttd').val('false');
	 document.mainForm.submit();
}

function exportexcel2(){
	var ids=""
	$("input[name='ids']:checked").each(function(){
		ids+=","+$(this).val();
	});
	if(ids!="") ids= ids.substr(1);
	$("#usercertids").val(ids);
	 $('#exportExcel').val('true');
	 $('#export').val('false');
	 $('#exporttd').val('false');
	 document.mainForm.submit();
}

function exportexcel3(){
	var ids=""
	$("input[name='ids']:checked").each(function(){
		ids+=","+$(this).val();
	});
	if(ids!="") ids= ids.substr(1);
	$("#usercertids").val(ids);
	 $('#exporttd').val('true');
	 $('#export').val('false');
	 $('#exportExcel').val('false');
	 document.mainForm.submit();
}

function checkover(){
	$.ajax({
        type: "POST",
        url: "certprint!isFinishExport.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
					$('#d1').show();
				 	$('#d1').attr("href","${ctx}/cert/manage/certprint!downloadUserCert.action?fileName="+data.label+".pdf");
				 $('#font').hide();
				 $('#exportbut').show();
				  $('#exporttdbut').show();
				 $('#exportexcelbut').show();
			 }else{
				 setTimeout('checkover()',3000);
		     } 
        }
	});
}


function checkoverExcel(){
	$.ajax({
        type: "POST",
        url: "certprint!isFinishExportExcel.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
				 $('#d2').show();
				 $('#d2').attr("href","${ctx}/cert/manage/certprint!downloadUserCert.action?fileName="+data.label+".xls");
				 $('#font').hide();
				 $('#exportbut').show();
				  $('#exporttdbut').show();
				 $('#exportexcelbut').show();
			 }else{
				 setTimeout('checkoverExcel()',3000);
		     } 
        }
	});
}


function checkoverTd(){
	$.ajax({
        type: "POST",
        url: "certprint!isFinishExport.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
				 $('#d3').show();
				 $('#d3').attr("href","${ctx}/cert/manage/certprint!downloadUserCert.action?fileName="+data.label+".pdf");
				 $('#font').hide();
				 $('#exportbut').show();
				  $('#exporttdbut').show();
				 $('#exportexcelbut').show();
			 }else{
				 setTimeout('checkoverTd()',3000);
		     } 
        }
	});
}
	 
</script>
</head>
<body>
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="certprint" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
  <!--adminLeft结束-->
   
    <section id="main" role="main"> 
    <div class="dr-container-fluid">
	<ol class="dr-breadcrumb">
		<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
		<li><a href="#" class="grey">培训项目管理</a></li>
		<li class="active">继教学时证书查询</li>
	</ol>
   <div class="dr-page-header">
     <h3>继教学时证书查询 </h3>
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

<form id="mainForm" name="mainForm"	action="${ctx}/cert/manage/certprint.action" method="post" class="form-inline dr-form-inline" >
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
<input type="hidden" id="ctx" value="${ctx}"/>
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" id="export"/>
<input type="hidden" name="exporttd" id="exporttd"/>
<input type="hidden" name="exportExcel" id="exportExcel"/>
<input type="hidden" name="printedStatus" id="printedStatus"/>
<input type="hidden" name="usercertids" id="usercertids" value=""/>

<div class="form-group">
	<label>项目</label>
	<input name="programName" class="form-control input-sm" style="width: 150px;" value="${param['programName']}" />
</div>
<div class="form-group">
	<label>行业</label>
	<input name="hyxt" class="form-control input-sm" style="width: 150px;" value="${param['hyxt']}" />
</div>	
<div class="form-group">
	<label>单位名称</label>
	<input name="unit" class="form-control input-sm"  value="${param['unit']}"/>
</div>		

<div class="form-group">
	<label>用户名</label>
	<input name="username" class="form-control input-sm"  value="${param['username']}"/>
</div>

<div class="form-group">
	<label>姓名</label>
	<input name="userNick" class="form-control input-sm" value="${param['userNick']}"/>
</div>		
<div class="form-group">
	<label>证书编号</label>
	<input name="certno" class="form-control input-sm"  value="${param['certno']}"/>
</div>

<div class="form-group">
	<label class="control-label"> 生成时间 </label>
</div>
<div class="form-group" style="width:250px;">
	<div class="input-group date" id="genTime01">
		<input type="text" value="${param['startTime']}" name="startTime" id="startTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
		</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
		</span>
	</div>
</div>
<div class="form-group">
	<label class="control-label">-</label>
</div>
<div class="form-group" style="width:250px;">
	<div class="input-group date" id="genTime02">
		<input type="text" value="${param['endTime']}" name="endTime" id="endTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
		</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
		</span>
	</div>
</div>
<div class="form-group">
<button name="Submit5"  onclick="$('#pageNo').val('1');$('#exportExcel').val('false');$('#export').val('false');document.mainForm.submit();" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
</div>
</div>
</form>


<form name="deleteForm" id="deleteForm" action="certprint!delete.action"	method="post">
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="filter_GED_genTime" value="${param['filter_GED_genTime']}" />
<input type="hidden" name="filter_LED_genTime" value="${param['filter_LED_genTime']}" />
<input type="hidden" name="filter_LIKES_name"  value="${param['filter_LIKES_name']}"/>
<input type="hidden" name="filter_LIKES_trainingPrograms$name"  value="${param['filter_LIKES_trainingPrograms$name']}"/>
<input type="hidden" name="filter_LIKES_username"  value="${param['filter_LIKES_username']}"/>
<input type="hidden" name="userNick"  value="${param['userNick']}"/>
<input type="hidden" name="filter_EQB_published"  value="${param['filter_EQB_published']}"/>
<input type="hidden" name="filter_EQB_printed"  value="${param['filter_EQB_printed']}"/>
<input type="hidden" name="filter_EQI_checked"  value="${param['filter_EQI_checked']}"/>

<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<div class="btn-group">
	<button name="Submit2" type="button" class="btn btn-primary btn-sm" id="exportbut" onclick="exportexcel();">
		<span class="glyphicon glyphicon-export"></span>&nbsp;导出继教学时证书
	</button>
	<span style="font-size: 12px;"><span id="font" style="<s:if test="export||exportExcel"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"><a href="#" target="_blank" id="d1" download="abc.pdf" style="display: none;">继教学时证书pdf文件下载</a><a href="" target="_blank" id="d2" style="margin-left:30px;display: none;">邮寄信息excel文件下载</a><a href="#" target="_blank" id="d3" download="abc.pdf" style="display: none;">套打证书pdf文件下载</a></label> </span>
</div>		
</div>
<!-- 
<input name="Submit3" type="button" class="operation_btu1" value="发布课程" id="batchpublicDown" /> 
<input name="Submit3" type="button"	class="operation_btu2" value="取消发布" id="batchUnpublicDown" />
-->

<table class="table table-bordered dr-table-bordered">
    <thead>
	<tr>
		<th width="3%"  ><input type="checkbox" id="checkboxall"/></th>
		<th width="15%" >项目名称</th>
		<th width="15%" >证书编号</th>		
		<th width="15%" >用户名</th>
		<th width="8%"  >姓名</th>	
		<th width="10%"  >单位</th>
		<th width="10%"  >行业</th>
		<th width="10%"  >用户图像</th>
		<th width="10%"  >获取时间</th>	
		<th width="10%" >操作</th>		
	</tr></thead>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids" value="${id}"/></td>
			<td title="${programsName}">
			<common:cut len="30" string="${programsName}"/>
			</td>
			<td>${certno}</td>				
			<td>${username}</td>
			<td>${name}</td>			
			<td>${unit}</td>
			<td>${hyxt}</td>
			<td>
				<img width=90 height=90 src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${user.avatarWithDefault}" />
			</td>
			<td><s:date name="genTime" format="yyyy.MM.dd"/></td></td>
			<td>
			<div class="btn-group">
              <!-- 	<button name="Submit2" type="button" class="btn btn-primary btn-sm" id="exportbut" onclick="exportexcel();">
					下载
				</button> -->
				<a type="button" class="btn btn-primary btn-sm"  href="${ctx}/certviewprint!downloadUserCert.excsec?id=${id}&time=<%=new java.util.Date().getTime()%>" id="downloadcert_${id}">下载证书</a>
				
            </div>
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include	file="/common/turnpage.jsp"%>
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
</body>
</html>