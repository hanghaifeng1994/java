<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>竞赛统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.user.util.UserUtils@getCurUser()"></s:set>
<script type="text/javascript">
$(document).ready(function(){
	 if(${export}){
		   $('#exportbut').hide();
		   checkover();
	   }
});

function exportexcel(){
	 $('#export').val('true');
	 document.mainForm.submit();
}

function checkover(){
	$.ajax({
        type: "POST",
        url: "jinsaiareaschoolcount!isFinishExportNew.action",
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
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="schoolCount" name="menu" />
	<jsp:param value="jinsai" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">竞赛统计</a>
</li>
<li class="active">学校竞赛统计</li>
</ol>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/jinsaiareaschoolcount.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>
<div class="form-group">
	<label>所属项目</label>
	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" 
			headerKey="" cssClass="form-control" name="programesId" onChange="changeProgrames();"></s:select>
</div>
<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
</div>
</form>
<form name="deleteForm" id="deleteForm" action="course.action" method="post">
 <div class="panel panel-default  mt10 mb10" >
  <s:if test="filter!=1">
 	<div class="btn-toolbar dr-btn-toolbar">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">学校竞赛导出excel文件下载</a>
				</label>
			    </span>
     </div>
 </s:if>
<table  class="table table-bordered dr-table-bordered"  ><tr>	
		<th width="4%">序号</th>
		<th width="4%">地区</th>
		<th width="4%">学校名称</th>
		<th width="5%">注册人数</th>
		<th width="5%">初赛人数</th>
		<th width="5%">复赛人数</th>
		<th width="6%">复赛率</th>
		<s:iterator value="clazzList" status="stat" var="c">
			<th width="6%">${c }</th>
		</s:iterator>
	</tr>
	<s:iterator value="page.result" status="stat">
			<c:if test="${schoolname ne null and schoolname ne '' }">
				<tr>
					<td><s:property value="#stat.index+1"></s:property></td>
					<td>${area}</td>
					<td>${schoolname}</td>
					<td><c:if test="${registernum eq null}">0</c:if><c:if test="${registernum ne null}">${registernum}</c:if></td> 
					<td><c:if test="${chusainum eq null}">0</c:if><c:if test="${chusainum ne null}">${chusainum}</c:if></td>
					<td><c:if test="${fusainum eq null}">0</c:if><c:if test="${fusainum ne null}">${fusainum}</c:if></td> 
					<td>
					<c:if test="${chusainum eq null or fusainum eq null or chusainum == '0'}">0</c:if>
					<c:if test="${!(chusainum eq null or fusainum eq null or chusainum == '0')}">
						<fmt:formatNumber type="number" value="${fusainum/chusainum*100}" maxFractionDigits="2"/>
					</c:if>%
					</td>
					
					<c:forEach  items="${allJinsaiDateVO}" var = "datavo">
						<td><c:if test="${datavo.chuValue eq null}">0</c:if><c:if test="${datavo.chuValue ne null}">${datavo.chuValue}</c:if></td>
						<td><c:if test="${datavo.fuValue eq null}">0</c:if><c:if test="${datavo.fuValue ne null}">${datavo.fuValue}</c:if></td> 
					</c:forEach>
					
				</tr>
			</c:if>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</section>
<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</body>
</html>