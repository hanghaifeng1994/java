<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<script type="text/javascript">
function jumpToPersonClazz(clazzId,statu){
	$("#clazzId").val(clazzId);
	if(statu!=null){
		$("#statu").val(statu);
	}else{
		$("#statu").val("");
	}
	$("#mainForm3").submit();
}
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
   		if(${export}){
		   $('#exportbut').hide();
		   checkover();
	    }
    }); 
    
    function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
	
	function changecity(){				
		var cityId = $("#cityId").val();
		if(cityId) {
			$.post("${ctx}/count/manage/studentcount!getAreaJson.excsec",{"cityId":cityId},function(data) {
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
	function changeprogram(){				
		var programesId = $("#programesId").val();
		if(programesId) {
			$.post("${ctx}/count/manage/clazzcountclazz!getPhases.excsec",{"programesId":programesId},function(data) {
				$("#phaseId option[value!='0']").remove();
				var practiceUnit = eval(data);
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${phaseId}"==practiceUnit[i].value){
						    $("#phaseId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else if(i==0){
						 $("#phaseId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else{
					 	 $("#phaseId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }
				}
			});
		}else{
			$("#phaseId option[value!='0']").remove();
		}
	}
	function changeTenant(){				
		var tenantId = $("#tenantId").val();
		if(tenantId) {
			$.post("${ctx}/count/manage/studentphasecount!getPrograms.excsec",{"tenantId":tenantId},function(data) {
				$("#programesId option[value!='']").remove();
				$("#phaseId option[value!='']").remove();
				var practiceUnit = eval(data);
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${programesId}"==practiceUnit[i].value){
						    $("#programesId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else{
						    $("#programesId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					}
				}
			});
		}
	}
	
	function changeItemCategory(){
		var categoryId = $("#categoryId").val();
		$.post("${ctx}/count/manage/clazzcountclazz!getProgramsByCategoryId.action",{"categoryId":categoryId},function(data) {
			$("#programesId option").remove();
			$("#phaseId option[value!='']").remove();
			var practiceUnit = eval(data);
			for(var i = 0 ;i < practiceUnit.length ; i++) {
				 if("${programesId}"==practiceUnit[i].value){
					    $("#programesId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				 }else{
					    $("#programesId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				}
			}
			changeprogram();
		});
		
	}
	function checkover(){
		$.ajax({
	        type: "POST",
	        url: "${ctx}/count/manage/clazzcountclazz!isFinishExport.action",
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
	<jsp:param value="clazzcountclazz" name="menu" />
	<jsp:param value="xueqing" name="bigmenu" />
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
<a href="#">学情统计</a>
</li>
<li class="active">班级学情</li>
</ol>

<div class="dr-page-header">
<h3>
班级学情统计
</h3>
</div>
<hr/>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/clazzcountclazz.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>

<!--<s:if test="currentTenant == null ">
	<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id" onchange="changeTenant()"
					id="tenantId"   value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
</s:if>-->
<div class="form-group">
	  	<label>项目分类</label>
	  	<s:select list="itemCategorys" onchange="changeItemCategory()" listKey="id" value="categoryId" id="categoryId" listValue="name" theme="simple"  cssClass="form-control" name="categoryId" headerValue="--全部--" headerKey=""></s:select>
</div>
<div class="form-group">
	  	<label>所属项目</label>
	  	<s:select list="programesLists" onchange="changeprogram()" listKey="id" value="programesId" id="programesId" listValue="name" theme="simple"  cssClass="form-control" name="programesId" headerValue="--所属项目--" headerKey=""></s:select>
</div>
<div class="form-group">
	  	<label>所属年度</label>
	  	<s:select list="phaseLists" listKey="id" value="phaseId" listValue="year" id="phaseId" theme="simple" headerValue="--全部--"
			headerKey="0" cssClass="form-control" name="phaseId"></s:select>
</div>
<div class="form-group">
	  	<label>所属城市</label>
	  	<s:select list="citysVLists" listKey="id" listValue="name" id="cityId" name="cityId" value="cityId" headerValue="--所属城市--" headerKey="" theme="simple" cssClass="form-control" ></s:select>
</div>
<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
		<!-- 	<div class="form-group">
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.mainForm.submit();$('#export').val('false');">
			<span class="glyphicon glyphicon-export"></span>
			 导出
			</button>
			</div> -->

</div>

</form>
<form name="deleteForm" id="deleteForm" action="${ctx}/count/manage/clazzcountclazz.action" method="post">
 <div class="panel panel-default  mt10 mb10" >
 	<div class="btn-toolbar dr-btn-toolbar">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">班级学情导出excel文件下载</a>
				</label>
			    </span>
	<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
		<span style="margin-left:30px;">班级数：<font style="color: #11B1CD;">${clazzcount}</font>&nbsp;&nbsp;|总人数：<font style="color: #11B1CD;">${qualitynum+noqualitynum}</font>&nbsp;&nbsp;|完成人数：<font style="color: #11B1CD;">${qualitynum}</font>&nbsp;&nbsp;|&nbsp;&nbsp;未完成人数：<font style="color: #11B1CD;">${noqualitynum}（其中待考人数：${daikaonum}）</font></span>
	</s:if>
	<s:else>
		<span style="margin-left:30px;">班级数：<font style="color: #11B1CD;">${clazzcount}</font>&nbsp;&nbsp;|总人数：<font style="color: #11B1CD;">${qualitynum+noqualitynum}</font>&nbsp;&nbsp;|合格人数：<font style="color: #11B1CD;">${qualitynum}</font>&nbsp;&nbsp;|&nbsp;&nbsp;不合格人数：<font style="color: #11B1CD;">${noqualitynum}（其中待考人数：${daikaonum}）</font></span>
	</s:else>
     </div>
     
	

<table  class="table table-bordered dr-table-bordered"  > 
	<tr>	
		<th width="5%">序号</th>
		<th width="8%">班级</th>
		<th width="5%">总人数</th>
		<th width="5%">完成人数</th>
		<th width="8%">未完成人数（含待考人数）</th>
		<th width="8%">待考人数</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<td><a href="#" onclick="jumpToPersonClazz('${id}');">${name}</a></td>
			<td><a href="#" onclick="jumpToPersonClazz('${id}');">${qualified+unqualified}</a></td>
			<td><a href="#" onclick="jumpToPersonClazz('${id}',1);">${qualified}</a></td>
			<td><a href="#" onclick="jumpToPersonClazz('${id}',0);">${unqualified}</a></td>
			<td><a href="#" onclick="jumpToPersonClazz('${id}',2);">${daikao}</a></td>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
<form id="mainForm3" name="mainForm3" action="${ctx}/count/manage/studentcountclazz.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="clazzId" id ="clazzId" />
	<input type="hidden" name="statu" id ="statu" />
</form>
</div>


<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>
</body>
</html>