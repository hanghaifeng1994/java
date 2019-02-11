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
<script type="text/javascript">  
$(document).ready(function(){
	    if($("#success").text()!="")$("#div-success").show();
	    if($("#error").text()!="")$("#div-error").show();
		//alert(111);
		//alert('${export}'); 
		if(${export}){
		     $("#exportbut").hide();
		     checkover();
	    }
	}); 
	function exportexcel(){
		//alert(11111222222)
		 $('#export').val('true');
		 document.exportForm.submit();
	}

	 function checkover(){
			$.ajax({
		        type: "POST",
		        url: "${ctx}/clazz/manage/clazz!isFinishExportNew.action",
		        data: {
		        	"threadName":'${threadName}',"fileName":'${fileName}'
				},
				dataType:"json",
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
    
    <form class="form-inline dr-form-inline" id="exportForm" name="exportForm" action="${ctx}/clazz/manage/clazz!learningcount.action" method="post">
  		<!--<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />  -->
		<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
		<input type="hidden" name="page.order" id="order" value="${page.order}" />
		<input type="hidden" name="export" value="false" id="export"/>
		<input	type="hidden" name="id" id="id" value="${id}" />
  		<!--<div class="form-group">
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.exportForm.submit();$('#export').val('false');">
			<span class="glyphicon glyphicon-export"></span>
			 导出
			</button>
		</div>
		
		--><div class="btn-toolbar dr-btn-toolbar">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="$('#export').val('true');document.exportForm.submit();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">个人学情导出excel文件下载</a>
				</label>
			    </span>
     </div>
  	</form>

  </div>

<form id="mainForm" name="mainForm"	action="clazz!learningcount.action" class="form-inline dr-form-inline" method="post">
	<input type="hidden" name="page4.pageNo" id="pageNo" value="${page4.pageNo}" />
	<input type="hidden" name="page4.orderBy" id="orderBy" value="${page4.orderBy}" />
	<input type="hidden" name="page4.order" id="order" value="${page4.order}" />
	<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}"/>
	<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
	<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
	<input type="hidden" name="export" value="false" id="export"/>
	<input	type="hidden" name="id" id="id" value="${id}" />
	
   
	
<div class="panel panel-default panel panel-default mt10 mb10 ml5 mr5">

<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
	<th width="5%">序号</th>
		<th width="10%">学员账号</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="5%">单位</th>
		<th width="5%">地区</th>
		<s:if test="programsCheckDTO.hasKcxx">
		<th width="8%">课程学时（分钟）</th>
		</s:if>
		
		<s:if test="programsCheckDTO.hasscore">
		<th width="7%">学习成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasKhzy">
		<th width="7%">作业已提交</th>
		<th width="7%">作业已评</th>
		<th width="7%">作业未提交</th>		 
		<th width="7%">作业总成绩</th>
		 </s:if>
		 <s:if test="programsCheckDTO.hasXxglgjjh">		 		 
		<th width="7%">研修成果已提交</th>
		<th width="7%">研修成果成绩</th>
		</s:if>
		
		<s:if test="programsCheckDTO.hasLtyt">
		<th width="7%">研修讨论发帖数</th>
		<th width="7%">研修讨论考核成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasYxrz">
		<th width="7%">研修日志发布数</th>
		<th width="7%">研修日志成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasYdjb">
		<th width="7%">阅读简报个数</th>
		<th width="7%">简报阅读成绩</th>
		</s:if>
		 <s:if test="programsCheckDTO.hasKccy">	 
		<th width="7%">测验成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasscore">		
		<th width="7%">最终成绩</th>
		</s:if>		
		<s:elseif test="programsCheckDTO.hashour">
			<th width="7%">所得学时</th>
			<th width="7%">考核要求学时</th>
		</s:elseif>
		<s:if test="programsCheckDTO.hasscore">
			<th width="9%">是否合格</th>
		</s:if>
		<s:else>
			<th width="9%">是否完成</th>
		</s:else>
		<%-- <th width="5%">序号</th>
		<th width="10%">学员账号</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="5%">单位</th>
		<th width="5%">地区</th>
		<th width="8%">课程学时（分钟）</th>
		<s:if test="type==0">
		<th width="7%">学习成绩</th>
		</s:if>
		<th width="7%">作业已提交</th>
		<th width="7%">作业已评</th>
		<th width="7%">作业未提交</th>
		<s:if test="type==0">
		<th width="7%">作业总成绩</th>
		</s:if>
		<s:if test="#request.isahstudyopen=='true'">
				
			</s:if>
			<s:else>
			<th width="7%">研修成果已提交</th>
		<th width="7%">研修成果成绩</th>
		<th width="7%">研修讨论发帖数</th>
		<th width="7%">研修讨论考核成绩</th>
		<th width="7%">研修日志发布数</th>
		<th width="7%">研修日志成绩</th>
		<th width="7%">阅读简报个数</th>
		<th width="7%">简报阅读成绩</th>
			</s:else>
			<th width="7%">测验成绩</th>
	<s:if test="type==0">
		
		<th width="7%">最终成绩</th>
		</s:if>
		
		<s:if test="type==0"></s:if>
		<s:else>
			<th width="7%">所得学时</th>
			<th width="7%">考核要求学时</th>
		</s:else>
		<s:if test="type==0">
			<th width="9%">是否合格</th>
		</s:if>
		<s:elseif test="type==1">
			<th width="9%">是否完成</th>
		</s:elseif> --%>
	</tr>
	<s:iterator value="page4.result" status="stat">
		<tr>
		<td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${unit}</td>
			<td>${canton}</td>
			<s:if test="programsCheckDTO.hasKcxx">
			<td>${studytime}</td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasscore">
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasKhzy">
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>			 
			<td><fmt:formatNumber type="number" value="${homescoresum}"  maxFractionDigits="1"/></td>
			</s:if>
		 
			<s:if test="programsCheckDTO.hasXxglgjjh">
			<td>${trainresultsigned}</td>
			<td><fmt:formatNumber type="number" value="${trainresultscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasLtyt">
			<td>${traindiscussposts}</td>
			<td><fmt:formatNumber type="number" value="${traindiscussscore}"  maxFractionDigits="1"/></td>		 		 
			</s:if>
			<s:if test="programsCheckDTO.hasYxrz">
			<td>${trainjournalsignsum}</td>			
			<td><fmt:formatNumber type="number" value="${trainjournalscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasYdjb">
			<td>${readnewslettersum}</td>			 
			<td><fmt:formatNumber type="number" value="${readnewsletterscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasKccy">
			<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasscore">				
			<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			</s:if>
			
			<s:elseif test="programsCheckDTO.hashour">
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
			</s:elseif>
			<td>
			<s:if test="programsCheckDTO.hasscore">
				<s:if test='qualified=="1"'>合格</s:if>
			  	<s:elseif test='qualified=="0"'>不合格</s:elseif>
			  	<s:else>未知</s:else>
			 </s:if>
			 <s:else>				 
			 	<s:if test='qualified=="1"'>完成</s:if>
			  	<s:elseif test='qualified=="0"'>未完成</s:elseif>
			  	<s:else>未知</s:else>			  	
			 </s:else>
			</td>
			<%-- <td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${unit}</td>
			<td>${canton}</td>
			<td>${studytime}</td>
			<s:if test="type==0">
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>
			<s:if test="type==0">
			<td>${homescoresum}</td>
			</s:if>
			<s:if test="#request.isahstudyopen=='true'">
				
			</s:if>
			<s:else>
				<td>${trainresultsigned}</td>
			<td><fmt:formatNumber type="number" value="${trainresultscore}"  maxFractionDigits="1"/></td>
			<td>${traindiscussposts}</td>
			<td><fmt:formatNumber type="number" value="${traindiscussscore}"  maxFractionDigits="1"/></td>		 		 
			<td>${trainjournalsignsum}</td>			
			<td><fmt:formatNumber type="number" value="${trainjournalscore}"  maxFractionDigits="1"/></td>
			<td>${readnewslettersum}</td>			 
			<td><fmt:formatNumber type="number" value="${readnewsletterscore}"  maxFractionDigits="1"/></td>
			</s:else>
			<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			<s:if test="type==0">
			
			<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="type==0"></s:if>
			<s:else>
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
			</s:else>
			<td>
			<s:if test="type==0">
				<s:if test='qualified=="1"'>合格</s:if>
			  	<s:elseif test='qualified=="0"'>不合格</s:elseif>
			  	<s:else>未知</s:else>
			 </s:if>
			 <s:elseif test="type==1">
				 
			 	<s:if test='qualified=="1"'>完成</s:if>
			  	<s:elseif test='qualified=="0"'>未完成</s:elseif>
			  	<s:else>未知</s:else>
			  	
			 </s:elseif>
			</td> --%>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="page4" scope="request"></s:set>
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
