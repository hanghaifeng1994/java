<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 辅导老师辅导的课程 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<title>课程的在线提问回复<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp"%></s:else></title>
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
		   document.getElementById("deleteForm").action="${ctx }/teacherquestion/manage/onlineteacherquestion!deleteAnswer.action?qid=${qid}";
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
					<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="onlineteacherquestion!answer.action?objectId=${objectId }&qid=${qid}" method="POST">
						<div class="dr-searchbar">
						 <input type="hidden" name="answerPage.pageNo" id="pageNo" value="${answerPage.pageNo}" />
	        			<input type="hidden" name="answerPage.orderBy" id="orderBy" value="${answerPage.orderBy}" />
	        			<input type="hidden" name="answerPage.order"	id="order" value="${answerPage.order}" />
			            
			          	<div class="form-group">
			                <label>内容</label>
			                <input style="width: 250px" name="content" type="text" placeholder="" class="form-control input-sm" value="${content }"/>
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
							<form name="deleteForm" id="deleteForm" action="onlineteacherquestion!answer.action?qid=${qid}" method="post">
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
										<th width="30%" >内容</th>
										<th width="10%" >回复人</th>
										<th width="10%" >回复时间</th>
										<th width="20%" >操作</th>
									</tr>
									<s:iterator value="answerPage.result" status="stat">
										<tr>
										<td>
										   <input type="checkbox" name="ids" id="ids" value="${id}" />
										 </td>
										 <td title="${content}"><common:cut len="50" string="${content}" /></td>
										 <td>${createUser.name}</td>
										 <td>${createTimeStr }</td>
										 <td>
											 <a class="btn btn-default btn-sm" type="button"  href="#" onclick="delRecord('onlineteacherquestion!deleteAnswer.action?ids=${id}&qid=${qid}');">
									             <span class="glyphicon glyphicon-trash"></span> 删除
									         </a>
					 					  </td>
										</tr>
									</s:iterator>
								</table>
								<s:set name="page" value="answerPage" scope="request"></s:set>
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
