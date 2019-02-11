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
	function changeprogram(){				
		var programId = $("#programesId").val();
		if(programId) {
			$.post("${ctx}/count/manage/jinsailearningsituation!getAreaJson.excsec",{"programId":programId},function(data) {
				$("#cantonId option[value!='']").remove();
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#cantonId option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${cantonId}"==practiceUnit[i].value){
						    $("#cantonId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else{
						    $("#cantonId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					}
				}
			});
		}
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
	<jsp:param value="diquCount" name="menu" />
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
<li class="active">地区竞赛统计</li>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/jinsailearningsituation.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>
 
<div class="form-group">
	<label>所属项目</label>
	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" 
			headerKey="" cssClass="form-control" name="programesId"  onChange="changeprogram();" id="programesId"></s:select>
</div>
<s:if test="filter==2">
<div class="form-group"> 
<div class="form-group"> 
	<label>所在地区</label>
	<s:select list="areaLists" listKey="name" listValue="name" theme="simple" 
			headerKey="" cssClass="form-control" name="area" headerValue="--全部--" id="cantonId"></s:select>
</div>
</s:if>
<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
	<div class="form-group">
	<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.mainForm.submit();">
	<span class="glyphicon glyphicon-export"></span>
	 导出
	</button>
	</div>
</div>

</div>
</form>
<form name="deleteForm" id="deleteForm" action="course.action" method="post">
 <div class="panel panel-default  mt10 mb10" >
<table   class="table table-bordered dr-table-bordered"  > 

	<tr>	
		<th width="5%">序号</th>
		<th width="5%">地区</th>
		<th width="4%">注册人数</th>
		<th width="4%">初赛人数</th>
		<th width="4%">复赛人数</th>
		<th width="5%">复赛率</th> 
		<th width="5%">初赛学校数量</th>
		<s:iterator value="clazzList" status="stat" var="c">
			<th width="6%">${c }</th>
		</s:iterator>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<td>${area}</td>
			<td>${registrnum}</td>
			<td>${chupersonnum}</td>
			<td>${fusainum}</td> 
			<td>
			<c:if test="${chupersonnum eq null or fusainum eq null or chupersonnum == '0'}">0</c:if>
			<c:if test="${!(chupersonnum eq null or fusainum eq null or chupersonnum == '0')}">
				<fmt:formatNumber type="number" value="${fusainum/chupersonnum*100}" maxFractionDigits="2"/>
			</c:if>%
			</td>
			<td>${chuschoolnum}</td>
	    	<c:forEach  items="${allJinsaiDateVO}" var = "datavo">
						<td><c:if test="${datavo.chuValue eq null}">0</c:if><c:if test="${datavo.chuValue ne null}">${datavo.chuValue}</c:if></td>
						<td><c:if test="${datavo.fuValue eq null}">0</c:if><c:if test="${datavo.fuValue ne null}">${datavo.fuValue}</c:if></td> 
		    </c:forEach>
		</tr>
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