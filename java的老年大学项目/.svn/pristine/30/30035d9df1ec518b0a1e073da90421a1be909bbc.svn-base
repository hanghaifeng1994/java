<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级学员-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<script src="${staticurl}/js/ajaxfileupload.js" type="text/javascript"></script>
<link href="${staticurl}/wx_js/css/jquery.dataTables.min.css" rel="stylesheet"/>
<script src="${staticurl}/wx_js/js/jquery.dataTables.min.js"></script>
<script>  
	$(document).ready(function() {
		$('#theTable').DataTable({
			scrollY: 250,
			scrollX: true,
			autoWidth: false,
			paging: false,
			searching: false,
			ordering: false,
			info: false
		});
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
        //信息提示  
		if($("#success").text()!="")$("#div-success").show();
		if($("#error").text()!="")$("#div-error").show();
		//信息提示  end
		$(".colorbox").colorbox({ width: "950", height:"100%" , close: "关闭", overlayClose: false,href:'clazz!mimportstudent.action?clazzid=${id}'});
		});

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
</script>

</head>
<body>

<!--页头部-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>


<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
       <div class="dr-page-header">
     <h3>班级学员</h3>
   </div>
   <hr/>
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
   
<div class="panel panel-default mt10">
  <div class="panel-heading">
    <h3 class="panel-title">
       <s:if test='!clazz.selfClass'>集体</s:if><s:else>自主</s:else>报名班级"${clazz.name}"管理
    </h3>
    <div class="panel-toolbar">
       <ul class="nav nav-tabs pull-right">
	     <li><a href="clazz!minfo.action?id=${id}" >班级信息</a></li>
       	 <li class="active"><a href="clazz!learningcount.action?id=${id }" >班级学情统计</a></li>
	     <s:if test='!clazz.selfClass'>
	     </s:if>
		   <li><a href="clazz!mcourse.action?id=${id }">班级课程</a></li>
	     
	     <li><a href="clazz!mstudents.action?id=${id }">班级学员</a></li>
	     <li><a href="clazz!mmanager.action?id=${id }">班主任任命</a></li>
	     <s:if test='!clazz.selfClass'>
		 <li><a href="clazz!mcost.action?id=${id }">费用结算</a></li>
	    </s:if>
       </ul>
    </div>

  </div>

<form id="mainForm" name="mainForm"	action="clazz!mstudents.action" class="form-inline dr-form-inline" method="post">
	<input type="hidden" name="page2.pageNo" id="pageNo" value="${page2.pageNo}" />
	<input type="hidden" name="page2.orderBy" id="orderBy" value="${page2.orderBy}" />
	<input type="hidden" name="page2.order" id="order" value="${page2.order}" />
	<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}"/>
	<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
	<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
	<input	type="hidden" name="id" id="id" value="${id}" />
	
   
	
<div class="panel panel-default panel panel-default mt10 mb10 ml5 mr5">

 
  

<table class="table" id="theTable">
	<thead>
		<tr>
			<th rowspan="2">课程</th>
			<th rowspan="2">属性</th>
			<th rowspan="2">选课人数</th>
			<th rowspan="2">获得学分人数</th>
			<th colspan="4">学时完成率</th>
			<th colspan="4">学习覆盖率</th>
			<th colspan="3">任务完成率</th>
			<th colspan="4">已完成任务得分</th>
		</tr>
		<tr>
			<th>额定</th>
			<th>最高</th>
			<th>最低</th>
			<th>平均</th>
			<th>额定</th>
			<th>最高</th>
			<th>最低</th>
			<th>平均</th>
			<th>最高</th>
			<th>最低</th>
			<th>平均</th>
			<th>额定</th>
			<th>最高</th>
			<th>最低</th>
			<th>平均</th>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="groupCountVO.groupCourseCountVOs" status="stat">
		<tr>
			<td>${courseName}</td>
			<td>${courseType}</td>
			<td>${studentNum}</td>
			<td>${hasScoreNum}</td>
			<td>${needLearnTime}</td>
			<td>
                 <div class="progress mb0">
                     <div class="progress-bar" role="progressbar" aria-valuenow="67" aria-valuemin="0" aria-valuemax="100" style="width: ${maxLearnTimeRate}%;">
                         <span class="">${maxLearnTimeRate}</span>
                     </div>
                 </div>
			</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: ${minLearnTimeRate}%;">
                        <span class="">${minLearnTimeRate}%</span>
                    </div>
                </div>
            </td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100" style="width: ${averageLearnTimeRate}%;">
                        <span class="">${averageLearnTimeRate}%</span>
                    </div>
                </div>
			</td>
			<td>${needCovergeRate}</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: ${maxCoverageRate}%;">
                        <span class="">${maxCoverageRate}%</span>
                    </div>
                </div>
			</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${minCoverageRate}%;">
                        <span class="">${minCoverageRate}%</span>
                    </div>
                </div>
            </td>
			<td>
                 <div class="progress mb0">
                     <div class="progress-bar" role="progressbar" aria-valuenow="54" aria-valuemin="0" aria-valuemax="100" style="width: ${averageCoverageRate}%;">
                         <span class="">${averageCoverageRate}%</span>
                     </div>
                 </div>
			</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: ${maxTaskRate}%;">
                        <span class="">${maxTaskRate}%</span>
                    </div>
                </div>
			</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${minTaskRate}%;">
                        <span class="">${minTaskRate}%</span>
                    </div>
                </div>
			</td>
			<td>
                <div class="progress mb0">
                    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: ${averageTaskRate}%;">
                        <span class="">${averageTaskRate}%</span>
                    </div>
                </div>
			</td>
			<td>${needScore}</td>
			<td>${maxTaskScore}</td>
			<td>${minTaskScore}</td>
			<td>${averageTaskScore}</td>
		</tr>
	</s:iterator>
		<tr>
			<td>组课平均</td>
			<td></td>
			<td>${groupCountVO.averageStudentNum}</td>
			<td>${groupCountVO.averageHasScoreNum}</td>
			<td>${groupCountVO.averageNeedLearningTime}</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageHighestTime}%;">
                                       <span class="">${groupCountVO.averageHighestTime}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageLowestTime}%;">
                                       <span class="">${groupCountVO.averageLowestTime}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageTime}%;">
                                       <span class="">${groupCountVO.averageTime}%</span>
                                   </div>
                               </div>
			</td>
			<td>${groupCountVO.averageNeedCoverageRate}</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="69" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageHighestCoverageRate}%;">
                                       <span class="">${groupCountVO.averageHighestCoverageRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageLowestCoverageRate}%;">
                                       <span class="">${groupCountVO.averageLowestCoverageRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="53" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageCoverageRate}%;">
                                       <span class="">${groupCountVO.averageCoverageRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="81" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageHighestTastRate}%;">
                                       <span class="">${groupCountVO.averageHighestTastRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="32" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageLowestTastRate}%;">
                                       <span class="">${groupCountVO.averageLowestTastRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="61" aria-valuemin="0" aria-valuemax="100" style="width: ${groupCountVO.averageTastRate}%;">
                                       <span class="">${groupCountVO.averageTastRate}%</span>
                                   </div>
                               </div>
			</td>
			<td>${groupCountVO.averageNeedScore}</td>
			<td>${groupCountVO.averageHighestScore}</td>
			<td>${groupCountVO.averageLowestScore}</td>
			<td>${groupCountVO.averageScore}</td>
		</tr>
		<tr>
			<td>满分</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td></td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td></td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>
                               <div class="progress mb0">
                                   <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                       <span class="">100%</span>
                                   </div>
                               </div>
			</td>
			<td>100</td>
			<td>100</td>
			<td>100</td>
		</tr>
	</tbody>
</table>
 
<s:set name="page" value="page2" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>	




</div>
</div>
</section>
</div>
    <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
</body>
</html>
