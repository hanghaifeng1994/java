<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>集中考试管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
Array.prototype.add = function(val) {
    var index = this.indexOf(val);
    if (index == -1) {
        this.push(val);
    }
};
function idsArrayIdsToString(ids){
	var str = '';
	for(var i=0;i<ids.length;i++){
		if(ids[i]!=''&&ids[i]!=null&&ids[i]!='undefined'){
			str+=ids[i]+",";
		}
	}
	return str;
}
function initIdsArrayIds(){
	var idsArray = document.getElementById("idsArray").value;
	if(idsArray!=null){
		idsArrays = new Array();
		if(idsArray!='' && idsArray!=null&&idsArray!='undefined'){
				idsArrays = idsArray.split(",");
		}
	}
}
function modifyIdsArray(id){
	if(document.getElementById("idsArray")!=null){
		if($("#ids_"+id).attr("checked")=="checked"){//加入
			idsArrays.add(id);
			document.getElementById("idsArray").value = idsArrayIdsToString(idsArrays);
	    }else {//移出
	    	idsArrays.remove(id);
	    	document.getElementById("idsArray").value = idsArrayIdsToString(idsArrays);
	   	}
	}
}

function bathModifyIdsArray(ids){
	for(var i=0;i<ids.length;i++){
		if(ids[i]!=''&&ids[i]!=null&&ids[i]!='undefined'){
			if($("#"+ids[i].id).attr("checked")=="checked"){//加入
				idsArrays.add(ids[i].value);
				document.getElementById("idsArray").value = idsArrayIdsToString(idsArrays);
		    }else {//移出
		    	idsArrays.remove(ids[i].value);
		    	document.getElementById("idsArray").value = idsArrayIdsToString(idsArrays);
		   	}
		}
	}
}

$(document).ready(function(){  
	initIdsArrayIds()
	if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   

    $("#programSelect").change(function(){
    	$.ajax({
	        type: "POST",
	        url: "focusexamuser!getClazz.action",
	        data: {
    		 programId:$(this).val(),
			},
			dataType:"json" ,
	        success: function(data) {
				$("#clazzId").empty();
				$("#clazzId").append("<option value=''>--全部--</option>");
				$.each(data,function(i,v){
					$("#clazzId").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				
	        }
		});
    });
    
	$("#checkboxall").click(function(){
		if($("#checkboxall").attr("checked")=="checked"){
	    	$("input[name='uccIds']").attr("checked",$(this).attr("checked"));
	    }else {
	    	$("input[name='uccIds']").removeAttr("checked");
	   	}
		//加入或移出
    	bathModifyIdsArray($("input[name='uccIds']"));
	});
	$("#batchAdd").click(function(){
		
		var uccIds = $("#idsArray").val();
		if(uccIds==""){
			b_alertx("没有可操作记录,请勾选");
			return false;
		}
		$.ajax({
	        type: "POST",
	        url: "focusexamuser!checkUnyyCount.action",
	        data: {
	        	uccIds:uccIds,
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.count==0){
					document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchAdd.action";
					addTeachContentCourse();
				 }else{
					 b_confirmx('您要安排的考试学员中有'+data.count+'位没有进行预约，您是否确定要继续安排考试？', function() {
						document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchAdd.action";
						addTeachContentCourse();
					 });
				 }
	        }
		});
		//document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchAdd.action";
		//addTeachContentCourse();
		/* b_confirmx('您确定要进行此操作吗?', function() {
			$("#batchAddForm").submit();
			document.getElementById("batchAddForm").action = oaction;
		}); */
	});
	$("#batchImport").click(function(){
		$.ajax({
	        type: "POST",
	        url: "focusexamuser!checkUnyyCount.action",
	        data: {
	        	filter_GED_finishedTime:$("#filter_GED_finishedTime").val(),
	        	filter_LED_finishedTime:$("#filter_LED_finishedTime").val(),
	        	filter_EQS_focusExamTime:$("#filter_EQS_focusExamTime").val(),
	        	programId:$("#programSelect").val(),
	        	clazzId:$("#clazzId").val(),
	        	userName:$("#userName").val()
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.count==0){
					 b_confirmx('您确定要进行此操作吗?', function() {
						document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchImport.action";
						addTeachContentCourse();
					});
				 }else{
					 b_confirmx('您要安排的考试学员中有'+data.count+'位没有进行预约，您是否确定要继续安排考试？', function() {
						 document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchImport.action";
							addTeachContentCourse();
					 });
				 }
	        }
		});
		
		/* var oaction = document.getElementById("mainForm").action;
		document.getElementById("mainForm").action="${ctx }/focus/manage/focusexamuser!batchImport.action";
		b_confirmx('您确定要进行此操作吗?', function() {
			$("#mainForm").submit();
			document.getElementById("mainForm").action = oaction;
		}); */
	});
	
	  $("#finishedTime01").datetimepicker({
	    	 customFormat: "yyyy-mm-dd hh:ii:ss",
			 format: "yyyy-mm-dd hh:ii:ss",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
		}); 
	   $("#finishedTime02").datetimepicker({
		   	 customFormat: "yyyy-mm-dd hh:ii:ss",
			 format: "yyyy-mm-dd hh:ii:ss ",
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
		   checkover();
		}
   });
  

//选择批次后回调
function selectBatchCallBack(){
	if($("#batchId").val()==''||$("#batchId").val()==null){
		alert("请选择批次!");
		return false;
	}
	$("#mainForm").submit();
}
function tst(){location.reload();}

function addTeachContentCourse(){
    b_IframeLevel("${ctx}/focus/manage/focusbatchmanager!selectBatch.action",500,500,tst);
}

function exportexcel(){
	 $('#export').val('true');
	 document.mainForm.submit();
}

function checkover(){
	$.ajax({
        type: "POST",
        url: "focusexamuser!isFinishExportNew.action",
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

function changecity(){				
		var cityId = $("#cityId").val();
		if(cityId) {
			$("#city").val($("#cityId").find("option:selected").text());
			$.post("${ctx}/focus/manage/focusexamuser!getAreaJson.excsec",{"cityId":cityId},function(data) {
				$("#areaId option[value!='']").remove();
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#areaId option[value!='']").remove();
				$("#area").val("");
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${areaId}"==practiceUnit[i].value){
						    $("#areaId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
						    $("#area").val(practiceUnit[i].label);
					 }else{
						    $("#areaId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }
				}
			});
		}else{
			$("#areaId").val("");
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
			<jsp:param value="focusexamuser" name="menu" />
			<jsp:param value="focus" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li><a href="#">集中考试管理</a></li>
				<li class="active"><span>待考人员列表</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					待考人员列表<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>

			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none;">
				<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
				<span id="success"><s:actionmessage theme="simple" /></span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none;">
				<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
				<span id="error"><s:actionerror theme="simple" /></span>
			</div>
			<!--信息提示 end-->

			<!--搜索模块-->
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="focusexamuser.action" method="post">
				<div class="dr-searchbar">
				    <input type="hidden" name="idsArray" id="idsArray" value="${idsArray}" />
					<input type="hidden" name="batchId" id="batchId" /> <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input type="hidden" name="page.order" id="order" value="${page.order}" /> <input type="hidden" name="export" value="false" id="export" />
					<div class="form-group">
						<label class="control-label"> 完成时间 </label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="finishedTime01">
							<input type="text" value="${param['filter_GED_finishedTime']}" name="filter_GED_finishedTime" id="filter_GED_finishedTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">-</label>
					</div>
					<div class="form-group" style="width:250px;">
						<!--<input name="filter_GED_finishedTime" id="finishedTime01" style="width: 90px" value="${param['filter_GED_finishedTime']}" class="form-control input-sm"/>-->
						<div class="input-group date" id="finishedTime02">
							<input type="text" value="${param['filter_LED_finishedTime']}" name="filter_LED_finishedTime" id="filter_LED_finishedTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
						<!--<input name="filter_LED_finishedTime" id="finishedTime02" value="${param['filter_LED_finishedTime']}" style="width: 90px" class="form-control input-sm"/>-->
					</div>
					<div class="form-group">
						<label>预约批次</label> <select name="filter_EQS_focusExamTime" id="filter_EQS_focusExamTime" style="width:160px;height:30px;">
							<option value="">--全部--</option>
							<c:forEach items="${YYBatch}" var="item">
								<option value="${item.id }" <c:if test="${item.id eq param['filter_EQS_focusExamTime'] }">selected="selected"</c:if>>${item.batchName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
				     <label>用户名</label>
				     <input class="form-control input-sm" type="text" name="userName" id="userName" value="${param['userName']}"/>
			      </div>
			      <div class="form-group">
				     <label>姓名</label>
				     <input class="form-control input-sm" type="text" name="name" id="name" value="${param['name']}"/>
			      </div>
			      <div class="form-group">
						<label>项目</label> <select name="programId" id="programSelect" style="width:150px;height:30px;">
							<option value="">--全部--</option>
							<c:forEach items="${programlist}" var="item">
								<option value="${item.programDTO.id}" <c:if test="${item.programDTO.id eq programId }">selected="selected"</c:if>>${item.programDTO.name}</option>
							</c:forEach>
						</select>
					</div>
			       <div class="form-group">
						<label>班级</label> <select name="clazzId"  style="width:150px;height:30px;" id="clazzId">
							<option value="">--全部--</option>
							<c:forEach items="${clazzlist}" var="item">
								<option value="${item.id}" <c:if test="${item.id eq clazzId }">selected="selected"</c:if>>${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group" id="validate_cityId" >
						<label>城市</label>
							<s:select style="width:150px;height:30px;" onchange="changecity()" list="citysVLists" listKey="id" theme="simple" 
								listValue="name" name="cityId" value="cityId" id="cityId" headerKey="" headerValue="--所在市--"/>
					</div>
					<div class="form-group" id="validate_areaId" >
						<label>区县</label>
							<s:select style="width:150px;height:30px;" list="areaVLists" listKey="id" theme="simple" 
								listValue="name" name="areaId" value="areaId " headerKey="" headerValue="--所在区县--" id="areaId" />
					</div>
					<div class="form-group">
						<button class="btn btn-default btn-sm" name="Submit5" onclick="$('#pageNo').val('1');document.mainForm.submit()">
							<span class="glyphicon glyphicon-search"></span> 搜索
						</button>
					</div>
					<div class="form-group">
						<button class="btn btn-default btn-sm" type="button" id="batchImport" name="Submit3">
							<span class="glyphicon glyphicon-plus"></span>按查询结果移入考次
						</button>
					</div>
					<div class="form-group">
						<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" onclick="exportexcel();">
							<span class="glyphicon glyphicon-export"></span>&nbsp;导出
						</button>
						<span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span> <label class="ml10" id="downLoad" style="display: none"> <a href="" target="_blank">待考人员导出excel文件下载</a> </label> </span>
					</div>
				</div>
				<!--搜索模块end-->
				<div class="panel panel-default">
                     <div class="btn-toolbar dr-btn-toolbar">
						<div class="form-group">
							<button class="btn btn-default btn-sm" type="button" id="batchAdd" name="Submit2">
								<span class="glyphicon glyphicon-plus"></span>批量移入考次
							</button>
						</div>
					</div>
					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall" />
								</td>
								<th width="12%">用户名</th>
								<th width="10%">姓名</th>
								<th width="12%">班级</th>
								<th width="16%">课程</th>
								<th width="10%">完成时间</th>
								<th width="10%">预约批次</th>
								<th width="12%">单位</th>
								<th width="12%">联系电话</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="page.result" status="stat">
								<tr>
									<td>
									 <c:set  var="ischeck" value="0"></c:set>
										<c:forEach items="${idsArrayStr}" var="item">
											<c:if test="${item eq id}">
												<c:set  var="ischeck" value="1"></c:set>
											</c:if>
										</c:forEach>
										<c:if test="${ischeck eq 1}">
												 <input type="checkbox" checked="checked" name='uccIds' id="ids_${id}" value="${id}"  onclick="modifyIdsArray('${id}')" />
										</c:if>
										<c:if test="${ischeck ne 1}">
												 <input type="checkbox" id="ids_${id}" name='uccIds' value="${id}"  onclick="modifyIdsArray('${id}')" />
										</c:if>
									</td>
									<td>${user.username}</td>
									<td>${user.name}</td>
									<td>${clazz.name}</td>
									<td>${course.name}</td>
									<td><s:date name="finishedTime" format="yyyy.MM.dd HH:mm:ss" />
									</td>
									<td>${focusBatchName}</td>
									<td>${user.unit}</td>
									<td>${user.mobilephone}</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</form>
			<div class="panel panel-default">
				<%@ include file="/common/turnpage.jsp"%>
			</div>
		</div>
		<!--footer start--> 
		<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> 
		<!--footer over--> 
		</section>
	</div>
	<!-- container end -->
</body>

</html>