<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<html>
<head>
<title>用户证书查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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
	 	        url: "usercert!publish.action",
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
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!publish.action";
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
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!checked.action";
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
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!unchecked.action";
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
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!printed.action";
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
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!unprinted.action";
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
			var usercertId=$("<input />");
			usercertId.attr("type","hidden");
			usercertId.attr("name","id");
			usercertId.attr("value",id);
			form.append(usercertId);
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
        url: "usercert!isFinishExport.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
					$('#d1').show();
				 	$('#d1').attr("href","${ctx}/cert/manage/usercert!downloadUserCert.action?fileName="+data.label+".pdf");
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
        url: "usercert!isFinishExportExcel.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
				 $('#d2').show();
				 $('#d2').attr("href","${ctx}/cert/manage/usercert!downloadUserCert.action?fileName="+data.label+".xls");
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
        url: "usercert!isFinishExport.action",
        data: {
        	"threadName": '${threadName}',"fileName":'${fileName}'
		},
		dataType:"json" ,
        success: function(data) {
			 if(data.value=="false"){
				 $('#downLoad').show();
				 $('#d3').show();
				 $('#d3').attr("href","${ctx}/cert/manage/usercert!downloadUserCert.action?fileName="+data.label+".pdf");
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
	<jsp:param value="usercert" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
  <!--adminLeft结束-->
   
    <section id="main" role="main"> 
    <div class="dr-container-fluid">
	<ol class="dr-breadcrumb">
		<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
		<li><a href="#" class="grey">培训项目管理</a></li>
		<li class="active">用户证书查询</li>
	</ol>
   <div class="dr-page-header">
     <h3>用户证书查询 </h3>
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

<form id="mainForm" name="mainForm"	action="${ctx}/cert/manage/usercert.action" method="post" class="form-inline dr-form-inline" >
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
						<label class="control-label"> 生成时间 </label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime01">
							<input type="text" value="${param['filter_GED_genTime']}" name="filter_GED_genTime" id="filter_GED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">-</label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime02">
							<input type="text" value="${param['filter_LED_genTime']}" name="filter_LED_genTime" id="filter_LED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					
<div class="form-group">
	<label>证书名</label>
	<input name="filter_LIKES_name" class="form-control input-sm"  value="${param['filter_LIKES_name']}"/>
</div>
<div class="form-group">
	<label>项目</label>
	<input name="filter_LIKES_trainingPrograms$name" class="form-control input-sm" style="width: 150px;" value="${param['filter_LIKES_trainingPrograms$name']}" />
</div>
<div class="form-group">
	<label>用户名</label>
	<input name="filter_LIKES_username" class="form-control input-sm"  value="${param['filter_LIKES_username']}"/>
</div>

<div class="form-group">
	<label>姓名</label>
	<input name="userNick" class="form-control input-sm" value="${param['userNick']}"/>
</div>		
<div class="form-group">
	<label>发布状态</label>
	<s:select list="#{'已发布':'true','未发布':'false'}"
			listKey="value" value="(#parameters.filter_EQB_published)"
			name="filter_EQB_published" listValue="key" headerKey=""
			headerValue="全部" theme="simple" cssClass="form-control input-sm"></s:select>
</div>
<div class="form-group">
	<label>审核状态</label>
	<select id="filter_EQI_checked" class="form-control input-sm" name="filter_EQI_checked">
		<option value="" >全部</option>
		<option value="0" <c:if test="${param.filter_EQI_checked=='0' }">selected="selected"</c:if>>未审核</option>
		<option value="1" <c:if test="${param.filter_EQI_checked=='1' }">selected="selected"</c:if>>审核通过</option>
		<option value="2" <c:if test="${param.filter_EQI_checked=='2' }">selected="selected"</c:if>>审核不通过</option>
	</select>
</div>
<div class="form-group">
	<label>导出状态</label>
	<s:select list="#{'已导出':'true','未导出':'false'}"
			listKey="value" value="(#parameters.filter_EQB_printed)"
			name="filter_EQB_printed" listValue="key" headerKey=""
			headerValue="全部" theme="simple" cssClass="form-control input-sm"></s:select>
</div>
<div class="form-group">
<button name="Submit5"  onclick="$('#pageNo').val('1');$('#exportExcel').val('false');$('#export').val('false');document.mainForm.submit();" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
</div>
<div class="form-group">
	<button name="Submit1" type="button" class="btn btn-default btn-sm" id="exportbsbut" onclick="printeds();">
		<span class="glyphicon glyphicon-export"></span>&nbsp;按条件标识已导出
	</button>
	<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" onclick="exportexcel();">
		<span class="glyphicon glyphicon-export"></span>&nbsp;导出用户证书
	</button>
	<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportexcelbut" onclick="exportexcel2();">
		<span class="glyphicon glyphicon-export"></span>&nbsp;导出邮寄信息
	</button>
	<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exporttdbut" onclick="exportexcel3();">
		<span class="glyphicon glyphicon-export"></span>&nbsp;导出套打证书
	</button>
	<span style="font-size: 12px;"><span id="font" style="<s:if test="export||exportExcel"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"><a href="#" target="_blank" id="d1" download="abc.pdf" style="display: none;">用户证书pdf文件下载</a><a href="" target="_blank" id="d2" style="margin-left:30px;display: none;">邮寄信息excel文件下载</a><a href="#" target="_blank" id="d3" download="abc.pdf" style="display: none;">套打证书pdf文件下载</a></label> </span>
</div>		
<input type="hidden" id="onecat" name="onecat" value="${onecat }" />
<input type="hidden" id="twocat" name="twocat" value="${twocat }" />
<input type="hidden" id="threecat" name="threecat" value="${ threecat}"/>
</div>
</form>


<form name="deleteForm" id="deleteForm" action="usercert!delete.action"	method="post">
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
<button name="Submit2" type="button" class="btn btn-primary btn-sm" id="batchDelDown" onclick="batchViewPrint('ids','${ctx}/certviewprint!batchViewPrint.excsec',
		'<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}" /><%=CerttemplateField.CETTEMPLATE_PATH%>',true,false,false);" ><span class="glyphicon glyphicon-list-alt"></span>&nbsp;批量套打
</button>
</div>
<div class="btn-group">
<button	name="Submit2" type="button" class="btn btn-primary btn-sm"
	    id="batchDelDown" onclick="batchViewPrint('ids','${ctx}/certviewprint!batchViewPrint.excsec',
	    '<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" 
    	defaultvalue="${pageContext.request.contextPath}" /><%=CerttemplateField.CETTEMPLATE_PATH%>',true,true,false);">
	    <span class="glyphicon glyphicon-print"></span>&nbsp;批量打印</button>
</div>
<div class="btn-group">
<button name="Submit22"  type="button" id="batchPublishDown" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量发布</button>
</div>
<div class="btn-group">
<button name="Submit23"  type="button" class="btn btn-primary btn-sm" id="checked"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量审核通过</button>
</div>
<div class="btn-group">
<button name="Submit24"  type="button" class="btn btn-primary btn-sm" id="unchecked"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量审核不通过</button>
</div>
<s:if test="#request.isHbddopen=='true'">
<div class="btn-group">
<button name="Submit25"  type="button" class="btn btn-primary btn-sm" id="printedButton"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量标识已导出</button>
</div>
<div class="btn-group">
<button name="Submit27"  type="button" class="btn btn-primary btn-sm" id="unprintedButton"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量标取消导出</button>
</div>
</s:if>

<div class="btn-group" style="float: right;">
       <span>已发布证书数量：<font style="color: #11B1CD;">${published}</font></span>&nbsp;&nbsp;&nbsp;&nbsp;
       <span>未发布证书数量：<font color="red">${unPublished}</font></span>
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
		<th width="18%" >证书名称</th>
		<th width="15%" >证书号</th>		
		<th width="15%" >用户名</th>
		<th width="8%"  >姓名</th>		
		<th width="15%"  >用户图像</th>
		<th width="5%"  >发布</th>
		<th width="5%"  >导出</th>
		<th width="5%"  >审核状态</th>
		<th width="12%" >操作</th>		
	</tr></thead>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids" value="${id}"/></td>
			<td title="${name}">
			<common:cut len="30" string="${name}"/>
			</td>
			<td>${certno}</td>				
			<td>${username}</td>
			<td>${realName}</td>			
			<td>
				<img width=90 height=90 src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${user.avatarWithDefault}" />
			</td>
			<td>${publishStr}</td>
			<td>${printStr}</td>
			<td>${checkedStr}</td>
			<%-- <td><s:date name="printedTime" format="yyyy.MM.dd"/></td> --%>
			<td>
			<div class="btn-group">
               <button class="btn btn-default btn-sm" type="button" id="oper_${id}" style="padding: 5px 8px;">
                                           证书管理
              </button>
              <button data-toggle="dropdown" class="btn btn-default btn-sm dropdown-toggle" type="button" style="height: 30px;padding: 5px">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
              </button>
                     <ul role="menu" class="dropdown-menu">
                     <!--  <li><a href="javascript:void(0)" onclick="singleViewPrint('${id}','${ctx}/certviewprint!singleViewPrint.excsec','<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}" /><%=CerttemplateField.CETTEMPLATE_PATH%>',true,true,false);">预览打印</a></li>-->
                     <li onclick="download(${id});"><a href="${ctx}/certviewprint!downloadUserCert.excsec?id=${id}&time=<%=new java.util.Date().getTime()%>" id="downloadcert_${id}">下载证书</a></li>

                     <li><a href="javascript:void(0)" onclick="singleViewPrint('${id}','${ctx}/certviewprint!singleViewPrint.excsec','<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}" /><%=CerttemplateField.CETTEMPLATE_PATH%>',true,false,false);">预览套打</a></li>
                     <li><s:if test="published">
			          <a href="usercert!unpublish.action?ids=${id }">取消发布</a>			
			            </s:if>
						<s:else>
						<a href="usercert!publish.action?ids=${id }">发布证书</a>
						</s:else></li>
                     </ul>
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