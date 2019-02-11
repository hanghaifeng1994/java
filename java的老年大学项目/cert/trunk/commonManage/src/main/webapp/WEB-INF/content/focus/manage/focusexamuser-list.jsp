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
$(document).ready(function(){  
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
function clean(id)
{
	var oaction = document.getElementById("mainForm").action;
		document.getElementById("mainForm").action="${ctx}/focus/manage/focusexamuser!cleanUp.action?cleanId="+id;
       b_confirm('该学员的学时和作业都将被清空，您确定要进行清零吗?', function() {
			$("#mainForm").submit();
			document.getElementById("mainForm").action = oaction;
   	});
}			
function checkover(){
	$.ajax({
        type: "POST",
        url: "focusexamuser!isFinishExportFaild.action",
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
			<jsp:param value="focusfail" name="menu" />
			<jsp:param value="focus" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li><a href="#">集中考试管理</a></li>
				<li class="active"><span>不合格人员表</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					不合格人员表<small>&nbsp;</small>
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
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="focusexamuser!failList.action" method="post">
				<div class="dr-searchbar">
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
						<label>失败次数</label> 
							<s:select list="#{'1':'一次','2':'二次','>2':'大于二次'}" listKey="key" listValue="value" name="failTime" theme="simple" headerValue="--全部--" headerKey="" value="failTime" cssClass="form-control input-sm" ></s:select>
					</div>
					<div class="form-group">
				     <label>用户名</label>
				     <input class="form-control input-sm" type="text" name="userName" id="userName" value="${param['userName']}"/>
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
					<div class="form-group">
						<button class="btn btn-default btn-sm" name="Submit5" onclick="$('#pageNo').val('1');document.mainForm.submit()">
							<span class="glyphicon glyphicon-search"></span> 搜索
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
					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<!-- <td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall" />-->
								</td>
								<th width="12%">用户名</th>
								<th width="10%">姓名</th>
								<th width="12%">班级</th>
								<th width="14%">课程</th>
								<th width="10%">完成时间</th>
								<th width="8%">预约批次</th>
								<th width="12%">单位</th>
								<th width="10%">联系电话</th>
								<th width="10%">失败次数</th>
								<th width="10%">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="page.result" status="stat">
								<tr>
									<!-- <td>
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
									</td>-->
									<td>${user.username}</td>
									<td>${user.name}</td>
									<td>${clazz.name}</td>
									<td>${course.name}</td>
									<td><s:date name="finishedTime" format="yyyy.MM.dd HH:mm:ss" />
									</td>
									<td>${focusBatchName}</td>
									<td>${user.unit}</td>
									<td>${user.mobilephone}</td>
									<td>${focusVisitCount}</td>
									<td>
                                       <a href="#" onclick="clean('${id}')" class="btn btn-primary btn-sm">
                                       <span class="glyphicon glyphicon-edit"></span>&nbsp;清零</a>
                                    </td>
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