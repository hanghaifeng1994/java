<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>集中考试管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		if($("#success").text()!="")$("#div-success").show();
	    if($("#error").text()!="")$("#div-error").show(); 
	   
	   
		$("#checkboxall").click(function(){
		        if($("#checkboxall").attr("checked")=="checked"){
		        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
		        }else {
		          $("input[name='ids']").removeAttr("checked");
		         }
		});
		 
		$("#batchSelect").change(function(){
			/* var obj = $("#batchSelect").find("option:selected");
			if($(this).val()==""){
				$("#pkinfo").html("");
				return;
			}
			var pkFlag = obj.attr("pkFlag");
			if(pkFlag=="true"||pkFlag==true){
				$("#pkinfo").html("<span style='color:green;'>已排考</span>");
			}else{
				$("#pkinfo").html("<span style='color:red;'>未排考</span>");
			} */
		});
		
		//验证批量删除文章的列表非空与否
		$("#batchDelDown").click(function(){
				var oaction = document.getElementById("mainForm").action;
				if(!checkSelect()) {
				   	b_alertx("没有可操作记录,请勾选");
				        return false;
				} 
			    b_confirmx('您确定要进行此操作吗?', function() {
			    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!batchDelete.action";
					$("#mainForm").submit();
					document.getElementById("mainForm").action = oaction;
			    });
		}); 
		
		//无锡复赛删除按钮
		$("#batchDelDownWxjs").click(function(){
				var oaction = document.getElementById("mainForm").action;
				if(!checkSelect()) {
				   	b_alertx("没有可操作记录,请勾选");
				        return false;
				} 
			    b_confirmx('您确定要进行此操作吗?', function() {
			    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!batchDeleteWxjs.action";
					$("#mainForm").submit();
					document.getElementById("mainForm").action = oaction;
			    });
		}); 
		
		$("#pkButton").click(function(){
			/* var oaction = document.getElementById("mainForm").action;
		    b_confirmx('您确定要进行此操作吗?', function() {
		    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!pkOption.action";
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
		    }); */
		    if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
		    	alert("请选择考试批次");
		    	return;
		    }
		    location.href="${ctx }/focus/manage/focusbatchmanager!examSearch.action?batchId="+$("#batchSelect").val();
		}); 
		
		$("#pkWxjsButton").click(function(){
			if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
		    	alert("请选择考试批次");
		    	return;
		    }
			var oaction = document.getElementById("mainForm").action;
		    b_confirmx('您确定要进行此操作吗?', function() {
		    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!pkWxjsOption.action";
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
		    });
		}); 
		
		
		$("#cancelPkButton").click(function(){
			 if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
			    	alert("请选择考试批次");
			    	return;
			    }
			var oaction = document.getElementById("mainForm").action;
		    b_confirmx('您确定要进行此操作吗?', function() {
		    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!cancelPkOption.action";
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
		    });
		}); 
		
		$("#joinExamButton").click(function(){
			 if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
			    	alert("请选择考试批次");
			    	return;
			    }
			var oaction = document.getElementById("mainForm").action;
		    b_confirmx('您确定要进行此操作吗?', function() {
		    	document.getElementById("mainForm").action="${ctx }/focus/manage/focusbatchmanager!joinExamOption.action";
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
		    });
		}); 
		
		$("#jiancha").click(function(){
			 if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
			    	alert("请选择考试批次");
			    	return;
			    }
		    location.href="${ctx }/focus/manage/focusbatchmanager!examSearch.action?batchId="+$("#batchSelect").val();
		}); 
		
		if("${export}"==true||"${export}"=="true"){
			   $('#exportbut').hide();
			   checkover();
		}
		
		if("${exportData}"==true||"${exportData}"=="true"){
			   $('#exportDatabut').hide();
			   checkzipover();
		}
		 
	});
    
	function checkSelect() {
		var flag1 = false;
		$("input[name='ids']:checked").each(function() {
			flag1 = true;
		});
		return flag1;
	}

	function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
	
	function exportbatchuser(){
		 if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
		    	alert("请选择考试批次");
		    	return;
		    }
		 $('#exportData').val('true');
		 document.mainForm.submit();
	}

	function checkover(){
		$.ajax({
	        type: "POST",
	        url: "focusbatchmanager!isFinishExportNew.action",
	        data: {
	        	"threadName": '${threadName}',"fileName":'${fileName}'
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.value=="false"){
					 $('#downLoad').show();
					 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
					 $('#font').hide();
					 $('#exportbut').show();
				 }else{
					 setTimeout('checkover()',3000);
			     } 
	        }
		});
	}
	
	function checkzipover(){
		$.ajax({
	        type: "POST",
	        url: "focusbatchmanager!isFinishZipExport.action",
	        data: {
	        	"threadName": '${threadName}',"fileName":'${fileName}'
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.value=="false"){
					 $('#downLoadData').show();
					 $('#downLoadData a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
					 $('#fontData').hide();
					 $('#exportDatabut').show();
				 }else{
					 setTimeout('checkzipover()',3000);
			     } 
	        }
		});
	}
	
	function clean(id)
	{
		var oaction = document.getElementById("mainForm").action;
			document.getElementById("mainForm").action="${ctx}/focus/manage/focusbatchmanager!modifyUserStudyinfo.action?cleanId="+id;
	        b_confirm('该学员的学时将被清空，您确定要进行清零吗?', function() {
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
	   	});
	}	
	var threadName;
	var upindex;
	function checkPs(){
		$.ajax({
	        type: "POST",
	        url: "focusbatchmanager!isFinish.excsec",
	        data: {
	        	"threadName": threadName,
			},
			dataType:"json",
	        success: function(data) {  
	        	upindex=setTimeout('checkPs()',1000);
				 if(data.value=="true"){
					 var num = data.label.split("_");
					 $("#success").html("     发布中！！！成功人数："+num[0]+" 失败人数："+num[1]);
				 }else{
					 var num = data.label.split("_");
					 $("#success").html("     发布中！！！成功人数："+num[0]+" 失败人数："+num[1]);
					 clearInterval(upindex);
			     } 
	        }
		});
	}
	
	function pubAndsys(){
		 if($("#batchSelect").val() == "" || $("#batchSelect").val() == null){
		    	b_alert("请选择考试批次");
		    	return;
		    }
		$.ajax({
	        type: "POST",
	    	dataType:"text",
	        url: "focusbatchmanager!pubFb.excsec",
	        data: {
	        	"batchId": $("#batchSelect").val(),
			},
	        success: function(data) {
	        	if(data=='false'){ 
	        		$("#error").html("    该批次已发布！！！");
	        		$("#div-error").show();
	        	}else{
		        	 threadName=data;
		        	$("#success").html("     发布中！！！");
		        	$("#div-success").show();
		        	 upindex=setTimeout('checkPs()',1000);
	        	}
	        }
		});
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
			<jsp:param value="focusbatchmanager" name="menu" />
			<jsp:param value="focus" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li><a href="#">集中考试管理</a>
				</li>
				<li class="active"><span>批次学员</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					批次学员列表<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
				<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
				<span id="success"><s:actionmessage theme="simple" /></span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
				<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
				<span id="error"><s:actionerror theme="simple" /></span>
			</div>
			<!--信息提示 end-->
			
			<s:if test="#request.iswxeduopen=='true'">
			<form id="uploadForm" class="form-inline dr-form-inline mt10 ml5 mr5" action="focusbatchmanager!saveimport.action" method="post" enctype="multipart/form-data">
			      <div class="dr-searchbar">
			        <div class="form-group">
			  		<label>下载数据文件包样本：
			  		<a href="${ctx}/template/wxjsstudent.xls"  target="_blank">导入样本.xls</a>
					</label>
					</div>
					<div class="form-group">
						<label>考试批次</label> <select name="batchId" style="width: 150px; height: 30px;" id="importBatchId">
						<option value="">--全部--</option>
							<c:forEach items="${userFocusBatchList}" var="item">
								<option value="${item.id }" pkFlag="${item.focusResult }" <c:if test="${item.id eq batchId }">selected="selected"</c:if>>${item.batchName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>组别</label> <select name="clazzId" style="width: 150px; height: 30px;" id="clazzId">
							<option value="">--全部--</option>
							<c:forEach items="${groupList}" var="item">
								<option value="${item.id }" <c:if test="${item.id eq clazzId }">selected="selected"</c:if>>${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
					<label >上传数据Excel文件</label>
					<input type="file" id="upload" name="upload" style="display: inline;" onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();"/>
					</div>
					<div class="form-group" id="uploadDiv">
					<button class="btn btn-primary btn-sm" type="button" id="Submit32" onclick="checkupload()">
					<span class="glyphicon glyphicon-open"></span>上传</button>
					</div>
					<div class="form-group ml30" id="uploadResult" style="display: none">
					<label>正在上传，请稍等、、、</label>
					</div>
					<div class="form-group ml30" id="errorResult" style="display: none">&nbsp;&nbsp;&nbsp;
					<label><a href="${fileName}" target="_blank">下载导入结果记录excel表格</a></label>
					</div>
					&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
				 </div>
			</form>
			<script>  
				$(document).ready(function() {
					if('${importThreadName}' != ''){
						checkimportover();
					}
					var uplaodflag = $("#uplaodflag").val();
			        if(uplaodflag == 'true'){
			        	$("#div-success").show();
					  	$("#success").text("上传完成，请查看导入结果记录表。");
				    	$('#errorResult').show();
				    	$('#importnum').show();
				    	$("#uplaodflag").val("false");
			        }
			        //信息提示  
					if($("#success").text()!="")$("#div-success").show();
					if($("#error").text()!="")$("#div-error").show();
					//信息提示  end
				});						 
				function  checkupload(){
					 var upload = $("#upload").val();
					 var importBatchId = $("#importBatchId").val();
					 var clazzId = $("#clazzId").val();
			         if(importBatchId==""||importBatchId==null){
			         	  b_alert("请选择批次！");
			         }else if(clazzId==""||clazzId==null){
			         	  b_alert("请选择组别！");
			         }else if(upload == "" || upload == null){
			          	  b_alert("上传文件不能为空！");
			         }else {
			          	 $.ajax({
					        type: "POST",
					        url: "${ctx}/focus/manage/focusbatchmanager!canImport.action",
							dataType:"json",
							data:{
								batchId:importBatchId,
								clazzId:clazzId
							},
							async:false,
					        success: function(data) {
								 if(data.value=="true"){
									 $("#uploadForm").submit(); 
								 }else{
									 b_alert("你选择的组别和这个批次的组别不一致！");
							     } 
					        }
						});
						
			        	
			          }
			    } 
			    
				function checkimportover(){
						$.ajax({
					        type: "POST",
					        url: "${ctx}/focus/manage/focusbatchmanager!isFinishSaveImport.action",
					        data: {
					        	"importThreadName":'${importThreadName}',
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
									 setTimeout("checkimportover()",1000);
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
			</script>
			</s:if>

			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="focusbatchmanager.action" method="post">
				<!--搜索模块-->
				<div class="dr-searchbar">
					<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
					<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
					<input type="hidden" name="page.order" id="order" value="${page.order}" /> 
					<input type="hidden" name="export" value="false" id="export" />
					<input type="hidden" name="exportData" value="false" id="exportData" />
					<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}"/>
					<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
					<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
					<input type="hidden" name="clazzId" value="${clazzId}"/>
					<input type="hidden" name="fileName" value="${fileName}"/>
					
					<div class="form-group">
						<label>考试批次</label> <select name="batchId" style="width: 300px; height: 30px;" id="batchSelect">
						<option value="">--全部--</option>
							<c:forEach items="${userFocusBatchList}" var="item">
								<option value="${item.id }" pkFlag="${item.focusResult }" <c:if test="${item.id eq batchId }">selected="selected"</c:if>>${item.batchName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>状态</label> 
						<select name="filter_EQI_status" style="width: 100px; height: 30px;" id="filter_EQI_status">
							<option value="">全部</option>
							<option value="1" <c:if test="${param['filter_EQI_status'] eq 1 }">selected="selected"</c:if>>已排考</option>
							<option value="2" <c:if test="${param['filter_EQI_status'] eq 2 }">selected="selected"</c:if>>开考中</option>
							<option value="3" <c:if test="${param['filter_EQI_status'] eq 3 }">selected="selected"</c:if>>已参考</option>
							<option value="4" <c:if test="${param['filter_EQI_status'] eq 4 }">selected="selected"</c:if>>缺考</option>
						</select>
					</div>
					<div class="form-group">
						<label>是否发布</label> 
						<select name="filter_EQB_published" style="width: 100px; height: 30px;" id="filter_EQB_published">
							<option value="">全部</option>
							<option value="false" <c:if test="${param['filter_EQB_published'] eq false }">selected="selected"</c:if>>未发布</option>
							<option value="true" <c:if test="${param['filter_EQB_published'] eq true }">selected="selected"</c:if>>已发布</option>
						</select>
					</div>
					<div class="form-group">
						<label>用户名</label> <input class="form-control input-sm" type="text" name="userName" id="userName" value="${param['userName']}" />
					</div>
					<div class="form-group">
						<button class="btn btn-default btn-sm" name="Submit5" onclick="$('#pageNo').val('1');document.mainForm.submit()">
							<span class="glyphicon glyphicon-search"></span>搜索
						</button>
					</div>

					<div class="form-group">
						<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" onclick="exportexcel();">
							<span class="glyphicon glyphicon-export"></span>&nbsp;导出表格
						</button>
						<span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"> <a href="" target="_blank">批次学员导出excel文件下载</a> </label> </span>
					</div>
					<s:if test="#request.iswxeduopen=='false'">
					<div class="form-group">
						<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="pkButton">
							<span class="glyphicon glyphicon-share-alt"></span>排考
						</button>
					</div>
					</s:if>
					<s:else>
					<div class="form-group">
						<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="pkWxjsButton">
							<span class="glyphicon glyphicon-share-alt"></span>排考
						</button>
					</div>
					</s:else>
					<div class="form-group">
						<button class="btn btn-danger btn-sm" type="button" name="Submit4" id="cancelPkButton">
							<span class="glyphicon glyphicon-asterisk"></span>取消排考
						</button>
					</div>
					<div class="form-group">
						<button class="btn btn-primary btn-sm" type="button" name="Submit6" id="joinExamButton">
							<span class="glyphicon glyphicon-share-alt"></span>线上开考
						</button>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary btn-sm" type="button" name="Submit9" id="jiancha">
							<span class="glyphicon glyphicon-share-alt"></span>批次数据检测
						</button>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="pubAndsys();" >
							<span class="glyphicon glyphicon-share-alt"></span>发布
						</button>
					</div>
					
					<div class="form-group">
						<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportDatabut" onclick="exportbatchuser();">
							<span class="glyphicon glyphicon-export"></span>&nbsp;导出局域网数据包
						</button>
						<span style="font-size: 12px;"><span id="fontData" style="<s:if test="exportData"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoadData" style="display: none"> <a href="" target="_blank">批次学员机考zip下载</a> </label> </span>
					</div>
					
					<div class="form-group">
						<a name="report" type="button" class="btn btn-default btn-sm" id="report" target="_blank" href="<common:prop name="lp3.url" propfilename="" />/exam/import/score">
							<span class="glyphicon glyphicon-export"></span>&nbsp;局域网成绩上报
						</a>
					</div>
				</div>
				<!--搜索模块end-->
				<div class="panel panel-default">
					<s:if test="#request.iswxeduopen=='false'">
					<div class="btn-toolbar dr-btn-toolbar">
						<button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
							<span class="glyphicon glyphicon-trash"></span> 批量删除
						</button>
					</div>
					</s:if>
					<s:else>
					<div class="btn-toolbar dr-btn-toolbar">
						<button class="btn btn-default btn-sm" type="button" id="batchDelDownWxjs" name="Submit2">
							<span class="glyphicon glyphicon-trash"></span> 批量删除
						</button>
					</div>
					</s:else>
					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall" /></td>
								<th width="15%">用户名</th>
								<th width="8%">姓名</th>
								<th width="8%">班级</th>
								<th width="8%">课程</th>
								<th width="8%">考场名称</th>
								<th width="8%">考试开始时间</th>
								<th width="8%">考试结束时间</th>
								<th width="5%">状态</th>
								<th width="8%">联系电话</th>
								<th width="8%">综合成绩</th>
								<th width="8%">考试成绩</th>
								<th width="8%">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="page.result" status="stat">
								<tr>
									<td><input type="checkbox" name="ids" value="${id}" /></td>
									<td>${userClassCourseDTO.user.username}</td>
									<td>${userClassCourseDTO.user.name}</td>
									<td>${userClassCourseDTO.clazz.name}</td>
									<td>${userClassCourseDTO.course.name}</td>
									<td>${userFocusExamtimeDTO.userFocusResource.resName}</td>
									<td><s:date name="userFocusExamtimeDTO.startTime" format="yyyy.MM.dd HH:mm" /></td>
									<td><s:date name="userFocusExamtimeDTO.endTime" format="yyyy.MM.dd HH:mm" /></td>
									<td><s:if test="status == 3">已参考</s:if><s:elseif test="status == 2">开考中</s:elseif><s:elseif test="status == 4">缺考</s:elseif><s:elseif test="status == 1">已排考</s:elseif><s:elseif test="status == 5">已确认参赛</s:elseif><s:else>未排考</s:else></td>
									<td>${userClassCourseDTO.user.mobilephone}</td>
									<s:if test="userClassCourseDTO.examEnded==true">
									<td>${courseScore}</td>
									<td>${userClassCourseDTO.examScore*2}</td>
									</s:if>
									<s:else>
									<td>${userClassCourseDTO.courseScore}</td>
									<td></td>
									</s:else>
									<td>
									   <a href="#" onclick="clean('${userClassCourseDTO.id}')" class="btn btn-primary btn-sm">
                                       <span class="glyphicon glyphicon-edit"></span>&nbsp;清零</a>
                                    </td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<!-- </form> -->
				</div>
			</form>
			<%@ include file="/common/turnpage.jsp"%>
			<!--订单列表end-->
		</div>
		<!--footer start--> <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> <!--footer over--> </section>
	</div>
	<!-- container end -->
</body>
</html>