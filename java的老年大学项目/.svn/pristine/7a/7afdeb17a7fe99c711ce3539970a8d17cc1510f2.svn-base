<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 辅导老师辅导的课程 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<title>课程的在线提问<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp"%></s:else></title>
<link href="${staticurl}/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="${ctx}/js/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();    
	   	$("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
	   	});
		 $("#batchDelDown").click(function(){
			var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/teacherquestion/manage/onlineteacherquestion!delete.action?objectId=${objectId}&type=${type}";
			if(!checkSelect()) {
			   	b_alert("没有可操作记录,请勾选");
			    return false;
			} 
		    b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
		    });
	   }); 	
	
	
	});
	function myreplay(id){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!getQuestionDetail.action",
		    data: {
		    	"id":id
			},
			dataType:"json",
			success: function(data) {
				$("#title").html(data.content);
				$("#clazzCourseQustionId").val(data.id);
		   	}
		});
		
		$('#replaySelect').dialog({
				title : '我要回答',
				width:600,
				height:480,
				autoOpen : true,
				modal : true,
				resizable : false,
				buttons : {
					'确认' : function() {
						addReplay();
						$('#replaySelect').dialog('close');
						
					},
					'取消' : function() {
						$('#replaySelect').dialog('close');
					}
				}
		});
	}
	
	
	function addReplay(){
		$.ajax({
			type: "POST",
		    url: "${ctx}/clazzcourse/manage/clazzcourse!replay.action",
		    data: {
		    	"clazzCourseQustionId":$("#clazzCourseQustionId").val(),
		    	"content":$("#content").val()
			},
			dataType:"json",
			success: function(data) {
				$("#mainForm").submit();
		   	}
		});
	}
	
	function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
</script>
</head>

<body>
	<center>
		<!--header start-->
		<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
			<jsp:param value="" name="menu" />
		</jsp:include>
		<!--header over-->

		<div class="dr-wrapper">
			<section id="main" role="main">
			<div class="dr-container-fluid">
				<!--正文开始-->
				<div class="dr-page-header" style="text-align: left;">
					<h3>在线提问 </h3>
				</div>
				<hr />
				<!--信息提示-->
				<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="success"><s:actionmessage  theme="simple"/></span>
				</div>
				<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="error"><s:actionerror theme="simple"/></span>
				</div>
				<div class="dr-searchbar" style="text-align: left;">
					<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/teacherquestion/manage/onlineteacherquestion.action?objectId=${objectId }&type=${type}" method="POST">
						<div class="dr-searchbar">
						<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
				        <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
				        <input type="hidden" name="page.order"	id="order" value="${page.order}" />
			            
			            <div class="form-group">
			                <label>标题</label>
			                <input style="width: 250px" name="title" type="text" placeholder="" class="form-control input-sm" value="${title }"/>
			           	</div>
			           <div class="form-group">
			               	<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
			                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
			                </button>
			           </div>
						</div>
						</form>
				</div>

				<div class="panel panel-default">
					<div class="panel-body row">
						<div class="col-md-12">
							<form name="deleteForm" id="deleteForm" action="onlineteacherquestion.action?objectId=${objectId }&type=${type}" method="post">
								<div class="panel panel-default  mt10 mb10" >
									<div class="btn-toolbar dr-btn-toolbar">
								      	 <div class="btn-group">
											<button id="batchDelDown" class="btn btn-default btn-sm" name="Submit2" type="button">
											<span class="glyphicon glyphicon-trash"></span>
											批量删除
											</button>
										</div>
								    </div>
							    </div>
								<table class="table table-bordered dr-table-default"> 
									<tr>
										<th width="3%"><input type="checkbox" id="checkboxall" /></th>
										<th width="15%" >标题</th>
										<th width="30%" >内容</th>
										<th width="10%" >创建者</th>
										<th width="10%" >创建时间</th>
										<th width="20%" >操作</th>
									</tr>
									<s:iterator value="page.result" status="stat">
										<tr>
										<td ><input type="checkbox" name="ids" value="${id}" /></td>
										<td title="${title}"><common:cut len="24" string="${title}" /></td>
										 <td title="${content}"><common:cut len="50" string="${content}" /></td>
										 <td>${createUser.name}</td>
										 <td>${createTimeStr }</td>
										 <td>
										 <a class="btn btn-primary btn-sm" type="button" href="${ctx }/teacherquestion/manage/onlineteacherquestion!answer.action?qid=${id}&objectId=${objectId}" target="_blank">
								             <span class="glyphicon glyphicon-edit"></span> 回复管理
								         </a>
										 <a class="btn btn-default btn-sm" type="button"  href="#" onclick="delRecord('onlineteacherquestion!delete.action?ids=${id}&objectId=${objectId}');">
								             <span class="glyphicon glyphicon-trash"></span> 删除
								         </a>
										 </td>
										</tr>
									</s:iterator>
								</table>
								<s:set name="page" value="questionPage" scope="request"></s:set>
								<%@ include file="/common/turnpage.jsp"%>
							</form>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>

<!--footer start-->
   	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
   	<jsp:param value="index" name="menu"/>
   	</jsp:include>
<!--footer over-->
</body>
</html>
