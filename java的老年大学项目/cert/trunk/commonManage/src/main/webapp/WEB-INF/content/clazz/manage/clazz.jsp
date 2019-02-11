<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>班级列表-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();    
	   $("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
	   });

	   //验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action?ID=${id}";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
	   }); 

	   //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/clazz!delete.action?flag=${flag}&flag2=wxold";
			       if(!checkSelect()) {
			    	   b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			     //  if(!confirm('您确定要进行此操作吗?')) return  false;
	
				 //  $("#deleteForm").submit();
				 //  document.getElementById("deleteForm").action = oaction;
	   }); 	
				 
	   $("#batchEnableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!enable.action";
			       if(!checkSelect()) {
			    	   b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
			 }); 

	   $("#batchDisableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!disable.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
			 }); 
    });  
	function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
	function tst(){location.reload();}
	 
	 function selectTenant(id,programId){
		 b_IframeLevel("${ctx}/clazz/manage/clazz!selectsign.action?programId="+programId+"&id="+id,550,400,tst);
	}
</script>
</head>
<body>
  <!--adminHeader开始-->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
	</jsp:include>
  <!--adminHeader结束-->
  <div class="dr-wrapper">
   
    <section id="main" role="main"> 
      <div class="dr-container-fluid">
      <div class="dr-page-header">
      	<h3><label style="margin-right: 10px;">${programDTO.name}</label>项目管理 </h3>
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
<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
		<!-- 租户操作下发项目，不显示其他tab -->
		<s:if test="!(currentTenant!=null && programDTO.downType>0)">
        <li><a href="${ctx}/train/manage/programs!minput.action?id=${programId}">培训项目属性设置</a></li>
        <li><a style="cursor: pointer;" href="${ctx}/train/manage/phase.action?programId=${programId}&menu=menu">项目阶段</a></li>
        <li><a style="cursor: pointer;" href="${ctx}/train/manage/teachcontent.action?programId=${programId}">教学内容设置</a></li>
        </s:if>
        <li class="active"><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>               
</div>

<div class="tab-content dr-tabs-panel">
<form id="mainForm" name="mainForm" action="clazz.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page.pageNo" id="pageNo"	value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input	type="hidden" name="flag" id="order" value="${flag}" />
	<input type="hidden" name="programId" value="${programId }" id="hiddenprogramsid" />
	<input type="hidden" name="phaseId" value="${phaseId}" id="hiddenphaseId" />
	<input type="hidden" name="teachContentId" value="${teachContentId}" id="teachContentId"/>
	<div class="dr-searchbar">
	<div class="form-group">
        <label>班级名称</label>
        <input class="form-control input-sm" type="text"  name="name" value="${name}"/>
	</div>
	<div class="form-group">
        <label>班级代码</label>
        <input class="form-control input-sm" type="text" name="filter_LIKES_code" value="${param['filter_LIKES_code']}"/>
	</div>
	<div class="form-group">
            <label>状态</label>
            <s:checkboxlist name="state" list="#{'开 放':1,'未开始':0,'结 束':2}"
            	theme="simple" listKey="value" listValue="key" value="state">
            </s:checkboxlist>
	</div>
	
	<div class="form-group">
		<label>项目阶段</label>
			<s:select list="phaseList" listKey="id" cssClass="form-control input-sm"
				listValue="name"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_phase$id)"
				name="filter_EQL_phase$id" theme="simple"
				headerValue="--请选择项目阶段--" headerKey="" id="phaseId"></s:select>
		<label>教学内容</label>
			<s:select list="teachContentList" listKey="id" cssClass="form-control input-sm"
				listValue="name+'(第'+version+'版)'"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_teachContent$id)"
				name="filter_EQL_teachContent$id" theme="simple"
				headerValue="--请选择教学内容--" headerKey="" id="teachContentId"></s:select>	
		<label>班级类型</label>
            	<s:select list="#{'0':'自主班级','1':'集体班级','4':'单位集体班级'}" listKey="key" listValue="value" cssClass="form-control input-sm"
			    theme="simple" name="filter_EQI_model" headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_model)"
				headerValue="请选择班级类型"></s:select>	
	</div>
	
	<div class="form-group">
		<button class="btn btn-default btn-sm" type="submit">
			<span class="glyphicon glyphicon-search"></span>
 			搜索
		</button>
	</div>
</div>
</form>

<form name="deleteForm" id="deleteForm" action="clazz.action"method="post">
  <div class="panel panel-default">
    <div class="btn-toolbar dr-btn-toolbar">
      	 <button name="Submit2" type="button" class="btn btn-default btn-sm" id="batchDelDown" >
		<span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除</button>
    <button class="btn btn-primary btn-sm" type="button"
	onclick="window.location='clazz!input.action?flag=self&programId=${programId}&isdown=${isdown}'">
	<span class="glyphicon glyphicon-plus"></span>
	新增自主班级
	</button>
	
	<button class="btn btn-primary btn-sm" type="button"
	onclick="window.location='clazz!input.action?flag=group&programId=${programId}&isdown=${isdown}'">
	<span class="glyphicon glyphicon-plus"></span>
	新增集体班级
	</button>
    </div>

<table class="table table-bordered dr-table-default">
<thead>
	<tr>
		<th width="3%"><input type="checkbox" id="checkboxall" /></th>
		<th width="10%">班级名称<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="6%">班级代码<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="12%">培训项目<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="13%">项目阶段<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">班主任<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="8%">学员数<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="8%">班级类型<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="7%">班级状态<!--<i class="dr-sorting-desc"></i>--></th>
		<!--<s:if test="nowUser.super"><th width="15%">来自</th></s:if>
		-->
		<th width="25%">操作</th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td ><input type="checkbox" name="ids" value="${id}" /></td>
			<td >${name}</td>
			<td >${code}</td>
			<td >${programName}</td>
			<td >${phaseName}</td>
			<td ><s:if test="header==null">&nbsp;</s:if><s:property value="header.name"/></td>
			<td >${studentCount }</td>
			<td >${modelString}</td>			
			<td >${stateStr}</td>
			<!--<s:if test="nowUser.super"><td >${tenant.name}</td></s:if>
			-->
			<td>
			<s:if test="model==1">
				<s:if test="mspushId!=null&&mspushId!=''">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('${ctx}/mspush/manage/mspush!tosendhome.action?id=${mspushId}')">
				<span class="glyphicon glyphicon-send"></span>&nbsp;发送短信
				</button> 
				</s:if><s:else>
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('${ctx}/mspush/manage/mspush!sendClassStudent.action?clazzId=${Id}')">
				<span class="glyphicon glyphicon-envelope"></span>&nbsp;发送短信
				</button> 
				</s:else>
				
			</s:if>
			<s:if test="validate_status==3">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('clazz!minfo.action?id=${id}<s:if test="model==1">&flag=group</s:if>')">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;管理
				</button>
			</s:if>
			<s:elseif test="!cityLevel">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('clazz!input.action?id=${id}&programId=${programId}<s:if test="model==1">&flag=group</s:if>&randomtemp=${randomNo}&isdown=${isdown}')">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;继续建班
				</button>
				<!--<a target="_blank" href="clazz!input.action?id=${id}&programId=${programId}&flag=group&randomtemp=${randomNo}&isdown=${isdown}">
				<button class="btn btn-default btn-sm" type="button">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;继续建班
				</button>
				</a>
			-->
			</s:elseif>
			<c:if test="${fn:contains(currentTenant.contents,'english')}">
			<button class="btn btn-primary btn-sm" type="button" onclick="selectTenant(${id},${programId})">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;报名设置
				</button>
			</c:if>
			<a href="#"onclick="delRecord('${ctx }/clazz/manage/clazz!delete.action?ids=${id}&programId=${programId}<s:if test='model==1'>&flag=group</s:if>');">
			<button class="btn btn-default btn-sm" type="button">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
			</button>
			</a>
			<s:if test="#request.iswxeduopen=='true'">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('${ctx }/question/manage/onlinequestion.action?objectId=${id}&type=1')">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;在线提问管理
				</button>
			</s:if>
			</td>
		</tr>
	</s:iterator>
  </tbody>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</div>
</div>
</section>

<!--footer start-->
   	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
   	<jsp:param value="index" name="menu"/>
   	</jsp:include>
<!--footer over-->

</body>
</html>