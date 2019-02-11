<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<%
response.addHeader("Access-Control-Allow-Origin", "www.zjzx.ah.cn");  
response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");  
response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With"); 
%>
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
        url: "jinsaistudentcount!isFinishExportNew.action",
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

function diqutongji(){
	$.ajax({    
	    url:'${ctx}/count/manage/jinsaistudentcount!diqutongji.action',  
	    type:'post',    
	    dataType:'json',    
	    success:function(data) {
	        if(data.value =="true" ){   
		       	alert(data.label);
	        }else {
	        	alert(data.label); 
		    }  
	     },    
	     error:function() {    
	          alert("异常！");    
	     }    
	});
}
function schooltongji(){
	$.ajax({    
	    url:'${ctx}/count/manage/jinsaistudentcount!schooltongji.action',  
	    type:'post',    
	    dataType:'json',    
	    success:function(data) {
	        if(data.value =="true" ){   
		       	alert(data.label);
	        }else {
	        	alert(data.label); 
		    }  
	     },    
	     error:function() {    
	          alert("异常！");    
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
	<jsp:param value="studentcount" name="menu" />
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
<li class="active">个人竞赛统计</li>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/jinsaistudentcount.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>

<div class="form-group">

<s:if test="filter==2">
	<div class="form-group">
	<label>地区</label>
	<input name="area" class="form-control input-sm" value="${area}"/>
	</div>
	<div class="form-group">
	<label>学校</label>
	<input name="schoolname" class="form-control input-sm" value="${schoolname}"/>
	</div>
</s:if>
<s:if test="filter==1">
	<div class="form-group">
	<label>学校</label>
	<input name="schoolname" class="form-control input-sm" value="${schoolname}"/>
	</div>
</s:if>

<div class="form-group">
<label>身份证ID</label>
<input name="idcardnum" class="form-control input-sm" value="${idcardnum}"/>
</div>

<label>姓名</label>
<input name="name" type="text" class="form-control input-sm"
				value="${name}"/>
</div>

<div class="form-group">
<label>年级</label>
<input name="grade" class="form-control input-sm" value="${grade}"/>
</div>

<div class="form-group">
<label>班级</label>
<input name="clazz" class="form-control input-sm" value="${clazz}"/>
</div>


<div class="form-group">
	<label>所属项目</label>
	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" 
			headerKey="" cssClass="form-control" name="programesId" onChange="changeProgrames();"></s:select>
</div>

<div class="form-group">
<label>参赛组别</label>
    <select  id="clazzLists" class="form-control input-sm" name="groupname"> 
	</select>
</div>

<div class="form-group">
<label>是否晋级</label>
 <s:select list="#{'1':'晋级','0':'未晋级'}" listKey="key" listValue="value" name="isjinji" theme="simple" headerValue="--全部--" headerKey=""  cssClass="form-control input-sm" ></s:select>
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div><!--
			<div class="form-group">
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.mainForm.submit();">
			<span class="glyphicon glyphicon-export"></span>
			 导出
			</button>
			</div>
--><!--<div class="form-group">
<button class="btn btn-primary btn-sm" type="button"  onclick="diqutongji();">
<span class="glyphicon glyphicon-bullhorn"></span>
地区统计
</button>
<button class="btn btn-primary btn-sm" type="button"  onclick="schooltongji();">
<span class="glyphicon glyphicon-bullhorn"></span>
学校统计
</button> 
</div>
--></div>
</form>
<form name="deleteForm" id="deleteForm" action="course.action" method="post">
 <div class="panel panel-default  mt10 mb10" >
 <s:if test="filter!=1">
 	<div class="btn-toolbar dr-btn-toolbar">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">个人竞赛导出excel文件下载</a>
				</label>
			    </span>
     </div>
 </s:if>
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>	
		<th width="5%">序号</th>
		<s:if test="filter==2">
			<th width="5%">地区</th>
		</s:if>
		<th width="5%">学校</th>
		<th width="5%">竞赛项目</th>
		<th width="5%">参赛组别</th>
		<th width="5%">年级</th>
		<th width="5%">班级</th>
		<th width="5%">姓名</th>
		<th width="6%">身份证号</th>
		<th width="5%">性别</th> 
		<th width="5%">手机号码</th>
		<th width="6%">初赛一测成绩</th>
		<th width="6%">测验时间</th>
		<th width="6%">初赛二测成绩</th>
		<th width="6%">测验时间</th>
		<th width="6%">初赛成绩</th>
		<th width="6%">初赛用时</th>
		<th width="5%">是否晋级</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<s:if test="filter==2">
				<td>${area}</td>
			</s:if>
			<td>${school}</td>
			<td><common:cut len="10" string="${compname}"></common:cut></td>
			<td>${groupname}</td>
			<td>${grade}</td>
			<td>${clazz}</td>
			<td>${name}</td>
			<td>${idcardnum}</td>
			<td>
			<s:if test='sex=="m"'>男</s:if>
			  <s:elseif test='sex=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${talephnum}</td>
			<td>
				<c:if test="${chuonescore eq null}">暂无成绩</c:if>
				<c:if test="${chuonescore ne null}">
					<fmt:formatNumber type="number" value="${chuonescore}" maxFractionDigits="0"/>
				</c:if>
			</td>
			<td><fmt:formatDate value="${onescoredate}" type="both" pattern="yyyy-MM-dd HH:mm:ss "/></td>
			<td>
				<c:if test="${chutwoscore eq null}">暂无成绩</c:if>
				<c:if test="${chutwoscore ne null}">
					<fmt:formatNumber type="number" value="${chutwoscore}" maxFractionDigits="0"/>
				</c:if>
			</td>
			<td><fmt:formatDate value="${twoscoredate}" type="both" pattern="yyyy-MM-dd HH:mm:ss "/></td>
			<td>
				<c:if test="${chugrade eq null}">暂无成绩</c:if>
				<c:if test="${chugrade ne null}">
					<fmt:formatNumber type="number" value="${chugrade}" maxFractionDigits="0"/>
				</c:if>
			</td>
			<td>${chutimeStr }</td>
			<td>
			      <s:if test='hege'>是</s:if>
				  <s:else>否</s:else>
			</td>
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
<script type="text/javascript">  
changeProgrames();
function changeProgrames(){
	var programesId = $("#programesId").val();
	if(programesId) {
		$.post("${ctx}/count/manage/jinsaistudentcount!getClazzLists.excsec",{"programesId":programesId},function(data) {
			$("#clazzLists").html("<option  cid=\"-1\" value='' selected style='color:#999;'>--全部--</option>");
			var practiceUnit = eval(data);
			if(practiceUnit.length == 0) $("#areaid option[value!='']").remove();
			for(var i = 0 ;i < practiceUnit.length ; i++) {
				 if("${groupname}"==practiceUnit[i].value){
					    $("#clazzLists").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				 }else{
					    $("#clazzLists").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				}
			}
		});
	}
	
}
</script>
</body>
</html>